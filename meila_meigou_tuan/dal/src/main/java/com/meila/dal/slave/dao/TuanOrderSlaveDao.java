package com.meila.dal.slave.dao;

import com.vdlm.dal.model.TuanOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TuanOrderSlaveDao {
    int countValidTuanOrderByTuanNo(@Param("tuanNo") String tuanNo);

    TuanOrder findOrderByUser(@Param("tuanId") Long tuanId, @Param("userId") Long userId);

    TuanOrder findOrderByUserNotInCancelled(@Param("tuanId") Long tuanId, @Param("userId") Long userId);

    List<TuanOrder> findTuanOrder(@Param("tuanId") Long tuanId);

    List<TuanOrder> selectUserTuanOrder(@Param("userId") long userId, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    long countUserTuanOrder(@Param("userId") long userId);

    int countValidTuanOrderByTuanNoAndUserId(@Param("tuanNo") String tuanNo, @Param("userId") long userId);

    List<TuanOrder> selectUserTuanOrderByActId(@Param("userId") long userId, @Param("actId") long actId);

    List<TuanOrder> findTuanOrderByTuanNo(@Param("tuanNo") String tuanNo);
}
