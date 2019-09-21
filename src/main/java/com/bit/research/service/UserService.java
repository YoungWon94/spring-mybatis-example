package com.bit.research.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bit.research.vo.Users;

public interface UserService {
	public List<Users> listAll();
	public int addUser(Users vo);
	public boolean readUser(String inputId);
	public boolean signInUser(Users vo, HttpServletRequest req);
	public boolean signOutUser(HttpServletRequest req);
	
	
	public Users test(Users vo);
	

}
