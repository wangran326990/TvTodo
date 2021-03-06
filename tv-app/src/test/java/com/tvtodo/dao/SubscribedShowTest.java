package com.tvtodo.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.tvtodo.models.SubscribedShow;
import com.tvtodo.models.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans-core.xml")
public class SubscribedShowTest {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	ISubscribedShowDao subscribedShowDao;
	@Resource(name="userDao")
	UserDao  userDao;
	
	@org.junit.Before
	public void setUp() {
		
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		
	
	}
	
	@Test
	public void testDelete() {
		int id = 1;
		subscribedShowDao.delete(id);
	}

	@Test
	public void testAddSubscribedShow() {
		if(userDao==null){
			System.out.println("fail");
		}
		User user  = userDao.getUserByName("username");
		SubscribedShow show = new SubscribedShow();
		show.setCountryCode("US");
		show.setLastUpdateDate(new Date());
		show.setShowId(139);
		show.setShowImageLink("http://static.tvmaze.com/uploads/images/original_untouched/31/78286.jpg");
		show.setShowName("Girls");
		show.setUser(user);
		subscribedShowDao.add(show);
	}

	@Test
	public void testUpdateSubscribedShow() {
		SubscribedShow show =subscribedShowDao.get(1);
		String dateString ="2012-04-16";
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			show.setLastUpdateDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		subscribedShowDao.update(show);
	}

	@Test
	public void testGetAShowById() {
		fail("Not yet implemented");
	}
	
	public ISubscribedShowDao getSubscribedShowDao() {
		return subscribedShowDao;
	}
	@Resource(name="subscribedShowDao")
	public void setSubscribedShowDao(ISubscribedShowDao subscribedShowDao) {
		this.subscribedShowDao = subscribedShowDao;
	}

	@After
	public void tearDown() throws Exception {
		
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
	}

}
