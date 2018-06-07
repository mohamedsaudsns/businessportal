package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the logistic_arrear database table.
 * 
 */
@Embeddable
public class LogisticArrearPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=4)
	private String compCode;

	@Column(name="DOC_ID", unique=true, nullable=false, length=10)
	private String docId;

	@Column(unique=true, nullable=false, length=4)
	private String plant;

	public LogisticArrearPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getDocId() {
		return this.docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getPlant() {
		return this.plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LogisticArrearPK)) {
			return false;
		}
		LogisticArrearPK castOther = (LogisticArrearPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.docId.equals(castOther.docId)
			&& this.plant.equals(castOther.plant);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.docId.hashCode();
		hash = hash * prime + this.plant.hashCode();
		
		return hash;
	}
}