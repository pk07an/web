package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class ProductTag extends BaseEntityImpl {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String shopId;

    private String productId;

    private String tagId;

    public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

    
}