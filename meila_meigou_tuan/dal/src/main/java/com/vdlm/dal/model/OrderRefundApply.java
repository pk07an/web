package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.OrderStatus;
import com.vdlm.dal.status.RefundStatus;
import com.vdlm.dal.type.RefundType;

public class OrderRefundApply extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String applyNo; // 申请编号

	private String orderId; // 订单id
	private String sellerId; // 卖家同意/确认id
	private String confirmUserId;// 平台运营人id
	private RefundStatus refundStatus;// 退款状态
	private OrderStatus orderStatus; // 订单状态

	private BigDecimal refundFee; // 退款金额
	private RefundType refundType;// 退款类型
	private String refundReason; // 退款原因
	private String refundRemark; // 退款说明
	private String rejectReason; // 拒绝原因
	private String rejectRemark; // 拒绝说明
	private String requestBy; // 发起人类型

	private Date refundTime; // 申请时间
	private Date cancelTime;// 同意时间
	private Date sellerConfirmTime;// 确认时间
	private Date plateConfirmTime;// 拒绝时间
	private Date transferTime;// 退款转账时间
	private Boolean archive;//

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getConfirmUserId() {
		return confirmUserId;
	}

	public void setConfirmUserId(String confirmUserId) {
		this.confirmUserId = confirmUserId;
	}

	public RefundStatus getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(RefundStatus refundStatus) {
		this.refundStatus = refundStatus;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}

	public RefundType getRefundType() {
		return refundType;
	}

	public void setRefundType(RefundType refundType) {
		this.refundType = refundType;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getRefundRemark() {
		return refundRemark;
	}

	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getRejectRemark() {
		return rejectRemark;
	}

	public void setRejectRemark(String rejectRemark) {
		this.rejectRemark = rejectRemark;
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Date getSellerConfirmTime() {
		return sellerConfirmTime;
	}

	public void setSellerConfirmTime(Date sellerConfirmTime) {
		this.sellerConfirmTime = sellerConfirmTime;
	}

	public Date getPlateConfirmTime() {
		return plateConfirmTime;
	}

	public void setPlateConfirmTime(Date plateConfirmTime) {
		this.plateConfirmTime = plateConfirmTime;
	}

	public Date getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(Date transferTime) {
		this.transferTime = transferTime;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

}
