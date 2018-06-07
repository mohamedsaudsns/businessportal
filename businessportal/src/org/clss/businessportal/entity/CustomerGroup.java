package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the customer_group database table.
 * 
 */
@Entity
@Table(name="customer_group")
@NamedQuery(name="CustomerGroup.findAll", query="SELECT c FROM CustomerGroup c")
public class CustomerGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerGroupPK id;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="CUSTOMER_GRP_NAME", length=20)
	private String customerGrpName;

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

	public CustomerGroup() {
	}

	public CustomerGroupPK getId() {
		return this.id;
	}

	public void setId(CustomerGroupPK id) {
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

	public String getCustomerGrpName() {
		return this.customerGrpName;
	}

	public void setCustomerGrpName(String customerGrpName) {
		this.customerGrpName = customerGrpName;
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