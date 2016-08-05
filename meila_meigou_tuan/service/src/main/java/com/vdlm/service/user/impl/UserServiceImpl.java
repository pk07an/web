package com.vdlm.service.user.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.meila.dal.slave.dao.UserSlaveDao;
import com.meila.meigou.cachehelper.MeilaCached;
import com.vdlm.dal.mapper.UserMapper;
import com.vdlm.dal.model.Role;
import com.vdlm.dal.model.User;
import com.vdlm.dal.model.UserRole;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.type.PaymentMode;
import com.vdlm.service.common.BaseServiceImpl;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.user.RoleService;
import com.vdlm.service.user.UserService;
import com.vdlm.utils.MD5Util;
import com.vdlm.utils.UniqueNoUtils.UniqueNoType;

@Service("userService")
// service已在applicationContext-service.xml中定义
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	public static final BigInteger STARTPOINT = new BigInteger("5000000001");
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserSlaveDao userSlaveDao;

	@Autowired
	private PasswordEncoder pwdEncoder;

	@Autowired
	private RoleService roleService;

	// 第三方支付的User
	private LinkedHashMap<PaymentMode, String> thirdPartyUsers;

	// 自己平台的账号ID，目前用于分佣
	@Value("${user.id.kkkd}")
	private String userIdKkkd;

	@Override
	public String loadKkkdUserId() {
		return userIdKkkd;
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userMapper.loadByLoginname(username);
		if (u == null)
			throw new UsernameNotFoundException(username);
		return u;
	}

	@Override
	@Transactional
	public User registerAnonymous(String cid, String partner) {
		// 用户的验证
		if (!cid.startsWith(UniqueNoType.CID.name())) {
			throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "非法注册用户");
		}
		User u = userMapper.loadByLoginname(cid);
		if (u != null) {
			return u;
		}
		User user = new User();
		user.setLoginname(cid);
		user.setPartner(partner);
		this.insert(user);
		return user;
	}

	@Override
	@Transactional
	public User register(String phone, String password) {
		// 用户的验证应该放到这里来，否则有安全问题
		User u = userMapper.loadByLoginname(phone);
		if (u != null) {
			if (pwdEncoder.matches(password, u.getPassword())) {
				return u;
			}
			throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "用户[" + phone + "]已经注册，请直接登录或者使用其他的用户名注册");
		}
		User user = new User();
		user.setLoginname(phone);
		user.setPhone(phone);
		user.setPassword(pwdEncoder.encode(password));
		this.insert(user);
		return user;
	}

	@Override
	public boolean isPwdSet() {
		User user = userMapper.selectByPrimaryKey(getCurrentUser().getId());
		return user != null && user.getPassword() != null;
	}

	@Override
	public boolean changePwd(String oldPwd, String newPwd) {
		User sessionUser = getCurrentUser();
		User u = load(sessionUser.getId());

		if (org.apache.commons.lang3.StringUtils.isNotBlank(oldPwd) && !pwdEncoder.matches(oldPwd, u.getPassword())) {
			throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "原密码不正确");
		}

		if (!StringUtils.hasLength(oldPwd) && !StringUtils.hasLength(u.getPassword()) || oldPwd != null
				&& u.getPassword() != null && pwdEncoder.matches(oldPwd, u.getPassword())) {
			newPwd = pwdEncoder.encode(newPwd);
			boolean changed = userMapper.changePwd(u.getId(), newPwd) > 0;
			if (changed)
				u.setPassword(newPwd);
			return changed;
		}
		return false;
	}

	@Override
	public int changePwd(User user) {
		if (StringUtils.hasText(user.getPassword())) {
			// 更新密码
			String password = user.getPassword();
			password = MD5Util.MD5Encode(password, "utf-8").toLowerCase();
			user.setPassword(pwdEncoder.encode(password));
		}
		return userMapper.updateAdmin(user);

	}

	@Override
	public boolean updateUserInfo(User user) {
		if (!getCurrentUser().getId().equals(user.getId()))
			return false;
		return userMapper.updateByPrimaryKeySelective(user) > 0;
	}

	@Override
	public boolean updateByAdmin(User user) {
		return userMapper.updateByPrimaryKeySelective(user) > 0;
	}

	@Override
	public User load(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User loadBySlave(String id) {
		return userSlaveDao.selectByPrimaryKey(id);
	}

	@Override
	public boolean isRegistered(String loginname) {
		return userMapper.countRegistered(loginname) > 0;
	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int delete(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int undelete(String id) {
		return userMapper.undeleteByPrimaryKey(id);
	}

	@Override
	public boolean emptyUserPassword(String mobile) {
		return userMapper.emptyUserPasswordByLoginname(mobile);
	}

	@Override
	public boolean emptyUserPassword(String mobile, String code) {
		// validate mobile and code
		User user = userMapper.loadByLoginname(mobile);
		if (user == null)
			return false;
		String userId = user.getId();
		return userMapper.emptyUserPassword(userId);
	}

	@Override
	public User loadByLoginname(String loginname) {
		return userMapper.loadByLoginname(loginname);
	}

	@Override
	@MeilaCached
	public User loadByCode(String code) {
		return userMapper.loadByCode(code);
	}

	@Override
	public User loadByCodeSlave(String code) {
		return userSlaveDao.loadByCode(code);
	}

	@Override
	public LinkedHashMap<PaymentMode, String> getThirdPartyUsers() {
		return thirdPartyUsers;
	}

	public void setThirdPartyUsers(LinkedHashMap<PaymentMode, String> thirdPartyUsers) {
		this.thirdPartyUsers = thirdPartyUsers;
	}

	@Override
	public int updateNameAndIdCardNumByPrimaryKey(String id, String name, String idCardNum) {
		return userMapper.updateNameAndIdCardNumByPrimaryKey(id, name, idCardNum);
	}

	@Override
	public User registerExtUser(String partner, String slug, String userName, String avatar, String extUserId) {
		// String loginname = extUserId + "@" + partner;
		User u = userMapper.loadByLoginname(slug);
		if (u != null) {
			return u;
		}
		User user = new User();
		user.setId(extUserId);
		user.setLoginname(slug);
		user.setName(userName);
		user.setAvatar(avatar);
		user.setPartner(partner);
		user.setExtUserId(extUserId);
		user.setCode(slug);
		this.insert(user);

		user.setId(IdTypeHandler.encode(Long.parseLong(extUserId)));
		return user;
	}

	@Override
	public int saveWithDrawType(String id, int type) {
		return userMapper.saveWithDrawType(id, type);
	}

	@Override
	public User loadByAdmin(String id) {
		return userMapper.selectByPKAndAdmin(id);
	}

	@Override
	public List<User> getFeeSplitAcct() {
		return userMapper.loadByRoles(2L);
	}

	@Override
	public User selectUserByExtUserId(String extUserId) {
		return userMapper.selectUserByExtUserId(extUserId);
	}

	@Override
	public int updateByCode(User user) {
		return userMapper.updateByCode(user);
	}

	@Override
	public List<User> listUserAdmin(Map<String, Object> params, Pageable page) {
		List<User> listUser = userMapper.selectUserAdmin(params, page);
		for (User uObj : listUser) {
			Role role = roleService.findRoleByUserId(uObj.getId());
			if (role != null) {
				uObj.setRole(role);
				uObj.setRoleName(role.getName());
			}
		}
		return listUser;
	}

	@Override
	public boolean setUserToAdmin(String id) {
		int cnt = userMapper.updateUserToAdmin(id);
		return (cnt == 1 ? true : false);
	}

	@Override
	public int cntAdmin(Map<String, Object> params) {
		return userMapper.selectCntAdmin(params);
	}

	@Override
	public java.util.List<String> getUserFunc(String user_id) {
		return userMapper.selectFunc(user_id);
	}

	@Override
	@Transactional
	public int saveAdmin(User user, UserRole userRole) {
		int cnt = 0;
		User userObj = this.loadByLoginname(user.getLoginname());

		if (userObj != null) {
			userObj.setPhone(user.getPhone());
			if (StringUtils.hasText(user.getPassword())) {
				// 更新密码
				String password = user.getPassword();
				password = MD5Util.MD5Encode(password, "utf-8").toLowerCase();
				userObj.setPassword(pwdEncoder.encode(password));
			}
			userObj.setPartner(pwdEncoder.encode(user.getPassword()));// FIXME
																		// 不懂是谁写的，partner放password的值？by
																		// reese
			userObj.setName(user.getName());
			cnt = userMapper.updateAdmin(userObj);
			long idCode = IdTypeHandler.decode(userObj.getId());
			if (roleService.findRoleByUserId(userObj.getId()) == null) {
				cnt += roleService.bindUserRole(new BigInteger(String.valueOf(idCode)), userRole.getRoleId());
			} else {
				cnt += roleService.updateUserRole(new BigInteger(String.valueOf(idCode)), userRole.getRoleId());
			}
		} else {
			userObj = new User();
			// user.setId(null);
			user.setId(String.valueOf(userMapper.selectMinId() - 1));// 生成vdlm_user的id，由于此id不是自增长，故取表中最小id
																		// 减1作为将插入user的id
																		// ,不考虑
																		// -1后为0的情况
																		// by
																		// reese
			user.setLoginname(user.getLoginname());
			user.setPhone(user.getPhone());
			String password = user.getPassword();
			password = MD5Util.MD5Encode(password, "utf-8").toLowerCase();
			user.setPassword(pwdEncoder.encode(password));
			cnt = this.insert(user);

			/*
			 * cnt += userMapper.updateUserToAdmin(user.getId()); long idCode =
			 * IdTypeHandler.decode(user.getId()); BigInteger bigId =
			 * STARTPOINT.add(new BigInteger(String.valueOf(idCode)));
			 * userMapper.updateAdminPrimaryKey(bigId, user.getId()); //bind
			 * user and role roleService.bindUserRole(bigId,
			 * userRole.getRoleId());
			 */
			// add by reese 2015-7-27
			String id = IdTypeHandler.encode(Long.parseLong(user.getId()));
			cnt += userMapper.updateUserToAdmin(id);
			roleService.bindUserRole(new BigInteger(user.getId()), userRole.getRoleId());

		}

		return cnt;
	}

	@Override
	public int cntUserByPhone(String phone, String id) {
		return userMapper.countUserByPhone(phone, id);
	}

	@Override
	public Map<String, User> selectUserByIds(List<String> userIds) {
		List<User> userList = userMapper.selectUserByIds(userIds);
		Map<String, User> userMap = new HashMap<String, User>();

		for (User user : userList) {
			userMap.put(user.getId(), user);
		}

		return userMap;
	}

}
