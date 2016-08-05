package com.vdlm.dal.mapper;

import com.vdlm.dal.model.PaymentRequestLogs;
import com.vdlm.dal.model.PaymentRequestLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentRequestLogsMapper {
    int countByExample(PaymentRequestLogsExample example);

    int deleteByExample(PaymentRequestLogsExample example);

    int deleteByPrimaryKey(String id);

    int insert(PaymentRequestLogs record);

    int insertSelective(PaymentRequestLogs record);

    List<PaymentRequestLogs> selectByExample(PaymentRequestLogsExample example);

    PaymentRequestLogs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PaymentRequestLogs record, @Param("example") PaymentRequestLogsExample example);

    int updateByExample(@Param("record") PaymentRequestLogs record, @Param("example") PaymentRequestLogsExample example);

    int updateByPrimaryKeySelective(PaymentRequestLogs record);

    int updateByPrimaryKey(PaymentRequestLogs record);
}