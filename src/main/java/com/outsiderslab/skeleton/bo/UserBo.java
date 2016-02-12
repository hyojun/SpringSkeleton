package com.outsiderslab.skeleton.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outsiderslab.skeleton.dao.UserDao;
import com.outsiderslab.skeleton.model.UserModel;

@Service
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
		userDao.deleteUser(userNo);
	}
	
	@SuppressWarnings("rawtypes")
	public List<UserModel> getUserList(Map parameterMap) {
		Object lastNo = parameterMap.get("lastNo");
		Object count = parameterMap.get("count");
		if (lastNo != null) {
			lastNo = Integer.parseInt(((String[])lastNo)[0]);
		}
		if (count != null) {
			count = Integer.parseInt(((String[])count)[0]);
		}
		return userDao.selectUserList((Integer)count, (Integer)lastNo);	
	}
}
