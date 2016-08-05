package com.vdlm.service.zone;
import java.util.Map;
import java.util.List;






import com.vdlm.dal.model.Zone;

public interface ZoneService {
	
	Zone load(String id);
	
	List<Zone> listRoots();
	
	List<Zone> listChildren(String zoneId);
	
	List<Zone> listSiblings(String zoneId);
	
	Zone findParent(String zoneId);
	
	List<Zone> listParents(String zoneId);
	
	Map<String, List<String>> loadPostFreeList();
	
	void updateZonePath(String id);
	
	List<Zone> listPostageZones();
	List<Zone> listPostageCityZones();
}
