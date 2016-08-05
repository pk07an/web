package com.vdlm.service.address.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdlm.dal.mapper.AddressMapper;
import com.vdlm.dal.model.Address;
import com.vdlm.dal.model.User;
import com.vdlm.dal.model.Zone;
import com.vdlm.service.address.AddressService;
import com.vdlm.service.address.AddressVO;
import com.vdlm.service.common.BaseServiceImpl;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.zone.ZoneService;

@Service("addressService")
public class AddressServiceImpl extends BaseServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;
	
	@Autowired
	private ZoneService zoneService;

	@Override
	public AddressVO saveUserAddress(Address address) {  		
		if (StringUtils.isEmpty(address.getId())) {		
			User user = this.getCurrentUser();
			if (null != user){
				address.setUserId(user.getId());			
			}else{
				log.error("未登录！");
				return null;
			}
		    List<Address> addressList= listUserAddresses(user.getId());
		    if(addressList!=null && addressList.size()>0)
		    	address.setCommon(false);
		    else
		    	address.setCommon(true);		    
		    addressMapper.insert(address);		
		} else {
			Address add=this.load(address.getId());
			if(add!=null)
				address.setCommon(add.getCommon());
			else
				address.setCommon(false);
		    addressMapper.updateByPrimaryKeySelective(address);
		}
		
		List<Zone> zoneList = zoneService.listParents(address.getZoneId());
        String details = "";
        for (Zone zone : zoneList) {
            details += zone.getName();
        }
        details += address.getStreet();
        AddressVO vo = new AddressVO(address, details);
        vo.setZones(zoneList);
        
		return vo;
	}

//	@Override
//	public Address updateUserAddress(Address address) {
//		User user = this.getCurrentUser();
//		if (null != user){
//			address.setUserId(user.getId());			
//		}
//		addressMapper.updateByPrimaryKeySelective(address);
//		return address;
//	}

	@Override
	public AddressVO loadUserAddress(String addressId) {
		User user = this.getCurrentUser();
		Address address = addressMapper.selectUserAddress(user.getId(), addressId);
		
		List<Zone> zoneList = zoneService.listParents(address.getZoneId());
        String details = "";
        for (Zone zone : zoneList) {
            details += zone.getName();
        }
        details += address.getStreet();
        AddressVO vo = new AddressVO(address, details);
        vo.setZones(zoneList);
        
		return vo;
	}

	@Override
	public List<AddressVO> listUserAddresses() {
		User user = this.getCurrentUser();
		List<Address> addresses = addressMapper.selectUserAddresses(user.getId());
		
		List<AddressVO> result = new ArrayList<AddressVO>();
		for (Address address : addresses) {
		    
		    List<Zone> zoneList = zoneService.listParents(address.getZoneId());
	        String details = "";
			for (Zone zone : zoneList) {
				//增加非空判断，提高程序健壮性
				if (null != zone) {
					details += zone.getName();
				}
			}
	        details += address.getStreet();
	        AddressVO vo = new AddressVO(address, details);
	        
	        vo.setZones(zoneList);
	        result.add(vo);
        }
		return result;
	}

	@Override
	public List<Address> listUserAddresses(String userId) {
		return addressMapper.selectUserAddresses(userId);
	}

	@Override
	public int archiveAddress(String addressId) {
		int result = addressMapper.updateForArchive(addressId);
		return result;
	}

	public int insert(Address e) {
		return addressMapper.insert(e);
	}

	@Override
	public Address load(String id) {
		return addressMapper.selectUserAddress(getCurrentUser().getId(), id);
	}

    @Override
    public int delete(String id) {
        User user = this.getCurrentUser();
        if (null != user) {
            return addressMapper.updateForArchiveByUserId(id, user.getId());
        }else{
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "地址删除失败");
        }
    }

	@Override
	public int undelete(String id) {
		return addressMapper.updateForUnArchive(id);
	}

	/**
	 * 功能描述：FIXME 需要优化，查询了两次。
	 * @param id
	 * @return
	 */
	@Override
	public Address asDefault(String id) {
		// addressMapper.updateByPrimaryKeySelective(id);
		Address ad = load(id);
		if(ad==null){
			return null;
		}		
		addressMapper.updateForUnCommon(ad.getUserId());		
		addressMapper.updateForCommon(id);
		return ad;
	}
	
	
    @Override
    public AddressVO getLatestUserAddresses(String userId) {
        Address address = addressMapper.selectLatestUserAddresses(userId);
        
        List<Zone> zoneList = zoneService.listParents(address.getZoneId());
        String details = "";
        for (Zone zone : zoneList) {
            details += zone.getName();
        }
        details += address.getStreet();
        AddressVO vo = new AddressVO(address, details);
        vo.setZones(zoneList);
        
        return vo;
    }
    
    @Override
    public Address selectDefaultAddressByUser() {
        return addressMapper.selectDefaultAddressByUser(getCurrentUser().getId());
    }

}
