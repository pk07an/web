package com.vdlm.web.tuan;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vdlm.dal.model.TuanStatus;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.tuan.TuanStatusService;

@Controller
public class TuanForwardController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TuanForwardController.class);
    @Autowired
    private TuanStatusService tuanStatusService;

    /**
     * 地址 http://local.meilapp.com/ptuan/30.xhtml 转换为
     * http://local.meilapp.com/ptuan/group/group-status.html?tuanNo=PT160310153820001055
     * 
     * @param tuanStatusId 表vdlm_tuan_status的id，通过id获取到tuan_no
     * @param model
     * @return
     */
    @RequestMapping("{tuanStatusId}.xhtml")
    public String ware(@PathVariable("tuanStatusId") String tuanStatusId, Model model) {
        try {
            Long statusId = Long.parseLong(tuanStatusId);
            TuanStatus status = tuanStatusService.getTuanStatusById(statusId);

            if (status != null && StringUtils.isNotBlank(status.getTuanNo())) {
                model.addAttribute("tuanNo", status.getTuanNo());
                return "redirect:/group/group-status.html";
            }
        } catch (Exception ex) {
            LOGGER.error("短信跳转地址异常", ex);

        }
        throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "请求地址错误,tuanStatusId=" + tuanStatusId);
    }

}
