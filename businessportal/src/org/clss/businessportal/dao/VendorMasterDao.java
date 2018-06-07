package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/

import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.entity.Department;
import org.clss.businessportal.entity.NewsLetter;

import org.clss.businessportal.entity.Role;
import org.clss.businessportal.entity.SmsConfiguration;
import org.clss.businessportal.entity.UserMaster;
import org.clss.businessportal.entity.VendorMaster;

public interface VendorMasterDao extends GenericDao<VendorMaster, Serializable> {

	public VendorMaster getVendorData(String companyCode, String vendorCode);
	
	public UserMaster getUserData(String companyCode, String vendorCode);
	public UserMaster getUserDataByMobileNo( String mobileNo);
	
	public Role getRoleNameData(String companyCode, String roleId);
	
	public List<Object[]> getDailyDashboardUpdateDate(String menu);

	public SmsConfiguration getSmsConfiguration(String status);

	public List<Role> getRoleList(String status);

	public List<Object[]> getDepartmentList(String role_id, String status);

	public String getVendorOutstandingAmount(String companyCode, String vendorCode);
	public String getDepositeTotalAmount(String companyCode, String vendorCode);

	public String getSecurityDepositAmount(String companyCode, String vendorCode, String itemType);

	public List<Object[]> getOutstandingData(String compCode, String vendorCode, String docDate);

	public List<Object[]> getOutstandingWithMonthData(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType);
	
	
	public List<Object[]> getCommissionChargeReport(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType);
	
	public List<Object[]> getTransportationChargeReport(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType);
	
	

	public List<Object[]> getMonthlyRentalPaymentReport(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType);
	
	public List<Object[]> getRentalPaymentStauswithmonth(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType);
	
	
	
	
	
	public List<Object[]> getFiledForceDataById(String compCode, String vendorCodeCustomerCode);
	

	public List<Object[]> getPaymentDetailsReport(String compCode, String vendorCode, String fromDate, String toDate,
			String itemType);
	
	
	public List<Object[]> getPoListReport(String compCode, String vendorCode, String fromDate, String toDate,
			String itemType);
	

	public List<Object[]> getBillPaymentDetailsReport(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType);

	public List<Object[]> getSecurityDepositStatusReport(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType);
	
	public List<Object[]> getLogisticSecurityDepositStatus(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType,String dateFilterFype);
	
	
	
	
	
	public List<Object[]> getDepositAmountReport(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType);
	
	
	public List<Object[]> getHmbDepositAmountReport(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType);
	
	
	public List<Object[]> NegativeMilkAdvanceDetailsReport(String compCode, String vendorCode,  String itemType);
	
	
	
	public List<Object[]> getMonthlyVehicleDetailsReport(String compCode, String vendorCode, String fromDate,
			String toDate);
	
	
	public List<Object[]> getVendorVehicleReport(String compCode, String vendorCode, String fromDate,
			String toDate);
	
	
	
	
//
//	public List<Object[]> MonthlyVehiclewiseDieselAmount(String compCode, String vendorCode, String fromDate,
//			String toDate, String itemType);
	
	public List<Object[]> MonthlyVehiclewiseDieselAmount(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType,String docType);
	
	public List<Object[]> MonthlyVehiclewiseAdditionalAmount(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType,String docType);
	
	
	public List<Object[]> getHMBFiledForceDataById(String Hmbcode,String accountGroup,String roleId);
	
	
	public List<Object[]> getTransporterPayment(String compCode, String vendorCode, String fromDate,
			String toDate, String itemType);
	
	
	public	NewsLetter getNewsLetterImageById(String country,String languageID, String status,String typeId);
	
	public	VendorMaster getVendorRegionCode(String vendorCode,String status);
	

}
