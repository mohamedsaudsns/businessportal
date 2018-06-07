package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the milk_avg database table.
 * 
 */
@Entity
@Table(name="milk_avg")
@NamedQuery(name="MilkAvg.findAll", query="SELECT m FROM MilkAvg m")
public class MilkAvg implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MilkAvgPK id;

	private BigDecimal amount;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private BigDecimal dmbtr;

	private String fat;

	@Column(name="FAT_HIGH")
	private String fatHigh;

	@Column(name="FAT_LOW")
	private String fatLow;

	@Column(name="FAT_PER")
	private String fatPer;

	@Column(name="FAT_RN")
	private String fatRn;

	private BigDecimal inc;

	@Column(name="KG_FAT")
	private String kgFat;

	@Column(name="KG_SNF")
	private String kgSnf;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String name1;

	private String quantity;

	@Column(name="QUANTITY_KG")
	private String quantityKg;

	private String sname;

	private String snf;

	@Column(name="SNF_HIGH")
	private String snfHigh;

	@Column(name="SNF_LOW")
	private String snfLow;

	@Column(name="SNF_PER")
	private String snfPer;

	@Column(name="SNF_RN")
	private String snfRn;

	private String status;

	public MilkAvg() {
	}

	public MilkAvgPK getId() {
		return this.id;
	}

	public void setId(MilkAvgPK id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public BigDecimal getDmbtr() {
		return this.dmbtr;
	}

	public void setDmbtr(BigDecimal dmbtr) {
		this.dmbtr = dmbtr;
	}

	public String getFat() {
		return this.fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
	}

	public String getFatHigh() {
		return this.fatHigh;
	}

	public void setFatHigh(String fatHigh) {
		this.fatHigh = fatHigh;
	}

	public String getFatLow() {
		return this.fatLow;
	}

	public void setFatLow(String fatLow) {
		this.fatLow = fatLow;
	}

	public String getFatPer() {
		return this.fatPer;
	}

	public void setFatPer(String fatPer) {
		this.fatPer = fatPer;
	}

	public String getFatRn() {
		return this.fatRn;
	}

	public void setFatRn(String fatRn) {
		this.fatRn = fatRn;
	}

	public BigDecimal getInc() {
		return this.inc;
	}

	public void setInc(BigDecimal inc) {
		this.inc = inc;
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

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSnf() {
		return this.snf;
	}

	public void setSnf(String snf) {
		this.snf = snf;
	}

	public String getSnfHigh() {
		return this.snfHigh;
	}

	public void setSnfHigh(String snfHigh) {
		this.snfHigh = snfHigh;
	}

	public String getSnfLow() {
		return this.snfLow;
	}

	public void setSnfLow(String snfLow) {
		this.snfLow = snfLow;
	}

	public String getSnfPer() {
		return this.snfPer;
	}

	public void setSnfPer(String snfPer) {
		this.snfPer = snfPer;
	}

	public String getSnfRn() {
		return this.snfRn;
	}

	public void setSnfRn(String snfRn) {
		this.snfRn = snfRn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}