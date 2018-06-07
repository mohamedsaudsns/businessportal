package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/



import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.custommodel.MilkDeductionDetailCustomModel;
import org.clss.businessportal.entity.MilkPaymentHa;
import org.clss.businessportal.entity.Role;
import org.clss.businessportal.entity.SocietyInchargeMapping;

public interface HmbDao extends GenericDao<MilkPaymentHa, Serializable>{
	
	public List<Object[]> getHmpSummary(String compCode, String socity, String  farmer,
			String fromdate, String todate);
	
	public List<Object[]> getHmpInchargeSummary(String compCode, String  farmer,
			String fromdate, String todate);
	
	public List<Object[]> getHmbInchargeDeductions(String compCode, String  farmer,
			String fromdate, String todate);
	
	public List<MilkDeductionDetailCustomModel> getHmbInchargeDeductionsDetails(String compCode, String  inchargeCode,
			String fromdate, String todate);
	
	
	
	public List<Object[]> getHmpPaymentDetails(String compCode, String plant, String  socity,
			String billNumber);
	
	public List<Object[]> getHmpArrearDetails(String compCode, String plant, String  socity,
			String billNumber);
	
	public List<Object[]> getHmpDeductionDetails(String compCode, String plant, String  socity,
			String billNumber);
	
	public List<Object[]> getHmpDeductionSdDetails(String compCode, String plant, String  socity,
			String billNumber);
	
	
	public List<Object[]> getHmpRecoveryDetails(String compCode, String plant, String  socity,
			String billNumber);
	
	
	public List<Object[]> getHmpIncentiveDetails(String compCode, String plant, String  socity,
			String billNumber,String currentDate);
	
	
	

	
	public List<Object[]> getMaterialStock(String compCode, String  socity);
	
	public List<Object[]> getEkoMaterialStock(String  socity);
	
	public List<Object[]> getAvgMilkMonth(String compCode, String  socity,String selectedYear,String farmer);
	
	
	public List<Object[]> getAvgMilkMonthLi(String socity, String  selectedYear,String selectedMonth);
	
	
	public List<Object[]> getHmServiceCharge(String compCode,  String  inchargeCode,String fromDate,String todate);
	
	public List<Object[]> getHmServiceChargeDeduction(String inchargeCode,  String  society,String fromDate,String todate);
	
	public List<Object[]> getHmServiceArrear(String  society,String fromDate,String todate);
	
	public List<Object[]> getMilkLiability(String socity);
	public List<Object[]> MilkFeeds(String socity);
	
	
	
	
	
	public List<SocietyInchargeMapping> getSocietyInchargeMappingList(String compcode,String inchargeCode,String partnerFunction);
	
	
	public List<Object[]> getBulkHmpSummary(String compCode, String socity, String  farmer,
			String fromdate, String todate);
	
	public List<Object[]> getFarmHmpSummary(String compCode, String socity, String  farmer,
			String fromdate, String todate);
	
	
	
	public List<Object[]> getBulkHmpPaymentDetails(String compCode, String plant, String  socity,
			String billNumber);
	
	public List<Object[]> getFarmHmpPaymentDetails(String compCode, String plant, String  socity,
			String billNumber);
	
	
}
