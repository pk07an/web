package com.vdlm.service.http;

/**
 *
 * @author chenxi
 */

public interface HttpResultCallback<T>
{
	int getSuccessCode();
	
	T doConvert(String content) throws Exception;
	
	HttpErrorStatusException returnException(int statusCode);
}
