package com.vdlm.dal.type;

public enum OrderActionType {
	SUBMIT, // 下单 
	CANCEL, // 取消订单
	// PREORDER, // 支付订单预付款
	// CONFIRM, // 确认预订单
	PAY, // 订单支付
	SHIP, // 订单发货
	SIGN, // 订单签收
	REFUND, // 卖家退款
	REQUEST_REFUND, // 申请退款
	ACCEPT_REFUND,  // 接受退款申请
	REJECT_REFUND,   // 拒绝退款申请
	CANCEL_REFUND   // 取消退款申请 
	// SUCCEED 
}
