package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hmb_service_arrear database table.
 * 
 */
@Embeddable
public class HmbServiceArrearPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE")
	private String compCode;

	@Column(name="TRANS_NO")
	private String transNo;

	public HmbServiceArrearPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getTransNo() {
		return this.transNo;
	}
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HmbServiceArrearPK)) {
			return false;
		}
		HmbServiceArrearPK castOther = (HmbServiceArrearPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.transNo.equals(castOther.transNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.transNo.hashCode();
		
		return hash;
	}
}