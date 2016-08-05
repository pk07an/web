package com.vdlm.dal.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.WithdrawApply;
import com.vdlm.dal.status.WithdrawApplyStatus;
import com.vdlm.dal.vo.WithdrawAdmin;

public interface WithdrawApplyMapper {
    
    int updateForArchive(String id);
    
    int updateForUnArchive(String id);

    int insert(WithdrawApply record);

    WithdrawApply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WithdrawApply record);
    
    List<WithdrawApply> listWithdrawApply(@Param("userId") String userId, @Param("status") WithdrawApplyStatus status, @Param("page") Pageable page);
    
    int pay(WithdrawApply record);
    
    BigDecimal totalWithdrawApplyByStatus(@Param("userId") String userId, @Param("status") WithdrawApplyStatus status);
    
    /**
	 * 用于后台提现管理
	 * @param page
	 * @return
	 */
	List<WithdrawAdmin> listWithdrawApplyByAdmin(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);
	
	Map<String, Object> countWithdrawApplyByAdmin(@Param(value="params") Map<String, Object> params);	
	
	int withdrawSuccessByNo(@Param(value="applyNo") String applyNo, @Param(value="confirmFee") BigDecimal confirmFee);
	
	WithdrawApply loadByApplyNo(@Param(value="applyNo") String applyNo);

	int cancel(@Param(value="id") String withdrawId, @Param(value="opRemark") String opRemark);
	
	int withdrawPendingByApplyNo(@Param(value="applyNo") String applyNo);
	
	int withdrawFailedByApplyNo(@Param(value="applyNo") String applyNo);
	
	int synchronousWithdrawByBank();
	
	int synchronousWithdrawByAliPay();
	
}