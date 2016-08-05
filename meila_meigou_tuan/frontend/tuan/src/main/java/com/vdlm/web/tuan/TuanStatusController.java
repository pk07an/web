package com.vdlm.web.tuan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vdlm.biz.res.ResourceFacade;
import com.vdlm.meila.client.MeilaSimpleUser;
import com.vdlm.meila.client.OnPurchaseModel;
import com.vdlm.service.constants.Constants;
import com.vdlm.service.sns.MeiLaSNSReportService;
import com.vdlm.service.tuan.TuanStatusService;
import com.vdlm.service.tuan.vo.TuanInfoVo;
import com.vdlm.service.tuan.vo.TuanUserVo;
import com.vdlm.web.MeilaBaseController;
import com.vdlm.web.common.JsonResult;
import com.vdlm.web.utils.MeiLaSNSReportUtils;

/**
 * 
 ************************************************************
 * @类名 : TuanStatusController.java
 *
 * @DESCRIPTION : 
 * @AUTHOR :  peter
 * @DATE :  2016年2月3日
 ************************************************************
 */
@RequestMapping("/service")
@Controller
public class TuanStatusController extends MeilaBaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TuanStatusController.class);
    @Autowired
    private TuanStatusService tuanStatusService;

    @Autowired
    private ResourceFacade resourceFacadePTuan;
    @Autowired
    private MeiLaSNSReportService meiLaSNSReportService;
    /**
     *
     * 功能描述：拼团详情页
     * 
     * @param tuanNo
     * @return JsonResult
     *
     */
    @RequestMapping(value = "gettuaninfo.json", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getStatus(String tuanNo, HttpServletRequest request, HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult();

        MeilaSimpleUser currentUser = null;
        try {
            currentUser = this.getCurLoginUserByMeila(request, response);
        } catch (Exception ex) {
            log.error("团购状态获取用户信息失败", ex);
        }

        try {
            TuanInfoVo tuanInfoVo = tuanStatusService.assemblyGroupBuying(tuanNo, null != currentUser ?Long.valueOf(currentUser.getId()) : 0);
            if (tuanInfoVo.getProductInfo() != null) {
                tuanInfoVo.getProductInfo().setImg(resourceFacadePTuan.resolveUrl(tuanInfoVo.getProductInfo().getImg()));
                tuanInfoVo.getProductInfo().setImg2(resourceFacadePTuan.resolveUrl(tuanInfoVo.getProductInfo().getImg2()));
            }
            List<TuanUserVo> tuanUser = tuanInfoVo.getTuanUser();
            if (tuanUser != null) {
                for (TuanUserVo tuanUserVo : tuanUser) {
                    tuanUserVo.setUserImg(resourceFacadePTuan.resolveUrl(tuanUserVo.getUserImg()));
                }
            }

            jsonResult.setData(tuanInfoVo);
            jsonResult.setRet(JsonResult.SUCCESS);
            
            // 上报社区团状态页访问
            try {
                String userId = currentUser == null ? "" : currentUser.getId();
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("tuanno", tuanNo);
                map.put("ischief", tuanInfoVo.getIsChief()?1:0);
                map.put("ispaid", tuanInfoVo.getIsPaid()?1:0);
                OnPurchaseModel model = MeiLaSNSReportUtils.createOnPurchaseModel(Constants.SnsReportActionEnum.EC_VIEW_TUAN_INFO.getCode(), request, userId, map);
                model.getReportModel().getAction().getExtra_data().put("tuanno", tuanNo);
                model.getReportModel().getAction().getExtra_data().put("ischief", tuanInfoVo.getIsChief()?1:0);
                model.getReportModel().getAction().getExtra_data().put("ispaid",  tuanInfoVo.getIsPaid()?1:0);
                meiLaSNSReportService.onPurchaseToMeila(model);
            } catch (Exception ex) {
                log.error("上报社区团状态页访问失败", ex);
            }
            
        } catch (Exception e) {
            LOGGER.error("团状态获取失败", e);
            jsonResult.setRet(JsonResult.FAILED);
            jsonResult.setMsg("团状态获取失败");
            jsonResult.setErrCode("-11");
        }
        return jsonResult;
    }

}
