package com.vdlm.service.common.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.vdlm.service.common.SignService;

public abstract class BaseSignServiceImpl implements SignService{
	 protected String sortQueryString(String queryString){
		String[] fields = queryString.split("&");
		HashMap<String,String> sortMap = new HashMap<String,String>();
		for (String field:fields){
			String[] keyValue = field.split("=");
			if (keyValue.length == 2){
				String key = keyValue[0];
				String value = keyValue[1];
				if (value != null){
					if (Character.isLetter(key.charAt(0))){
						if (!(key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("sign_type"))){
							sortMap.put(key, keyValue[1]);							
						}
					} else {
						return null;
					}	
				}	
			}
		}
		List<Entry<String, String>> infoIds =new ArrayList<Map.Entry<String, String>>(sortMap.entrySet());
		//排序
		Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {   
		    public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {      
		        return (o1.getKey()).toString().compareTo(o2.getKey());
		    }
		}); 
		
		StringBuffer sortQuery = new StringBuffer();
		for (int i = 0; i < infoIds.size(); i++) {
			sortQuery.append(infoIds.get(i).getKey());
			sortQuery.append("=");
			sortQuery.append(infoIds.get(i).getValue());
			if (i<infoIds.size()-1){
				sortQuery.append("&");				
			}
		}
		return sortQuery.toString();
	}
	 
	abstract protected String getKey(String partner);
}
