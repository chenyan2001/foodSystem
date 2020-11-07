package com.cy.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cy.mapper.BackMapper;
import com.cy.pojo.Category;
import com.cy.pojo.Food;
import com.cy.pojo.Page;
import com.cy.pojo.User;
import com.cy.pojo.adUser;
import com.cy.service.BackService;
import com.cy.service.FoodService;

@Controller
public class BackController {

	@Autowired
	private BackService backservice;
	@Autowired
	private FoodService foodservice;
	
	@RequestMapping("/tobacklogin")
	public String toBackLogin() {		
		return "loginback";
	}
	
	@RequestMapping("/toback")
	public String toback(adUser user,Model model,HttpSession session) {
		adUser us = backservice.selectadUserLogin(user);
		if (us == null) {
			model.addAttribute("Login_error", "账号或密码有误，请重新输入");
			return "loginback";
		}
		session.setAttribute("us", us);
		return "background";
	}
	//安全退出
	@RequestMapping("/aduser")
	public String loginOut(HttpSession session) {
		session.invalidate();//清除缓存
		return "redirect:tobacklogin";	
		}
	//用户管理
	@RequestMapping("/manageuser")
	public String toaf(Model model) {
		List<User> users = this.backservice.selectAllUssers();
		model.addAttribute("users", users);
		return "manageruser";
	}
	//美食管理
	@RequestMapping("/managefood")
	public String tomyf(Model model,@RequestParam(value = "currentPage",defaultValue = "1")Integer currpage){
		Page<Food> page = backservice.selectpageByFoodsBack(currpage);
		model.addAttribute("page", page);
		return "managerfood";
	}
	//注销用户
	@RequestMapping("/delmanuser")
	public String delManUser(Integer id) {
		String uname = this.backservice.selectNameById(id);
		this.backservice.deleteManaUser(id);
		this.backservice.delectFoodByUname(uname);
		return "redirect:manageuser";
	}
	//删除美食
	@RequestMapping("/delmanfood")
	public String delfood(Integer id) {
		this.foodservice.deleteFood(id);
		return "redirect:managefood";
	}
	@RequestMapping("/manaddfood")
	public String manaddfood() {
		return "backAddFood";
	}
	//添加美食
	@RequestMapping("/addbackfood")
	public String addbackfood(Food food,MultipartFile file,HttpServletRequest request) throws Exception {
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
		food.setfImage(newfilename);
		//获取session
		HttpSession session = request.getSession();
		//取用户对象
		adUser user = (adUser) session.getAttribute("us");
		//从用户对象中获取用户名
		food.setfCreateName(user.getAdName());
		food.setfSign(""+1);
		System.out.println(food);
		foodservice.insertFood(food);
		return "redirect:managefood";
	}
	//获取需要修改的数据
	@RequestMapping("/updmanfood")
	public String updmanfood(int id,Model model) {
		Food food = this.foodservice.selectFoodUpdate(id);
		model.addAttribute("bafouupd", food);
		return "backFoodUpd";
	}
	//修改美食
		@RequestMapping("/backupdatefood")
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
			food.setfSign(""+1);
			System.out.println(food);
			foodservice.updateFood(food);
			return "redirect:managefood";
		}
		//查询类别
		@RequestMapping("selectclass")
		public String selectclass(Model  model) {
			List<Category> categories = this.foodservice.selectCateName();
			model.addAttribute("cate", categories);
			return "backClass";
		}
		//添加类别
		@RequestMapping("addclass")
		public String addclass(Category category) {
			this.backservice.insertClass(category);
			return "redirect:selectclass";
		}
}
