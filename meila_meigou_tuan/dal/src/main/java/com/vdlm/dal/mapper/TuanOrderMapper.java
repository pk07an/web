package com.vdlm.dal.mapper;

import com.vdlm.dal.model.TuanOrder;

public interface TuanOrderMapper {
  

    int insert(TuanOrder record);

   
    TuanOrder selectByPrimaryKey(Long id);


    int update(TuanOrder record);
}