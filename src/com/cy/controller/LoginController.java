package com.cy.controller;

import java.lang.reflect.Array;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cy.pojo.Category;
import com.cy.pojo.Food;
import com.cy.pojo.User;
import com.cy.service.FoodService;
import com.cy.service.LoginService;

import javafx.geometry.Side;

@Controller
public class LoginController {

	//��¼
	@RequestMapping("/login")
	public String toLogin() {
		return "login";
		
	}
	@Autowired
	private LoginService loginservice;
	@Autowired
	private FoodService foodservice;
	
	//��¼
	@RequestMapping("/adminLogin")
	public String index(User user,Model model,HttpSession httpSession) {
		User u = loginservice.selectUserLogin(user);
		if (u == null) {
			model.addAttribute("Login_error", "�˺Ż�������������������");
			return "login";
		}
		httpSession.setAttribute("u", u);
		return "redirect:index";
		
	}
	//��ȫ�˳�
	@RequestMapping("/adminout")
	public String lohinOut(HttpSession session) {
		session.invalidate();//�������
		return "redirect:login";
		
	}
	//ע��
	@RequestMapping("/enroll")
	public String toEnroll() {
		return "enroll";
	}
	@RequestMapping("/adminEnroll")
	public String enroll(User user,Model model,HttpSession session) {
		System.out.println(user);
		User us = loginservice.selectUsersname(user);
		System.out.println(us);
		if (us!=null) {
			model.addAttribute("enroll_error", "�˻��Ѵ���");
			return "enroll";
			
		}		
		loginservice.insertUserEnroll(user);
		session.setAttribute("u", user);
		return "login";
	}
	
	//������Ϣ
	@RequestMapping("/usermassage")
	public String tousermass() {
		return "usermassage";
	}
	
	//�޸�����
	@RequestMapping("/updatepwd")
	public String toupdate() {
		return "updatepwd";
	}
	@RequestMapping("/updatepsw")
	public String updateUserpsw(User user,String uOldPassword,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("u");
		String pwd = us.getuPassword();
		if (!uOldPassword.equals(pwd)) {
			model.addAttribute("update_error", "���������");
			return "updatepwd";
		}
		loginservice.updateUserPsw(user);
		return "login";
	}
}
