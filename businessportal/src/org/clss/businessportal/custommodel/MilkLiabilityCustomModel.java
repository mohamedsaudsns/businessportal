package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class MilkLiabilityCustomModel implements Serializable  {
	
	private String inputDate;
	private String fromDate;
	private String toDate;
	private String lpd;
	private String nop;
	private String fatPer;
	private String snfPer;
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getLpd() {
		return lpd;
	}
	public void setLpd(String lpd) {
		this.lpd = lpd;
	}
	public String getNop() {
		return nop;
	}
	public void setNop(String nop) {
		this.nop = nop;
	}
	public String getFatPer() {
		return fatPer;
	}
	public void setFatPer(String fatPer) {
		this.fatPer = fatPer;
	}
	public String getSnfPer() {
		return snfPer;
	}
	public void setSnfPer(String snfPer) {
		this.snfPer = snfPer;
	}
	@Override
	public String toString() {
		return "MilkLiabilityCustomModel [inputDate=" + inputDate + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", lpd=" + lpd + ", nop=" + nop + ", fatPer=" + fatPer + ", snfPer=" + snfPer + "]";
	}
	
	
	
}
