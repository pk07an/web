package com.vdlm.service.zone.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vdlm.dal.mapper.ZoneMapper;
import com.vdlm.dal.model.PostConf;
import com.vdlm.dal.model.Zone;
import com.vdlm.service.common.BaseServiceImpl;
import com.vdlm.service.zone.ZoneService;

@Service("zoneService")
public class ZoneServiceImpl extends BaseServiceImpl implements ZoneService {

	@Autowired
	private ZoneMapper zoneMapper;
	
	@Override
	public List<Zone> listRoots() {
		return zoneMapper.listRoots();
	}

	@Override
	public List<Zone> listChildren(String zoneId) {
		List<Zone> list = zoneMapper.listChildren(zoneId);
		return list;
	}

	@Override
	public Zone findParent(String zoneId) {
		return zoneMapper.findParent(zoneId);
	}

	@Override
	public Zone load(String id) {
		return zoneMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Zone> listParents(String zoneId) {
		List<Zone> zones = new ArrayList<Zone>();
		Zone zone = zoneMapper.selectByPrimaryKey(zoneId);
		if (zone == null) {
			return zones;
		}
		
		String path = zone.getPath();
		String[] zoneIds = path.split(">");
		
		for (String zId : zoneIds) {
			if (StringUtils.isEmpty(zId)) {
				continue;
			}
			zones.add(zoneMapper.selectByPrimaryKey(zId));
		}
		zones.add(zone);
		return zones;
	}

	@Override
	public Map<String, List<String>> loadPostFreeList() {
		List<PostConf>zoneList =  zoneMapper.selectPostConf();
		if (null == zoneList || 0 == zoneList.size()) return null;
		Map<String, List<String>> ret = new HashedMap<String, List<String>>();
		List<String> commonList = new ArrayList<String>(); 
		List<String> cityList = new ArrayList<String>();
		List<String> provList = new ArrayList<String>();
		for (PostConf aZone : zoneList) {
			if (aZone.getRegionType().equals("0")) {
				commonList.add(aZone.getName());
			} else if (aZone.getRegionType().equals("1")) {
				cityList.add(aZone.getName());
			} else if (aZone.getRegionType().equals("2")) {
				provList.add(aZone.getName());
			} else {
			}
		}
		ret.put("common", commonList);
		ret.put("city", cityList);
		ret.put("province", provList);
		return ret;
	}

	@Override
	public void updateZonePath(String id) {
		Zone zone = zoneMapper.selectByPrimaryKey(id);
		Zone parent = zoneMapper.selectByPrimaryKey(zone.getParentId());
		if (parent != null) {
			zoneMapper.updatePath(id, parent.getPath() + parent.getId() + ">");
		}
		List<Zone> children = zoneMapper.listChildren(id);
		for (Zone z : children) {
			updateZonePath(z.getId());
		}
	}

    @Override
    public List<Zone> listSiblings(String zoneId) {
        return zoneMapper.listSiblings(zoneId);
    }
    
    @Override
	public List<Zone> listPostageZones() {
    	return zoneMapper.listPostAgeArea();
    }

	@Override
	public List<Zone> listPostageCityZones() {
		return zoneMapper.selectCity4PostAge();
	}
    
}
