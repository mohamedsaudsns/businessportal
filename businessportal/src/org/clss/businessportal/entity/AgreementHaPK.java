package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the agreement_ha database table.
 * 
 */
@Embeddable
public class AgreementHaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="VENDOR_CODE", unique=true, nullable=false, length=10)
	private String vendorCode;

	@Column(name="FISCAL_YEAR", unique=true, nullable=false, length=10)
	private String fiscalYear;

	@Column(name="AGREEMENT_NO", unique=true, nullable=false, length=50)
	private String agreementNo;

	public AgreementHaPK() {
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
	public String getFiscalYear() {
		return this.fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public String getAgreementNo() {
		return this.agreementNo;
	}
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AgreementHaPK)) {
			return false;
		}
		AgreementHaPK castOther = (AgreementHaPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.vendorCode.equals(castOther.vendorCode)
			&& this.fiscalYear.equals(castOther.fiscalYear)
			&& this.agreementNo.equals(castOther.agreementNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.vendorCode.hashCode();
		hash = hash * prime + this.fiscalYear.hashCode();
		hash = hash * prime + this.agreementNo.hashCode();
		
		return hash;
	}
}