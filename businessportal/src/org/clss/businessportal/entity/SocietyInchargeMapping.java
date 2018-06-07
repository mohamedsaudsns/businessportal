package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the society_incharge_mapping database table.
 * 
 */
@Entity
@Table(name="society_incharge_mapping")
@NamedQuery(name="SocietyInchargeMapping.findAll", query="SELECT s FROM SocietyInchargeMapping s")
public class SocietyInchargeMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SocietyInchargeMappingPK id;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String incharge;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String status;

	public SocietyInchargeMapping() {
	}

	public SocietyInchargeMappingPK getId() {
		return this.id;
	}

	public void setId(SocietyInchargeMappingPK id) {
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

	public String getIncharge() {
		return this.incharge;
	}

	public void setIncharge(String incharge) {
		this.incharge = incharge;
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