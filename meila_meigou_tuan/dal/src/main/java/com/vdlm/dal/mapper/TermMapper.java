package com.vdlm.dal.mapper;

import com.vdlm.dal.model.Term;

public interface TermMapper {
	
	int insert(Term record);

	Term load(String id);

	Term loadByName(String term);
	
}
