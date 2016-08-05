package com.vdlm.dal.type;

public enum PushMsgType {
	
	MSG_NORMAL(1),
	
	MSG_LEAVEMSGS(200),
	
	MSG_PROD (1000),
		MSG_PROD_OUTSTOCK_S(1005),       //  商品下架(库存为0自动下架)
	
	MSG_ORDER(2000),
		MSG_ORDER_DONE_B(2502),				//  交易完成
		MSG_ORDER_SHIPPED_B(2502),			//  发货成功,待收货
		MSG_ORDER_CLOSED_B(2502),			//  交易关闭(卖家已退款)
		MSG_ORDER_NEW_B(2502), 				//  新订单提交,待付款
		MSG_ORDER_PAYED_B(2502),  			// 您已付款成功,待发货
		MSG_ORDER_DELAYSIGN_B(2502),		// 买家订单签收到期提醒
		
		MSG_ORDER_FIRST_S(2001),				// 第一笔新订单
		MSG_ORDER_NEW_S(2002),					// 新订单
		MSG_ORDER_PAYED_S(2002),				// 付款成功
		MSG_ORDER_DONE_S(2002),			//  交易完成(担保交易延期自动签收, 确认收货) 
		MSG_ORDER_CLOSED_S(2002),		   //  交易关闭(订单超时未付款)
		MSG_ORDER_HANDFEE(2002),			// 订单超过指定数目收取相应手续费
		MSG_ORDER_DELAYSIGN_S(2002),     // 买家已延迟签收
		
		MSG_ORDER_REMINDSHIP_S(2002),  // 提醒卖家发货
		
	MSG_INCOME(3000),
		MSG_INCOME_FIRST_S(3001),			// 第一次交易完成可收款
		MSG_REFUND_REQUEST_S(3002), //发起退款申请(给卖家)
		MSG_REFUND_REJECT_B(3502),  //拒绝退款申请(给买家)
		MSG_REFUND_AGREE_RETURN_B(3503),  //卖家同意退货(给买家)
		MSG_REFUND_SUCCESS_B(3504), //完成退款申请(给买家)
		
	MSG_ACTIVITY1(9001),							// 活动类
		MSG_ACTIVITY(9002),							// 活动大促通知
		MSG_ACTIVITY_FREE_B(9002),				// 买家免单活动消息
	
	MSG_MAX(10000);
	
	private int code;
	
	private PushMsgType(int code) {
		this.code = code;
	}
	
	public int getValue() {
		return code;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.code);
	}
	
}
