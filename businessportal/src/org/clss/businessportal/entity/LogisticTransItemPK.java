package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the logistic_trans_item database table.
 * 
 */
@Embeddable
public class LogisticTransItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=4)
	private String compCode;

	@Column(unique=true, nullable=false, length=10)
	private String transporter;

	@Column(unique=true, nullable=false, length=4)
	private String werks;

	@Column(name="ROUTE_NO", unique=true, nullable=false, length=6)
	private String routeNo;

	@Temporal(TemporalType.DATE)
	@Column(unique=true, nullable=false)
	private java.util.Date crdat;

	public LogisticTransItemPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getTransporter() {
		return this.transporter;
	}
	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}
	public String getWerks() {
		return this.werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	public String getRouteNo() {
		return this.routeNo;
	}
	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}
	public java.util.Date getCrdat() {
		return this.crdat;
	}
	public void setCrdat(java.util.Date crdat) {
		this.crdat = crdat;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LogisticTransItemPK)) {
			return false;
		}
		LogisticTransItemPK castOther = (LogisticTransItemPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.transporter.equals(castOther.transporter)
			&& this.werks.equals(castOther.werks)
			&& this.routeNo.equals(castOther.routeNo)
			&& this.crdat.equals(castOther.crdat);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.transporter.hashCode();
		hash = hash * prime + this.werks.hashCode();
		hash = hash * prime + this.routeNo.hashCode();
		hash = hash * prime + this.crdat.hashCode();
		
		return hash;
	}
}