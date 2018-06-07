package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the agreement_ha database table.
 * 
 */
@Entity
@Table(name="agreement_ha")
@NamedQuery(name="AgreementHa.findAll", query="SELECT a FROM AgreementHa a")
public class AgreementHa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AgreementHaPK id;

	@Column(name="AGREEMENT_NO_OF_PERIOD", length=5)
	private String agreementNoOfPeriod;

	@Column(name="AREA_IN_SQFT", length=45)
	private String areaInSqft;

	@Column(name="BRAND_NAME", length=45)
	private String brandName;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="CUR_ADVANCE", precision=13, scale=2)
	private BigDecimal curAdvance;

	@Column(name="CUR_RENT", precision=13, scale=2)
	private BigDecimal curRent;

	@Column(name="CURRENT_STATUS", length=80)
	private String currentStatus;

	@Column(length=45)
	private String department;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="INIAL_ADVANCE_AMOUNT", precision=13, scale=2)
	private BigDecimal inialAdvanceAmount;

	@Column(name="INITIAL_RENT_AMOUNT", precision=13, scale=2)
	private BigDecimal initialRentAmount;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(length=45)
	private String location;

	@Column(name="NOTICE_PERIOD", length=45)
	private String noticePeriod;

	@Column(length=45)
	private String plant;

	@Column(name="PRE_RENT_IN_SQFT", length=45)
	private String preRentInSqft;

	@Temporal(TemporalType.DATE)
	@Column(name="RENEWAL_DATE")
	private Date renewalDate;

	@Column(name="RENEWAL_TYPE", length=45)
	private String renewalType;

	@Column(name="RENT_INCREASE_PER", length=4)
	private String rentIncreasePer;

	@Column(name="RENT_INCREASE_YEAR", length=10)
	private String rentIncreaseYear;

	@Column(name="RENT_SQFT", length=45)
	private String rentSqft;

	@Column(name="SHOP_ADDRESS", length=100)
	private String shopAddress;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	@Column(length=1)
	private String status;

	@Column(name="VENDOR_NAME", length=70)
	private String vendorName;

	//bi-directional many-to-one association to AgreementLi
	@OneToMany(mappedBy="agreementHa")
	private List<AgreementLi> agreementLis;

	public AgreementHa() {
	}

	public AgreementHaPK getId() {
		return this.id;
	}

	public void setId(AgreementHaPK id) {
		this.id = id;
	}

	public String getAgreementNoOfPeriod() {
		return this.agreementNoOfPeriod;
	}

	public void setAgreementNoOfPeriod(String agreementNoOfPeriod) {
		this.agreementNoOfPeriod = agreementNoOfPeriod;
	}

	public String getAreaInSqft() {
		return this.areaInSqft;
	}

	public void setAreaInSqft(String areaInSqft) {
		this.areaInSqft = areaInSqft;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public BigDecimal getCurAdvance() {
		return this.curAdvance;
	}

	public void setCurAdvance(BigDecimal curAdvance) {
		this.curAdvance = curAdvance;
	}

	public BigDecimal getCurRent() {
		return this.curRent;
	}

	public void setCurRent(BigDecimal curRent) {
		this.curRent = curRent;
	}

	public String getCurrentStatus() {
		return this.currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getInialAdvanceAmount() {
		return this.inialAdvanceAmount;
	}

	public void setInialAdvanceAmount(BigDecimal inialAdvanceAmount) {
		this.inialAdvanceAmount = inialAdvanceAmount;
	}

	public BigDecimal getInitialRentAmount() {
		return this.initialRentAmount;
	}

	public void setInitialRentAmount(BigDecimal initialRentAmount) {
		this.initialRentAmount = initialRentAmount;
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

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNoticePeriod() {
		return this.noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String getPlant() {
		return this.plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getPreRentInSqft() {
		return this.preRentInSqft;
	}

	public void setPreRentInSqft(String preRentInSqft) {
		this.preRentInSqft = preRentInSqft;
	}

	public Date getRenewalDate() {
		return this.renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}

	public String getRenewalType() {
		return this.renewalType;
	}

	public void setRenewalType(String renewalType) {
		this.renewalType = renewalType;
	}

	public String getRentIncreasePer() {
		return this.rentIncreasePer;
	}

	public void setRentIncreasePer(String rentIncreasePer) {
		this.rentIncreasePer = rentIncreasePer;
	}

	public String getRentIncreaseYear() {
		return this.rentIncreaseYear;
	}

	public void setRentIncreaseYear(String rentIncreaseYear) {
		this.rentIncreaseYear = rentIncreaseYear;
	}

	public String getRentSqft() {
		return this.rentSqft;
	}

	public void setRentSqft(String rentSqft) {
		this.rentSqft = rentSqft;
	}

	public String getShopAddress() {
		return this.shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVendorName() {
		return this.vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public List<AgreementLi> getAgreementLis() {
		return this.agreementLis;
	}

	public void setAgreementLis(List<AgreementLi> agreementLis) {
		this.agreementLis = agreementLis;
	}

	public AgreementLi addAgreementLi(AgreementLi agreementLi) {
		getAgreementLis().add(agreementLi);
		agreementLi.setAgreementHa(this);

		return agreementLi;
	}

	public AgreementLi removeAgreementLi(AgreementLi agreementLi) {
		getAgreementLis().remove(agreementLi);
		agreementLi.setAgreementHa(null);

		return agreementLi;
	}

}