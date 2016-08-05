package com.meila.dal.slave.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.vo.FragmentVO;



public interface FragmentSlaveDao {
    
    List<FragmentVO> selectByProductId(@Param(value="productId") String productId);
    
}
