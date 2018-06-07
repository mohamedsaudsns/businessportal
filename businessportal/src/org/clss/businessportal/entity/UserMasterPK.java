package org.clss.businessportal.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

/**
 * The primary key class for the user_master database table.
 * 
 */
@Embeddable
public class UserMasterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="USER_ID", unique=true, nullable=false)
	private String  userId;

	@Column(name="USER_TYPE_ID", unique=true, nullable=false)
	private int userTypeId;

	public UserMasterPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getUserTypeId() {
		return this.userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserMasterPK)) {
			return false;
		}
		UserMasterPK castOther = (UserMasterPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.userId.equals(castOther.userId)
			&& (this.userTypeId == castOther.userTypeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.userTypeId;
		
		return hash;
	}
}