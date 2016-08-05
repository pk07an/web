package com.vdlm.dal.mapper;

import com.vdlm.dal.model.UserAlipay;

public interface UserAlipayMapper {

	public int updateForUnArchive(String id);

	public int updateForArchive(String id);

	public int insert(UserAlipay alipay);

	public UserAlipay selectByPrimaryKey(String id);

	public UserAlipay loadByUserId(String userId);

	public int updateByPrimaryKeySelective(UserAlipay alipay);
}
