package com.outsiderslab.skeleton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.outsiderslab.skeleton.exception.InvalidParameterException;
import com.outsiderslab.skeleton.model.ErrorResponse;
import com.outsiderslab.skeleton.model.Response;

@Controller
@RequestMapping("/v1")
public class MainController {	
	@ResponseBody
	@RequestMapping("login")
	public Response<Void> login() {
		return new Response<>();
	}
	
	@RequestMapping("logout")
	public void logout() {
	}
	
	@RequestMapping("error")
	public ErrorResponse error() {
		throw new InvalidParameterException();
	}
}
