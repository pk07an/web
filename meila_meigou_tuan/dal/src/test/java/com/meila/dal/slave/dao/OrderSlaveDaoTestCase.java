package com.meila.dal.slave.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vdlm.dal.mybatis.IdTypeHandler;

public class OrderSlaveDaoTestCase extends BaseDaoTestCase {
    @Autowired
    OrderSlaveDao orderSlaveDao;
    String buyerId="";
    @Before
    public void setup(){
        buyerId=IdTypeHandler.encode(3344814);
    }
    @Test
    public void testCountPaidByDayAndBuyerId(){
       System.out.println(this.orderSlaveDao.countPaidByDayAndBuyerId(buyerId));
    }

}
