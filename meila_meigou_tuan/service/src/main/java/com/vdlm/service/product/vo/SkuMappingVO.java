package com.vdlm.service.product.vo;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.vdlm.dal.model.SkuMapping;

public class SkuMappingVO extends SkuMapping {
	private static final long serialVersionUID = 1L;
	List<String> mappingValues;
	
	//供json转java使用
	public SkuMappingVO(){
		
	}
	
	public SkuMappingVO(SkuMapping skuMapping){
		BeanUtils.copyProperties(skuMapping, this);
	}
	
	public List<String> getMappingValues() {
		return mappingValues;
	}
	public void setMappingValues(List<String> mappingValues) {
		this.mappingValues = mappingValues;
	}

	
}
