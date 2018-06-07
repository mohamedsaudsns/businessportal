package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the field_force_staff database table.
 * 
 */
@Embeddable
public class FieldForceStaffPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PLANT_CODE")
	private String plantCode;

	private String hmb;

	private String position;

	public FieldForceStaffPK() {
	}
	public String getPlantCode() {
		return this.plantCode;
	}
	public void setPlantCode(String plantCode) {
		this.plantCode = plantCode;
	}
	public String getHmb() {
		return this.hmb;
	}
	public void setHmb(String hmb) {
		this.hmb = hmb;
	}
	public String getPosition() {
		return this.position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FieldForceStaffPK)) {
			return false;
		}
		FieldForceStaffPK castOther = (FieldForceStaffPK)other;
		return 
			this.plantCode.equals(castOther.plantCode)
			&& this.hmb.equals(castOther.hmb)
			&& this.position.equals(castOther.position);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.plantCode.hashCode();
		hash = hash * prime + this.hmb.hashCode();
		hash = hash * prime + this.position.hashCode();
		
		return hash;
	}
}