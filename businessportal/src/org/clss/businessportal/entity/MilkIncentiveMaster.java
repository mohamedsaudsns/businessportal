package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the milk_incentive_master database table.
 * 
 */
@Entity
@Table(name="milk_incentive_master")
@NamedQuery(name="MilkIncentiveMaster.findAll", query="SELECT m FROM MilkIncentiveMaster m")
public class MilkIncentiveMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MilkIncentiveMasterPK id;

	@Column(name="COMPARISTION_TY")
	private String comparistionTy;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DEPOSIT_PERCENT")
	private String depositPercent;

	@Column(name="INC_DESCRIPTION")
	private String incDescription;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="QTY_STRUCTURE")
	private String qtyStructure;

	@Column(name="QUL_CONDITION")
	private String qulCondition;

	@Column(name="QUL_CRITERIA")
	private String qulCriteria;

	@Column(name="SECURITY_DEPOSIT")
	private String securityDeposit;

	private String status;

	public MilkIncentiveMaster() {
	}

	public MilkIncentiveMasterPK getId() {
		return this.id;
	}

	public void setId(MilkIncentiveMasterPK id) {
		this.id = id;
	}

	public String getComparistionTy() {
		return this.comparistionTy;
	}

	public void setComparistionTy(String comparistionTy) {
		this.comparistionTy = comparistionTy;
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

	public String getDepositPercent() {
		return this.depositPercent;
	}

	public void setDepositPercent(String depositPercent) {
		this.depositPercent = depositPercent;
	}

	public String getIncDescription() {
		return this.incDescription;
	}

	public void setIncDescription(String incDescription) {
		this.incDescription = incDescription;
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

	public String getQtyStructure() {
		return this.qtyStructure;
	}

	public void setQtyStructure(String qtyStructure) {
		this.qtyStructure = qtyStructure;
	}

	public String getQulCondition() {
		return this.qulCondition;
	}

	public void setQulCondition(String qulCondition) {
		this.qulCondition = qulCondition;
	}

	public String getQulCriteria() {
		return this.qulCriteria;
	}

	public void setQulCriteria(String qulCriteria) {
		this.qulCriteria = qulCriteria;
	}

	public String getSecurityDeposit() {
		return this.securityDeposit;
	}

	public void setSecurityDeposit(String securityDeposit) {
		this.securityDeposit = securityDeposit;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}