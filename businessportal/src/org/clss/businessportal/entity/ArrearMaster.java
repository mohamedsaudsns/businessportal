package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the arrear_master database table.
 * 
 */
@Entity
@Table(name="arrear_master")
@NamedQuery(name="ArrearMaster.findAll", query="SELECT a FROM ArrearMaster a")
public class ArrearMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ARREAR_CODE", unique=true, nullable=false, length=4)
	private String arrearCode;

	@Column(name="ARREAR_NAME", length=60)
	private String arrearName;

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

	public ArrearMaster() {
	}

	public String getArrearCode() {
		return this.arrearCode;
	}

	public void setArrearCode(String arrearCode) {
		this.arrearCode = arrearCode;
	}

	public String getArrearName() {
		return this.arrearName;
	}

	public void setArrearName(String arrearName) {
		this.arrearName = arrearName;
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

}