package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.dao.CountryDao;
import org.clss.businessportal.entity.CountryMaster;
import org.clss.businessportal.entity.RegionMaster;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("/countryDao")
public class CountryDaoImpl extends GenericDaoImpl<CountryMaster, Serializable> implements CountryDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<RegionMaster> getRegions() {
		// TODO Auto-generated method stub
		List<RegionMaster> regionMasters= getSessioFactory().getCurrentSession().createCriteria(RegionMaster.class).list();
		for (RegionMaster regionMaster : regionMasters) {
			Hibernate.initialize(regionMaster.getCountryMaster());
		}
		return regionMasters;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RegionMaster> getRegionsByCountryId(String countryId) {
		// TODO Auto-generated method stub
		return getSessioFactory().getCurrentSession().createCriteria(RegionMaster.class)
				.add(Restrictions.eq("id.countryCode", countryId)).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CountryMaster> getCountries(){
		return getSessioFactory().getCurrentSession().createCriteria(CountryMaster.class).list();
	}
	
	

}
