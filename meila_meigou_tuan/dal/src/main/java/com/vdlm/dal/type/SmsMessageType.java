package com.vdlm.dal.type;

public enum SmsMessageType {
	/**
	 * 买家下完订单
	 */
	SUBMITTED_BUYER,
	/**
	 * 付款后卖家消息
	 */
	PAID_SELLER,
	/**
	 * 付款后买家消息
	 */
	PAID_BUYER,
	/**
	 * 发货后买家消息
	 */
	SHIPPED_BUYER,
	/**
	 * 未付款超时取消卖家消息
	 */
	CANCELLED_SELLER,
	/**
	 * 未付款超时取消买家消息
	 */
	CANCELLED_BUYER,
	/**
	 * 买家发起退款申请
	 */
	ORDER_REFUND_REQUEST_SELLER,
	
	/**
	 * 卖家拒绝退款申请
	 */
	ORDER_REFUND_REJECT_BUYERER,
	
	/**
	 * 卖家同意退货
	 */
	ORDER_REFUND_AGREE_RETURN_BUYERER,
	
	/**
	 * 完成退款申请
	 */
	ORDER_REFUND_SUCCESS_BUYERER,
	
	/**
	 * 搬家完成后的提示消息
	 */
	MOVE_PRODUCT,
	/**
	 * 第三方名活动免单通知
	 */
	FREE_ORDER,
	/**
	 * 第三方名活动免单通知
	 */
	FREE_ORDER_FINISH,
	/**
	 *  延迟收货到期提醒
	 */
	DELAYSIGN_EXPIRE_REMIND
}
