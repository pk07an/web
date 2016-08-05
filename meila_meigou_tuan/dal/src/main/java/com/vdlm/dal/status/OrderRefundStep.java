package com.vdlm.dal.status;

public enum OrderRefundStep {
	AUDIT_ITEM,   //等待卖家审核退货
	WAIT_RETURN,  //等待买家退货
	AUDIT_RETURN, //等待卖家确认收货
	AUDIT_FEE,	  //等待卖家审核退款
	SUCCESS,   //退货退款成功
	
//    const REFUND_STEP_AUDIT_ITEM = 1;   //等待卖家审核退货
//    const REFUND_STEP_WAIT_RETURN = 2;  //等待买家退货
//    const REFUND_STEP_AUDIT_RETURN = 3; //等待卖家确认收货
//    const REFUND_STEP_APPLY_MONEY = 4;  //等待卖家确认收货
//    const REFUND_STEP_AUDIT_MONEY = 5;  //等待卖家审核退款
//    const REFUND_STEP_WAIT_MONEY = 6;   //卖家同意退款
//    const REFUND_SETP_DONE = 7;         //退货退款成功
	
//    const REFUND_STEPEX_UNDONE = 0; //未处理
//
//    const REFUND_STEPEX_CANNEL = 1; //取消
//
//    const REFUND_STEPEX_REFUSED = 2; //拒绝
}
