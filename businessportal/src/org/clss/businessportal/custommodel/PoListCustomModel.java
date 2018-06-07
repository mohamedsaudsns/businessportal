package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class PoListCustomModel implements Serializable  {
	
	private String compCode;
	private String poNumber;
	private String poItemNo;
	private String docCat;
	private String docDate;
	private String releaseStaus;
	private String shortText;
	private String materialcode;
	private String grossAmount;
	private String netAmount;
	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getPoItemNo() {
		return poItemNo;
	}
	public void setPoItemNo(String poItemNo) {
		this.poItemNo = poItemNo;
	}
	public String getDocCat() {
		return docCat;
	}
	public void setDocCat(String docCat) {
		this.docCat = docCat;
	}
	public String getDocDate() {
		return docDate;
	}
	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}
	public String getReleaseStaus() {
		return releaseStaus;
	}
	public void setReleaseStaus(String releaseStaus) {
		this.releaseStaus = releaseStaus;
	}
	public String getShortText() {
		return shortText;
	}
	public void setShortText(String shortText) {
		this.shortText = shortText;
	}
	public String getMaterialcode() {
		return materialcode;
	}
	public void setMaterialcode(String materialcode) {
		this.materialcode = materialcode;
	}
	public String getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(String grossAmount) {
		this.grossAmount = grossAmount;
	}
	public String getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}
	
	
	


}
			  
