package com.vdlm.dal.model;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;

public class Zone extends BaseEntityImpl implements Archivable {
	
	private static final long serialVersionUID = 1L;

	private String name;

    private String zipCode;

    private String path;
    
    private String parentId;
    
    private String zoneTag;
    
    private Boolean archive;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public Boolean getArchive() {
		return archive;
	}

	@Override
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getZoneTag() {
		return zoneTag;
	}

	public void setZoneTag(String zoneTag) {
		this.zoneTag = zoneTag;
	}
}
