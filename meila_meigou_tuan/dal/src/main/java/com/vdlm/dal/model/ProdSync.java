package com.vdlm.dal.model;

import java.math.BigDecimal;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;

public class ProdSync extends BaseEntityImpl implements Archivable {

	private static final long serialVersionUID = 1L;
	
	private String shopId;
	
	private String name;
	
	private Boolean archive;
	
	private Boolean synced;
	
	private String unionId;
	
	private BigDecimal commissionRate;
	
	private String auditSts;
	
	private String auditNote;
	
	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public Boolean getSynced() {
		return synced;
	}

	public void setSynced(Boolean synced) {
		this.synced = synced;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public BigDecimal getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(BigDecimal commissionRate) {
		this.commissionRate = commissionRate;
	}

	public String getAuditSts() {
		return auditSts;
	}

	public void setAuditSts(String auditSts) {
		this.auditSts = auditSts;
	}

	public String getAuditNote() {
		return auditNote;
	}

	public void setAuditNote(String auditNote) {
		this.auditNote = auditNote;
	}

}
