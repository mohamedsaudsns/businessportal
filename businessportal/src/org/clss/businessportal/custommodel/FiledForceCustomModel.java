package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class FiledForceCustomModel implements Serializable  {
	
	private String designation;
	private String empName;
	private String empMobileNo;
	private String empEmailId;
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpMobileNo() {
		return empMobileNo;
	}
	public void setEmpMobileNo(String empMobileNo) {
		this.empMobileNo = empMobileNo;
	}
	public String getEmpEmailId() {
		return empEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}
	@Override
	public String toString() {
		return "FiledForceCustomModel [designation=" + designation + ", empName=" + empName + ", empMobileNo="
				+ empMobileNo + ", empEmailId=" + empEmailId + "]";
	}
	
	
}
