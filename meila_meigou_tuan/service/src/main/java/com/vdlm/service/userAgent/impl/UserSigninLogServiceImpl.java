package com.vdlm.service.userAgent.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdlm.dal.mapper.UserSigninLogMapper;
import com.vdlm.dal.model.UserSigninLog;
import com.vdlm.service.userAgent.UserSigninLogService;

@Service("userSigninLogService")
public class UserSigninLogServiceImpl implements UserSigninLogService {
	
	@Autowired
	UserSigninLogMapper userSigninLogMapper;
	
	@Override
	public void insert(UserSigninLog userSigninLog){
		userSigninLogMapper.insert(userSigninLog);
	}
}
