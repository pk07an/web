package com.vdlm.service.fragment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meila.dal.slave.dao.FragmentSlaveDao;
import com.vdlm.dal.mapper.FragmentMapper;
import com.vdlm.dal.model.Fragment;
import com.vdlm.dal.vo.FragmentVO;
import com.vdlm.service.common.BaseServiceImpl;
import com.vdlm.service.fragment.FragmentService;

@Service("fragmentService")
public class FragmentServiceImpl extends BaseServiceImpl implements FragmentService{
	
	@Autowired
	private FragmentMapper fragmentMapper;
	
	@Autowired
	private FragmentSlaveDao fragmentSlaveDao;
	
	@Override
	public int insert(Fragment fragment) {
		Integer maxIdx = fragmentMapper.selectMaxByShopId(fragment.getShopId());
		fragment.setIdx(maxIdx == null ? 0 : maxIdx + 1);
		int rc = fragmentMapper.insert(fragment);
		fragmentMapper.addCode(fragment.getId());
		return rc;
	}

	@Override
	public int update(Fragment fragment) {
		return fragmentMapper.update(fragment);
	}
	
	@Override
	public int delete(String id) {
		return fragmentMapper.deleteById(id);
	}

	@Override
	public FragmentVO selectById(String id) {
		return fragmentMapper.selectById(id);
	}

	@Override
	public List<FragmentVO> selectByProductId(String productId){
		return fragmentMapper.selectByProductId(productId);
	}
	
	@Override
	public List<FragmentVO> selectByProductIdSlave(String productId){
	    return fragmentSlaveDao.selectByProductId(productId);
	}
	
	@Override
	public List<FragmentVO> selectByShopId(String shopId) {
		return fragmentMapper.selectByShopId(shopId);
	}

	@Override
	@Transactional
	public void moveBefore(String srcId, String destId) {
		FragmentVO dest  = fragmentMapper.selectById(destId);
		fragmentMapper.incAllBeforeDest(dest.getShopId(), dest.getIdx(), 1);
		fragmentMapper.updateSrcIdx(srcId, dest.getIdx());
	}

	@Override
	@Transactional
	public void moveAfter(String srcId, String destId) {
		FragmentVO dest  = fragmentMapper.selectById(destId);
		fragmentMapper.decAllAfterDest(dest.getShopId(), dest.getIdx(), -1);
		fragmentMapper.updateSrcIdx(srcId, dest.getIdx());
	}
}
