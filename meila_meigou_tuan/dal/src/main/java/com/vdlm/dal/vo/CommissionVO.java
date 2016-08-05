package com.vdlm.dal.vo;

import com.vdlm.dal.model.Commission;
import com.vdlm.dal.type.UserPartnerType;

public class CommissionVO extends Commission {

	private static final long serialVersionUID = 1L;

	private String orderNo;
	private String orderStatus;
	private String productName;
	private String skuName;
	private String userName;
	private UserPartnerType partnerType;
	private String userPhone;

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public UserPartnerType getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(UserPartnerType partnerType) {
		this.partnerType = partnerType;
	}
}
