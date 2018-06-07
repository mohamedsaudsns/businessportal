package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vendor_master database table.
 * 
 */
@Embeddable
public class VendorMasterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="VENDOR_CODE", unique=true, nullable=false, length=10)
	private String vendorCode;

	public VendorMasterPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VendorMasterPK)) {
			return false;
		}
		VendorMasterPK castOther = (VendorMasterPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.vendorCode.equals(castOther.vendorCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.vendorCode.hashCode();
		
		return hash;
	}
}