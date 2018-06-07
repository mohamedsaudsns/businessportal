package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ar_report database table.
 * 
 */
@Embeddable
public class ArReportPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="CUSTOMER_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String customerCode;

	@Column(name="DOC_NO", unique=true, nullable=false, length=10)
	private String docNo;

	@Column(name="FI_YEAR", unique=true, nullable=false)
	private int fiYear;

	@Column(name="ITEM_NO", unique=true, nullable=false, length=4)
	private String itemNo;

	public ArReportPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getCustomerCode() {
		return this.customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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
		if (!(other instanceof ArReportPK)) {
			return false;
		}
		ArReportPK castOther = (ArReportPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.customerCode.equals(castOther.customerCode)
			&& this.docNo.equals(castOther.docNo)
			&& (this.fiYear == castOther.fiYear)
			&& this.itemNo.equals(castOther.itemNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.customerCode.hashCode();
		hash = hash * prime + this.docNo.hashCode();
		hash = hash * prime + this.fiYear;
		hash = hash * prime + this.itemNo.hashCode();
		
		return hash;
	}
}