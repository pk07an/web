package com.vdlm.dal.vo;

import java.math.BigDecimal;
import java.util.Date;

public class XQHomeActProductVO {
	
	private String productId;  //	商品ID
	private BigDecimal oldPrice;  // 原价
	private BigDecimal actPrice;	//	活动价
	private String productTitle; //	商品名称
//	private String productBrand;//	商品品牌
//	private String productTag; //	商品TAG
	private String productDesc; //	推荐理由
	private Date startTime; //	开始时间
	private Date endTime; //	结束时间
	private int soldOut; //	1=在售，2=售罄
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public BigDecimal getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}
	public BigDecimal getActPrice() {
		return actPrice;
	}
	public void setActPrice(BigDecimal actPrice) {
		this.actPrice = actPrice;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
//	public String getProductBrand() {
//		return productBrand;
//	}
//	public void setProductBrand(String productBrand) {
//		this.productBrand = productBrand;
//	}
//	public String getProductTag() {
//		return productTag;
//	}
//	public void setProductTag(String productTag) {
//		this.productTag = productTag;
//	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getSoldOut() {
		return soldOut;
	}
	public void setSoldOut(int soldOut) {
		this.soldOut = soldOut;
	}

}
