package com.vdlm.dal.model;

/**
 *
 * @author: chenxi
 */

public class RangeIdPair {

	private final ObjectRange range;
	private final String id;
	
	public RangeIdPair(ObjectRange range, String id) {
		this.range = range;
		this.id = id;
	}

	public ObjectRange getRange() {
		return range;
	}

	public String getId() {
		return id;
	}
	
}
