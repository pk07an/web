package com.vdlm.dal.vo;

import com.vdlm.dal.model.promotion.PromotionProTag;
 
public class PromotionProTagVo extends PromotionProTag {

	private static final long serialVersionUID = 1L;
 
	private String shopName;
	private String productName;
	private String tagName;
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}	 

}
