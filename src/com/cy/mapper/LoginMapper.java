package com.cy.mapper;

import java.lang.reflect.Array;
import java.util.List;

import com.cy.pojo.User;

public interface LoginMapper {

	//�û���¼
	public User selectUserLogin(User user);
	
	//�û�ע��
	public void insertUserEnroll(User user);
	//��ѯ�û���
	public User selectUsersname(User user);
	
	//�޸�����
	public void updateUserPsw(User user);
}
