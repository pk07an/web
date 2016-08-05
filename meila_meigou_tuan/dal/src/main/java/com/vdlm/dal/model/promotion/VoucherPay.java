package com.vdlm.dal.model.promotion;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.CouponStatus;

public class VoucherPay  extends BaseEntityImpl{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userID;
	
	private String proID ;

	private String voucherID ;
	
	private  BigDecimal discount;
	
	private CouponStatus status;
	
	private String payNO;

	
	public String getUserID() {
		return userID;
	}




	public void setUserID(String userID) {
		this.userID = userID;
	}




	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public CouponStatus getStatus() {
		return status;
	}

	public void setStatus(CouponStatus status) {
		this.status = status;
	}

	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public String getPayNO() {
		return payNO;
	}

	public void setPayNO(String payNO) {
		this.payNO = payNO;
	}

	public String getVoucherID() {
		return voucherID;
	}

	public void setVoucherID(String voucherID) {
		this.voucherID = voucherID;
	}

	
   	
}
