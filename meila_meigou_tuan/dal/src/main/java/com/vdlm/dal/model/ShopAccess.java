package com.vdlm.dal.model;

import java.util.Date;

import com.vdlm.dal.BaseEntityImpl;

public class ShopAccess extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private Date date;

	private Integer hour;

	private Integer pv;

	private String userId;

	private String shopId;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId == null ? null : shopId.trim();
	}
}