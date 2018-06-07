package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the milk_liability database table.
 * 
 */
@Embeddable
public class MilkLiabilityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String werks;

	private String society;

	@Temporal(TemporalType.DATE)
	@Column(name="FROM_DATE")
	private java.util.Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name="TO_DATE")
	private java.util.Date toDate;

	public MilkLiabilityPK() {
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
	public java.util.Date getFromDate() {
		return this.fromDate;
	}
	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}
	public java.util.Date getToDate() {
		return this.toDate;
	}
	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MilkLiabilityPK)) {
			return false;
		}
		MilkLiabilityPK castOther = (MilkLiabilityPK)other;
		return 
			this.werks.equals(castOther.werks)
			&& this.society.equals(castOther.society)
			&& this.fromDate.equals(castOther.fromDate)
			&& this.toDate.equals(castOther.toDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.werks.hashCode();
		hash = hash * prime + this.society.hashCode();
		hash = hash * prime + this.fromDate.hashCode();
		hash = hash * prime + this.toDate.hashCode();
		
		return hash;
	}
}