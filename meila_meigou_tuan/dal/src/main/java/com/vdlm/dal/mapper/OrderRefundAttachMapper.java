package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.OrderRefundAttach;

public interface OrderRefundAttachMapper {

    int insert(OrderRefundAttach record);

    OrderRefundAttach selectByPrimaryKey(@Param("id")String id);

    List<OrderRefundAttach> listByRefundId(@Param("refundId") String refundId);

}