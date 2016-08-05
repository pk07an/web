package com.vdlm.dal.mapper;

import java.util.List;

import com.vdlm.dal.model.PostConf;
import com.vdlm.dal.model.Zone;

public interface ZoneMapper {
	Zone selectByPrimaryKey(String id);
	
	List<Zone> listRoots();
	
	List<Zone> listChildren(String zoneId);
	
	Zone findParent(String zoneId);

	List<Zone> selectByIds(List<String> params);
	
	List<Zone> findByName(String name);
	
	List<PostConf> findPostArea(String name);
	
	List<PostConf> selectPostConf();

	void updatePath(String id, String path); 
	
	boolean isDescendant(String id, String decendantId);

    List<Zone> listSiblings(String zoneId);
    
    List<Zone> listPostAgeArea();
    List<Zone> selectCity4PostAge();
    
}