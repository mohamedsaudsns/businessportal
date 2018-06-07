package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the filed_force database table.
 * 
 */
@Embeddable
public class FiledForcePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="VENDOR_CUSTOMER_CODE", unique=true, nullable=false, length=10)
	private String vendorCustomerCode;

	@Column(name="POSITION_CODE", unique=true, nullable=false, length=45)
	private String positionCode;

	public FiledForcePK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getVendorCustomerCode() {
		return this.vendorCustomerCode;
	}
	public void setVendorCustomerCode(String vendorCustomerCode) {
		this.vendorCustomerCode = vendorCustomerCode;
	}
	public String getPositionCode() {
		return this.positionCode;
	}
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FiledForcePK)) {
			return false;
		}
		FiledForcePK castOther = (FiledForcePK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.vendorCustomerCode.equals(castOther.vendorCustomerCode)
			&& this.positionCode.equals(castOther.positionCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.vendorCustomerCode.hashCode();
		hash = hash * prime + this.positionCode.hashCode();
		
		return hash;
	}
}