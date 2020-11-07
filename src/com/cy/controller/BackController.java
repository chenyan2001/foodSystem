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
			model.addAttribute("Login_error", "�˺Ż�������������������");
			return "loginback";
		}
		session.setAttribute("us", us);
		return "background";
	}
	//��ȫ�˳�
	@RequestMapping("/aduser")
	public String loginOut(HttpSession session) {
		session.invalidate();//�������
		return "redirect:tobacklogin";	
		}
	//�û�����
	@RequestMapping("/manageuser")
	public String toaf(Model model) {
		List<User> users = this.backservice.selectAllUssers();
		model.addAttribute("users", users);
		return "manageruser";
	}
	//��ʳ����
	@RequestMapping("/managefood")
	public String tomyf(Model model,@RequestParam(value = "currentPage",defaultValue = "1")Integer currpage){
		Page<Food> page = backservice.selectpageByFoodsBack(currpage);
		model.addAttribute("page", page);
		return "managerfood";
	}
	//ע���û�
	@RequestMapping("/delmanuser")
	public String delManUser(Integer id) {
		String uname = this.backservice.selectNameById(id);
		this.backservice.deleteManaUser(id);
		this.backservice.delectFoodByUname(uname);
		return "redirect:manageuser";
	}
	//ɾ����ʳ
	@RequestMapping("/delmanfood")
	public String delfood(Integer id) {
		this.foodservice.deleteFood(id);
		return "redirect:managefood";
	}
	@RequestMapping("/manaddfood")
	public String manaddfood() {
		return "backAddFood";
	}
	//�����ʳ
	@RequestMapping("/addbackfood")
	public String addbackfood(Food food,MultipartFile file,HttpServletRequest request) throws Exception {
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
		food.setfImage(newfilename);
		//��ȡsession
		HttpSession session = request.getSession();
		//ȡ�û�����
		adUser user = (adUser) session.getAttribute("us");
		//���û������л�ȡ�û���
		food.setfCreateName(user.getAdName());
		food.setfSign(""+1);
		System.out.println(food);
		foodservice.insertFood(food);
		return "redirect:managefood";
	}
	//��ȡ��Ҫ�޸ĵ�����
	@RequestMapping("/updmanfood")
	public String updmanfood(int id,Model model) {
		Food food = this.foodservice.selectFoodUpdate(id);
		model.addAttribute("bafouupd", food);
		return "backFoodUpd";
	}
	//�޸���ʳ
		@RequestMapping("/backupdatefood")
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
			food.setfSign(""+1);
			System.out.println(food);
			foodservice.updateFood(food);
			return "redirect:managefood";
		}
		//��ѯ���
		@RequestMapping("selectclass")
		public String selectclass(Model  model) {
			List<Category> categories = this.foodservice.selectCateName();
			model.addAttribute("cate", categories);
			return "backClass";
		}
		//������
		@RequestMapping("addclass")
		public String addclass(Category category) {
			this.backservice.insertClass(category);
			return "redirect:selectclass";
		}
}
