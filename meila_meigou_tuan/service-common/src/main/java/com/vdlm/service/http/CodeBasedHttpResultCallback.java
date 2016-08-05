package com.vdlm.service.http;

/**
 *
 * @author: chenxi
 */

public class CodeBasedHttpResultCallback implements HttpResultCallback<Boolean> {

	private int successCode;
	
	public CodeBasedHttpResultCallback(int successCode) {
		this.successCode = successCode;
	}
	
	@Override
	public Boolean doConvert(String content) throws Exception {
		return true;
	}

	@Override
	public int getSuccessCode() {
		return successCode;
	}

	@Override
	public HttpErrorStatusException returnException(int statusCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
