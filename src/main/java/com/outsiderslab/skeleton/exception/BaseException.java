package com.outsiderslab.skeleton.exception;

import com.outsiderslab.skeleton.model.ResultCode;

public abstract class BaseException extends RuntimeException {
	private static final long serialVersionUID = -1690285182249044075L;
	protected ResultCode errorCode;
	
	public BaseException(){
	}
	
	public BaseException(Throwable throwable){
		super(throwable);
	}
	
	public ResultCode getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(ResultCode errorCode) {
		this.errorCode = errorCode;
	}
}
