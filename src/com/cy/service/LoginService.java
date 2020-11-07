package com.cy.service;

import java.lang.reflect.Array;
import java.util.List;

import com.cy.pojo.User;

public interface LoginService {

	//用户登录
	public User selectUserLogin(User user);
	
	//用户注册
	public void insertUserEnroll(User user);
	//查询用户名
	public User selectUsersname(User user);
	
	//修改密码
	public void updateUserPsw(User user);
}
