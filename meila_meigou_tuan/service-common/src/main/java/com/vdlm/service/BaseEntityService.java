package com.vdlm.service;

import com.vdlm.dal.BaseEntity;

public interface BaseEntityService<E extends BaseEntity> extends BaseService {

	/**
	 * 检查默认的not null，和default value等约束要求，
	 */
	int insert(E e);

	E load(String id);


}
