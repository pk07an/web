package com.vdlm.dal.model.promotion;

/**
 *
 * @author: chenxi
 */

public enum PromotionActionType {

	REDUCE(1, "reduce price"),
	OFF(2, "price off"),
	FREE_LOGISTICS_FEE(3, "free logistics fee"),
	ATTACH(4, "attach product/sku"),
	COUPON(5, "use coupon"),
	
	MIX(99, "mix action supporting almost cases");
	
	private final int code;
	private final String desc;

	PromotionActionType(int code, String desc) {
		this.code = code;
		this.desc = desc;
    }
	
	public int code() {
		return code;
	}
	
	public String desc() {
		return desc;
	}

    public static PromotionActionType fromCode(int code) {
        for (final PromotionActionType action : PromotionActionType.values()) {
            if (action.code() == code) {
                return action;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return desc();
    }
}
