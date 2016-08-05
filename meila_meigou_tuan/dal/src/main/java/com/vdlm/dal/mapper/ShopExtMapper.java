package com.vdlm.dal.mapper;

import com.vdlm.dal.model.ShopExt;
import com.vdlm.dal.model.ShopExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopExtMapper {
    int countByExample(ShopExtExample example);

    int deleteByExample(ShopExtExample example);

    int deleteByPrimaryKey(String id);

    int insert(ShopExt record);

    int insertSelective(ShopExt record);

    List<ShopExt> selectByExample(ShopExtExample example);

    ShopExt selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ShopExt record, @Param("example") ShopExtExample example);

    int updateByExample(@Param("record") ShopExt record, @Param("example") ShopExtExample example);

    int updateByPrimaryKeySelective(ShopExt record);

    int updateByPrimaryKey(ShopExt record);
}