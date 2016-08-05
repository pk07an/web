package com.vdlm.dal.model;

import java.math.BigDecimal;

public class ThirdCommission {
	
	private String thirdId;
	private String thirdPartner;
	private String auditSts;
	private BigDecimal commissionRate;
	private String failedReason;
	
	public String getThirdId() {
		return thirdId;
	}
	public void setThirdId(String thirdId) {
		this.thirdId = thirdId;
	}
	public String getThirdPartner() {
		return thirdPartner;
	}
	public void setThirdPartner(String thirdPartner) {
		this.thirdPartner = thirdPartner;
	}
	public String getAuditSts() {
		return auditSts;
	}
	public void setAuditSts(String auditSts) {
		this.auditSts = auditSts;
	}
	public BigDecimal getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(BigDecimal commissionRate) {
		this.commissionRate = commissionRate;
	}
	public String getFailedReason() {
		return failedReason;
	}
	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}
	
	 
}
