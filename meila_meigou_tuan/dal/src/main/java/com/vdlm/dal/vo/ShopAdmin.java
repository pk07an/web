package com.vdlm.dal.vo;

import com.vdlm.dal.model.Shop;

public class ShopAdmin extends Shop{

	private static final long serialVersionUID = 1L;

	private String phone;
	
	private String opRemark;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOpRemark() {
		return opRemark;
	}

	public void setOpRemark(String opRemark) {
		this.opRemark = opRemark;
	}
	
	
}
