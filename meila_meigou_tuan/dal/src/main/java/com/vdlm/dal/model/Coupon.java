package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vdlm.dal.status.CouponStatus;

public class Coupon {
    
    private String id;
    
    private String code;
    
    private String activityId;
    
    private String activityTitle;
    
    private String userId;
    
    private BigDecimal discount;
    
    private Date validFrom;
    
    private Date validTo;
    
    private String extCouponId;
    
    private CouponStatus status;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private String bizNo; // 付款单号;
    
    private Date cashieritemCreatedAt; // 付款时间
    
    // add by luojy 20150703
    private String deviceId;
    
    public Coupon(){
    	
    }
    
    public Coupon(String actId, String code, BigDecimal discount, CouponStatus status, 
    		String userId, String deviceId, Date validFrom, Date validTo){
    	this.activityId = actId;
    	this.code = code;
    	this.discount = discount;
    	this.status = status;
    	this.userId = userId;
    	this.deviceId = deviceId;
    	this.validFrom = validFrom;
    	this.validTo = validTo;
    }

    public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
    // add by luojy 20150703
	
    public String getBizNo() {
		return bizNo;
	}

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public Date getCashieritemCreatedAt() {
		return cashieritemCreatedAt;
	}
	
	public String getCashieritemCreatedAtStr() {
		Date date = this.getCashieritemCreatedAt();
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return simpleDateFormat.format(date);
		}
	}

	public void setCashieritemCreatedAt(Date cashieritemCreatedAt) {
		this.cashieritemCreatedAt = cashieritemCreatedAt;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
    
    public String getActivityTitle() {
        return activityTitle;
    }

    public void setactivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getUserId() {
        return userId==null?"":userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Date getCreatedAt() {
        return createdAt;
    }
	
	public String getCreatedAtStr() {
		Date date = this.getCreatedAt();
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return simpleDateFormat.format(date);
		}
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

    public Date getValidFrom() {
        return validFrom;
    }
    
    public String getValidFromStr() {
		Date date = this.getValidFrom();
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return simpleDateFormat.format(date);
		}
	}

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }
    
    public String getValidToStr() {
		Date date = this.getValidTo();
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return simpleDateFormat.format(date);
		}
	}

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public CouponStatus getStatus() {
        return status;
    }
    
    public String getStatusVal() {
    	String ret = null;
    	if(status==null){
    	    return ret;
    	}
    	switch (status) {
		case VALID:
			ret = "有效";
			break;
		case OVERDUE:
			ret = "过期";
			break;
		case USED:
			ret = "已使用";
			break;
		default:
			break;
		}
    	return ret;
    }

    public void setStatus(CouponStatus status) {
        this.status = status;
    }

	public String getExtCouponId() {
		return extCouponId==null?"":extCouponId;
	}

	public void setExtCouponId(String extCouponId) {
		this.extCouponId = extCouponId;
	}
    
}
