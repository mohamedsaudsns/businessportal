package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/



import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.entity.FiledForce;

public interface AdminDao extends GenericDao<FiledForce, Serializable>{
	
	public void saveFiledForce(List<FiledForce> ff);
	
	
	
	public List<Object[]> getUserTrackList(String vendorCode, String fromDate,
			String toDate);
	
	

}
