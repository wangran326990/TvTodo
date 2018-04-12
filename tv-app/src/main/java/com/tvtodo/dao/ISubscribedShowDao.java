package com.tvtodo.dao;

import java.util.List;

import com.tvtodo.models.SubscribedShow;
import com.tvtodo.models.User;

public interface ISubscribedShowDao extends IBaseDao<SubscribedShow>{
	/**
	 *  add a subscribed show
	 */
	public SubscribedShow add(SubscribedShow show);
	
	/**
	 * update subscribed show info
	 * @param user
	 */
	public void update(SubscribedShow show);
	
	/**
	 * delete a subscribed show information by show id
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * get show by show id
	 * @param id
	 */
	
	public SubscribedShow getAShowById(int id);
	
	public List<SubscribedShow> getSubscribedShowsByUserId(int id);
}
