package com.vdlm.biz.authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.PortMapper;
import org.springframework.security.web.PortMapperImpl;
import org.springframework.security.web.PortResolver;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.RedirectUrlBuilder;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * a more flexible class than spring LoginUrlAuthenticationEntryPoint class, which support continuous handling after authentication
 * 
 * @author: chenxi
 */

public class LoginUrlEntryPoint implements AuthenticationEntryPoint, InitializingBean {
	
	private static final String CONTINUE_PREFIX = "continue:";
	
    //~ Static fields/initializers =====================================================================================

    private static final Log logger = LogFactory.getLog(LoginUrlAuthenticationEntryPoint.class);

    //~ Instance fields ================================================================================================

    private PortMapper portMapper = new PortMapperImpl();

    private PortResolver portResolver = new PortResolverImpl();

    private String loginFormUrl;

    private boolean forceHttps = false;

    private boolean useForward = false;

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     *
     * @param loginFormUrl URL where the login page can be found. Should either be relative to the web-app context path
     * (include a leading {@code /}) or an absolute URL.
     */
    public LoginUrlEntryPoint(String loginFormUrl) {
        this.loginFormUrl = loginFormUrl;
    }

    //~ Methods ========================================================================================================

    @Override
	public void afterPropertiesSet() throws Exception {
        Assert.isTrue(StringUtils.hasText(loginFormUrl) && UrlUtils.isValidRedirectUrl(loginFormUrl),
                "loginFormUrl must be specified and must be a valid redirect URL");
        if (useForward && UrlUtils.isAbsoluteUrl(loginFormUrl)) {
            throw new IllegalArgumentException("useForward must be false if using an absolute loginFormURL");
        }
        Assert.notNull(portMapper, "portMapper must be specified");
        Assert.notNull(portResolver, "portResolver must be specified");
    }

    /**
     * Allows subclasses to modify the login form URL that should be applicable for a given request.
     *
     * @param request   the request
     * @param response  the response
     * @param exception the exception
     * @return the URL (cannot be null or empty; defaults to {@link #getLoginFormUrl()})
     */
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) {

        return getLoginFormUrl();
    }

    /**
     * Performs the redirect (or forward) to the login form URL.
     */
    @Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        String redirectUrl = null;

        if (useForward) {

            if (forceHttps && "http".equals(request.getScheme())) {
                // First redirect the current request to HTTPS.
                // When that request is received, the forward to the login page will be used.
                redirectUrl = buildHttpsRedirectUrlForRequest(request);
            }

            if (redirectUrl == null) {
                final String loginForm = determineUrlToUseForThisRequest(request, response, authException);

                if (logger.isDebugEnabled()) {
                    logger.debug("Server side forward to: " + loginForm);
                }

                final RequestDispatcher dispatcher = request.getRequestDispatcher(loginForm);

                dispatcher.forward(request, response);

                return;
            }
        } else {
            // redirect to login page. Use https if forceHttps true

            redirectUrl = buildRedirectUrlToLoginPage(request, response, authException);

        }
        
        if (redirectUrl != null && redirectUrl.startsWith(CONTINUE_PREFIX)) {
        	 final RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl.substring(CONTINUE_PREFIX.length()));

             dispatcher.forward(request, response);

             return;
        }

        redirectStrategy.sendRedirect(request, response, redirectUrl);
    }

    protected String buildRedirectUrlToLoginPage(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) {

        final String loginForm = determineUrlToUseForThisRequest(request, response, authException);

        if (UrlUtils.isAbsoluteUrl(loginForm) || (loginForm != null && loginForm.startsWith(CONTINUE_PREFIX))) {
            return loginForm;
        }

        final int serverPort = portResolver.getServerPort(request);
        final String scheme = request.getScheme();

        final RedirectUrlBuilder urlBuilder = new RedirectUrlBuilder();

        urlBuilder.setScheme(scheme);
        urlBuilder.setServerName(request.getServerName());
        urlBuilder.setPort(serverPort);
        urlBuilder.setContextPath(request.getContextPath());
        urlBuilder.setPathInfo(loginForm);

        if (forceHttps && "http".equals(scheme)) {
            final Integer httpsPort = portMapper.lookupHttpsPort(Integer.valueOf(serverPort));

            if (httpsPort != null) {
                // Overwrite scheme and port in the redirect URL
                urlBuilder.setScheme("https");
                urlBuilder.setPort(httpsPort.intValue());
            } else {
                logger.warn("Unable to redirect to HTTPS as no port mapping found for HTTP port " + serverPort);
            }
        }

        return urlBuilder.getUrl();
    }

    /**
     * Builds a URL to redirect the supplied request to HTTPS. Used to redirect the current request
     * to HTTPS, before doing a forward to the login page.
     */
    protected String buildHttpsRedirectUrlForRequest(HttpServletRequest request)
            throws IOException, ServletException {

        final int serverPort = portResolver.getServerPort(request);
        final Integer httpsPort = portMapper.lookupHttpsPort(Integer.valueOf(serverPort));

        if (httpsPort != null) {
            final RedirectUrlBuilder urlBuilder = new RedirectUrlBuilder();
            urlBuilder.setScheme("https");
            urlBuilder.setServerName(request.getServerName());
            urlBuilder.setPort(httpsPort.intValue());
            urlBuilder.setContextPath(request.getContextPath());
            urlBuilder.setServletPath(request.getServletPath());
            urlBuilder.setPathInfo(request.getPathInfo());
            urlBuilder.setQuery(request.getQueryString());

            return urlBuilder.getUrl();
        }

        // Fall through to server-side forward with warning message
        logger.warn("Unable to redirect to HTTPS as no port mapping found for HTTP port " + serverPort);

        return null;
    }

    /**
     * Set to true to force login form access to be via https. If this value is true (the default is false),
     * and the incoming request for the protected resource which triggered the interceptor was not already
     * <code>https</code>, then the client will first be redirected to an https URL, even if <tt>serverSideRedirect</tt>
     * is set to <tt>true</tt>.
     */
    public void setForceHttps(boolean forceHttps) {
        this.forceHttps = forceHttps;
    }

    protected boolean isForceHttps() {
        return forceHttps;
    }

    /**
     * The URL where the <code>UsernamePasswordAuthenticationFilter</code> login
     * page can be found. Should either be relative to the web-app context path
     * (include a leading {@code /}) or an absolute URL.
     *
     * @deprecated use constructor injection
     */
    @Deprecated
    public void setLoginFormUrl(String loginFormUrl) {
        this.loginFormUrl = loginFormUrl;
    }

    public String getLoginFormUrl() {
        return loginFormUrl;
    }

    public void setPortMapper(PortMapper portMapper) {
        this.portMapper = portMapper;
    }

    protected PortMapper getPortMapper() {
        return portMapper;
    }

    public void setPortResolver(PortResolver portResolver) {
        this.portResolver = portResolver;
    }

    protected PortResolver getPortResolver() {
        return portResolver;
    }

    /**
     * Tells if we are to do a forward to the {@code loginFormUrl} using the {@code RequestDispatcher},
     * instead of a 302 redirect.
     *
     * @param useForward true if a forward to the login page should be used. Must be false (the default) if
     * {@code loginFormUrl} is set to an absolute value.
     */
    public void setUseForward(boolean useForward) {
        this.useForward = useForward;
    }

    protected boolean isUseForward() {
        return useForward;
    }
}
