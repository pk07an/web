package com.vdlm.service.tuan;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meila.dal.slave.dao.TuanOrderSlaveDao;
import com.meila.dal.slave.dao.TuanStatusSlaveDao;
import com.vdlm.dal.model.TuanOrder;
import com.vdlm.dal.model.TuanStatus;
import com.vdlm.dal.status.OrderStatus;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.tuan.status.TuanOrderStatus;

@Service
public class TuanService {
    private static Logger LOG = LoggerFactory.getLogger(TuanService.class);

    @Autowired
    private TuanStatusSlaveDao tuanStatusSlaveDao;
    
    @Autowired
    private TuanOrderSlaveDao tuanOrderSlaveDao;

    public int countValidTuanByActId(long actId) {
        return tuanStatusSlaveDao.countValidTuanByActId(actId);
    }

    public int countUserValidTuanByActIdAndUserId(long actId, long userId) {
        return tuanStatusSlaveDao.countUserValidTuanByActIdAndUserId(actId, userId);
    }

    public TuanStatus selectTuanStatusByTuanNo(String tuanNo) {
        return tuanStatusSlaveDao.selectTuanStatusByTuanNo(tuanNo);
    }

    public Map<Long, Integer> countAllValidTuanMap() {
        List<Map<String, Object>> validTuanList = tuanStatusSlaveDao.countAllValidTuanMap();
        Map<Long, Integer> resultMap = new HashMap<Long, Integer>();

        for (Map<String, Object> map : validTuanList) {
            Long actId = 0L;
            Integer tuanCount = 0;
            for (Map.Entry<String, Object> entry : map.entrySet()) {

                if ("actId".equals(entry.getKey())) {
                    actId = (Long) entry.getValue();
                } else if ("tuanCount".equals(entry.getKey())) {
                    Long count = ((Long) entry.getValue());
                    tuanCount = count ==null?0:count.intValue();
                }
            }
            resultMap.put(actId, tuanCount);
        }
        return resultMap;
    }
    
    
    /**
     * 
     *
     * 功能描述：检查该团是否可以参加
     * 
     * @param tuanNo
     * @param userId void
     *
     */
    public void checkTuanJoin(String tuanNo, long userId) {

        // 参团
        // 1,判断参加的团的有效性
        TuanStatus tuanStatus = this.selectTuanStatusByTuanNo(tuanNo);
        if (null == tuanStatus) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "找不到团信息");
        }
        Date endDate = DateUtils.addHours(tuanStatus.getStartTime(), tuanStatus.getAliveTime());

        if (tuanStatus.getUserId() == userId) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "自己不能参加自己开的团");
        }
        if (!TuanOrderStatus.PROCESS.name().equals(tuanStatus.getStatus()) || new Date().after(endDate)) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "该团已不允许参团");
        }

        // 获取已经参团的订单数量(只包含已支付)
        int tuanOrderCount = tuanOrderSlaveDao.countValidTuanOrderByTuanNo(tuanNo);

        // 取团记录上的成团人数
        if (tuanStatus.getMemberNum() < tuanOrderCount + 1) {
            // 如果已经参团的订单数+当前这一订单 大于 单团最大人数的，不允许当前订单参团
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "团已满");
        }
        int userCurrentTuanCount = tuanOrderSlaveDao.countValidTuanOrderByTuanNoAndUserId(tuanStatus.getTuanNo(), userId);
        if (userCurrentTuanCount > 0) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "请勿重复参团");
        }

        TuanOrder chiefTuanOrder = tuanOrderSlaveDao.findOrderByUser(tuanStatus.getId(), tuanStatus.getUserId());

        if (null == chiefTuanOrder || !OrderStatus.PAID.name().equals(chiefTuanOrder.getOrderStatus())) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "该团未开成功");
        }
    }
}
