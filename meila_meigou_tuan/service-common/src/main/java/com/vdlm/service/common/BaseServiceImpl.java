package com.vdlm.service.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vdlm.dal.model.User;
import com.vdlm.service.BaseService;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;

public abstract class BaseServiceImpl implements BaseService {
	
	protected Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 获取当前用户信息
	 * 如果是未登录的匿名用户，系统根据匿名用户唯一码自动创建一个用户
	 * 具体逻辑查看：UniqueNoFilter
	 * @return
	 */
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			Object principal = auth.getPrincipal();
			if (principal instanceof User)
				return (User) principal;
			if (auth.getClass().getSimpleName().indexOf("Anonymous") < 0)
				log.error("Unknown authentication encountered, ignore it. " + auth);
		}
//		User user=new User();
//        user.setId("92730c6d");
//        user.setAvatar("/FjX5-lK3lutMCSCyR-VlyuzMZlT3?imageMogr/v2/thumbnail/150");
//        return user;
		throw new BizException(GlobalErrorCode.UNAUTHORIZED, "need login first.");
	}
	
//	public User getCurrentUser(boolean persist) {
//	    
//	}
}