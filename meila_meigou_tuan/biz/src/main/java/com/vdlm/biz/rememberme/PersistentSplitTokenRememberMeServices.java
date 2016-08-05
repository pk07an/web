package com.vdlm.biz.rememberme;

import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.rememberme.CookieTheftException;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

/**
 *
 * @author:  chenxi
 *
 * Use this class instead of org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices
 * to fix the scenario that when a user sends 2 or more request very closely, spring remember me will throw CookieTheftException.
 *
 * Storing token with last token and current token, split by comma, for example,
 * 'ApaW/lL3Bl0nO9Rgy5ZNMw==,dXhFUzW/p4aHdm24QkeYwQ==', which can fix the problem described above.
 * When session is timeout, a user sends 2 request almost at the same time, let us say R1 and R2, they are carrying the same token at that time.
 * Think about the case R1 firstly go through the token comparison and update the token in database, and then R2 get the mismatch result,
 * in this case, we assume the server can accept the concurrency in a limit seconds, defined by concurrencySafeSeconds field, if the token R2
 * carries equals with the first half value of the token got from database, then R2 can also go through it.
 */

public class PersistentSplitTokenRememberMeServices extends AbstractRememberMeServices {

    private PersistentTokenRepository tokenRepository = new InMemoryTokenRepositoryImpl();
    private final SecureRandom random;

    public static final int DEFAULT_SERIES_LENGTH = 16;
    public static final int DEFAULT_TOKEN_LENGTH = 16;

    private int seriesLength = DEFAULT_SERIES_LENGTH;
    private int tokenLength = DEFAULT_TOKEN_LENGTH;

    private int concurrencySafeSeconds = 2;

    /**
     * @deprecated Use constructor injection
     */
    @Deprecated
    public PersistentSplitTokenRememberMeServices() {
        random = new SecureRandom();
    }

    public PersistentSplitTokenRememberMeServices(String key, UserDetailsService userDetailsService,
                                                  PersistentTokenRepository tokenRepository) {
        super(key, userDetailsService);
        random = new SecureRandom();
        this.tokenRepository = tokenRepository;
    }

    /**
     * Locates the presented cookie data in the token repository, using the series id.
     * If the data compares successfully with that in the persistent store, a new token is generated and stored with
     * the same series. The corresponding cookie value is set on the response.
     *
     * @param cookieTokens the series and token values
     *
     * @throws RememberMeAuthenticationException if there is no stored token corresponding to the submitted cookie, or
     * if the token in the persistent store has expired.
     * @throws InvalidCookieException if the cookie doesn't have two tokens as expected.
     * @throws CookieTheftException if a presented series value is found, but the stored token is different from the
     * one presented.
     */
    @Override
    protected UserDetails processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request, HttpServletResponse response) {

        if (cookieTokens.length != 2) {
            throw new InvalidCookieException("Cookie token did not contain " + 2 +
                    " tokens, but contained '" + Arrays.asList(cookieTokens) + "'");
        }

        final String presentedSeries = cookieTokens[0];
        final String presentedToken = cookieTokens[1];

        PersistentRememberMeToken token = tokenRepository.getTokenForSeries(presentedSeries);

        if (token == null) {
            // No series match, so we can't authenticate using this cookie
            throw new RememberMeAuthenticationException("No persistent token found for series id: " + presentedSeries);
        }

        // We have a match for this user/series combination
        String[] tokens = token.getTokenValue().split(",");
        if (!presentedToken.equals(tokens[1])) {
            long reqInterval = System.currentTimeMillis() - token.getDate().getTime();
            if (presentedToken.equals(tokens[0]) && reqInterval < concurrencySafeSeconds * 1000) {
                // no-op, log the time interval
                logger.info("successive requests in safe time interval: " + reqInterval + "ms");
            }
            else {
                // Token doesn't match series value. Delete all logins for this user and throw an exception to warn them.
                if (presentedToken.equals(tokens[0])) {
                    logger.warn("successive requests exceed safe time interval: " + reqInterval + "ms");
                } else {
                    logger.warn("sent token does not match last token in db");
                }

                tokenRepository.removeUserTokens(token.getUsername());

                throw new CookieTheftException(messages.getMessage("PersistentSplitTokenRememberMeServices.cookieStolen",
                        "Invalid remember-me token (Series/token) mismatch. Implies previous cookie theft attack."));
            }
        }

        if (token.getDate().getTime() + getTokenValiditySeconds()*1000L < System.currentTimeMillis()) {
            throw new RememberMeAuthenticationException("Remember-me login has expired");
        }

        // Token also matches, so login is valid. Update the token value, keeping the *same* series number.
        if (logger.isDebugEnabled()) {
            logger.debug("Refreshing persistent login token for user '" + token.getUsername() + "', series '" +
                    token.getSeries() + "'");
        }

        PersistentRememberMeToken newToken = new PersistentRememberMeToken(token.getUsername(),
                token.getSeries(), tokens[1] + "," + generateTokenData(), new Date());

        try {
            tokenRepository.updateToken(newToken.getSeries(), newToken.getTokenValue(), newToken.getDate());
            addCookie(newToken, request, response);
        } catch (DataAccessException e) {
            logger.error("Failed to update token: ", e);
            throw new RememberMeAuthenticationException("Autologin failed due to data access problem");
        }

        return getUserDetailsService().loadUserByUsername(token.getUsername());
    }

    /**
     * Creates a new persistent login token with a new series number, stores the data in the
     * persistent token repository and adds the corresponding cookie to the response.
     *
     */
    @Override
    protected void onLoginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication successfulAuthentication) {
        String username = successfulAuthentication.getName();

        logger.debug("Creating new persistent login for user " + username);

        PersistentRememberMeToken persistentToken = new PersistentRememberMeToken(username, generateSeriesData(),
                "new," + generateTokenData(), new Date());
        try {
            tokenRepository.createNewToken(persistentToken);
            addCookie(persistentToken, request, response);
        } catch (DataAccessException e) {
            logger.error("Failed to save persistent token ", e);
        }
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        super.logout(request, response, authentication);

        if (authentication != null) {
            tokenRepository.removeUserTokens(authentication.getName());
        }
    }

    protected String generateSeriesData() {
        byte[] newSeries = new byte[seriesLength];
        random.nextBytes(newSeries);
        return new String(Base64.encode(newSeries));
    }

    protected String generateTokenData() {
        byte[] newToken = new byte[tokenLength];
        random.nextBytes(newToken);
        return new String(Base64.encode(newToken));
    }

    private void addCookie(PersistentRememberMeToken token, HttpServletRequest request, HttpServletResponse response) {
        String currentToken = token.getTokenValue().split(",")[1];
        setCookie(new String[] {token.getSeries(), currentToken}, getTokenValiditySeconds(), request, response);
    }

    /**
     * @deprecated Use constructor injection
     */
    @Deprecated
    public void setTokenRepository(PersistentTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public void setSeriesLength(int seriesLength) {
        this.seriesLength = seriesLength;
    }

    public void setTokenLength(int tokenLength) {
        this.tokenLength = tokenLength;
    }

    public void setConcurrencySafeSeconds(int concurrencySafeSeconds) {
        this.concurrencySafeSeconds = concurrencySafeSeconds;
    }

    @Override
    public void setTokenValiditySeconds(int tokenValiditySeconds) {
        Assert.isTrue(tokenValiditySeconds > 0, "tokenValiditySeconds must be positive for this implementation");
        super.setTokenValiditySeconds(tokenValiditySeconds);
    }

    @Override
    protected void setCookie(String[] tokens, int maxAge, HttpServletRequest request, HttpServletResponse response) {
        String cookieValue = encodeCookie(tokens);
        Cookie cookie = new Cookie(this.getCookieName(), cookieValue);
        cookie.setMaxAge(maxAge);

        // 把authToken写到根下面
        cookie.setPath("/");

        cookie.setSecure(request.isSecure());

        Method setHttpOnlyMethod = ReflectionUtils.findMethod(Cookie.class,"setHttpOnly", boolean.class);
        if(setHttpOnlyMethod != null) {
            ReflectionUtils.invokeMethod(setHttpOnlyMethod, cookie, Boolean.TRUE);
        } else if (logger.isDebugEnabled()) {
            logger.debug("Note: Cookie will not be marked as HttpOnly because you are not using Servlet 3.0 (Cookie#setHttpOnly(boolean) was not found).");
        }

        response.addCookie(cookie);
    }

    /**
     * 先取cookie，没有则尝试从req param里获取
     */
    @Override
    protected String extractRememberMeCookie(HttpServletRequest request) {
        String ret = super.extractRememberMeCookie(request);
        if (StringUtils.hasText(ret)) {
            return ret;
        }
        return request.getParameter(getCookieName());
    }
}
