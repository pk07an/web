package com.vdlm.dal.vo;

import java.util.Date;

import com.vdlm.dal.model.CampaignProduct;
import com.vdlm.dal.status.ActivityTicketAuditStatus;
import com.vdlm.dal.type.ActivityStatus;

public class CampaignProductEX extends CampaignProduct{

	private static final long serialVersionUID = 1L;

	private ActivityStatus status;
	
	private ActivityTicketAuditStatus auditStatus;
	
	private Date activityStartTime;
	
	private Date activityEndTime;
	
	private String feedback;

	public ActivityStatus getStatus() {
		return status;
	}

	public void setStatus(ActivityStatus status) {
		this.status = status;
	}

	public ActivityTicketAuditStatus getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(ActivityTicketAuditStatus auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Date getActivityStartTime() {
		return activityStartTime;
	}

	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public Date getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
