package com.vdlm.dal.status;

public enum OrderStatus {
	// PREORDER, // 预订
	SUBMITTED, // 已提交
	CANCELLED, // 取消
	WAITPAYCONFIRM,//等待支付确认
	PAID, // 已付款
	SHIPPED, // 已发货
	SUCCESS, // 交易成功
	REFUNDING, // 退款申请中
	CLOSED ,// 交易关闭
	PART_SHIPPED//部分发货
}
