package com.vdlm.service.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vdlm.service.constants.Constants;

/**
 * @类名： CookieUtils.java
 * @描述：Web 端的COOKIE utils
 * @作者： Toney
 * @修改日期： 2015年7月6日
 */
public class CookieUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(CookieUtils.class);

    /**
     * 根据Cookie名称得到Cookie的值，没有返回Null
     * 
     * 2006-7-28
     * 
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = getCookie(request, name);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    /**
     * 根据Cookie名称得到Cookie对象，不存在该对象则返回Null
     * 
     * 2006-7-28
     * 
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie cookies[] = request.getCookies();
        if (cookies == null || name == null || name.length() == 0)
            return null;
        Cookie cookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if (!cookies[i].getName().equals(name))
                continue;
            cookie = cookies[i];
            if (request.getServerName().equals(cookie.getDomain()))
                break;
        }

        return cookie;
    }

    /**
     * 删除指定Cookie
     * 
     * 2006-7-28
     * 
     * @param response
     * @param cookie
     */
    public static void deleteCookie(HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            cookie.setPath("/");
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    /**
     * 删除指定Cookie
     * 
     * 2006-7-28
     * 
     * @param response
     * @param cookie
     */
    public static void deleteCookie(HttpServletResponse response, Cookie cookie, String domain) {
        if (cookie != null) {
            cookie.setPath("/");
            cookie.setValue("");
            cookie.setMaxAge(0);
            cookie.setDomain(domain);
            response.addCookie(cookie);
        }
    }

    /**
     * 添加一条新的Cookie信息，默认有效时间为一个月
     * 
     * 2006-7-28
     * 
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void setCookie(HttpServletResponse response, String name, String value) {
        setCookie(response, name, value, 0x278d00);
    }

    /**
     * 添加一条新的Cookie信息，可以设置其最长有效时间(单位：秒)
     * 
     * 2006-7-28
     * 
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
        if (value == null)
            value = "";
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 添加一条新的Cookie信息，可以设置其Name，Value，MaxAge，Path，Domain(单位：秒)
     * 
     * 2006-8-23
     * 
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge, String path, String domain) {
        if (value == null)
            value = "";
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        cookie.setDomain(domain);
        response.addCookie(cookie);
    }
}
