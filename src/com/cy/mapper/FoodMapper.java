package com.cy.mapper;

import java.util.List;
import java.util.Map;

import com.cy.pojo.Category;
import com.cy.pojo.Collect;
import com.cy.pojo.Comment;
import com.cy.pojo.Food;
import com.cy.pojo.User;

public interface FoodMapper {

	//最新美食
	public List<Food> selectNewFood();
	
	//查询所有美食
	public List<Food> selectAllFoods(Map map);
	//查总条数
	public int selectcountFood();
	
	//查询类别名称
	public List<Category> selectCateName();
	
	//点击类别名称查询类别名字
	public String selectClassName(Integer cID);
	
	//查询美食类别数量
	public Integer selectclasscount(Integer cID);
	
	//查询类别美食
	public List<Food> selectClassFood(Integer cID);
	
	//查询我的美食
	public List<Food> selectMyFood(String uname);
	
	//添加新美食
	public void insertFood(Food food);
	
	//查询美食名称
	public List<Food> selectSearchName(String fName);
	
	//查询美食主要材料
	public List<Food> selectSearchMain(String fMainIngredient);
	
	//美食详情
	public Food selectFoodDetails(Integer id);
	
	//查询需要修改的美食
	public Food selectFoodUpdate(Integer id);
	//修改美食
	public void updateFood(Food food);
	
	//删除美食
	public void deleteFood(Integer id);
	
	//收藏美食
	public List<Food> selectCollect(Integer id);
	
	//添加收藏
	public void insertColleFood(Collect collect);
	
	//取消收藏
	public void deleteColleFood(Collect collect);
	
	//是否收藏
	public Collect selectIfCollect(Collect collect);
	
	//最热美食（点击次数多）
	public void updateFoodClickNum(Integer id);
	public List<Food> selectClickNumFood();
	
	//发表评论
	public void insertFoodComment(Comment comment);
	
	//查询美食
	public List<Comment> selectFoodComment(Integer id);
	public List<User> selectCommentName();
}
