package com.vdlm.service.user.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdlm.dal.mapper.RoleMapper;
import com.vdlm.dal.model.Role;
import com.vdlm.service.user.RoleService;
@Service
public class RolesServiceImpl implements RoleService{

	
	@Autowired
	public  RoleMapper roleMapper;
	
	
	@Override
	public List<Role> listAllRole() {
		
		return roleMapper.findAllRoles();
	}

	@Override
	public int bindUserRole(BigInteger userId, String roleId) {
		return roleMapper.insertUserRole(userId,roleId);
	}

	@Override
	public int updateUserRole(BigInteger userId, String roleId) {
		return roleMapper.updateUserRole(userId,roleId);
	}

	@Override
	public Role findRoleByUserId(String userId) {
		return roleMapper.findRoleByUserId(userId);
	}

	
	
}
