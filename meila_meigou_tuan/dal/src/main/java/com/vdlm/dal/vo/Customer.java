package com.vdlm.dal.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Customer {
	private String buyerName;
	private String buyerPhone;
	private String wechat;
	private int orderCount; //数量
	private BigDecimal sumConsumption; //金额 
	private Date lastPaidAt;
	
	private String remark;
	private Boolean vip;
	private String zoneId;
	private String street;
	private String deliveryAddr;
	
	public String getDeliveryAddr() {
		return deliveryAddr;
	}

	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}
	
	
	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
	
	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public BigDecimal getSumConsumption() {
		return sumConsumption;
	}

	public void setSumConsumption(BigDecimal sumConsumption) {
		this.sumConsumption = sumConsumption;
	}
	
	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Date getLastPaidAt() {
		return lastPaidAt;
	}

	public void setLastPaidAt(Date lastPaidAt) {
		this.lastPaidAt = lastPaidAt;
	}
}
