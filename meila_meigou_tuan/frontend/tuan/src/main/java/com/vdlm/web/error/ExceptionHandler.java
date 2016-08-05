package com.vdlm.web.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.vdlm.web.utils.MeiLaDeviceUtils;

/**
 * General error handler for the application.
 */
@ControllerAdvice
class ExceptionHandler {

	Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * Handle exceptions thrown by handlers.
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception e, HttpServletRequest req, HttpServletResponse resp) {
		log.error("access '" + req.getRequestURI() + "' occurs error [" + e.getMessage()
						+ "] on: " + req.getContextPath() + ", "
						+ req.getParameterMap(), e);
		ModelAndView mav = new ModelAndView("error/general");
		 MeiLaDeviceUtils.isApp(req);
	     MeiLaDeviceUtils.isWechat(req);
		return mav;
	}
}