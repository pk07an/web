package com.vdlm.biz.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author:  chenxi
 *
 * The domain based login url authentication entry point class extending the spring LoginUrlAuthenticationEntryPoint
 * class, which uses builded LoginStrategy from login-strategies.xml file to determine the login page.
 *
 * support redirect/forward in same domain and redirect to a different domain.
 */

public class DomainBasedLoginUrlEntryPoint extends LoginUrlEntryPoint {

    private static final String DEFALUT_STRATEGY_FILE = "login-strategies.xml";

    private final LoginStrategy strategy;

    public DomainBasedLoginUrlEntryPoint(String loginFormUrl) throws LoginConfigurationException {
        super(loginFormUrl);
        strategy = new LoginStrategyBuilder().build(DEFALUT_STRATEGY_FILE);
    }

    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) {
        String url = strategy.buildLoginUrl(request, response, exception);
        if (url == null) {
            return getLoginFormUrl();
        }

        return url;
    }

}
