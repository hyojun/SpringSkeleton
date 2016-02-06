package com.outsiderslab.skeleton.exception;

import com.outsiderslab.skeleton.model.ResultCode;

public class InvalidParameterException extends BaseException {
	private static final long serialVersionUID = -3498253780009093416L;

	{
		errorCode = ResultCode.INVALID_PARAMERTER;
	}

	public InvalidParameterException() {
	}

	public InvalidParameterException(Throwable throwable) {
		super(throwable);
	}
}
