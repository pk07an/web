package com.vdlm.web.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @类名： MeiLaDeviceUtils.java
 * @描述：设备获取工具类
 * @作者： Toney
 * @修改日期： 2015年7月7日
 */
public class MeiLaDeviceUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeiLaDeviceUtils.class);

    public static boolean isWechat(HttpServletRequest request) {
        boolean isWechat = false;
        String ua = request.getHeader("user-agent");
        if (StringUtils.isNotBlank(ua)) {
            ua = ua.toLowerCase();
            if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
                isWechat = true;
            }
        }
        request.setAttribute("isWechat", isWechat);
        return isWechat;
    }

    public static boolean isApp(HttpServletRequest request) {
        boolean isApp = false;
        // 判断是APP
        String ua = request.getHeader("user-agent");
        if (StringUtils.isNotBlank(ua)) {
            ua = ua.toLowerCase();
            if (ua.indexOf("meila") != -1) {
                isApp = true;
            }
        }
        request.setAttribute("isApp", isApp);
        return isApp;
    }
}
