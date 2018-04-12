package com.tvtodo.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tvtodo.dao.ISubscribedShowDao;
import com.tvtodo.dao.IUserDao;
import com.tvtodo.dao.SubscribedShowDao;
import com.tvtodo.dao.UserDao;
import com.tvtodo.models.SubscribedShow;
import com.tvtodo.models.User;

@Service(value="userService")
public class UserService implements IUserService{
	private IUserDao userDao;
	
	private ISubscribedShowDao  subscribedShowDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	public ISubscribedShowDao getSubscribedShowDao() {
		return subscribedShowDao;
	}
	@Resource(name="subscribedShowDao")
	public void setSubscribedShowDao(ISubscribedShowDao subscribedShowDao) {
		this.subscribedShowDao = subscribedShowDao;
	}
	
	public boolean subscribeShow(int userId, SubscribedShow show){
		User user = userDao.get(userId);
		if(user==null){
			return false;
		}
		
		show.setUser(user);
		subscribedShowDao.add(show);
		return true;
	}
	
	public List<User> listUser(){
		return userDao.listUsers();
	}
	
	public void addUser(User user) throws Exception{
		if(userDao.getUserByName(user.getUserName())!=null){
			throw new Exception("user exist");
		
		}else{
			userDao.add(user);
		}
	}
	
	
	public void updateUser(User user){
		userDao.update(user);
	}
	
	public User getUserByName(String username){
		return 	userDao.getUserByName(username);
	}
	
	@Override
	public void unsubscribeShow(int id) {
		subscribedShowDao.delete(id);
	}
	
	
	
	
}