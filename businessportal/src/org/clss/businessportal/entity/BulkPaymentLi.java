package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the bulk_payment_li database table.
 * 
 */
@Entity
@Table(name="bulk_payment_li")
@NamedQuery(name="BulkPaymentLi.findAll", query="SELECT b FROM BulkPaymentLi b")
public class BulkPaymentLi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BulkPaymentLiPK id;

	@Column(name="CLR_B")
	private String clrB;

	@Column(name="CLR_C")
	private String clrC;

	@Temporal(TemporalType.DATE)
	private Date crdat;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DMBTR_B")
	private BigDecimal dmbtrB;

	@Column(name="DMBTR_C")
	private BigDecimal dmbtrC;

	private String docno;

	private String farmer;

	@Column(name="FAT_B")
	private String fatB;

	@Column(name="FAT_C")
	private String fatC;

	@Column(name="INCENTIVE_B")
	private BigDecimal incentiveB;

	@Column(name="INCENTIVE_C")
	private BigDecimal incentiveC;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="QTY_B")
	private String qtyB;

	@Column(name="QTY_C")
	private String qtyC;

	@Column(name="QTY_KG_B")
	private String qtyKgB;

	@Column(name="QTY_KG_C")
	private String qtyKgC;

	@Column(name="RATE_B")
	private BigDecimal rateB;

	@Column(name="RATE_C")
	private BigDecimal rateC;

	@Column(name="SNF_B")
	private String snfB;

	@Column(name="SNF_C")
	private String snfC;

	private String society;

	private String status;

	public BulkPaymentLi() {
	}

	public BulkPaymentLiPK getId() {
		return this.id;
	}

	public void setId(BulkPaymentLiPK id) {
		this.id = id;
	}

	public String getClrB() {
		return this.clrB;
	}

	public void setClrB(String clrB) {
		this.clrB = clrB;
	}

	public String getClrC() {
		return this.clrC;
	}

	public void setClrC(String clrC) {
		this.clrC = clrC;
	}

	public Date getCrdat() {
		return this.crdat;
	}

	public void setCrdat(Date crdat) {
		this.crdat = crdat;
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

	public BigDecimal getDmbtrB() {
		return this.dmbtrB;
	}

	public void setDmbtrB(BigDecimal dmbtrB) {
		this.dmbtrB = dmbtrB;
	}

	public BigDecimal getDmbtrC() {
		return this.dmbtrC;
	}

	public void setDmbtrC(BigDecimal dmbtrC) {
		this.dmbtrC = dmbtrC;
	}

	public String getDocno() {
		return this.docno;
	}

	public void setDocno(String docno) {
		this.docno = docno;
	}

	public String getFarmer() {
		return this.farmer;
	}

	public void setFarmer(String farmer) {
		this.farmer = farmer;
	}

	public String getFatB() {
		return this.fatB;
	}

	public void setFatB(String fatB) {
		this.fatB = fatB;
	}

	public String getFatC() {
		return this.fatC;
	}

	public void setFatC(String fatC) {
		this.fatC = fatC;
	}

	public BigDecimal getIncentiveB() {
		return this.incentiveB;
	}

	public void setIncentiveB(BigDecimal incentiveB) {
		this.incentiveB = incentiveB;
	}

	public BigDecimal getIncentiveC() {
		return this.incentiveC;
	}

	public void setIncentiveC(BigDecimal incentiveC) {
		this.incentiveC = incentiveC;
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

	public String getQtyB() {
		return this.qtyB;
	}

	public void setQtyB(String qtyB) {
		this.qtyB = qtyB;
	}

	public String getQtyC() {
		return this.qtyC;
	}

	public void setQtyC(String qtyC) {
		this.qtyC = qtyC;
	}

	public String getQtyKgB() {
		return this.qtyKgB;
	}

	public void setQtyKgB(String qtyKgB) {
		this.qtyKgB = qtyKgB;
	}

	public String getQtyKgC() {
		return this.qtyKgC;
	}

	public void setQtyKgC(String qtyKgC) {
		this.qtyKgC = qtyKgC;
	}

	public BigDecimal getRateB() {
		return this.rateB;
	}

	public void setRateB(BigDecimal rateB) {
		this.rateB = rateB;
	}

	public BigDecimal getRateC() {
		return this.rateC;
	}

	public void setRateC(BigDecimal rateC) {
		this.rateC = rateC;
	}

	public String getSnfB() {
		return this.snfB;
	}

	public void setSnfB(String snfB) {
		this.snfB = snfB;
	}

	public String getSnfC() {
		return this.snfC;
	}

	public void setSnfC(String snfC) {
		this.snfC = snfC;
	}

	public String getSociety() {
		return this.society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}