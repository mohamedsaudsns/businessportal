package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the society_incharge_mapping database table.
 * 
 */
@Embeddable
public class SocietyInchargeMappingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE")
	private String compCode;

	private String society;

	private String ekorg;

	private String parvw;

	public SocietyInchargeMappingPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getSociety() {
		return this.society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
	public String getEkorg() {
		return this.ekorg;
	}
	public void setEkorg(String ekorg) {
		this.ekorg = ekorg;
	}
	public String getParvw() {
		return this.parvw;
	}
	public void setParvw(String parvw) {
		this.parvw = parvw;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SocietyInchargeMappingPK)) {
			return false;
		}
		SocietyInchargeMappingPK castOther = (SocietyInchargeMappingPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.society.equals(castOther.society)
			&& this.ekorg.equals(castOther.ekorg)
			&& this.parvw.equals(castOther.parvw);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.society.hashCode();
		hash = hash * prime + this.ekorg.hashCode();
		hash = hash * prime + this.parvw.hashCode();
		
		return hash;
	}
}