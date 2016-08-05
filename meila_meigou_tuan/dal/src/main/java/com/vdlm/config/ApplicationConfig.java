package com.vdlm.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ApplicationConfig {

	private Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);

	/** 线上环境的profile名称 */
	public final static String PROFILE_NAME_PROD = "prod";

	/**
	 * dev profile
	 */
	@Profile("dev")
	@Bean(name = "propertyPlaceholderConfigurer")
	public PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurerDev() {
		PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("env/config-dev.properties"));
		LOG.warn("env/config-dev.properties loaded");
		return ppc;
	}

	@Profile("test")
	@Bean(name = "propertyPlaceholderConfigurer")
	public PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurerTest() {
		PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("env/config-test.properties"));
		LOG.warn("env/config-test.properties loaded");
		return ppc;
	}

	@Profile(PROFILE_NAME_PROD)
	@Bean(name = "propertyPlaceholderConfigurer")
	public PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurerProd() {
		PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("env/config-prod.properties"));
		LOG.warn("env/config-prod.properties loaded");
		return ppc;
	}
}