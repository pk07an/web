package com.vdlm.web.tuan;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.meila.meigou.cachehelper.RedisAdapter;
import com.vdlm.biz.res.ResourceFacade;
import com.vdlm.dal.model.Product;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.vo.FragmentImageVO;
import com.vdlm.dal.vo.FragmentVO;
import com.vdlm.meila.client.MeilaSimpleUser;
import com.vdlm.meila.client.OnPurchaseModel;
import com.vdlm.service.constants.Constants;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.fragment.FragmentImageService;
import com.vdlm.service.fragment.FragmentService;
import com.vdlm.service.product.MeiLaProductService;
import com.vdlm.service.sns.MeiLaSNSReportService;
import com.vdlm.service.tuan.TuanActivityService;
import com.vdlm.service.tuan.vo.TuanActivityVo;
import com.vdlm.utils.RedisKeyConstant;
import com.vdlm.web.MeilaBaseController;
import com.vdlm.web.common.JsonResult;
import com.vdlm.web.utils.MeiLaSNSReportUtils;

/**
 * 
 ************************************************************
 * @类名 : TuanDetailController.java
 *
 * @DESCRIPTION :
 * @AUTHOR : dan
 * @DATE : 2016年2月3日
 ************************************************************
 */
@RequestMapping("/service")
@Controller
public class TuanDetailController extends MeilaBaseController {
    private static Logger LOG = LoggerFactory.getLogger(TuanDetailController.class);
    @Autowired
    private TuanActivityService tuanActivityService;
    @Autowired
    private MeiLaProductService meiLaProductService;
    @Autowired
    private ResourceFacade resourceFacadePTuan;
    @Autowired
    private FragmentService fragmentService;

    @Autowired
    private FragmentImageService fragmentImageService;

    @Autowired
    private RedisAdapter redisAdapter;

    @Autowired
    private MeiLaSNSReportService meiLaSNSReportService;

    /**
     * 
     *
     * 功能描述：获取活动的商品信息
     * 
     * @param actId
     * @return JsonResult
     *
     */
    @RequestMapping("getActivityProduct.json")
    @ResponseBody
    public JsonResult getActivityProduct(String actId, HttpServletRequest request, HttpServletResponse response) {
        JsonResult result = new JsonResult();
        try {
            TuanActivityVo tuanActivityVo = tuanActivityService.queryActById(Long.valueOf(actId));
            if (null != tuanActivityVo) {
                tuanActivityVo.setImg(resourceFacadePTuan.resolveUrl(tuanActivityVo.getImg()));
                tuanActivityVo.setImg2(resourceFacadePTuan.resolveUrl(tuanActivityVo.getImg2()));
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
                OnPurchaseModel model = MeiLaSNSReportUtils.createOnPurchaseModel(Constants.SnsReportActionEnum.EC_VIEW_TUAN_PRODUCT_DETAIL.getCode(),
                    request, userId, map);
                model.getReportModel().getAction().getExtra_data().put("actId", actId);
                model.getReportModel().getAction().getExtra_data().put("referer", referer);
                meiLaSNSReportService.onPurchaseToMeila(model);
            } catch (Exception ex) {
                log.error("上报社区获取团活动商品详情异常", ex);
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

    /**
     * 
     *
     * 功能描述：获取商品的图文详情
     * 
     * @param productCode
     * @return JsonResult
     *
     */
    @RequestMapping("getProductDesc.json")
    @ResponseBody
    public JsonResult getProudctDesc(String productCode) {
        JsonResult result = new JsonResult();

        try {
            Map<String, Object> resultMap = new HashMap<String, Object>();
            // 获取商品
            Product product = meiLaProductService.selectByProductCode(productCode);
            // 获取图文详情
            List<FragmentVO> fragments = this.getProudctFragments(product.getId());

            resultMap.put("product", product);
            resultMap.put("fragments", fragments);
            result.setData(resultMap);
            // 上报社区获取团活动商品图文详情
        } catch (Exception ex) {
            LOG.error("获取活动商品信息出错", ex);
            result.setRet(JsonResult.FAILED);
            result.setMsg("系统异常");
            result.setErrCode("-11");
        }
        return result;

    }

    /**
     *
     * 功能描述：组装商品图文详情段落
     * 
     * @param productId
     * @return List<FragmentVO>
     *
     */
    @SuppressWarnings("unchecked")
    private List<FragmentVO> getProudctFragments(String productId) {
        if (StringUtils.isBlank(productId)) {
            return null;
        }

        final String cacheKey = RedisKeyConstant.CACHE_TUAN_DESC_PRODUCTID + productId;
        if (redisAdapter.exists(cacheKey)) {
            return (List<FragmentVO>) redisAdapter.get(cacheKey, List.class);
        }
        List<FragmentVO> fragments = fragmentService.selectByProductIdSlave(productId);
        for (int i = 0; i < fragments.size(); i++) {
            FragmentVO vo = fragments.get(i);
            List<FragmentImageVO> imgs = fragmentImageService.selectByFragmentIdSlave(vo.getId());
            for (FragmentImageVO fragmentImageVO : imgs) {
                fragmentImageVO.setImgUrl(resourceFacadePTuan.resolveUrl(fragmentImageVO.getImg()));
            }
            vo.setImgs(imgs);

            if (vo.getDescription() != null) {
                vo.setDescription(vo.getDescription().trim());
            }

            vo.setDescription(StringUtils.replace(vo.getDescription(), "\n", "<br />"));
        }
        if (CollectionUtils.isNotEmpty(fragments)) {
            redisAdapter.set(cacheKey, fragments);
            redisAdapter.expire(cacheKey, RedisKeyConstant.CACHE_TUAN_DESC_PRODUCTID_TIME);
        }
        return fragments;
    }
}
