package com.vdlm.meila.client;

import com.vdlm.dal.model.User;

public class MeilaSimpleUser {

	private String id;
	private String slug;
	private String nickName;
	private String avatar;

	private User vdlmUser;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

    public User getVdlmUser() {
        return vdlmUser;
    }

    public void setVdlmUser(User vdlmUser) {
        this.vdlmUser = vdlmUser;
    }
}
