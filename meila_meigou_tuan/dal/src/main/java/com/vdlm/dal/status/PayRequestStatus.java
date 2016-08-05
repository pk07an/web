package com.vdlm.dal.status;

/**
 * 请求支付状态
 * 
 * @author huxaya
 *
 */
public enum PayRequestStatus {
	SUBMITTED, // 已提交
	FAILED, // 支付失败
	PAID, // 支付成功
	SUCCESS, // 支付完成、担保中
	CANCELED // 取消
}
