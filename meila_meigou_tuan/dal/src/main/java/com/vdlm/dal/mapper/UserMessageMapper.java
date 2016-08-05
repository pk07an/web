package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.UserMessage;
import com.vdlm.dal.status.UserMessageStatus;

public interface UserMessageMapper {

	void insert(UserMessage um);
	
	UserMessage selectByPrimaryKey(String id);

	void updateUserMessageStatus(@Param("id")String id, @Param("status")UserMessageStatus status);

	List<UserMessage> selectByReceiver(String userId);

	List<UserMessage> selectBySender(String userId);

	List<UserMessage> selectByUser(String userId);

}
