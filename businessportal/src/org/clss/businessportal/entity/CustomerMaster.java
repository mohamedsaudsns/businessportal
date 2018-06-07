package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customer_master database table.
 * 
 */
@Entity
@Table(name="customer_master")
@NamedQuery(name="CustomerMaster.findAll", query="SELECT c FROM CustomerMaster c")
public class CustomerMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerMasterPK id;

	@Column(length=35)
	private String city;

	@Column(name="CRATE_CAPACITY", length=45)
	private String crateCapacity;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="CUSTOMER_ACC_GRP_CODE", nullable=false, length=4)
	private String customerAccGrpCode;

	@Column(name="CUSTOMER_GRP_CODE", nullable=false, length=2)
	private String customerGrpCode;

	@Column(length=35)
	private String district;

	@Column(name="DOOR_NO", length=80)
	private String doorNo;

	@Column(length=45)
	private String email;

	@Column(length=15)
	private String gstin;

	@Column(length=80)
	private String landmark;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="MOBILE_NO_1", length=15)
	private String mobileNo1;

	@Column(name="MOBILE_NO_2", length=15)
	private String mobileNo2;

	@Column(length=35)
	private String name;

	@Column(name="NAME_2", length=35)
	private String name2;

	@Column(name="PAN_NO", length=10)
	private String panNo;

	@Column(name="POSTAL_CODE", length=10)
	private String postalCode;

	@Column(length=1)
	private String status;

	@Column(name="STREET_1", length=35)
	private String street1;

	@Column(name="STREET_2", length=35)
	private String street2;

	@Column(name="STREET_NAME_1", length=80)
	private String streetName1;

	@Column(name="STREET_NAME_2", length=80)
	private String streetName2;

	@Column(name="STREET_NAME_3", length=80)
	private String streetName3;

	@Column(name="TELEPHONE_NO", length=16)
	private String telephoneNo;

	//bi-directional many-to-one association to ArReport
	@OneToMany(mappedBy="customerMaster")
	private List<ArReport> arReports;

	//bi-directional many-to-one association to CustomerBankDetail
	@OneToMany(mappedBy="customerMaster")
	private List<CustomerBankDetail> customerBankDetails;

	//bi-directional many-to-one association to CompanyMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMP_CODE", nullable=false, insertable=false, updatable=false)
	private CompanyMaster companyMaster;

	//bi-directional many-to-one association to RegionMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="COUNTRY_CODE", referencedColumnName="COUNTRY_CODE"),
		@JoinColumn(name="REGION_CODE", referencedColumnName="REGION_CODE")
		})
	private RegionMaster regionMaster;

	public CustomerMaster() {
	}

	public CustomerMasterPK getId() {
		return this.id;
	}

	public void setId(CustomerMasterPK id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCrateCapacity() {
		return this.crateCapacity;
	}

	public void setCrateCapacity(String crateCapacity) {
		this.crateCapacity = crateCapacity;
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

	public String getCustomerAccGrpCode() {
		return this.customerAccGrpCode;
	}

	public void setCustomerAccGrpCode(String customerAccGrpCode) {
		this.customerAccGrpCode = customerAccGrpCode;
	}

	public String getCustomerGrpCode() {
		return this.customerGrpCode;
	}

	public void setCustomerGrpCode(String customerGrpCode) {
		this.customerGrpCode = customerGrpCode;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDoorNo() {
		return this.doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGstin() {
		return this.gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getLandmark() {
		return this.landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
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

	public String getMobileNo1() {
		return this.mobileNo1;
	}

	public void setMobileNo1(String mobileNo1) {
		this.mobileNo1 = mobileNo1;
	}

	public String getMobileNo2() {
		return this.mobileNo2;
	}

	public void setMobileNo2(String mobileNo2) {
		this.mobileNo2 = mobileNo2;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName2() {
		return this.name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getPanNo() {
		return this.panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getStreetName1() {
		return this.streetName1;
	}

	public void setStreetName1(String streetName1) {
		this.streetName1 = streetName1;
	}

	public String getStreetName2() {
		return this.streetName2;
	}

	public void setStreetName2(String streetName2) {
		this.streetName2 = streetName2;
	}

	public String getStreetName3() {
		return this.streetName3;
	}

	public void setStreetName3(String streetName3) {
		this.streetName3 = streetName3;
	}

	public String getTelephoneNo() {
		return this.telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public List<ArReport> getArReports() {
		return this.arReports;
	}

	public void setArReports(List<ArReport> arReports) {
		this.arReports = arReports;
	}

	public ArReport addArReport(ArReport arReport) {
		getArReports().add(arReport);
		arReport.setCustomerMaster(this);

		return arReport;
	}

	public ArReport removeArReport(ArReport arReport) {
		getArReports().remove(arReport);
		arReport.setCustomerMaster(null);

		return arReport;
	}

	public List<CustomerBankDetail> getCustomerBankDetails() {
		return this.customerBankDetails;
	}

	public void setCustomerBankDetails(List<CustomerBankDetail> customerBankDetails) {
		this.customerBankDetails = customerBankDetails;
	}

	public CustomerBankDetail addCustomerBankDetail(CustomerBankDetail customerBankDetail) {
		getCustomerBankDetails().add(customerBankDetail);
		customerBankDetail.setCustomerMaster(this);

		return customerBankDetail;
	}

	public CustomerBankDetail removeCustomerBankDetail(CustomerBankDetail customerBankDetail) {
		getCustomerBankDetails().remove(customerBankDetail);
		customerBankDetail.setCustomerMaster(null);

		return customerBankDetail;
	}

	public CompanyMaster getCompanyMaster() {
		return this.companyMaster;
	}

	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
	}

	public RegionMaster getRegionMaster() {
		return this.regionMaster;
	}

	public void setRegionMaster(RegionMaster regionMaster) {
		this.regionMaster = regionMaster;
	}

}