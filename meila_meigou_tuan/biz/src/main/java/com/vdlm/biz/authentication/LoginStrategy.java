package com.vdlm.biz.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author:  chenxi
 *
 * This interface is used for redirecting unauthenticated user to customized login page.
 * You can configure the class name for customized-class type or spring bean name for customized-ref type
 * in login-strageties.xml like this:
 *
 * <login-strategies>
 *   <default type="customized-ref" strategy="defaultBeanName" /> (optional)
 *   <domains>
 *     <domain name="xxx.yy.zzz" type="customized-class" strategy="aaa.bbb.strategyClass" />
 *     <domain name="xxx.yy.zzz" type="customized-ref" strategy="strategyBeanName" />
 *   </domains>
 * </login-strategies>
 *
 * Note: you redirect the login page to a differ domain by returning an absolute url like:
 *        http://xxx.yyy.zzz
 *        otherwise, you redirect the login page in the same domain
 */

public interface LoginStrategy {

    String buildLoginUrl(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception);
}
