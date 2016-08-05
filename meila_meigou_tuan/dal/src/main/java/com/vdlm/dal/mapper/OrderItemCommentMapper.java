package com.vdlm.dal.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.OrderItemComment;
import com.vdlm.dal.model.OrderItemCommentImage;
import com.vdlm.dal.status.OrderStatus;
import com.vdlm.dal.vo.OrderItemCommentAdmin;

public interface OrderItemCommentMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(OrderItemComment record);

    OrderItemComment selectByPrimaryKey(String id);
    
    OrderItemComment selectByCode(String code);

    int updateByPrimaryKeySelective(OrderItemComment record);

	List<OrderItemComment> selectByProductId(@Param("productId")String productId,@Param("pager") Pageable pager);
	
	Long countByProductId(@Param("productId")String productId);
	
	OrderItemComment selectLastestByProductId(@Param("productId")String productId);
	
	Long countByBuyerIdAndSellerId(@Param("buyerId")String buyerId, @Param("sellerId")String sellerId);
	
	List<OrderItemComment> selectByBuyerIdAndSellerId(@Param("buyerId")String buyerId, @Param("sellerId")String sellerId,@Param("pager") Pageable pager);
	
	List<OrderItemComment> selectUnreadBySellerId(@Param("sellerId")String sellerId,@Param("pager") Pageable pager);
	
	List<OrderItemComment> selectByOrderItemId(@Param("orderItemId")String orderItemId);
	
	Long countNewOrderItemReplyBySellerId(@Param("sellerId") String sellerId, @Param("startTime") Date startTime);
	
	BigDecimal selectProcuctScoreAvg(@Param("productId")String productId);
	
	Long selectSumProductScore(@Param("productId")String productId);
	
	Long checkExistsByOrderId(@Param("orderId")String orderId);
	Long checkExistsByOrderItemId(@Param("orderId")String orderId,@Param("orderItemId") String orderItemId,@Param("buyerId") String buyerId);
	Long checkExistsByItemId(@Param("orderId")String orderId,@Param("orderItemId") String orderItemId);
	
	int insertCommentImage(OrderItemCommentImage image);
	
	List<OrderItemCommentImage> selectImageByCommentId(@Param("commentId")String commentId);
	
	Long countOrderCommentByAdmin(@Param(value="params") Map<String, Object> params);
	
	List<OrderItemCommentAdmin> listOrderCommentByAdmin(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);
	
	int deleteByAdmin(@Param("ids")String[] ids);
	
	int addCode(@Param("id") String id);

    /**
     * 功能描述：统计用户未评价订单
     * @param buyerId
     * @param success
     * @return
     */
    int countByCommnetAndBuyer(@Param("buyerId")String buyerId,@Param("status") OrderStatus status);
}