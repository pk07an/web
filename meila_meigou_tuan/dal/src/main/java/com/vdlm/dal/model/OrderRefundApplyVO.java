package com.vdlm.dal.model;

public class OrderRefundApplyVO extends OrderRefundApply {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String buyerId;
	private String orderSellerId;// 订单上的卖家ID

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getOrderSellerId() {
		return orderSellerId;
	}

	public void setOrderSellerId(String orderSellerId) {
		this.orderSellerId = orderSellerId;
	}
}
