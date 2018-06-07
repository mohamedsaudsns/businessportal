package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.entity.CountryMaster;
import org.clss.businessportal.entity.Department;
import org.clss.businessportal.entity.NewsLetterLanguage;
import org.clss.businessportal.entity.RegionMaster;

public interface DepartmentDao extends GenericDao<Department, Serializable>{

	public List<Department> getDepartmentList(String  status);
	public List<NewsLetterLanguage> getNewsLetterLanguageList(String  status);
	public List<RegionMaster> getNewsLetterRegionList(String  status,String countryCode);
	public List<CountryMaster> getNewsLetterCountryList(String  status);
	public List<Department> getDepartmentSearchList(String  status,String searchStr);
	
	
	
	
}
