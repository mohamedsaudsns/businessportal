package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class FiledForceStaffCustomModel implements Serializable  {
	
	private String plantCode;
	private String plantName;
	private String hmb;
	private String hmbName;
	private String designation;
	private String designationLevel;
	private String designationtype;
	private String vendor;
	private String vendorName;
	private String vendorMobileNo;
	public String getPlantCode() {
		return plantCode;
	}
	public void setPlantCode(String plantCode) {
		this.plantCode = plantCode;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getHmb() {
		return hmb;
	}
	public void setHmb(String hmb) {
		this.hmb = hmb;
	}
	public String getHmbName() {
		return hmbName;
	}
	public void setHmbName(String hmbName) {
		this.hmbName = hmbName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDesignationLevel() {
		return designationLevel;
	}
	public void setDesignationLevel(String designationLevel) {
		this.designationLevel = designationLevel;
	}
	public String getDesignationtype() {
		return designationtype;
	}
	public void setDesignationtype(String designationtype) {
		this.designationtype = designationtype;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorMobileNo() {
		return vendorMobileNo;
	}
	public void setVendorMobileNo(String vendorMobileNo) {
		this.vendorMobileNo = vendorMobileNo;
	}
	@Override
	public String toString() {
		return "FiledForceStaffCustomModel [plantCode=" + plantCode + ", plantName=" + plantName + ", hmb=" + hmb
				+ ", hmbName=" + hmbName + ", designation=" + designation + ", designationLevel=" + designationLevel
				+ ", designationtype=" + designationtype + ", vendor=" + vendor + ", vendorName=" + vendorName
				+ ", vendorMobileNo=" + vendorMobileNo + "]";
	}
	
	
	
}
