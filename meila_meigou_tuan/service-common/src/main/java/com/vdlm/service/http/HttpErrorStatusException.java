package com.vdlm.service.http;

/**
 *
 * @author: chenxi
 */

public class HttpErrorStatusException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6672565418562893127L;

	private final int statusCode;
	
	public HttpErrorStatusException(int statusCode) {
        super();
        this.statusCode = statusCode;
    }

    public HttpErrorStatusException(String msg, int statusCode) {
        super(msg);
        this.statusCode = statusCode;
    }

    public HttpErrorStatusException(Throwable t, int statusCode) {
        super(t);
        this.statusCode = statusCode;
    }

    public HttpErrorStatusException(String msg, Throwable t, int statusCode) {
        super(msg, t);
        this.statusCode = statusCode;
    }

	public int getStatusCode() {
		return statusCode;
	}
}
