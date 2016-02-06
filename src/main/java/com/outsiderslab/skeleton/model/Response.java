package com.outsiderslab.skeleton.model;

public class Response<T> {
	private int code;
	private T data;

	public Response() {
		super();
	}

	public Response(T data) {
		super();
		this.code = ResultCode.SUCCESS.getCode();
		this.data = data;
	}

	public int getCode() {
		return code;
	}
	public void setCode(ResultCode resultCode) {
		this.code = resultCode.getCode();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
