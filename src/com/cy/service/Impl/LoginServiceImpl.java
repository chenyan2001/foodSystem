package com.cy.service.Impl;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.mapper.LoginMapper;
import com.cy.pojo.User;
import com.cy.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginmapper;
	@Override
	public User selectUserLogin(User user) {
		// TODO Auto-generated method stub
		User u = this.loginmapper.selectUserLogin(user);
		return u;
	}
	@Override
	public void insertUserEnroll(User user) {
		// TODO Auto-generated method stub
		this.loginmapper.insertUserEnroll(user);
	}
	@Override
	public User selectUsersname(User user) {
		// TODO Auto-generated method stub
		User us = this.loginmapper.selectUsersname(user);
		return us;
	}
	@Override
	public void updateUserPsw(User user) {
		// TODO Auto-generated method stub
		this.loginmapper.updateUserPsw(user);
	}

}
