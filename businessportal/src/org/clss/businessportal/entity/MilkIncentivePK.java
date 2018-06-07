package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the milk_incentive database table.
 * 
 */
@Embeddable
public class MilkIncentivePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE")
	private String compCode;

	@Temporal(TemporalType.DATE)
	private java.util.Date postingdate;

	private String werks;

	private String society;

	private String partner;

	@Column(name="J_1KFTBUS")
	private String j1kftbus;

	private String ebeln;

	private String ebelp;

	@Temporal(TemporalType.DATE)
	private java.util.Date crdat;

	private String shift;

	@Column(name="INC_TYPE")
	private String incType;

	@Column(name="MILK_TYPE")
	private String milkType;

	public MilkIncentivePK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public java.util.Date getPostingdate() {
		return this.postingdate;
	}
	public void setPostingdate(java.util.Date postingdate) {
		this.postingdate = postingdate;
	}
	public String getWerks() {
		return this.werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	public String getSociety() {
		return this.society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
	public String getPartner() {
		return this.partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getJ1kftbus() {
		return this.j1kftbus;
	}
	public void setJ1kftbus(String j1kftbus) {
		this.j1kftbus = j1kftbus;
	}
	public String getEbeln() {
		return this.ebeln;
	}
	public void setEbeln(String ebeln) {
		this.ebeln = ebeln;
	}
	public String getEbelp() {
		return this.ebelp;
	}
	public void setEbelp(String ebelp) {
		this.ebelp = ebelp;
	}
	public java.util.Date getCrdat() {
		return this.crdat;
	}
	public void setCrdat(java.util.Date crdat) {
		this.crdat = crdat;
	}
	public String getShift() {
		return this.shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getIncType() {
		return this.incType;
	}
	public void setIncType(String incType) {
		this.incType = incType;
	}
	public String getMilkType() {
		return this.milkType;
	}
	public void setMilkType(String milkType) {
		this.milkType = milkType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MilkIncentivePK)) {
			return false;
		}
		MilkIncentivePK castOther = (MilkIncentivePK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.postingdate.equals(castOther.postingdate)
			&& this.werks.equals(castOther.werks)
			&& this.society.equals(castOther.society)
			&& this.partner.equals(castOther.partner)
			&& this.j1kftbus.equals(castOther.j1kftbus)
			&& this.ebeln.equals(castOther.ebeln)
			&& this.ebelp.equals(castOther.ebelp)
			&& this.crdat.equals(castOther.crdat)
			&& this.shift.equals(castOther.shift)
			&& this.incType.equals(castOther.incType)
			&& this.milkType.equals(castOther.milkType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.postingdate.hashCode();
		hash = hash * prime + this.werks.hashCode();
		hash = hash * prime + this.society.hashCode();
		hash = hash * prime + this.partner.hashCode();
		hash = hash * prime + this.j1kftbus.hashCode();
		hash = hash * prime + this.ebeln.hashCode();
		hash = hash * prime + this.ebelp.hashCode();
		hash = hash * prime + this.crdat.hashCode();
		hash = hash * prime + this.shift.hashCode();
		hash = hash * prime + this.incType.hashCode();
		hash = hash * prime + this.milkType.hashCode();
		
		return hash;
	}
}