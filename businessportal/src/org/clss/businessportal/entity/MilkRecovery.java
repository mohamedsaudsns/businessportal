package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the milk_recovery database table.
 * 
 */
@Entity
@Table(name="milk_recovery")
@NamedQuery(name="MilkRecovery.findAll", query="SELECT m FROM MilkRecovery m")
public class MilkRecovery implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MilkRecoveryPK id;

	@Column(name="ADJ_AMT", precision=10, scale=2)
	private BigDecimal adjAmt;

	@Column(name="ADJ_AMT_DOCNO", length=10)
	private String adjAmtDocno;

	@Column(precision=10, scale=2)
	private BigDecimal amt;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVAL_DATE")
	private Date approvalDate;

	@Column(length=12)
	private String approver;

	@Column(name="BILL_NUM", length=10)
	private String billNum;

	@Column(length=4)
	private String bukrs;

	@Column(name="C_NAME", length=35)
	private String cName;

	@Column(length=5)
	private String clr;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(length=10)
	private String docno;

	@Column(name="F_NAME", length=35)
	private String fName;

	@Column(length=10)
	private String farmer;

	@Column(name="FARMER_TY", length=30)
	private String farmerTy;

	@Column(length=5)
	private String fat;

	@Column(name="J_1KFTBUS", length=30)
	private String j1kftbus;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="LOCAL_CURR", length=5)
	private String localCurr;

	@Column(name="P_CODE")
	private int pCode;

	@Column(length=1)
	private String paid;

	@Column(length=10)
	private String prctr;

	@Column(length=15)
	private String qty;

	@Column(name="QTY_KG", length=15)
	private String qtyKg;

	@Column(name="RECVR_FRM", length=1)
	private String recvrFrm;

	@Column(length=50)
	private String remarks;

	@Column(name="ROUTE_NO", length=6)
	private String routeNo;

	@Column(length=10)
	private String saknr;

	@Column(name="SAP_CREATED_BY", length=12)
	private String sapCreatedBy;

	@Column(name="SAP_STATUS", length=1)
	private String sapStatus;

	@Column(length=5)
	private String snf;

	@Column(length=1)
	private String status;

	@Temporal(TemporalType.DATE)
	private Date tdate;

	@Column(length=10)
	private String transporter;

	@Column(name="TRUCK_NO", length=10)
	private String truckNo;

	@Column(length=5)
	private String uom;

	@Column(name="UOM_KG", length=15)
	private String uomKg;

	public MilkRecovery() {
	}

	public MilkRecoveryPK getId() {
		return this.id;
	}

	public void setId(MilkRecoveryPK id) {
		this.id = id;
	}

	public BigDecimal getAdjAmt() {
		return this.adjAmt;
	}

	public void setAdjAmt(BigDecimal adjAmt) {
		this.adjAmt = adjAmt;
	}

	public String getAdjAmtDocno() {
		return this.adjAmtDocno;
	}

	public void setAdjAmtDocno(String adjAmtDocno) {
		this.adjAmtDocno = adjAmtDocno;
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

	public String getBukrs() {
		return this.bukrs;
	}

	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}

	public String getCName() {
		return this.cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
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

	public String getDocno() {
		return this.docno;
	}

	public void setDocno(String docno) {
		this.docno = docno;
	}

	public String getFName() {
		return this.fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getFarmer() {
		return this.farmer;
	}

	public void setFarmer(String farmer) {
		this.farmer = farmer;
	}

	public String getFarmerTy() {
		return this.farmerTy;
	}

	public void setFarmerTy(String farmerTy) {
		this.farmerTy = farmerTy;
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

	public String getLocalCurr() {
		return this.localCurr;
	}

	public void setLocalCurr(String localCurr) {
		this.localCurr = localCurr;
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

	public String getPrctr() {
		return this.prctr;
	}

	public void setPrctr(String prctr) {
		this.prctr = prctr;
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

	public String getRecvrFrm() {
		return this.recvrFrm;
	}

	public void setRecvrFrm(String recvrFrm) {
		this.recvrFrm = recvrFrm;
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

	public String getSapCreatedBy() {
		return this.sapCreatedBy;
	}

	public void setSapCreatedBy(String sapCreatedBy) {
		this.sapCreatedBy = sapCreatedBy;
	}

	public String getSapStatus() {
		return this.sapStatus;
	}

	public void setSapStatus(String sapStatus) {
		this.sapStatus = sapStatus;
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

	public String getUomKg() {
		return this.uomKg;
	}

	public void setUomKg(String uomKg) {
		this.uomKg = uomKg;
	}

}