package com.vdlm.dal.vo;

public class AreaPair {
	private String id;
	private String name;
	
	public AreaPair(String zoneId, String zoneName) {
		this.setId(zoneId);
		this.setName(zoneName);
	}
	
	public AreaPair() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
