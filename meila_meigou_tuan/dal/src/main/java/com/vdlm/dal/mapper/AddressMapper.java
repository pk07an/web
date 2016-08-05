package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Address;

public interface AddressMapper {
	
    int insert(Address record);

    Address selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Address record);

	Address selectUserAddress(String userId, String addressId);
	
	List<Address> selectUserAddresses(String userId);

	int updateForArchive(String addressId);
	
	int updateForUnArchive(String addressId);

	Address selectOrderAddress(String orderId);

    Address selectLatestUserAddresses(String userId);

	void updateForUnCommon(String userId);

	void updateForCommon(String id);
	
    int updateForArchiveByUserId(@Param("id") String id, @Param("userId") String userId);
    
    Address selectDefaultAddressByUser(String userId);
}