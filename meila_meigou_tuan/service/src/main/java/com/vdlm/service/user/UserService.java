package com.vdlm.service.user;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;

import com.vdlm.dal.model.User;
import com.vdlm.dal.model.UserRole;
import com.vdlm.dal.type.PaymentMode;
import com.vdlm.service.ArchivableEntityService;

/**
 * @author jamesp
 * 
 */
@Validated
public interface UserService extends UserDetailsService, ArchivableEntityService<User> {

	User registerAnonymous(String cid, String partner);
	
	/**
	 * 手机号码注册，若已存在，直接返回该对象
	 * 
	 * @param loginname
	 */
	User register(@NotNull String loginname, String password);
	
	// public User registerExtUser(String partner, String slug, String userName, String avatar,String extUserId)
	User registerExtUser(String partner, String slug, String userName, String avatar,String extUserId);

	/**
	 * 
	 * @param username
	 * @param oldPwd
	 *            can be null
	 * @param newPwd
	 *            not null
	 * @return changed?
	 */
	boolean changePwd(String oldPwd, String newPwd);

    int changePwd(User user);

	/**
	 * @return 当前用户是否已设置密码
	 */
	boolean isPwdSet();

	/**
	 * 管理员更新用户信息 （姓名，身份证号码， 店铺id)
	 * @param user
	 * @return
	 */
	boolean updateByAdmin(User user);
	
	/**
	 * 用户自己更新用户姓名，身份证号码
	 * @param user
	 * @return
	 */
	boolean updateUserInfo(User user);

	/**
	 * 用户是否已注册
	 */
	boolean isRegistered(String loginname);
	
	/**
	 * 用户是否已注册
	 */
	User loadByLoginname(String loginname);
	
	User loadByCode(String code);
	
	boolean emptyUserPassword(String mobile);
	
	boolean emptyUserPassword(String mobile, String code);
	
	String loadKkkdUserId();
	
	LinkedHashMap<PaymentMode, String> getThirdPartyUsers();
	
	int updateNameAndIdCardNumByPrimaryKey(String id, String name, String idCardNum);

	int saveWithDrawType(String id, int type);

	User loadByAdmin(String id);
	
	List<User> getFeeSplitAcct();
	
	
	User selectUserByExtUserId(String extUserId);

	int updateByCode(User user);
	
	/**
	 * 取用户所有的功能点
	 * @param user_id
	 * @return
	 */
	java.util.List<String> getUserFunc(String user_id);

	
	/**
	 * 以下为运营角色管理
	 * @param params
	 * @param page
	 * @return
	 */
    List<User>	listUserAdmin(Map<String,Object> params,Pageable page);
    
    boolean  setUserToAdmin(String id);
    
    int cntAdmin(Map<String,Object> params) ;
    
    int saveAdmin(User user,UserRole userRole);

    /**
     * 查找user表中存在该phone的用户数
     * @param phone
     * @return
     */
    int cntUserByPhone(String phone,String id);

    /**
     * 根据id查询用户(批量)
     * @param userIs
     * @return
     */
	Map<String, User> selectUserByIds(List<String> userIs);

    User loadBySlave(String id);

    User loadByCodeSlave(String code);

}