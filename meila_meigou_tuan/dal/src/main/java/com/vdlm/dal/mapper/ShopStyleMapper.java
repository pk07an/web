package com.vdlm.dal.mapper;

import com.vdlm.dal.model.ShopStyle;

public interface ShopStyleMapper {

	ShopStyle selectByPrimaryKey(String id);

	int insert(ShopStyle ss);

	int update(ShopStyle ss);
	
}
