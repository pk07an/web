package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Fragment;
import com.vdlm.dal.vo.FragmentVO;

public interface FragmentMapper {
	
	int insert(Fragment fragment);

	int update(Fragment fragment);
	
	int deleteById(@Param(value="id") String id);
	
	Integer selectMaxByShopId(@Param(value="shopId") String shopId);

	FragmentVO selectById(@Param(value="id") String id);
	
	List<FragmentVO> selectByShopId(@Param(value="shopId") String shopId);
	
	List<FragmentVO> selectByProductId(@Param(value="productId") String productId);

	void incAllBeforeDest(@Param(value="shopId") String shopId, @Param(value="idx") int idx, @Param(value="increment") int increment);
	
	void decAllAfterDest(@Param(value="shopId") String shopId, @Param(value="idx") int idx, @Param(value="increment") int increment);
	
	int updateSrcIdx(@Param(value="id") String id, @Param(value="idx") int idx);
	
	int addCode(@Param("id") String id);
}
