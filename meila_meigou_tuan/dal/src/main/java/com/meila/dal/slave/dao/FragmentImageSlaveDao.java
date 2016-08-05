package com.meila.dal.slave.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.vo.FragmentImageVO;

public interface FragmentImageSlaveDao {

    List<FragmentImageVO> selectByFragmentId(@Param(value="fragmentId") String fragmentId);
 
}
