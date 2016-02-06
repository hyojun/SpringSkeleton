package com.outsiderslab.skeleton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.outsiderslab.skeleton.model.Response;

@Controller
@RequestMapping("/v1")
public class MainController {	
	@ResponseBody
	@RequestMapping("login")
	public Response<Void> login() {
		return new Response<>();
	}

	@ResponseBody
	@RequestMapping("logout")
	public Response<Void> logout() {
		return new Response<>();
	}
}
