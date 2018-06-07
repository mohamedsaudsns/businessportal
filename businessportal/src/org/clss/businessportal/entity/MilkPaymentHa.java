package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the milk_payment_ha database table.
 * 
 */
@Entity
@Table(name="milk_payment_ha")
@NamedQuery(name="MilkPaymentHa.findAll", query="SELECT m FROM MilkPaymentHa m")
public class MilkPaymentHa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MilkPaymentHaPK id;

	@Column(name="ACT_DED")
	private BigDecimal actDed;

	@Column(name="ADJ_DOC_POST_BY")
	private String adjDocPostBy;

	private BigDecimal arrears;

	@Column(name="AVG_RATE")
	private BigDecimal avgRate;

	private String bankl;

	private String bankn;

	@Column(name="BASIC_MILK")
	private BigDecimal basicMilk;

	@Column(name="BLK_CNT")
	private int blkCnt;

	@Column(name="BUS_TYP")
	private String busTyp;

	@Column(name="C_NAME")
	private String cName;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private BigDecimal deductions;

	private String docno;

	@Column(name="F_NAME")
	private String fName;

	@Column(name="FAR_CNT")
	private int farCnt;

	private String farmer;

	@Column(name="FARMER_TY")
	private String farmerTy;

	@Column(name="FV_CNT")
	private int fvCnt;

	@Column(name="GROSS_AMT")
	private BigDecimal grossAmt;

	@Column(name="HMB_CNT")
	private int hmbCnt;

	private BigDecimal incentive;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String name1;

	@Column(name="NEG_ADJ_DOC_C")
	private String negAdjDocC;

	@Column(name="NEG_ADJ_DOC_F")
	private String negAdjDocF;

	@Temporal(TemporalType.DATE)
	@Column(name="NEG_POST_DATE")
	private Date negPostDate;

	@Column(name="NET_AMT")
	private BigDecimal netAmt;

	@Column(name="P_CODE")
	private int pCode;

	@Column(name="P_SO")
	private int pSo;

	private String payee;

	@Column(name="POST_BY")
	private String postBy;

	@Temporal(TemporalType.DATE)
	@Column(name="POST_DAT")
	private Date postDat;

	private String quantity;

	@Column(name="R_NAME")
	private String rName;

	private BigDecimal recoveries;

	private String remarks;

	private String route;

	private String society;

	private String status;

	public MilkPaymentHa() {
	}

	public MilkPaymentHaPK getId() {
		return this.id;
	}

	public void setId(MilkPaymentHaPK id) {
		this.id = id;
	}

	public BigDecimal getActDed() {
		return this.actDed;
	}

	public void setActDed(BigDecimal actDed) {
		this.actDed = actDed;
	}

	public String getAdjDocPostBy() {
		return this.adjDocPostBy;
	}

	public void setAdjDocPostBy(String adjDocPostBy) {
		this.adjDocPostBy = adjDocPostBy;
	}

	public BigDecimal getArrears() {
		return this.arrears;
	}

	public void setArrears(BigDecimal arrears) {
		this.arrears = arrears;
	}

	public BigDecimal getAvgRate() {
		return this.avgRate;
	}

	public void setAvgRate(BigDecimal avgRate) {
		this.avgRate = avgRate;
	}

	public String getBankl() {
		return this.bankl;
	}

	public void setBankl(String bankl) {
		this.bankl = bankl;
	}

	public String getBankn() {
		return this.bankn;
	}

	public void setBankn(String bankn) {
		this.bankn = bankn;
	}

	public BigDecimal getBasicMilk() {
		return this.basicMilk;
	}

	public void setBasicMilk(BigDecimal basicMilk) {
		this.basicMilk = basicMilk;
	}

	public int getBlkCnt() {
		return this.blkCnt;
	}

	public void setBlkCnt(int blkCnt) {
		this.blkCnt = blkCnt;
	}

	public String getBusTyp() {
		return this.busTyp;
	}

	public void setBusTyp(String busTyp) {
		this.busTyp = busTyp;
	}

	public String getCName() {
		return this.cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
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

	public String getFName() {
		return this.fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public int getFarCnt() {
		return this.farCnt;
	}

	public void setFarCnt(int farCnt) {
		this.farCnt = farCnt;
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

	public int getFvCnt() {
		return this.fvCnt;
	}

	public void setFvCnt(int fvCnt) {
		this.fvCnt = fvCnt;
	}

	public BigDecimal getGrossAmt() {
		return this.grossAmt;
	}

	public void setGrossAmt(BigDecimal grossAmt) {
		this.grossAmt = grossAmt;
	}

	public int getHmbCnt() {
		return this.hmbCnt;
	}

	public void setHmbCnt(int hmbCnt) {
		this.hmbCnt = hmbCnt;
	}

	public BigDecimal getIncentive() {
		return this.incentive;
	}

	public void setIncentive(BigDecimal incentive) {
		this.incentive = incentive;
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

	public String getNegAdjDocC() {
		return this.negAdjDocC;
	}

	public void setNegAdjDocC(String negAdjDocC) {
		this.negAdjDocC = negAdjDocC;
	}

	public String getNegAdjDocF() {
		return this.negAdjDocF;
	}

	public void setNegAdjDocF(String negAdjDocF) {
		this.negAdjDocF = negAdjDocF;
	}

	public Date getNegPostDate() {
		return this.negPostDate;
	}

	public void setNegPostDate(Date negPostDate) {
		this.negPostDate = negPostDate;
	}

	public BigDecimal getNetAmt() {
		return this.netAmt;
	}

	public void setNetAmt(BigDecimal netAmt) {
		this.netAmt = netAmt;
	}

	public int getPCode() {
		return this.pCode;
	}

	public void setPCode(int pCode) {
		this.pCode = pCode;
	}

	public int getPSo() {
		return this.pSo;
	}

	public void setPSo(int pSo) {
		this.pSo = pSo;
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

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRName() {
		return this.rName;
	}

	public void setRName(String rName) {
		this.rName = rName;
	}

	public BigDecimal getRecoveries() {
		return this.recoveries;
	}

	public void setRecoveries(BigDecimal recoveries) {
		this.recoveries = recoveries;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRoute() {
		return this.route;
	}

	public void setRoute(String route) {
		this.route = route;
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