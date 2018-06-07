package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the milk_payment_ha database table.
 * 
 */
@Embeddable
public class MilkPaymentHaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BILL_NUM")
	private String billNum;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FRM")
	private java.util.Date dateFrm;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_TO")
	private java.util.Date dateTo;

	private String plant;

	@Column(name="COMP_CODE")
	private String compCode;

	public MilkPaymentHaPK() {
	}
	public String getBillNum() {
		return this.billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
	public java.util.Date getDateFrm() {
		return this.dateFrm;
	}
	public void setDateFrm(java.util.Date dateFrm) {
		this.dateFrm = dateFrm;
	}
	public java.util.Date getDateTo() {
		return this.dateTo;
	}
	public void setDateTo(java.util.Date dateTo) {
		this.dateTo = dateTo;
	}
	public String getPlant() {
		return this.plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
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
		if (!(other instanceof MilkPaymentHaPK)) {
			return false;
		}
		MilkPaymentHaPK castOther = (MilkPaymentHaPK)other;
		return 
			this.billNum.equals(castOther.billNum)
			&& this.dateFrm.equals(castOther.dateFrm)
			&& this.dateTo.equals(castOther.dateTo)
			&& this.plant.equals(castOther.plant)
			&& this.compCode.equals(castOther.compCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.billNum.hashCode();
		hash = hash * prime + this.dateFrm.hashCode();
		hash = hash * prime + this.dateTo.hashCode();
		hash = hash * prime + this.plant.hashCode();
		hash = hash * prime + this.compCode.hashCode();
		
		return hash;
	}
}