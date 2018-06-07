package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vendor_vehicle_details database table.
 * 
 */
@Embeddable
public class VendorVehicleDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE")
	private String compCode;

	@Column(name="SERVICE_AGENT")
	private String serviceAgent;

	public VendorVehicleDetailPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getServiceAgent() {
		return this.serviceAgent;
	}
	public void setServiceAgent(String serviceAgent) {
		this.serviceAgent = serviceAgent;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VendorVehicleDetailPK)) {
			return false;
		}
		VendorVehicleDetailPK castOther = (VendorVehicleDetailPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.serviceAgent.equals(castOther.serviceAgent);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.serviceAgent.hashCode();
		
		return hash;
	}
}