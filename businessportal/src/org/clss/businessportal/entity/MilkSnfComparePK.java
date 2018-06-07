package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the milk_snf_compare database table.
 * 
 */
@Embeddable
public class MilkSnfComparePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String plant;

	private String society;

	@Temporal(TemporalType.DATE)
	@Column(name="SS_DATE")
	private java.util.Date ssDate;

	private String shift;

	public MilkSnfComparePK() {
	}
	public String getPlant() {
		return this.plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getSociety() {
		return this.society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
	public java.util.Date getSsDate() {
		return this.ssDate;
	}
	public void setSsDate(java.util.Date ssDate) {
		this.ssDate = ssDate;
	}
	public String getShift() {
		return this.shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MilkSnfComparePK)) {
			return false;
		}
		MilkSnfComparePK castOther = (MilkSnfComparePK)other;
		return 
			this.plant.equals(castOther.plant)
			&& this.society.equals(castOther.society)
			&& this.ssDate.equals(castOther.ssDate)
			&& this.shift.equals(castOther.shift);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.plant.hashCode();
		hash = hash * prime + this.society.hashCode();
		hash = hash * prime + this.ssDate.hashCode();
		hash = hash * prime + this.shift.hashCode();
		
		return hash;
	}
}