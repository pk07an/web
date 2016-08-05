package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.RangeIdPair;
import com.vdlm.dal.model.promotion.PromotionModel;
import com.vdlm.dal.model.promotion.PromotionProTag;

/**
 *
 * @author: chenxi
 */

public interface PromotionModelMapper {

	PromotionModel selectByRangeAndObjId(RangeIdPair pair);
	
	// need order by range desc
	List<PromotionModel> selectByRangesAndObjIds(@Param("pairs") List<RangeIdPair> pairs);
	
	List<PromotionModel> selectByObjId(String objId);
	
	List<PromotionModel> selectBySellerId(String sellerId);
	
	List<PromotionModel> selectByPartner(String sellerId);
	
	int insert(PromotionModel model);
	
	int update(PromotionModel model);
	
	//int deleteById(String id);
	
	int updatePeriodicityDate(String id);
    
	PromotionModel	selectProModelByPrimaryKey(String modelId);
	
	//PromotionModel findProModelByProductID(String productID);
	List<PromotionModel> getAllList(@Param(value="params") Map<String, Object> params,@Param("page") Pageable pageable);
	
	Long countAllList(@Param(value="params") Map<String, Object> params);
	  
	int selectCntbyRangsAndObjIds( @Param("pair") RangeIdPair pair);
	
	int delRuleById(@Param("id") String id);
}
