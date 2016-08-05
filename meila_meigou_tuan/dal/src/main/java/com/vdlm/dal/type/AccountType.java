package com.vdlm.dal.type;

/**
 * 账户类别
 * 
 * @author huxaya
 *
 */
public enum AccountType {
	AVAILABLE, // 可用账户
	DANBAO, // 担保账户
	FROZEN, // 冻结账户
	COMMISSION, //佣金账户 针对网站主
	WITHDRAW, // 提现账户
	CREDIT, // 信用账户
	HONGBAO, // 红包账户
	CONSUME, // 消费账户(虚拟账户)
	DEPOSIT //保证金
}
