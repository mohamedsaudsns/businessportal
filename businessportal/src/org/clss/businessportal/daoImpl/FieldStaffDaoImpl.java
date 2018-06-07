package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.dao.FieldStaffDao;
import org.clss.businessportal.entity.CcHmbCompare;
import org.springframework.stereotype.Repository;

@Repository("/FieldStaffDao")
public class FieldStaffDaoImpl extends GenericDaoImpl<CcHmbCompare, Serializable> implements FieldStaffDao{

	
	
	@Override
	public List<Object[]> getCcHmbCompareReport(String vendor_code,String fromDate,String todate)
			{

		String sql = "";

		System.out.println("Enter the XML Query...");

	

			// for Security Deposit Refund Status
			sql = "SELECT WERKS,(SELECT PLANT_DESC FROM plant_master where PLANT=cchmb.WERKS) as PLANT_NAME,SOCIETY,(SELECT NAME FROM vendor_master where VENDOR_CODE=cchmb.SOCIETY) as SOCITY_NAME,DATE_FORMAT(CRDAT,'%d/%m/%Y'),SHIFT,QUANTITY,ERFMG_LTR,DIFF FROM cc_hmb_compare cchmb"
					+ "  where SOCIETY IN (SELECT HMB FROM field_force_staff where VENDOR='"+vendor_code+"'  and  HMB_DATE>=now()) and CRDAT between '"+fromDate+"' and '"+todate+"' and  QUANTITY='0' order by CRDAT,SHIFT DESC ";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Summary size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	@Override
	public List<Object[]> getComparisionStatementReport(String vendor_code,String fromDate,String todate)
			{

		String sql = "";

		System.out.println("Enter the XML Query...");

	

			// for Security Deposit Refund Status
			sql = "SELECT PLANT,(SELECT PLANT_DESC FROM plant_master where PLANT=mshmb.PLANT) as PLANT_NAME,SOCIETY,(SELECT NAME FROM vendor_master where VENDOR_CODE=mshmb.SOCIETY) as SOCITY_NAME,DATE_FORMAT(SS_DATE,'%d/%m/%Y') as SS_DATE,SHIFT,P_NAME,S_NAME,QUANTITY,QUANTITY_KG,FAT,SNF,CTS,CKGFAT,CKGSNF,ERFMG_LTR,FAT_N,SNF_N,TS_N,DKGFAT,DKGSNF,ROUTE,R_NAME,ERFMG_LTR_S,CKGFAT_S,CKGSNF_S,FAT_S,SNF_S,ERFMG_LTR_E,CKGFAT_E,CKGSNF_E,FAT_E,SNF_E FROM milk_snf_compare mshmb"
					+ "  where SOCIETY IN (SELECT HMB FROM field_force_staff where VENDOR='"+vendor_code+"'  and  HMB_DATE>=now()) and SS_DATE between '"+fromDate+"' and '"+todate+"'  order by SS_DATE,SHIFT DESC ";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println("get comparision Statement size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	@Override
	public List<Object[]> getTsRecoveryReport(String vendor_code,String fromDate,String todate)
			{

		String sql = "";

		System.out.println("Enter the XML Query...");

	

			// for Security Deposit Refund Status
			sql = "SELECT PLANT_CODE,(SELECT PLANT_DESC FROM plant where PLANT=mshmb.PLANT_CODE) as PLANT_NAME,HMB,(SELECT NAME FROM vendor_master where VENDOR_CODE=mshmb.HMB) as SOCITY_NAME,SUM_LT_CENTER,SUM_KG_FAT_CENTER,SUM_KG_SNF_CENTER,SUM_LT_SCAN,SUM_KG_FAT_SCAN,SUM_KG_SNF_SCAN,DIFF_LT,DIFF_PER,DIFF_SUM_KG_FAT,DIFF_SUM_KG_SNF,TOTAL_SOLID,AMT_DIFF_SCAN_QTY_LTR,TOTAL_SOLID_AMT,TOTAL_TS,SAM_MILK,FMILK_SH_AMT,FTS_SH_AMT,DATE_FORMAT(DATE_FRM,'%d/%m/%Y') as DATE_FROM,DATE_FORMAT(DATE_TO,'%d/%m/%Y') as DATE_TO,RDE_NAME,ARDOCC_NAME,RDOCC_NAME FROM ts_recovery mshmb  where HMB IN (SELECT HMB FROM field_force_staff"
					+ " where VENDOR='"+vendor_code+"'  and  HMB_DATE>=now()) and DATE_FRM between '"+fromDate+"' and '"+todate+"'  order by DATE_FRM,DATE_TO DESC ";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println("get Ts Recovery size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	@Override
	public List<Object[]> getFfsServiceCharge(String compCode,  String  inchargeCode,String fromDate,String todate) {

		String sql = "";


			sql = "SELECT POST_DAT,BILL_NUM,TOTAL,TOTAL_TDS,NET_Amt,C_START_DATE,C_END_DATE,SOCIETY,C_NAME,AVG_QTY	,LIFNR,(SELECT NAME FROM vendor_master where VENDOR_CODE=hmbService.LIFNR) VENDOR_NAME,ACT_NO_OF_DAYS "
			+",(SELECT PAN_NO FROM vendor_master where VENDOR_CODE=hmbService.LIFNR) PAN_NO,(SELECT ADDRESS FROM plant_master where PLANT=hmbService.WERKS) as "
			+"PLANT_ADDRESS,(SELECT city FROM plant_master where PLANT=hmbService.WERKS) as CITY,(SELECT PINCODE FROM plant_master where PLANT=hmbService.WERKS) as PIN_CODE "


			+",SAMPLE_MILK_AMT,ARREAR_AMT,ACT_DED,TS_TALLY,ADLT_COMM,TEST_COMM,SPIL_COMM,TS_COMM,QTY_COMM,FEED_AMT,INC_AMT,SMS_AMT,(SELECT PLANT_DESC FROM plant_master where PLANT=hmbService.WERKS) as PLANT_DESC "

			+" FROM hmb_service_charges hmbService where COMP_CODE='"+compCode+"' and LIFNR='"+inchargeCode+"' and MONTH(C_END_DATE)=MONTH('"+fromDate+"') and PARVW='IN'";
			
			
		System.out.println("getFfsServiceCharge Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getFfsServiceCharge size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	@Override
	public List<Object[]> getFfsServiceChargeDeduction(String incharge,  String  society,String fromDate,String todate) {

		String sql = "";

			sql = "SELECT (SELECT DEDUCTION_DESC FROM deduction_master where DEDUCTION_CODE=ZDEDTYPE) as Deduction_DESC,ZDEDTYPE,ZDEDAMT FROM hmb_service_deduction where ZVENDOR='"+incharge+"' and  ZCC_HMB='"+society+"' and  ZSDATE between '"+fromDate+"' and '"+todate+"' and PAID='X'";
			
			
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getFfsServiceChargeDeduction size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	@Override
	public List<Object[]> getFfsServiceArrear(String  society,String fromDate,String todate) {

		String sql = "";


			sql = "SELECT ARREAR_CODE,ARREAR_DESC,sum(AMT) as SUM_AMOUNT  FROM hmb_service_arrear ar where CENTER_CODE='"+society+"' and ARRALL_DATE   between '"+fromDate+"' and '"+todate+"' group by ARREAR_CODE";
			
			
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getFfsServiceArrear size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	

	
	

}
