package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.entity.CustomerMaster;
import org.clss.businessportal.entity.VendorMaster;

public interface CustomerMasterDao extends GenericDao<CustomerMaster, Serializable>{

	public CustomerMaster getCustomerData(String companyCode,String customerCode);
	
	public String  getCustomerOutstandingAmount(String companyCode,String customerCode);
	public List<Object[]> getCustomerOutstandingData(String compCode, String customerCode,String fromDate,String toDate,String itemType);
}
