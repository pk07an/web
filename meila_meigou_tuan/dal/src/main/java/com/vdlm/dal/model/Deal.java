package com.vdlm.dal.model;

import java.math.BigDecimal;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.DealStatus;
import com.vdlm.dal.type.DealType;

public class Deal extends BaseEntityImpl {
	
	private static final long serialVersionUID = 1L;
	
	private String dealNo;
	
	private String orderId;
	
	private String withdrawId;
	
	private String payDealNo;

	private DealType dealType;

	private String accountFrom;

	private String accountTo;

	private BigDecimal fee;

	private DealStatus status;

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}
	
	public String getPayDealNo() {
		return payDealNo;
	}

	public void setPayDealNo(String payDealNo) {
		this.payDealNo = payDealNo;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getWithdrawId() {
		return withdrawId;
	}

	public void setWithdrawId(String withdrawId) {
		this.withdrawId = withdrawId;
	}

	public DealType getDealType() {
		return dealType;
	}

	public void setDealType(DealType dealType) {
		this.dealType = dealType;
	}

	public String getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}

	public String getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
	}
	
	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public DealStatus getStatus() {
		return status;
	}

	public void setStatus(DealStatus status) {
		this.status = status;
	}
	
}
