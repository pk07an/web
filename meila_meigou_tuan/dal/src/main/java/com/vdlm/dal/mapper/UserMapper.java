package com.vdlm.dal.mapper;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.User;
import com.vdlm.dal.model.Role;

public interface UserMapper {
	int deleteByPrimaryKey(String id);

	int undeleteByPrimaryKey(String id);

	int insert(User record);

	User selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	int countRegistered(String mobile);

	User loadByLoginname(String loginname);

	User loadByCode(String code);
	
	int changePwd(@Param("id") String uid, @Param("newPwd") String newPwd);

	boolean emptyUserPassword(@Param("id") String userId);

	boolean emptyUserPasswordByLoginname(@Param("loginname") String loginname);
	
	int updateNameAndIdCardNumByPrimaryKey(@Param("id") String id, @Param("name") String name, @Param("idCardNum") String idCardNum);
	
	int saveWithDrawType(@Param("id")String id, @Param("type")int type);

	User selectByPKAndAdmin(String id);
	
	List<User> loadByRoles(Long roles);
	
	User selectUserByExtUserId(String ext_user_id);
	
	int updateByCode(User user);

	/**
	 * 取用户权限
	 * @param uid
	 * @return
	 */
	List<String> selectFunc(@Param("id") String uid);
	
	List<User> selectUserAdmin(@Param("params") Map<String,Object> params,@Param("pager") Pageable page);
		
	int selectCntAdmin(@Param("params") Map<String,Object> params);

	int updateUserToAdmin(String id);
	
	int updateAdmin(User user);
	
	List<Role> selectUserRoleList(@Param("id") String uid);
	
	int updateAdminPrimaryKey(@Param("bigId") BigInteger bigId,@Param("id") String id);

    int selectMinId();//选取最小id by reese 2015-7-27

    int countUserByPhone(@Param("phone")String phone,@Param("id")String id);//通过phone查找数据库中是否存在  by reese 2015-7-27

    /**
     * 根据id批量查询user
     * @param userIs
     * @return
     */
	List<User> selectUserByIds(@Param("userIds") List<String> userIds);

}