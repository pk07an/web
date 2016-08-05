package com.vdlm.dal.mapper;

import org.springframework.dao.DuplicateKeyException;

import com.vdlm.dal.model.TinyUrl;


public interface TinyUrlMapper {

	int insert(TinyUrl url) throws DuplicateKeyException;

	TinyUrl selectByPrimaryKey(String key);
	
	TinyUrl selectByUrl(String url);
	
}
