package com.vdlm.dal.vo;

import java.math.BigDecimal;
import java.util.Date;


public class MsgProdInfoVO {
	private String prodImg;
	private String prodName;
	private String skuDesc;
	private Date paidAt; 
	private BigDecimal paidFee;
	public String getProdImg() {
		return prodImg;
	}
	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getSkuDesc() {
		return skuDesc;
	}
	public void setSkuDesc(String skuDesc) {
		this.skuDesc = skuDesc;
	}
	public Date getPaidAt() {
		return paidAt;
	}
	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}
	public BigDecimal getPaidFee() {
		return paidFee;
	}
	public void setPaidFee(BigDecimal paidFee) {
		this.paidFee = paidFee;
	}
	
}
