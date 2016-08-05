package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class OrderMessage extends BaseEntityImpl {
    
    private static final long serialVersionUID = 2064574735033295355L;

    private String orderId;
    
    private String content;
    
    private String buyerId;
    
    private String sellerId;
    
    private String groupId;
    
    private String productId;
    
    private Boolean hasRead;
    
    private String uploadPic;
    
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
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
	public Boolean getHasRead() {
		return hasRead;
	}
	public void setHasRead(Boolean hasRead) {
		this.hasRead = hasRead;
	}
	public String getUploadPic(){
		return uploadPic;
	}
	public void setUploadPic(String uploadPic){
		this.uploadPic = uploadPic;
	}
	
}
