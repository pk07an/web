package com.vdlm.service.userAgent.impl;

import javax.servlet.http.HttpServletRequest;

import com.vdlm.dal.model.User;
import com.vdlm.dal.model.UserSigninLog;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

public class UserSigninLogFactory {
	
	public static UserSigninLog createUserSigninLog(HttpServletRequest request, User user){
		return parse(request, user);
	}
	
	private static UserSigninLog parse(HttpServletRequest request, User user){
		String ua = request.getHeader("User-Agent");
		String ip = getIpAddr(request);
		UserAgent userAgent = UserAgent.parseUserAgentString(ua);
		Browser browser = userAgent.getBrowser();
		OperatingSystem os = userAgent.getOperatingSystem();
//		DeviceType client = os.getDeviceType();
		UserSigninLog userSigninLog = new UserSigninLog();
		userSigninLog.setUserId(user.getId());
		userSigninLog.setIp(ip);
		userSigninLog.setClient(ua);
		userSigninLog.setBrowser(browser.toString());
		userSigninLog.setOs(os.toString());
		userSigninLog.setPartner(user.getPartner());
		return userSigninLog;
	}
	
	private static String getIpAddr(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for");    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("WL-Proxy-Client-IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("HTTP_CLIENT_IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getRemoteAddr();    
        }    
        return ip; 
	}
}
