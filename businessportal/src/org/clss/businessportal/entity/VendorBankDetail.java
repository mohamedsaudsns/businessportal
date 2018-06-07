package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vendor_bank_details database table.
 * 
 */
@Entity
@Table(name="vendor_bank_details")
@NamedQuery(name="VendorBankDetail.findAll", query="SELECT v FROM VendorBankDetail v")
public class VendorBankDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VendorBankDetailPK id;

	@Column(name="BANK_CITY", length=45)
	private String bankCity;

	@Column(name="BANK_COUNTRY", length=45)
	private String bankCountry;

	@Column(name="BANK_NAME", length=45)
	private String bankName;

	@Column(name="BRANCH_NAME", length=45)
	private String branchName;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="IFSC_CODE", length=45)
	private String ifscCode;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(length=1)
	private String status;

	//bi-directional many-to-one association to VendorMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="COMP_CODE", referencedColumnName="COMP_CODE", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="VENDOR_CODE", referencedColumnName="VENDOR_CODE", nullable=false, insertable=false, updatable=false)
		})
	private VendorMaster vendorMaster;

	public VendorBankDetail() {
	}

	public VendorBankDetailPK getId() {
		return this.id;
	}

	public void setId(VendorBankDetailPK id) {
		this.id = id;
	}

	public String getBankCity() {
		return this.bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getBankCountry() {
		return this.bankCountry;
	}

	public void setBankCountry(String bankCountry) {
		this.bankCountry = bankCountry;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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

	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
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

	public VendorMaster getVendorMaster() {
		return this.vendorMaster;
	}

	public void setVendorMaster(VendorMaster vendorMaster) {
		this.vendorMaster = vendorMaster;
	}

}