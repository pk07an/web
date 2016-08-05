package com.vdlm.dal.model;

/**
 *
 * @author: chenxi
 */

public enum ObjectRange {

	PARTNER(1, "partner"),
	SHOP(10, "shop"),
	CATEGORY(100, "category"),
    PRODUCT(1000, "product"),
    SKU(2000, "sku"),
	BUYER(3000, "buyer"),
//    ORDER("order")
    ;
	
	private final int code;
	private final String desc;

	ObjectRange(int code, String desc) {
		this.code = code;
		this.desc = desc;
    }
	
	public int code() {
		return code;
	}
	
	public String desc() {
		return desc;
	}

    public static ObjectRange fromCode(int code) {
        for (final ObjectRange range : ObjectRange.values()) {
            if (range.code() == code) {
                return range;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return desc();
    }
    
}
