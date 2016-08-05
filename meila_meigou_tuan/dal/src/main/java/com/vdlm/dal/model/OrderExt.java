package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderExt {
    private String id;

    private String orderId;

    private Integer expressCompanyNo;

    private String mcode;

    private Integer coin;

    private BigDecimal coinPrice=BigDecimal.ZERO.setScale(2);

    private Integer refundStatus;

    private String utmChannel;

    private Integer utmUserId;

    private Date statusUpdateTime;

    private Integer settlementStatus;

    private String source;
    
    private boolean tuanFlag;
    
    private String tuanNo;
    
    private String utmActivity;
    
    private String inChannel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getExpressCompanyNo() {
        return expressCompanyNo;
    }

    public void setExpressCompanyNo(Integer expressCompanyNo) {
        this.expressCompanyNo = expressCompanyNo;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public BigDecimal getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(BigDecimal coinPrice) {
        this.coinPrice = coinPrice;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getUtmChannel() {
        return utmChannel;
    }

    public void setUtmChannel(String utmChannel) {
        this.utmChannel = utmChannel;
    }

    public Integer getUtmUserId() {
        return utmUserId;
    }

    public void setUtmUserId(Integer utmUserId) {
        this.utmUserId = utmUserId;
    }

    public Date getStatusUpdateTime() {
        return statusUpdateTime;
    }

    public void setStatusUpdateTime(Date statusUpdateTime) {
        this.statusUpdateTime = statusUpdateTime;
    }

    public Integer getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(Integer settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public boolean getTuanFlag() {
        return tuanFlag;
    }

    public void setTuanFlag(boolean tuanFlag) {
        this.tuanFlag = tuanFlag;
    }

    public String getTuanNo() {
        return tuanNo;
    }

    public String getUtmActivity() {
        return utmActivity;
    }

    public void setUtmActivity(String utmActivity) {
        this.utmActivity = utmActivity;
    }

    public String getInChannel() {
        return inChannel;
    }

    public void setInChannel(String inChannel) {
        this.inChannel = inChannel;
    }

    public void setTuanNo(String tuanNo) {
        this.tuanNo = tuanNo;
    }
}