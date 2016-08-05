package com.vdlm.dal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserCoupon  implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -6428437219584861814L;

    private String id;

    private String userId;

    private String couponCode;

    private String shopId;

    private String sellerId;

    private String activityId;

    private String activityTitile;

    private String activityRange;

    private String status;

    private Date createTime;

    private Date usedTime;

    private Date startTime;

    private Date endTime;

    private String couponChannel;

    private String couponTitle;

    private Date updatedTime;

    private String clientId;

    private String extActivityId;
    
    private BigDecimal discount; //券的价值

    private BigDecimal fullDiscount;//满多少

    public BigDecimal getFullDiscount() {
        return fullDiscount;
    }

    public void setFullDiscount(BigDecimal fullDiscount) {
        this.fullDiscount = fullDiscount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityTitile() {
        return activityTitile;
    }

    public void setActivityTitile(String activityTitile) {
        this.activityTitile = activityTitile;
    }

    public String getActivityRange() {
        return activityRange;
    }

    public void setActivityRange(String activityRange) {
        this.activityRange = activityRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCouponChannel() {
        return couponChannel;
    }

    public void setCouponChannel(String couponChannel) {
        this.couponChannel = couponChannel;
    }

    public String getCouponTitle() {
        return couponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        this.couponTitle = couponTitle;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getExtActivityId() {
        return extActivityId;
    }

    public void setExtActivityId(String extActivityId) {
        this.extActivityId = extActivityId;
    }
    
    public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
}