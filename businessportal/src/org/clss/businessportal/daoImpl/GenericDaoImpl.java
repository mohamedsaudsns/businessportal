/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.clss.businessportal.dao.GenericDao;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author mohamedsaud.sns
 * @param <T>
 * @param <ID>
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {
		RuntimeException.class, Exception.class })
public class GenericDaoImpl<T, ID extends Serializable> implements
		GenericDao<T, ID> {

	@Autowired
	private SessionFactory sessioFactory;

	protected Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public SessionFactory getSessioFactory() {
		return sessioFactory;
	}

	public void setSessioFactory(SessionFactory sessioFactory) {
		this.sessioFactory = sessioFactory;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getSessioFactory().getCurrentSession()
				.createCriteria(persistentClass).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(String companyCode,String status) {
		return getSessioFactory().getCurrentSession()
				.createCriteria(persistentClass)
				.add(Restrictions.eq("id.compCode", companyCode))
				.add(Restrictions.eq("status", status)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(String companyCode) {
		return getSessioFactory().getCurrentSession()
				.createCriteria(persistentClass)
				.add(Restrictions.eq("id.compCode", companyCode)).list();
	}

	public void add(T entity) {
		getSessioFactory().getCurrentSession().saveOrUpdate(entity);
		// getSessioFactory().getCurrentSession().evict(entity);
	}

	public void save(T entity) {
		getSessioFactory().getCurrentSession().save(entity);
		// getSessioFactory().getCurrentSession().evict(entity);
	}

	public void update(T entity) {
		getSessioFactory().getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(T entity) {
		getSessioFactory().getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		return (T) getSessioFactory().getCurrentSession().get(persistentClass,id);
	}

	public void merge(T entity) {
		getSessioFactory().getCurrentSession().merge(entity);
	}

}
