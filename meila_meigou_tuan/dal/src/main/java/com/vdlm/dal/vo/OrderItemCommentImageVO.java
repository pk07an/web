package com.vdlm.dal.vo;

import com.vdlm.dal.model.OrderItemCommentImage;

public class OrderItemCommentImageVO extends OrderItemCommentImage {

	private static final long serialVersionUID = 1L;
	
	private String imgUrl;

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
