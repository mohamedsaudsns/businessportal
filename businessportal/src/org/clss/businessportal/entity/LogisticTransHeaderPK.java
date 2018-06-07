package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the logistic_trans_header database table.
 * 
 */
@Embeddable
public class LogisticTransHeaderPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(unique=true, nullable=false, length=10)
	private String transporter;

	@Column(unique=true, nullable=false, length=4)
	private String plant;

	@Column(unique=true, nullable=false, length=6)
	private String route;

	@Column(name="BILL_NUM", unique=true, nullable=false, length=10)
	private String billNum;

	@Temporal(TemporalType.DATE)
	@Column(name="BILL_PRD_STR", unique=true, nullable=false)
	private java.util.Date billPrdStr;

	@Temporal(TemporalType.DATE)
	@Column(name="BILL_PRD_END", unique=true, nullable=false)
	private java.util.Date billPrdEnd;

	public LogisticTransHeaderPK() {
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
	public String getPlant() {
		return this.plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getRoute() {
		return this.route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getBillNum() {
		return this.billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
	public java.util.Date getBillPrdStr() {
		return this.billPrdStr;
	}
	public void setBillPrdStr(java.util.Date billPrdStr) {
		this.billPrdStr = billPrdStr;
	}
	public java.util.Date getBillPrdEnd() {
		return this.billPrdEnd;
	}
	public void setBillPrdEnd(java.util.Date billPrdEnd) {
		this.billPrdEnd = billPrdEnd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LogisticTransHeaderPK)) {
			return false;
		}
		LogisticTransHeaderPK castOther = (LogisticTransHeaderPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.transporter.equals(castOther.transporter)
			&& this.plant.equals(castOther.plant)
			&& this.route.equals(castOther.route)
			&& this.billNum.equals(castOther.billNum)
			&& this.billPrdStr.equals(castOther.billPrdStr)
			&& this.billPrdEnd.equals(castOther.billPrdEnd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.transporter.hashCode();
		hash = hash * prime + this.plant.hashCode();
		hash = hash * prime + this.route.hashCode();
		hash = hash * prime + this.billNum.hashCode();
		hash = hash * prime + this.billPrdStr.hashCode();
		hash = hash * prime + this.billPrdEnd.hashCode();
		
		return hash;
	}
}