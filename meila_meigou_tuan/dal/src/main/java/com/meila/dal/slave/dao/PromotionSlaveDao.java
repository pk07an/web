package com.meila.dal.slave.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.vo.PromotionTagVO;

/**
 * <pre>
 *     &#64;类名： PromotionSlaveDao.java 
 *     &#64;描述：针对促销的一些slave 查询
 *     &#64;作者： Toney
 *     &#64;修改日期： 2015年8月13日
 * </pre>
 */
public interface PromotionSlaveDao {
	public List<PromotionTagVO> selectTagByProductId(@Param("productIdList") List<String> productIdList);

	public List<PromotionTagVO> selectLastTagByProductId(@Param("productId") String productId);
}
