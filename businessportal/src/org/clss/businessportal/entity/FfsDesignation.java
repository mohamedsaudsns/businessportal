package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the ffs_designation database table.
 * 
 */
@Entity
@Table(name="ffs_designation")
@NamedQuery(name="FfsDesignation.findAll", query="SELECT f FROM FfsDesignation f")
public class FfsDesignation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DESG_TYPE")
	private String desgType;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private Time crtim;

	@Column(name="DEL_IND")
	private String delInd;

	@Column(name="DESG_DESCR")
	private String desgDescr;

	@Column(name="DESG_LEVEL")
	private String desgLevel;

	private String ernam;

	@Temporal(TemporalType.DATE)
	private Date ersda;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String status;

	public FfsDesignation() {
	}

	public String getDesgType() {
		return this.desgType;
	}

	public void setDesgType(String desgType) {
		this.desgType = desgType;
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

	public Time getCrtim() {
		return this.crtim;
	}

	public void setCrtim(Time crtim) {
		this.crtim = crtim;
	}

	public String getDelInd() {
		return this.delInd;
	}

	public void setDelInd(String delInd) {
		this.delInd = delInd;
	}

	public String getDesgDescr() {
		return this.desgDescr;
	}

	public void setDesgDescr(String desgDescr) {
		this.desgDescr = desgDescr;
	}

	public String getDesgLevel() {
		return this.desgLevel;
	}

	public void setDesgLevel(String desgLevel) {
		this.desgLevel = desgLevel;
	}

	public String getErnam() {
		return this.ernam;
	}

	public void setErnam(String ernam) {
		this.ernam = ernam;
	}

	public Date getErsda() {
		return this.ersda;
	}

	public void setErsda(Date ersda) {
		this.ersda = ersda;
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