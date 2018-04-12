package com.tvtodo.services;

import java.util.List;

import com.tvtodo.models.SubscribedShow;
import com.tvtodo.models.User;

public interface IUserService {
	
	public boolean subscribeShow(int userId, SubscribedShow show);
	
	public List<User> listUser();
	
	public void addUser(User user) throws Exception;
	
	public void updateUser(User user);
	
	public User getUserByName(String username);
	
	public void unsubscribeShow(int id );
}
