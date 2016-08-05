package com.vdlm.dal.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.vdlm.dal.status.OrderStatus;
import com.vdlm.dal.type.DealType;

public class DealHistoryVO {

	//title, fee, memo, date  v1用到的
	
	private OrderStatus orderStatus;

	private String feeFrom;
	
	private DealType dealType; 

	private BigDecimal fee;  //金额

	private String withdrawBank; //提现银行
	
	private String title;
	
	private String memo;

	private Date date;

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getFeeFrom() {
		return feeFrom;
	}

	public void setFeeFrom(String feeFrom) {
		this.feeFrom = feeFrom;
	}
	
	public DealType getDealType() {
		return dealType;
	}

	public void setDealType(DealType dealType) {
		this.dealType = dealType;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getWithdrawBank() {
		return withdrawBank;
	}

	public void setWithdrawBank(String withdrawBank) {
		this.withdrawBank = withdrawBank;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
