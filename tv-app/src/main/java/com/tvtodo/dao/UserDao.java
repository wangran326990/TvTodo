package com.tvtodo.dao;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.collection.internal.PersistentSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tvtodo.models.SubscribedShow;
import com.tvtodo.models.User;
import com.tvtodo.services.SubscribedShowService;

@Repository(value="userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public User getUserByName(String username) {
		try {
				
		String hql = "from User ur where ur.userName =?";
		User user = (User)super.getSession()
						  .createQuery(hql)
						  .setParameter(0, username)
						  .uniqueResult();
		
		return user;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 *  add a user
	 */
	@Override
	public User add(User user){
		return super.add(user);
	}
	
	/**
	 * update user's information
	 * @param user
	 */
	@Override
	public void update(User user){
		super.update(user);
	}
	
	/**
	 * delete user's information by user id
	 * @param id
	 */
	@Override
	public void delete(int id){
		super.delete(id);
	}

	@Override
	public List<User> listUsers() {
		String hql ="from User ur left join fetch ur.subscribedShows";
		return super.list(hql);
	}
	
	
}