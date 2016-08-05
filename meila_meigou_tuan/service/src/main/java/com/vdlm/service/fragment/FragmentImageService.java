package com.vdlm.service.fragment;

import java.util.List;

import com.vdlm.dal.model.FragmentImage;
import com.vdlm.dal.vo.FragmentImageVO;
import com.vdlm.service.BaseService;

public interface FragmentImageService extends BaseService {

	int insert(FragmentImage fragmentImage);
	
	int deleteById(String id);

	int deleteByFragmentId(String fragmentId);
	
	void delete4Update(String fragmentId, List<String> ids);

	List<FragmentImageVO> selectByFragmentId(String fragmentId);

	List<FragmentImageVO> selectByImgKey(String imgKey);
	
	void moveBefore(String srcId, String desId);

	void moveAfter(String srcId, String desId);

    List<FragmentImageVO> selectByFragmentIdSlave(String fragmentId);
}
