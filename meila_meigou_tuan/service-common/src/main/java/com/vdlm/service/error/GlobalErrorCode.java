package com.vdlm.service.error;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GlobalErrorCode {
	// 
	SUCESS(200, "Success"),
	//
	UNAUTHORIZED(401, "Unauthorized"),
	//第三方接口授权失败
	AUTHENTICATION(407, "Authentication"),
	//
	NOT_FOUND(404, "Resource not found"),
	//
	INTERNAL_ERROR(500, "Server internal error"),
	//
	INVALID_ARGUMENT(11001, "Invalid argument"),
	//错误的参数，原参数已修改， 页面需重新刷新
	INVALID_ARGUMENT_2(11002, "Invalid argument"),
	//
	THIRDPLANT_BUZERROR(700, "Business error"),
	//
	UNKNOWN(10001, "Unknown error"),

	MEILA_SUCCESS(0, "meila success"),
	MEILA_NO_LOGIN(1, "meila msg"),
	MEILA_CHECK_REQ_ERROR(-1, "meila msg"),
	MEILA_REUQEST_AUTH_CODE(300,"request Authentication code or request open id");

	private static final Map<Integer, GlobalErrorCode> values = new HashMap<Integer, GlobalErrorCode>();
	static {
		for (GlobalErrorCode ec : GlobalErrorCode.values()) {
			values.put(ec.errorCode, ec);
		}
	}

	private int errorCode;
	private String error;

	private GlobalErrorCode(int errorCode, String error) {
		this.errorCode = errorCode;
		this.error = error;
	}

	public static GlobalErrorCode valueOf(int code) {
		GlobalErrorCode ec = values.get(code);
		if (ec != null)
			return ec;
		return UNKNOWN;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getError() {
		return error;
	}
}
