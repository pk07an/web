package com.vdlm.dal.vo;

import com.vdlm.dal.model.Feedback;

public class FeedbackVO extends Feedback {

	private static final long serialVersionUID = 1L;
	
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
