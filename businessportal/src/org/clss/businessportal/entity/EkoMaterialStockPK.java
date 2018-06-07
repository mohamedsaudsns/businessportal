package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the eko_material_stock database table.
 * 
 */
@Embeddable
public class EkoMaterialStockPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String swerk;

	private String equnr;

	private String msgrp;

	public EkoMaterialStockPK() {
	}
	public String getSwerk() {
		return this.swerk;
	}
	public void setSwerk(String swerk) {
		this.swerk = swerk;
	}
	public String getEqunr() {
		return this.equnr;
	}
	public void setEqunr(String equnr) {
		this.equnr = equnr;
	}
	public String getMsgrp() {
		return this.msgrp;
	}
	public void setMsgrp(String msgrp) {
		this.msgrp = msgrp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EkoMaterialStockPK)) {
			return false;
		}
		EkoMaterialStockPK castOther = (EkoMaterialStockPK)other;
		return 
			this.swerk.equals(castOther.swerk)
			&& this.equnr.equals(castOther.equnr)
			&& this.msgrp.equals(castOther.msgrp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.swerk.hashCode();
		hash = hash * prime + this.equnr.hashCode();
		hash = hash * prime + this.msgrp.hashCode();
		
		return hash;
	}
}