package com.vdlm.dal.mapper;

import com.vdlm.dal.model.ProductUpdateLog;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

/**
 * 商品更新记录 映射mapper类 by reese  2015/7/15
 */
public interface ProductUpdateLogMapper {

    int deleteByPrimaryKey(String id);

    int insert(ProductUpdateLog record);

    int insertSelective(ProductUpdateLog record);

    ProductUpdateLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductUpdateLog record);

    int updateByPrimaryKey(ProductUpdateLog record);

    int updateSelectiveInfo(@Param(value="map") Map<String,Object> params);

    int insertInfo(@Param(value="map") Map<String,Object> params);

    int updateImageById(@Param(value="id") String id ,@Param(value="key") String key );

}