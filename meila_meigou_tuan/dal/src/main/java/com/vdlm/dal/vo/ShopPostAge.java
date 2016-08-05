package com.vdlm.dal.vo;

import java.math.BigDecimal;
import java.util.List;


public class ShopPostAge {
	
	private String shopId;
	/**
	 * 店铺邮费开关
	 */
	private Boolean postageStatus;
	/**
	 * 店铺全局邮费
	 */
	private BigDecimal postage;
	/**
	 * 指定包邮订单金额
	 */
	private BigDecimal freeShippingPrice;
	/**
	 * 指定包邮商品列表
	 */
	private List<String> freeShippingGoods;
	/**
	 * 自定义邮费地区设置
	 */
	private List<AreaPostagePair> customizedPostage;
	
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public BigDecimal getFreeShippingPrice() {
		return freeShippingPrice;
	}
	public void setFreeShippingPrice(BigDecimal freeShippingPrice) {
		this.freeShippingPrice = freeShippingPrice;
	}
	public List<String> getFreeShippingGoods() {
		return freeShippingGoods;
	}
	public void setFreeShippingGoods(List<String> freeShippingGoods) {
		this.freeShippingGoods = freeShippingGoods;
	}
	public List<AreaPostagePair> getCustomizedPostage() {
		return customizedPostage;
	}
	public void setCustomizedPostage(List<AreaPostagePair> customizedPostage) {
		this.customizedPostage = customizedPostage;
	}
	public Boolean getPostageStatus() {
		return postageStatus;
	}
	public void setPostageStatus(Boolean postageStatus) {
		this.postageStatus = postageStatus;
	}
	public BigDecimal getPostage() {
		return postage;
	}
	public void setPostage(BigDecimal postage) {
		this.postage = postage;
	}
	
}
