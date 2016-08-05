package com.vdlm.dal.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext context;// 声明一个静态变量保存

	@Override
	public void setApplicationContext(ApplicationContext contex) throws BeansException {
		context = contex;
	}

	public static ApplicationContext getContext() {
		return context;
	}
	
	/**
	 * 直接获取bean
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName){
		return context.getBean(beanName);
	}
	
	public static <T> T getBean(Class<T> requiredType){
		return context.getBean(requiredType);
	}
}

