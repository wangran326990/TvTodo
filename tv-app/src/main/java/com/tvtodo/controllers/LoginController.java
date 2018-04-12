package com.tvtodo.controllers;

import java.lang.reflect.Type;
import java.util.HashSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tvtodo.dao.SubscribedShowDao;
import com.tvtodo.dto.AjaxResponse;
import com.tvtodo.models.SubscribedShow;
import com.tvtodo.models.User;
import com.tvtodo.services.LoginService;

@RestController(value="loginController")
public class LoginController {
	@Resource(name="loginService")
	private LoginService loginService;
	@Resource(name="subscribedShowDao")
	private SubscribedShowDao subscribedShowDao;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public  AjaxResponse<User> login(HttpServletResponse resp,@RequestParam String username, @RequestParam String password, HttpSession session){
		resp.setHeader("Access-Control-Allow-Origin", "*");
		 AjaxResponse<User> response=loginService.doLogin(username, password, session);
//		 Gson gson = new Gson();
//		 Type userType = new TypeToken<AjaxResponse<User>>() {}.getType();
		//return gson.toJson(response,userType);
		 return response;
	}
	
	public void test(){
		System.out.println("test");
	}
}