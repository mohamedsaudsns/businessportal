package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the spl_gl database table.
 * 
 */
@Embeddable
public class SplGlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String mandt;

	private String spras;

	private String koart;

	private String shbkz;

	public SplGlPK() {
	}
	public String getMandt() {
		return this.mandt;
	}
	public void setMandt(String mandt) {
		this.mandt = mandt;
	}
	public String getSpras() {
		return this.spras;
	}
	public void setSpras(String spras) {
		this.spras = spras;
	}
	public String getKoart() {
		return this.koart;
	}
	public void setKoart(String koart) {
		this.koart = koart;
	}
	public String getShbkz() {
		return this.shbkz;
	}
	public void setShbkz(String shbkz) {
		this.shbkz = shbkz;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SplGlPK)) {
			return false;
		}
		SplGlPK castOther = (SplGlPK)other;
		return 
			this.mandt.equals(castOther.mandt)
			&& this.spras.equals(castOther.spras)
			&& this.koart.equals(castOther.koart)
			&& this.shbkz.equals(castOther.shbkz);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mandt.hashCode();
		hash = hash * prime + this.spras.hashCode();
		hash = hash * prime + this.koart.hashCode();
		hash = hash * prime + this.shbkz.hashCode();
		
		return hash;
	}
}