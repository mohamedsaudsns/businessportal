package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the logistic_deduction database table.
 * 
 */
@Embeddable
public class LogisticDeductionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(unique=true, nullable=false, length=10)
	private String zdocno;

	@Column(unique=true, nullable=false)
	private int zdocitem;

	public LogisticDeductionPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getZdocno() {
		return this.zdocno;
	}
	public void setZdocno(String zdocno) {
		this.zdocno = zdocno;
	}
	public int getZdocitem() {
		return this.zdocitem;
	}
	public void setZdocitem(int zdocitem) {
		this.zdocitem = zdocitem;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LogisticDeductionPK)) {
			return false;
		}
		LogisticDeductionPK castOther = (LogisticDeductionPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.zdocno.equals(castOther.zdocno)
			&& (this.zdocitem == castOther.zdocitem);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.zdocno.hashCode();
		hash = hash * prime + this.zdocitem;
		
		return hash;
	}
}