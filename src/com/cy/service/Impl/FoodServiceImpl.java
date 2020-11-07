package com.cy.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.mapper.FoodMapper;
import com.cy.pojo.Category;
import com.cy.pojo.Collect;
import com.cy.pojo.Comment;
import com.cy.pojo.Food;
import com.cy.pojo.Page;
import com.cy.pojo.User;
import com.cy.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodMapper foodmapper;
	@Override
	public List<Food> selectNewFood() {
		// TODO Auto-generated method stub
		List<Food> foods = this.foodmapper.selectNewFood();
		return foods;
	}
	@Override
	public Page<Food> selectpageByFoods(Integer currpage) {
		// TODO Auto-generated method stub
		int pageSize = 3;
		int start = (currpage-1)*pageSize;
		Map map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("pageSize", pageSize);
		
		List<Food> foods = this.foodmapper.selectAllFoods(map);
		int totalCount = this.foodmapper.selectcountFood();
		
		//×ÜÒ³Êý
		int totalPage = totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize)+1;
		Page<Food> page = new Page<Food>();
		page.setList(foods);
		page.setCurrpage(currpage);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setTotalPage(totalPage);
		return page;
	}
	@Override
	public List<Category> selectCateName() {
		// TODO Auto-generated method stub
		List<Category> categories = this.foodmapper.selectCateName();
		return categories;
	}
	@Override
	public String selectClassName(Integer cID) {
		// TODO Auto-generated method stub
		String cName = this.foodmapper.selectClassName(cID);
		return cName;
	}
	
	@Override
	public Integer selectclasscount(Integer cID) {
		// TODO Auto-generated method stub
		Integer num = this.foodmapper.selectclasscount(cID);
		return num;
	}
	@Override
	public List<Food> selectClassFood(Integer cID) {
		// TODO Auto-generated method stub
		List<Food> foods = this.foodmapper.selectClassFood(cID);
		return foods;
	}
	@Override
	public List<Food> selectMyFood(String uname) {
		// TODO Auto-generated method stub
		List<Food> foods = this.foodmapper.selectMyFood(uname);
		return foods;
	}
	@Override
	public void insertFood(Food food) {
		// TODO Auto-generated method stub
		this.foodmapper.insertFood(food);
	}
	@Override
	public List<Food> selectSearchName(String fName) {
		// TODO Auto-generated method stub
		List<Food> foods = this.foodmapper.selectSearchName(fName);
		return foods;
	}
	@Override
	public List<Food> selectSearchMain(String fMainIngredient) {
		// TODO Auto-generated method stub
		List<Food> foods = this.foodmapper.selectSearchMain(fMainIngredient);
		return foods;
	}
	@Override
	public Food selectFoodDetails(Integer id) {
		// TODO Auto-generated method stub
		Food food = this.foodmapper.selectFoodDetails(id);
		return food;
	}
	@Override
	public Food selectFoodUpdate(Integer id) {
		// TODO Auto-generated method stub
		Food food = this.foodmapper.selectFoodUpdate(id);
		return food;
	}
	@Override
	public void updateFood(Food food) {
		// TODO Auto-generated method stub
		this.foodmapper.updateFood(food);
	}
	@Override
	public void deleteFood(Integer id) {
		// TODO Auto-generated method stub
		this.foodmapper.deleteFood(id);
	}
	@Override
	public List<Food> selectCollect(Integer id) {
		// TODO Auto-generated method stub
		List<Food> foods = this.foodmapper.selectCollect(id);
		return foods;
	}
	@Override
	public void insertColleFood(Collect collect) {
		// TODO Auto-generated method stub
		this.foodmapper.insertColleFood(collect);
	}
	@Override
	public void deleteColleFood(Collect collect) {
		// TODO Auto-generated method stub
		this.foodmapper.deleteColleFood(collect);
	}
	@Override
	public Collect selectIfCollect(Collect collect) {
		// TODO Auto-generated method stub
		Collect coll = this.foodmapper.selectIfCollect(collect);
		return coll;
	}
	@Override
	public void updateFoodClickNum(Integer id) {
		// TODO Auto-generated method stub
		this.foodmapper.updateFoodClickNum(id);
	}
	@Override
	public List<Food> selectClickNumFood() {
		// TODO Auto-generated method stub
		List<Food> foods = this.foodmapper.selectClickNumFood();
		return foods;
	}
	@Override
	public void insertFoodComment(Comment comment) {
		// TODO Auto-generated method stub
		this.foodmapper.insertFoodComment(comment);
	}
	@Override
	public List<Comment> selectFoodComment(Integer id) {
		// TODO Auto-generated method stub
		List<Comment> comments = this.foodmapper.selectFoodComment(id);
		return comments;
	}
	@Override
	public List<User> selectCommentName() {
		// TODO Auto-generated method stub
		List<User> users = this.foodmapper.selectCommentName();
		return users;
	}
	
	
	

}
