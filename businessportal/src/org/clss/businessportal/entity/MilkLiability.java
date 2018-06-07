package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the milk_liability database table.
 * 
 */
@Entity
@Table(name="milk_liability")
@NamedQuery(name="MilkLiability.findAll", query="SELECT m FROM MilkLiability m")
public class MilkLiability implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MilkLiabilityPK id;

	private BigDecimal amt;

	private BigDecimal amt1;

	private BigDecimal amt2;

	@Column(name="CENT_DAYS")
	private String centDays;

	@Column(name="CENT_MILK")
	private String centMilk;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DIFF_QTY_LTR")
	private String diffQtyLtr;

	private BigDecimal dmbtr2;

	private String erfmg;

	@Column(name="ERFMG_LTR")
	private String erfmgLtr;

	private String fat;

	@Column(name="FAT_N")
	private String fatN;

	@Temporal(TemporalType.DATE)
	@Column(name="HMB_MDATE")
	private Date hmbMdate;

	@Column(name="HMB_TYPE")
	private String hmbType;

	@Column(name="J_1KFTBUS")
	private String j1kftbus;

	@Column(name="KG_FAT")
	private String kgFat;

	@Column(name="KG_SNF")
	private String kgSnf;

	@Column(name="KG_TS")
	private String kgTs;

	private String kgfat;

	private String kgsnf;

	private String kgts;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String name1;

	private BigDecimal netamt;

	@Column(name="NO_OF_FARMERS")
	private String noOfFarmers;

	private String quantity;

	@Column(name="QUANTITY_KG")
	private String quantityKg;

	@Column(name="REC_DAYS")
	private String recDays;

	@Column(name="REC_MILK")
	private String recMilk;

	@Temporal(TemporalType.DATE)
	@Column(name="SAP_DATE")
	private Date sapDate;

	private String snf;

	@Column(name="SNF_N")
	private String snfN;

	@Column(name="SOCIETY_DESC")
	private String societyDesc;

	private String status;

	private BigDecimal totamt;

	private String ts;

	@Column(name="TS_N")
	private String tsN;

	public MilkLiability() {
	}

	public MilkLiabilityPK getId() {
		return this.id;
	}

	public void setId(MilkLiabilityPK id) {
		this.id = id;
	}

	public BigDecimal getAmt() {
		return this.amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public BigDecimal getAmt1() {
		return this.amt1;
	}

	public void setAmt1(BigDecimal amt1) {
		this.amt1 = amt1;
	}

	public BigDecimal getAmt2() {
		return this.amt2;
	}

	public void setAmt2(BigDecimal amt2) {
		this.amt2 = amt2;
	}

	public String getCentDays() {
		return this.centDays;
	}

	public void setCentDays(String centDays) {
		this.centDays = centDays;
	}

	public String getCentMilk() {
		return this.centMilk;
	}

	public void setCentMilk(String centMilk) {
		this.centMilk = centMilk;
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

	public String getDiffQtyLtr() {
		return this.diffQtyLtr;
	}

	public void setDiffQtyLtr(String diffQtyLtr) {
		this.diffQtyLtr = diffQtyLtr;
	}

	public BigDecimal getDmbtr2() {
		return this.dmbtr2;
	}

	public void setDmbtr2(BigDecimal dmbtr2) {
		this.dmbtr2 = dmbtr2;
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

	public String getFat() {
		return this.fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
	}

	public String getFatN() {
		return this.fatN;
	}

	public void setFatN(String fatN) {
		this.fatN = fatN;
	}

	public Date getHmbMdate() {
		return this.hmbMdate;
	}

	public void setHmbMdate(Date hmbMdate) {
		this.hmbMdate = hmbMdate;
	}

	public String getHmbType() {
		return this.hmbType;
	}

	public void setHmbType(String hmbType) {
		this.hmbType = hmbType;
	}

	public String getJ1kftbus() {
		return this.j1kftbus;
	}

	public void setJ1kftbus(String j1kftbus) {
		this.j1kftbus = j1kftbus;
	}

	public String getKgFat() {
		return this.kgFat;
	}

	public void setKgFat(String kgFat) {
		this.kgFat = kgFat;
	}

	public String getKgSnf() {
		return this.kgSnf;
	}

	public void setKgSnf(String kgSnf) {
		this.kgSnf = kgSnf;
	}

	public String getKgTs() {
		return this.kgTs;
	}

	public void setKgTs(String kgTs) {
		this.kgTs = kgTs;
	}

	public String getKgfat() {
		return this.kgfat;
	}

	public void setKgfat(String kgfat) {
		this.kgfat = kgfat;
	}

	public String getKgsnf() {
		return this.kgsnf;
	}

	public void setKgsnf(String kgsnf) {
		this.kgsnf = kgsnf;
	}

	public String getKgts() {
		return this.kgts;
	}

	public void setKgts(String kgts) {
		this.kgts = kgts;
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

	public String getName1() {
		return this.name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public BigDecimal getNetamt() {
		return this.netamt;
	}

	public void setNetamt(BigDecimal netamt) {
		this.netamt = netamt;
	}

	public String getNoOfFarmers() {
		return this.noOfFarmers;
	}

	public void setNoOfFarmers(String noOfFarmers) {
		this.noOfFarmers = noOfFarmers;
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

	public String getRecDays() {
		return this.recDays;
	}

	public void setRecDays(String recDays) {
		this.recDays = recDays;
	}

	public String getRecMilk() {
		return this.recMilk;
	}

	public void setRecMilk(String recMilk) {
		this.recMilk = recMilk;
	}

	public Date getSapDate() {
		return this.sapDate;
	}

	public void setSapDate(Date sapDate) {
		this.sapDate = sapDate;
	}

	public String getSnf() {
		return this.snf;
	}

	public void setSnf(String snf) {
		this.snf = snf;
	}

	public String getSnfN() {
		return this.snfN;
	}

	public void setSnfN(String snfN) {
		this.snfN = snfN;
	}

	public String getSocietyDesc() {
		return this.societyDesc;
	}

	public void setSocietyDesc(String societyDesc) {
		this.societyDesc = societyDesc;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotamt() {
		return this.totamt;
	}

	public void setTotamt(BigDecimal totamt) {
		this.totamt = totamt;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getTsN() {
		return this.tsN;
	}

	public void setTsN(String tsN) {
		this.tsN = tsN;
	}

}