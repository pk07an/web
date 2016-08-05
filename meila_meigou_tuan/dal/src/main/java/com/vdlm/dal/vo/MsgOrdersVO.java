package com.vdlm.dal.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vdlm.dal.util.json.JsonResourceUrlSerializer;



public class MsgOrdersVO {
	
	private String orderId;

	private String buyerId;
	
	private String buyerNick;
	
	@JsonSerialize(using = JsonResourceUrlSerializer.class)
	private String productImg;

	private String lastMsgCont;
	
	private Date lastMsgTime;
	
	private Boolean hasRead;
	
	private String avatar;
	
	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerNick() {
		return buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getLastMsgCont() {
		return lastMsgCont;
	}

	public void setLastMsgCont(String lastMsgCont) {
		this.lastMsgCont = lastMsgCont;
	}

	public Date getLastMsgTime() {
		return lastMsgTime;
	}

	public void setLastMsgTime(Date lastMsgTime) {
		this.lastMsgTime = lastMsgTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Boolean getHasRead() {
		return hasRead;
	}

	public void setHasRead(Boolean hasRead) {
		this.hasRead = hasRead;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
