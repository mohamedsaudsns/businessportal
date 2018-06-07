package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the milk_incentive database table.
 * 
 */
@Entity
@Table(name="milk_incentive")
@NamedQuery(name="MilkIncentive.findAll", query="SELECT m FROM MilkIncentive m")
public class MilkIncentive implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MilkIncentivePK id;

	private BigDecimal amt;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVAL_DATE")
	private Date approvalDate;

	private String approver;

	@Column(name="BILL_NUM")
	private String billNum;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String docno;

	private String fkimg;

	@Column(name="INC_ARRERS")
	private String incArrers;

	@Column(name="INC_BONUS")
	private BigDecimal incBonus;

	@Column(name="INC_RATE")
	private String incRate;

	@Temporal(TemporalType.DATE)
	@Column(name="INC_VALID_FROM")
	private Date incValidFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="INC_VALID_TO")
	private Date incValidTo;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="LOCAL_CURR")
	private String localCurr;

	private String paid;

	@Column(name="PROCESSED_FLG")
	private String processedFlg;

	private String qty;

	@Column(name="QTY_KG")
	private String qtyKg;

	private String remarks;

	@Column(name="SAP_CREATEDBY")
	private String sapCreatedby;

	@Temporal(TemporalType.DATE)
	@Column(name="SAP_CREATEDON")
	private Date sapCreatedon;

	@Column(name="SAP_STATUS")
	private String sapStatus;

	private String status;

	private String uom;

	@Column(name="UOM_KG")
	private String uomKg;

	public MilkIncentive() {
	}

	public MilkIncentivePK getId() {
		return this.id;
	}

	public void setId(MilkIncentivePK id) {
		this.id = id;
	}

	public BigDecimal getAmt() {
		return this.amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public Date getApprovalDate() {
		return this.approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getApprover() {
		return this.approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getBillNum() {
		return this.billNum;
	}

	public void setBillNum(String billNum) {
		this.billNum = billNum;
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

	public String getDocno() {
		return this.docno;
	}

	public void setDocno(String docno) {
		this.docno = docno;
	}

	public String getFkimg() {
		return this.fkimg;
	}

	public void setFkimg(String fkimg) {
		this.fkimg = fkimg;
	}

	public String getIncArrers() {
		return this.incArrers;
	}

	public void setIncArrers(String incArrers) {
		this.incArrers = incArrers;
	}

	public BigDecimal getIncBonus() {
		return this.incBonus;
	}

	public void setIncBonus(BigDecimal incBonus) {
		this.incBonus = incBonus;
	}

	public String getIncRate() {
		return this.incRate;
	}

	public void setIncRate(String incRate) {
		this.incRate = incRate;
	}

	public Date getIncValidFrom() {
		return this.incValidFrom;
	}

	public void setIncValidFrom(Date incValidFrom) {
		this.incValidFrom = incValidFrom;
	}

	public Date getIncValidTo() {
		return this.incValidTo;
	}

	public void setIncValidTo(Date incValidTo) {
		this.incValidTo = incValidTo;
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

	public String getLocalCurr() {
		return this.localCurr;
	}

	public void setLocalCurr(String localCurr) {
		this.localCurr = localCurr;
	}

	public String getPaid() {
		return this.paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getProcessedFlg() {
		return this.processedFlg;
	}

	public void setProcessedFlg(String processedFlg) {
		this.processedFlg = processedFlg;
	}

	public String getQty() {
		return this.qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getQtyKg() {
		return this.qtyKg;
	}

	public void setQtyKg(String qtyKg) {
		this.qtyKg = qtyKg;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSapCreatedby() {
		return this.sapCreatedby;
	}

	public void setSapCreatedby(String sapCreatedby) {
		this.sapCreatedby = sapCreatedby;
	}

	public Date getSapCreatedon() {
		return this.sapCreatedon;
	}

	public void setSapCreatedon(Date sapCreatedon) {
		this.sapCreatedon = sapCreatedon;
	}

	public String getSapStatus() {
		return this.sapStatus;
	}

	public void setSapStatus(String sapStatus) {
		this.sapStatus = sapStatus;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}