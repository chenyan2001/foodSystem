package com.cy.mapper;

import java.util.List;
import java.util.Map;

import com.cy.pojo.Category;
import com.cy.pojo.Food;
import com.cy.pojo.User;
import com.cy.pojo.adUser;

public interface BackMapper {

	//管理员登录
	public adUser selectadUserLogin(adUser user);
	//查询所有用户
	public List<User> selectAllUssers();
	
	//查总条数
	public int selectallcountFood();
	//查询所有美食
	public List<Food> selectAllFoodBack(Map map);
	
	//删除用户
	public void deleteManaUser(Integer id);
	public String selectNameById(Integer id);
	public void delectFoodByUname(String name);
	
	//添加类别
	public void insertClass(Category category);
}
