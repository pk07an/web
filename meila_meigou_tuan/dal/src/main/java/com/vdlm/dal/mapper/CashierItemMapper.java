package com.vdlm.dal.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.CashierItem;
import com.vdlm.dal.type.PaymentMode;
import com.vdlm.dal.vo.CouponInfoVO;

public interface CashierItemMapper {
	
	CashierItem selectByPrimaryKey(String id);

	int insert(CashierItem item);
	
	int deleteCouponByBizNo(@Param("bizNo") String bizNo);
	
	int deletePaymentByBizNo(@Param("bizNo") String bizNo);
	
	int deleteByBizNo(@Param("bizNo") String bizNo);
	
	CashierItem loadCashierItemByBizIdAndChannel(@Param("bizNo") String bizNo, @Param("mode") PaymentMode mode);
	
	List<CashierItem> listByBizNo(@Param("bizNo") String bizNo);
	
	int paid(@Param("id") String id);
	
	BigDecimal loadPaidFee(@Param("bizNo") String bizNo);
	
	List<Map<String, Object>> loadHongBaoFee(@Param("bizNo") String bizNo);
	
	int update(CashierItem item);
	
	List<CouponInfoVO> loadCouponInfoByOrderNo(@Param("bizNo") String bizNo);

	List<CashierItem> listByBatchBizNos(@Param("batchBizNo") String batchBizNo);
}
