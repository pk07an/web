package com.vdlm.dal.model;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;

public class OrderRefundAttach extends BaseEntityImpl implements Archivable {

	private static final long serialVersionUID = 1L;

	private String refundId;

    private Integer type;

    private String attachKey;
    
    private Boolean archive;

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAttachKey() {
        return attachKey;
    }

    public void setAttachKey(String attachKey) {
        this.attachKey = attachKey == null ? null : attachKey.trim();
    }

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
}