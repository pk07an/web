package com.vdlm.service.common;

public interface SignService {
	
	boolean signCheck(String partner,String sign,String queryString);
	
	String signQuery(String partner,String queryString);

	String sign(String partner,String queryString);
}
