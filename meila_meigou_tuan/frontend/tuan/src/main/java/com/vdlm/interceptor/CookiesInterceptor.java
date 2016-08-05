package com.vdlm.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.vdlm.web.utils.UtmParamUtil;

public class CookiesInterceptor extends HandlerInterceptorAdapter {
    private final Logger logger = LoggerFactory.getLogger(CookiesInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            this.writeCookies(request, response);
        } catch (Exception ex) {
            logger.error("utm参数写入cookies异常",ex);
        }
        return true;
    }

    /**
     * 处理url中的参数，写入cookie：utm_channel utm_source utm_activity utm_user utm_medium in_channel
     * url第一优先级，cookie第二优先级，并且url有如果有utm参数的话，是要覆盖cookie里的
     * 
     * @param req
     * @param resp
     */
    private void writeCookies(HttpServletRequest req, HttpServletResponse resp) {

        Map<String, String> params = UtmParamUtil.getUtmParamByUrl(req);

        for (Map.Entry<String, String> e : params.entrySet()) {
            Cookie c = new Cookie(e.getKey(), e.getValue());
            c.setDomain(".meilapp.com");
            c.setPath("/");
            c.setMaxAge(-1);
            resp.addCookie(c);
        }
    }
}
