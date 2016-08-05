package com.vdlm.dal.type;

public enum FileStoreKey {
	V1("md_"),
	V2("qn@");

	private FileStoreKey(String key) {
		this.key = key;
	}
	
	private String key;
	
	public String getKey() {
		return key;
	}
}
