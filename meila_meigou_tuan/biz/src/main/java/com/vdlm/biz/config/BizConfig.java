package com.vdlm.biz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.vdlm.biz.Scanned;

@Configuration
@ComponentScan(basePackageClasses = Scanned.class)
@ImportResource("classpath:META-INF/applicationContext-biz.xml")
public class BizConfig {
}
