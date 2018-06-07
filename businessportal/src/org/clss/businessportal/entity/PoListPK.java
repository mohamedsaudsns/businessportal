package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the po_list database table.
 * 
 */
@Embeddable
public class PoListPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="VENDOR_CODE", unique=true, nullable=false, length=10)
	private String vendorCode;

	@Column(name="PO_NUMBER", unique=true, nullable=false, length=15)
	private String poNumber;

	@Column(name="PO_ITEM_NO", unique=true, nullable=false, length=5)
	private String poItemNo;

	public PoListPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getVendorCode() {
		return this.vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getPoNumber() {
		return this.poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getPoItemNo() {
		return this.poItemNo;
	}
	public void setPoItemNo(String poItemNo) {
		this.poItemNo = poItemNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PoListPK)) {
			return false;
		}
		PoListPK castOther = (PoListPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.vendorCode.equals(castOther.vendorCode)
			&& this.poNumber.equals(castOther.poNumber)
			&& this.poItemNo.equals(castOther.poItemNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.vendorCode.hashCode();
		hash = hash * prime + this.poNumber.hashCode();
		hash = hash * prime + this.poItemNo.hashCode();
		
		return hash;
	}
}