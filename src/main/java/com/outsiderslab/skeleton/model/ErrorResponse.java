package com.outsiderslab.skeleton.model;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ErrorResponse extends Response<Object> {
	private String message;

	@Autowired
	private MessageSource messageSource;
	
	protected ErrorResponse() {
		super();
	}

	@PostConstruct
	private void postConstruct() {
		setCode(ResultCode.FATAL);
	}
	
	public void setCode(ResultCode resultCode) {
		super.setCode(resultCode);
		this.message = messageSource.getMessage(String.valueOf(getCode()), null, Locale.KOREAN);
	}
	public void setCode(ResultCode resultCode, Object[] args) {
		super.setCode(resultCode);
		this.message = messageSource.getMessage(String.valueOf(getCode()), args, Locale.KOREAN);
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
