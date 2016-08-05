package com.vdlm.meila.client;

import java.util.ArrayList;
import java.util.List;

import com.vdlm.meila.client.MeilaUser;

public class MeilaProductLikeInfo {

	private Boolean is_liked;
	private Integer like_count;
	
	private List<MeilaUser> like_users;

	public Boolean getIs_liked() {
		return is_liked;
	}

	public void setIs_liked(Boolean is_liked) {
		this.is_liked = is_liked;
	}

	public Integer getLike_count() {
		return like_count;
	}

	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
	}

	public List<MeilaUser> getLike_users() {
		if( like_users==null){
		 return new ArrayList<MeilaUser>();	
		}
		
		return like_users;
	}

	public void setLike_users(List<MeilaUser> like_users) {
		this.like_users = like_users;
	}

}
