package com.meila.dal.slave.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * <pre>
 *    &#64;类名： OrderSlaveDao.java 
 *    &#64;描述： order slave select 
 *    &#64;作者： Toney 
 *    &#64;修改日期： 2015年8月10日
 * </pre>
 */
public interface OrderSlaveDao {
	public Long countPaidByDayAndBuyerId(@Param("buyerId") String buyerId);

	int selectShopLastestTotalAmountByShopId(@Param("shopId") String shopId, @Param("interval") int interval);

	Map<String, Object> selectLastHostSaleByShopId(@Param("shopId") String shopId, @Param("interval") int interval);
}
