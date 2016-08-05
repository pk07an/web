package com.vdlm.biz.authentication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author:  chenxi
 *
 * The simple mapping strategy class for directly redirecting the login page to a static url.
 * You can configure the url for simple type in login-strageties.xml like this:
 *
 * <login-strategies>
 *   <domain name="xxx.yy.zzz" type="simple" strategy="/aaa/bbb" />
 * </login-strategies>
 */

public class SimpleMappingStrategy implements LoginStrategy {

    private final Map<String, String> mappings = new HashMap<String, String>();

    void registerMapping(String domain, String url) {
        mappings.put(domain, url);
    }

    @Override
    public String buildLoginUrl(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException exception) {
        String serverName = request.getServerName();
        return mappings.get(serverName);
    }

}
