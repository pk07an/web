package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentRequestLogs extends BaseObject {
    private String id;

    private String payNo;

    private String payType;

    private String payDetailType;

    private BigDecimal totalFee;

    private String userId;

    private String outTradeNo;

    private Date createdAt;

    private Date updatedAt;

    private String paySubject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayDetailType() {
        return payDetailType;
    }

    public void setPayDetailType(String payDetailType) {
        this.payDetailType = payDetailType;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPaySubject() {
        return paySubject;
    }

    public void setPaySubject(String paySubject) {
        this.paySubject = paySubject;
    }
}