package com.vdlm.dal.vo;

import java.util.List;

import com.vdlm.dal.model.Fragment;

public class FragmentVO extends Fragment{
	
	private static final long serialVersionUID = 1L;
	
	private List<FragmentImageVO> imgs;

	public List<FragmentImageVO> getImgs() {
		return imgs;
	}

	public void setImgs(List<FragmentImageVO> imgs) {
		this.imgs = imgs;
	}
	
}
