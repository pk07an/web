package com.vdlm.web.tuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vdlm.biz.res.ResourceFacade;
import com.vdlm.dal.model.TuanStatus;
import com.vdlm.meila.client.MeilaSimpleUser;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.tuan.TuanOrderService;
import com.vdlm.service.tuan.TuanService;
import com.vdlm.service.tuan.TuanStatusService;
import com.vdlm.service.tuan.vo.TuanActivityVo;
import com.vdlm.service.tuan.vo.TuanJoinStatusVo;
import com.vdlm.service.tuan.vo.TuanOrderVo;
import com.vdlm.service.tuan.vo.TuanUserVo;
import com.vdlm.web.MeilaBaseController;
import com.vdlm.web.common.JsonResult;

/**
 * 
 ************************************************************
 * @类名 : TuanJoinController.java
 *
 * @DESCRIPTION :
 * @AUTHOR : meila-x
 * @DATE : 2016年4月28日
 ************************************************************
 */
@Controller
@RequestMapping("/service")
public class TuanJoinController extends MeilaBaseController {
    private static Logger LOG = LoggerFactory.getLogger(TuanJoinController.class);
    @Autowired
    private TuanStatusService tuanStatusService;

    @Autowired
    private TuanOrderService tuanOrderService;

    @Autowired
    private ResourceFacade resourceFacadePTuan;

    @Autowired
    private TuanService tuanService;

    /**
     * 
     *
     * 功能描述：获取详细页中间用户关联的个人信息（用户开/参团列表 & 可参与其他团列表） （迭代6，拼团详情页附加信息调用）
     * 
     * @param actId
     * @return JsonResult
     *
     */
    @RequestMapping("getTuanDetailUserExtInfo.json")
    @ResponseBody
    public JsonResult getTuanDetailUserExtInfo(String actId, HttpServletRequest request, HttpServletResponse response) {
        JsonResult result = new JsonResult();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        try {

            MeilaSimpleUser currentUser = null;
            try {
                currentUser = this.getCurLoginUserByMeila(request, response);
            } catch (Exception ex) {
                log.error("获得可参团列表的用户没有登录");
            }

            long userId = currentUser == null ? 0 : Long.valueOf(currentUser.getId());

            // 可参团列表
            List<TuanJoinStatusVo> tuanJoinStatusVoList = tuanStatusService.getCanTuanJoinStatusVo(Long.valueOf(actId), 1000, userId); // 默认取1000条，假定同时进行的团不会有1000个
            if (CollectionUtils.isNotEmpty(tuanJoinStatusVoList)) {
                for (TuanJoinStatusVo tuanJoinStatusVo : tuanJoinStatusVoList) {
                    tuanJoinStatusVo.setUserImg(resourceFacadePTuan.resolveUrl(tuanJoinStatusVo.getUserImg()));
                }
            }

            dataMap.put("joinTuanList", tuanJoinStatusVoList);

            // 如果是已经登录的用户，获取用户该活动我的拼团的信息
            List<TuanOrderVo> tuanOrderVoList = new ArrayList<TuanOrderVo>();
            if (userId != 0) {
                tuanOrderVoList = tuanOrderService.getMyTuanOrderListByActId(userId, Long.valueOf(actId));
                if (CollectionUtils.isNotEmpty(tuanOrderVoList)) {
                    for (TuanOrderVo tuanOrderVo : tuanOrderVoList) {
                        // 获取用户列表
                        List<TuanUserVo> tuanUserVoList = tuanOrderService.getTuanUserListByTuanNo(tuanOrderVo.getTuanNo(),String.valueOf(userId),tuanOrderVo.getStatus());
                        if (CollectionUtils.isNotEmpty(tuanUserVoList)) {
                            for (TuanUserVo tuanUserVo : tuanUserVoList) {
                                tuanUserVo.setUserImg(resourceFacadePTuan.resolveUrl(tuanUserVo.getUserImg()));
                            }
                            tuanOrderVo.setTuanUser(tuanUserVoList);
                        }

                        TuanActivityVo tuanActivityVo = tuanOrderVo.getTuanActivity();
                        if (null != tuanActivityVo) {
                            tuanActivityVo.setImg(resourceFacadePTuan.resolveUrl(tuanActivityVo.getImg()));
                            tuanActivityVo.setImg2(resourceFacadePTuan.resolveUrl(tuanActivityVo.getImg2()));
                        }
                    }
                }
            }
            dataMap.put("tuanOrderVoList", tuanOrderVoList);

            result.setData(dataMap);
            result.setRet(JsonResult.SUCCESS);
        } catch (Exception ex) {
            LOG.error("获取可参团列表失败", ex);
            result.setRet(JsonResult.FAILED);
            result.setMsg("系统异常");
            result.setErrCode("-11");
        }
        return result;
    }

    /**
     * 
     *
     * 功能描述：检查该团是否可以参加 (暂时先没有调用)
     * 
     * @param tuanNo
     * @return JsonResult
     *
     */
    @RequestMapping("checkJoinTuan.json")
    @ResponseBody
    @Deprecated
    public JsonResult checkJoinTuan(String tuanNo, HttpServletRequest request, HttpServletResponse response) {
        JsonResult result = new JsonResult();

        try {
            MeilaSimpleUser currentUser = null;
            try {
                currentUser = this.getCurLoginUserByMeila(request, response);
            } catch (Exception ex) {
                log.error("获得可参团列表的用户没有登录");
            }

            long userId = currentUser == null ? 0 : Long.valueOf(currentUser.getId());
            tuanService.checkTuanJoin(tuanNo, userId);
            result.setData(tuanNo);
            result.setRet(JsonResult.SUCCESS);
        } catch (Exception ex) {
            LOG.error("检查是否可参团失败", ex);
            result.setRet(JsonResult.FAILED);
            if (ex instanceof BizException) {
                BizException bex = (BizException) ex;
                result.setErrCode(String.valueOf(bex.getErrorCode().getErrorCode()));
                result.setMsg(bex.getMessage());
            } else {
                result.setMsg("系统异常");
                result.setErrCode("-11");
            }
        }
        return result;
    }

    /**
     * 
     *
     * 功能描述：自动参团接口，返回参团的tuanNo 迭代6,点参团按钮调用
     * 
     * @param actId
     * @return JsonResult
     *
     */
    @RequestMapping("autoJoinTuan.json")
    @ResponseBody
    public JsonResult autoJoinTuan(String actId, HttpServletRequest request, HttpServletResponse response) {
        JsonResult result = new JsonResult();
        try {
            MeilaSimpleUser currentUser = null;
            try {
                currentUser = this.getCurLoginUserByMeila(request, response);
            } catch (Exception ex) {
                log.error("获得可参团列表的用户没有登录");
            }

            long userId = currentUser == null ? 0 : Long.valueOf(currentUser.getId());

            List<TuanStatus> tuanStatusList = tuanStatusService.selectCanJoinTuanListByActId(Long.valueOf(actId), 1, userId);
            if (CollectionUtils.isNotEmpty(tuanStatusList)) {
                String tuanNo = tuanStatusList.get(0).getTuanNo();
                result.setData(tuanNo);
                result.setRet(JsonResult.SUCCESS);
            } else {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "参团失败！所有团都已满员，你自己开个团吧");
            }
        } catch (Exception ex) {
            LOG.error("自动选择参团失败", ex);
            result.setRet(JsonResult.FAILED);
            if (ex instanceof BizException) {
                BizException bex = (BizException) ex;
                result.setErrCode(String.valueOf(bex.getErrorCode().getErrorCode()));
                result.setMsg(bex.getMessage());
            } else {
                result.setMsg("系统异常");
                result.setErrCode("-11");
            }
        }
        return result;
    }
}
