package com.vdlm.dal.mapper;

import com.vdlm.dal.model.OrderItemPromotion;
import com.vdlm.dal.model.OrderItemPromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemPromotionMapper {
    int countByExample(OrderItemPromotionExample example);

    int deleteByExample(OrderItemPromotionExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrderItemPromotion record);

    int insertSelective(OrderItemPromotion record);

    List<OrderItemPromotion> selectByExample(OrderItemPromotionExample example);

    OrderItemPromotion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrderItemPromotion record, @Param("example") OrderItemPromotionExample example);

    int updateByExample(@Param("record") OrderItemPromotion record, @Param("example") OrderItemPromotionExample example);

    int updateByPrimaryKeySelective(OrderItemPromotion record);

    int updateByPrimaryKey(OrderItemPromotion record);
}