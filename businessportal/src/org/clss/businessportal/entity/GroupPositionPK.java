package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the group_position database table.
 * 
 */
@Embeddable
public class GroupPositionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="GROUP_ID", unique=true, nullable=false, length=45)
	private String groupId;

	@Column(name="POSITION_ID", unique=true, nullable=false, length=45)
	private String positionId;

	public GroupPositionPK() {
	}
	public String getGroupId() {
		return this.groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getPositionId() {
		return this.positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GroupPositionPK)) {
			return false;
		}
		GroupPositionPK castOther = (GroupPositionPK)other;
		return 
			this.groupId.equals(castOther.groupId)
			&& this.positionId.equals(castOther.positionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.groupId.hashCode();
		hash = hash * prime + this.positionId.hashCode();
		
		return hash;
	}
}