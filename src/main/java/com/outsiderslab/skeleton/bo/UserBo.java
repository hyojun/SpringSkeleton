package com.outsiderslab.skeleton.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.outsiderslab.skeleton.dao.UserDao;
import com.outsiderslab.skeleton.model.UserModel;

public class UserBo {
	@Autowired
	private UserDao userDao;
	
	public void addUser(UserModel userModel) {
		userDao.insertUser(userModel);
	}
	
	public void updateUser(UserModel userModel) {
		userDao.updateUser(userModel);
	}

	public UserModel getUser(int userNo) {
		return userDao.selectUser(userNo);
	}

	public void deleteUser(int userNo) {
	}
}
