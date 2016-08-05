package com.vdlm.dal.model.promotion;

/**
 * Exhaustively list almost all possible scenarios in promotion activity, because of poor English, I have to add some
 * Chinese comment in some tricky rule types.
 * 
 * @author: chenxi
 */

public enum RuleType {

	/*
	 * buyer range
	 */
	VIP_LEVEL(0, "vip level"), // promotion activity for users who are vip, the discount is according vip level
	NEW_BUYER(1, "new buyer"), // promotion activity for users who register in an app/website
	FIRST_PURCHASE(2, "first purchase"), // promotion activity for users who purchase for the first time
    BIRTHDAY(3, "birthday"), // promotion activity for users who purchase products in his or her birthday
    INVITED(4, "friend inviting"), // promotion activity for users who are invited by an old user in an app/website
    /*
     * partner/shop/product/sku range
     */
    
    // 满N件xx折扣（全场、指定商品、指定SKU等）
    FULL_N_ITEM_OFF(5, "full n items off"), 
    // 满N件减xx元（全场、指定商品、指定SKU等）
    FULL_N_ITEM_REDUCE(6, "full n items reduce"),
    // 满送（全场、指定商品、指定SKU等）
    FULL_N_PRICE_ATTACH(7, "full n price attach product"),
    // 满X元包邮
    FULL_N_PRICE_FREE_LOGISTICS(8, "full n price free logistics fee"), 
    // 满xx元减xx元（全场、指定商品、指定SKU等）
    FULL_N_PRICE_REDUCE(9, "full n price reduce"),
    // 组合销售, A + B搭配销售，支持选配，指定搭配后的价格或折扣，支持同一商品与其他不同商品组合搭配
    COMPOSIT_ITMES(10, "composit items")
    ;
	
	private final int code;
	private final String desc;

	RuleType(int code, String desc) {
		this.code = code;
		this.desc = desc;
    }
	
	public int code() {
		return code;
	}
	
	public String desc() {
		return desc;
	}

    public static RuleType fromCode(int code) {
        for (final RuleType type : RuleType.values()) {
            if (type.code() == code) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return desc();
    }
    
}
