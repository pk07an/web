package com.vdlm.dal.model.promotion;

/**
 *
 * @author: chenxi
 */

public enum CouponCodeType {

	COMMON("common code"),
	PRODUCT("bind with product"),
    PRODUCT_TIME("bind with product plus time restrictions "),
    PRIVILEGE("privilege")
    ;
	
	private final String desc;

	CouponCodeType(String desc) {
		this.desc = desc;
    }
	
	public String desc() {
		return desc;
	}

    public static CouponCodeType fromOrdinal(int ordinal) {
        for (final CouponCodeType type : CouponCodeType.values()) {
            if (type.ordinal() == ordinal) {
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
