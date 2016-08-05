package com.vdlm.dal.vo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vdlm.dal.model.OrderItemComment;
import com.vdlm.dal.util.json.JsonResourceUrlSerializer;

public class OrderItemCommentVO extends OrderItemComment{

	private static final long serialVersionUID = 1L;

	private String buyerAvatar;
	
	private String buyerNick;
	
	private String buyerCode;
	
	private String sellerAvatar;
	
	private String sellerNick;
	
	@JsonSerialize(using = JsonResourceUrlSerializer.class)
	private String productImgUrl;
	
	private BigDecimal price;
	
	private String skuStr;
	
	private Integer amount;
	
	private String commentAt;
	
	private String replyAt;
	
	private List<OrderItemCommentImageVO> images;
	
	private String buyerLevel;

	public String getBuyerAvatar() {
		return buyerAvatar;
	}

	public void setBuyerAvatar(String buyerAvatar) {
		this.buyerAvatar = buyerAvatar;
	}

	public String getBuyerNick() {
		return buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public String getSellerAvatar() {
		return sellerAvatar;
	}

	public void setSellerAvatar(String sellerAvatar) {
		this.sellerAvatar = sellerAvatar;
	}

	public String getSellerNick() {
		return sellerNick;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public String getSkuStr() {
		return skuStr;
	}

	public void setSkuStr(String skuStr) {
		this.skuStr = skuStr;
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCommentAt() {
		return DateFormatUtils.format(this.getCreatedAt(), "yyyy-MM-dd HH:mm:ss");
	}

	public String getReplyAt() {
		if(StringUtils.isBlank(this.getReply())){
			return "";
		}
		return DateFormatUtils.format(this.getUpdatedAt(), "yyyy-MM-dd HH:mm:ss");
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<OrderItemCommentImageVO> getImages() {
		return images;
	}

	public void setImages(List<OrderItemCommentImageVO> images) {
		this.images = images;
	}

	public String getBuyerCode() {
		return buyerCode;
	}

	public void setBuyerCode(String buyerCode) {
		this.buyerCode = buyerCode;
	}

	public void setCommentAt(String commentAt) {
		this.commentAt = commentAt;
	}

	public void setReplyAt(String replyAt) {
		this.replyAt = replyAt;
	}

	public String getBuyerLevel() {
		return buyerLevel;
	}

	public void setBuyerLevel(String buyerLevel) {
		this.buyerLevel = buyerLevel;
	}
}
