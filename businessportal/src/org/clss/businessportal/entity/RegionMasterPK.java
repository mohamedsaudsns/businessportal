package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the region_master database table.
 * 
 */
@Embeddable
public class RegionMasterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="REGION_CODE", unique=true, nullable=false, length=4)
	private String regionCode;

	@Column(name="COUNTRY_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=3)
	private String countryCode;

	public RegionMasterPK() {
	}
	public String getRegionCode() {
		return this.regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getCountryCode() {
		return this.countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RegionMasterPK)) {
			return false;
		}
		RegionMasterPK castOther = (RegionMasterPK)other;
		return 
			this.regionCode.equals(castOther.regionCode)
			&& this.countryCode.equals(castOther.countryCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.regionCode.hashCode();
		hash = hash * prime + this.countryCode.hashCode();
		
		return hash;
	}
}