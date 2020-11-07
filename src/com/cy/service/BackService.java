package com.cy.service;

import java.util.List;

import com.cy.pojo.Category;
import com.cy.pojo.Food;
import com.cy.pojo.Page;
import com.cy.pojo.User;
import com.cy.pojo.adUser;

public interface BackService {

	//管理员登录
	public adUser selectadUserLogin(adUser user);
	//查询所有用户
	public List<User> selectAllUssers();
	
	//查询所有美食
	public Page<Food> selectpageByFoodsBack(Integer currpage);
	
	//删除用户
	public void deleteManaUser(Integer id);
	public String selectNameById(Integer id);
	public void delectFoodByUname(String name);
	
	//添加类别
	public void insertClass(Category category);
}
