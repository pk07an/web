package com.vdlm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.vdlm.service.Scanned;

@Configuration
@ComponentScan(basePackageClasses = Scanned.class)
@EnableTransactionManagement
@ImportResource({ "classpath:/META-INF/applicationContext-service-common.xml",
		"classpath:/META-INF/applicationContext-service.xml",
		"classpath:/META-INF/applicationContext-sync.xml" })
public class ServiceConfig {

	@Bean
	public RestOperations restTemplate() {
		RestTemplate ret = new RestTemplate();
		
		return ret;
	}
}