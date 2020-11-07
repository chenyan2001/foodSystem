package com.cy.mapper;

import java.util.List;
import java.util.Map;

import com.cy.pojo.Category;
import com.cy.pojo.Collect;
import com.cy.pojo.Comment;
import com.cy.pojo.Food;
import com.cy.pojo.User;

public interface FoodMapper {

	//������ʳ
	public List<Food> selectNewFood();
	
	//��ѯ������ʳ
	public List<Food> selectAllFoods(Map map);
	//��������
	public int selectcountFood();
	
	//��ѯ�������
	public List<Category> selectCateName();
	
	//���������Ʋ�ѯ�������
	public String selectClassName(Integer cID);
	
	//��ѯ��ʳ�������
	public Integer selectclasscount(Integer cID);
	
	//��ѯ�����ʳ
	public List<Food> selectClassFood(Integer cID);
	
	//��ѯ�ҵ���ʳ
	public List<Food> selectMyFood(String uname);
	
	//�������ʳ
	public void insertFood(Food food);
	
	//��ѯ��ʳ����
	public List<Food> selectSearchName(String fName);
	
	//��ѯ��ʳ��Ҫ����
	public List<Food> selectSearchMain(String fMainIngredient);
	
	//��ʳ����
	public Food selectFoodDetails(Integer id);
	
	//��ѯ��Ҫ�޸ĵ���ʳ
	public Food selectFoodUpdate(Integer id);
	//�޸���ʳ
	public void updateFood(Food food);
	
	//ɾ����ʳ
	public void deleteFood(Integer id);
	
	//�ղ���ʳ
	public List<Food> selectCollect(Integer id);
	
	//����ղ�
	public void insertColleFood(Collect collect);
	
	//ȡ���ղ�
	public void deleteColleFood(Collect collect);
	
	//�Ƿ��ղ�
	public Collect selectIfCollect(Collect collect);
	
	//������ʳ����������ࣩ
	public void updateFoodClickNum(Integer id);
	public List<Food> selectClickNumFood();
	
	//��������
	public void insertFoodComment(Comment comment);
	
	//��ѯ��ʳ
	public List<Comment> selectFoodComment(Integer id);
	public List<User> selectCommentName();
}
