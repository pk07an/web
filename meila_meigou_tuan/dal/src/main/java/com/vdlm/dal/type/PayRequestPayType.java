package com.vdlm.dal.type;

public enum PayRequestPayType {
	RECHARGE, // 充值
	BATCH, // 批量转账
	INSTANT, // 即时转账
	DANBAO, // 担保转账
	REFUND, // 退款
	WITHDRAW, // 提现
	FROZEN, // 冻结
	UNFROZEN, // 解冻
	RECHARGEHONGBAO,	//充值到红包账户 
	AVAILABLE2CONSUME, 	// 从可用账户转到消费账户
	HONGBAO2CONSUME, 	// 从红包账户到可消费账户
	CONSUME2AVAILABLE, 	// 从消费账户到可用账户
	CONSUME2HONGBAO, 	// 从消费账户到红包账户
	DANBAO2CONSUME	//从担保账户到消费账户
	
}
