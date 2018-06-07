package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the recovery_master database table.
 * 
 */
@Entity
@Table(name="recovery_master")
@NamedQuery(name="RecoveryMaster.findAll", query="SELECT r FROM RecoveryMaster r")
public class RecoveryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RECOVERY_CODE", unique=true, nullable=false, length=4)
	private String recoveryCode;

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

	@Column(name="RECOVERY_NAME", length=45)
	private String recoveryName;

	@Column(length=1)
	private String status;

	public RecoveryMaster() {
	}

	public String getRecoveryCode() {
		return this.recoveryCode;
	}

	public void setRecoveryCode(String recoveryCode) {
		this.recoveryCode = recoveryCode;
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

	public String getRecoveryName() {
		return this.recoveryName;
	}

	public void setRecoveryName(String recoveryName) {
		this.recoveryName = recoveryName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}