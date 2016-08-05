package com.vdlm.dal.model;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;

public class CartItem extends BaseEntityImpl implements Archivable {
	
	private static final long serialVersionUID = 1L;
	
	private String userId;

	private String skuId;

    private String productId;
    
    private String shopId;
    
    private String sellerId;
    
    private Integer amount;
    
    private String status;

	private Boolean archive;
	
	private String domain; // xiangqu, kkkd
	
	private String source; // wap, web
	
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}