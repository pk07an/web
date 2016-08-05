package com.vdlm.dal.model.promotion;

/**
 *
 * @author: chenxi
 */

public enum PeriodicityType {

	NO_PERIODICITY(0, "only once"),
	EVERYDAY(1, "everyday periodicity"),
	EVERYWEEK(2, "everyweek periodicity"),
	EVERYMONTH(3, "everymonth periodicity");
	
	private final int code;
	private final String desc;
	
	PeriodicityType(int code, String desc) {
		this.code = code;
		this.desc = desc;
    }
	
	public int code() {
		return code;
	}
	
	public String desc() {
		return desc;
	}

    public static PeriodicityType fromCode(int code) {
        for (final PeriodicityType type : PeriodicityType.values()) {
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
