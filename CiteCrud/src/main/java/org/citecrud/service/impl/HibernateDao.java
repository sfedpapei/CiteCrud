package org.citecrud.service.impl;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

//import org.citecrud.model.Employee;
import org.citecrud.service.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.lang.reflect.ParameterizedType;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class HibernateDao<E, K extends Serializable, T> implements
		GenericDao<E, K, T> {

	private SessionFactory sessionFactory;

	protected Class<? extends E> daoType;

	@SuppressWarnings("unchecked")
	public HibernateDao() {
		daoType = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(E entity) {
		currentSession().save(entity);

	}

	public void update(E entity) {
		currentSession().saveOrUpdate(entity);

	}

	public void remove(E entity) {
		currentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	public E find(K key) {
		return (E) currentSession().get(daoType, key);
	}

	@SuppressWarnings("unchecked")
	public List<E> list() {
		return currentSession().createCriteria(daoType)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	public List<E> findByName(T name) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public E findbyId(K key) {
		// TODO Auto-generated method stub
		return null;
	}

}
