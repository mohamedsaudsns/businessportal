package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.clss.businessportal.dao.CustomerMasterDao;
import org.clss.businessportal.entity.CustomerMaster;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("/CustomerMasterDao")
@SuppressWarnings("unchecked")
public class CustomerMasterDaoImpl extends GenericDaoImpl<CustomerMaster, Serializable> implements CustomerMasterDao{

	@Override
	public CustomerMaster getCustomerData(String companyCode, String customerCode) {
		
		
		System.out.println("companyCode.."+companyCode+"..customerCode"+customerCode);
		CustomerMaster customerMaster = (CustomerMaster)getSessioFactory().getCurrentSession().createCriteria(CustomerMaster.class)
				.add(Restrictions.eq("id.compCode", companyCode))
				.add(Restrictions.eq("id.customerCode",customerCode)).uniqueResult();
			if(customerMaster!=null) {
			Hibernate.initialize(customerMaster.getRegionMaster());
			Hibernate.initialize(customerMaster.getRegionMaster().getCountryMaster());
			Hibernate.initialize(customerMaster.getCustomerBankDetails());
			
		}
		return customerMaster;
	}
	
	
	public String  getCustomerOutstandingAmount(String companyCode,String customerCode){
		
		BigDecimal result;
		
		String sql = "SELECT sum(AMOUNT) FROM ar_report where COMP_CODE='"+companyCode+"' and CUSTOMER_CODE='"+customerCode+"';";
		System.out.println("XML Query..." + sql);

		result = (BigDecimal) getSessioFactory().getCurrentSession().createSQLQuery(sql).uniqueResult();
		
		return ""+result;
		
	}
	
	
	@Override
	public List<Object[]> getCustomerOutstandingData(String compCode, String customerCode,String docDate,String todate,String itemType) {

		System.out.println("Enter the XML Query...");
		String sql ="";
		
		if(itemType.equals("INT")){
			 sql= "SELECT ap.COMP_CODE,ap.CUSTOMER_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM customer_master where COMP_CODE=ap.COMP_CODE and CUSTOMER_CODE=ap.CUSTOMER_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME FROM ar_report as ap where COMP_CODE='"+compCode+"' and CUSTOMER_CODE='"+customerCode+"' and  DOC_DATE <='"+todate+"'  order by DOC_DATE desc;";
			
		}else{

		 sql= "SELECT ap.COMP_CODE,ap.CUSTOMER_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM customer_master where COMP_CODE=ap.COMP_CODE and CUSTOMER_CODE=ap.CUSTOMER_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME FROM ar_report as ap where COMP_CODE='"+compCode+"' and CUSTOMER_CODE='"+customerCode+"' and  DOC_DATE >='"+docDate+"' and DOC_DATE <='"+todate+"'  order by DOC_DATE desc;";
		}
		 System.out.println("XML Query..." + sql);

		List<Object[]> getCustomerOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getCustomerOutstandingData size..." + getCustomerOutstandingData.size());

		return getCustomerOutstandingData;
	}
	
}
