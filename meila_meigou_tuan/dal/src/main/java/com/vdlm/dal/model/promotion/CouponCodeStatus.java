package com.vdlm.dal.model.promotion;

/**
 *
 * @author: chenxi
 */

public enum CouponCodeStatus {

	UNUSED("unused"),
	FROZEN("frozen, unpaid"),
	USED("used"),
    EXPIRED("expired")
    ;
	
	private final String desc;

	CouponCodeStatus(String desc) {
		this.desc = desc;
    }
	
	public String desc() {
		return desc;
	}

    public static CouponCodeStatus fromOrdinal(int ordinal) {
        for (final CouponCodeStatus status : CouponCodeStatus.values()) {
            if (status.ordinal() == ordinal) {
                return status;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return desc();
    }
    
}
