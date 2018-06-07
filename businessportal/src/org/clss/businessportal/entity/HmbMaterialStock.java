package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the hmb_material_stock database table.
 * 
 */
@Entity
@Table(name="hmb_material_stock")
@NamedQuery(name="HmbMaterialStock.findAll", query="SELECT h FROM HmbMaterialStock h")
public class HmbMaterialStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HmbMaterialStockPK id;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String kunag;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private BigDecimal netmktrpkgs;

	private BigDecimal netsales;

	private BigDecimal netsalesqtkg;

	private String status;

	@Column(name="TEXT_S751_MATNR")
	private String textS751Matnr;

	public HmbMaterialStock() {
	}

	public HmbMaterialStockPK getId() {
		return this.id;
	}

	public void setId(HmbMaterialStockPK id) {
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

	public String getKunag() {
		return this.kunag;
	}

	public void setKunag(String kunag) {
		this.kunag = kunag;
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

	public BigDecimal getNetmktrpkgs() {
		return this.netmktrpkgs;
	}

	public void setNetmktrpkgs(BigDecimal netmktrpkgs) {
		this.netmktrpkgs = netmktrpkgs;
	}

	public BigDecimal getNetsales() {
		return this.netsales;
	}

	public void setNetsales(BigDecimal netsales) {
		this.netsales = netsales;
	}

	public BigDecimal getNetsalesqtkg() {
		return this.netsalesqtkg;
	}

	public void setNetsalesqtkg(BigDecimal netsalesqtkg) {
		this.netsalesqtkg = netsalesqtkg;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTextS751Matnr() {
		return this.textS751Matnr;
	}

	public void setTextS751Matnr(String textS751Matnr) {
		this.textS751Matnr = textS751Matnr;
	}

}