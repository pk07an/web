package com.vdlm.dal.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.vdlm.dal.vo.OrderExportVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.Order;
import com.vdlm.dal.model.promotion.PromotionModel;
import com.vdlm.dal.status.OrderStatus;
import com.vdlm.dal.type.RefundType;
import com.vdlm.dal.vo.Customer;
import com.vdlm.dal.vo.OrderItemWithOrderVO;
import com.vdlm.dal.vo.OrderVO;

public interface OrderMapper {

	int insert(Order record);

	Order selectByPrimaryKey(String id);
	
	Order selectByOrderNo(String orderNo);

	int updateByPrimaryKeySelective(Order record);

	List<OrderVO> selectByBuyerAndStatus(String buyerId, @Param("status") OrderStatus status, @Param("pager")Pageable pageable);

	Long countByBuyerAndStatus(String buyerId, @Param("status") OrderStatus status);
	
	Long countBySellerAndStatus(String sellerId, @Param("status") OrderStatus status);
	// add by luojy 20150702
	Long countBySellerAndStatus1(String sellerId,@Param("key") String key, @Param("status") OrderStatus... status);
	
	List<OrderVO> selectBySellerAndStatus(String sellerId, @Param("status") OrderStatus status, @Param("pager")Pageable pageable);

	List<OrderItemWithOrderVO> selectBySellerAndStatusKey(String sellerId, @Param("status") OrderStatus status, @Param("key") String key);
	// add by luojy 20150702
	List<OrderItemWithOrderVO> selectBySellerAndStatusKey(String sellerId, @Param("status") OrderStatus status, @Param("key") String key, @Param("page") Pageable page);

	List<Customer> selectCustomersByShopId(@Param("shopId") String shopId, @Param("sort") String sortStr, @Param("page") Pageable pageable);
	
	Long countByAdmin(@Param(value="params")Map<String, Object> params);
	
	Map<String, Object> countMapByAdmin(@Param(value="params") Map<String, Object> params);	
	
	/**
	 * 店铺订单统计
	 * @param params
	 * @return
	 */
	int countByShopStatistics(@Param(value="params")Map<String, Object> params);
	
	List<OrderVO> selectByAdmin(@Param(value="params")Map<String, Object> params, @Param("page") Pageable pageable);
	
	List<Customer> selectCustomersByShopIdAndKey(@Param("shopId") String shopId, @Param("key") String key, @Param("sort") String sortStr, @Param("page") Pageable pageable);

	Customer selectCustomerByShopIdAndBuyerId(String shopId, String buyerId);

	Customer selectCustomerByShopIdAndConsignee(String shopId, String name, String phone);

	List<OrderVO> selectByShopIdAndCustomerId(String shopId, String customerId);
	
	List<Order> selectAutoCancel();
	
	List<Order> selectAutoSignRemind(); 
	
	List<Order> selectAutoSign();

	int updateOrderStatus4Buyer(String orderId, OrderStatus orderStatus, String buyerId);

	int updateOrderStatus4Seller(String orderId, OrderStatus orderStatus, String sellerId);
	
	int updateOrderByRequestRefund(@Param("id")String orderId);
	
	int updateOrderByCancelRefund(@Param("id")String orderId, @Param("status")OrderStatus orderStatus);
	
	int updateOrderStatus(String orderId, OrderStatus orderStatus);

	Order selectBySeller(@Param("id")String orderId, @Param("sellerId")String sellerId);

	List<Order> selectByShopIdAndConsignee(String shopId, String name, String phone);

	int updateOrderByCancel(@Param("params")Map<String, Object> params, @Param("order")Order order);

	int updateOrderByPay(@Param("params")Map<String, Object> params, @Param("order")Order order);

	int updateOrderByShip(@Param("params")Map<String, Object> params, @Param("order")Order order);

	int updateOrderBySign(@Param("params")Map<String, Object> params, @Param("order")Order order);
	
	int updateOrderStatusWithPreCondition(@Param("params")Map<String, Object> params, @Param("order")Order order);
	
	int updateOrderByRefund(@Param("params")Map<String, Object> params, @Param("order")Order record);
	
	Long selectOrderSeqByShopId(String shopId);
	
	int updateOrderRefundByAdmin(String orderId, RefundType refundType);
	
	List<Customer> selectCustomersByVip(@Param("shopId") String shopId, @Param("value") Boolean value);
	
	Order selectLatestByBuyerId(@Param("shopId") String shopId, @Param("buyerId") String buyerId);

	List<Order> selectByBuyer(@Param(value="params") Map<String, Object> params, @Param("buyerId") String userId);
	
	List<Order> selectBySellerAndStatus(@Param("sellerId") String sellerId, @Param("status") OrderStatus status);

	/**
	 * 修改订单价格（老接口）
	 * @param orderId
	 * @param totalFee
	 * @param sellerId
	 * @return
	 */
	int updateTotalPrice(@Param("orderId") String orderId, @Param("totalFee") BigDecimal totalFee, @Param("sellerId") String sellerId);
	
	/**
	 * 修改订单价格（新 接口141230）
	 * @param orderId
	 * @param totalFee
	 * @param logisticsFee
	 * @param sellerId
	 * @return
	 */
	int updatePrice(@Param("orderId") String orderId, @Param("totalFee") BigDecimal totalFee, @Param("logisticsFee") BigDecimal logisticsFee, @Param("sellerId") String sellerId);
	
	List<Order> selectByShopId(@Param("shopId") String shopId);

    Long selectCountByStatus4Buyer(@Param("buyerId") String userId, @Param("status") OrderStatus status);
	
    int countNoVisitOrderBySellerId(@Param("userId") String userId, @Param("lastVisitTime") Date lastVisitTime);

    int updateVipByCustomer(@Param("consignee") String consignee, @Param("phone") String phone, @Param("shopId") String shopId, @Param("vip") Boolean vip);
    
    int updRemarkByAdmin(@Param(value="orderId") String id,@Param(value="remark") String remark);
    
    String obtainPaymentChannel(@Param(value="orderNo") String orderNo);
    
    int delete(@Param("ids") String[] ids);
    
    List<Order> selectByBuyer(@Param("buyerId") String buyerId, @Param("pager") Pageable pager);

    Long countByBuyer(@Param("buyerId") String buyerId);
    
    int countBySpecialTime(@Param("model") PromotionModel model,@Param("buyerId") String buyerId);

	List<Order> selectByPayNo(@Param("payNo") String payNo, @Param("buyerId") String buyerId);

	List<Order> selectOrderNoListByStatus(@Param("status") OrderStatus status, @Param("pager")Pageable pageable);
	List<Map<String, Object>> groupByStatus(@Param("userId") String userId) ;    
	
	/**
	 * 功能描述：统计支付之后各状态的数量
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> groupByStatusAfterPaid(@Param("userId") String userId) ;    

	// add by luojy 20150702
    List<Order> selectOrders4Export(@Param("params") Map<String, Object> params);

    /**
     * bos 导出订单相关 by reese 2015-7-29
     * @param params
     * @return
     */
    List<OrderExportVO> selectByAdmin4BosExcel(@Param("params") Map<String, Object> params);

    /**
     * bos 导出数据条数统计，大于此记录数时，停止导出 by reese
     * @return
     */
    int cntByAdmin4BosExcel(@Param("params") Map<String, Object> params);
    /**
     * 功能描述：用户购买成功商品，不包括CANCELL 、SUBMITTED 、CLOSED
     * @param userId
     * @return
     */
    int countByBuyerPaidOrder(@Param("buyerId") String userId);

    OrderExportVO checkDataValid(@Param("orderNo")String orderNo, @Param("buyerId")String buyerId);

    int updateSettlementStatus(@Param("orderNo")String orderNo, @Param("buyerId")String buyerId);

    /**
     * 通过Order 查询order_ext表中是否存在该order的扩展信息，若无，则进行插入操作
     * by reese 2015-8-3
     * @param order
     * @return
     */
    int insertOrderExt(Order order);

    List<Order> loadOrderByOrderNos(@Param("orderNos") List<String> orderNos);

    /**
     * 功能描述：更新订单的订单状态
     * @param payNo
     * @param orderStatus
     * @return
     */
    int updateWaitPayConfirmByPayNo(@Param("payNo")String payNo, @Param("updateStatus")String updateStatus,@Param("orderStatus")String orderStatus,@Param("buyerId")String buyerId);

    /**
     * 功能描述：根据订单号和买家ID查询订单对象
     * @param orderNo
     * @param buyerId
     * @return
     */
    OrderVO selectByOrderNoAndBuyer(@Param("orderNo")String orderNo,@Param("buyerId")String buyerId);
}