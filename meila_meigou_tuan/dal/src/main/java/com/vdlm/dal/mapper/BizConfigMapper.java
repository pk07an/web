package com.vdlm.dal.mapper;

import com.vdlm.dal.model.BizConfig;
import com.vdlm.dal.model.BizConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizConfigMapper {
    int countByExample(BizConfigExample example);

    int deleteByExample(BizConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizConfig record);

    int insertSelective(BizConfig record);

    List<BizConfig> selectByExample(BizConfigExample example);

    BizConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizConfig record, @Param("example") BizConfigExample example);

    int updateByExample(@Param("record") BizConfig record, @Param("example") BizConfigExample example);

    int updateByPrimaryKeySelective(BizConfig record);

    int updateByPrimaryKey(BizConfig record);

    BizConfig selectByUqKey(@Param("name") String name, @Param("group") String group);
}