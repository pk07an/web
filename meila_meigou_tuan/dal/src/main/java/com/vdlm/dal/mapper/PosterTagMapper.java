package com.vdlm.dal.mapper;

import com.vdlm.dal.model.PosterTag;

public interface PosterTagMapper {
	
    PosterTag load(String id);

	int insert(PosterTag po);

    PosterTag delete(String posterId, String id);

}
