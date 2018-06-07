package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the news_letter database table.
 * 
 */
@Embeddable
public class NewsLetterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="REGION_CODE")
	private String regionCode;

	@Column(name="TYPE_ID")
	private int typeId;

	@Column(name="COUNTRY_CODE")
	private String countryCode;

	public NewsLetterPK() {
	}
	public String getRegionCode() {
		return this.regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public int getTypeId() {
		return this.typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
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
		if (!(other instanceof NewsLetterPK)) {
			return false;
		}
		NewsLetterPK castOther = (NewsLetterPK)other;
		return 
			this.regionCode.equals(castOther.regionCode)
			&& (this.typeId == castOther.typeId)
			&& this.countryCode.equals(castOther.countryCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.regionCode.hashCode();
		hash = hash * prime + this.typeId;
		hash = hash * prime + this.countryCode.hashCode();
		
		return hash;
	}
}