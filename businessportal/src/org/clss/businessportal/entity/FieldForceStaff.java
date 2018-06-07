package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the field_force_staff database table.
 * 
 */
@Entity
@Table(name="field_force_staff")
@NamedQuery(name="FieldForceStaff.findAll", query="SELECT f FROM FieldForceStaff f")
public class FieldForceStaff implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FieldForceStaffPK id;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Temporal(TemporalType.DATE)
	@Column(name="HMB_DATE")
	private Date hmbDate;

	@Column(name="HMB_NAME")
	private String hmbName;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String name;

	private String pname;

	private String status;

	private String vendor;

	public FieldForceStaff() {
	}

	public FieldForceStaffPK getId() {
		return this.id;
	}

	public void setId(FieldForceStaffPK id) {
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

	public Date getHmbDate() {
		return this.hmbDate;
	}

	public void setHmbDate(Date hmbDate) {
		this.hmbDate = hmbDate;
	}

	public String getHmbName() {
		return this.hmbName;
	}

	public void setHmbName(String hmbName) {
		this.hmbName = hmbName;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}