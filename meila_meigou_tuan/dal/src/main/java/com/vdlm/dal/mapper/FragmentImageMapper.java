package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.FragmentImage;
import com.vdlm.dal.vo.FragmentImageVO;

public interface FragmentImageMapper {

	int insert(FragmentImage fragmentImage);
	
	int deleteById(@Param(value="id") String id);

	int deleteByFragmentId(@Param(value="fragmentId") String fragmentId);
	
	FragmentImageVO selectById(@Param(value="id") String id);

	Integer selectMaxByFragmentId(@Param(value="fragmentId") String fragmentId);
	
	List<FragmentImageVO> selectByFragmentId(@Param(value="fragmentId") String fragmentId);
	
	List<FragmentImageVO> selectByImgKey(@Param(value="imgKey") String imgKey);
	
	void incAllBeforeDest(@Param(value="fragmentId") String fragmentId, @Param(value="idx") int idx, @Param(value="increment") int increment);
	
	void decAllAfterDest(@Param(value="fragmentId") String fragmentId, @Param(value="idx") int idx, @Param(value="increment") int increment);
	
	int updateSrcIdx(@Param(value="id") String id, @Param(value="idx") int idx);
	
	void delete4Update(@Param("fragmentId")String fragmentId, @Param("ids")List<String> ids);
}
