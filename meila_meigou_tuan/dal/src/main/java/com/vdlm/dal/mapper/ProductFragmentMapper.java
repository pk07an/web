package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.ProductFragment;

public interface ProductFragmentMapper {

	int insert(ProductFragment productFragment);
	
	int deleteById(String id);
	
	Integer selectMaxByProductId(String productId);
	
	ProductFragment selectById(String id);
	
	List<ProductFragment> selectByProductId(String productId);
	
	int deleteByProductId(@Param(value="productId") String productId);
	
	void incAllBeforeDest(@Param(value="productId") String productId, @Param(value="idx") int idx, @Param(value="increment") int increment);
	
	void decAllAfterDest(@Param(value="productId") String productId, @Param(value="idx") int idx, @Param(value="increment") int increment);
	
	int updateSrcIdx(@Param(value="id") String id, @Param(value="idx") int idx);
}
