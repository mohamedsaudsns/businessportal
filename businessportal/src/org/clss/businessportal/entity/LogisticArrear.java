package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the logistic_arrear database table.
 * 
 */
@Entity
@Table(name="logistic_arrear")
@NamedQuery(name="LogisticArrear.findAll", query="SELECT l FROM LogisticArrear l")
public class LogisticArrear implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LogisticArrearPK id;

	@Column(precision=10, scale=2)
	private BigDecimal amt;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVAL_DATE")
	private Date approvalDate;

	@Column(length=12)
	private String approver;

	@Column(name="ARREAR_CODE",length=4)
	private String arrearCode;

	@Temporal(TemporalType.DATE)
	@Column(name="ARREAR_DAT")
	private Date arrearDat;

	@Column(name="ARREAR_SHIFT", length=1)
	private String arrearShift;

	@Column(name="BILL_NUM", length=10)
	private String billNum;

	@Column(length=4)
	private String bukrs;

	@Column(name="CREATED_BY", length=12)
	private String createdBy;

	@Column(length=10)
	private String docno;

	@Column(length=10)
	private String kostl;

	@Column(name="LOCAL_CURR", length=5)
	private String localCurr;

	@Column(length=1)
	private String paid;

	@Temporal(TemporalType.DATE)
	@Column(name="POST_DAT")
	private Date postDat;

	@Column(precision=10, scale=2)
	private BigDecimal qty;

	@Column(precision=10, scale=2)
	private BigDecimal rate;

	@Column(length=50)
	private String remarks;

	@Column(name="ROUTE_NO", length=6)
	private String routeNo;

	@Column(length=10)
	private String saknr;

	@Column(length=1)
	private String status;

	@Column(name="T_NAME", length=35)
	private String tName;

	@Temporal(TemporalType.DATE)
	private Date tdate;

	@Column(length=10)
	private String transporter;

	@Column(name="TRUCK_NO", length=10)
	private String truckNo;

	@Column(length=5)
	private String uom;

	public LogisticArrear() {
	}

	public LogisticArrearPK getId() {
		return this.id;
	}

	public void setId(LogisticArrearPK id) {
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

	public String getArrearCode() {
		return this.arrearCode;
	}

	public void setArrearCode(String arrearCode) {
		this.arrearCode = arrearCode;
	}

	public Date getArrearDat() {
		return this.arrearDat;
	}

	public void setArrearDat(Date arrearDat) {
		this.arrearDat = arrearDat;
	}

	public String getArrearShift() {
		return this.arrearShift;
	}

	public void setArrearShift(String arrearShift) {
		this.arrearShift = arrearShift;
	}

	public String getBillNum() {
		return this.billNum;
	}

	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	public String getBukrs() {
		return this.bukrs;
	}

	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDocno() {
		return this.docno;
	}

	public void setDocno(String docno) {
		this.docno = docno;
	}

	public String getKostl() {
		return this.kostl;
	}

	public void setKostl(String kostl) {
		this.kostl = kostl;
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

	public Date getPostDat() {
		return this.postDat;
	}

	public void setPostDat(Date postDat) {
		this.postDat = postDat;
	}

	public BigDecimal getQty() {
		return this.qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRouteNo() {
		return this.routeNo;
	}

	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}

	public String getSaknr() {
		return this.saknr;
	}

	public void setSaknr(String saknr) {
		this.saknr = saknr;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTName() {
		return this.tName;
	}

	public void setTName(String tName) {
		this.tName = tName;
	}

	public Date getTdate() {
		return this.tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public String getTransporter() {
		return this.transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	public String getTruckNo() {
		return this.truckNo;
	}

	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

}