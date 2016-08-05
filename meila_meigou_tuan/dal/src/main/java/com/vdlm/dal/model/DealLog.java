package com.vdlm.dal.model;

import java.math.BigDecimal;

import com.vdlm.dal.BaseEntityImpl;

public class DealLog extends BaseEntityImpl {
	
	private static final long serialVersionUID = 1L;

	private String dealId;
	
	private String title;

	private String accountId;

	private BigDecimal fee;

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	
}
