package com.cy.mapper;

import java.util.List;
import java.util.Map;

import com.cy.pojo.Category;
import com.cy.pojo.Food;
import com.cy.pojo.User;
import com.cy.pojo.adUser;

public interface BackMapper {

	//����Ա��¼
	public adUser selectadUserLogin(adUser user);
	//��ѯ�����û�
	public List<User> selectAllUssers();
	
	//��������
	public int selectallcountFood();
	//��ѯ������ʳ
	public List<Food> selectAllFoodBack(Map map);
	
	//ɾ���û�
	public void deleteManaUser(Integer id);
	public String selectNameById(Integer id);
	public void delectFoodByUname(String name);
	
	//������
	public void insertClass(Category category);
}
