package com.cy.service;

import java.util.List;

import com.cy.pojo.Category;
import com.cy.pojo.Food;
import com.cy.pojo.Page;
import com.cy.pojo.User;
import com.cy.pojo.adUser;

public interface BackService {

	//����Ա��¼
	public adUser selectadUserLogin(adUser user);
	//��ѯ�����û�
	public List<User> selectAllUssers();
	
	//��ѯ������ʳ
	public Page<Food> selectpageByFoodsBack(Integer currpage);
	
	//ɾ���û�
	public void deleteManaUser(Integer id);
	public String selectNameById(Integer id);
	public void delectFoodByUname(String name);
	
	//������
	public void insertClass(Category category);
}
