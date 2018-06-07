package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vendor_bank_details database table.
 * 
 */
@Embeddable
public class VendorBankDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ACCOUNT_NO", unique=true, nullable=false, length=45)
	private String accountNo;

	@Column(name="VENDOR_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String vendorCode;

	@Column(name="COMP_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String compCode;

	public VendorBankDetailPK() {
	}
	public String getAccountNo() {
		return this.accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getVendorCode() {
		return this.vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
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
		if (!(other instanceof VendorBankDetailPK)) {
			return false;
		}
		VendorBankDetailPK castOther = (VendorBankDetailPK)other;
		return 
			this.accountNo.equals(castOther.accountNo)
			&& this.vendorCode.equals(castOther.vendorCode)
			&& this.compCode.equals(castOther.compCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.accountNo.hashCode();
		hash = hash * prime + this.vendorCode.hashCode();
		hash = hash * prime + this.compCode.hashCode();
		
		return hash;
	}
}