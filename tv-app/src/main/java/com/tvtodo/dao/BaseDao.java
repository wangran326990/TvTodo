package com.tvtodo.dao;



import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.annotation.Transactional;



@SuppressWarnings("unchecked")
public class BaseDao<T> implements IBaseDao<T> {
	
	private SessionFactory sessionFactory;
	
	private Class<?> clz;
	
	public Class<?> getClz(){
		if(clz == null){
			clz = ((Class<?>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	
	@Override
	public T add(T t) {
		
		getSession().save(t);
		return t;
	}

	@Override
	public void update(T t) {
		
		getSession().update(t);

	}

	@Override
	public void delete(int id) {
		
		getSession().delete(this.load(id));

	}

	@Override
	public T load(int id) {
		
		T t = (T)getSession().load(getClz(), id);
		//return (T)getSession().load(getClz(), id);
		return t;
	}

	
	public List<T> list(String hql, Object[] args) {

		
		return this.list(hql, args, null);
	}

	
	public List<T> list(String hql, Object arg) {

		return this.list(hql, new Object[]{arg});
	}


	public List<T> list(String hql) {
		
		return this.list(hql, null);
	}


	public List<T> list(String hql, Object[] args, Map<String, Object> alias) {
		Query query = getSession().createQuery(hql);
		if(alias!=null){
			for(Map.Entry<String, Object> entry : alias.entrySet()){
				Object val = alias.get(entry.getKey());
				if(val instanceof Collection){
					query.setParameterList(entry.getKey(), (Collection) val);
				}else{
					query.setParameter(entry.getKey(), val);
				}
			}
		}
		
		
		if(args != null && args.length >0){
			int index = 0;
			for(Object arg :args){
				query.setParameter(index++, arg);
				
			}
		}
		return query.list();
	}

	
	public List<T> listByAlias(String hql, Map<String, Object> alias) {
	
		
		return this.list(hql, null, alias);
	}


	
	@SuppressWarnings("rawtypes")
	private void setAlias(Map<String, Object> alias, Query query){
		
		if(alias!=null){
			for(Map.Entry<String, Object> entry : alias.entrySet()){
				Object val = alias.get(entry.getKey());
				if(val instanceof Collection){
					query.setParameterList(entry.getKey(), (Collection) val);
				}else{
					query.setParameter(entry.getKey(), val);
				}
			}
		}
		
	}
	
	private void setParameter(Object[] args, Query query){
		if(args != null && args.length >0){
			int index = 0;
			for(Object arg :args){
				query.setParameter(index++, arg);
				
			}
		}
	}
	

	
	
	public Object queryObject(String hql, Object[] args) {
		
		
		return this.queryObject(hql, args, null);
	}


	public Object queryObject(String hql, Object arg) {
		
		return this.queryObject(hql, new Object[]{arg});
	}


	public Object queryObject(String hql) {
		
		return this.queryObject(hql, null);
	}


	public void updateByHql(String hql, Object[] args) {
		
		Query query = getSession().createQuery(hql);
		this.setParameter(args, query);
		query.executeUpdate();
		
	}


	public void updateByHql(String hql, Object arg) {
		 
		this.updateByHql(hql, new Object[]{arg});
	}


	public void updateByHql(String hql) {
		
		this.updateByHql(hql, null);
	}


	public <N extends Object> List<N> listBySql(String sql, Object[] args, Class<? extends Object> clz, boolean hasEntity) {
		
		return this.listBySql(sql, args, null, clz, hasEntity);
	}


	public <N extends Object> List<N> listBySql(String sql, Object arg, Class<? extends Object> clz, boolean hasEntity) {
		
		return this.listBySql(sql, new Object[]{arg}, null, clz, hasEntity);
	}


	public <N extends Object> List<N> listBySql(String sql, Class<? extends Object> clz, boolean hasEntity) {
		
		return this.listBySql(sql, null, clz, hasEntity);
	}


	public <N extends Object> List<N> listBySql(String sql, Object[] args, Map<String, Object> alias, Class<? extends Object> clz, boolean hasEntity) {
		
		//sql = initSort(sql);
		SQLQuery query = getSession().createSQLQuery(sql);
		setAlias(alias, (Query) query);
		setParameter(args, (Query) query);
		if(hasEntity){
			query.addEntity(clz);
		}else{
			query.setResultTransformer(Transformers.aliasToBean(clz));
		}
		return query.list();
	}


	public <N extends Object> List<N> listAliasBySql(String sql, Map<String, Object> alias, Class<? extends Object> clz, boolean hasEntity) {
		
		return this.listBySql(sql, alias, clz, hasEntity);
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
			return sessionFactory.getCurrentSession();
	}


	public Object queryObject(String hql, Object[] args, Map<String, Object> alias) {
		
		Query query = getSession().createQuery(hql);
		setAlias(alias, query);
		setParameter(args, query);
		return query.uniqueResult();
	}
	

	public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
		
		
		return this.queryObject(hql,null,alias);
	}

	@Override
	public T get(int id) {
			return (T)getSession().get( getClz(), id);
	}
	
	
	

}