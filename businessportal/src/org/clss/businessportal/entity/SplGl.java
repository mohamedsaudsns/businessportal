package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the spl_gl database table.
 * 
 */
@Entity
@Table(name="spl_gl")
@NamedQuery(name="SplGl.findAll", query="SELECT s FROM SplGl s")
public class SplGl implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SplGlPK id;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String ktext;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String ltext;

	private String status;

	public SplGl() {
	}

	public SplGlPK getId() {
		return this.id;
	}

	public void setId(SplGlPK id) {
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

	public String getKtext() {
		return this.ktext;
	}

	public void setKtext(String ktext) {
		this.ktext = ktext;
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

	public String getLtext() {
		return this.ltext;
	}

	public void setLtext(String ltext) {
		this.ltext = ltext;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}