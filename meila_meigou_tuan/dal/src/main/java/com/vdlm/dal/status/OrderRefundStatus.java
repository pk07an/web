package com.vdlm.dal.status;

public enum OrderRefundStatus {
	SUBMITTED, //已提交
	CANCELLED, //取消
	AGREE_RETURN, //买家同意退货
	REJECT_RETURN, //拒绝买家退货
	REJECT_REFUND, //拒绝买家退款
	RETURN_ING,  //买家填写退货运单号后，处于退货中 
	RETURN_DONE, //买家已退货，商品已签收
	SUCCESS,   //退款成功，但还未打款
	COMPLETE,  //退款申请成功，卖家收到货后的状态，（如果是不退货的退款，则直接从success跳到COMPLETE）
	CLOSE;	   //退款申请被拒绝后关闭
//	
//	String description;
//	
//	public String getDescription() {
//		return description;
//	}
//
//    const REFUND_STATUS_REFUND_SUCCESS = 6; //退货成功, 但还未打款
//    const REFUND_STATUS_REFUND_FAIL = 7; //拒绝退货
//    const REFUND_STATUS_RETURN_FAIL = 9; //退货没有收到。
//    const REFUND_STATUS_FUND_FINISH = 8; //退货已打款, 走完整个流程
	
//	AUDIT_ITEM,   //等待卖家审核退货
//	WAIT_RETURN,  //等待买家退货
//	AUDIT_RETURN, //等待卖家确认收货
//	AUDIT_FEE,	  //等待卖家审核退款
//	SUCCESS,   //退货退款成功
//	
	
//    const REFUND_STEP_AUDIT_ITEM = 1;   //等待卖家审核退货
//    const REFUND_STEP_WAIT_RETURN = 2;  //等待买家退货
//    const REFUND_STEP_AUDIT_RETURN = 3; //等待卖家确认收货
//    const REFUND_STEP_APPLY_MONEY = 4;  //等待卖家确认收货
//    const REFUND_STEP_AUDIT_MONEY = 5;  //等待卖家审核退款
//    const REFUND_STEP_WAIT_MONEY = 6;   //卖家同意退款
//    const REFUND_SETP_DONE = 7;         //退货退款成功
}
