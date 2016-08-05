package com.vdlm.meila.client;

import com.vdlm.meila.client.MeilaUser;

public class MeilaProductRecommendation {
	private String description;// 描述
	
	private MeilaUser user=new MeilaUser();// 推荐人信息

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MeilaUser getUser() {
		return user;
	}

	public void setUser(MeilaUser user) {
		this.user = user;
	}

}
