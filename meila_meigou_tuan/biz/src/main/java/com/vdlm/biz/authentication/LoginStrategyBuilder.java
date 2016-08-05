package com.vdlm.biz.authentication;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vdlm.dal.util.SpringContextUtil;

/**
 *
 * @author:  chenxi
 *
 * This class is used for building an instance of LoginStrategy from login-strageties.xml, only support
 * simple, customized-class and customized-ref types now. a typical configuration file is as follow:
 * <?xml version="1.0" encoding="utf-8"?>
 * <login-strategies>
 *    <!-- 	<default type="customized-ref" strategy="defaultBeanName" /> -->
 *    <domains>
 *      <domain name="simple.ixiaopu.com" type="simple" url="/test" />
 *      <domain name="customized.ixiaopu.com" type="customized-class" stragety="com.vdlm.authentication.CustomizedLoginStrategy" />
 *      <domain name="xiangqu.ixiaopu.com" type="customized-class" stragety="com.vdlm.authentication.XiangquLoginStrategy" />
 *      <domain name="spring.ixiaopu.com" type="customized-ref" stragety="springStrategy" />
 *    </domains>
 * </login-strategies>
 */
public class LoginStrategyBuilder {
    // element
    private static String ROOT_EL = "login-strategies";
    private static String DOMAINS_EL = "domains";
    private static String DOMAIN_EL = "domain";
    private static String DEFAULT_EL = "default";

    // attribute
    private static String NAME_ATTR = "name";
    private static String TYPE_ATTR = "type";
    private static String URL_ATTR = "url";
    private static String STRAGETY_ATTR = "strategy";

    // specified value
    private static String SIMPLE_TYPE = "simple";
    private static String CUSTOMIZED_CLASS_TYPE = "customized-class";
    private static String CUSTOMIZED_REF_TYPE = "customized-ref";

    private final static Logger LOG = LoggerFactory.getLogger(LoginStrategyBuilder.class);

    private final SAXBuilder builder;
    
    public LoginStrategyBuilder() {
        builder = new SAXBuilder();
    }

    public LoginStrategy build(String resource) throws LoginConfigurationException {
        Document doc;
        InputStream in = null;
        try {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
            doc = builder.build(in);
            final Element root = doc.getRootElement();
            if (root == null || !ROOT_EL.equals(root.getName())) {
                throw new LoginConfigurationException("invalid root element, it must be named " + ROOT_EL);
            }

            final LoginStrategyProxy strategy = new LoginStrategyProxy();
            // build default strategy
            buildDefault(strategy, root);
            // build domains
            buildDomains(strategy, root);

            return strategy;
        } catch (final Exception e) {
            throw new LoginConfigurationException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (final IOException e) {
                    throw new LoginConfigurationException(e);
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    private void buildDefault(LoginStrategyProxy proxy, Element root) throws LoginConfigurationException {
    	final List<Element> defaultEls = root.getChildren(DEFAULT_EL);
    	if (defaultEls == null || defaultEls.size() == 0) {
            LOG.info("no default element defined!");
            return;
        }
    	if (defaultEls.size() > 1) {
    		throw new LoginConfigurationException("there are more than 1 default element defined!");
    	} else if (defaultEls.size() == 1) {
    		final String type = defaultEls.get(0).getAttributeValue(TYPE_ATTR);
    		if (!(CUSTOMIZED_CLASS_TYPE.equals(type) || CUSTOMIZED_REF_TYPE.equals(type))) {
                throw new LoginConfigurationException("default type must be customized-class or customized-ref!");
            }
    		final String strategy = defaultEls.get(0).getAttributeValue(STRAGETY_ATTR);
    		if (CUSTOMIZED_CLASS_TYPE.equals(type)) {
                if (strategy == null) {
                    throw new LoginConfigurationException("domain with customized type must specify the strategy attribute!");
                }
                proxy.registerCustomized(strategy);
            }
            if (CUSTOMIZED_REF_TYPE.equals(type)) {
                if (strategy == null) {
                    throw new LoginConfigurationException("domain with customized type must specify the strategy attribute!");
                }
                proxy.registerCustomized((LoginStrategy) SpringContextUtil.getBean(strategy));
            }
    	}
    }

    @SuppressWarnings("unchecked")
    private void buildDomains(LoginStrategyProxy proxy, Element root) throws LoginConfigurationException {
    	final List<Element> domains = root.getChildren(DOMAINS_EL);
    	if (domains == null || domains.size() == 0) {
            LOG.warn("no domain defined!");
            return;
        }
    	if (domains.size() > 1) {
    		throw new LoginConfigurationException("there are more than 1 domains element defined!");
    	}
    	
        final List<Element> children = domains.get(0).getChildren(DOMAIN_EL);
        if (children == null || children.size() == 0) {
            LOG.warn("no domain defined!");
            return;
        }

        String name;
        String type;
        String url;
        String strategy;
        for (final Element child : children) {
            name = child.getAttributeValue(NAME_ATTR);
            if (name == null) {
                throw new LoginConfigurationException("no name attribute specified!");
            }
            type = child.getAttributeValue(TYPE_ATTR);
            if (type == null) {
                throw new LoginConfigurationException("no type attribute specified!");
            }
            if (!(SIMPLE_TYPE.equals(type) || CUSTOMIZED_CLASS_TYPE.equals(type)
                    || CUSTOMIZED_REF_TYPE.equals(type))) {
                throw new LoginConfigurationException("type must be simple or customized-class or customized-ref!");
            }
            url = child.getAttributeValue(URL_ATTR);
            strategy = child.getAttributeValue(STRAGETY_ATTR);
            if (SIMPLE_TYPE.equals(type)) {
                if (url == null) {
                    throw new LoginConfigurationException("domain with simple type must specify the url attribute!");
                }
                proxy.registerSimple(name, url);
            }
            if (CUSTOMIZED_CLASS_TYPE.equals(type)) {
                if (strategy == null) {
                    throw new LoginConfigurationException("domain with customized type must specify the strategy attribute!");
                }
                proxy.registerCustomized(name, strategy);
            }
            if (CUSTOMIZED_REF_TYPE.equals(type)) {
                if (strategy == null) {
                    throw new LoginConfigurationException("domain with customized type must specify the strategy attribute!");
                }
                proxy.registerCustomized(name, (LoginStrategy) SpringContextUtil.getBean(strategy));
            }
        }
    }

}
