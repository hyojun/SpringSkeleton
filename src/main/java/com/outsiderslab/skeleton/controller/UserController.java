package com.outsiderslab.skeleton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.outsiderslab.skeleton.bo.UserBo;
import com.outsiderslab.skeleton.model.Response;
import com.outsiderslab.skeleton.model.UserModel;

@Controller
@RequestMapping("/v1/user")
public class UserController {
	@Autowired
	private UserBo userBo;
	
	@ResponseBody
	@RequestMapping(value = "{no}", method = RequestMethod.GET)
	public Response<UserModel> getUser(@PathVariable("no") Integer no) {
		// TODO input validation
		UserModel userModel = new UserModel();
		userModel.setNo(no);
		userModel.setName("test");
		Response<UserModel> response = new Response<UserModel>(userModel);

		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Response<UserModel> postUser(@RequestBody UserModel userModel) {
		// TODO input validation
		userBo.addUser(userModel);
		return new Response<>();
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Response<UserModel> putUser(@RequestBody UserModel userModel) {
		// TODO input validation
		userBo.updateUser(userModel);
		return new Response<>();
	}

	@ResponseBody
	@RequestMapping(value = "{no}", method = RequestMethod.PUT)
	public Response<UserModel> deleteUser(@PathVariable("no") Integer no) {
		// TODO input validation
		userBo.deleteUser(no);
		return new Response<>();
	}
}