package com.vdlm.dal.meilavo;

import java.util.List;

public class MeiLaOrderItemCommentVO {

	private String orderId;
	private String sellerId;
	
	private List<MeiLaSaveOrderItemCommentVO> item;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public List<MeiLaSaveOrderItemCommentVO> getItem() {
		return item;
	}

	public void setItem(List<MeiLaSaveOrderItemCommentVO> item) {
		this.item = item;
	}

}
