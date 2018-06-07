package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the milk_payment_li database table.
 * 
 */
@Entity
@Table(name="milk_payment_li")
@NamedQuery(name="MilkPaymentLi.findAll", query="SELECT m FROM MilkPaymentLi m")
public class MilkPaymentLi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MilkPaymentLiPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="APP_DATE")
	private Date appDate;

	@Column(name="APP_USER_NAME", length=12)
	private String appUserName;

	@Column(length=1)
	private String approved;

	@Column(name="BILL_NUM", length=10)
	private String billNum;

	@Column(name="BOX_NUMBER", length=3)
	private String boxNumber;

	@Column(length=5)
	private String clr;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(precision=10, scale=2)
	private BigDecimal dmbtr;

	@Column(name="F_J_1KFTBUS", length=30)
	private String fJ1kftbus;

	@Column(length=5)
	private String fat;

	@Column(name="J_1KFTBUS", length=30)
	private String j1kftbus;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="NET_PRICE", precision=10, scale=2)
	private BigDecimal netPrice;

	@Column(name="P_CODE")
	private int pCode;

	@Column(length=1)
	private String paid;

	@Column(length=1)
	private String processed;

	@Column(length=15)
	private String quantity;

	@Column(name="QUANTITY_KG", length=15)
	private String quantityKg;

	@Column(length=5)
	private String snf;

	@Column(length=1)
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	@Column(length=5)
	private String uom;

	@Column(name="UOM_KG", length=3)
	private String uomKg;

	@Column(name="USER_NAME", length=12)
	private String userName;

	public MilkPaymentLi() {
	}

	public MilkPaymentLiPK getId() {
		return this.id;
	}

	public void setId(MilkPaymentLiPK id) {
		this.id = id;
	}

	public Date getAppDate() {
		return this.appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public String getAppUserName() {
		return this.appUserName;
	}

	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}

	public String getApproved() {
		return this.approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getBillNum() {
		return this.billNum;
	}

	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	public String getBoxNumber() {
		return this.boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public String getClr() {
		return this.clr;
	}

	public void setClr(String clr) {
		this.clr = clr;
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

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getDmbtr() {
		return this.dmbtr;
	}

	public void setDmbtr(BigDecimal dmbtr) {
		this.dmbtr = dmbtr;
	}

	public String getFJ1kftbus() {
		return this.fJ1kftbus;
	}

	public void setFJ1kftbus(String fJ1kftbus) {
		this.fJ1kftbus = fJ1kftbus;
	}

	public String getFat() {
		return this.fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
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

	public BigDecimal getNetPrice() {
		return this.netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public int getPCode() {
		return this.pCode;
	}

	public void setPCode(int pCode) {
		this.pCode = pCode;
	}

	public String getPaid() {
		return this.paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getProcessed() {
		return this.processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
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

	public String getSnf() {
		return this.snf;
	}

	public void setSnf(String snf) {
		this.snf = snf;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getUomKg() {
		return this.uomKg;
	}

	public void setUomKg(String uomKg) {
		this.uomKg = uomKg;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}