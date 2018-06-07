package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/



import java.io.Serializable;
import java.util.List;

import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.clss.businessportal.entity.CcHmbCompare;
import org.clss.businessportal.entity.MilkPaymentHa;
import org.clss.businessportal.entity.Role;
import org.clss.businessportal.entity.SocietyInchargeMapping;

public interface FieldStaffDao extends GenericDao<CcHmbCompare, Serializable>{
	
	
	
	public List<Object[]> getCcHmbCompareReport(String vendorCode,String fromDate,String todate);
	
	public List<Object[]> getComparisionStatementReport(String vendorCode,String fromDate,String todate);
	public List<Object[]> getTsRecoveryReport(String vendorCode,String fromDate,String todate);
	
	public List<Object[]> getFfsServiceCharge(String compCode,  String  inchargeCode,String fromDate,String todate);
	public List<Object[]> getFfsServiceChargeDeduction(String inchargeCode,  String  society,String fromDate,String todate);
	public List<Object[]> getFfsServiceArrear(String  society,String fromDate,String todate);

	
	
}
