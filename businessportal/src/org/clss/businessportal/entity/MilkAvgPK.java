package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the milk_avg database table.
 * 
 */
@Embeddable
public class MilkAvgPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String plant;

	private String society;

	@Temporal(TemporalType.DATE)
	private java.util.Date crdat;

	private String shift;

	public MilkAvgPK() {
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
	public java.util.Date getCrdat() {
		return this.crdat;
	}
	public void setCrdat(java.util.Date crdat) {
		this.crdat = crdat;
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
		if (!(other instanceof MilkAvgPK)) {
			return false;
		}
		MilkAvgPK castOther = (MilkAvgPK)other;
		return 
			this.plant.equals(castOther.plant)
			&& this.society.equals(castOther.society)
			&& this.crdat.equals(castOther.crdat)
			&& this.shift.equals(castOther.shift);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.plant.hashCode();
		hash = hash * prime + this.society.hashCode();
		hash = hash * prime + this.crdat.hashCode();
		hash = hash * prime + this.shift.hashCode();
		
		return hash;
	}
}