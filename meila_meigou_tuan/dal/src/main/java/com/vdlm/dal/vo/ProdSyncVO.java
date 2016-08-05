package com.vdlm.dal.vo;

import com.vdlm.dal.model.ProdSync;

public class ProdSyncVO extends ProdSync {
	
	private static final long serialVersionUID = 1L;

	private String shopUrl;
	
	private String commisionRate;

	public String getShopUrl() {
		return shopUrl;
	}

	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}

	public String getCommisionRate() {
		return commisionRate;
	}

	public void setCommisionRate(String commisionRate) {
		this.commisionRate = commisionRate;
	}
}
