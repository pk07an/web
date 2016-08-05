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
 * A composite LoginStrategy class delegating the specified domain to an appropriate LoginStrategy instance,
 * which is constructed from login-strategies.xml by LoginStrategyBuilder class.
 */

public class DefaultLoginStrategy implements LoginStrategy {

    private SimpleMappingStrategy simpleStrategy;

    private final Map<String, LoginStrategy> createdStrategies = new HashMap<String, LoginStrategy>();
    private final Map<String, LoginStrategy> mappings = new HashMap<String, LoginStrategy>();

    @Override
    public String buildLoginUrl(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException exception) {
        String serverName = request.getServerName();
        LoginStrategy strategy = mappings.get(serverName);
        if (strategy == null) {
            return null;
        }

        return strategy.buildLoginUrl(request, response, exception);
    }

    void registerSimple(String domain, String url) throws LoginConfigurationException {
        if (mappings.containsKey(domain)) {
            throw new LoginConfigurationException("duplicated domain name: " + domain);
        }
        if (simpleStrategy == null) {
            simpleStrategy = new SimpleMappingStrategy();
        }

        simpleStrategy.registerMapping(domain, url);
        mappings.put(domain, simpleStrategy);
    }

    void registerCustomized(String domain, String strategyClass) throws LoginConfigurationException {
        if (mappings.containsKey(domain)) {
            throw new LoginConfigurationException("duplicated domain name: " + domain);
        }

        try {
            if (!createdStrategies.containsKey(strategyClass)) {
                Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(strategyClass);
                LoginStrategy strategy = (LoginStrategy) clazz.newInstance();
                mappings.put(domain, strategy);
                createdStrategies.put(strategyClass, strategy);
            } else {
                mappings.put(domain, createdStrategies.get(strategyClass));
            }
        } catch (Exception e) {
            throw new LoginConfigurationException(e);
        }
    }

    void registerCustomized(String domain, LoginStrategy strategy) throws LoginConfigurationException {
        if (mappings.containsKey(domain)) {
            throw new LoginConfigurationException("duplicated domain name: " + domain);
        }
        mappings.put(domain, strategy);
    }

}
