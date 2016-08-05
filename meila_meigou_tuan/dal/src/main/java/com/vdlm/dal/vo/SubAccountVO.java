package com.vdlm.dal.vo;

import com.vdlm.dal.model.SubAccount;

public class SubAccountVO extends SubAccount {

	private static final long serialVersionUID = 1L;
	
	private String userId;
	private int withdrawType;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getWithdrawType() {
		return withdrawType;
	}

	public void setWithdrawType(int withdrawType) {
		this.withdrawType = withdrawType;
	}

}
