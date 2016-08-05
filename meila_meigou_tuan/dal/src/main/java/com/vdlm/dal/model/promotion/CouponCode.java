package com.vdlm.dal.model.promotion;

import java.util.Date;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.model.ObjectRange;

/**
 * This class is stand for all types of coupon like object with a special string code like xiaomi F code to determine whether
 * a user have an authorization to purchase an product.
 *
 * @author: chenxi
 */

public class CouponCode extends BaseEntityImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4131813309720547695L;
	
	private String partner;
	// FIXME need it?
	private CouponCodeType type;
	/**
	 * see objId field in {@link PromotionModel}
	 */
	private String objId; // optional
	/**
	 * see range field in {@link PromotionModel}
	 */
	private ObjectRange range;  
	/**
	 * optional, buyer
	 */
	private String userId; 
	/**
	 * optional, the start date of the coupon
	 */
	private Date start;
	/**
	 * optional, the end date of the coupon
	 */
	private Date end;
	/**
	 * whether the coupon can be only used once
	 */
	private boolean onlyOnce;
	/**
	 * the string coupon code value
	 */
	private String value;
	/**
	 * the status of this coupon 
	 */
	private CouponCodeStatus status;
	
	public String getPartner() {
		return partner;
	}
	
	public void setPartner(String partner) {
		this.partner = partner;
	}
	
	public CouponCodeType getType() {
		return type;
	}
	
	public void setType(CouponCodeType type) {
		this.type = type;
	}
	
	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public ObjectRange getRange() {
		return range;
	}

	public void setRange(ObjectRange range) {
		this.range = range;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public boolean isOnlyOnce() {
		return onlyOnce;
	}

	public void setOnlyOnce(boolean onlyOnce) {
		this.onlyOnce = onlyOnce;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CouponCodeStatus getStatus() {
		return status;
	}
	
	public void setStatus(CouponCodeStatus status) {
		this.status = status;
	}
	
}
