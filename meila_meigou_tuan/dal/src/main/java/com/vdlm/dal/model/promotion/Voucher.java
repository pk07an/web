package com.vdlm.dal.model.promotion;

import java.math.BigDecimal;

import com.vdlm.dal.BaseEntity;
import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.VoucherStatus;

public class Voucher extends BaseEntityImpl {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String proID;	
	
	private String title;	
	
	private BigDecimal discount;
	
	private double platFormRatio;
	
	private VoucherStatus status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public VoucherStatus getStatus() {
		return status;
	}

	public void setStatus(VoucherStatus status) {
		this.status = status;
	}

	public double getPlatFormRatio() {
		return platFormRatio;
	}

	public void setPlatFormRatio(double platFormRatio) {
		this.platFormRatio = platFormRatio;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	
}
