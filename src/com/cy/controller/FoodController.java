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
	//首页
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
	//所有美食
	@RequestMapping("/showFood")
	public String showAllFood(@RequestParam(value = "currentPage",defaultValue = "1")Integer currpage,Model model) {
		Page<Food> page = foodservice.selectpageByFoods(currpage);
		model.addAttribute("page", page);
		return "allfoods";
	}
	//美食分类
	@RequestMapping("/showClassify")
	public String Classify(Model model) {
		List<Category> categories = foodservice.selectCateName();
		model.addAttribute("categorys", categories);
		return "classify";
	}
	//分类后美食
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
	
	//我的美食
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
	//跳转到发布美食
	@RequestMapping("addFood")
	public String toaddFood() {
		return "addFood";
	}
	//添加新美食
	@RequestMapping("/insertfood")
	public String insertfood(Food food,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		//获取原来的文件名
		String origname = file.getOriginalFilename();
		System.out.println(origname);
		
		//构造新文件名字
		String newfilename = UUID.randomUUID()+"-"+origname;
		//设定保定位置
		String filepath = request.getServletContext().getRealPath("/static/images/");
		//判断路径是否存在，不存在则创建
			File filep = new File(filepath);
			if (!filep.exists()) {
				filep.mkdirs();
			}
		//将文件保存到指定路径
		File f = new File(filepath+"/"+newfilename);
		file.transferTo(f);
		food.setfImage(newfilename);
		//获取session
		HttpSession session = request.getSession();
		//取用户对象
		User user = (User) session.getAttribute("u");
		//从用户对象中获取用户名
		food.setfCreateName(user.getuName());
		foodservice.insertFood(food);
		return "redirect:showMyfood";
	}
	
	//查询美食名字
	@RequestMapping("/searchFood")
	public String toSearch() {
		return "searchFood";
	}
	//搜索名字
	@RequestMapping("/searchname")
	public String searchname(String fName,HttpSession session) {
		List<Food> foodsname = foodservice.selectSearchName(fName);
		session.setAttribute("foodsname", foodsname);
		return "redirect:searchFood";
	}
	//搜索主要材料
	@RequestMapping("/searchmain")
	public String searchmain(String fMainIngredient,HttpSession session) {
		List<Food> foodsmain = foodservice.selectSearchMain(fMainIngredient);
		session.setAttribute("foodsname", foodsmain);
		return "redirect:searchFood";
	}
	
	//美食详情
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
	
	//查询需要修改的美食
	@RequestMapping("/editfood")
	public String selectFoodupda(Integer id,Model model) {
		Food food = foodservice.selectFoodUpdate(id);
		model.addAttribute("updafood", food);
		return "editFood";
	}
	//修改美食
	@RequestMapping("/updatefood")
	public String updatefood(Food food,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		
		//获取原来的文件名
		String origname = file.getOriginalFilename();
		
		//构造新文件名字
		String newfilename = UUID.randomUUID()+"-"+origname;
		//设定保定位置
		String filepath = request.getServletContext().getRealPath("/static/images/");
		//判断路径是否存在，不存在则创建
		File filep = new File(filepath);
		if (!filep.exists()) {
			filep.mkdirs();
		}
		//将文件保存到指定路径
		File f = new File(filepath+"/"+newfilename);
		file.transferTo(f);
		if (file.getOriginalFilename()!= null && file.getOriginalFilename() != "") {
			food.setfImage(newfilename);
		}
		
		foodservice.updateFood(food);
		return "redirect:showMyfood";
	}
	//删除美食
	@RequestMapping("/deletefood")
	public String delFood(Integer id) {
		foodservice.deleteFood(id);
		return "redirect:showMyfood";
	}
	//收藏
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
	//添加收藏
	@ResponseBody
	@RequestMapping("/addCollect")
	public Collect addCollect(@RequestBody Collect collect) {
		foodservice.insertColleFood(collect);
		return collect;
	}
	
	//取消收藏
	@ResponseBody
	@RequestMapping("/delCollect")
	public Collect delCollect(@RequestBody Collect collect) {
		foodservice.deleteColleFood(collect);
		return collect;
	}
	
	//是否收藏
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
