package com.vdlm.service.http;

/**
 *
 * @author: chenxi
 */

public class HttpResult<T> {

	private final boolean success;
	private final T content;
	private HttpErrorStatusException exception;
	
	public HttpResult() {
		this(false);
	}
	
	public HttpResult(boolean success) {
		this(success, null);
	}
	
	public HttpResult(boolean success, T content) {
		this.success = success;
		this.content = content;
	}

	public boolean isSuccess() {
		return success;
	}

	public T getContent() throws Exception {
//		if (exception != null)
//			throw exception;
		return content;
	}

	public HttpErrorStatusException getException() {
		return exception;
	}

	public void setException(HttpErrorStatusException exception) {
		this.exception = exception;
	}
	
}
