package com.vdlm.interceptor;

import java.net.URLEncoder;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.vdlm.dal.model.User;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.type.UserPartnerType;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.user.UserService;
import com.vdlm.service.utils.CookieUtils;
import com.vdlm.web.common.JsonResult;
import com.vdlm.web.utils.MeiLaDeviceUtils;

public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private com.vdlm.meila.client.MeilaClient meilaClient;
    @Autowired
    private UserService userService;

    private final String SESSION_USER_INFO = "MUD-SC0";

    @Value("${meila.third.login.service.host}")
    private String THIRD_LOGIN_SERVICE_HOST;

    private final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    private String getLoginedUserInfo(HttpServletRequest request) {
        String headMud = request.getHeader("Mud");
        String mud = StringUtils.isBlank(headMud) ? Objects.toString(CookieUtils.getCookieValue(request, "Mud"), "") : headMud;
        String sc0 = Objects.toString(CookieUtils.getCookieValue(request, "sc0"), "");
        return mud + "-" + sc0;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // login interceptor
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof User)
                user = (User) principal;
        }
        String reqMudSc0 = getLoginedUserInfo(request);
        if (user != null) {
            String mudSc0 = Objects.toString(request.getSession().getAttribute(SESSION_USER_INFO));
            if (!StringUtils.equals(mudSc0, reqMudSc0)) {
                user = null;
            }
        }
        if (user == null) {
            com.vdlm.meila.client.MeilaSimpleUser mUser = null;
            try {
                mUser = meilaClient.getUserByHeaderAndCookie(request, response);
            } catch (BizException e) {
                throw new BizException(GlobalErrorCode.UNAUTHORIZED, "授权失败，请重新登录");
            }
            if (mUser != null) {
                String loginId = mUser.getId();
                user = userService.load(IdTypeHandler.encode(NumberUtils.toLong(loginId)));
                if (user == null) {
                    user = userService.registerExtUser(UserPartnerType.MEILA.toString(), mUser.getSlug(), mUser.getNickName(), mUser.getAvatar(),
                        loginId);
                }
            }
        }
        if (user == null) {
            // goto login; TODO 如果是APP里要怎么处理呢？
            String url = THIRD_LOGIN_SERVICE_HOST;
            String refererUrl = request.getServletPath();
            String param = request.getQueryString();

            if (refererUrl.indexOf(".json") != -1) {
                JsonResult jsonResult = new JsonResult();
                jsonResult.setRet(JsonResult.FAILED);
                jsonResult.setErrCode("-99");
                jsonResult.setMsg("not login");
                ajaxJson(JSONObject.toJSONString(jsonResult), response);
                return false;
            } else {
                String backUrl = THIRD_LOGIN_SERVICE_HOST + refererUrl;
                if (StringUtils.isNotBlank(param)) {
                    backUrl = backUrl + "?" + param;
                }
                url = url + "/login/?next=" + URLEncoder.encode(backUrl, "utf-8");
                response.sendRedirect(url);
                return false;
            }
        } else {
            request.setAttribute("user", user);
            request.getSession().setAttribute(SESSION_USER_INFO, reqMudSc0);
            auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        // login interceptor end
        MeiLaDeviceUtils.isApp(request);
        MeiLaDeviceUtils.isWechat(request);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO Auto-generated method stub
        super.afterCompletion(request, response, handler, ex);
    }

    private void ajaxJson(String content, HttpServletResponse response) {
        try {
            response.setContentType("text/json;charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (Exception e) {
            logger.error("error ajaxJson", e);
        }
    }
}
