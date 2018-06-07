package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the monthly_vehicle_summary database table.
 * 
 */
@Embeddable
public class MonthlyVehicleSummaryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="SHIPMENT_NO", unique=true, nullable=false, length=10)
	private String shipmentNo;

	@Column(unique=true, nullable=false, length=10)
	private String lblni;

	public MonthlyVehicleSummaryPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getShipmentNo() {
		return this.shipmentNo;
	}
	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
	}
	public String getLblni() {
		return this.lblni;
	}
	public void setLblni(String lblni) {
		this.lblni = lblni;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MonthlyVehicleSummaryPK)) {
			return false;
		}
		MonthlyVehicleSummaryPK castOther = (MonthlyVehicleSummaryPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.shipmentNo.equals(castOther.shipmentNo)
			&& this.lblni.equals(castOther.lblni);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.shipmentNo.hashCode();
		hash = hash * prime + this.lblni.hashCode();
		
		return hash;
	}
}