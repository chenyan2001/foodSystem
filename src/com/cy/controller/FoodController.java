package com.cy.controller;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cy.pojo.Category;
import com.cy.pojo.Collect;
import com.cy.pojo.Comment;
import com.cy.pojo.Food;
import com.cy.pojo.Page;
import com.cy.pojo.User;
import com.cy.service.FoodService;
import com.sun.java.swing.plaf.windows.resources.windows;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class FoodController {

	@Autowired
	private FoodService foodservice;
	//��ҳ
	@RequestMapping("/index")
	public String index(Model model,HttpSession session) {
		List<Food> foods = foodservice.selectNewFood();
		List<Food> hotFoods = foodservice.selectClickNumFood();
		List<Category> categories = foodservice.selectCateName();
		session.setAttribute("categorys", categories);
		model.addAttribute("foods", foods);
		model.addAttribute("hotFoods", hotFoods);
		return "index";
	}
	//������ʳ
	@RequestMapping("/showFood")
	public String showAllFood(@RequestParam(value = "currentPage",defaultValue = "1")Integer currpage,Model model) {
		Page<Food> page = foodservice.selectpageByFoods(currpage);
		model.addAttribute("page", page);
		return "allfoods";
	}
	//��ʳ����
	@RequestMapping("/showClassify")
	public String Classify(Model model) {
		List<Category> categories = foodservice.selectCateName();
		model.addAttribute("categorys", categories);
		return "classify";
	}
	//�������ʳ
	@RequestMapping("/catename")
	public String cateFood(@RequestParam(value = "id") Integer cID,Model model) {
		String cName = foodservice.selectClassName(cID);
		model.addAttribute("cName", cName);
		Integer num = foodservice.selectclasscount(cID);
		model.addAttribute("num", num);
		List<Food> foods = foodservice.selectClassFood(cID);
		model.addAttribute("classfood", foods);
		return "catename";
	}
	
	//�ҵ���ʳ
	@RequestMapping("/showMyfood")
	public String selectMyfoods(User user,Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("u");
		if (u==null) {
			return "login";
		}
		List<Food> foods = foodservice.selectMyFood(u.getuName());
		model.addAttribute("foods", foods);
		return "myfood";
	}
	//��ת��������ʳ
	@RequestMapping("addFood")
	public String toaddFood() {
		return "addFood";
	}
	//�������ʳ
	@RequestMapping("/insertfood")
	public String insertfood(Food food,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		//��ȡԭ�����ļ���
		String origname = file.getOriginalFilename();
		System.out.println(origname);
		
		//�������ļ�����
		String newfilename = UUID.randomUUID()+"-"+origname;
		//�趨����λ��
		String filepath = request.getServletContext().getRealPath("/static/images/");
		//�ж�·���Ƿ���ڣ��������򴴽�
			File filep = new File(filepath);
			if (!filep.exists()) {
				filep.mkdirs();
			}
		//���ļ����浽ָ��·��
		File f = new File(filepath+"/"+newfilename);
		file.transferTo(f);
		food.setfImage(newfilename);
		//��ȡsession
		HttpSession session = request.getSession();
		//ȡ�û�����
		User user = (User) session.getAttribute("u");
		//���û������л�ȡ�û���
		food.setfCreateName(user.getuName());
		foodservice.insertFood(food);
		return "redirect:showMyfood";
	}
	
	//��ѯ��ʳ����
	@RequestMapping("/searchFood")
	public String toSearch() {
		return "searchFood";
	}
	//��������
	@RequestMapping("/searchname")
	public String searchname(String fName,HttpSession session) {
		List<Food> foodsname = foodservice.selectSearchName(fName);
		session.setAttribute("foodsname", foodsname);
		return "redirect:searchFood";
	}
	//������Ҫ����
	@RequestMapping("/searchmain")
	public String searchmain(String fMainIngredient,HttpSession session) {
		List<Food> foodsmain = foodservice.selectSearchMain(fMainIngredient);
		session.setAttribute("foodsname", foodsmain);
		return "redirect:searchFood";
	}
	
	//��ʳ����
	@RequestMapping("/fooddetails")
	public String allfoodDetalis(Integer id,Model model) {
		Food food = foodservice.selectFoodDetails(id);
		foodservice.updateFoodClickNum(id);
		model.addAttribute("food", food);
		List<Comment> comments = foodservice.selectFoodComment(id);
		model.addAttribute("comments", comments);
		List<User> users = foodservice.selectCommentName();
		model.addAttribute("users", users);
		return "foodDetails";
	}
	
	//��ѯ��Ҫ�޸ĵ���ʳ
	@RequestMapping("/editfood")
	public String selectFoodupda(Integer id,Model model) {
		Food food = foodservice.selectFoodUpdate(id);
		model.addAttribute("updafood", food);
		return "editFood";
	}
	//�޸���ʳ
	@RequestMapping("/updatefood")
	public String updatefood(Food food,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		
		//��ȡԭ�����ļ���
		String origname = file.getOriginalFilename();
		
		//�������ļ�����
		String newfilename = UUID.randomUUID()+"-"+origname;
		//�趨����λ��
		String filepath = request.getServletContext().getRealPath("/static/images/");
		//�ж�·���Ƿ���ڣ��������򴴽�
		File filep = new File(filepath);
		if (!filep.exists()) {
			filep.mkdirs();
		}
		//���ļ����浽ָ��·��
		File f = new File(filepath+"/"+newfilename);
		file.transferTo(f);
		if (file.getOriginalFilename()!= null && file.getOriginalFilename() != "") {
			food.setfImage(newfilename);
		}
		
		foodservice.updateFood(food);
		return "redirect:showMyfood";
	}
	//ɾ����ʳ
	@RequestMapping("/deletefood")
	public String delFood(Integer id) {
		foodservice.deleteFood(id);
		return "redirect:showMyfood";
	}
	//�ղ�
	@RequestMapping("collect")
	public String tocollect(User user,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("u");
		if (us==null) {
			return "login";
		}
		List<Food> collfood = foodservice.selectCollect(us.getuID());
		model.addAttribute("collfood", collfood);
		return "collect";
	}
	//����ղ�
	@ResponseBody
	@RequestMapping("/addCollect")
	public Collect addCollect(@RequestBody Collect collect) {
		foodservice.insertColleFood(collect);
		return collect;
	}
	
	//ȡ���ղ�
	@ResponseBody
	@RequestMapping("/delCollect")
	public Collect delCollect(@RequestBody Collect collect) {
		foodservice.deleteColleFood(collect);
		return collect;
	}
	
	//�Ƿ��ղ�
	@ResponseBody
	@RequestMapping("/seleCollect")
	public Collect seleCollect(@RequestBody Collect collect) {
		Collect collect2 = foodservice.selectIfCollect(collect);
		return collect2;
	}
//	@ResponseBody
//	@RequestMapping("/updaClickNum")
//	public Food updaFoodClick(@RequestBody Food food) {
//		foodservice.updateFoodClickNum(food);
//		System.out.println(food);
//		return food;
//	}
	@ResponseBody
	@RequestMapping("/sendcomment")
	public Comment sendComment(@RequestBody Comment comment) {
		this.foodservice.insertFoodComment(comment);
		return comment;
	}
}
