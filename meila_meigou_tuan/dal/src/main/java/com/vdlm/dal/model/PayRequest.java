package com.vdlm.dal.model;

import java.math.BigDecimal;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.PayRequestStatus;
import com.vdlm.dal.type.PayRequestBizType;
import com.vdlm.dal.type.PayRequestPayType;

/**
 * 支付请求model
 * 
 * @author huxaya
 *
 */
public class PayRequest extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String payNo; // 唯一事务号，多笔支付

	private String bizId;

	private PayRequestBizType bizType;

	private PayRequestPayType payType;

	private BigDecimal amount;

	private String fromSubAccountId;

	private String toSubAccountId;

	private PayRequestStatus status;

	private String statusex;

	private String outpayType;

	private String outpayInfo;

	private String forRequestId;

	private String callbackStatus;

	private String callback;

	private Integer callbackType;

	private String callbackParam;

	private String comment;

	public PayRequest() { }

	public PayRequest(String payNo, String bizId, PayRequestBizType bizType, PayRequestPayType payType, BigDecimal amount, 
			String fromSubAccountId, String toSubAccountId, String forRequestId) {
		this.payNo = payNo;
		this.bizId = bizId;
		this.bizType = bizType;
		this.payType = payType;
		this.amount = amount;
		this.fromSubAccountId = fromSubAccountId;
		this.toSubAccountId = toSubAccountId;
		this.forRequestId = forRequestId;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public PayRequestBizType getBizType() {
		return bizType;
	}

	public void setBizType(PayRequestBizType bizType) {
		this.bizType = bizType;
	}

	public PayRequestPayType getPayType() {
		return payType;
	}

	public void setPayType(PayRequestPayType payType) {
		this.payType = payType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFromSubAccountId() {
		return fromSubAccountId;
	}

	public void setFromSubAccountId(String fromSubAccountId) {
		this.fromSubAccountId = fromSubAccountId;
	}

	public String getToSubAccountId() {
		return toSubAccountId;
	}

	public void setToSubAccountId(String toSubAccountId) {
		this.toSubAccountId = toSubAccountId;
	}

	public PayRequestStatus getStatus() {
		return status;
	}

	public void setStatus(PayRequestStatus status) {
		this.status = status;
	}

	public String getStatusex() {
		return statusex;
	}

	public void setStatusex(String statusex) {
		this.statusex = statusex == null ? null : statusex.trim();
	}

	public String getOutpayType() {
		return outpayType;
	}

	public void setOutpayType(String outpayType) {
		this.outpayType = outpayType == null ? null : outpayType.trim();
	}

	public String getOutpayInfo() {
		return outpayInfo;
	}

	public void setOutpayInfo(String outpayInfo) {
		this.outpayInfo = outpayInfo == null ? null : outpayInfo.trim();
	}

	public String getForRequestId() {
		return forRequestId;
	}

	public void setForRequestId(String forRequestId) {
		this.forRequestId = forRequestId;
	}

	public String getCallbackStatus() {
		return callbackStatus;
	}

	public void setCallbackStatus(String callbackStatus) {
		this.callbackStatus = callbackStatus == null ? null : callbackStatus.trim();
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback == null ? null : callback.trim();
	}

	public Integer getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(Integer callbackType) {
		this.callbackType = callbackType;
	}

	public String getCallbackParam() {
		return callbackParam;
	}

	public void setCallbackParam(String callbackParam) {
		this.callbackParam = callbackParam == null ? null : callbackParam.trim();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	@Override
	public String toString() {
		return "PayRequest [payNo=" + payNo + ", status=" + status + ", payType=" + payType + ", bizId=" + bizId + ", bizType=" + bizType + ", amount=" + amount + ", fromSubAccountId=" + fromSubAccountId
				+ ", toSubAccountId=" + toSubAccountId + "]";
	}
}