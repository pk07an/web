package com.vdlm.service.tuan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.runtime.parser.node.MathUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meila.dal.slave.dao.ProductInfoSlaveDao;
import com.meila.dal.slave.dao.TuanActivitySlaveDao;
import com.vdlm.dal.model.ProductInfo;
import com.vdlm.dal.model.TuanActivity;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.type.DeliveryTypeEnum;
import com.vdlm.service.product.MeiLaProductService;
import com.vdlm.service.product.vo.ProductSkuVO;
import com.vdlm.service.tuan.status.TuanActStatus;
import com.vdlm.service.tuan.vo.Page;
import com.vdlm.service.tuan.vo.TuanActivityVo;

/**
 * ***********************************************************
 *
 * @类名 : TuanActivityService
 *
 *
 * @DESCRIPTION :
 * @AUTHOR : Dan
 * @DATE : 2016-03-01 
 * ***********************************************************
 */
@Service
public class TuanActivityService {

    @Autowired
    private TuanActivitySlaveDao tuanActivitySlaveDao;

    @Autowired
    private ProductInfoSlaveDao productInfoSlaveDao;

    @Autowired
    private TuanService tuanService;
    @Autowired
    private MeiLaProductService meiLaProductService;
    
    /**
     * 
     *
     * 功能描述：查询拼团活动列表，数据库里所有都取出来，再排序，再分页
     * 
     * @param pageNum
     * @param pageSize
     * @param isTest
     * @return Page<TuanActivityVo>
     *
     */
    public Page<TuanActivityVo> queryAllTuanActivityList(Integer pageNum, Integer pageSize, boolean isTest) {

        List<TuanActivityVo> result = new ArrayList<TuanActivityVo>();
        Long total = Long.valueOf(0);
        Long totalPage = Long.valueOf(0);
        List<TuanActivity> tuanActivities = tuanActivitySlaveDao.selectAllTuanActivityList(isTest);
        // 数据库有记录，执行排序与分页
        if (!CollectionUtils.isEmpty(tuanActivities)) {
            // 排序
            this.sort(tuanActivities);

            //分页
            total = Long.valueOf(tuanActivities.size());
            totalPage = getTotalPages(total, pageSize);
            if (pageNum <= totalPage) {
                int startRow = (pageNum - 1) * pageSize;
                int endRow = (startRow + pageSize) > total ? total.intValue() : startRow + pageSize;
                List<TuanActivity> subList = tuanActivities.subList(startRow, endRow);
                if (!CollectionUtils.isEmpty(subList)) {
                    for (TuanActivity tuanActivity : subList) {
                        TuanActivityVo tuanActivityVo = getTuanActivityVo(tuanActivity);
                        result.add(tuanActivityVo);
                    }
                }
            }

        }
        return new Page<TuanActivityVo>(result, pageNum, pageSize, totalPage.intValue(), total.intValue());
    }

    private void sort(List<TuanActivity> tuanActivities) {
        final Map<Long, Integer> validTuanMap = tuanService.countAllValidTuanMap();
        final Date now = new Date();
        // 排序
        Collections.sort(tuanActivities, new Comparator<TuanActivity>() {
            @Override
            public int compare(TuanActivity o1, TuanActivity o2) {
                if (o1.getEndTime().before(now) && !o2.getEndTime().before(now)) {
                    // o1过期，o2没有过期
                    return 1;

                } else if (!o1.getEndTime().before(now) && o2.getEndTime().before(now)) {
                    // o1没有过期，o2过期
                    return -1;
                } else if (o1.getEndTime().before(now) && o2.getEndTime().before(now)) {
                    // o1,o2都过期，按结束时间排序
                    return -(o1.getEndTime().compareTo(o2.getEndTime()));
                } else {
                    Integer validTuanO1 = validTuanMap.get(o1.getId()) == null ? 0 : validTuanMap.get(o1.getId());
                    Integer validTuanO2 = validTuanMap.get(o2.getId()) == null ? 0 : validTuanMap.get(o2.getId());

                    if (validTuanO1 >= o1.getTotalNum() && validTuanO2 < o2.getTotalNum()) {
                        // o1满团，o2没满
                        return 1;

                    } else if (validTuanO1 < o1.getTotalNum() && validTuanO2 >= o2.getTotalNum()) {
                        // o1没满团，o2满团
                        return -1;

                    } else if (validTuanO1 >= o1.getTotalNum() && validTuanO2 >= o2.getTotalNum()) {
                        // O1,O2都满团，按结束时间排序
                        return -(o1.getEndTime().compareTo(o2.getEndTime()));
                    } else {
                        // O1,O2都没有满团
                        if (o1.getRank() > o2.getRank()) {
                            // o1的权重大于o2
                            return -1;
                        } else if (o1.getRank() == o2.getRank()) {
                            return -(o1.getEndTime().compareTo(o2.getEndTime()));
                        } else {
                            return 1;
                        }
                    }
                }
            }
        });
    }
    private TuanActivityVo getTuanActivityVo(TuanActivity tuanActivity) {
        TuanActivityVo tuanActivityVo = new TuanActivityVo();
        BeanUtils.copyProperties(tuanActivity, tuanActivityVo);
        this.initTuanActStatus(tuanActivity, tuanActivityVo);
        return tuanActivityVo;
    }

    private Long getTotalPages(Long totalCount, int pageSize) {
        if (totalCount <= 0)
            return 0l;

        Long pageCount = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageCount++;
        }
        return pageCount;
    }

    public List<TuanActivityVo> queryActvList(Integer pageId) {
        return null;
    }

    public TuanActivityVo queryActById(Long id) {
        TuanActivityVo tuanActivityVo = null;
        TuanActivity tuanActivity = tuanActivitySlaveDao.selectById(id);

        if (null != tuanActivity) {
            tuanActivityVo = new TuanActivityVo();
            BeanUtils.copyProperties(tuanActivity, tuanActivityVo);
            if (!MathUtils.isZero(tuanActivity.getProductId())) {
                ProductInfo productInfo = productInfoSlaveDao.selectByProductId(tuanActivity.getProductId());
                if (null != productInfo) {
                    String deliveryType = StringUtils.isBlank(productInfo.getDeliveryType()) ? DeliveryTypeEnum.MEILA.name()
                            : productInfo.getDeliveryType();
                    tuanActivityVo.setDeliveryType(deliveryType);
                }
                String skuSpecStr = this.getSkuSpecStr(IdTypeHandler.encode(tuanActivity.getProductId()),
                    IdTypeHandler.encode(tuanActivity.getSkuId()));
                tuanActivityVo.setSkuSpecStr(skuSpecStr);

            }
            this.initTuanActStatus(tuanActivity, tuanActivityVo);
        }

        return tuanActivityVo;
    }
    
    private String getSkuSpecStr(String productId, String skuId) {
        String spec = "";
        ProductSkuVO productSkuVO = meiLaProductService.loadById(productId, skuId);
        if (productSkuVO != null) {
            spec = productSkuVO.getSku().getSpec1();
            spec = StringUtils.isBlank(productSkuVO.getSku().getSpec2()) ? spec : (spec + "," + productSkuVO.getSku().getSpec2());
            spec = StringUtils.isBlank(productSkuVO.getSku().getSpec3()) ? spec : (spec + "," + productSkuVO.getSku().getSpec3());
            spec = StringUtils.isBlank(productSkuVO.getSku().getSpec4()) ? spec : (spec + "," + productSkuVO.getSku().getSpec4());
            spec = StringUtils.isBlank(productSkuVO.getSku().getSpec5()) ? spec : (spec + "," + productSkuVO.getSku().getSpec5());
        }
        return spec;
    }

    public void initTuanActStatus(TuanActivity tuanActivity, TuanActivityVo tuanActivityVo) {
        // 判断活动的状态
        Date beginTime = tuanActivity.getBeginTime();
        Date endTime = tuanActivity.getEndTime();
        // short actStatus = tuanActivity.getStatus();
        Date now = new Date();
        if (now.before(beginTime)) {
            // 未开始
            tuanActivityVo.setTuanActStatus(TuanActStatus.NOTBEGIN);
        } else if (now.after(endTime)) {
            // 已结束
            tuanActivityVo.setTuanActStatus(TuanActStatus.END);
        } else {
            // 进行中
            int validTuan = tuanService.countValidTuanByActId(tuanActivity.getId());
            if (tuanActivity.getTotalNum() <= validTuan) {
                // 满团
                tuanActivityVo.setTuanActStatus(TuanActStatus.OVERLOAD);
            } else {
                // 有团
                tuanActivityVo.setTuanActStatus(TuanActStatus.PROCESS);
            }
        }
    }

}
