package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.entity.Department;
import org.clss.businessportal.entity.FfsDesignationMapping;
import org.clss.businessportal.entity.NewsLetter;

import org.clss.businessportal.entity.RegionMaster;
import org.clss.businessportal.entity.Role;
import org.clss.businessportal.entity.Scheme;
import org.clss.businessportal.entity.SmsConfiguration;
import org.clss.businessportal.entity.SocietyInchargeMapping;
import org.clss.businessportal.entity.UserMaster;
import org.clss.businessportal.entity.VendorMaster;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("/VendorMasterDao")
@SuppressWarnings("unchecked")
public class VendorMasterDaoImpl extends GenericDaoImpl<VendorMaster, Serializable> implements VendorMasterDao {

	@Override
	public VendorMaster getVendorData(String companyCode, String vendorCode) {

		System.out.println("companyCode.." + companyCode + "..vendorCode" + vendorCode);
		VendorMaster vendorMaster = (VendorMaster) getSessioFactory().getCurrentSession()
				.createCriteria(VendorMaster.class).add(Restrictions.eq("id.compCode", companyCode))
				.add(Restrictions.eq("id.vendorCode", vendorCode)).uniqueResult();

		if (vendorMaster != null) {
			Hibernate.initialize(vendorMaster.getVendorBankDetails());
			Hibernate.initialize(vendorMaster.getRegionMaster());
			Hibernate.initialize(vendorMaster.getRegionMaster());
			Hibernate.initialize(vendorMaster.getRegionMaster().getCountryMaster());
		}
		return vendorMaster;
	}
	
	
	@Override
	public UserMaster getUserDataByMobileNo(String mobileNo) {

		UserMaster userMaster = (UserMaster) getSessioFactory().getCurrentSession()
				.createCriteria(UserMaster.class).add(Restrictions.eq("mobileNo", mobileNo))
				.uniqueResult();


		return userMaster;
	}
	
	
	@Override
	public UserMaster getUserData(String companyCode, String vendorCode) {

		System.out.println("companyCode.." + companyCode + "..vendorCode" + vendorCode);
		UserMaster vendorMaster = (UserMaster) getSessioFactory().getCurrentSession()
				.createCriteria(UserMaster.class).add(Restrictions.eq("id.compCode", companyCode))
				.add(Restrictions.eq("id.userId", vendorCode)).uniqueResult();


		return vendorMaster;
	}
	
	@Override
	public Role getRoleNameData(String companyCode, String roleId) {

		System.out.println("companyCode.." + companyCode + "..roleId" + roleId);
		Role role = (Role) getSessioFactory().getCurrentSession()
				.createCriteria(Role.class).add(Restrictions.eq("id.compCode", companyCode))
				.add(Restrictions.eq("id.roleId", Integer.parseInt(roleId))).uniqueResult();

	
		return role;
	}

	@Override
	public SmsConfiguration getSmsConfiguration(String status) {

		SmsConfiguration smsConfiguration = (SmsConfiguration) getSessioFactory().getCurrentSession()
				.createCriteria(SmsConfiguration.class).add(Restrictions.eq("status", status)).uniqueResult();

		if (smsConfiguration != null) {

		}
		return smsConfiguration;
	}

	public String getVendorOutstandingAmount(String companyCode, String vendorCode) {

		BigDecimal result;

		String sql = "SELECT sum(AMOUNT) FROM ap_report where COMP_CODE='" + companyCode + "' and VENDOR_CODE='"
				+ vendorCode + "';";
		System.out.println("XML Query..." + sql);

		result = (BigDecimal) getSessioFactory().getCurrentSession().createSQLQuery(sql).uniqueResult();

		return "" + result;

	}
	
	public String getDepositeTotalAmount(String companyCode, String vendorCode) {

		String result;

		String sql = "SELECT format(sum(abs(amount)),2) as TOATAL_AMOUNT FROM ap_report as ap where COMP_CODE='1000' and VENDOR_CODE='"+vendorCode+"' and ITEM_TYPE='OPN' and SP_GL_IND IN('2','3')  order by DOC_DATE desc";
		System.out.println("XML Query..." + sql);

		result = (String) getSessioFactory().getCurrentSession().createSQLQuery(sql).uniqueResult();

		return "" + result;

	}
	

	public String getSecurityDepositAmount(String companyCode, String vendorCode, String itemType) {

		BigDecimal result;
		String sql = "";

		if (itemType.equals("Open")) {

			sql = "SELECT sum(AMOUNT) FROM ap_report where COMP_CODE='" + companyCode + "' and VENDOR_CODE='"
					+ vendorCode + "' and ;";
			System.out.println("XML Query..." + sql);

		} else {

		}

		result = (BigDecimal) getSessioFactory().getCurrentSession().createSQLQuery(sql).uniqueResult();

		return "" + result;

	}

	@Override
	public List<Role> getRoleList(String status) {

		List<Role> roleList = null;

		roleList = (List<Role>) getSessioFactory().getCurrentSession().createCriteria(Role.class)
				.add(Restrictions.eq("block", status)).list();

		return roleList;
	}

	@Override
	public List<Object[]> getDepartmentList(String role_id, String status) {

		String sql = "SELECT  MENU_ID,(SELECT MENU_DESC FROM menumaster where menu_id=ro.MENU_ID and STATUS='A') as MENU_NAME FROM role_access ro where role_id='"
				+ role_id + "' and block='A';";
		System.out.println("XML Query..." + sql);

		List<Object[]> DepatmentList = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" DepatmentList size..." + DepatmentList.size());

		return DepatmentList;
	}

	@Override
	public List<Object[]> getOutstandingData(String compCode, String vendorCode, String docDate) {

		System.out.println("Enter the XML Query...");

		String sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME FROM ap_report as ap where COMP_CODE='"
				+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE <='" + docDate
				+ "' order by DOC_DATE desc;";
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());

		return getOutstandingData;
	}

	@Override
	public List<Object[]> getOutstandingWithMonthData(String compCode, String vendorCode, String docDate, String todate,
			String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and ITEM_TYPE='OPN' order by DOC_DATE desc;";
		} else {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	@Override
	public List<Object[]> getCommissionChargeReport(String compCode, String vendorCode, String docDate, String todate,
			String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and ITEM_TYPE='OPN' and ITEM_TEXT like '%Commission chrgs%' order by DOC_DATE desc;";
		} else {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and ITEM_TEXT like '%Commission chrgs%' order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	@Override
	public List<Object[]> getTransportationChargeReport(String compCode, String vendorCode, String docDate, String todate,
			String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and ITEM_TYPE='OPN' and ITEM_TEXT like '%Transport chrgs%' order by DOC_DATE desc;";
		} else {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and  ITEM_TEXT like '%Transport chrgs%' order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	

	@Override
	public List<Object[]> getMonthlyRentalPaymentReport(String compCode, String vendorCode, String docDate,
			String todate, String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and  DOC_DATE <='" + todate
					+ "' and ITEM_TYPE='OPN' and DOC_TYPE='KR' and DB_CR_IND='H' order by DOC_DATE desc;";
		} else {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and DOC_TYPE='KR' and DB_CR_IND='H' order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Object[]> getFiledForceDataById(String compCode, String vendorCodeCustomerCode) {

		String sql = "";

			sql = "SELECT (SELECT NAME FROM vendor_portal.position where POSITION_ID=ff.POSITION_CODE) as Desination,ff.EMP_NAME,ff.EMP_MOBILE_NO,ff.EMP_EMAIL_ID FROM filed_force ff where COMP_CODE='"+compCode+"' and VENDOR_CUSTOMER_CODE='"+vendorCodeCustomerCode+"'";
	

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	

	@Override
	public List<Object[]> getPaymentDetailsReport(String compCode, String vendorCode, String docDate, String todate,
			String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate
					+ "' and ITEM_TYPE='OPN' and DOC_TYPE='ZP'  order by DOC_DATE desc;";
		} else {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and DOC_TYPE='ZP'  order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getPoListReport(String compCode, String vendorCode, String docDate, String todate,
			String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

	

			sql = "SELECT PO_NUMBER,PO_ITEM_NO,DOC_CAT,DOC_DATE,RELEASE_STATUS,SHORT_TEXT,MATERIAL_CODE,GROSS_VALUE,NET_VALUE FROM po_list where  COMP_CODE='"+compCode+"' and VENDOR_CODE='"+vendorCode+"'"

+"and DOC_DATE >='"+docDate+"' and DOC_DATE <='"+todate+"'";

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());

		return getOutstandingData;
	}

	@Override
	public List<Object[]> getBillPaymentDetailsReport(String compCode, String vendorCode, String docDate, String todate,
			String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and ITEM_TYPE='OPN'  order by DOC_DATE desc;";
		} else {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "'   order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	@Override
	public List<Object[]> getMonthlyVehicleDetailsReport(String compCode, String vendorCode, String docDate,
			String todate) {

		String sql = "";


			// for Security Deposit Refund Status
			sql = "SELECT PLANT,PLANT_DESCRIPTON,SHIPMENT_NO,ROUTE,ROUTE_DESCRIPTON,TRUCK_NUMBER,ROUTE_MASTER_DISTANCE,STARTING_KM,ENDING_KM,DISTANCE_TRAVELLED,PASSING_KM,FREIGHT_RATE,TOLL_FEES,STAGE_FIXED_AMT,"
					+ "ADDITIONAL_AMOUNT,DEDUCTION_AMOUNT,FREIGHT_KM,FREIGHT_FIXED,SUPPLM1,SUPPLM2,SEC_ROUTE_FREIGHT_AMT,SEC_ROUTE_FREIGHT_KM,SHIP_COMPLETION_DATE,"
					+ "ZFKMRT,KZWI4,ZDI1,ZDI2,ZVTK,ZKNR,ZANR,ZVAD,COST2,DALBG,SERVICE_AGENT FROM monthly_vehicle_summary where COMP_CODE='"+compCode+"' and PAYMENT_VENDOR='"+vendorCode+"' and SHIP_COMPLETION_DATE >='"+docDate+"' and SHIP_COMPLETION_DATE <='"+todate+"';";

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getSecurityDepositStatusReport size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getVendorVehicleReport(String compCode, String vendorCode, String docDate,
			String todate) {

		String sql = "";


			// for Security Deposit Refund Status
			sql = "SELECT TRUCK_NUMBER,PERMIT_STATUS,BIRTH_DATE,VEHICLE_TYPE,CRATE_CAPACITY,DIESEL_CARD_NUMBER,NAME1,SERVICE_AGENT,SUPPL1_DES,SUPPL2_DES,DELETION FROM vendor_vehicle_details where COMP_CODE='"+compCode+"' and PAYMENT_VENDOR='"+vendorCode+"'";
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getSecurityDepositStatusReport size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	@Override
	public List<Object[]> getDailyDashboardUpdateDate(String menuName) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (menuName.equals("Dashboard")) {

			///// for SecurityDepositStatus
			sql = "SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='HMB' and MENU='Dashboard' and FUNCTION_NAME IN ('Feed','Milk Liablity')  order by MODULE_NAME,CREATED_ON desc";
		}if (menuName.equals("Vendor Master")) {

		sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Common' and MENU='Vendor Master' and FUNCTION_NAME IN ('Vendor History')  order by MODULE_NAME,CREATED_ON desc";
		}if(menuName.equals("HMB Summary")) {
			
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='HMB' and MENU='HMB Summary' and FUNCTION_NAME IN ('Milk Payment Ha','Milk Payment Li','Milk Payment Deduction','Milk Payment Deduction SD','Milk Payment Arrear','Milk Payment Recovery','Milk Payment Incentive','Milk Payment Bouns','HMB Service Charge','HMB Service Arrear','HMB Service Deduction','Open Item ATPY')  order by MODULE_NAME,CREATED_ON desc";
			
			
		}if(menuName.equals("Milk Deduction")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='HMB' and MENU='HMB Summary' and FUNCTION_NAME IN ('Milk Payment Ha','Milk Payment Deduction','Milk Payment Deduction SD')  order by MODULE_NAME,CREATED_ON desc";
			
		}if(menuName.equals("Material Stock")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='HMB' and MENU='Material Stock' and FUNCTION_NAME IN ('Can Material Stock','Eko Material Stock')  order by MODULE_NAME,CREATED_ON desc";
			
		}if(menuName.equals("Milk Month Average")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='HMB' and MENU='Milk Month Average' and FUNCTION_NAME IN ('Milk Month Average')  order by MODULE_NAME,CREATED_ON desc";
			
		}if(menuName.equals("Negative Milk Advance Details")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Standard' and MENU='Standard' and FUNCTION_NAME IN ('Open Item ATPY')  order by MODULE_NAME,CREATED_ON desc";
			
		}if(menuName.equals("Filed Force Staff")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='HMB' and MENU='Filed Force Staff' and FUNCTION_NAME IN ('Filed Force Staff')  order by MODULE_NAME,CREATED_ON desc";
			
			
		}if(menuName.equals("HMB Farmer Summary")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='HMB' and MENU='HMB Summary' and FUNCTION_NAME IN ('Milk Payment Ha','Milk Payment Li','Milk Payment Deduction','Milk Payment Deduction SD','Milk Payment Arrear','Milk Payment Recovery','Milk Payment Incentive','Milk Payment Bouns')  order by MODULE_NAME,CREATED_ON desc";
			
		}if(menuName.equals("Bulk HMB Summary")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='HMB' and MENU='HMB Summary' and FUNCTION_NAME IN ('Milk Payment Ha','Bulk Payment Li','Milk Payment Deduction','Milk Payment Deduction SD','Milk Payment Arrear','Milk Payment Recovery','Milk Payment Incentive','Milk Payment Bouns')  order by MODULE_NAME,CREATED_ON desc";
			
			
		}if(menuName.equals("Farm HMB Summary")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='HMB' and MENU='HMB Summary' and FUNCTION_NAME IN ('Milk Payment Ha','Bulk Payment Li','Milk Payment Deduction','Milk Payment Deduction SD','Milk Payment Arrear','Milk Payment Recovery','Milk Payment Incentive','Milk Payment Bouns')  order by MODULE_NAME,CREATED_ON desc";
			
			
		}if(menuName.equals("Rental Payment Staus with month")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Standard' and MENU='Standard' and FUNCTION_NAME IN ('Balance Item HMBO','Open Item HMBO')  order by MODULE_NAME,CREATED_ON desc";
			
			
		}if(menuName.equals("Security Deposit Status")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Standard' and MENU='Standard' and FUNCTION_NAME IN ('Open Item ATPY','Open Item HMBO','Open Item FRTV')  order by MODULE_NAME,CREATED_ON desc";
			
			
		}if(menuName.equals("Security Deposit Refund Status")) {
			
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Standard' and MENU='Standard' and FUNCTION_NAME IN ('Balance Item ATPY','Balance Item HMBO','Balance Item FRTV')  order by MODULE_NAME,CREATED_ON desc";
		}if(menuName.equals("Vehicle History RCDate Crate Capacity")) {
			
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Transporter' and MENU='Vendor Vehicle Details' and FUNCTION_NAME IN ('Vendor Vehicle Details')  order by MODULE_NAME,CREATED_ON desc";
			
		}if(menuName.equals("Monthly Vehicle Details")) {
			
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Transporter' and MENU='Monthly Vehicle Details' and FUNCTION_NAME IN ('Monthly Vehicle Details')  order by MODULE_NAME,CREATED_ON desc";
			
		}if(menuName.equals("Additional And Deduction Details")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Standard' and MENU='Standard' and FUNCTION_NAME IN ('Balance Item FRTV','Open Item FRTV')  order by MODULE_NAME,CREATED_ON desc";
		}if(menuName.equals("Transporter Payment")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Standard' and MENU='Standard' and FUNCTION_NAME IN ('Balance Item FRTV','Open Item FRTV')  order by MODULE_NAME,CREATED_ON desc";
		}if(menuName.equals("Monthly Vehicle wise Diesel Amount")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Standard' and MENU='Standard' and FUNCTION_NAME IN ('Balance Item FRTV','Open Item FRTV')  order by MODULE_NAME,CREATED_ON desc";
		}if(menuName.equals("Logistic Security Deposit Status")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Standard' and MENU='Standard' and FUNCTION_NAME IN ('Open Item FRTV')  order by MODULE_NAME,CREATED_ON desc";
		}if(menuName.equals("Monthly Vehicle Details For Logistics")) {
			
			sql="SELECT DATE_FORMAT(CREATED_ON, '%d/%b/%Y %h:%i %p') as daily_update FROM daily_scheduler_log where MODULE_NAME='Logistic' and MENU='Logistic' and FUNCTION_NAME IN ('Logistic Trans Header','Logistic Trans Item','Logistic Arrear','Logistic Deduction')  order by MODULE_NAME,CREATED_ON desc";	
		}
			

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Daily Schdull size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public List<Object[]> getSecurityDepositStatusReport(String compCode, String vendorCode, String docDate,
			String todate, String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			///// for SecurityDepositStatus
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,ALLOC_NMBR,"
					+ " (SELECT TRUCK_NUMBER FROM vendor_vehicle_details where TRUCK_NUMBER IN (ap.ALLOC_NMBR)) as VECH_NO FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' "
//							+ "and DOC_DATE >='" + docDate
//					+ "' and DOC_DATE <='" + todate
					+ " and ITEM_TYPE='OPN' and SP_GL_IND='Y'  order by DOC_DATE desc;";
		} else {

			// for Security Deposit Refund Status
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,ALLOC_NMBR,"
					+ " (SELECT TRUCK_NUMBER FROM vendor_vehicle_details where TRUCK_NUMBER IN (ap.ALLOC_NMBR)) as VECH_NO FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "'"
//							+ " and DOC_DATE >='" + docDate
//					+ "' and DOC_DATE <='" + todate
					+ " and ITEM_TYPE='BAL' and SP_GL_IND='Y'  order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getSecurityDepositStatusReport size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	
	
	@Override
	public List<Object[]> getLogisticSecurityDepositStatus(String compCode, String vendorCode, String docDate,
			String todate, String itemType,String dateFilterFype) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {
			
			
			if(dateFilterFype.equals("YES")) {
				
			///// for SecurityDepositStatus
				sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,SP_GL_IND FROM ap_report as ap where COMP_CODE='"
						+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
						+ "' and DOC_DATE <='" + todate
						+ "' and ITEM_TYPE='OPN' and  SP_GL_IND IN('Y','L')  order by DOC_DATE desc;";
				
			}else {
				
			///// for SecurityDepositStatus
				sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,SP_GL_IND FROM ap_report as ap where COMP_CODE='"
						+ compCode + "' and VENDOR_CODE='" + vendorCode + "'  and ITEM_TYPE='OPN' and  SP_GL_IND IN('Y','L')  order by DOC_DATE desc;";
			}
			

			
		} else {
			
			if(dateFilterFype.equals("YES")) {

			// for Security Deposit Refund Status
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,SP_GL_IND FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate
					+ "' and ITEM_TYPE='BAL' and  SP_GL_IND IN('Y','L')  order by DOC_DATE desc;";
			
			}else{
				
				sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,SP_GL_IND FROM ap_report as ap where COMP_CODE='"
						+ compCode + "' and VENDOR_CODE='" + vendorCode 
						+ "' and ITEM_TYPE='BAL' and  SP_GL_IND IN('Y','L')  order by DOC_DATE desc;";
				
				
			}
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getSecurityDepositStatusReport size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	
	
	
	
	@Override
	public List<Object[]> getHmbDepositAmountReport(String compCode, String vendorCode, String docDate,
			String todate, String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			///// for SecurityDepositStatus
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,format(abs(ap.AMOUNT),2) as AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode 
					+ "' and ITEM_TYPE='OPN' and SP_GL_IND IN('2','3')  order by DOC_DATE desc;";
		} else {

			// for Security Deposit Refund Status
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,format(abs(ap.AMOUNT),2) as AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode 
					+ "' and ITEM_TYPE='BAL' and SP_GL_IND IN('2','3')  order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" get Hmb Deposit amount size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	
	
	@Override
	public List<Object[]> getDepositAmountReport(String compCode, String vendorCode, String docDate,
			String todate, String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			///// for SecurityDepositStatus
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate
					+ "' and ITEM_TYPE='OPN' and SP_GL_IND IN('2','3')  order by DOC_DATE desc;";
		} else {

			// for Security Deposit Refund Status
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate
					+ "' and ITEM_TYPE='BAL' and SP_GL_IND IN('2','3')  order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getSecurityDepositStatusReport size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> NegativeMilkAdvanceDetailsReport(String compCode, String vendorCode,  String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");
		
		
		
		sql="SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,sum(ap.AMOUNT),ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,(SELECT LTEXT FROM spl_gl where KOART='K' and SHBKZ=ap.SP_GL_IND) as SPL_GL_DESC FROM ap_report as ap"
				+ " where COMP_CODE='"+compCode+"' and VENDOR_CODE='"+vendorCode+"' and  ITEM_TYPE='OPN' and SP_GL_IND IN(SELECT SPL_GL FROM spl_gl_mapping where ITEM_NO='1')  group by ap.SP_GL_IND order by POSTING_DATE desc";
		
		
//		if (itemType.equals("Open")) {
//
//			///// for SecurityDepositStatus
//			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
//					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
//					+ "' and DOC_DATE <='" + todate
//					+ "' and ITEM_TYPE='OPN' and SP_GL_IND='4'  order by DOC_DATE desc;";
//		} else {
//
//			// for Security Deposit Refund Status
//			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
//					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
//					+ "' and DOC_DATE <='" + todate
//					+ "' and ITEM_TYPE='BAL' and SP_GL_IND='4'  order by DOC_DATE desc;";
//		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" NegativeMilkAdvanceDetailsReport size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	

//	@Override
//	public List<Object[]> MonthlyVehiclewiseDieselAmount(String compCode, String vendorCode, String docDate,
//			String todate, String itemType) {
//
//		String sql = "";
//
//		System.out.println("Enter the XML Query...");
//
//		if (itemType.equals("Open")) {
//
//			///// for SecurityDepositStatus
//			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
//					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
//					+ "' and DOC_DATE <='" + todate + "' and SP_GL_IND='M'  order by DOC_DATE desc;";
//		} else {
//
//			// for Security Deposit Refund Status
//			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT FROM ap_report as ap where COMP_CODE='"
//					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
//					+ "' and DOC_DATE <='" + todate + "' and SP_GL_IND='M'  order by DOC_DATE desc;";
//		}
//
//		System.out.println("XML Query..." + sql);
//
//		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();
//
//		System.out.println(" getSecurityDepositStatusReport size..." + getOutstandingData.size());
//
//		return getOutstandingData;
//	}
	
	@Override
	public List<Object[]> MonthlyVehiclewiseDieselAmount(String compCode, String vendorCode, String docDate,
			String todate, String itemType,String docType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			///// for SecurityDepositStatus
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,ALLOC_NMBR,"
					+ "(SELECT VEH_NO FROM fleet_card_master where FLEET_CARD=ap.ALLOC_NMBR) as VECH_NO,BKTXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and SP_GL_IND='M' and DOC_TYPE='"+docType+"' order by DOC_DATE desc;";
		} else {

			// for Security Deposit Refund Status
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,ALLOC_NMBR,"
					+ "(SELECT VEH_NO FROM fleet_card_master where FLEET_CARD=ap.ALLOC_NMBR) as VECH_NO,BKTXT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and SP_GL_IND='M' and DOC_TYPE='"+docType+"' order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getSecurityDepositStatusReport size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> MonthlyVehiclewiseAdditionalAmount(String compCode, String vendorCode, String docDate,
			String todate, String itemType,String docType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			///// for SecurityDepositStatus
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,ALLOC_NMBR,"
					+ "(SELECT VEH_NO FROM fleet_card_master where FLEET_CARD=ap.ALLOC_NMBR) as VECH_NO,ap.CLR_DOC_NO FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and SP_GL_IND='' and DOC_TYPE NOT IN('KZ','ZP','RE') order by DOC_DATE desc;";
		} else {

			// for Security Deposit Refund Status
			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,REF_DOC_NO,TDS_AMOUNT,ITEM_TEXT,ALLOC_NMBR,"
					+ "(SELECT VEH_NO FROM fleet_card_master where FLEET_CARD=ap.ALLOC_NMBR) as VECH_NO,ap.CLR_DOC_NO FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and SP_GL_IND='' and DOC_TYPE NOT IN('KZ','ZP','RE')  order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" MonthlyVehiclewiseAdditionalAmount size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getHMBFiledForceDataById(String hmbCode,String accountGroup,String roleId) {
		
//		List<FfsDesignationMapping> desgList= null;
//
//		desgList = (List<FfsDesignationMapping>) getSessioFactory().getCurrentSession().createCriteria(FfsDesignationMapping.class)
//				.add(Restrictions.eq("id.roleId", Integer.parseInt(roleId.toString()))).list();
//		
//		String desgType="";
//		
//		if(desgList.size()>0){
//			
//			for (FfsDesignationMapping societyInchargeMapping : desgList) {
//				desgType+="'"+societyInchargeMapping.getId().getDesgType()+"',";
//				System.out.println("desgType.."+desgType);
//			}
//		
//			
//		}
		
		String sql = "";
		
	
//sql="SELECT PLANT_CODE,PNAME,HMB,HMB_NAME,DESG_DESCR,DESG_LEVEL,DESG_TYPE, VENDOR,NAME,(SELECT MOBILE_NO_1 FROM vendor_master"
//		+ " where vendor_code=ffstaf.VENDOR ) as VENDOR_MOBILE_NO FROM field_force_staff ffstaf "
//		+ "where HMB='"+hmbCode+"' and DESG_TYPE IN("+desgType.substring(0, desgType.length() - 1)+") and VENDOR!='' order by  DESG_LEVEL ASC";


sql="SELECT ffstaf.PLANT_CODE,ffstaf.PNAME,ffstaf.HMB,ffstaf.HMB_NAME,ffstaf.DESG_DESCR,ffstaf.DESG_LEVEL,ffstaf.DESG_TYPE,ffstaf.VENDOR,NAME, "
+" (SELECT MOBILE_NO_2 FROM vendor_master WHERE vendor_code = ffstaf.VENDOR) AS VENDOR_MOBILE_NO "

+" FROM field_force_staff ffstaf,ffs_designation_mapping ffsmap WHERE "
+" ffstaf.HMB = '"+hmbCode+"' AND ffstaf.DESG_TYPE=ffsmap.DESG_TYPE "
+" AND ffstaf.VENDOR != '' AND ffsmap.ROLE_ID = '"+roleId+"'  "
+" ORDER BY ffsmap.DESG_ORDER ";

	

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Filed Force data..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
//	@Override
//	public List<Object[]> getHMBFiledForceDataById(String hmbCode,String accountGroup,String roleId) {
//		
//		String desType="";
//		
//		String sql = "";
//		
//		/// HMB Incharge 
//		if(accountGroup.equals("ATPY")) {
//
//			
//			desType="'RDE','ARDOCC','RDOCC','FTE','FTO','INS','VO','FeedASO','FeedSO'";
//			sql = "SELECT PLANT_CODE,PNAME,HMB,HMB_NAME,"
//					+ "(SELECT (SELECT DESG_DESCR FROM ffs_designation where DESG_TYPE=ffPos.DESG_TYPE and DESG_LEVEL!='0') as DESIGNATION FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION)as DESIGNATION,"
//					+ "(SELECT (SELECT DESG_LEVEL FROM ffs_designation where DESG_TYPE=ffPos.DESG_TYPE and DESG_LEVEL!='0') as DESIGNATION FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION)as DESG_LEVEL,"
//					+ "(SELECT DESG_TYPE FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION and DESG_TYPE IN("+desType+")) as DES_TYPE, VENDOR,NAME,"
//					+ "(SELECT MOBILE_NO_1 FROM vendor_master where vendor_code=ffstaf.VENDOR and MOBILE_NO_1!='0') as VENDOR_MOBILE_NO"
//					+ " FROM field_force_staff ffstaf where HMB='"+hmbCode+"' order by  DESG_LEVEL ASC";
//			
//		//// Building Owner
//		}else if(accountGroup.equals("HMBO")){
//			desType="'RDE','ARDOCC','RDOCC'";
//			
//			sql = "SELECT PLANT_CODE,PNAME,HMB,HMB_NAME,"
//					+ "(SELECT (SELECT DESG_DESCR FROM ffs_designation where DESG_TYPE=ffPos.DESG_TYPE and DESG_LEVEL!='0') as DESIGNATION FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION)as DESIGNATION,"
//					+ "(SELECT (SELECT DESG_LEVEL FROM ffs_designation where DESG_TYPE=ffPos.DESG_TYPE and DESG_LEVEL!='0') as DESIGNATION FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION)as DESG_LEVEL,"
//					+ "(SELECT DESG_TYPE FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION and DESG_TYPE IN("+desType+")) as DES_TYPE, VENDOR,NAME,"
//					+ "(SELECT MOBILE_NO_1 FROM vendor_master where vendor_code=ffstaf.VENDOR and MOBILE_NO_1!='0') as VENDOR_MOBILE_NO"
//					+ " FROM field_force_staff ffstaf where HMB='"+hmbCode+"' order by  DESG_LEVEL ASC";
//			
//		/// Farmer	
//		}else if(accountGroup.equals("FRMR")) {
//			desType="'RDE','ARDOCC','INS','VO','FeedASO','FeedSO'";
//			
//			sql = "SELECT PLANT_CODE,PNAME,HMB,HMB_NAME,"
//					+ "(SELECT (SELECT DESG_DESCR FROM ffs_designation where DESG_TYPE=ffPos.DESG_TYPE and DESG_LEVEL!='0') as DESIGNATION FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION)as DESIGNATION,"
//					+ "(SELECT (SELECT DESG_LEVEL FROM ffs_designation where DESG_TYPE=ffPos.DESG_TYPE and DESG_LEVEL!='0') as DESIGNATION FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION)as DESG_LEVEL,"
//					+ "(SELECT DESG_TYPE FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION and DESG_TYPE IN("+desType+")) as DES_TYPE, VENDOR,NAME,"
//					+ "(SELECT MOBILE_NO_1 FROM vendor_master where vendor_code=ffstaf.VENDOR and MOBILE_NO_1!='0') as VENDOR_MOBILE_NO"
//					+ " FROM field_force_staff ffstaf where HMB='"+hmbCode+"' order by  DESG_LEVEL ASC";
//			
//			
//		}
//	else if(accountGroup.equals("BLVN")) {
//		desType="'RDE','ARDOCC','INS','VO','FeedASO','FeedSO'";
//		
//		sql = "SELECT PLANT_CODE,PNAME,HMB,HMB_NAME,"
//				+ "(SELECT (SELECT DESG_DESCR FROM ffs_designation where DESG_TYPE=ffPos.DESG_TYPE and DESG_LEVEL!='0') as DESIGNATION FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION)as DESIGNATION,"
//				+ "(SELECT (SELECT DESG_LEVEL FROM ffs_designation where DESG_TYPE=ffPos.DESG_TYPE and DESG_LEVEL!='0') as DESIGNATION FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION)as DESG_LEVEL,"
//				+ "(SELECT DESG_TYPE FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION and DESG_TYPE IN("+desType+")) as DES_TYPE, VENDOR,NAME,"
//				+ "(SELECT MOBILE_NO_1 FROM vendor_master where vendor_code=ffstaf.VENDOR and MOBILE_NO_1!='0') as VENDOR_MOBILE_NO"
//				+ " FROM field_force_staff ffstaf where HMB='"+hmbCode+"' order by  DESG_LEVEL ASC";
//		
//		
//	}
//		else {
//			
//			sql = "SELECT PLANT_CODE,PNAME,HMB,HMB_NAME,"
//					+ "(SELECT (SELECT DESG_DESCR FROM ffs_designation where DESG_TYPE=ffPos.DESG_TYPE and DESG_LEVEL!='0') as DESIGNATION FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION)as DESIGNATION,"
//					+ "(SELECT (SELECT DESG_LEVEL FROM ffs_designation where DESG_TYPE=ffPos.DESG_TYPE and DESG_LEVEL!='0') as DESIGNATION FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION)as DESG_LEVEL,"
//					+ "(SELECT DESG_TYPE FROM ffs_position ffPos where POSITION_ID=ffstaf.POSITION ) as DES_TYPE, VENDOR,NAME,"
//					+ "(SELECT MOBILE_NO_1 FROM vendor_master where vendor_code=ffstaf.VENDOR and MOBILE_NO_1!='0') as VENDOR_MOBILE_NO"
//					+ " FROM field_force_staff ffstaf where HMB='"+hmbCode+"' order by  DESG_LEVEL ASC";
//			
//			
//		}
//
//		
//
//		
//	
//
//		System.out.println("XML Query..." + sql);
//
//		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();
//
//		System.out.println(" Filed Force data..." + getOutstandingData.size());
//
//		return getOutstandingData;
//	}
	
	@Override
	public List<Object[]> getRentalPaymentStauswithmonth(String compCode, String vendorCode, String docDate,
			String todate, String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

		if (itemType.equals("Open")) {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,ITEM_TEXT,TDS_AMOUNT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and  DOC_DATE <='" + todate
					+ "' and ITEM_TYPE='OPN' and DOC_TYPE IN ('ZF') order by DOC_DATE desc;";
		} else {

			sql = "SELECT ap.COMP_CODE,ap.VENDOR_CODE,ap.DOC_NO,ap.FI_YEAR,ap.DOC_TYPE,ap.DOC_DATE,ap.POSTING_DATE,ap.AMOUNT,ap.DB_CR_IND,(SELECT NAME FROM vendor_master where COMP_CODE=ap.COMP_CODE and VENDOR_CODE=ap.VENDOR_CODE) as VENDOR_NAME,(SELECT DOC_TYPE_DESC FROM doc_type_master where DOC_TYPE=ap.DOC_TYPE and STATUS='A') DOC_TYPE_NAME,ITEM_TEXT,TDS_AMOUNT FROM ap_report as ap where COMP_CODE='"
					+ compCode + "' and VENDOR_CODE='" + vendorCode + "' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate + "' and DOC_TYPE IN ('ZF') order by DOC_DATE desc;";
		}

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	
	@Override
	public List<Object[]> getTransporterPayment(String compCode, String vendorCode, String docDate,
			String todate, String itemType) {

		String sql = "";

		System.out.println("Enter the XML Query...");

	

			///// for SecurityDepositStatus
			sql = "SELECT DOC_DATE,FI_YEAR,REF_DOC_NO,ALLOC_NMBR,ITEM_TEXT,DB_CR_IND,abs(AMOUNT) as AMOUNT FROM ap_report where ITEM_TYPE='BAL' and  VENDOR_CODE='"+vendorCode+"'and  DOC_TYPE IN ('ZP') and SP_GL_IND='' and DOC_DATE >='" + docDate
					+ "' and DOC_DATE <='" + todate+"' order by DOC_DATE desc";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getTransporterPayment size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	public	NewsLetter getNewsLetterImageById(String countryCode,String regionCode, String status,String typeId)  {
		
		System.out.println("Region."+regionCode+"status."+status+"typeId."+typeId);
		NewsLetter image = (NewsLetter) getSessioFactory().getCurrentSession().createCriteria(NewsLetter.class).add(Restrictions.eq("id.countryCode", countryCode))
				.add(Restrictions.eq("id.regionCode", regionCode))
				.add(Restrictions.eq("id.typeId", Integer.parseInt(typeId))).add(Restrictions.eq("status", status))
				.uniqueResult();
		
		System.out.println("image..file name."+image.getFileName());
		
		

		return image;
	}
	
	public	VendorMaster getVendorRegionCode(String vendorCode,String status)  {
		
		
		VendorMaster vendor = (VendorMaster) getSessioFactory().getCurrentSession().createCriteria(VendorMaster.class)
				.add(Restrictions.eq("id.vendorCode", vendorCode))
				.add(Restrictions.eq("status", status))
				.uniqueResult();
		if(vendor!=null) {
			
			Hibernate.initialize(vendor.getRegionMaster());
		}
		
		
		

		return vendor;
	}

	
	
	

}
