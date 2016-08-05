package com.vdlm.dal.type;

public enum PushMsgId {
	
	FirstIncome(101L), 
	FirstSelled(102L),
	
	// 留言通知
	MessageNotify(200L),
	MessageNotify_XQ(200L),
	
	// 有新订单
	NewOrder(2002L),
	NewOrder_XQ(2506L),
	
	REFUND_REQUEST(3001L), //发起退款申请
	REFUND_REJECT(3002L),  //拒绝退款申请
	REFUND_AGREE_RETURN(3003L),  //卖家同意退货
	REFUND_SUCCESS(3004L), //完成退款申请
	
	// 提醒卖家发货
	OrderRemindShip(2009),
	
	// 想去名单通知
	FreeOrder_XQ(2507L),
	
	// 卖家延迟收货通知
	OrderDelaySign(2008),
	
	// 买家延迟收货到期提醒
	OrderDelaySignRemind(2508),
	
	// 交易关闭
	OrderCancel(2005L),
	OrderCancel_XQ(2505L),
	
	// 已付款通知
	OrderPay(2003L), 	
	OrderPay_XQ(2503L),
	
	// 发货通知买家
	OrderShip_XQ(2502L),//想去发货
	
	// 签收通知
	OrderSign(2004L),
	OrderSign_XQ(2504L),
	
	// 卖家发起退款通知
	OrderRefund_XQ(2505L),
	
	// 收取卖家手续费
	OrderHandFee(2007L),
	
	MSG_MAX(10000);
	
	private long id;
	
	private PushMsgId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
}
