package org.clss.businessportal.custommodel;

import java.io.Serializable;
import java.util.Comparator;

/**
*
* @author Mohamed Saud SNS
*/


public class MilkDeductionDetailCustomModel implements Serializable  {
	
	private String farmerCode;
	private String farmerName;
	private String pCode;
	private String entryDate;
	private String deductionName;
	private String deductionamount;
	private String deductiontotalAmount;
	public String getFarmerCode() {
		return farmerCode;
	}
	public void setFarmerCode(String farmerCode) {
		this.farmerCode = farmerCode;
	}
	public String getFarmerName() {
		return farmerName;
	}
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getDeductionName() {
		return deductionName;
	}
	public void setDeductionName(String deductionName) {
		this.deductionName = deductionName;
	}
	public String getDeductionamount() {
		return deductionamount;
	}
	public void setDeductionamount(String deductionamount) {
		this.deductionamount = deductionamount;
	}
	public String getDeductiontotalAmount() {
		return deductiontotalAmount;
	}
	public void setDeductiontotalAmount(String deductiontotalAmount) {
		this.deductiontotalAmount = deductiontotalAmount;
	}
	@Override
	public String toString() {
		return "MilkDeductionDetailCustomModel [farmerCode=" + farmerCode + ", farmerName=" + farmerName + ", pCode="
				+ pCode + ", entryDate=" + entryDate + ", deductionName=" + deductionName + ", deductionamount="
				+ deductionamount + ", deductiontotalAmount=" + deductiontotalAmount + "]";
	}
	
	
	   public static Comparator<MilkDeductionDetailCustomModel> EntrydateComparator = new Comparator<MilkDeductionDetailCustomModel>() {

			public int compare(MilkDeductionDetailCustomModel s1, MilkDeductionDetailCustomModel s2) {
			   String entryDate1 = s1.getEntryDate();
			   String entryDate2 = s2.getEntryDate();

			   //ascending order
			   return entryDate1.compareTo(entryDate2);

			   //descending order
			   //return entryDate2.compareTo(entryDate1);
		    }};
	
	
	
}
