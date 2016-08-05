package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class PostAgeSet  extends BaseEntityImpl {
	private static final long serialVersionUID = 1L;
	
	private String shopId;
	
	private String postageSet;

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getPostageSet() {
		return postageSet;
	}

	public void setPostageSet(String postageSet) {
		this.postageSet = postageSet;
	}
	
}
