package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class Fragment extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	
	private String shopId;
	private String name;
	private String description;
	private Integer idx;
	private Boolean showModel;//true,文字靠前，false图片靠前
	private String code;

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Boolean getShowModel() {
		return showModel;
	}

	public void setShowModel(Boolean showModel) {
		this.showModel = showModel;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
