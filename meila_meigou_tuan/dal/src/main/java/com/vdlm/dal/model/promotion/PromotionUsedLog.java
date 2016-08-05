package com.vdlm.dal.model.promotion;

import com.vdlm.dal.BaseEntityImpl;

/**
 *
 * @author: chenxi
 */

public class PromotionUsedLog extends BaseEntityImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6654215798629669180L;
	
	private String orderId;
	private String couponId;
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getCouponId() {
		return couponId;
	}
	
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	
	
}
