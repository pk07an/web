package com.vdlm.dal.mapper;

import com.vdlm.dal.model.TuanStatus;

public interface TuanStatusMapper {
    int insert(TuanStatus record);

    TuanStatus selectByPrimaryKey(Long id);

    int update(TuanStatus tuanStatus);

}
