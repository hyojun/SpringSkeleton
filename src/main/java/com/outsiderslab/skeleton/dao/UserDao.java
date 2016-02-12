package com.outsiderslab.skeleton.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.outsiderslab.skeleton.model.UserModel;

@Repository
public interface UserDao {
	public void insertUser(UserModel userModel);
	public void updateUser(UserModel userModel);
	public void deleteUser(int userNo);
	public UserModel selectUser(int userNo);
	public List<UserModel> selectUserList(@Param("count") Integer count, @Param("lastNo") Integer lastNo);
}
