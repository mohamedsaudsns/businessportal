package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the region_master database table.
 * 
 */
@Entity
@Table(name="region_master")
@NamedQuery(name="RegionMaster.findAll", query="SELECT r FROM RegionMaster r")
public class RegionMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegionMasterPK id;

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

	@Column(name="REGION_NAME", length=45)
	private String regionName;

	@Column(length=1)
	private String status;

	//bi-directional many-to-one association to CustomerMaster
	@OneToMany(mappedBy="regionMaster")
	private List<CustomerMaster> customerMasters;

	//bi-directional many-to-one association to CountryMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COUNTRY_CODE", nullable=false, insertable=false, updatable=false)
	private CountryMaster countryMaster;

	//bi-directional many-to-one association to VendorMaster
	@OneToMany(mappedBy="regionMaster")
	private List<VendorMaster> vendorMasters;

	public RegionMaster() {
	}

	public RegionMasterPK getId() {
		return this.id;
	}

	public void setId(RegionMasterPK id) {
		this.id = id;
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

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CustomerMaster> getCustomerMasters() {
		return this.customerMasters;
	}

	public void setCustomerMasters(List<CustomerMaster> customerMasters) {
		this.customerMasters = customerMasters;
	}

	public CustomerMaster addCustomerMaster(CustomerMaster customerMaster) {
		getCustomerMasters().add(customerMaster);
		customerMaster.setRegionMaster(this);

		return customerMaster;
	}

	public CustomerMaster removeCustomerMaster(CustomerMaster customerMaster) {
		getCustomerMasters().remove(customerMaster);
		customerMaster.setRegionMaster(null);

		return customerMaster;
	}

	public CountryMaster getCountryMaster() {
		return this.countryMaster;
	}

	public void setCountryMaster(CountryMaster countryMaster) {
		this.countryMaster = countryMaster;
	}

	public List<VendorMaster> getVendorMasters() {
		return this.vendorMasters;
	}

	public void setVendorMasters(List<VendorMaster> vendorMasters) {
		this.vendorMasters = vendorMasters;
	}

	public VendorMaster addVendorMaster(VendorMaster vendorMaster) {
		getVendorMasters().add(vendorMaster);
		vendorMaster.setRegionMaster(this);

		return vendorMaster;
	}

	public VendorMaster removeVendorMaster(VendorMaster vendorMaster) {
		getVendorMasters().remove(vendorMaster);
		vendorMaster.setRegionMaster(null);

		return vendorMaster;
	}

}