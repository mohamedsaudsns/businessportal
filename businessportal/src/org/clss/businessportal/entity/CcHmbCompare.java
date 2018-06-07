package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cc_hmb_compare database table.
 * 
 */
@Entity
@Table(name="cc_hmb_compare")
@NamedQuery(name="CcHmbCompare.findAll", query="SELECT c FROM CcHmbCompare c")
public class CcHmbCompare implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CcHmbComparePK id;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String diff;

	@Column(name="ERFMG_LTR")
	private String erfmgLtr;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String quantity;

	private String status;

	public CcHmbCompare() {
	}

	public CcHmbComparePK getId() {
		return this.id;
	}

	public void setId(CcHmbComparePK id) {
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

	public String getDiff() {
		return this.diff;
	}

	public void setDiff(String diff) {
		this.diff = diff;
	}

	public String getErfmgLtr() {
		return this.erfmgLtr;
	}

	public void setErfmgLtr(String erfmgLtr) {
		this.erfmgLtr = erfmgLtr;
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

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}