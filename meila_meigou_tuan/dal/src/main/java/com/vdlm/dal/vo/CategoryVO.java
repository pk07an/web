package com.vdlm.dal.vo;

import java.io.Serializable;

public class CategoryVO implements Serializable {
	private String id;
	private String name;
	private Long productCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProductCount() {
		return productCount;
	}

	public void setProductCount(Long productCount) {
		this.productCount = productCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
