package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.type.BankCardType;
import com.vdlm.dal.type.PaymentMode;

public class OutpayAgreement extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String userId;

    private PaymentMode payMode;

    private String bizAgreeId;

    private String payAgreeId;
    
    private BankCardType cardType;
    
    private String bankCode;
    
    private String accountNum;
    
    private String identityType;
    
    private String identityNo;
    
    private String accountName;
    
    private String mediaType;
    
    private String mediaNo;
    
    private String bindStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PaymentMode getPayMode() {
        return payMode;
    }

    public void setPayMode(PaymentMode payMode) {
        this.payMode = payMode;
    }

    public String getBindStatus() {
		return bindStatus;
	}

	public void setBindStatus(String bindStatus) {
		this.bindStatus = bindStatus;
	}

	public String getBizAgreeId() {
        return bizAgreeId;
    }

    public void setBizAgreeId(String bizAgreeId) {
        this.bizAgreeId = bizAgreeId == null ? null : bizAgreeId.trim();
    }

    public String getPayAgreeId() {
        return payAgreeId;
    }

    public void setPayAgreeId(String payAgreeId) {
        this.payAgreeId = payAgreeId == null ? null : payAgreeId.trim();
    }

	public BankCardType getCardType() {
		return cardType;
	}

	public void setCardType(BankCardType cardType) {
		this.cardType = cardType;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaNo() {
		return mediaNo;
	}

	public void setMediaNo(String mediaNo) {
		this.mediaNo = mediaNo;
	}
	
}