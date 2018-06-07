package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the milk_payment_li database table.
 * 
 */
@Embeddable
public class MilkPaymentLiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(unique=true, nullable=false, length=8)
	private String plant;

	@Column(unique=true, nullable=false, length=20)
	private String society;

	@Temporal(TemporalType.DATE)
	@Column(name="SS_DATE", unique=true, nullable=false)
	private java.util.Date ssDate;

	@Column(unique=true, nullable=false, length=1)
	private String shift;

	@Column(name="MILK_TYPE", unique=true, nullable=false, length=1)
	private String milkType;

	@Column(unique=true, nullable=false, length=20)
	private String farmer;

	public MilkPaymentLiPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getPlant() {
		return this.plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getSociety() {
		return this.society;
	}
	public void setSociety(String society) {
		this.society = society;
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
	public String getMilkType() {
		return this.milkType;
	}
	public void setMilkType(String milkType) {
		this.milkType = milkType;
	}
	public String getFarmer() {
		return this.farmer;
	}
	public void setFarmer(String farmer) {
		this.farmer = farmer;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MilkPaymentLiPK)) {
			return false;
		}
		MilkPaymentLiPK castOther = (MilkPaymentLiPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.plant.equals(castOther.plant)
			&& this.society.equals(castOther.society)
			&& this.ssDate.equals(castOther.ssDate)
			&& this.shift.equals(castOther.shift)
			&& this.milkType.equals(castOther.milkType)
			&& this.farmer.equals(castOther.farmer);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.plant.hashCode();
		hash = hash * prime + this.society.hashCode();
		hash = hash * prime + this.ssDate.hashCode();
		hash = hash * prime + this.shift.hashCode();
		hash = hash * prime + this.milkType.hashCode();
		hash = hash * prime + this.farmer.hashCode();
		
		return hash;
	}
}