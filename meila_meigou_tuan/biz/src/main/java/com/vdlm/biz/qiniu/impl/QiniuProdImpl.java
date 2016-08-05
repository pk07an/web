package com.vdlm.biz.qiniu.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.vdlm.config.ApplicationConfig;

@Component("qiniu")
@Profile(ApplicationConfig.PROFILE_NAME_PROD)
public class QiniuProdImpl extends QiniuNonProdImpl {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Value("${qiniu.product}")
	String qiniuProduct;

//	@Value("${qiniu.shop}")
//	String qiniuShop;
//	
//	@Value("${qiniu.stat}")
//	String qiniuStat;
//	
//	@Value("${qiniu.resource}")
//	String qiniuResource;
//	
//	@Value("${qiniu.log}")
//	String qiniuLog;
//
//	@Value("${qiniu.other}")
//	String qiniuOther;
	
	@Override
	protected synchronized void initMapQiniuBean() {
		if (mapQiniuBean != null)
			return;
		QiniuBean bean = null;
		mapQiniuBean = new HashMap<String, QiniuBean>();
		String[] products = qiniuProduct.split("\\|");
		try{
			bean = new QiniuBean("product", products[0], products[1], products[2],
					products[3]);
			mapQiniuBean.put(products[0], bean);
		}catch(Exception e){
			log.error("qiniuProduct" + qiniuProduct);
		}

//		String[] shops = qiniuShop.split("\\|");
//		bean = new QiniuBean("shop", shops[0], shops[1], shops[2], shops[3]);
//		mapQiniuBean.put(shops[0], bean);
//		
//		String[] stats = qiniuStat.split("\\|");
//		bean = new QiniuBean("stat", stats[0], stats[1], stats[2], stats[3]);
//		mapQiniuBean.put(stats[0], bean);
//		
//		String[] resources = qiniuResource.split("\\|");
//		bean = new QiniuBean("resource", resources[0], resources[1], resources[2], resources[3]);
//		mapQiniuBean.put(resources[0], bean);
//		
//		String[] logs = qiniuLog.split("\\|");
//		bean = new QiniuBean("log", logs[0], logs[1], logs[2], logs[3]);
//		mapQiniuBean.put(logs[0], bean);
//		
//		String[] others = qiniuOther.split("\\|");
//		bean = new QiniuBean("other", others[0], others[1], others[2], others[3]);
//		mapQiniuBean.put(others[0], bean);
	}
}
