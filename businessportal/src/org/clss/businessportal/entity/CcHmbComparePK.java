package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cc_hmb_compare database table.
 * 
 */
@Embeddable
public class CcHmbComparePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String werks;

	private String society;

	@Temporal(TemporalType.DATE)
	private java.util.Date crdat;

	private String shift;

	public CcHmbComparePK() {
	}
	public String getWerks() {
		return this.werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
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
		if (!(other instanceof CcHmbComparePK)) {
			return false;
		}
		CcHmbComparePK castOther = (CcHmbComparePK)other;
		return 
			this.werks.equals(castOther.werks)
			&& this.society.equals(castOther.society)
			&& this.crdat.equals(castOther.crdat)
			&& this.shift.equals(castOther.shift);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.werks.hashCode();
		hash = hash * prime + this.society.hashCode();
		hash = hash * prime + this.crdat.hashCode();
		hash = hash * prime + this.shift.hashCode();
		
		return hash;
	}
}