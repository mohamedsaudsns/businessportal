package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.clss.businessportal.custommodel.HmbSummaryCustomModel;
import org.clss.businessportal.custommodel.MilkDeductionDetailCustomModel;
import org.clss.businessportal.dao.HmbDao;
import org.clss.businessportal.entity.AgreementHa;
import org.clss.businessportal.entity.MilkPaymentHa;
import org.clss.businessportal.entity.SocietyInchargeMapping;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("/HmpDao")
public class HmbDaoImpl extends GenericDaoImpl<MilkPaymentHa, Serializable> implements HmbDao{

	
	
	@Override
	public List<Object[]> getHmpSummary(String compCode, String socity, String farmer,
			String fromDate, String toDate) {

		String sql = "";

		System.out.println("Enter the XML Query...");

	

			// for Security Deposit Refund Status
			sql = "SELECT COMP_CODE,BILL_NUM,DATE_FRM,DATE_TO,plant,SOCIETY,FARMER,GROSS_AMT,DEDUCTIONS,RECOVERIES,ARREARS,NET_AMT,ACT_DED,F_NAME,INCENTIVE,BANKN,BANKL,BASIC_MILK,P_CODE,C_NAME FROM milk_payment_ha WHERE COMP_CODE='"+compCode+"' and  SOCIETY='"+socity+"' and FARMER='"+farmer+"' and DATE_FRM IN (SELECT DATE_FRM " 
             +"   FROM milk_payment_ha where "
              +" (DATE_FRM BETWEEN '"+fromDate+"' AND '"+toDate+"')    or  (DATE_TO BETWEEN '"+fromDate+"' AND '"+toDate+"')  ) ";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Summary size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getHmpInchargeSummary(String compCode, String farmer,
			String fromDate, String toDate) {
		
		List<SocietyInchargeMapping> socityList = null;

		socityList = (List<SocietyInchargeMapping>) getSessioFactory().getCurrentSession().createCriteria(SocietyInchargeMapping.class)
				.add(Restrictions.eq("id.compCode", compCode)).add(Restrictions.eq("id.ekorg", "1000"))
				.add(Restrictions.eq("id.parvw", "IN"))
				.add(Restrictions.eq("incharge", farmer)).list();
		
		String socity="";
		
		if(socityList.size()>0){
			
			for (SocietyInchargeMapping societyInchargeMapping : socityList) {
				socity+=""+societyInchargeMapping.getId().getSociety()+",";
//				System.out.println("socity.."+socity);
			}
		
			
		}

		String sql = "";

//		System.out.println("Enter the XML Query...");

	

			// for Security Deposit Refund Status
//			sql = "SELECT COMP_CODE,BILL_NUM,DATE_FRM,DATE_TO,plant,SOCIETY,FARMER,GROSS_AMT,DEDUCTIONS,RECOVERIES,ARREARS,NET_AMT,ACT_DED,F_NAME,INCENTIVE,BANKN,BANKL,BASIC_MILK,"
//					+ "(SELECT ROUND(sum(QUANTITY),3) FROM milk_payment_li milk_pay_li where comp_code=mpha.COMP_CODE and plant=mpha.PLANT and SOCIETY=mpha.SOCIETY and BILL_NUM=mpha.BILL_NUM ) as TOTAL_LTR,mpha.P_CODE"
//					+ " FROM milk_payment_ha mpha WHERE COMP_CODE='"+compCode+"' and  SOCIETY IN ("+socity.substring(0, socity.length() - 1)+")  and DATE_FRM IN (SELECT DATE_FRM " 
//             +"   FROM milk_payment_ha where "
//              +" (DATE_FRM BETWEEN '"+fromDate+"' AND '"+toDate+"')    or  (DATE_TO BETWEEN '"+fromDate+"' AND '"+toDate+"')  ) ";
//		
			
			
			sql="SELECT COMP_CODE,BILL_NUM,DATE_FRM,DATE_TO,plant,SOCIETY,FARMER,GROSS_AMT,DEDUCTIONS,RECOVERIES,ARREARS,NET_AMT,ACT_DED,F_NAME,INCENTIVE,BANKN,BANKL,BASIC_MILK,(SELECT ROUND(sum(QUANTITY),3) FROM milk_payment_li milk_pay_li where milk_pay_li.comp_code=mpha.COMP_CODE and milk_pay_li.plant=mpha.PLANT and milk_pay_li.SOCIETY=mpha.SOCIETY and milk_pay_li.BILL_NUM=mpha.BILL_NUM ) as TOTAL_LTR, mpha.P_CODE FROM milk_payment_ha mpha WHERE "
					+ " mpha.COMP_CODE='"+compCode+"' and  mpha.SOCIETY IN ("+socity.substring(0, socity.length() - 1)+")  and (  (DATE_FRM BETWEEN '"+fromDate+"' AND '"+toDate+"')  or  (DATE_TO BETWEEN '"+fromDate+"' AND '"+toDate+"')  ) ";
			

		System.out.println("HMB Summary Header Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Summary Header size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getHmbInchargeDeductions(String compCode, String farmer,
			String fromDate, String toDate) {
		
		List<SocietyInchargeMapping> socityList = null;

		socityList = (List<SocietyInchargeMapping>) getSessioFactory().getCurrentSession().createCriteria(SocietyInchargeMapping.class)
				.add(Restrictions.eq("id.compCode", compCode)).add(Restrictions.eq("id.ekorg", "1000"))
				.add(Restrictions.eq("id.parvw", "IN")).add(Restrictions.eq("incharge", farmer)).list();
		
		String socity="";
		
		if(socityList.size()>0){
			
			for (SocietyInchargeMapping societyInchargeMapping : socityList) {
				socity+=""+societyInchargeMapping.getId().getSociety()+",";
				System.out.println("socity.."+socity);
			}
		
			
		}

		String sql = "";


			// for Security Deposit Refund Status
//			sql = "SELECT DATE_FRM,DATE_TO,plant,SOCIETY,FARMER,format(sum(DEDUCTIONS),2) as DEDUCTIONS "
//					+ " FROM milk_payment_ha mpha WHERE COMP_CODE='"+compCode+"' and  SOCIETY IN ("+socity.substring(0, socity.length() - 1)+")  and DATE_FRM IN (SELECT DATE_FRM " 
//             +"   FROM milk_payment_ha where "
//              +" (DATE_FRM BETWEEN '"+fromDate+"' AND '"+toDate+"')    or  (DATE_TO BETWEEN '"+fromDate+"' AND '"+toDate+"')  ) group by DATE_FRM,DATE_TO ";
//		

			
			// For Milk Deduction
			
			
			sql="SELECT mpha.DATE_FRM,mpha.DATE_TO,mpha.plant,mpha.SOCIETY,mpha.FARMER,format(sum(mpha.DEDUCTIONS),2) as DEDUCTIONS  FROM milk_payment_ha mpha WHERE mpha.COMP_CODE='"+compCode+"' and  mpha.SOCIETY IN ("+socity.substring(0, socity.length() - 1)+")  and  ((mpha.DATE_FRM BETWEEN '"+fromDate+"' AND '"+toDate+"')    or  (mpha.DATE_TO BETWEEN '"+fromDate+"' AND '"+toDate+"') )  group by mpha.DATE_FRM,mpha.DATE_TO ";
			
			
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Deduction size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	@Override
	public List<MilkDeductionDetailCustomModel> getHmbInchargeDeductionsDetails(String compCode, String inchargeCode,
			String fromDate, String toDate) {
		
		
		List<MilkDeductionDetailCustomModel> deductionList = new ArrayList<MilkDeductionDetailCustomModel>();
		
	
		String sql1="",sql2="";
		
		
//		sql1="SELECT mpha.FARMER,mpha.F_NAME,mpha.P_CODE,DATE_FORMAT(deductionSd.ERDAT,'%d.%m.%Y') as ERDAT,(SELECT DEDUCTION_DESC FROM deduction_master where DEDUCTION_CODE=deductionSd.ZDEDTYPE) as DEDUCTION_NAME,deductionSd.VALUE FROM milk_payment_ha mpha INNER JOIN milk_deduction_sd deductionSd ON  mpha.plant=deductionSd.WERKS and mpha.SOCIETY=deductionSd.SOCIETY and mpha.BILL_NUM=deductionSd.BILL_NUM WHERE"
//				+ " mpha.COMP_CODE='"+compCode+"' and  mpha.SOCIETY IN (SELECT SOCIETY FROM society_incharge_mapping where COMP_CODE='"+compCode+"' and INCHARGE='"+inchargeCode+"')  and DATE_FRM IN (SELECT DATE_FRM    FROM milk_payment_ha where  "
//						+ "(DATE_FRM BETWEEN '"+fromDate+"' AND '"+toDate+"')    or  (DATE_TO BETWEEN '"+fromDate+"' AND '"+toDate+"')  )  " ; 
		
		
		sql1="SELECT mpha.FARMER,mpha.F_NAME,mpha.P_CODE,DATE_FORMAT(deductionSd.ERDAT,'%d.%m.%Y') as ERDAT,(SELECT dm.DEDUCTION_DESC FROM deduction_master dm where dm.DEDUCTION_CODE=deductionSd.ZDEDTYPE) as DEDUCTION_NAME,deductionSd.VALUE FROM milk_payment_ha mpha INNER JOIN milk_deduction_sd deductionSd ON  mpha.plant=deductionSd.WERKS and mpha.SOCIETY=deductionSd.SOCIETY and mpha.BILL_NUM=deductionSd.BILL_NUM WHERE mpha.COMP_CODE='"+compCode+"' and  mpha.SOCIETY IN (SELECT sm.SOCIETY FROM society_incharge_mapping sm where sm.COMP_CODE='"+compCode+"' and sm.INCHARGE='"+inchargeCode+"')  and  ( (mpha.DATE_FRM BETWEEN '"+fromDate+"' AND '"+toDate+"')    or  (mpha.DATE_TO BETWEEN '"+fromDate+"' AND '"+toDate+"')  ) ;";
		
		sql2="SELECT mpha.FARMER,mpha.F_NAME,mpha.P_CODE,DATE_FORMAT(deduction.ZSDATE,'%d.%m.%Y') as ZSDATE,(SELECT DEDUCTION_DESC FROM deduction_master where DEDUCTION_CODE=deduction.ZDEDTYPE) as DEDUCTION_NAME,deduction.ZDEDAMT FROM milk_payment_ha mpha INNER JOIN milk_deduction deduction ON  mpha.plant=deduction.WERKS  and mpha.BILL_NUM=deduction.BILL_NUM WHERE"
				+ " mpha.COMP_CODE='"+compCode+"' and  mpha.SOCIETY IN (SELECT SOCIETY FROM society_incharge_mapping where COMP_CODE='"+compCode+"' and INCHARGE='"+inchargeCode+"') and  ( ( mpha.DATE_FRM BETWEEN '"+fromDate+"' AND '"+toDate+"')    or  ( mpha.DATE_TO BETWEEN '"+fromDate+"' AND '"+toDate+"')  )"  ;
		
	//	sql1="";


	List<Object[]> query1Data = getSessioFactory().getCurrentSession().createSQLQuery(sql1).list();
	
	for (Object[] outReport : query1Data) {
		MilkDeductionDetailCustomModel deModel=new MilkDeductionDetailCustomModel();
		
		deModel.setFarmerCode(outReport[0].toString());
		deModel.setFarmerName(outReport[1].toString());
		deModel.setpCode(outReport[2].toString());
		deModel.setEntryDate(outReport[3].toString());
		deModel.setDeductionName(outReport[4].toString());
		deModel.setDeductionamount(outReport[5].toString());
		deductionList.add(deModel);
	
	}
	
List<Object[]> query2Data = getSessioFactory().getCurrentSession().createSQLQuery(sql2).list();
	
	for (Object[] outReport : query2Data) {
		MilkDeductionDetailCustomModel deModel=new MilkDeductionDetailCustomModel();
		
		deModel.setFarmerCode(outReport[0].toString());
		deModel.setFarmerName(outReport[1].toString());
		deModel.setpCode(outReport[2].toString());
		deModel.setEntryDate(outReport[3].toString());
		deModel.setDeductionName(outReport[4].toString());
		deModel.setDeductionamount(outReport[5].toString());
		deductionList.add(deModel);
	
	}
	


		System.out.println("sql1" + sql1);
		System.out.println("sql2" + sql2);

		return deductionList;
	}
	
	
	
	
	@Override
	public List<Object[]> getHmpPaymentDetails(String compCode, String plant, String  socity,
			String billNumber) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT DMBTR,QUANTITY,FAT,SNF,CLR,SS_DATE,SHIFT,"
					+ "(SELECT sum(amt) FROM milk_incentive where WERKS='"+plant+"' and SOCIETY='"+socity+"' and PARTNER=milk_pay_li.FARMER and BILL_NUM='"+billNumber+"' and CRDAT=milk_pay_li.SS_DATE and SHIFT=milk_pay_li.SHIFT group by WERKS,SOCIETY,CRDAT,SHIFT) as INCENTIVE_AMOUNT,MILK_TYPE "
							+ "FROM milk_payment_li milk_pay_li where comp_code='"+compCode+"' and plant='"+plant+"' and SOCIETY='"+socity+"' and BILL_NUM='"+billNumber+"' ";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Payment Details size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	@Override
	public List<Object[]> getHmpArrearDetails(String compCode, String plant, String  socity,
			String billNumber) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT (SELECT ARREAR_NAME FROM arrear_master where ARREAR_CODE=ma.ARREAR_CODE) as ARREAR_NAME,AMT,ARREAR_DAT FROM milk_arrear ma where comp_code='"+compCode+"' and plant='"+plant+"' and SOCIETY='"+socity+"' and BILL_NUM='"+billNumber+"' ";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Arrear Details size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getHmpDeductionDetails(String compCode, String plant, String  socity,
			String billNumber) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT (SELECT DEDUCTION_DESC FROM deduction_master where DEDUCTION_CODE=md.ZDEDTYPE) as DEDUCTION_NAME,ZDEDAMT,ZSDATE "
+" FROM milk_deduction md where comp_code='"+compCode+"' and WERKS='"+plant+"'  and BILL_NUM='"+billNumber+"'";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Deduction Details size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getHmpDeductionSdDetails(String compCode, String plant, String  socity,
			String billNumber) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT (SELECT DEDUCTION_DESC FROM deduction_master where DEDUCTION_CODE=mds.ZDEDTYPE) as DEDUCTION_NAME,VALUE,ERDAT FROM milk_deduction_sd mds "
					+ "where comp_code='"+compCode+"' and WERKS='"+plant+"' and SOCIETY='"+socity+"' and BILL_NUM='"+billNumber+"'";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Deduction SD Details size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getHmpRecoveryDetails(String compCode, String plant, String  socity,
			String billNumber) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT ( SELECT RECOVERY_NAME FROM recovery_master where  RECOVERY_CODE=mr.RECOVERY)"
					+ " AS MILK_RECOVERY_NAME,AMT,RECVRY_DATE FROM milk_recovery as mr where comp_code='"+compCode+"'   and SOCIETY='"+socity+"' and BILL_NUM='"+billNumber+"'";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Deduction Details size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	
	@Override
	public List<Object[]> getHmpIncentiveDetails(String compCode, String plant, String  socity,
			String billNumber,String currentDate) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT CRDAT,(SELECT INC_DESCRIPTION FROM milk_incentive_master where inc_type=mi.INC_TYPE and INC_VALID_FROM<='"+currentDate+"' and INC_VALID_TO>='"+currentDate+"') as INCENTIVE_NAME,AMT FROM milk_incentive mi where"
					+ " WERKS='"+plant+"' and SOCIETY='"+socity+"' and BILL_NUM='"+billNumber+"'";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Incentive Details size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getMaterialStock(String compCode,  String  socity) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT MATNR,MATNR_DESC,LBLAB FROM material_stock where COMP_CODE='"+compCode+"' and LIFNR='"+socity+"'";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Material Stock Details size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	@Override
	public List<Object[]> getEkoMaterialStock( String  socity) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT SWERK,EQUNR,MSGRP,EQKTX,INVNR FROM eko_material_stock where MSGRP='"+socity+"'";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Eko Material Stock Details size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	@Override
	public List<Object[]> getAvgMilkMonth(String compCode,  String  socity1,String selectedYear,String farmer) {

		
		List<SocietyInchargeMapping> socityList = null;

		socityList = (List<SocietyInchargeMapping>) getSessioFactory().getCurrentSession().createCriteria(SocietyInchargeMapping.class)
				.add(Restrictions.eq("id.compCode", compCode)).add(Restrictions.eq("id.ekorg", "1000"))
				.add(Restrictions.eq("id.parvw", "IN")).add(Restrictions.eq("incharge", farmer)).list();
		
		String socity="";
		
		if(socityList.size()>0){
			
			for (SocietyInchargeMapping societyInchargeMapping : socityList) {
				socity+=""+societyInchargeMapping.getId().getSociety()+",";
				System.out.println("socity.."+socity);
			}
		
			
		}
		
		
		
		
		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT MONTH(CRDAT),sum(QUANTITY) as QTY_SUM,sum(KG_FAT) as FAT_SUM,sum(KG_SNF) as SNF_SUM,year(CRDAT) as SELECTED_YEAR, SOCIETY,day(last_day(CRDAT))"
					+ ",sum(QUANTITY_KG) as QTY_KG_SUM FROM milk_avg where"
					+ "   year(CRDAT)='"+selectedYear+"' and SOCIETY='"+socity.substring(0, socity.length() - 1)+"' group by MONTH(CRDAT)";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Avg Milk Month size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getAvgMilkMonthLi(String socity, String  selectedYear,String selectedMonth) {


		
		
		
		
		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT CRDAT,SHIFT,QUANTITY,FAT_PER,snf_per FROM milk_avg"
					+ " where SOCIETY='"+socity+"' and year(CRDAT)='"+selectedYear+"' and MONTH(CRDAT)='"+selectedMonth+"'  order by  CRDAT,SHIFT DESC";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Avg Milk Month size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	
	
	@Override
	public List<Object[]> getMilkLiability(String socity) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
		//	sql = "SELECT POST_DAT,BILL_NUM,TOTAL,TOTAL_TDS,NET_Amt FROM vendor_portal.hmb_service_charges where COMP_CODE='"+compCode+"' and LIFNR='"+inchargeCode+"' and C_START_DATE>='"+fromDate+"'";
		

			sql = "SELECT DATE_FORMAT(FROM_DATE,'%b-%y') AS INPUT_DATE , FROM_DATE,TO_DATE,REC_MILK as LPD,NO_OF_FARMERS as NOP,FAT_N as FAT_PER,SNF_N as SNF_PER FROM milk_liability where "
					+ "SOCIETY='"+socity+"' and FROM_DATE BETWEEN CURDATE() - INTERVAL 12 MONTH AND CURDATE();";
			
			
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Milk Liability size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	@Override
	public List<Object[]> MilkFeeds(String socity) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
		//	sql = "SELECT POST_DAT,BILL_NUM,TOTAL,TOTAL_TDS,NET_Amt FROM vendor_portal.hmb_service_charges where COMP_CODE='"+compCode+"' and LIFNR='"+inchargeCode+"' and C_START_DATE>='"+fromDate+"'";
		

			sql = "SELECT DATE_FORMAT(SPMON,'%b-%y') AS INPUT_DATE ,TRUNCATE(sum(NETSALESQTKG),0) as NET_SALES FROM hmb_material_stock where LIFNR='"+socity+"' and SPMON BETWEEN CURDATE() - INTERVAL 12 MONTH AND CURDATE() group by SPMON;";
			
			
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Milk Feeds size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	
	
	@Override
	public List<Object[]> getHmServiceCharge(String compCode,  String  inchargeCode,String fromDate,String todate) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
		//	sql = "SELECT POST_DAT,BILL_NUM,TOTAL,TOTAL_TDS,NET_Amt FROM vendor_portal.hmb_service_charges where COMP_CODE='"+compCode+"' and LIFNR='"+inchargeCode+"' and C_START_DATE>='"+fromDate+"'";
		

			sql = "SELECT POST_DAT,BILL_NUM,TOTAL,TOTAL_TDS,NET_Amt,C_START_DATE,C_END_DATE,SOCIETY,C_NAME,AVG_QTY	,LIFNR,(SELECT NAME FROM vendor_master where VENDOR_CODE=hmbService.LIFNR) VENDOR_NAME,ACT_NO_OF_DAYS "
			+",(SELECT PAN_NO FROM vendor_master where VENDOR_CODE=hmbService.LIFNR) PAN_NO,(SELECT ADDRESS FROM plant_master where PLANT=hmbService.WERKS) as "
			+"PLANT_ADDRESS,(SELECT city FROM plant_master where PLANT=hmbService.WERKS) as CITY,(SELECT PINCODE FROM plant_master where PLANT=hmbService.WERKS) as PIN_CODE "


			+",SAMPLE_MILK_AMT,ARREAR_AMT,ACT_DED,TS_TALLY,ADLT_COMM,TEST_COMM,SPIL_COMM,TS_COMM,QTY_COMM,FEED_AMT,INC_AMT,SMS_AMT,(SELECT PLANT_DESC FROM plant_master where PLANT=hmbService.WERKS) as PLANT_DESC "

			+" FROM hmb_service_charges hmbService where COMP_CODE='"+compCode+"' and LIFNR='"+inchargeCode+"' and MONTH(C_END_DATE)=MONTH('"+fromDate+"') and PARVW='IN'";
			
			
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Service Charge size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	@Override
	public List<Object[]> getHmServiceChargeDeduction(String incharge,  String  society,String fromDate,String todate) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
		//	sql = "SELECT POST_DAT,BILL_NUM,TOTAL,TOTAL_TDS,NET_Amt FROM vendor_portal.hmb_service_charges where COMP_CODE='"+compCode+"' and LIFNR='"+inchargeCode+"' and C_START_DATE>='"+fromDate+"'";
		

			sql = "SELECT (SELECT DEDUCTION_DESC FROM deduction_master where DEDUCTION_CODE=ZDEDTYPE) as Deduction_DESC,ZDEDTYPE,ZDEDAMT FROM hmb_service_deduction where ZVENDOR='"+incharge+"' and  ZCC_HMB='"+society+"' and  ZSDATE between '"+fromDate+"' and '"+todate+"' and PAID='X'";
			
			
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Service Charge Deduction size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	@Override
	public List<Object[]> getHmServiceArrear(String  society,String fromDate,String todate) {

		String sql = "";


			sql = "SELECT ARREAR_CODE,ARREAR_DESC,sum(AMT) as SUM_AMOUNT  FROM hmb_service_arrear ar where CENTER_CODE='"+society+"' and ARRALL_DATE   between '"+fromDate+"' and '"+todate+"' group by ARREAR_CODE";
			
			
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getHmServiceArrear size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	public List<SocietyInchargeMapping> getSocietyInchargeMappingList(String compcode,String inchargeCode,String partnerFunction){
		
	
		
		List<SocietyInchargeMapping> socityList = null;

		socityList = (List<SocietyInchargeMapping>) getSessioFactory().getCurrentSession().createCriteria(SocietyInchargeMapping.class)
				.add(Restrictions.eq("id.compCode", compcode)).add(Restrictions.eq("id.ekorg", "1000"))
				.add(Restrictions.eq("id.parvw", partnerFunction)).add(Restrictions.eq("incharge", inchargeCode)).list();
		

		return socityList;
		
	}

	
	@Override
	public List<Object[]> getBulkHmpSummary(String compCode, String socity, String farmer,
			String fromDate, String toDate) {

		String sql = "";

		System.out.println("Enter the XML Query...");

	

			// for Security Deposit Refund Status
			sql = "SELECT COMP_CODE,BILL_NUM,DATE_FRM,DATE_TO,plant,SOCIETY,FARMER,GROSS_AMT,DEDUCTIONS,RECOVERIES,ARREARS,NET_AMT,ACT_DED,F_NAME,INCENTIVE,BANKN,BANKL,BASIC_MILK FROM milk_payment_ha WHERE COMP_CODE='"+compCode+"' and  SOCIETY='"+socity+"'  and DATE_FRM IN (SELECT DATE_FRM " 
             +"   FROM milk_payment_ha where "
              +" (DATE_FRM BETWEEN '"+fromDate+"' AND '"+toDate+"')    or  (DATE_TO BETWEEN '"+fromDate+"' AND '"+toDate+"')  ) ";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Summary size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	@Override
	public List<Object[]> getFarmHmpSummary(String compCode, String socity, String farmer,
			String fromDate, String toDate) {

		String sql = "";

		System.out.println("Enter the XML Query...");

	

			// for Security Deposit Refund Status
			sql = "SELECT COMP_CODE,BILL_NUM,DATE_FRM,DATE_TO,plant,SOCIETY,FARMER,GROSS_AMT,DEDUCTIONS,RECOVERIES,ARREARS,NET_AMT,ACT_DED,F_NAME,INCENTIVE,BANKN,BANKL,BASIC_MILK FROM milk_payment_ha WHERE COMP_CODE='"+compCode+"' and  SOCIETY='"+socity+"'  and DATE_FRM IN (SELECT DATE_FRM " 
             +"   FROM milk_payment_ha where "
              +" (DATE_FRM BETWEEN '"+fromDate+"' AND '"+toDate+"')    or  (DATE_TO BETWEEN '"+fromDate+"' AND '"+toDate+"')  ) ";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Summary size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	@Override
	public List<Object[]> getBulkHmpPaymentDetails(String compCode, String plant, String  socity,
			String billNumber) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
			sql = "SELECT  DMBTR_C,QTY_C,FAT_C,SNF_C,CLR_c,SS_DATE,SHIFT,"
					+ "(SELECT sum(amt) FROM milk_incentive where WERKS='"+plant+"' and SOCIETY='"+socity+"'  and BILL_NUM='"+billNumber+"' and CRDAT=milk_pay_li.SS_DATE and SHIFT=milk_pay_li.SHIFT group by WERKS,SOCIETY,CRDAT,SHIFT) as INCENTIVE_AMOUNT,DOCNO "
							+ "FROM bulk_payment_li milk_pay_li where  plant='"+plant+"' and SOCIETY='"+socity+"' and BILL_NUM='"+billNumber+"' ";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Payment Details size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getFarmHmpPaymentDetails(String compCode, String plant, String  socity,
			String billNumber) {

		String sql = "";

		System.out.println("Enter the XML Query...");

			// for Security Deposit Refund Status
		
		sql = "SELECT  DMBTR_C,QTY_C,FAT_C,SNF_C,CLR_c,SS_DATE,SHIFT,"
				+ "(SELECT sum(amt) FROM milk_incentive where WERKS='"+plant+"' and SOCIETY='"+socity+"' and  BILL_NUM='"+billNumber+"' and CRDAT=milk_pay_li.SS_DATE and SHIFT=milk_pay_li.SHIFT group by WERKS,SOCIETY,CRDAT,SHIFT) as INCENTIVE_AMOUNT,DOCNO "
						+ "FROM bulk_payment_li milk_pay_li where  plant='"+plant+"' and SOCIETY='"+socity+"' and BILL_NUM='"+billNumber+"' ";
		

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" Hmb Payment Details size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	

}
