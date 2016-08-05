package com.vdlm.dal.model.promotion;

import java.util.List;
import java.util.Set;

public class PromotionFeeData {

	private String skuId;

	private  Set<String> proIds;

	public PromotionFeeData(String skuId, Set<String> proIds) {
		super();
		this.skuId = skuId;
		this.proIds = proIds;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public Set<String> getProIds() {
		return proIds;
	}

	public void setProIds(Set<String> proIds) {
		this.proIds = proIds;
	}

}
