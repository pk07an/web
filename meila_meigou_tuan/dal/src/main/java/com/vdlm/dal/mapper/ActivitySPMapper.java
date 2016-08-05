package com.vdlm.dal.mapper;


import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.ActivitySP;

public interface ActivitySPMapper {
    /**
	 * 根据 商品id  取首个未过期的特价活动 seker 2015-01-06 
	 * @param productId 商品id
	 * @return
	 */
    ActivitySP getFirstActivitySP(@Param("productId") String productId);
    
	/**
	 * 用户在活动期间的购买数量  seker 2015-01-06 
	 * @param activity
	 * @param user_id
	 * @return
	 */
	int getBuyQty(@Param("userId") String userId, @Param("activity") ActivitySP activity);
}
