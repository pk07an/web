package com.vdlm.dal.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.SubAccount;
import com.vdlm.dal.type.AccountType;
import com.vdlm.dal.vo.SubAccountVO;

public interface SubAccountMapper {

	int insert(SubAccount record);

    SubAccount selectByPrimaryKey(String id);
    
    /**
     * 根据账号及账号类别获得子账号对象
     * @param accountId
     * @param accountType
     * @return
     */
    SubAccount selectByAccountIdAndType(@Param(value="accountId")String accountId, @Param(value="accountType") AccountType accountType);

    int updateByPrimaryKeySelective(SubAccount record);

    int addBalance(@Param(value="id")String id, @Param(value="amount")BigDecimal amount);
    
    int lockSubAccount(String id);
    
    List<SubAccount> listByAccountId(String accountId);
    
    List<SubAccountVO> listByCanWithdraw(@Param(value="accountType") AccountType accountType);
    
    List<SubAccount> selectBalanceByUser(@Param("userId") String userId);
    
    BigDecimal selectBalanceByUserAndType(@Param("userId") String userId, @Param(value="accountType") AccountType accountType);
    
}