package com.vdlm.dal.vo;

import com.vdlm.dal.model.OrderItemComment;

public class OrderItemCommentAdmin extends OrderItemComment {
	
	private static final long serialVersionUID = 1L;
	
	private String productName;
	private String orderNum;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
}
