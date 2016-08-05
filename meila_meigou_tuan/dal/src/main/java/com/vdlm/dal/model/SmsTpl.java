package com.vdlm.dal.model;

import java.util.Date;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;

public class SmsTpl extends BaseEntityImpl implements Archivable {

	private static final long serialVersionUID = 1L;
	private String smsEvent;
	private String countryCode;
	private String formatVar;
	private String content;
	private String planForm;
	private String status;
	private Boolean archive;
	private Date createdAt;
	private Date updatedAt;
	
	public String getSmsEvent() {
		return smsEvent;
	}

	public void setSmsEvent(String smsEvent) {
		this.smsEvent = smsEvent;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getFormatVar() {
		return formatVar;
	}

	public void setFormatVar(String formatVar) {
		this.formatVar = formatVar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPlanForm() {
		return planForm;
	}

	public void setPlanForm(String planForm) {
		this.planForm = planForm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getArchive() {
		return archive;
	}
	
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

}
