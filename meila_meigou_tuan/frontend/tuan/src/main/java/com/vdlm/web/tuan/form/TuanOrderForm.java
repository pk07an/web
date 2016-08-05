package com.vdlm.web.tuan.form;

import java.io.Serializable;

/**
 * 
 ************************************************************
 * @类名 : TuanOrderForm.java
 *
 * @DESCRIPTION :
 * @AUTHOR : peter
 * @DATE : 2016年3月2日
 ************************************************************
 */
public class TuanOrderForm implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String actId;// 活动ID
    private String addressId;// 地址ID
    private String orderType;// 订单类型，0：开团，1：参团
    private String tuanNo;// 团单号，参团使用
    private String remark;// 卖家留言

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getTuanNo() {
        return tuanNo;
    }

    public void setTuanNo(String tuanNo) {
        this.tuanNo = tuanNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
