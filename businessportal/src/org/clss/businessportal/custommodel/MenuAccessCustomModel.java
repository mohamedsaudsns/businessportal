package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class MenuAccessCustomModel implements Serializable  {
	
	private String menuAccessId;
	private String menuAccessName;
	private String menuAccessValue;
	private String roleId;
	public String getMenuAccessId() {
		return menuAccessId;
	}
	public void setMenuAccessId(String menuAccessId) {
		this.menuAccessId = menuAccessId;
	}
	public String getMenuAccessName() {
		return menuAccessName;
	}
	public void setMenuAccessName(String menuAccessName) {
		this.menuAccessName = menuAccessName;
	}
	public String getMenuAccessValue() {
		return menuAccessValue;
	}
	public void setMenuAccessValue(String menuAccessValue) {
		this.menuAccessValue = menuAccessValue;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
