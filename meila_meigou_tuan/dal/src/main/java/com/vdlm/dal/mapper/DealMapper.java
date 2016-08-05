package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.Deal;
import com.vdlm.dal.status.DealStatus;
import com.vdlm.dal.type.DealType;
import com.vdlm.dal.vo.DealHistoryVO;

public interface DealMapper {
	
	Deal selectByPrimaryKey(String id);

	List<Deal> selectByOrder(String orderId);
	
	Deal selectByWithdraw(String withdrawId);

	List<Deal> selectByAccount(String accountId, DealStatus status);
	
	int insert(Deal record);
	
	int update(Deal record);
	
	int updateStatus(@Param("id") String id, @Param("status") DealStatus status);

	List<DealHistoryVO> listDealByUserId(@Param("userId")String userId, @Param("page")Pageable page);

	Deal selectByOrderAndType(@Param("orderId")String orderId, @Param("type")DealType type);
	
	List<Deal> initDeal2PayRequest();
}
