package com.vdlm.dal.status;

/**
 * 退款状态枚举
 * @author meila-x
 *
 */
public enum RefundStatus {
	PROCESS, // 处理中
	B_CANCEL, // 买家取消
	S_ACCPECT, // 卖家同意
	S_REJECT, // 卖家拒绝
	P_ACCPECT, // 平台确认
	P_REJECT, // 平台拒绝|
	SUCCESS;// 退款成功（实际打款）
}
