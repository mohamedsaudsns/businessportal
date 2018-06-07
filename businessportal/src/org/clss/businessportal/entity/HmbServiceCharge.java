package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the hmb_service_charges database table.
 * 
 */
@Entity
@Table(name="hmb_service_charges")
@NamedQuery(name="HmbServiceCharge.findAll", query="SELECT h FROM HmbServiceCharge h")
public class HmbServiceCharge implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HmbServiceChargePK id;

	@Column(name="ACT_DED", precision=10, scale=2)
	private BigDecimal actDed;

	@Column(name="ACT_NO_OF_DAYS", length=2)
	private String actNoOfDays;

	@Column(name="ADLT_COMM", precision=10, scale=2)
	private BigDecimal adltComm;

	@Column(name="ARREAR_AMT", precision=10, scale=2)
	private BigDecimal arrearAmt;

	@Column(name="AVG_QTY", length=12)
	private String avgQty;

	@Column(name="CENTER_EB", precision=10, scale=2)
	private BigDecimal centerEb;

	@Column(name="CENTER_RENT", precision=10, scale=2)
	private BigDecimal centerRent;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(precision=10, scale=2)
	private BigDecimal deductions;

	@Column(length=10)
	private String docno;

	@Column(name="DOCNO_NON_TDS", length=10)
	private String docnoNonTds;

	@Column(name="FEED_AMT", precision=10, scale=2)
	private BigDecimal feedAmt;

	@Column(name="FIELD_INCENTIVE", precision=10, scale=2)
	private BigDecimal fieldIncentive;

	@Column(name="INC_AMT", precision=10, scale=2)
	private BigDecimal incAmt;

	@Column(name="INC_AMT_INCHARGE", precision=10, scale=2)
	private BigDecimal incAmtIncharge;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="LOAN_INCENTIVE1", precision=10, scale=2)
	private BigDecimal loanIncentive1;

	@Column(name="LOCAL_CURR", length=5)
	private String localCurr;

	@Column(name="NET_AMT", length=16)
	private String netAmt;

	@Column(name="NO_OF_DAYS", length=2)
	private String noOfDays;

	@Column(length=1)
	private String payee;

	@Column(name="POST_BY", length=12)
	private String postBy;

	@Temporal(TemporalType.DATE)
	@Column(name="POST_DAT")
	private Date postDat;

	@Column(name="QTY_ASSU", precision=10, scale=2)
	private BigDecimal qtyAssu;

	@Column(name="QTY_COMM", precision=10, scale=2)
	private BigDecimal qtyComm;

	@Column(name="SAMPLE_MILK_AMT", precision=10, scale=2)
	private BigDecimal sampleMilkAmt;

	@Column(name="SMS_AMT", precision=10, scale=2)
	private BigDecimal smsAmt;

	@Column(name="SPIL_COMM", precision=10, scale=2)
	private BigDecimal spilComm;

	@Column(length=1)
	private String status;

	@Column(name="TDS_ARREAR", precision=10, scale=2)
	private BigDecimal tdsArrear;

	@Column(name="TDS_DED", precision=10, scale=2)
	private BigDecimal tdsDed;

	@Column(name="TDS_INCENTIVE", precision=10, scale=2)
	private BigDecimal tdsIncentive;

	@Column(name="TDS_PERC", length=10)
	private String tdsPerc;

	@Column(name="TEST_COMM", precision=10, scale=2)
	private BigDecimal testComm;

	@Column(name="TEST_SAMPLE", precision=10, scale=2)
	private BigDecimal testSample;

	@Column(precision=10, scale=2)
	private BigDecimal total;

	@Column(name="TOTAL_TDS", precision=10, scale=2)
	private BigDecimal totalTds;

	@Column(name="TRANSFER_BY", length=12)
	private String transferBy;

	@Temporal(TemporalType.DATE)
	@Column(name="TRANSFER_DAT")
	private Date transferDat;

	@Column(name="TS_COMM", precision=10, scale=2)
	private BigDecimal tsComm;

	@Column(name="TS_TALLY", precision=10, scale=2)
	private BigDecimal tsTally;

	@Column(name="UOM_KG", length=5)
	private String uomKg;

	@Column(name="WHT_CODE", length=2)
	private String whtCode;

	@Column(name="WHT_TYPE", length=2)
	private String whtType;

	public HmbServiceCharge() {
	}

	public HmbServiceChargePK getId() {
		return this.id;
	}

	public void setId(HmbServiceChargePK id) {
		this.id = id;
	}

	public BigDecimal getActDed() {
		return this.actDed;
	}

	public void setActDed(BigDecimal actDed) {
		this.actDed = actDed;
	}

	public String getActNoOfDays() {
		return this.actNoOfDays;
	}

	public void setActNoOfDays(String actNoOfDays) {
		this.actNoOfDays = actNoOfDays;
	}

	public BigDecimal getAdltComm() {
		return this.adltComm;
	}

	public void setAdltComm(BigDecimal adltComm) {
		this.adltComm = adltComm;
	}

	public BigDecimal getArrearAmt() {
		return this.arrearAmt;
	}

	public void setArrearAmt(BigDecimal arrearAmt) {
		this.arrearAmt = arrearAmt;
	}

	public String getAvgQty() {
		return this.avgQty;
	}

	public void setAvgQty(String avgQty) {
		this.avgQty = avgQty;
	}

	public BigDecimal getCenterEb() {
		return this.centerEb;
	}

	public void setCenterEb(BigDecimal centerEb) {
		this.centerEb = centerEb;
	}

	public BigDecimal getCenterRent() {
		return this.centerRent;
	}

	public void setCenterRent(BigDecimal centerRent) {
		this.centerRent = centerRent;
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

	public BigDecimal getDeductions() {
		return this.deductions;
	}

	public void setDeductions(BigDecimal deductions) {
		this.deductions = deductions;
	}

	public String getDocno() {
		return this.docno;
	}

	public void setDocno(String docno) {
		this.docno = docno;
	}

	public String getDocnoNonTds() {
		return this.docnoNonTds;
	}

	public void setDocnoNonTds(String docnoNonTds) {
		this.docnoNonTds = docnoNonTds;
	}

	public BigDecimal getFeedAmt() {
		return this.feedAmt;
	}

	public void setFeedAmt(BigDecimal feedAmt) {
		this.feedAmt = feedAmt;
	}

	public BigDecimal getFieldIncentive() {
		return this.fieldIncentive;
	}

	public void setFieldIncentive(BigDecimal fieldIncentive) {
		this.fieldIncentive = fieldIncentive;
	}

	public BigDecimal getIncAmt() {
		return this.incAmt;
	}

	public void setIncAmt(BigDecimal incAmt) {
		this.incAmt = incAmt;
	}

	public BigDecimal getIncAmtIncharge() {
		return this.incAmtIncharge;
	}

	public void setIncAmtIncharge(BigDecimal incAmtIncharge) {
		this.incAmtIncharge = incAmtIncharge;
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

	public BigDecimal getLoanIncentive1() {
		return this.loanIncentive1;
	}

	public void setLoanIncentive1(BigDecimal loanIncentive1) {
		this.loanIncentive1 = loanIncentive1;
	}

	public String getLocalCurr() {
		return this.localCurr;
	}

	public void setLocalCurr(String localCurr) {
		this.localCurr = localCurr;
	}

	public String getNetAmt() {
		return this.netAmt;
	}

	public void setNetAmt(String netAmt) {
		this.netAmt = netAmt;
	}

	public String getNoOfDays() {
		return this.noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getPayee() {
		return this.payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getPostBy() {
		return this.postBy;
	}

	public void setPostBy(String postBy) {
		this.postBy = postBy;
	}

	public Date getPostDat() {
		return this.postDat;
	}

	public void setPostDat(Date postDat) {
		this.postDat = postDat;
	}

	public BigDecimal getQtyAssu() {
		return this.qtyAssu;
	}

	public void setQtyAssu(BigDecimal qtyAssu) {
		this.qtyAssu = qtyAssu;
	}

	public BigDecimal getQtyComm() {
		return this.qtyComm;
	}

	public void setQtyComm(BigDecimal qtyComm) {
		this.qtyComm = qtyComm;
	}

	public BigDecimal getSampleMilkAmt() {
		return this.sampleMilkAmt;
	}

	public void setSampleMilkAmt(BigDecimal sampleMilkAmt) {
		this.sampleMilkAmt = sampleMilkAmt;
	}

	public BigDecimal getSmsAmt() {
		return this.smsAmt;
	}

	public void setSmsAmt(BigDecimal smsAmt) {
		this.smsAmt = smsAmt;
	}

	public BigDecimal getSpilComm() {
		return this.spilComm;
	}

	public void setSpilComm(BigDecimal spilComm) {
		this.spilComm = spilComm;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTdsArrear() {
		return this.tdsArrear;
	}

	public void setTdsArrear(BigDecimal tdsArrear) {
		this.tdsArrear = tdsArrear;
	}

	public BigDecimal getTdsDed() {
		return this.tdsDed;
	}

	public void setTdsDed(BigDecimal tdsDed) {
		this.tdsDed = tdsDed;
	}

	public BigDecimal getTdsIncentive() {
		return this.tdsIncentive;
	}

	public void setTdsIncentive(BigDecimal tdsIncentive) {
		this.tdsIncentive = tdsIncentive;
	}

	public String getTdsPerc() {
		return this.tdsPerc;
	}

	public void setTdsPerc(String tdsPerc) {
		this.tdsPerc = tdsPerc;
	}

	public BigDecimal getTestComm() {
		return this.testComm;
	}

	public void setTestComm(BigDecimal testComm) {
		this.testComm = testComm;
	}

	public BigDecimal getTestSample() {
		return this.testSample;
	}

	public void setTestSample(BigDecimal testSample) {
		this.testSample = testSample;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotalTds() {
		return this.totalTds;
	}

	public void setTotalTds(BigDecimal totalTds) {
		this.totalTds = totalTds;
	}

	public String getTransferBy() {
		return this.transferBy;
	}

	public void setTransferBy(String transferBy) {
		this.transferBy = transferBy;
	}

	public Date getTransferDat() {
		return this.transferDat;
	}

	public void setTransferDat(Date transferDat) {
		this.transferDat = transferDat;
	}

	public BigDecimal getTsComm() {
		return this.tsComm;
	}

	public void setTsComm(BigDecimal tsComm) {
		this.tsComm = tsComm;
	}

	public BigDecimal getTsTally() {
		return this.tsTally;
	}

	public void setTsTally(BigDecimal tsTally) {
		this.tsTally = tsTally;
	}

	public String getUomKg() {
		return this.uomKg;
	}

	public void setUomKg(String uomKg) {
		this.uomKg = uomKg;
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