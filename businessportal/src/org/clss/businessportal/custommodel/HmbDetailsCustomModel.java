package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class HmbDetailsCustomModel implements Serializable  {
	
	private String compCode;
	private String sNo;
	private String particulars;
	private String amount;
	private String totalAmount;
	private String ssDate;
	private String shift;
	private String qtyKg;
	private String fat;
	private String snf;
	private String incentiveAmount;
	private String milkType;
	
	private String rateLtrAmount;
	private String addRateLtrAmount;
	private String holeTotal;
	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getSsDate() {
		return ssDate;
	}
	public void setSsDate(String ssDate) {
		this.ssDate = ssDate;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getQtyKg() {
		return qtyKg;
	}
	public void setQtyKg(String qtyKg) {
		this.qtyKg = qtyKg;
	}
	public String getFat() {
		return fat;
	}
	public void setFat(String fat) {
		this.fat = fat;
	}
	public String getSnf() {
		return snf;
	}
	public void setSnf(String snf) {
		this.snf = snf;
	}
	public String getIncentiveAmount() {
		return incentiveAmount;
	}
	public void setIncentiveAmount(String incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}
	public String getMilkType() {
		return milkType;
	}
	public void setMilkType(String milkType) {
		this.milkType = milkType;
	}
	public String getRateLtrAmount() {
		return rateLtrAmount;
	}
	public void setRateLtrAmount(String rateLtrAmount) {
		this.rateLtrAmount = rateLtrAmount;
	}
	public String getAddRateLtrAmount() {
		return addRateLtrAmount;
	}
	public void setAddRateLtrAmount(String addRateLtrAmount) {
		this.addRateLtrAmount = addRateLtrAmount;
	}
	public String getHoleTotal() {
		return holeTotal;
	}
	public void setHoleTotal(String holeTotal) {
		this.holeTotal = holeTotal;
	}
	@Override
	public String toString() {
		return "HmbDetailsCustomModel [compCode=" + compCode + ", sNo=" + sNo + ", particulars=" + particulars
				+ ", amount=" + amount + ", totalAmount=" + totalAmount + ", ssDate=" + ssDate + ", shift=" + shift
				+ ", qtyKg=" + qtyKg + ", fat=" + fat + ", snf=" + snf + ", incentiveAmount=" + incentiveAmount
				+ ", milkType=" + milkType + ", rateLtrAmount=" + rateLtrAmount + ", addRateLtrAmount="
				+ addRateLtrAmount + ", holeTotal=" + holeTotal + "]";
	}
	
	
	
}
