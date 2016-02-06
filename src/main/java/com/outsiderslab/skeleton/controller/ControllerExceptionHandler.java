package com.outsiderslab.skeleton.controller;

import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.outsiderslab.skeleton.exception.BaseException;
import com.outsiderslab.skeleton.model.ErrorResponse;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	private Provider<ErrorResponse> errorProvider;

	@ExceptionHandler(BaseException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse error(BaseException exception) {
		// TODO log exception nicely
		exception.printStackTrace();
		
		ErrorResponse error = errorProvider.get();
		error.setCode(exception.getErrorCode());
		
		return error;
	}
	
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse error(Throwable throwable) {
		// TODO log exception nicely
		throwable.printStackTrace();
		
		ErrorResponse error = errorProvider.get();
		
		return error;
	}
}
