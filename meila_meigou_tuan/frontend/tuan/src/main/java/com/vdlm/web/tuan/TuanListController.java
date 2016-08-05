package com.vdlm.web.tuan;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vdlm.biz.res.ResourceFacade;
import com.vdlm.dal.model.User;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.meila.client.MeilaSimpleUser;
import com.vdlm.meila.client.OnPurchaseModel;
import com.vdlm.service.constants.Constants;
import com.vdlm.service.sns.MeiLaSNSReportService;
import com.vdlm.service.tuan.TuanActivityService;
import com.vdlm.service.tuan.TuanOrderService;
import com.vdlm.service.tuan.vo.Page;
import com.vdlm.service.tuan.vo.TuanActivityVo;
import com.vdlm.service.tuan.vo.TuanOrderVo;
import com.vdlm.web.MeilaBaseController;
import com.vdlm.web.common.JsonResult;
import com.vdlm.web.utils.MeiLaSNSReportUtils;

/**
 * 
 ************************************************************
 * @类名 : MeilaTuanListController.java
 *
 * @DESCRIPTION :
 * @AUTHOR : dan
 * @DATE : 2016年2月2日
 ************************************************************
 */
@Controller
@RequestMapping("/service")
public class TuanListController extends MeilaBaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TuanListController.class);

    @Autowired
    private TuanActivityService tuanActivityService;

    @Autowired
    private ResourceFacade resourceFacadePTuan;
    @Autowired
    private TuanOrderService tuanOrderService;

    @Autowired
    private MeiLaSNSReportService meiLaSNSReportService;
    /**
     *
     * 功能描述：获取拼团活动的列表
     *
     * @param pageNo
     * @return JsonResult
     *
     */
    @RequestMapping(value = "getactvlist.json", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getActivityList(@RequestParam(value = "pageno", required = true, defaultValue = "1") Integer pageNo,
        @RequestParam(value = "test", required = false) String test, HttpServletRequest request, HttpServletResponse response) {
        JsonResult result = new JsonResult();
        boolean isTest = StringUtils.isNotBlank(test) && "onlyfortest".equals(test) ? true : false;
        try {
            Page<TuanActivityVo> tuanActivityVoPage = tuanActivityService.queryAllTuanActivityList(pageNo, 5, isTest);
            for (TuanActivityVo tuanActivityVo : tuanActivityVoPage.getList()) {
                tuanActivityVo.setImg(resourceFacadePTuan.resolveUrl(tuanActivityVo.getImg()));
                tuanActivityVo.setImg2(resourceFacadePTuan.resolveUrl(tuanActivityVo.getImg2()));
            }
            result.setRet(JsonResult.SUCCESS);
            result.setData(tuanActivityVoPage);

            if (!isTest) {
                // 上报社区访问活动列表

                try {
                    MeilaSimpleUser currentUser = null;
                    try {
                        currentUser = this.getCurLoginUserByMeila(request, response);
                    } catch (Exception ex) {

                    }
                    String userId = currentUser == null ? "" : IdTypeHandler.encode(Long.valueOf(currentUser.getId()));
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("pageno", pageNo);
                    OnPurchaseModel model = MeiLaSNSReportUtils.createOnPurchaseModel(Constants.SnsReportActionEnum.EC_VIEW_ACT_LIST.getCode(), request, userId, map);
                    model.getReportModel().getAction().getExtra_data().put("pageno", pageNo);
                    meiLaSNSReportService.onPurchaseToMeila(model);
                } catch (Exception ex) {
                    log.error("上报社区访问活动列表失败", ex);
                }
            }

        } catch (Exception e) {
            LOGGER.error("团活动列表获取失败", e);
            result.setRet(JsonResult.FAILED);
            result.setMsg("团活动列表获取失败");
            result.setErrCode("-11");
        }
        return result;
    }

    /**
     * 我的团页面
     * 
     * @param req
     * @return
     */
    @RequestMapping(value = "gettuanlist.json", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult gettuanlist(@RequestParam(value = "pageno", required = true, defaultValue = "1") Integer pageNo, HttpServletRequest req) {
        JsonResult result = new JsonResult();
        try {
            User currentUser = this.getCurrentUser();
            Page<TuanOrderVo> tuanOrderVoPage = tuanOrderService.getMyTuanOrderList(IdTypeHandler.decode(currentUser.getId()), pageNo, 5);
            if (CollectionUtils.isNotEmpty(tuanOrderVoPage.getList())) {
                for (TuanOrderVo tuanOrderVo : tuanOrderVoPage.getList()) {
                    TuanActivityVo tuanActivityVo = tuanOrderVo.getTuanActivity();
                    if (null != tuanActivityVo) {
                        tuanActivityVo.setImg(resourceFacadePTuan.resolveUrl(tuanActivityVo.getImg()));
                        tuanActivityVo.setImg2(resourceFacadePTuan.resolveUrl(tuanActivityVo.getImg2()));
                    }
                }
            }
            result.setData(tuanOrderVoPage);

            // 上报社区访问我的团页面
            try {
                String userId = currentUser == null ? "" : currentUser.getId();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("pageno", pageNo);
                OnPurchaseModel model = MeiLaSNSReportUtils.createOnPurchaseModel(Constants.SnsReportActionEnum.EC_VIEW_TUAN_LIST.getCode(), req, userId, map);
                model.getReportModel().getAction().getExtra_data().put("pageno", pageNo);
                meiLaSNSReportService.onPurchaseToMeila(model);
            } catch (Exception ex) {
                log.error("上报社区访问我的团页面失败", ex);
            }
        } catch (Exception e) {
            LOGGER.error("团订单获取失败", e);
            result.setRet(JsonResult.FAILED);
            result.setMsg("团订单获取失败");
            result.setErrCode("-11");
        }
        return result;
    }

}
