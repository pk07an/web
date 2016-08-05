package com.vdlm.dal.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.Account;
import com.vdlm.dal.vo.DealHistoryVO;

public interface AccountMapper {
	
    int insert(Account record);

    List<DealHistoryVO> listDealByAccountId(@Param("accountId")String accountId, @Param("page")Pageable page);
    
    Account selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    int addBalance(@Param("accountId") String accountId, @Param("amount") BigDecimal amount);

    int subBalance(@Param("accountId") String accountId, @Param("amount") BigDecimal amount);

    int freezeBalance(@Param("accountId") String accountId, @Param("amount") BigDecimal amount);
    
    int unFreezeBalance(@Param("accountId") String accountId, @Param("amount") BigDecimal amount);
    
	Account selectByUserId(String userId);
	
	/**
	 * 可以提现的账号列表，用于自动提现
	 * @return
	 */
	List<Account> listByCanWithdraw();
	
}