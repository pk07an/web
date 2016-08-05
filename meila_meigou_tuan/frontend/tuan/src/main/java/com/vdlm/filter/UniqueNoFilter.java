package com.vdlm.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;
import com.vdlm.dal.model.User;
import com.vdlm.dal.model.UserSigninLog;
import com.vdlm.service.user.UserService;
import com.vdlm.service.userAgent.UserSigninLogService;
import com.vdlm.service.userAgent.impl.UserSigninLogFactory;

public class UniqueNoFilter extends OncePerRequestFilter {

	public static final String CLIENT_ID = "vd_cid";

    private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	    String requestURI = request.getRequestURI();

	    // access trace log
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if (principal != null && principal instanceof User) {
            User user = (User)principal;
            String trace = "TRACE: user[" + user.getLoginname() + "] : " + requestURI;
            if (StringUtils.isNotEmpty(request.getQueryString())) {
                trace += "?" + request.getQueryString();
            }
            log.info(trace);
        } else {
            String trace = "TRACE: anonymouse user access: " + requestURI;
            if (StringUtils.isNotEmpty(request.getQueryString())) {
                trace += "?" + request.getQueryString();
            }
            log.info(trace);
        }
        log.info("Params: " + JSON.toJSONString(request.getParameterMap()));

//	    List<String> whiteList = new ArrayList<String>();
//	    whiteList.add("/");
//
//	    List<String> whitePrefixList = new ArrayList<String>();
////	    whitePrefixList.add("/xiangqu/");
//	    whitePrefixList.add("/cart");
//	    whitePrefixList.add("/order");
//	    // whitePrefixList.add("/p/");
//
//	    boolean inWhiteList = false;
//	    for (String wlist : whiteList) {
//            if (requestURI.equals(wlist)) {
//                inWhiteList = true;
//            }
//        }
//	    if (!inWhiteList) {
//	        for (String wlist : whitePrefixList) {
//	            if (requestURI.startsWith(wlist)) {
//	                inWhiteList = true;
//	            }
//	        }
//	    }

//        if ("xiangqu".equals(request.getParameter("partner"))) {
//            inWhiteList = true;
//        }

//        if ((principal == null || !(principal instanceof User)) && inWhiteList) {
//            Cookie[] cookies = request.getCookies();
//            boolean existCid = false;
//            if (cookies != null) {
//                for (Cookie cookie : cookies) {
//                    if (cookie.getName().equals(CLIENT_ID) && cookie.getValue() != null) {
//                        existCid = true;
//                        // 匿名用户自动登录
//                        log.warn("user auto login by cookie " + cookie.getValue());
//                        setCurrentUser(cookie.getValue(), request.getParameter("partner"), request);
//                        break;
//                    }
//                }
//            }
//            if (!existCid) {
//                String newCid = UniqueNoUtils.next(UniqueNoType.CID);
//                Cookie newCookie = new Cookie(CLIENT_ID, newCid);
//                newCookie.setMaxAge(Integer.MAX_VALUE);
//                newCookie.setPath("/");
//                response.addCookie(newCookie);
//                request.setAttribute(CLIENT_ID, newCid);
//
//                log.warn("create new user and login by cookie " + newCid);
//                setCurrentUser(newCid, request.getParameter("partner"), request);
//            }
//        }
//        request.getSession().invalidate();
//        request.getSession().getId();

        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
		filterChain.doFilter(request, response);
	}

	private void setCurrentUser(String cid, String partner, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if (principal == null || !(principal instanceof User)) {
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
            UserService userService = (UserService) webApplicationContext.getBean("userService");
            User user = userService.loadByLoginname(cid);
            if (user == null) {
                user = userService.registerAnonymous(cid, partner);
            }
            Authentication auth1 = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth1);

            //记录用户登录环境Log
            UserSigninLog log = UserSigninLogFactory.createUserSigninLog(request, user);
            UserSigninLogService userSigninLogService = (UserSigninLogService) webApplicationContext.getBean("userSigninLogService");
            userSigninLogService.insert(log);
        }
    }

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
}
