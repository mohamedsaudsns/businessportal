package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the material_stock database table.
 * 
 */
@Embeddable
public class MaterialStockPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(unique=true, nullable=false, length=18)
	private String matnr;

	@Column(unique=true, nullable=false, length=4)
	private String werks;

	@Column(unique=true, nullable=false, length=10)
	private String charg;

	@Column(unique=true, nullable=false, length=1)
	private String sobkz;

	@Column(unique=true, nullable=false, length=10)
	private String lifnr;

	public MaterialStockPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getMatnr() {
		return this.matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public String getWerks() {
		return this.werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	public String getCharg() {
		return this.charg;
	}
	public void setCharg(String charg) {
		this.charg = charg;
	}
	public String getSobkz() {
		return this.sobkz;
	}
	public void setSobkz(String sobkz) {
		this.sobkz = sobkz;
	}
	public String getLifnr() {
		return this.lifnr;
	}
	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MaterialStockPK)) {
			return false;
		}
		MaterialStockPK castOther = (MaterialStockPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.matnr.equals(castOther.matnr)
			&& this.werks.equals(castOther.werks)
			&& this.charg.equals(castOther.charg)
			&& this.sobkz.equals(castOther.sobkz)
			&& this.lifnr.equals(castOther.lifnr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.matnr.hashCode();
		hash = hash * prime + this.werks.hashCode();
		hash = hash * prime + this.charg.hashCode();
		hash = hash * prime + this.sobkz.hashCode();
		hash = hash * prime + this.lifnr.hashCode();
		
		return hash;
	}
}