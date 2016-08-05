package com.vdlm.biz.url;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlHelper {
	public static final String SHOP_URL_PREFIX = "/shop";
	public static final String UNION_SHOP_URL_PREFIX = "/unionShop";
	public static final String PRODUCT_URL_PREFIX = "/p";
	public static final String PRODUCT_URL_PREFIX_MEILA = "/ware";

	@Value("${site.web.host.name}")
	String siteHost;

	public String genShopUrl(String shopId) {
		return shopId == null ? null : siteHost + SHOP_URL_PREFIX + "/" + shopId;
	}

	public String genProductUrl(String prodId) {
		return prodId == null ? null : siteHost + PRODUCT_URL_PREFIX + "/" + prodId;
	}
	
	public String genProductUrlMeiLa(String prodCode) {
		return prodCode == null ? null : siteHost + PRODUCT_URL_PREFIX_MEILA + "/" + prodCode;
	}
}
