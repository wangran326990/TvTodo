package com.tvtodo.controllers;

import java.lang.reflect.Type;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tvtodo.dto.AjaxResponse;
import com.tvtodo.models.User;
import com.tvtodo.services.UserService;

@RestController("userController")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public AjaxResponse<String> addUser(@RequestBody String json, HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println(json);
		AjaxResponse<String> response = new AjaxResponse<String>();
		//Type userType = new TypeToken<AjaxResponse<String>>() {}.getType();
		try {
			Gson gson = new Gson();
			User user = gson.fromJson(json, User.class);
			userService.addUser(user);
			response.setResponse("successful");
			response.setErrorMessage("");
		} catch (Exception e) {
			response.setResponse("");
			response.setErrorMessage(e.getMessage());
			return response;
			
		}
		return response;
		
	}
	
	
}
