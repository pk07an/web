package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.HelperMessage;

public interface HelperMessageMapper {
	
	List<HelperMessage> selectAll(@Param(value="page") Pageable page);
	
	int insert(@Param(value="params") HelperMessage record, @Param(value="icon") String icon);
	
	int update(@Param(value="params") HelperMessage record, @Param(value="id") String id, @Param(value="icon") String icon);
	
	Boolean delete(String id);
	
	List<HelperMessage> listMessageByAdmin(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);
	
	Long countMessageByAdmin(@Param(value="params") Map<String, Object> params);
}
