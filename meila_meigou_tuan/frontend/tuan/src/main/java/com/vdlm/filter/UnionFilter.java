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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vdlm.dal.model.User;
import com.vdlm.service.user.UserService;

public class UnionFilter extends OncePerRequestFilter {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 拦截记录订单的分销的id
     */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	    
	    String unionId = request.getParameter("union_id");
        if (StringUtils.isNotEmpty(unionId)) {
	        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	        UserService userService = (UserService) webApplicationContext.getBean("userService");
            User user = userService.load(unionId);
            if (user != null) {
                Cookie c = new Cookie("union_id", unionId);
                // expired in 15 days
                c.setMaxAge(86400 * 15);
                c.setPath("/");
                response.addCookie(c);
                log.info("add union_id[" + unionId + "] in user cookie");             }
        }
	    
		filterChain.doFilter(request, response);
	}
}
