package com.vdlm.web.error;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vdlm.service.error.BizException;
import com.vdlm.utils.CommonUtils;
import com.vdlm.web.utils.MeiLaDeviceUtils;

@Controller
class CustomErrorController {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Display an error page, as defined in web.xml <code>custom-error</code> element.
     */
    @RequestMapping("/generalError.xhtml")
    public String generalError(HttpServletRequest request, HttpServletResponse response, Model model) {
        // retrieve some useful information from the request
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");

        if (null != throwable) {
            log.error("/generalError 异常: ", throwable);
        }

        statusCode = getExceptionStatus(throwable, statusCode);
        String exceptionMessage = getExceptionMessage(throwable, statusCode);

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        String message = MessageFormat.format("{0} returned for {1} with message {2}", statusCode, requestUri, exceptionMessage);

        log.error(request.getRequestURI() + " general error : " + message);

        model.addAttribute("statusCode", statusCode);
        model.addAttribute("isApp", MeiLaDeviceUtils.isApp(request));
        model.addAttribute("isWechat", MeiLaDeviceUtils.isWechat(request));

        return "error/general";
    }

    private String getExceptionMessage(Throwable throwable, Integer statusCode) {
        if (throwable != null) {
            return CommonUtils.getRootCause(throwable).getMessage();
        }
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        return httpStatus.getReasonPhrase();
    }

    private Integer getExceptionStatus(Throwable throwable, Integer statusCode) {
        if (throwable != null) {
            if (CommonUtils.getRootCause(throwable) instanceof BizException) {
                BizException bizExp = (BizException) CommonUtils.getRootCause(throwable);
                return bizExp.getErrorCode().getErrorCode();
            }
        }
        return statusCode;
    }
}
