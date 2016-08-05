package com.meila.dal.slave.dao;

import com.vdlm.dal.model.TuanActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TuanActivitySlaveDao {

    TuanActivity selectById(@Param("id") Long id);

    List<TuanActivity> selectAllTuanActivityList(@Param("isTest") boolean isTest);
}
