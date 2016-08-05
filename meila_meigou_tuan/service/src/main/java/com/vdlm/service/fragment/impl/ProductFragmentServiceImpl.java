package com.vdlm.service.fragment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vdlm.dal.mapper.ProductFragmentMapper;
import com.vdlm.dal.model.ProductFragment;
import com.vdlm.service.common.BaseServiceImpl;
import com.vdlm.service.fragment.ProductFragmentService;

@Service("productFragmentService")
public class ProductFragmentServiceImpl extends BaseServiceImpl implements ProductFragmentService{
	
	@Autowired
	private ProductFragmentMapper productFragmentMapper;

	@Override
	public int insert(ProductFragment productFragment) {
		Integer maxIdx = productFragmentMapper.selectMaxByProductId(productFragment.getProductId());
		productFragment.setIdx(maxIdx == null ? 0 : maxIdx + 1);
		return productFragmentMapper.insert(productFragment);
	}

	@Override
	public int deleteById(String id) {
		return productFragmentMapper.deleteById(id);
	}

	@Override
	public List<ProductFragment> selectByProductId(String productId) {
		return productFragmentMapper.selectByProductId(productId);
	}

	@Override
	@Transactional
	public void moveBefore(String srcId, String destId) {
		ProductFragment dest  = productFragmentMapper.selectById(destId);
		productFragmentMapper.incAllBeforeDest(dest.getProductId(), dest.getIdx(), 1);
		productFragmentMapper.updateSrcIdx(srcId, dest.getIdx());
	}

	@Override
	@Transactional
	public void moveAfter(String srcId, String destId) {
		ProductFragment dest  = productFragmentMapper.selectById(destId);
		productFragmentMapper.decAllAfterDest(dest.getProductId(), dest.getIdx(), -1);
		productFragmentMapper.updateSrcIdx(srcId, dest.getIdx());
	}

	@Override
	public int deleteByProductId(String productId) {
		return productFragmentMapper.deleteByProductId(productId);
	}
}
