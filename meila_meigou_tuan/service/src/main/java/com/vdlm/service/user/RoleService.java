package com.vdlm.service.user;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Role;


public interface RoleService {

	 List<Role> listAllRole();
	
	 int bindUserRole(@Param("userId") BigInteger userId,@Param("roleId") String roleId);
	 
	 int updateUserRole(@Param("userId")BigInteger userId,@Param("roleId") String roleId);
	 
	  Role findRoleByUserId(@Param("userId") String userId);
}
