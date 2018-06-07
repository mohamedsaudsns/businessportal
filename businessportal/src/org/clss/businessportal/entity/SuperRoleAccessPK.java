package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the super_role_access database table.
 * 
 */
@Embeddable
public class SuperRoleAccessPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE")
	private String compCode;

	@Column(name="ROLE_ID")
	private int roleId;

	@Column(name="ACCESS_ROLE_ID")
	private int accessRoleId;

	public SuperRoleAccessPK() {
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
	public int getAccessRoleId() {
		return this.accessRoleId;
	}
	public void setAccessRoleId(int accessRoleId) {
		this.accessRoleId = accessRoleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SuperRoleAccessPK)) {
			return false;
		}
		SuperRoleAccessPK castOther = (SuperRoleAccessPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& (this.roleId == castOther.roleId)
			&& (this.accessRoleId == castOther.accessRoleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.roleId;
		hash = hash * prime + this.accessRoleId;
		
		return hash;
	}
}