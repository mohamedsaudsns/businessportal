package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class DepartmentAccessCustomModel implements Serializable  {
	
	private String departmentAccessId;
	private String departmentAccessValue;
	private boolean displayflag;
	public String getDepartmentAccessId() {
		return departmentAccessId;
	}
	public void setDepartmentAccessId(String departmentAccessId) {
		this.departmentAccessId = departmentAccessId;
	}
	public String getDepartmentAccessValue() {
		return departmentAccessValue;
	}
	public void setDepartmentAccessValue(String departmentAccessValue) {
		this.departmentAccessValue = departmentAccessValue;
	}
	public boolean isDisplayflag() {
		return displayflag;
	}
	public void setDisplayflag(boolean displayflag) {
		this.displayflag = displayflag;
	}
	
	
	
}
