package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the milk_recovery database table.
 * 
 */
@Embeddable
public class MilkRecoveryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="POST_DAT", unique=true, nullable=false)
	private java.util.Date postDat;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="POST_TIME", unique=true, nullable=false)
	private java.util.Date postTime;

	@Column(unique=true, nullable=false, length=8)
	private String plant;

	@Column(unique=true, nullable=false, length=2)
	private String recovery;

	@Temporal(TemporalType.DATE)
	@Column(name="RECVRY_DATE", unique=true, nullable=false)
	private java.util.Date recvryDate;

	@Column(name="RECVRY_SHIFT", unique=true, nullable=false, length=1)
	private String recvryShift;

	@Column(name="MILK_TYPE", unique=true, nullable=false, length=1)
	private String milkType;

	@Column(unique=true, nullable=false, length=10)
	private String society;

	public MilkRecoveryPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public java.util.Date getPostDat() {
		return this.postDat;
	}
	public void setPostDat(java.util.Date postDat) {
		this.postDat = postDat;
	}
	public java.util.Date getPostTime() {
		return this.postTime;
	}
	public void setPostTime(java.util.Date postTime) {
		this.postTime = postTime;
	}
	public String getPlant() {
		return this.plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getRecovery() {
		return this.recovery;
	}
	public void setRecovery(String recovery) {
		this.recovery = recovery;
	}
	public java.util.Date getRecvryDate() {
		return this.recvryDate;
	}
	public void setRecvryDate(java.util.Date recvryDate) {
		this.recvryDate = recvryDate;
	}
	public String getRecvryShift() {
		return this.recvryShift;
	}
	public void setRecvryShift(String recvryShift) {
		this.recvryShift = recvryShift;
	}
	public String getMilkType() {
		return this.milkType;
	}
	public void setMilkType(String milkType) {
		this.milkType = milkType;
	}
	public String getSociety() {
		return this.society;
	}
	public void setSociety(String society) {
		this.society = society;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MilkRecoveryPK)) {
			return false;
		}
		MilkRecoveryPK castOther = (MilkRecoveryPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.postDat.equals(castOther.postDat)
			&& this.postTime.equals(castOther.postTime)
			&& this.plant.equals(castOther.plant)
			&& this.recovery.equals(castOther.recovery)
			&& this.recvryDate.equals(castOther.recvryDate)
			&& this.recvryShift.equals(castOther.recvryShift)
			&& this.milkType.equals(castOther.milkType)
			&& this.society.equals(castOther.society);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.postDat.hashCode();
		hash = hash * prime + this.postTime.hashCode();
		hash = hash * prime + this.plant.hashCode();
		hash = hash * prime + this.recovery.hashCode();
		hash = hash * prime + this.recvryDate.hashCode();
		hash = hash * prime + this.recvryShift.hashCode();
		hash = hash * prime + this.milkType.hashCode();
		hash = hash * prime + this.society.hashCode();
		
		return hash;
	}
}