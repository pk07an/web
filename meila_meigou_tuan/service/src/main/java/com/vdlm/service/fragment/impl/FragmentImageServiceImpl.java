package com.vdlm.service.fragment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meila.dal.slave.dao.FragmentImageSlaveDao;
import com.vdlm.dal.mapper.FragmentImageMapper;
import com.vdlm.dal.model.FragmentImage;
import com.vdlm.dal.vo.FragmentImageVO;
import com.vdlm.service.common.BaseServiceImpl;
import com.vdlm.service.fragment.FragmentImageService;

@Service("fragmentImageService")
public class FragmentImageServiceImpl extends BaseServiceImpl implements FragmentImageService{
	
	@Autowired
	private FragmentImageMapper fragmentImageMapper;
	@Autowired
	private FragmentImageSlaveDao fragmentImageSlaveDao;

	@Override
	public int insert(FragmentImage fragmentImage) {
		Integer maxIdx = fragmentImageMapper.selectMaxByFragmentId(fragmentImage.getFragmentId());
		fragmentImage.setIdx(maxIdx == null ? 0 : maxIdx + 1);
		return fragmentImageMapper.insert(fragmentImage);
	}
	
	public int deleteById(String id) {
		return fragmentImageMapper.deleteById(id);
	}
	
	@Override
	public int deleteByFragmentId(String id) {
		return fragmentImageMapper.deleteByFragmentId(id);
	}

	@Override
	public List<FragmentImageVO> selectByFragmentId(String fragmentId) {
		return fragmentImageMapper.selectByFragmentId(fragmentId);
	}
	@Override
	public List<FragmentImageVO> selectByFragmentIdSlave(String fragmentId) {
	    return fragmentImageSlaveDao.selectByFragmentId(fragmentId);
	}
	
	@Override
	public List<FragmentImageVO> selectByImgKey(String imgKey){
		return fragmentImageMapper.selectByImgKey(imgKey);
	}
	
	@Override
	@Transactional
	public void moveBefore(String srcId, String destId) {
		FragmentImageVO dest  = fragmentImageMapper.selectById(destId);
		fragmentImageMapper.incAllBeforeDest(dest.getFragmentId(), dest.getIdx(), 1);
		fragmentImageMapper.updateSrcIdx(srcId, dest.getIdx());
	}

	@Override
	@Transactional
	public void moveAfter(String srcId, String destId) {
		FragmentImageVO dest  = fragmentImageMapper.selectById(destId);
		fragmentImageMapper.decAllAfterDest(dest.getFragmentId(), dest.getIdx(), -1);
		fragmentImageMapper.updateSrcIdx(srcId, dest.getIdx());
	}

	@Override
	public void delete4Update(String fragmentId, List<String> ids) {
		fragmentImageMapper.delete4Update(fragmentId, ids);
	}
}
