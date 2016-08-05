package com.vdlm.dal.type;

/**
 * 资金操作类型
 * 
 * @author huxaya
 *
 */
public enum AccountOpType {
    RECHARGE, // 充值
    INSTANT, // 即时转账、
    DANBAO_ING, // 担保转账中
    DANBAO_DONE, // 担保转账完成
    DANBAO_CANCEL, // 担保转账取消
    REFUND, // 即时转账 退款
    WITHDRAW_ING, // 提现中
    WITHDRAW_DONE, // 提现完成
    WITHDRAW_CANCEL, // 提现取消
    FROZEN, // 冻结
    UNFROZEN, // 解冻
    DANBAO_REFUND, // 担保退款
    AVAILABLE2CONSUME, // 从自己的可用账户转到消费账户
    HONGBAO2CONSUME, // 从自己的红包账户到消费账户
    CONSUME2AVAILABLE, // 从自己的消费转到可用账户账户
    CONSUME2HONGBAO, // 从自己的消费账户到红包账户
    // 以下类别两个为交易完成后的退款
    AVAILABLE_CONSUME_REFUND, // 退款时，从卖家的可用账户退到买家的消费账户
    DANBAO2CONSUME_REFUND // 退款时，从卖家的可用账户退到买家的消费账户
}
