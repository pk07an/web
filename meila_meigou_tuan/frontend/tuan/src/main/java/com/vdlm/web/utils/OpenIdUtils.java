package com.vdlm.web.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vdlm.service.utils.MeiLaRestTemplate;

/**
 * 微信公众号支付openId相关操作
 * @author abner
 *
 */
public class OpenIdUtils {
	
	
	private final static Logger logger = LoggerFactory.getLogger(OpenIdUtils.class);
	/**
	 * 构造微信授权的code
	 * @param redirectUrl 微信返回Code的URL
	 * @return 请求的url串
	 */
	public static String CreateJsapiCodeRequestUrl(String redirectUrl,String charset,String appid){
		try {
			return "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri=" + URLEncoder.encode(redirectUrl,charset) +
					"&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
			
		} catch (UnsupportedEncodingException e) {
			logger.info("url转义失败:" + e.getMessage());
			return "";
		} 
		
	}

	/**
	 * 判断是否需要向微信获取用户的openId
	 * @param req
	 * @return
	 */
	public static boolean isNeedGetOpenIdFromTen(HttpServletRequest req){
		boolean isNeed = false;
		if(MeiLaDeviceUtils.isWechat(req)){//是微信浏览器
			HttpSession session = req.getSession(true);
			
			if(session.getAttribute("openid") == null ||
					StringUtils.isBlank(session.getAttribute("openid").toString())){//session中是否已经包含有openid,如果不含有则需要重新申请
				isNeed = true;
			}
		}
		return isNeed;
	}
	
	/**
	 * 获取openid,并选择是否保存到session中
	 * @param appid
	 * @param secret
	 * @param code
	 * @param request
	 * @param isSave true:保存到session中,false:不保存
	 * @return
	 */
	public static String getOpenIdFromTen(String appid,String secret,String code,HttpServletRequest request,boolean isSave){
		String openid = "";
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid+"&secret=" + secret + "&code=" +code + 
							"&grant_type=authorization_code";
		
		MeiLaRestTemplate meiLaRestTemplate = new MeiLaRestTemplate();
		ResponseEntity<String> response = meiLaRestTemplate.postForEntity(requestUrl, null, String.class);
		
		String responseStr = response.getBody(); //获取应答的内容
		JSONObject resultJson =  (JSONObject)JSONObject.parse(responseStr);
		openid = resultJson.get("openid").toString();
		if(isSave){
			request.getSession(true).setAttribute("openid", openid);
	 		request.getRequestedSessionId();
		}
		
		return openid ;
	}
}
