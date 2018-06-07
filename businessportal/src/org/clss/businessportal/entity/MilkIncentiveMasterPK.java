package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the milk_incentive_master database table.
 * 
 */
@Embeddable
public class MilkIncentiveMasterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE")
	private String compCode;

	@Column(name="INC_TYPE")
	private String incType;

	@Temporal(TemporalType.DATE)
	@Column(name="INC_VALID_FROM")
	private java.util.Date incValidFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="INC_VALID_TO")
	private java.util.Date incValidTo;

	public MilkIncentiveMasterPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getIncType() {
		return this.incType;
	}
	public void setIncType(String incType) {
		this.incType = incType;
	}
	public java.util.Date getIncValidFrom() {
		return this.incValidFrom;
	}
	public void setIncValidFrom(java.util.Date incValidFrom) {
		this.incValidFrom = incValidFrom;
	}
	public java.util.Date getIncValidTo() {
		return this.incValidTo;
	}
	public void setIncValidTo(java.util.Date incValidTo) {
		this.incValidTo = incValidTo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MilkIncentiveMasterPK)) {
			return false;
		}
		MilkIncentiveMasterPK castOther = (MilkIncentiveMasterPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.incType.equals(castOther.incType)
			&& this.incValidFrom.equals(castOther.incValidFrom)
			&& this.incValidTo.equals(castOther.incValidTo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.incType.hashCode();
		hash = hash * prime + this.incValidFrom.hashCode();
		hash = hash * prime + this.incValidTo.hashCode();
		
		return hash;
	}
}