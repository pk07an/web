package com.vdlm.service.address;

import java.util.List;

import com.vdlm.dal.model.Address;
import com.vdlm.service.ArchivableEntityService;

public interface AddressService extends ArchivableEntityService<Address> {

	/**
	 * 保存用户地址
	 * @param address
	 * @return
	 */
    AddressVO saveUserAddress(Address address);
	
	/**
	 * 更新用户地址
	 * @param address
	 * @return
	 */
//	Address updateUserAddress(Address address);
	
	/**
	 * 用户获取某一地址
	 * @param addressId
	 * @return
	 */
    AddressVO loadUserAddress(String addressId);
	
	/**
	 * 获取用户的所有地址
	 * @param userId
	 * @return
	 */
	List<AddressVO> listUserAddresses();
	
	AddressVO getLatestUserAddresses(String userId);
	
	/**
	 * 获取会话用户的所有地址
	 * @param userId
	 * @return
	 */
	List<Address> listUserAddresses(String userId);

	/**
	 * 用户删除地址
	 * @param userId
	 * @return
	 */
	int archiveAddress(String addressId);

	/**
	 * 用户设置默认地址
	 * @param userId
	 * @return
	 */
	Address asDefault(String id);

    Address selectDefaultAddressByUser();
}
