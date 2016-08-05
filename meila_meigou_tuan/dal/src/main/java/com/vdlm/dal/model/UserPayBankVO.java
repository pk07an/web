package com.vdlm.dal.model;

import com.vdlm.dal.type.PaymentMode;

/**
 * 用户协议支付银行列表
 * @author huxaya
 *
 */
public class UserPayBankVO {
	private String userId;
	private String aggreeId;
	private String bankImg;
	private String accountNum;
	private String bankCode;
	private String cardType;
	private String bankName;
	private PaymentMode payType;
	private String cardTypeName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAggreeId() {
		return aggreeId;
	}
	public void setAggreeId(String aggreeId) {
		this.aggreeId = aggreeId;
	}
	public String getBankImg() {
		return bankImg;
	}
	public void setBankImg(String bankImg) {
		this.bankImg = bankImg;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public PaymentMode getPayType() {
		return payType;
	}
	public void setPayType(PaymentMode payType) {
		this.payType = payType;
	}
	public String getCardTypeName() {
		return cardTypeName;
	}
	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}
	
}
