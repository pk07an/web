package com.vdlm.dal.model;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;

public class UserAlipay extends BaseEntityImpl implements Archivable {
	
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String account;
	private String name;
	private Boolean archive;
	
	@Override
	public Boolean getArchive() {
		return archive;
	}

	@Override
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
