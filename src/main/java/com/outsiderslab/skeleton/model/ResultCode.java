package com.outsiderslab.skeleton.model;

public enum ResultCode {
	SUCCESS(0),
	INVALID_PARAMERTER(401),
	FAIL_TO_MAKE_RESPONSE(501),
	FATAL(900),
	;
	
	private int code;
	
	private ResultCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
