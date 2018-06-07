package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class AverageMilkMonthCustomModel implements Serializable  {
	
	private String compCode;
	private String avgmonth;
	private String avgMilk;
	private String avgFat;
	private String avgSnf;
	private String socity;
	private String selectedyear;
	private String selectedMonth;
	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getAvgmonth() {
		return avgmonth;
	}
	public void setAvgmonth(String avgmonth) {
		this.avgmonth = avgmonth;
	}
	public String getAvgMilk() {
		return avgMilk;
	}
	public void setAvgMilk(String avgMilk) {
		this.avgMilk = avgMilk;
	}
	public String getAvgFat() {
		return avgFat;
	}
	public void setAvgFat(String avgFat) {
		this.avgFat = avgFat;
	}
	public String getAvgSnf() {
		return avgSnf;
	}
	public void setAvgSnf(String avgSnf) {
		this.avgSnf = avgSnf;
	}
	public String getSocity() {
		return socity;
	}
	public void setSocity(String socity) {
		this.socity = socity;
	}
	public String getSelectedyear() {
		return selectedyear;
	}
	public void setSelectedyear(String selectedyear) {
		this.selectedyear = selectedyear;
	}
	public String getSelectedMonth() {
		return selectedMonth;
	}
	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}
	@Override
	public String toString() {
		return "AverageMilkMonthCustomModel [compCode=" + compCode + ", avgmonth=" + avgmonth + ", avgMilk=" + avgMilk
				+ ", avgFat=" + avgFat + ", avgSnf=" + avgSnf + ", socity=" + socity + ", selectedyear=" + selectedyear
				+ ", selectedMonth=" + selectedMonth + "]";
	}
	
	
	
	

	
}
