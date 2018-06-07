package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hmb_material_stock database table.
 * 
 */
@Embeddable
public class HmbMaterialStockPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String vkbur;

	private String werks;

	private String lifnr;

	private String matnr;

	@Temporal(TemporalType.DATE)
	private java.util.Date spmon;

	public HmbMaterialStockPK() {
	}
	public String getVkbur() {
		return this.vkbur;
	}
	public void setVkbur(String vkbur) {
		this.vkbur = vkbur;
	}
	public String getWerks() {
		return this.werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	public String getLifnr() {
		return this.lifnr;
	}
	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}
	public String getMatnr() {
		return this.matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public java.util.Date getSpmon() {
		return this.spmon;
	}
	public void setSpmon(java.util.Date spmon) {
		this.spmon = spmon;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HmbMaterialStockPK)) {
			return false;
		}
		HmbMaterialStockPK castOther = (HmbMaterialStockPK)other;
		return 
			this.vkbur.equals(castOther.vkbur)
			&& this.werks.equals(castOther.werks)
			&& this.lifnr.equals(castOther.lifnr)
			&& this.matnr.equals(castOther.matnr)
			&& this.spmon.equals(castOther.spmon);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.vkbur.hashCode();
		hash = hash * prime + this.werks.hashCode();
		hash = hash * prime + this.lifnr.hashCode();
		hash = hash * prime + this.matnr.hashCode();
		hash = hash * prime + this.spmon.hashCode();
		
		return hash;
	}
}