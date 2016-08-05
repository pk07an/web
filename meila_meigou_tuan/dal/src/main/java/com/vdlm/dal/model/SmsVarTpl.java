package com.vdlm.dal.model;

import java.util.Date;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;

public class SmsVarTpl extends BaseEntityImpl implements Archivable {

	private static final long serialVersionUID = 1L;
	private String varName;
	private String varNote;
	private Boolean archive;
	private Date createdAt;
	private Date updatedAt;
	
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public String getVarNote() {
		return varNote;
	}
	public void setVarNote(String varNote) {
		this.varNote = varNote;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
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
}
