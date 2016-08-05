package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.promotion.PromotionProTag;
import com.vdlm.dal.model.promotion.PromotionTag;

public interface PromotionProTagMapper {

	int insert(@Param("proTag") PromotionProTag proTag);
	
	int del(@Param("id") String id);
	
	List<PromotionProTag>  getAllList(@Param("page") Pageable pageable);
	
	List<PromotionProTag>  getListByTagId(@Param("tagId") String tagId);
	
	int selectCntbyProductIdAndTagId(@Param("productId") String productId,@Param("tagId") String tagId);
	
	 List<PromotionProTag>  selectByProductId(@Param("productId") String productId);
	 
	 List<PromotionProTag>  selectByProductIdList(@Param("ids") List<String> productIdList);

	 
	 List<PromotionProTag>  getAllList(@Param(value="params") Map<String, Object> params,@Param("page") Pageable pageable);
	    
		
	Long countAllList(@Param(value="params") Map<String, Object> params);
		  
	int cntByProductIdAndTagId(@Param("productId") String productId,@Param("tagId") String TagId);
	
	PromotionProTag selectProTagByProIdAndTagId(@Param("productId") String productId,@Param("tagId") String TagId);

	void updateArchive(@Param("id") String id);
}
