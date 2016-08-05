package com.vdlm.dal.model;

import java.math.BigDecimal;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.PaymentStatus;
import com.vdlm.dal.type.PaymentChannel;
import com.vdlm.dal.type.PaymentMode;
import com.vdlm.dal.type.UserPartnerType;

public class CashierItem extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String bizNo;
	private PaymentChannel paymentChannel; // 支付渠道 支付平台、储蓄卡、信用卡
	private PaymentMode paymentMode; // 支付方式
	private BigDecimal amount; // 支付金额
//	private BigDecimal thirdVouchers;// 第三方抵用券，如闪购币数量、想去优惠券金额
//	private String thirdVoucherId; // 第三方优惠id
	
	private String userId;
	private String couponId;//优惠券ID
	private String agreementId; // 协议号
	private String bankCode; // 银行,如CCB、CMB
	private String bankName;
	private PaymentStatus status;
	private String productId;
	private String productName;
	private UserPartnerType partnerType;
	private String batchBizNos;
	private Boolean batch;
//	private String thirdVoucherName;
	
	private String payToken;
	private String destination;
	// such as native browser, when the payment is completed, to control page response
	private String client;
	
	public String getBizNo() {
		return bizNo;
	}

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public PaymentChannel getPaymentChannel() {
		return paymentChannel;
	}

	public void setPaymentChannel(PaymentChannel paymentChannel) {
		this.paymentChannel = paymentChannel;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

//	public BigDecimal getThirdVouchers() {
//		return thirdVouchers;
//	}
//
//	public void setThirdVouchers(BigDecimal thirdVouchers) {
//		this.thirdVouchers = thirdVouchers;
//	}

	public String getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(String agreementId) {
		this.agreementId = agreementId;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

//	public String getThirdVoucherName() {
//		return thirdVoucherName;
//	}
//
//	public void setThirdVoucherName(String thirdVoucherName) {
//		this.thirdVoucherName = thirdVoucherName;
//	}
//
//	public String getThirdVoucherId() {
//		return thirdVoucherId;
//	}
//
//	public void setThirdVoucherId(String thirdVoucherId) {
//		this.thirdVoucherId = thirdVoucherId;
//	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public UserPartnerType getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(UserPartnerType partnerType) {
		this.partnerType = partnerType;
	}
	public Boolean getBatch() {
		return batch;
	}

	public void setBatch(Boolean batch) {
		this.batch = batch;
	}
	public String getBatchBizNos() {
		return batchBizNos;
	}

	public void setBatchBizNos(String batchBizNos) {
		this.batchBizNos = batchBizNos;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getPayToken() {
		return payToken;
	}

	public void setPayToken(String payToken) {
		this.payToken = payToken;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
