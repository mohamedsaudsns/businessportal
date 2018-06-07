package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ts_recovery database table.
 * 
 */
@Embeddable
public class TsRecoveryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PLANT_CODE")
	private String plantCode;

	private String hmb;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FRM")
	private java.util.Date dateFrm;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_TO")
	private java.util.Date dateTo;

	public TsRecoveryPK() {
	}
	public String getPlantCode() {
		return this.plantCode;
	}
	public void setPlantCode(String plantCode) {
		this.plantCode = plantCode;
	}
	public String getHmb() {
		return this.hmb;
	}
	public void setHmb(String hmb) {
		this.hmb = hmb;
	}
	public java.util.Date getDateFrm() {
		return this.dateFrm;
	}
	public void setDateFrm(java.util.Date dateFrm) {
		this.dateFrm = dateFrm;
	}
	public java.util.Date getDateTo() {
		return this.dateTo;
	}
	public void setDateTo(java.util.Date dateTo) {
		this.dateTo = dateTo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TsRecoveryPK)) {
			return false;
		}
		TsRecoveryPK castOther = (TsRecoveryPK)other;
		return 
			this.plantCode.equals(castOther.plantCode)
			&& this.hmb.equals(castOther.hmb)
			&& this.dateFrm.equals(castOther.dateFrm)
			&& this.dateTo.equals(castOther.dateTo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.plantCode.hashCode();
		hash = hash * prime + this.hmb.hashCode();
		hash = hash * prime + this.dateFrm.hashCode();
		hash = hash * prime + this.dateTo.hashCode();
		
		return hash;
	}
}