package com.vdlm.dal.mapper;

import com.vdlm.dal.model.OrderExt;
import com.vdlm.dal.model.OrderExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderExtMapper {
    int countByExample(OrderExtExample example);

    int deleteByExample(OrderExtExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrderExt record);

    int insertSelective(OrderExt record);

    List<OrderExt> selectByExample(OrderExtExample example);

    OrderExt selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrderExt record, @Param("example") OrderExtExample example);

    int updateByExample(@Param("record") OrderExt record, @Param("example") OrderExtExample example);

    int updateByPrimaryKeySelective(OrderExt record);

    int updateByPrimaryKey(OrderExt record);
    
    List<OrderExt> selectOrderExtByOrderIdList(@Param("ids") List<String> ids);
}