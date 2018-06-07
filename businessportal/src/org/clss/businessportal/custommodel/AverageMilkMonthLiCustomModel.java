package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class AverageMilkMonthLiCustomModel implements Serializable  {
	
	private String ssDate;
	private String shift;
	private String milktype;
	private String qty;
	private String fat;
	private String snf;
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
	public String getMilktype() {
		return milktype;
	}
	public void setMilktype(String milktype) {
		this.milktype = milktype;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
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
	@Override
	public String toString() {
		return "AverageMilkMonthLiCustomModel [ssDate=" + ssDate + ", shift=" + shift + ", milktype=" + milktype
				+ ", qty=" + qty + ", fat=" + fat + ", snf=" + snf + "]";
	}

	
	

	
}
