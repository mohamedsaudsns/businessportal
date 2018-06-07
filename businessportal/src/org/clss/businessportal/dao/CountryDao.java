package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.entity.CountryMaster;
import org.clss.businessportal.entity.RegionMaster;



public interface CountryDao extends GenericDao<CountryMaster, Serializable>{
	
	public List<RegionMaster> getRegions();
	
	public List<RegionMaster> getRegionsByCountryId(String countryId);
	
	public List<CountryMaster> getCountries();
	



}
