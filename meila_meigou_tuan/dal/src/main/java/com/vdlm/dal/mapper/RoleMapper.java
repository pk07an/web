package com.vdlm.dal.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Role;
public interface RoleMapper {
	
	 List<Role>  findAllRoles();
	 
	 int insertUserRole(@Param("userId") BigInteger userId,@Param("roleId") String roleId);
	 
	 int updateUserRole(@Param("userId") BigInteger userId,@Param("roleId") String roleId);
	 
	 Role findRoleByUserId(@Param("userId") String userId);  
}
