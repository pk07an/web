package com.vdlm.dal.model;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;

/**
 * 商品评论
 *
 */
public class OrderItemComment extends BaseEntityImpl implements Archivable {
	
	private static final long serialVersionUID = 1L;

	private String orderId;
	
	private String orderItemId;

	private String productId;
	
	private String sellerId;
	
	private String buyerId;

	private String content;
	
	private String reply;

	private Integer productScore;
	
	private Boolean archive;
	
	private String code;
	
	private String fakeSkuStr;
	private String commentType;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getProductScore() {
		return productScore;
	}

	public void setProductScore(Integer productScore) {
		this.productScore = productScore;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public Boolean getArchive() {
		return archive;
	}

	@Override
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFakeSkuStr() {
		return fakeSkuStr;
	}

	public void setFakeSkuStr(String fakeSkuStr) {
		this.fakeSkuStr = fakeSkuStr;
	}

	public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}
	
}