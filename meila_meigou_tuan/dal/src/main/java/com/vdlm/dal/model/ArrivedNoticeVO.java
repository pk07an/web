package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class ArrivedNoticeVO extends BaseEntityImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 预约买家id
	private String buyerId;
	// 卖家id
	private String sellerId;
	// 商铺id
	private String shopId;
	// 商品id
	private String productId;
	// 商品名称
	private String productName;
	//商品code
	private String productCode;
	// 逻辑删除标志
	private boolean archive;

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

}
