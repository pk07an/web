package com.vdlm.dal.mapper;

import java.util.List;

import com.vdlm.dal.model.Poster;

public interface PosterMapper {
	
	Poster load(String id);

	int insert(Poster record);

    List<Poster> selectAll();

    List<Poster> selectByTag(String tag);

}
