package com.cy.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.mapper.BackMapper;
import com.cy.pojo.Category;
import com.cy.pojo.Food;
import com.cy.pojo.Page;
import com.cy.pojo.User;
import com.cy.pojo.adUser;
import com.cy.service.BackService;

@Service
public class BackServiceImpl implements BackService {
	
	@Autowired
	private BackMapper backmapper;
	
	@Override
	public adUser selectadUserLogin(adUser user) {
		// TODO Auto-generated method stub
		adUser u = backmapper.selectadUserLogin(user);
		return u;
	}
	
	@Override
	public List<User> selectAllUssers() {
		// TODO Auto-generated method stub
		List<User> users = this.backmapper.selectAllUssers();
		return users;
	}
	
	@Override
	public void deleteManaUser(Integer id) {
		// TODO Auto-generated method stub
		this.backmapper.deleteManaUser(id);
	}
	@Override
	public String selectNameById(Integer id) {
		// TODO Auto-generated method stub
		String name = this.backmapper.selectNameById(id);
		return name;
	}
	@Override
	public void delectFoodByUname(String name) {
		// TODO Auto-generated method stub
		this.backmapper.delectFoodByUname(name);
	}

	@Override
	public Page<Food> selectpageByFoodsBack(Integer currpage) {
		// TODO Auto-generated method stub
		int pageSize = 3;
		int start = (currpage-1)*pageSize;
		Map map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("pageSize", pageSize);
		
		List<Food> foods = this.backmapper.selectAllFoodBack(map);
		int totalCount = this.backmapper.selectallcountFood();
		
		int totalPage = totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize+1);
		Page page = new Page<Food>();
		page.setList(foods);
		page.setPageSize(pageSize);
		page.setCurrpage(currpage);
		page.setTotalCount(totalCount);
		page.setTotalPage(totalPage);
		
		return page;
	}

	@Override
	public void insertClass(Category category) {
		// TODO Auto-generated method stub
		this.backmapper.insertClass(category);
	}
	

}
