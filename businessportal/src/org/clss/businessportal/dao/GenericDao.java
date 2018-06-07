/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clss.businessportal.dao;

import java.util.List;

/**
*
* @author Mohamed Saud SNS
*/

public interface GenericDao<T, ID> {

	public List<T> findAll();

	public T findById(ID id);
	
	public List<T> findAll(String companyCode,String status);
	
	public List<T> findAll(String companyCode);
	
	public void add(T entity);

	public void save(T entity);

	public void update(T entity);

	public void delete(T entity);

	public void merge(T entity);
}
