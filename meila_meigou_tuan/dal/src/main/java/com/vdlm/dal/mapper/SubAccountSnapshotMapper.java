package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.SubAccountSnapshot;

public interface SubAccountSnapshotMapper {

    int insert(SubAccountSnapshot record);

    List<SubAccountSnapshot> selectByAccountId(@Param(value="accountId") String accountId);
}