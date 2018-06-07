package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ap_report database table.
 * 
 */
@Embeddable
public class ApReportPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE")
	private String compCode;

	@Column(name="VENDOR_CODE")
	private String vendorCode;

	@Column(name="DOC_NO")
	private String docNo;

	@Column(name="FI_YEAR")
	private int fiYear;

	@Column(name="ITEM_NO")
	private String itemNo;

	public ApReportPK() {
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
	public String getDocNo() {
		return this.docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public int getFiYear() {
		return this.fiYear;
	}
	public void setFiYear(int fiYear) {
		this.fiYear = fiYear;
	}
	public String getItemNo() {
		return this.itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ApReportPK)) {
			return false;
		}
		ApReportPK castOther = (ApReportPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.vendorCode.equals(castOther.vendorCode)
			&& this.docNo.equals(castOther.docNo)
			&& (this.fiYear == castOther.fiYear)
			&& this.itemNo.equals(castOther.itemNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.vendorCode.hashCode();
		hash = hash * prime + this.docNo.hashCode();
		hash = hash * prime + this.fiYear;
		hash = hash * prime + this.itemNo.hashCode();
		
		return hash;
	}
}