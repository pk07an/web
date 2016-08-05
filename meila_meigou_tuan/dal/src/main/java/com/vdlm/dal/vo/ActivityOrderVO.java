package com.vdlm.dal.vo;

import com.vdlm.dal.model.ActivityOrder;

public class ActivityOrderVO extends ActivityOrder {

	private static final long serialVersionUID = 1L;
	
	private String sellerPhone;
	private String buyerPhone;

	public String getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
}
