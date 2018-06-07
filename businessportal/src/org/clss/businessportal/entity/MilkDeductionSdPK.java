package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the milk_deduction_sd database table.
 * 
 */
@Embeddable
public class MilkDeductionSdPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(unique=true, nullable=false, length=10)
	private String vbeln;

	@Column(unique=true, nullable=false)
	private int posnr;

	@Temporal(TemporalType.DATE)
	@Column(unique=true, nullable=false)
	private java.util.Date erdat;

	public MilkDeductionSdPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getVbeln() {
		return this.vbeln;
	}
	public void setVbeln(String vbeln) {
		this.vbeln = vbeln;
	}
	public int getPosnr() {
		return this.posnr;
	}
	public void setPosnr(int posnr) {
		this.posnr = posnr;
	}
	public java.util.Date getErdat() {
		return this.erdat;
	}
	public void setErdat(java.util.Date erdat) {
		this.erdat = erdat;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MilkDeductionSdPK)) {
			return false;
		}
		MilkDeductionSdPK castOther = (MilkDeductionSdPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.vbeln.equals(castOther.vbeln)
			&& (this.posnr == castOther.posnr)
			&& this.erdat.equals(castOther.erdat);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.vbeln.hashCode();
		hash = hash * prime + this.posnr;
		hash = hash * prime + this.erdat.hashCode();
		
		return hash;
	}
}