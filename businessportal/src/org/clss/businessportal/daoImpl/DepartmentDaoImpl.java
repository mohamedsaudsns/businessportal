package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.dao.DepartmentDao;
import org.clss.businessportal.entity.CountryMaster;
import org.clss.businessportal.entity.Department;
import org.clss.businessportal.entity.NewsLetterLanguage;
import org.clss.businessportal.entity.RegionMaster;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("/departmentDao")
@SuppressWarnings("unchecked")
public class DepartmentDaoImpl extends GenericDaoImpl<Department, Serializable> implements  DepartmentDao{

	
	@Override
	public List<Department> getDepartmentList(String status) {
		
		List<Department> departmentList=null;

		departmentList = (List<Department>)getSessioFactory().getCurrentSession().createCriteria(Department.class)
				.add(Restrictions.eq("block", status))
				.list();

		return departmentList;
	}
	
	@Override
	public List<Department> getDepartmentSearchList(String status,String depSearch) {
		
		List<Department> departmentList=null;

		departmentList = (List<Department>)getSessioFactory().getCurrentSession().createCriteria(Department.class)
				.add(Restrictions.eq("block", status)).add(Restrictions.like("departmentName", depSearch+"%")).addOrder( Order.asc("departmentName"))
				.list();

		return departmentList;
	}
	
	
	@Override
	public List<NewsLetterLanguage> getNewsLetterLanguageList(String  status) {
		
		List<NewsLetterLanguage> departmentList=null;

		departmentList = (List<NewsLetterLanguage>)getSessioFactory().getCurrentSession().createCriteria(NewsLetterLanguage.class)
				.add(Restrictions.eq("status", status))
				.list();

		return departmentList;
	}
	
	@Override
	public List<RegionMaster> getNewsLetterRegionList(String  status,String countryCode) {
		
		List<RegionMaster> regionMasterList=null;

		regionMasterList = (List<RegionMaster>)getSessioFactory().getCurrentSession().createCriteria(RegionMaster.class).add(Restrictions.eq("id.countryCode", countryCode))
				.add(Restrictions.eq("status", status))
				.list();

		return regionMasterList;
	}
	
	@Override
	public List<CountryMaster> getNewsLetterCountryList(String  status) {
		
		List<CountryMaster> countryMasterList=null;

		countryMasterList = (List<CountryMaster>)getSessioFactory().getCurrentSession().createCriteria(CountryMaster.class)
				.add(Restrictions.eq("status", status))
				.list();

		return countryMasterList;
	}
	
	
	
	
}
