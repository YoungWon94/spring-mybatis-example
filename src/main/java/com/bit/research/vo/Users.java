package com.bit.research.vo;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

public class Users {
	
	
	private String userid;
	
	private String userpw;
	
	
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", userpw=" + userpw + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	
	
}
