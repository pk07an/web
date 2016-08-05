package com.vdlm.service;

import com.vdlm.dal.model.User;
import com.vdlm.service.error.BizException;

public interface BaseService {

	/**
	 * @throws BizException
	 *             if not logined
	 */
	User getCurrentUser() throws BizException;

}