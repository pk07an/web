package com.vdlm.service.fragment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Fragment;
import com.vdlm.dal.vo.FragmentVO;
import com.vdlm.service.BaseService;

public interface FragmentService extends BaseService {

	int insert(Fragment fragment);

	int update(Fragment fragment);

	int delete(String id);

	FragmentVO selectById(String id);

	List<FragmentVO> selectByProductId(String productId);

	List<FragmentVO> selectByShopId(@Param(value = "shopId") String shopId);

	void moveBefore(String srcId, String desId);

	void moveAfter(String srcId, String desId);

    List<FragmentVO> selectByProductIdSlave(String productId);
}
