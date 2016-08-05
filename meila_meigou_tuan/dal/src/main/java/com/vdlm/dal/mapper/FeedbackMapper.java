package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.Feedback;
import com.vdlm.dal.status.FeedbackStatus;
import com.vdlm.dal.vo.FeedbackVO;

public interface FeedbackMapper {
	
	Feedback selectByPrimaryKey(String id);
	
	int insert(Feedback record);
	
	int updateForClosed(String id,String replay, @Param("status")FeedbackStatus status);
	
	List<FeedbackVO> listFeedbacksByAdmin(@Param(value="params")Map<String, Object> params, @Param(value="page") Pageable page); 
	
	Long countFeedbacksByAdmin(@Param(value="params")Map<String, Object> params);

}