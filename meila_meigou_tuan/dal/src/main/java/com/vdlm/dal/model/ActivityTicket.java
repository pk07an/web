package com.vdlm.dal.model;

import java.util.Date;

import com.vdlm.dal.status.ActivityTicketAuditStatus;
import com.vdlm.dal.type.ActivityStatus;

public class ActivityTicket {
    
    private String id;
    
    private String activityId;
    
    private String shopId;
    
    // 活动开始时间
    private Date startTime;
 
    // 活动结束时间
    private Date endTime;
    
    // 活动审核的生命周期状态
    private ActivityTicketAuditStatus auditStatus;

    // 活动的生命周期状态
    private ActivityStatus status;
        
    private Date createdAt;

    private Boolean archive;
    
    private Integer preferentialType;
    
    private Float discount;
    
    private Float reduction;
    
    private String feedback;
    
    private String reason;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public ActivityTicketAuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(ActivityTicketAuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public void setStatus(ActivityStatus status) {
        this.status = status;
    }

    public ActivityStatus getStatus() {
        return status;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getPreferentialType() {
		return preferentialType;
	}

	public void setPreferentialType(Integer preferentialType) {
		this.preferentialType = preferentialType;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Float getReduction() {
		return reduction;
	}

	public void setReduction(Float reduction) {
		this.reduction = reduction;
	}

}
