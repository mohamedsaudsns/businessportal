package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hmb_service_charges database table.
 * 
 */
@Embeddable
public class HmbServiceChargePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="BILL_NUM", unique=true, nullable=false, length=10)
	private String billNum;

	@Column(unique=true, nullable=false, length=4)
	private String werks;

	@Column(unique=true, nullable=false, length=2)
	private String parvw;

	@Column(unique=true, nullable=false, length=10)
	private String society;

	@Column(name="C_NAME", unique=true, nullable=false, length=35)
	private String cName;

	@Column(unique=true, nullable=false, length=30)
	private String gestyp;

	@Column(unique=true, nullable=false, length=10)
	private String lifnr;

	@Temporal(TemporalType.DATE)
	@Column(name="C_START_DATE", unique=true, nullable=false)
	private java.util.Date cStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name="C_END_DATE", unique=true, nullable=false)
	private java.util.Date cEndDate;

	public HmbServiceChargePK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getBillNum() {
		return this.billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
	public String getWerks() {
		return this.werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	public String getParvw() {
		return this.parvw;
	}
	public void setParvw(String parvw) {
		this.parvw = parvw;
	}
	public String getSociety() {
		return this.society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
	public String getCName() {
		return this.cName;
	}
	public void setCName(String cName) {
		this.cName = cName;
	}
	public String getGestyp() {
		return this.gestyp;
	}
	public void setGestyp(String gestyp) {
		this.gestyp = gestyp;
	}
	public String getLifnr() {
		return this.lifnr;
	}
	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}
	public java.util.Date getCStartDate() {
		return this.cStartDate;
	}
	public void setCStartDate(java.util.Date cStartDate) {
		this.cStartDate = cStartDate;
	}
	public java.util.Date getCEndDate() {
		return this.cEndDate;
	}
	public void setCEndDate(java.util.Date cEndDate) {
		this.cEndDate = cEndDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HmbServiceChargePK)) {
			return false;
		}
		HmbServiceChargePK castOther = (HmbServiceChargePK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.billNum.equals(castOther.billNum)
			&& this.werks.equals(castOther.werks)
			&& this.parvw.equals(castOther.parvw)
			&& this.society.equals(castOther.society)
			&& this.cName.equals(castOther.cName)
			&& this.gestyp.equals(castOther.gestyp)
			&& this.lifnr.equals(castOther.lifnr)
			&& this.cStartDate.equals(castOther.cStartDate)
			&& this.cEndDate.equals(castOther.cEndDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.billNum.hashCode();
		hash = hash * prime + this.werks.hashCode();
		hash = hash * prime + this.parvw.hashCode();
		hash = hash * prime + this.society.hashCode();
		hash = hash * prime + this.cName.hashCode();
		hash = hash * prime + this.gestyp.hashCode();
		hash = hash * prime + this.lifnr.hashCode();
		hash = hash * prime + this.cStartDate.hashCode();
		hash = hash * prime + this.cEndDate.hashCode();
		
		return hash;
	}
}