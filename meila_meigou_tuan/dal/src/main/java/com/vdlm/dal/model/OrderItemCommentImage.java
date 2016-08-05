package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class OrderItemCommentImage extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;
	
	private String commentId;
	private String img;
	private Integer imgWidth;
	private Integer imgHeight;
	private Integer imgOrder;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getImgOrder() {
		return imgOrder;
	}

	public void setImgOrder(Integer imgOrder) {
		this.imgOrder = imgOrder;
	}

	public Integer getImgWidth() {
		return imgWidth;
	}

	public void setImgWidth(Integer imgWidth) {
		this.imgWidth = imgWidth;
	}

	public Integer getImgHeight() {
		return imgHeight;
	}

	public void setImgHeight(Integer imgHeight) {
		this.imgHeight = imgHeight;
	}

}
