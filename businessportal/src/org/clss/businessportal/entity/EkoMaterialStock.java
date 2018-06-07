package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the eko_material_stock database table.
 * 
 */
@Entity
@Table(name="eko_material_stock")
@NamedQuery(name="EkoMaterialStock.findAll", query="SELECT e FROM EkoMaterialStock e")
public class EkoMaterialStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EkoMaterialStockPK id;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String eqktx;

	private String invnr;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String status;

	public EkoMaterialStock() {
	}

	public EkoMaterialStockPK getId() {
		return this.id;
	}

	public void setId(EkoMaterialStockPK id) {
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

	public String getEqktx() {
		return this.eqktx;
	}

	public void setEqktx(String eqktx) {
		this.eqktx = eqktx;
	}

	public String getInvnr() {
		return this.invnr;
	}

	public void setInvnr(String invnr) {
		this.invnr = invnr;
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