package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hmb_service_deduction database table.
 * 
 */
@Embeddable
public class HmbServiceDeductionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE")
	private String compCode;

	private String zdocno;

	private int zdocitem;

	public HmbServiceDeductionPK() {
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
		if (!(other instanceof HmbServiceDeductionPK)) {
			return false;
		}
		HmbServiceDeductionPK castOther = (HmbServiceDeductionPK)other;
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