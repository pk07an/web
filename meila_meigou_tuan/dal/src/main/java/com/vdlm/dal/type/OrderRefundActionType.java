package com.vdlm.dal.type;

public enum OrderRefundActionType {
	CANCEL, //取消
	SUBMIT, // 下单
	REJECT, // 拒绝
	CONFIRM, // 确认订单
	SHIP, // 买家发货
	SIGN, // 卖家收货
	REJECT_SIGN //没有收到货
}
