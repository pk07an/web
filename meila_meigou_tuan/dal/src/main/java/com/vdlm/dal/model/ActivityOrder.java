package com.vdlm.dal.model;

import java.math.BigDecimal;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.ActivityOrderStatus;

public class ActivityOrder extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String orderNo;
	private long sellerId;
	private long buyerId;
	private BigDecimal totalFee;
	private long activityId;
	private ActivityOrderStatus status;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public ActivityOrderStatus getStatus() {
		return status;
	}

	public void setStatus(ActivityOrderStatus status) {
		this.status = status;
	}
}
