package com.meila.dal.slave.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.vo.PromotionTagVO;

public class PromotionSlaveDaoTestCase extends BaseDaoTestCase {
    
    @Autowired
    private PromotionSlaveDao promotionSlaveDao;
    
    @Test
    public void testSelectTagByProductId(){
        List<String> productIdList =new ArrayList<String>();
        //有效的
        productIdList.add(IdTypeHandler.encode(2958));
        productIdList.add(IdTypeHandler.encode(2958));
        productIdList.add(IdTypeHandler.encode(2945));
        productIdList.add(IdTypeHandler.encode(2944));
        //失效
        productIdList.add(IdTypeHandler.encode(2968));
        productIdList.add(IdTypeHandler.encode(2954));
        productIdList.add(IdTypeHandler.encode(2955));
        List<PromotionTagVO> promotionTagVOs=promotionSlaveDao.selectTagByProductId(productIdList);
        System.out.println(ToStringBuilder.reflectionToString(promotionTagVOs));
    }
}
