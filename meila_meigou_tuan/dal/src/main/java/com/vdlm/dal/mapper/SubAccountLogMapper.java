package com.vdlm.dal.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.SubAccountLog;
import com.vdlm.dal.vo.TradeDetailsVO;

public interface SubAccountLogMapper {

    int insert(SubAccountLog record);

    SubAccountLog selectByPrimaryKey(String id);

    Map<String,Object> countTradeDetailsByUserId(Map<String, Object> params);
    
    List<TradeDetailsVO> queryTradeDetailsByUserId(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);
    
    BigDecimal totalAmountByParams(@Param(value="params") Map<String, Object> params);
}