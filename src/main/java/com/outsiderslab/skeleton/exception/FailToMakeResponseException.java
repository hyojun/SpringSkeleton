package com.outsiderslab.skeleton.exception;

import com.outsiderslab.skeleton.model.ResultCode;

public class FailToMakeResponseException extends BaseException {
	private static final long serialVersionUID = -6563195634052483371L;
	{
		errorCode = ResultCode.FAIL_TO_MAKE_RESPONSE;
	}

	public FailToMakeResponseException() {
	}

	
	public FailToMakeResponseException(Throwable throwable) {
		super(throwable);
	}
}
