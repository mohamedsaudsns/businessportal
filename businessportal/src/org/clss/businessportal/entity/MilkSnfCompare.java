package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the milk_snf_compare database table.
 * 
 */
@Entity
@Table(name="milk_snf_compare")
@NamedQuery(name="MilkSnfCompare.findAll", query="SELECT m FROM MilkSnfCompare m")
public class MilkSnfCompare implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MilkSnfComparePK id;

	private String ckgfat;

	@Column(name="CKGFAT_E")
	private String ckgfatE;

	@Column(name="CKGFAT_S")
	private String ckgfatS;

	private String ckgsnf;

	@Column(name="CKGSNF_E")
	private String ckgsnfE;

	@Column(name="CKGSNF_S")
	private String ckgsnfS;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String cts;

	private String dkgfat;

	private String dkgsnf;

	private String erfmg;

	@Column(name="ERFMG_LTR")
	private String erfmgLtr;

	@Column(name="ERFMG_LTR_E")
	private String erfmgLtrE;

	@Column(name="ERFMG_LTR_S")
	private String erfmgLtrS;

	private String fat;

	@Column(name="FAT_E")
	private String fatE;

	@Column(name="FAT_N")
	private String fatN;

	@Column(name="FAT_S")
	private String fatS;

	@Column(name="J_1KFTBUS")
	private String j1kftbus;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="P_NAME")
	private String pName;

	private String quantity;

	@Column(name="QUANTITY_KG")
	private String quantityKg;

	@Column(name="R_NAME")
	private String rName;

	private String route;

	@Column(name="S_NAME")
	private String sName;

	private String snf;

	@Column(name="SNF_E")
	private String snfE;

	@Column(name="SNF_N")
	private String snfN;

	@Column(name="SNF_S")
	private String snfS;

	private String status;

	@Column(name="TS_N")
	private String tsN;

	public MilkSnfCompare() {
	}

	public MilkSnfComparePK getId() {
		return this.id;
	}

	public void setId(MilkSnfComparePK id) {
		this.id = id;
	}

	public String getCkgfat() {
		return this.ckgfat;
	}

	public void setCkgfat(String ckgfat) {
		this.ckgfat = ckgfat;
	}

	public String getCkgfatE() {
		return this.ckgfatE;
	}

	public void setCkgfatE(String ckgfatE) {
		this.ckgfatE = ckgfatE;
	}

	public String getCkgfatS() {
		return this.ckgfatS;
	}

	public void setCkgfatS(String ckgfatS) {
		this.ckgfatS = ckgfatS;
	}

	public String getCkgsnf() {
		return this.ckgsnf;
	}

	public void setCkgsnf(String ckgsnf) {
		this.ckgsnf = ckgsnf;
	}

	public String getCkgsnfE() {
		return this.ckgsnfE;
	}

	public void setCkgsnfE(String ckgsnfE) {
		this.ckgsnfE = ckgsnfE;
	}

	public String getCkgsnfS() {
		return this.ckgsnfS;
	}

	public void setCkgsnfS(String ckgsnfS) {
		this.ckgsnfS = ckgsnfS;
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

	public String getCts() {
		return this.cts;
	}

	public void setCts(String cts) {
		this.cts = cts;
	}

	public String getDkgfat() {
		return this.dkgfat;
	}

	public void setDkgfat(String dkgfat) {
		this.dkgfat = dkgfat;
	}

	public String getDkgsnf() {
		return this.dkgsnf;
	}

	public void setDkgsnf(String dkgsnf) {
		this.dkgsnf = dkgsnf;
	}

	public String getErfmg() {
		return this.erfmg;
	}

	public void setErfmg(String erfmg) {
		this.erfmg = erfmg;
	}

	public String getErfmgLtr() {
		return this.erfmgLtr;
	}

	public void setErfmgLtr(String erfmgLtr) {
		this.erfmgLtr = erfmgLtr;
	}

	public String getErfmgLtrE() {
		return this.erfmgLtrE;
	}

	public void setErfmgLtrE(String erfmgLtrE) {
		this.erfmgLtrE = erfmgLtrE;
	}

	public String getErfmgLtrS() {
		return this.erfmgLtrS;
	}

	public void setErfmgLtrS(String erfmgLtrS) {
		this.erfmgLtrS = erfmgLtrS;
	}

	public String getFat() {
		return this.fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
	}

	public String getFatE() {
		return this.fatE;
	}

	public void setFatE(String fatE) {
		this.fatE = fatE;
	}

	public String getFatN() {
		return this.fatN;
	}

	public void setFatN(String fatN) {
		this.fatN = fatN;
	}

	public String getFatS() {
		return this.fatS;
	}

	public void setFatS(String fatS) {
		this.fatS = fatS;
	}

	public String getJ1kftbus() {
		return this.j1kftbus;
	}

	public void setJ1kftbus(String j1kftbus) {
		this.j1kftbus = j1kftbus;
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

	public String getPName() {
		return this.pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getQuantityKg() {
		return this.quantityKg;
	}

	public void setQuantityKg(String quantityKg) {
		this.quantityKg = quantityKg;
	}

	public String getRName() {
		return this.rName;
	}

	public void setRName(String rName) {
		this.rName = rName;
	}

	public String getRoute() {
		return this.route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getSName() {
		return this.sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public String getSnf() {
		return this.snf;
	}

	public void setSnf(String snf) {
		this.snf = snf;
	}

	public String getSnfE() {
		return this.snfE;
	}

	public void setSnfE(String snfE) {
		this.snfE = snfE;
	}

	public String getSnfN() {
		return this.snfN;
	}

	public void setSnfN(String snfN) {
		this.snfN = snfN;
	}

	public String getSnfS() {
		return this.snfS;
	}

	public void setSnfS(String snfS) {
		this.snfS = snfS;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTsN() {
		return this.tsN;
	}

	public void setTsN(String tsN) {
		this.tsN = tsN;
	}

}