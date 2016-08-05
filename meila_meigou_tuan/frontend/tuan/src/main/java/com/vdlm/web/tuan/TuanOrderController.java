package com.vdlm.web.tuan;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vdlm.biz.res.ResourceFacade;
import com.vdlm.dal.model.OrderAddress;
import com.vdlm.dal.model.TuanOrder;
import com.vdlm.dal.model.TuanStatus;
import com.vdlm.dal.model.User;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.status.OrderStatus;
import com.vdlm.dal.type.DeliveryTypeEnum;
import com.vdlm.meila.client.MeilaSimpleUser;
import com.vdlm.meila.client.OnPurchaseModel;
import com.vdlm.meila.client.ReportModel;
import com.vdlm.service.constants.Constants;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.sns.MeiLaSNSReportService;
import com.vdlm.service.tuan.TuanActivityService;
import com.vdlm.service.tuan.TuanOrderService;
import com.vdlm.service.tuan.TuanService;
import com.vdlm.service.tuan.status.TuanOrderStatus;
import com.vdlm.service.tuan.vo.TuanActivityVo;
import com.vdlm.service.tuan.vo.TuanAdderssVo;
import com.vdlm.service.utils.IdCardUtils;
import com.vdlm.service.utils.NameUtils;
import com.vdlm.web.MeilaBaseController;
import com.vdlm.web.common.JsonResult;
import com.vdlm.web.tuan.form.TuanOrderForm;
import com.vdlm.web.utils.MeiLaSNSReportUtils;
import com.vdlm.web.utils.UtmParamUtil;

/**
 * 
 ************************************************************
 * @类名 : TuanOrderController.java
 *
 * @DESCRIPTION :
 * @AUTHOR : Peter
 * @DATE : 2016年2月3日
 ************************************************************
 */
@RequestMapping("/service")
@Controller
public class TuanOrderController extends MeilaBaseController {
    private static Logger LOG = LoggerFactory.getLogger(TuanOrderController.class);
    @Autowired
    private TuanOrderService tuanOrderService;

    @Autowired
    private TuanActivityService tuanActivityService;

    @Autowired
    private TuanService tuanService;

    @Autowired
    private ResourceFacade resourceFacadePTuan;

    @Autowired
    private MeiLaSNSReportService meiLaSNSReportService;

    /**
     * 获取地址信息
     * 
     * @param req
     * @return
     */
    @RequestMapping(value = "getaddress.json", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getAddress(String addressId) {
        JsonResult result = new JsonResult();

        try {
            TuanAdderssVo tuanAdderssVo = tuanOrderService.getAddress(addressId);
            result.setData(tuanAdderssVo);
        } catch (Exception ex) {
            LOG.error("获取地址异常", ex);
            result.setRet(JsonResult.FAILED);
            result.setMsg("系统异常");
            result.setErrCode("-11");
        }
        return result;
    }

    /**
     *
     * 功能描述：订单提交接口
     * 
     * @param tuanOrderForm
     * @return JsonResult
     *
     */
    @RequestMapping(value = "submitorder.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doSubmitOrder(TuanOrderForm tuanOrderForm, HttpServletRequest request) {
        JsonResult result = new JsonResult();

        try {
            User currentUser = this.getCurrentUser();
            long actId = Long.valueOf(tuanOrderForm.getActId());
            TuanActivityVo tuanActivityVo = tuanActivityService.queryActById(actId);

            if (null == tuanActivityVo) {
                throw new BizException(GlobalErrorCode.NOT_FOUND, "找不到活动");
            }

            if (StringUtils.isBlank(tuanOrderForm.getAddressId())) {
                throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "亲，没有选择地址");
            }

            // 订单地址
            OrderAddress address = tuanOrderService.orderAddress(tuanOrderForm.getAddressId());

            // 判断参数与活动有效性
            long tuanId = this.checkValid(tuanOrderForm, tuanActivityVo, actId, IdTypeHandler.decode(currentUser.getId()), address);

            String tuanNo = tuanOrderForm.getTuanNo();
            ReportModel reportModel = MeiLaSNSReportUtils.createReportModel("", request, "");
            Map<String, String> resultMap = tuanOrderService.submitTuanOrder(currentUser.getId(), actId, address, tuanOrderForm.getRemark(),
                tuanOrderForm.getOrderType(), tuanNo, tuanId, UtmParamUtil.getSourceMap(request), reportModel);
            result.setMsg("下单成功");
            result.setData(resultMap);
        } catch (Exception ex) {
            LOG.error("下订单异常", ex);
            result.setRet(JsonResult.FAILED);
            if (ex instanceof BizException) {
                BizException bex = (BizException) ex;
                result.setErrCode(String.valueOf(bex.getErrorCode().getErrorCode()));
                result.setMsg(bex.getMessage());
            } else {
                result.setErrCode("-11");
                result.setMsg("下单失败");
            }

        }
        return result;
    }

    /**
     * 
     * 功能描述：检查是否可以提交订单
     * 
     * @param tuanOrderForm
     * @param tuanActivityVo
     * @param actId
     * @param userId
     * @param address
     * @return
     */
    private long checkValid(TuanOrderForm tuanOrderForm, TuanActivityVo tuanActivityVo, long actId, long userId, OrderAddress address) {
        if (StringUtils.isBlank(tuanOrderForm.getActId())) {
            throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "亲，没有活动号");
        }
        if (address == null) {
            throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "亲，收货地址不能为空");
        }
        if (StringUtils.isBlank(tuanOrderForm.getOrderType())) {
            throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "亲，没有下单类型");
        }

        // 保税仓商品,需要进行身份证校验
        String deliveryType = tuanActivityVo.getDeliveryType();
        if (StringUtils.isNotBlank(deliveryType)
                && (deliveryType.equals(DeliveryTypeEnum.BONDED_AREA.name()) || deliveryType.equals(DeliveryTypeEnum.BONDED_AREA_ML.name()))) {

            // 身份证输入有误
            String idCard = address.getIdCard();
            boolean isValidated = IdCardUtils.isIDCard(StringUtils.isBlank(idCard) ? "" : idCard);
            if (!isValidated) {
                throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "亲，身份证输入有误");
            }

            // 请填写正确的收货人姓名以便海关清关哦
            if (!NameUtils.isChinese(address.getConsignee())) {
                throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "亲，请填写正确的收货人姓名以便海关清关");
            }
        }

        if ("1".equals(tuanOrderForm.getOrderType())) {
            // 代表参团
            if (StringUtils.isBlank(tuanOrderForm.getTuanNo())) {
                throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "参团需要有团单号");
            }
        }

        switch (tuanActivityVo.getTuanActStatus()) {
            case NOTBEGIN:
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "活动还没开始");
            case END:
                if ("0".equals(tuanOrderForm.getOrderType())) {
                    // 只有开团校验
                    throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "活动已结束");
                } else {
                    break;
                }
            case OVERLOAD:
                if ("0".equals(tuanOrderForm.getOrderType())) {
                    throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "团已到达最大限制");
                } else {
                    break;
                }
            case PROCESS:
                break;
            default:
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "活动状态异常");
        }

        long tuanId = 0;
        if ("1".equals(tuanOrderForm.getOrderType())) {
            // 参团
            // 1,判断参加的团的有效性
            TuanStatus tuanStatus = tuanService.selectTuanStatusByTuanNo(tuanOrderForm.getTuanNo());
            if (null == tuanStatus) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "找不到团信息");
            }
            tuanId = tuanStatus.getId();
            Date endDate = DateUtils.addHours(tuanStatus.getStartTime(), tuanStatus.getAliveTime());

            if (tuanStatus.getUserId() == userId) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "自己不能参加自己开的团");
            }
            if (!TuanOrderStatus.PROCESS.name().equals(tuanStatus.getStatus()) || new Date().after(endDate)) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "该团已不允许参团");
            }

            // 获取已经参团的订单数量(只包含已支付)
            int tuanOrderCount = tuanOrderService.countValidTuanOrderByTuanNo(tuanOrderForm.getTuanNo());

            // 取团记录上的成团人数
            if (tuanStatus.getMemberNum() < tuanOrderCount + 1) {
                // 如果已经参团的订单数+当前这一订单 大于 单团最大人数的，不允许当前订单参团
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "团已满");
            }
            int userCurrentTuanCount = tuanOrderService.countValidTuanOrderByTuanNoAndUserId(tuanStatus.getTuanNo(), userId);
            if (userCurrentTuanCount > 0) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "请勿重复参团");
            }

            TuanOrder chiefTuanOrder = tuanOrderService.findOrderByUser(tuanStatus.getId(), tuanStatus.getUserId());

            if (null == chiefTuanOrder || !OrderStatus.PAID.name().equals(chiefTuanOrder.getOrderStatus())) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "该团未开成功");
            }

        } else if ("0".equals(tuanOrderForm.getOrderType())) {
            // 开团
            int tuanCount = tuanService.countUserValidTuanByActIdAndUserId(actId, userId);
            if (tuanCount == 3) {
                // 限制一个人同一个活动只能开三次团
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "同一活动只能开三个团");
            }
            if (tuanActivityVo.getTuanPrice().subtract(tuanActivityVo.getDiscount()).compareTo(BigDecimal.ZERO) != 1) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "开团价格异常");
            }
        } else {
            throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "参数异常");
        }
        return tuanId;
    }

    /**
     * 
     *
     * 功能描述：获取活动的商品信息
     * 
     * @param actId
     * @return JsonResult
     *
     */
    @RequestMapping("getOrderProduct.json")
    @ResponseBody
    public JsonResult getOrderProduct(String actId, String orderType, HttpServletRequest request, HttpServletResponse response) {
        JsonResult result = new JsonResult();
        try {
            if (!"0".equals(orderType) && !"1".equals(orderType)) {
                throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "开参团参数错误");
            }

            TuanActivityVo tuanActivityVo = tuanActivityService.queryActById(Long.valueOf(actId));
            if (null != tuanActivityVo) {
                tuanActivityVo.setImg(resourceFacadePTuan.resolveUrl(tuanActivityVo.getImg()));
                tuanActivityVo.setImg2(resourceFacadePTuan.resolveUrl(tuanActivityVo.getImg2()));
                if("1".equals(orderType)){
                    //参团没有优惠
                    tuanActivityVo.setDiscount(BigDecimal.ZERO);
                }
                
            } else {
                throw new BizException(GlobalErrorCode.NOT_FOUND, "找不到活动");
            }
            result.setData(tuanActivityVo);
            result.setErrCode("0");
            // 上报社区获取团活动商品详情
            // 上报社区团状态页访问
            try {
                final String referer = request.getHeader("referer");
                MeilaSimpleUser currentUser = null;
                try {
                    currentUser = this.getCurLoginUserByMeila(request, response);
                } catch (Exception ex) {

                }
                String userId = currentUser == null ? "" : IdTypeHandler.encode(Long.valueOf(currentUser.getId()));
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("actId", Long.valueOf(actId));
                map.put("referer", referer);
                OnPurchaseModel model = MeiLaSNSReportUtils.createOnPurchaseModel(Constants.SnsReportActionEnum.EC_VIEW_TUAN_ORDER_CONFIRM.getCode(),
                    request, userId, map);
                model.getReportModel().getAction().getExtra_data().put("actId", actId);
                model.getReportModel().getAction().getExtra_data().put("referer", referer);
                meiLaSNSReportService.onPurchaseToMeila(model);
            } catch (Exception ex) {
                log.error("上报社区获取订单团活动商品详情异常", ex);
            }

        } catch (Exception ex) {
            LOG.error("获取活动商品信息出错", ex);
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
