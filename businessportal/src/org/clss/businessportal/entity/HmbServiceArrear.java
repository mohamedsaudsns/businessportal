package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the hmb_service_arrear database table.
 * 
 */
@Entity
@Table(name="hmb_service_arrear")
@NamedQuery(name="HmbServiceArrear.findAll", query="SELECT h FROM HmbServiceArrear h")
public class HmbServiceArrear implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HmbServiceArrearPK id;

	private BigDecimal amt;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVAL_DATE")
	private Date approvalDate;

	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="ARRALL_DATE")
	private Date arrallDate;

	@Column(name="ARREAR_CODE")
	private String arrearCode;

	@Column(name="ARREAR_DESC")
	private String arrearDesc;

	@Column(name="BILL_NUM")
	private String billNum;

	private String bukrs;

	@Column(name="CENTER_CODE")
	private String centerCode;

	@Column(name="CENTER_DESC")
	private String centerDesc;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="FI_DOC_NO")
	private String fiDocNo;

	@Column(name="J_1KFTBUS")
	private String j1kftbus;

	private String kostl;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="NET_ARREAR")
	private BigDecimal netArrear;

	@Column(name="PAID_FLG")
	private String paidFlg;

	@Column(name="PERSON_RESP")
	private String personResp;

	private String plant;

	@Column(name="PLANT_DESC")
	private String plantDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="POST_DAT")
	private Date postDat;

	@Column(name="PROFIT_CENTER")
	private String profitCenter;

	@Column(name="REJECTED_BY")
	private String rejectedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="REJECTED_ON")
	private Date rejectedOn;

	private String saknr;

	@Column(name="SAP_CREATED_BY")
	private String sapCreatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="SAP_CREATED_ON")
	private Date sapCreatedOn;

	@Column(name="SAP_STATUS")
	private String sapStatus;

	private String status;

	@Column(name="TDS_PERC")
	private String tdsPerc;

	private String text;

	@Column(name="TOTAL_TDS")
	private BigDecimal totalTds;

	@Temporal(TemporalType.DATE)
	@Column(name="TRANS_DATE")
	private Date transDate;

	@Column(name="WHT_CODE")
	private String whtCode;

	@Column(name="WHT_TYPE")
	private String whtType;

	public HmbServiceArrear() {
	}

	public HmbServiceArrearPK getId() {
		return this.id;
	}

	public void setId(HmbServiceArrearPK id) {
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

	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getArrallDate() {
		return this.arrallDate;
	}

	public void setArrallDate(Date arrallDate) {
		this.arrallDate = arrallDate;
	}

	public String getArrearCode() {
		return this.arrearCode;
	}

	public void setArrearCode(String arrearCode) {
		this.arrearCode = arrearCode;
	}

	public String getArrearDesc() {
		return this.arrearDesc;
	}

	public void setArrearDesc(String arrearDesc) {
		this.arrearDesc = arrearDesc;
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

	public String getCenterCode() {
		return this.centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getCenterDesc() {
		return this.centerDesc;
	}

	public void setCenterDesc(String centerDesc) {
		this.centerDesc = centerDesc;
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

	public String getFiDocNo() {
		return this.fiDocNo;
	}

	public void setFiDocNo(String fiDocNo) {
		this.fiDocNo = fiDocNo;
	}

	public String getJ1kftbus() {
		return this.j1kftbus;
	}

	public void setJ1kftbus(String j1kftbus) {
		this.j1kftbus = j1kftbus;
	}

	public String getKostl() {
		return this.kostl;
	}

	public void setKostl(String kostl) {
		this.kostl = kostl;
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

	public BigDecimal getNetArrear() {
		return this.netArrear;
	}

	public void setNetArrear(BigDecimal netArrear) {
		this.netArrear = netArrear;
	}

	public String getPaidFlg() {
		return this.paidFlg;
	}

	public void setPaidFlg(String paidFlg) {
		this.paidFlg = paidFlg;
	}

	public String getPersonResp() {
		return this.personResp;
	}

	public void setPersonResp(String personResp) {
		this.personResp = personResp;
	}

	public String getPlant() {
		return this.plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getPlantDesc() {
		return this.plantDesc;
	}

	public void setPlantDesc(String plantDesc) {
		this.plantDesc = plantDesc;
	}

	public Date getPostDat() {
		return this.postDat;
	}

	public void setPostDat(Date postDat) {
		this.postDat = postDat;
	}

	public String getProfitCenter() {
		return this.profitCenter;
	}

	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}

	public String getRejectedBy() {
		return this.rejectedBy;
	}

	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public Date getRejectedOn() {
		return this.rejectedOn;
	}

	public void setRejectedOn(Date rejectedOn) {
		this.rejectedOn = rejectedOn;
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

	public Date getSapCreatedOn() {
		return this.sapCreatedOn;
	}

	public void setSapCreatedOn(Date sapCreatedOn) {
		this.sapCreatedOn = sapCreatedOn;
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

	public String getTdsPerc() {
		return this.tdsPerc;
	}

	public void setTdsPerc(String tdsPerc) {
		this.tdsPerc = tdsPerc;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public BigDecimal getTotalTds() {
		return this.totalTds;
	}

	public void setTotalTds(BigDecimal totalTds) {
		this.totalTds = totalTds;
	}

	public Date getTransDate() {
		return this.transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getWhtCode() {
		return this.whtCode;
	}

	public void setWhtCode(String whtCode) {
		this.whtCode = whtCode;
	}

	public String getWhtType() {
		return this.whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

}