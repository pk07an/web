package com.vdlm.dal.model;

import com.vdlm.dal.type.PaymentMode;

public class PayBankWay extends PayBank {
	
	private static final long serialVersionUID = 1L;
	
	private String bankId;
	private String bankCode;
	private String cardType;
	private PaymentMode paymentMode;
	private String payWayStatus;

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPayWayStatus() {
		return payWayStatus;
	}

	public void setPayWayStatus(String payWayStatus) {
		this.payWayStatus = payWayStatus;
	}

}
