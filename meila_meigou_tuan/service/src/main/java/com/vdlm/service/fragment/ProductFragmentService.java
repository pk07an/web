package com.vdlm.service.fragment;

import java.util.List;

import com.vdlm.dal.model.ProductFragment;
import com.vdlm.service.BaseService;

public interface ProductFragmentService extends BaseService{
	
	int insert(ProductFragment productFragment);
	
	int deleteById(String id);
	
	int deleteByProductId(String productId);
	
	List<ProductFragment> selectByProductId(String productId);
	
	void moveBefore(String srcId, String desId);
	
	void moveAfter(String srcId, String desId);
}
