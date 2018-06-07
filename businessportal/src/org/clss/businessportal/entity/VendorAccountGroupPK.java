package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vendor_account_group database table.
 * 
 */
@Embeddable
public class VendorAccountGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="VENDOR_ACC_GRP_CODE", unique=true, nullable=false, length=4)
	private String vendorAccGrpCode;

	@Column(name="COMP_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String compCode;

	public VendorAccountGroupPK() {
	}
	public String getVendorAccGrpCode() {
		return this.vendorAccGrpCode;
	}
	public void setVendorAccGrpCode(String vendorAccGrpCode) {
		this.vendorAccGrpCode = vendorAccGrpCode;
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VendorAccountGroupPK)) {
			return false;
		}
		VendorAccountGroupPK castOther = (VendorAccountGroupPK)other;
		return 
			this.vendorAccGrpCode.equals(castOther.vendorAccGrpCode)
			&& this.compCode.equals(castOther.compCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.vendorAccGrpCode.hashCode();
		hash = hash * prime + this.compCode.hashCode();
		
		return hash;
	}
}