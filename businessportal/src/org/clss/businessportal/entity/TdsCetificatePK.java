package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tds_cetificate database table.
 * 
 */
@Embeddable
public class TdsCetificatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="FICSAL_YEAR", unique=true, nullable=false, length=10)
	private String ficsalYear;

	@Column(unique=true, nullable=false, length=2)
	private String quater;

	@Column(name="PAN_NO", unique=true, nullable=false, length=10)
	private String panNo;

	public TdsCetificatePK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getFicsalYear() {
		return this.ficsalYear;
	}
	public void setFicsalYear(String ficsalYear) {
		this.ficsalYear = ficsalYear;
	}
	public String getQuater() {
		return this.quater;
	}
	public void setQuater(String quater) {
		this.quater = quater;
	}
	public String getPanNo() {
		return this.panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TdsCetificatePK)) {
			return false;
		}
		TdsCetificatePK castOther = (TdsCetificatePK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.ficsalYear.equals(castOther.ficsalYear)
			&& this.quater.equals(castOther.quater)
			&& this.panNo.equals(castOther.panNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.ficsalYear.hashCode();
		hash = hash * prime + this.quater.hashCode();
		hash = hash * prime + this.panNo.hashCode();
		
		return hash;
	}
}