package com.vdlm.dal.model;

import com.vdlm.dal.type.UserPartnerType;

public class Personnel {

	private String id;
	private String name;
	private UserPartnerType partner;
	private String extUserId;
	private String innerId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserPartnerType getPartner() {
		return partner;
	}

	public void setPartner(UserPartnerType partner) {
		this.partner = partner;
	}

	public String getExtUserId() {
		return extUserId;
	}

	public void setExtUserId(String extUserId) {
		this.extUserId = extUserId;
	}

	public String getInnerId() {
		return innerId;
	}

	public void setInnerId(String innerId) {
		this.innerId = innerId;
	}

}
