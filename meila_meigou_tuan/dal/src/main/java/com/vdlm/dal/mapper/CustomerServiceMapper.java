package com.vdlm.dal.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.CustomerService;

public interface CustomerServiceMapper {
	CustomerService load(String id);
	
	List<CustomerService> loadAll();
	
	List<CustomerService> selectByName(String name);
	
	List<CustomerService> selectByPhone(String phone);
	
	List<CustomerService> getSupportByScope(@Param("scope") String scope);
	
	int deleteByPrimaryKey(String id);
	
	int undeleteByPrimaryKey(String id);
	
	int insert(CustomerService e);
	
	
	
}
