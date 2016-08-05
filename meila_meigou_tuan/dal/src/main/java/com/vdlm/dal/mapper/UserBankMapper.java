package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.UserBank;

public interface UserBankMapper {
    int updateForArchive(String id);
    
    int updateForUnArchive(String id);

    int insert(UserBank record);

    UserBank selectByPrimaryKey(String id);
    
    List<UserBank> listByUserId(@Param(value="userId") String userId);

    int updateByPrimaryKeySelective(UserBank record);

    /**
     * 累计收入
     * @param userId
     * @return
     */
    int accumulatedIncomeIncomeByUserId(@Param(value="userId") String userId);
}