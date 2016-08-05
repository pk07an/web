package com.vdlm.web.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * url和cookie中utm参数处理工具类 utm参数用于跟踪页面来源，例如推广等
 * 
 * @author Peter
 */
public class UtmParamUtil {

    public static final String UTM_CHANNEL = "utm_channel";
    public static final String UTM_SOURCE = "utm_source";
    public static final String UTM_ACTIVITY = "utm_activity";
    public static final String UTM_USER = "utm_user";
    public static final String UTM_MEDIUM = "utm_medium";
    public static final String IN_CHANNEL = "in_channel";

    private static final String CHARSET = "UTF-8";

    // 需要处理的参数列表
    private static List<String> utms = Arrays.asList(UTM_CHANNEL, UTM_SOURCE, UTM_ACTIVITY, UTM_USER, UTM_MEDIUM, IN_CHANNEL);
    private static Logger LOG = LoggerFactory.getLogger(UtmParamUtil.class);

    public static Map<String, String> getUtmParam(HttpServletRequest req) {

        Map<String, String> params = new HashMap<String, String>();

        // 先取cookie
        Cookie[] cookies = req.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (utms.contains(cookie.getName())) {
                    params.put(cookie.getName(), null == cookie.getValue() ? "" : cookie.getValue());
                }
            }
        }

        // 再取url参数
        for (String utm : utms) {
            if (StringUtils.isNotEmpty(req.getParameter(utm))) {
                try {
                    params.put(utm, URLEncoder.encode(req.getParameter(utm), CHARSET));
                } catch (Exception e) {
                    LOG.error("从cookies获取utm参数失败", e);
                }
            }
        }

        return params;
    }

    /**
     * 
     *
     * 功能描述：从cookie或者request里获取统计参数,cookie需要解码
     * 
     * @param request
     * @return Map<String,String>
     *
     */
    public static Map<String, String> getSourceMap(HttpServletRequest request) {
        Map<String, String> sourceMap = new HashMap<String, String>();
        try {
            Map<String, String> utmParams = UtmParamUtil.getUtmParam(request);
            String utmChannel = Objects.toString(utmParams.get(UtmParamUtil.UTM_CHANNEL), "");
            String utmActivity = Objects.toString(utmParams.get(UtmParamUtil.UTM_ACTIVITY), "");
            String inChannel = Objects.toString(utmParams.get(UtmParamUtil.IN_CHANNEL), "");
            String utmSource = Objects.toString(utmParams.get(UtmParamUtil.UTM_SOURCE), "");
            String utmUser = Objects.toString(utmParams.get(UtmParamUtil.UTM_USER), "");
            String utmMedium = Objects.toString(utmParams.get(UtmParamUtil.UTM_MEDIUM), "");

            utmChannel = URLDecoder.decode(StringUtils.isBlank(utmChannel) ? "" : utmChannel, CHARSET);
            utmActivity = URLDecoder.decode(StringUtils.isBlank(utmActivity) ? "" : utmActivity, CHARSET);
            inChannel = URLDecoder.decode(StringUtils.isBlank(inChannel) ? "" : inChannel, CHARSET);
            utmSource = URLDecoder.decode(StringUtils.isBlank(utmSource) ? "" : utmSource, CHARSET);
            utmUser = URLDecoder.decode(StringUtils.isBlank(utmUser) ? "" : utmUser, CHARSET);
            utmMedium = URLDecoder.decode(StringUtils.isBlank(utmMedium) ? "" : utmMedium, CHARSET);

            sourceMap.put("utm_channel", utmChannel);
            sourceMap.put("utm_source", utmSource);
            sourceMap.put("utm_activity", utmActivity);
            sourceMap.put("utm_user", utmUser);
            sourceMap.put("utm_medium", utmMedium);
            sourceMap.put("in_channel", inChannel);
            sourceMap.put("source", MeiLaDeviceUtils.isApp(request) ? "" : "web");
        } catch (Exception e) {
            LOG.error("构造统计参数失败", e);
        }

        return sourceMap;
    }
    
    /**
     * 
     *
     * 功能描述：通过url抓取utm相关参数
     * 
     * @param req
     * @return Map<String,String>
     *
     */
    public static Map<String, String> getUtmParamByUrl(HttpServletRequest req) {

        Map<String, String> params = new HashMap<String, String>();
        // 再取url参数
        for (String utm : utms) {
            if (StringUtils.isNotEmpty(req.getParameter(utm))) {
                try {
                    params.put(utm, URLEncoder.encode(req.getParameter(utm), CHARSET));
                } catch (Exception e) {
                    LOG.error("从url获取utm参数失败", e);
                }
            }
        }

        return params;
    }
}
