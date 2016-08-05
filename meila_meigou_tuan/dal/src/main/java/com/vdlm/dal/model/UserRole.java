package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class UserRole extends BaseEntityImpl{

	
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  String userId;
	
      private  String roleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
  	
	
	
}
