package com.bit.research.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.bit.research.dao.UserDAO;
import com.bit.research.vo.Users;

@Service
public class UserService_imp implements UserService{
	
	@Autowired
	private UserDAO dao;

	@Override
	public List<Users> listAll() {		
		List<Users> userList = dao.listAll();		
		return userList;
	}
	
	@Override
	public int addUser(Users vo) {
		return dao.addUser(vo);
	}
	
	@Override
	public boolean readUser(String inputId) {		
		Users user = dao.readUser(inputId);
		return user == null ? false : true;				
	}
	
	@Override
	public boolean signInUser(Users vo, HttpServletRequest req) {
		Users user = dao.signInUser(vo);	
		if(user==null) {
			return false;
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("signInId", user.getUserid());
			return true;
		}
	}
	
	@Override
	public boolean signOutUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("signInId");
		return false;
	}
	
	@Override
	public Users test(Users vo) {
		return dao.test(vo);
	}

}
