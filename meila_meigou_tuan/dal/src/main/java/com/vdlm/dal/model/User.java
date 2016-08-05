package com.vdlm.dal.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.utils.UniqueNoUtils.UniqueNoType;

public class User extends BaseEntityImpl implements UserDetails, Archivable {

	private static final long serialVersionUID = 1L;

	/** 后台管理员 */
	public static final long ROLE_ADMIN = 1;
	/** 广告分润联盟 */
	public static final long ROLE_UNION = 1 << 1;
	
	private static final SimpleGrantedAuthority role_auth_admin = new SimpleGrantedAuthority(
			"ROLE_ADMIN");
	private static final SimpleGrantedAuthority role_auth_union = new SimpleGrantedAuthority(
			"ROLE_UNION");

	private String name;//目前等于绑定银行卡时候的姓名

	//美啦 bos role list
	//private java.util.List<Role> roleList =null;
	
	private Role role;//meila bos 角色
	
	private String roleName;
	/**
	 * 是否后台账号，TODO 先简单实现了，有必要在支持UserRole
	 */
	private Long roles;

	private String avatar;

	private String email;

	private String loginname;

	private String phone;

	private String password;

	private Boolean archive;

	private String shopId;
	
	private String idCardNum;
	// 第三方用户提供方
	private String partner;
	// 第三方用户id
	private String extUserId;
	
	private int withdrawType;
	
	private String typeIcon;   // 美啦 卖家认证 by: yongqi 20150612

	private String code;
	
	// add by luojy 20150706
	private long functionSet;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 美啦bos 角色
	 * @return
	 */
	/*
	public java.util.List<Role> getRoleList()
	{
		return this.roleList;
	}
	
	public void setRoleList(java.util.List<Role> list)
	{
		this.roleList = list;
	}
	public String getRoleName()
	{
		StringBuffer buf = new StringBuffer();
		for(int i=0; roleList !=null && i < roleList.size(); i++)
		{
			Role obj = roleList.get(i);
			if(i>0) buf.append(",");
			buf.append(obj.getName());
		}
		return buf.toString();
	}
	*/
	/*** ------ **/

	public Long getRoles() {
		return roles;
	}

	public void setRoles(Long roles) {
		this.roles = roles;
	}

	public boolean hasRole(long role) {
		return roles != null && (roles & role) != 0;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>(2);
		if (hasRole(ROLE_ADMIN))
			auths.add(role_auth_admin);
		if (hasRole(ROLE_UNION))
			auths.add(role_auth_union);
		return auths;
	}

	@Override
	public String getUsername() {
		return this.getLoginname() == null ? this.getEmail() : this
				.getLoginname();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

    public String getExtUserId() {
        return extUserId;
    }

    public void setExtUserId(String extUserId) {
        this.extUserId = extUserId;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    @Override
    public String getId() {
        return super.getId();
    }
    
    public boolean isAnonymous() {
        return this.loginname.startsWith(UniqueNoType.CID.name());
    }

	public int getWithdrawType() {
		return withdrawType;
	}

	public void setWithdrawType(int withdrawType) {
		this.withdrawType = withdrawType;
	}

    public String getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(String typeIcon) {
        this.typeIcon = typeIcon;
    }
    
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	// add by luojy 20150706
	public Boolean getFunctionSts(int bit) {
		long result = (1 << bit) & this.functionSet;
		return result > 0 ?  true : false;
	}
	
	
}