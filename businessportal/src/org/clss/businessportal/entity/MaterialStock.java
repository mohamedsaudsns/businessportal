package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the material_stock database table.
 * 
 */
@Entity
@Table(name="material_stock")
@NamedQuery(name="MaterialStock.findAll", query="SELECT m FROM MaterialStock m")
public class MaterialStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MaterialStockPK id;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Temporal(TemporalType.DATE)
	private Date ersda;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Temporal(TemporalType.DATE)
	private Date lbdll;

	@Column(length=15)
	private String lbein;

	@Column(length=3)
	private String lbfll;

	@Column(length=3)
	private String lbflq;

	@Column(length=3)
	private String lbill;

	@Column(length=3)
	private String lbilq;

	@Column(length=15)
	private String lbins;

	private int lbjin;

	@Column(length=15)
	private String lblab;

	@Column(length=1)
	private String lbrue;

	@Column(length=1)
	private String lbspr;

	@Column(length=15)
	private String lbuml;

	@Column(length=15)
	private String lbvei;

	@Column(length=15)
	private String lbvin;

	@Column(length=15)
	private String lbvla;

	@Column(length=3)
	private String lbvll;

	@Column(length=3)
	private String lbvlq;

	private int lfgja;

	private int lfmon;

	@Column(name="SGT_SCAT", length=16)
	private String sgtScat;

	@Column(length=1)
	private String status;

	public MaterialStock() {
	}

	public MaterialStockPK getId() {
		return this.id;
	}

	public void setId(MaterialStockPK id) {
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

	public Date getLbdll() {
		return this.lbdll;
	}

	public void setLbdll(Date lbdll) {
		this.lbdll = lbdll;
	}

	public String getLbein() {
		return this.lbein;
	}

	public void setLbein(String lbein) {
		this.lbein = lbein;
	}

	public String getLbfll() {
		return this.lbfll;
	}

	public void setLbfll(String lbfll) {
		this.lbfll = lbfll;
	}

	public String getLbflq() {
		return this.lbflq;
	}

	public void setLbflq(String lbflq) {
		this.lbflq = lbflq;
	}

	public String getLbill() {
		return this.lbill;
	}

	public void setLbill(String lbill) {
		this.lbill = lbill;
	}

	public String getLbilq() {
		return this.lbilq;
	}

	public void setLbilq(String lbilq) {
		this.lbilq = lbilq;
	}

	public String getLbins() {
		return this.lbins;
	}

	public void setLbins(String lbins) {
		this.lbins = lbins;
	}

	public int getLbjin() {
		return this.lbjin;
	}

	public void setLbjin(int lbjin) {
		this.lbjin = lbjin;
	}

	public String getLblab() {
		return this.lblab;
	}

	public void setLblab(String lblab) {
		this.lblab = lblab;
	}

	public String getLbrue() {
		return this.lbrue;
	}

	public void setLbrue(String lbrue) {
		this.lbrue = lbrue;
	}

	public String getLbspr() {
		return this.lbspr;
	}

	public void setLbspr(String lbspr) {
		this.lbspr = lbspr;
	}

	public String getLbuml() {
		return this.lbuml;
	}

	public void setLbuml(String lbuml) {
		this.lbuml = lbuml;
	}

	public String getLbvei() {
		return this.lbvei;
	}

	public void setLbvei(String lbvei) {
		this.lbvei = lbvei;
	}

	public String getLbvin() {
		return this.lbvin;
	}

	public void setLbvin(String lbvin) {
		this.lbvin = lbvin;
	}

	public String getLbvla() {
		return this.lbvla;
	}

	public void setLbvla(String lbvla) {
		this.lbvla = lbvla;
	}

	public String getLbvll() {
		return this.lbvll;
	}

	public void setLbvll(String lbvll) {
		this.lbvll = lbvll;
	}

	public String getLbvlq() {
		return this.lbvlq;
	}

	public void setLbvlq(String lbvlq) {
		this.lbvlq = lbvlq;
	}

	public int getLfgja() {
		return this.lfgja;
	}

	public void setLfgja(int lfgja) {
		this.lfgja = lfgja;
	}

	public int getLfmon() {
		return this.lfmon;
	}

	public void setLfmon(int lfmon) {
		this.lfmon = lfmon;
	}

	public String getSgtScat() {
		return this.sgtScat;
	}

	public void setSgtScat(String sgtScat) {
		this.sgtScat = sgtScat;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}