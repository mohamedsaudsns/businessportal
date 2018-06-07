package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the department_access database table.
 * 
 */
@Embeddable
public class DepartmentAccessPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="ROLE_ID", unique=true, nullable=false)
	private int roleId;

	@Column(name="DEPARTMNET_ID", unique=true, nullable=false)
	private int departmnetId;

	@Column(name="MENU_ID", unique=true, nullable=false)
	private int menuId;

	public DepartmentAccessPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public int getRoleId() {
		return this.roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getDepartmnetId() {
		return this.departmnetId;
	}
	public void setDepartmnetId(int departmnetId) {
		this.departmnetId = departmnetId;
	}
	public int getMenuId() {
		return this.menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DepartmentAccessPK)) {
			return false;
		}
		DepartmentAccessPK castOther = (DepartmentAccessPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& (this.roleId == castOther.roleId)
			&& (this.departmnetId == castOther.departmnetId)
			&& (this.menuId == castOther.menuId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.roleId;
		hash = hash * prime + this.departmnetId;
		hash = hash * prime + this.menuId;
		
		return hash;
	}
}