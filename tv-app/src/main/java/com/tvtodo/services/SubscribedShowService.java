package com.tvtodo.services;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tvtodo.dao.SubscribedShowDao;
import com.tvtodo.models.SubscribedShow;
@Service("subscribedShowService")
public class SubscribedShowService implements ISubscribedShowService {

	
	private SubscribedShowDao subscribedShowDao;
	
	
	
	@Override
	public boolean updateShowUpdateTime(Date date, int sid) {
		
		try {
			SubscribedShow show = subscribedShowDao.get(sid);
			show.setLastUpdateDate(date);
			subscribedShowDao.update(show);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	public SubscribedShowDao getSubscribedShowDao() {
		return subscribedShowDao;
	}
	
	@Resource(name="subscribedShowDao")
	public void setSubscribedShowDao(SubscribedShowDao subscribedShowDao) {
		this.subscribedShowDao = subscribedShowDao;
	}
	

}
