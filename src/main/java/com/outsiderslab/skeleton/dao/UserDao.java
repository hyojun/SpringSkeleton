package com.outsiderslab.skeleton.dao;

import com.outsiderslab.skeleton.model.UserModel;

public interface UserDao {
	public void insertUser(UserModel userModel);
	public void updateUser(UserModel userModel);
	public void deleteUser(int userNo);
	public UserModel selectUser(int userNo);
}
