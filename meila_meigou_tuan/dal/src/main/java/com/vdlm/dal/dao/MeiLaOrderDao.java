package com.vdlm.dal.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.vo.OrderVO;

/**
 * @类名： MeiLaOrderDao.java
 * @描述：订单DAO
 * @作者： Toney
 * @修改日期： 2015年6月25日
 */
public interface MeiLaOrderDao {

    /**
     * 功能描述：按payNos查询
     * 
     * @param orderNo
     * @return
     */
    List<OrderVO> selectByBuyerAndPayNos(@Param("payNos") List<String> payNos,@Param("status") String status, @Param("userId") String userId);

    /**
     * 功能描述：分页查询orderCode
     * 
     * @param status
     * @param userId
     * @param page
     * @return
     */
    List<String> selectByOrderNoPage(@Param("status") String status, @Param("userId") String userId, @Param("pager") Pageable pager);

    /**
     * 功能描述：功能描述：按OrderNo查询
     * @param newArrayList
     * @param object
     * @param buyerId
     * @return
     */
    List<OrderVO> selectByBuyerAndOrderNos(@Param("orderNos") List<String> orderNos, @Param("status") String status, @Param("userId") String userId);

    /**
     * 功能描述：按OrderNo、卖家ID查询
     * @param newArrayList
     * @param object
     * @param sellerId
     * @return
     */
    List<OrderVO> selectOrderByOrderNoAndSeller(@Param("orderNos") ArrayList<String> newArrayList, @Param("status") String status, @Param("sellerId") String sellerId);
    
    /**
     * 功能描述：查询待评价订单，返回的是order_no
     * 
     * @param status
     * @param userId
     * @param page
     * @return
     */
    List<String> selectOrderNoPageForComments(@Param("userId") String userId, @Param("pager") Pageable pager);
}
