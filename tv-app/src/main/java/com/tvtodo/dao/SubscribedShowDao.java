package com.tvtodo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tvtodo.models.SubscribedShow;
@Repository(value="subscribedShowDao")
public class SubscribedShowDao extends BaseDao<SubscribedShow> implements ISubscribedShowDao {

	@Override
	public SubscribedShow add( SubscribedShow show) {
		
		return super.add(show);
	}

	@Override
	public void update(SubscribedShow show) {
		super.update(show);	
	}

	@Override
	public void delete(int id) {
		super.delete(id);
	}

	@Override
	public SubscribedShow getAShowById(int id) {
			return super.get(id);
	}
//int id, int showId, Date lastUpdateDate, String showName, String showImageLink,
//	String countryCode
	@Override
	public List<SubscribedShow> getSubscribedShowsByUserId(int id) {
		String hql= "select "
				+ "new SubscribedShow(ss.id, ss.showId, ss.lastUpdateDate, ss.showName, ss.showImageLink, ss.countryCode )"
				+ "from SubscribedShow ss "
				+ "where ss.user.id=?";
		return super.list(hql, id);
	}
	


}
