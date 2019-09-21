package com.bit.research.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.research.service.UserService;
import com.bit.research.vo.Users;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private UserService userService;	
	
	
	@RequestMapping("/")
	public String home(Model model) {
		logger.info("Welcome home! The client locale is {}.");		
		
		model.addAttribute("test",userService.listAll());
		System.out.println("서비스 성공!");		
		
		return "home";
	}
	
	@RequestMapping("/create")
	public String create(Users vo) {
		System.out.println(vo);
		
		System.out.println(userService.addUser(vo));
		
		System.out.println("추가 성공!");	
		
		return "redirect:/";
	}
	
	@RequestMapping("/signIn")
	public String read(Model model,Users vo, HttpServletRequest req) {
		
		String message="";
		if(userService.readUser(vo.getUserid())) {
			if(userService.signInUser(vo,req)) {							
				message="성공";
			}else {
				message = "아이디 비번 불일치";
			}
		}else {
			message = "아이디 없음";			
		}
		model.addAttribute("message", message);
		System.out.println("signIn >>>>>>>>"+message);
		
		return "forward:/";
		
	}
	
	@RequestMapping("/signOut")
	public String signOut(HttpServletRequest req) {
		
		
		return "redirect:/";
	}
	
}
