package com.tvtodo.services;

import javax.servlet.http.HttpSession;

import com.tvtodo.constants.LoginEnum;
import com.tvtodo.dto.AjaxResponse;
import com.tvtodo.models.User;

public interface ILoginService {
	
	public AjaxResponse<User> doLogin(String username, String password,HttpSession session);
	
	public boolean isUserLogin(String username, HttpSession session);
	
	public boolean doLogout(HttpSession session);
}
