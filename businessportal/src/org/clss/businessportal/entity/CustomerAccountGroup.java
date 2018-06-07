package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the customer_account_group database table.
 * 
 */
@Entity
@Table(name="customer_account_group")
@NamedQuery(name="CustomerAccountGroup.findAll", query="SELECT c FROM CustomerAccountGroup c")
public class CustomerAccountGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerAccountGroupPK id;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="CUSTOMER_ACC_GRP_NAME", length=30)
	private String customerAccGrpName;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(length=1)
	private String status;

	//bi-directional many-to-one association to CompanyMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMP_CODE", nullable=false, insertable=false, updatable=false)
	private CompanyMaster companyMaster;

	public CustomerAccountGroup() {
	}

	public CustomerAccountGroupPK getId() {
		return this.id;
	}

	public void setId(CustomerAccountGroupPK id) {
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

	public String getCustomerAccGrpName() {
		return this.customerAccGrpName;
	}

	public void setCustomerAccGrpName(String customerAccGrpName) {
		this.customerAccGrpName = customerAccGrpName;
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

	public CompanyMaster getCompanyMaster() {
		return this.companyMaster;
	}

	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
	}

}