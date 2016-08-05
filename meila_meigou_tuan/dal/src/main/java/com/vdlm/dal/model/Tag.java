package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class Tag extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String tag;
	
	private String creatorId;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Tag tag = (Tag) obj;
		if (this.getTag().equals(tag.getTag()))
			return true;

		return false;
	}

	public int hashCode() {
		Tag tag = (Tag) this;
		return tag.getTag().hashCode();
	}

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
}
