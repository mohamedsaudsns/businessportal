package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the scheme_li database table.
 * 
 */
@Embeddable
public class SchemeLiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ITEM_NO", unique=true, nullable=false)
	private int itemNo;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="DEPARTMENT_ID", unique=true, nullable=false)
	private int departmentId;

	@Column(name="DEPARTMENT_VISIBLE_ID", unique=true, nullable=false)
	private int departmentVisibleId;

	public SchemeLiPK() {
	}
	public int getItemNo() {
		return this.itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public int getDepartmentId() {
		return this.departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getDepartmentVisibleId() {
		return this.departmentVisibleId;
	}
	public void setDepartmentVisibleId(int departmentVisibleId) {
		this.departmentVisibleId = departmentVisibleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SchemeLiPK)) {
			return false;
		}
		SchemeLiPK castOther = (SchemeLiPK)other;
		return 
			(this.itemNo == castOther.itemNo)
			&& this.compCode.equals(castOther.compCode)
			&& (this.departmentId == castOther.departmentId)
			&& (this.departmentVisibleId == castOther.departmentVisibleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemNo;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.departmentId;
		hash = hash * prime + this.departmentVisibleId;
		
		return hash;
	}
}