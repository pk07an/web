package com.vdlm.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vdlm.dal.model.User;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;

/**
 * web工程的基类Controller
 *
 * @author odin
 */
public class BaseController {

    protected Logger log = LoggerFactory.getLogger(getClass());

    @Value("${alipay.domain}")
    String alipayDomain;

    /**
     * 获取当前用户信息 如果是未登录的匿名用户，系统根据匿名用户唯一码自动创建一个用户 具体逻辑查看：UniqueNoFilter
     * 
     * @return
     */
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof User) {
                return (User) principal;
            }

            if (auth.getClass().getSimpleName().indexOf("Anonymous") < 0) {
                log.error("Unknown authentication encountered, ignore it. " + auth);
            }
        }

        throw new BizException(GlobalErrorCode.UNAUTHORIZED, "need login first.");
    }
}
