package com.vdlm.dal;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.vdlm.dal.mybatis.IdTypeHandler;

public abstract class BaseEntityImpl implements BaseEntity {
	private static final long serialVersionUID = 1L;
	private String id;
	private long idRaw = -1;
	private Date createdAt;//插入逻辑在mysql实现，只查询
	private Date updatedAt;//更新逻辑在mysql实现，只查询

	public String getId() {
		if (StringUtils.isBlank(id) && idRaw > 0)
			id = IdTypeHandler.encode(idRaw);
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	long getIdRaw() {
		return idRaw;
	}

	void setIdRaw(long idRaw) {
		this.idRaw = idRaw;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
}
