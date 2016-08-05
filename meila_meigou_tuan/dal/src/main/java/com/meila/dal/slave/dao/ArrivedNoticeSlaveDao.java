package com.meila.dal.slave.dao;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.ArrivedNoticeVO;

public interface ArrivedNoticeSlaveDao {

	ArrivedNoticeVO selectValidBybuyerIdAndProductId(@Param("buyerId") String buyerId, @Param("productId") String productId);

	int countValidBybuyerIdAndProductId(@Param("productId") String productId);
}
