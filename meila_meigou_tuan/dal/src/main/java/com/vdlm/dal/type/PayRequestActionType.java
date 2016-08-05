package com.vdlm.dal.type;

/**
 * 请求支付可操作的动作类型
 * 
 * @author huxaya
 *
 */
public enum PayRequestActionType {

	SUBMIT, // 提交请求
	CANCEL, // 取消支付请求
	PAY, // 确认支付
	SUCCESS // 成功
}
