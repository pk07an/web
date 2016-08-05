package com.vdlm.dal.model;

import java.math.BigDecimal;

public class OrderItemPromotion {
    private String id;

    private String orderItemId;

    private String activityIdstr;

    private BigDecimal discountFee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getActivityIdstr() {
        return activityIdstr;
    }

    public void setActivityIdstr(String activityIdstr) {
        this.activityIdstr = activityIdstr;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }
}