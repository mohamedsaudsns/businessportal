package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_menu_assignment database table.
 * 
 */
@Embeddable
public class UserMenuAssignmentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="USER_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private int userId;

	@Column(name="USER_TYPE_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private int userTypeId;

	@Column(name="ROLE_ID", unique=true, nullable=false)
	private int roleId;

	public UserMenuAssignmentPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserTypeId() {
		return this.userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public int getRoleId() {
		return this.roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserMenuAssignmentPK)) {
			return false;
		}
		UserMenuAssignmentPK castOther = (UserMenuAssignmentPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& (this.userId == castOther.userId)
			&& (this.userTypeId == castOther.userTypeId)
			&& (this.roleId == castOther.roleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.userId;
		hash = hash * prime + this.userTypeId;
		hash = hash * prime + this.roleId;
		
		return hash;
	}
}