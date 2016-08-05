package com.vdlm.web.view;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.thymeleaf.TemplateProcessingParameters;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.resourceresolver.IResourceResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolution;
import org.thymeleaf.util.StringUtils;
import org.thymeleaf.util.Validate;

/**
 * Support different templates for multiple domains, default domain is specified in config-*.properties file under vdlm-dal project.
 * You can configure the prefix for the other domain-based templates in viewprefix.properties under classpath, for example:
 *  kkkd.xiangqu.com=/WEB-INF/views-xq/
 *
 * Note: this template resolver will try searching the template file with same name in default prefix directory if it cannot find
 * the domain-based one.
 *
 * @author:  chenxi
 */

public class MultiDomainsTemplateResolver extends ServletContextTemplateResolver {

    private static final String VIEW_PREFIX_FILE = "viewprefix.properties";

    /**
     * default domain like '.xxx.yy' or 'www.xxx.yy'
     */
    private String defaultDomain;

    /**
     * load from viewprefix.properties
     */
    private final Properties prefixes = new Properties();

    public MultiDomainsTemplateResolver() {
        super();
        loadViewPrefixes();
    }

    private void loadViewPrefixes() {
        InputStream resource = Thread.currentThread()
                                     .getContextClassLoader()
                                     .getResourceAsStream(VIEW_PREFIX_FILE);
        try {
            prefixes.load(resource);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file from " + VIEW_PREFIX_FILE, e);
        }
    }

    @Override
    protected String computeResourceName(final TemplateProcessingParameters templateProcessingParameters) {
        /*
         * default try locating the domain-based template
         */
        return computeResourceName(templateProcessingParameters, false);
    }

    protected String computeResourceName(final TemplateProcessingParameters templateProcessingParameters, boolean useParent) {
        if (useParent) {
            //  use parent class to locate the template
            return super.computeResourceName(templateProcessingParameters);
        }

        // now try locating the domain-based template
        checkInitialized();
        final IContext context = templateProcessingParameters.getContext();
        if (!(context instanceof IWebContext)) {
            throw new TemplateProcessingException(
                    "Resource resolution by ServletContext with " +
                    this.getClass().getName() + " can only be performed " +
                    "when context implements " + IWebContext.class.getName() +
                    " [current context: " + context.getClass().getName() + "]");
        }

        final String host = ((IWebContext) context).getHttpServletRequest().getServerName();

        final String templateName = templateProcessingParameters.getTemplateName();

        Validate.notNull(templateName, "Template name cannot be null");

        String unaliasedName = getTemplateAliases().get(templateName);
        if (unaliasedName == null) {
            unaliasedName = templateName;
        }

        final StringBuilder resourceName = new StringBuilder();
        if (!StringUtils.isEmptyOrWhitespace(getPrefix())) {
            /*
             * if current host belongs to default domain, go to parent schema,
             * else, get prefix from prefixes fields
             */
            if (host.endsWith(defaultDomain)) {
                resourceName.append(getPrefix());
            } else {
                String prefix = prefixes.getProperty(host);
                if (prefix != null) {
                    resourceName.append(prefix);
                } else {
                    resourceName.append(getPrefix());
                }
            }
        }
        resourceName.append(unaliasedName);
        if (!StringUtils.isEmptyOrWhitespace(getSuffix())) {
            resourceName.append(getSuffix());
        }

        return resourceName.toString();
    }

    @Override
    public TemplateResolution resolveTemplate(final TemplateProcessingParameters templateProcessingParameters) {

        checkInitialized();

        Validate.notNull(templateProcessingParameters, "Template Processing Parameters cannot be null");

        if (!computeResolvable(templateProcessingParameters)) {
            return null;
        }

        IResourceResolver resourceResolver = computeResourceResolver(templateProcessingParameters);
        String resourceName = computeResourceName(templateProcessingParameters);
        InputStream templateInputStream =
                resourceResolver.getResourceAsStream(templateProcessingParameters, resourceName);
        // immediately locate default prefix directory when finding the template input stream is null
        // to reduce useless operations
        if (templateInputStream == null) {
            return new TemplateResolution(
                    templateProcessingParameters.getTemplateName(),
                    computeResourceName(templateProcessingParameters, true),
                    resourceResolver,
                    computeCharacterEncoding(templateProcessingParameters),
                    computeTemplateMode(templateProcessingParameters),
                    computeValidity(templateProcessingParameters));
        }

        // ok, now please enjoy the domain-based template
        return new TemplateResolution(
                templateProcessingParameters.getTemplateName(),
                resourceName,
                resourceResolver,
                computeCharacterEncoding(templateProcessingParameters),
                computeTemplateMode(templateProcessingParameters),
                computeValidity(templateProcessingParameters));

    }

    public String getDefaultDomain() {
        return defaultDomain;
    }

    public void setDefaultDomain(String defaultDomain) {
        this.defaultDomain = defaultDomain;
    }

}
