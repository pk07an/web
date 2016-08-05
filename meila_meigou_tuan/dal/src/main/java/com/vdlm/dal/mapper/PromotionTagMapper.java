package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.promotion.PromotionTag;


public interface PromotionTagMapper {

	int insert(@Param("tagObj") PromotionTag tagObj);
	
	int update(@Param("tagObj") PromotionTag tagObj);
	
	int del(String tagId);
	
	List<PromotionTag>  getAllList(@Param("params") Map<String,Object> params,@Param("page") Pageable  pageable);

	Long countTagList();
	
	/**
	 * 标签和活动绑定 
	 * @param proId
	 * @param id
	 * @return
	 */
	int bindPromotion(@Param("proId") String proId,@Param("id") String id);
	
	
	 PromotionTag  findTagByProId(@Param("proId") String proId);
}
