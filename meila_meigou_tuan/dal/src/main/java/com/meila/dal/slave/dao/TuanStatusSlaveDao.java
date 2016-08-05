package com.meila.dal.slave.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.TuanStatus;

public interface TuanStatusSlaveDao {

    int countValidTuanByActId(long actId);

    int countUserValidTuanByActIdAndUserId(@Param("actId") long actId, @Param("userId") long userId);

    TuanStatus selectTuanStatusByTuanNo(@Param("tuanNo") String tuanNo);

    TuanStatus selectTuanStatus(Long groupBuyingId);
    
    List<Map<String, Object>> countAllValidTuanMap();
    
    List<TuanStatus> selectCanJoinTuanListByActId(@Param("actId")long actId,@Param("limit")int limit,@Param("userId")long userId);
}
