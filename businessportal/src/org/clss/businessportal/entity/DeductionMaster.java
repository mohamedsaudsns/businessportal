package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the deduction_master database table.
 * 
 */
@Entity
@Table(name="deduction_master")
@NamedQuery(name="DeductionMaster.findAll", query="SELECT d FROM DeductionMaster d")
public class DeductionMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEDUCTION_CODE", unique=true, nullable=false, length=4)
	private String deductionCode;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DEDUCTION_DESC", length=45)
	private String deductionDesc;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(length=1)
	private String status;

	public DeductionMaster() {
	}

	public String getDeductionCode() {
		return this.deductionCode;
	}

	public void setDeductionCode(String deductionCode) {
		this.deductionCode = deductionCode;
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

	public String getDeductionDesc() {
		return this.deductionDesc;
	}

	public void setDeductionDesc(String deductionDesc) {
		this.deductionDesc = deductionDesc;
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

}