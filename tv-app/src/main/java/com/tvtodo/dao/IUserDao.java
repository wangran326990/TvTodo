package com.tvtodo.dao;

import java.util.List;

import com.tvtodo.models.User;

public interface IUserDao extends IBaseDao<User>{
	/**
	 *  add a user
	 */
	public User add(User user);
	
	/**
	 * update user's information
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * delete user's information by user id
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * get user by username
	 * @param username
	 */
	
	public User getUserByName(String username);
	
	public List<User> listUsers();
}