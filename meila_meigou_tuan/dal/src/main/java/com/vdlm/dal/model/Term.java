package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class Term extends BaseEntityImpl {
	
	private static final long serialVersionUID = 5499098729123662464L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
