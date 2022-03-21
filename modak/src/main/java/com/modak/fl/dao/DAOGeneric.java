package com.modak.fl.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.modak.fl.exception.ExceptionDAO;




public abstract class DAOGeneric<T> {

	private final SessionFactory sessionFactory;
	private Class<T> domainClass = getDomainClass();

	protected Query query;
	protected List<T> list;
	protected String strQuery;


	public DAOGeneric(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public T get(Serializable id) throws ExceptionDAO{
		T obj = getSession().get(domainClass, id);
		if(obj == null){

		}
		return getSession().get(domainClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object... params) throws ExceptionDAO{
		Session session = getSession();
		TypedQuery<T> query = session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> list = query.getResultList();
		return list;
	}

	public List<T> list()throws ExceptionDAO{
		return find("FROM " + domainClass.getSimpleName());
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public Serializable save(Object o) throws ExceptionDAO{
		Session session = getSession();
		Serializable id = session.save(o);
		session.flush();
		return id;
	}

	public void update(Object o) throws ExceptionDAO{
		Session session = getSession();
		session.update(o);
		session.flush();
	}

	public void delete(Object o)throws ExceptionDAO{
		Session session = getSession();
		session.delete(o);
		session.flush();
	}

	public void delete(Serializable id) throws ExceptionDAO{
		Object obj = get(id);
		delete(obj);
	}

	@SuppressWarnings("unchecked")
	public Class<T> getDomainClass(){
		if (domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}
}