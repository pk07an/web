package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class ProductFragment extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	
	private String productId;
	private String fragmentId;
	private Integer idx;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getFragmentId() {
		return fragmentId;
	}

	public void setFragmentId(String fragmentId) {
		this.fragmentId = fragmentId;
	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

}
