package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class OrderAddress extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String orderId;// 订单ID
	private String zoneId; // 地区ID
	private String consignee;// 收货人
	private String street;//  详细地址
	private String phone;// 电话号码
	private String weixinId;// 微信号
	private String idCard; //身份证号
	
	public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getWeixinId() {
		return weixinId;
	}

	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}
}