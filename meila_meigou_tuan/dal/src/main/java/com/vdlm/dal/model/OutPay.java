package com.vdlm.dal.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.PaymentStatus;
import com.vdlm.dal.type.PayDetailType;

public class OutPay extends BaseEntityImpl{
   
	private static final long serialVersionUID = 1L;

    private String pOutpayId;

    private String requestId;

    private String forOutpayId;

    private String userId;

    private PaymentStatus status;

    private String outpayType;

    private String outpayTypeEx;

    private BigDecimal amount;

    private String outId;

    private String outAccountId;

    private String outAccountName;

    private String outStatus;

    private String outStatusEx;

    private byte[] detail;
    
    private String billNo;
    
    private String tradeNo;
    
    private PayDetailType payDetailType;
    private String partner;

    public String getpOutpayId() {
        return pOutpayId;
    }

    public void setpOutpayId(String pOutpayId) {
        this.pOutpayId = pOutpayId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getForOutpayId() {
        return forOutpayId;
    }

    public void setForOutpayId(String forOutpayId) {
        this.forOutpayId = forOutpayId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getOutpayType() {
        return outpayType;
    }

    public void setOutpayType(String outpayType) {
        this.outpayType = outpayType == null ? null : outpayType.trim();
    }

    public String getOutpayTypeEx() {
        return outpayTypeEx;
    }

    public void setOutpayTypeEx(String outpayTypeEx) {
        this.outpayTypeEx = outpayTypeEx == null ? null : outpayTypeEx.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId == null ? null : outId.trim();
    }

    public String getOutAccountId() {
        return outAccountId;
    }

    public void setOutAccountId(String outAccountId) {
        this.outAccountId = outAccountId == null ? null : outAccountId.trim();
    }

    public String getOutAccountName() {
        return outAccountName;
    }

    public void setOutAccountName(String outAccountName) {
        this.outAccountName = outAccountName == null ? null : outAccountName.trim();
    }

    public String getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(String outStatus) {
        this.outStatus = outStatus == null ? null : outStatus.trim();
    }

    public String getOutStatusEx() {
        return outStatusEx;
    }

    public void setOutstatusex(String outStatusEx) {
        this.outStatusEx = outStatusEx == null ? null : outStatusEx.trim();
    }

    public byte[] getDetail() {
        return detail;
    }

    public void setDetail(byte[] detail) {
        this.detail = detail;
    }

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
	public PayDetailType getPayDetailType() {
        return payDetailType;
    }

    public void setPayDetailType(PayDetailType payDetailType) {
        this.payDetailType = payDetailType;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}