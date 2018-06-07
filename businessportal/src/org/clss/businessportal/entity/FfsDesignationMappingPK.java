package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ffs_designation_mapping database table.
 * 
 */
@Embeddable
public class FfsDesignationMappingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ROLE_ID")
	private int roleId;

	@Column(name="DESG_TYPE")
	private String desgType;

	public FfsDesignationMappingPK() {
	}
	public int getRoleId() {
		return this.roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getDesgType() {
		return this.desgType;
	}
	public void setDesgType(String desgType) {
		this.desgType = desgType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FfsDesignationMappingPK)) {
			return false;
		}
		FfsDesignationMappingPK castOther = (FfsDesignationMappingPK)other;
		return 
			(this.roleId == castOther.roleId)
			&& this.desgType.equals(castOther.desgType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.roleId;
		hash = hash * prime + this.desgType.hashCode();
		
		return hash;
	}
}