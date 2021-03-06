package com.tvtodo.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tvtodo.dao.IUserDao;
import com.tvtodo.models.User;
@Controller(value="testController")
public class TestController {
	
	private IUserDao userDao;
	
	@RequestMapping(value="/homepage",method=RequestMethod.GET)
	public String addUser(){
		return "test";
	}
	public IUserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
}
