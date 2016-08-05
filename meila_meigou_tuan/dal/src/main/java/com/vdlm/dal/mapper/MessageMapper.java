package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.Message;

public interface MessageMapper {
	
	int insert(Message record);

	Message selectByPrimaryKey(String id);

	List<Message> listMessageByAdmin(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);
	
	Long countMessageByAdmin(@Param(value="params")Map<String, Object> params);
}
