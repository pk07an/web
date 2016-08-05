package com.vdlm.dal.vo;

import java.util.Date;

import com.vdlm.dal.model.Activity;
import com.vdlm.dal.type.ActivityStatus;

public class ActivityEX extends Activity {

	private static final long serialVersionUID = 1L;

	private Integer preferentialType;
	private Float discount;
	private ActivityStatus ticketStatus;
	private Float reduction;
	private String ticketId;
	// 活动开始时间
    private Date ticketStartTime;
    // 活动结束时间
    private Date ticketEndTime;

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

	public ActivityStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(ActivityStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Date getTicketStartTime() {
		return ticketStartTime;
	}

	public void setTicketStartTime(Date ticketStartTime) {
		this.ticketStartTime = ticketStartTime;
	}

	public Date getTicketEndTime() {
		return ticketEndTime;
	}

	public void setTicketEndTime(Date ticketEndTime) {
		this.ticketEndTime = ticketEndTime;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

}
