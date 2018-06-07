package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the role_access database table.
 * 
 */
@Embeddable
public class RoleAccessPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="ROLE_ID", unique=true, nullable=false)
	private int roleId;

	@Column(name="MENU_ORDER_ID", unique=true, nullable=false)
	private int menuOrderId;

	@Column(name="MENU_ID", unique=true, nullable=false)
	private int menuId;

	public RoleAccessPK() {
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
	public int getMenuOrderId() {
		return this.menuOrderId;
	}
	public void setMenuOrderId(int menuOrderId) {
		this.menuOrderId = menuOrderId;
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
		if (!(other instanceof RoleAccessPK)) {
			return false;
		}
		RoleAccessPK castOther = (RoleAccessPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& (this.roleId == castOther.roleId)
			&& (this.menuOrderId == castOther.menuOrderId)
			&& (this.menuId == castOther.menuId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.roleId;
		hash = hash * prime + this.menuOrderId;
		hash = hash * prime + this.menuId;
		
		return hash;
	}
}