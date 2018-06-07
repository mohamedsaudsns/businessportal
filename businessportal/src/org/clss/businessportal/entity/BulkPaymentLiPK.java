package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bulk_payment_li database table.
 * 
 */
@Embeddable
public class BulkPaymentLiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BILL_NUM")
	private String billNum;

	private String plant;

	@Temporal(TemporalType.DATE)
	@Column(name="SS_DATE")
	private java.util.Date ssDate;

	private String shift;

	public BulkPaymentLiPK() {
	}
	public String getBillNum() {
		return this.billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
	public String getPlant() {
		return this.plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public java.util.Date getSsDate() {
		return this.ssDate;
	}
	public void setSsDate(java.util.Date ssDate) {
		this.ssDate = ssDate;
	}
	public String getShift() {
		return this.shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BulkPaymentLiPK)) {
			return false;
		}
		BulkPaymentLiPK castOther = (BulkPaymentLiPK)other;
		return 
			this.billNum.equals(castOther.billNum)
			&& this.plant.equals(castOther.plant)
			&& this.ssDate.equals(castOther.ssDate)
			&& this.shift.equals(castOther.shift);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.billNum.hashCode();
		hash = hash * prime + this.plant.hashCode();
		hash = hash * prime + this.ssDate.hashCode();
		hash = hash * prime + this.shift.hashCode();
		
		return hash;
	}
}