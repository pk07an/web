package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class SubAccountSnapshot extends BaseEntityImpl{
    
	private static final long serialVersionUID = 1L;

	private String subAccountLogId;
	
    private String accountId; //冗余

    private String snapshot;

	public String getSubAccountLogId() {
		return subAccountLogId;
	}

	public void setSubAccountLogId(String subAccountLogId) {
		this.subAccountLogId = subAccountLogId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(String snapshot) {
		this.snapshot = snapshot;
	}

}