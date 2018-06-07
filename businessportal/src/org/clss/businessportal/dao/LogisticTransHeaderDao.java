package org.clss.businessportal.dao;

import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.entity.LogisticTransHeader;
import org.clss.businessportal.entity.LogisticTransItem;

public interface LogisticTransHeaderDao extends GenericDao<LogisticTransHeader, Serializable>{

	public List<LogisticTransHeader> getMonthlyVehicleDetailsReportForLogistics(String compCode, String vendorCode, String fromDate,
			String toDate);
	
	public List<LogisticTransItem> getTransItems(String compCode,String vendorCode,String plant,String route,String fdate,String edate);
	
	public List<Object[]> getArrearDetails(String compCode,String vendorCode,String plant,String route,String fdate,String edate);
	
	public List<Object[]> getDeductionDetails(String compCode,String vendorCode,String plant,String route,String fdate,String edate);
}
