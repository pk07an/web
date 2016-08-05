package com.vdlm.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vdlm.biz.authentication.LoginStrategy;
import com.vdlm.dal.model.User;
import com.vdlm.dal.model.UserSigninLog;
import com.vdlm.meila.client.MeilaClient;
import com.vdlm.meila.client.MeilaSimpleUser;
import com.vdlm.service.user.UserService;
import com.vdlm.service.userAgent.UserSigninLogService;
import com.vdlm.service.userAgent.impl.UserSigninLogFactory;

/**
 *
 * @author: chenxi
 */

public class MeilaLoginStrategy implements LoginStrategy {

    private static Logger LOG = LoggerFactory.getLogger(MeilaLoginStrategy.class);
    
    @Autowired
    private MeilaClient meilaClient;
    
    @Autowired
	private UserSigninLogService userSigninLogService;
    
    @Autowired
    private UserService userService;
    
	@Override
	public String buildLoginUrl(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception) {
		// get Authorization header 
		try {
			MeilaSimpleUser mUser = meilaClient.userVerify(request, response);
			if (mUser == null)
				return null;
			// login the user in MP
			User user = null;
			String loginname = String.valueOf(mUser.getSlug());
            user = userService.loadByLoginname(loginname);
            
            if (user == null) {
                user = userService.registerExtUser("meila", loginname, mUser.getNickName(), mUser.getAvatar(),mUser.getId());
            } 
//            request.getSession().invalidate();
            
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            
            //记录用户登录环境Log
            //take notes user signin environment log into table
            UserSigninLog log = UserSigninLogFactory.createUserSigninLog(request, user);
            userSigninLogService.insert(log);

            String actionPath = request.getRequestURI().substring(request.getContextPath().length());
            return "continue:" + actionPath;
		} catch (Exception e) {
			LOG.error("failed to validate session token due to ", e);
			return null;
		}

	}

}
