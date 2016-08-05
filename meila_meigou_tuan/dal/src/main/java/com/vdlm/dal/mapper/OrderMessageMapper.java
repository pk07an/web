package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.OrderMessage;
import com.vdlm.dal.vo.MsgProdInfoVO;

public interface OrderMessageMapper {
	
	OrderMessage selectByPrimaryKey(String id);

    int insert(OrderMessage message);
    
    List<OrderMessage> selectByOrderId(@Param("orderId")String orderId);

    List<OrderMessage> selectMsgBySeller(@Param("sellerId") String sellerId, @Param("page") Pageable pageable);
    
    List<OrderMessage> selectMsgByBuyer(@Param("buyerId") String buyerId, @Param("page") Pageable pageable);
    
    List<OrderMessage> selectRepsMsgBySeller(@Param("buyerId") String buyerId, @Param("page") Pageable pageable);
    
    List<OrderMessage> selectOrdersBySeller(@Param("sellerId") String sellerId, @Param("page") Pageable pageable);
    
    MsgProdInfoVO selectProdInfoByOrderId(@Param("orderId") String orderId);
    
    int updateMsgReadByOrderId(@Param("orderId") String orderId);

    /**
     * 获取卖家的最后一条回复
     * @param orderId
     * @return
     */
    OrderMessage selectLatestSellerReplyByOrderId(@Param("orderId") String orderId);
}
