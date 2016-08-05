package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.type.PaymentMode;

public class Payment extends BaseEntityImpl {
	
	private static final long serialVersionUID = 1L;
	private PaymentMode type;
	private String name;
	private String img;
	private String description;
	private String payUrl;
	private Boolean archive;
	
	public PaymentMode getType() {
		return type;
	}
	public void setType(PaymentMode type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPayUrl() {
		return payUrl;
	}
	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

}
