package com.vdlm.dal.mapper;

import java.util.List;

import com.vdlm.dal.model.Promotion;

public interface PromotionMapper {

    Promotion selectByPrimaryKey(String id);

    List<Promotion> selectAvailables();

}
