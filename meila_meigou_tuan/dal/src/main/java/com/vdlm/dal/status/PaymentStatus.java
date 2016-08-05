package com.vdlm.dal.status;

/**
 * 系统内部的支付状态
 * @author huxaya
 *
 */
public enum PaymentStatus {
	/**等待支付**/
	WAITING,
	/** 支付成功，但还可进一步操作（退款，分润等） */
	SUCCESS,
	/** 支付成功且完成，无后续可操作 */
	FINISHED,
	/** 未支付或已退款，已关闭 */
	CLOSED,
	/** 未支付 */
	PENDING
	
	
//	//WAITING, //等待支付
//	SUBMITTED, //提交
//	FAILED, //支付失败
//	SUCCESS, //支付完成
//	CANCEL //取消
	
}
