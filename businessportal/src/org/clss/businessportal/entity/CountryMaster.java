package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the country_master database table.
 * 
 */
@Entity
@Table(name="country_master")
@NamedQuery(name="CountryMaster.findAll", query="SELECT c FROM CountryMaster c")
public class CountryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COUNTRY_CODE", unique=true, nullable=false, length=3)
	private String countryCode;

	@Column(name="COUNTRY_NAME", length=50)
	private String countryName;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(length=1)
	private String status;

	//bi-directional many-to-one association to RegionMaster
	@OneToMany(mappedBy="countryMaster")
	private List<RegionMaster> regionMasters;

	public CountryMaster() {
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getLastChangedBy() {
		return this.lastChangedBy;
	}

	public void setLastChangedBy(int lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	public Date getLastChangedOn() {
		return this.lastChangedOn;
	}

	public void setLastChangedOn(Date lastChangedOn) {
		this.lastChangedOn = lastChangedOn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<RegionMaster> getRegionMasters() {
		return this.regionMasters;
	}

	public void setRegionMasters(List<RegionMaster> regionMasters) {
		this.regionMasters = regionMasters;
	}

	public RegionMaster addRegionMaster(RegionMaster regionMaster) {
		getRegionMasters().add(regionMaster);
		regionMaster.setCountryMaster(this);

		return regionMaster;
	}

	public RegionMaster removeRegionMaster(RegionMaster regionMaster) {
		getRegionMasters().remove(regionMaster);
		regionMaster.setCountryMaster(null);

		return regionMaster;
	}

}