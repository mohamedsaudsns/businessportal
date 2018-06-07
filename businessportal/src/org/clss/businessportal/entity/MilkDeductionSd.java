package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the milk_deduction_sd database table.
 * 
 */
@Entity
@Table(name="milk_deduction_sd")
@NamedQuery(name="MilkDeductionSd.findAll", query="SELECT m FROM MilkDeductionSd m")
public class MilkDeductionSd implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MilkDeductionSdPK id;

	@Column(length=10)
	private String belnr;

	@Column(name="BILL_NUM", length=10)
	private String billNum;

	@Column(length=12)
	private String chgby;

	@Temporal(TemporalType.DATE)
	private Date chgon;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DED_DOC", length=10)
	private String dedDoc;

	@Column(length=15)
	private String fklmg;

	@Column(length=10)
	private String kunnr;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(length=10)
	private String lifnr;

	@Column(length=18)
	private String matnr;

	@Column(name="P_AMT", precision=10, scale=2)
	private BigDecimal pAmt;

	@Column(length=1)
	private String paid;

	@Temporal(TemporalType.DATE)
	@Column(name="PAY_DATE")
	private Date payDate;

	@Column(name="S_AMT", precision=10, scale=2)
	private BigDecimal sAmt;

	private int sequence;

	@Column(length=10)
	private String society;

	@Column(length=1)
	private String status;

	@Column(precision=10, scale=2)
	private BigDecimal value;

	@Column(length=4)
	private String werks;

	@Temporal(TemporalType.DATE)
	private Date zappdate;

	@Column(length=12)
	private String zapprby;

	@Column(length=1)
	private String zappsta;

	private int zbillcycle;

	@Column(precision=10, scale=2)
	private BigDecimal zdedamt;

	@Column(length=4)
	private String zdedtype;

	@Column(length=12)
	private String zdelby;

	@Temporal(TemporalType.DATE)
	private Date zdeldate;

	@Column(length=1)
	private String zdelfg;

	@Column(precision=10, scale=2)
	private BigDecimal zemiamt;

	@Column(length=5)
	private String zgroup;

	@Column(length=4)
	private String znoemi;

	@Column(length=12)
	private String zrejby;

	@Temporal(TemporalType.DATE)
	private Date zrejdate;

	@Column(length=40)
	private String zremark1;

	@Column(length=40)
	private String zremark2;

	public MilkDeductionSd() {
	}

	public MilkDeductionSdPK getId() {
		return this.id;
	}

	public void setId(MilkDeductionSdPK id) {
		this.id = id;
	}

	public String getBelnr() {
		return this.belnr;
	}

	public void setBelnr(String belnr) {
		this.belnr = belnr;
	}

	public String getBillNum() {
		return this.billNum;
	}

	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	public String getChgby() {
		return this.chgby;
	}

	public void setChgby(String chgby) {
		this.chgby = chgby;
	}

	public Date getChgon() {
		return this.chgon;
	}

	public void setChgon(Date chgon) {
		this.chgon = chgon;
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

	public String getDedDoc() {
		return this.dedDoc;
	}

	public void setDedDoc(String dedDoc) {
		this.dedDoc = dedDoc;
	}

	public String getFklmg() {
		return this.fklmg;
	}

	public void setFklmg(String fklmg) {
		this.fklmg = fklmg;
	}

	public String getKunnr() {
		return this.kunnr;
	}

	public void setKunnr(String kunnr) {
		this.kunnr = kunnr;
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

	public String getLifnr() {
		return this.lifnr;
	}

	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}

	public String getMatnr() {
		return this.matnr;
	}

	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}

	public BigDecimal getPAmt() {
		return this.pAmt;
	}

	public void setPAmt(BigDecimal pAmt) {
		this.pAmt = pAmt;
	}

	public String getPaid() {
		return this.paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public BigDecimal getSAmt() {
		return this.sAmt;
	}

	public void setSAmt(BigDecimal sAmt) {
		this.sAmt = sAmt;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
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

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getWerks() {
		return this.werks;
	}

	public void setWerks(String werks) {
		this.werks = werks;
	}

	public Date getZappdate() {
		return this.zappdate;
	}

	public void setZappdate(Date zappdate) {
		this.zappdate = zappdate;
	}

	public String getZapprby() {
		return this.zapprby;
	}

	public void setZapprby(String zapprby) {
		this.zapprby = zapprby;
	}

	public String getZappsta() {
		return this.zappsta;
	}

	public void setZappsta(String zappsta) {
		this.zappsta = zappsta;
	}

	public int getZbillcycle() {
		return this.zbillcycle;
	}

	public void setZbillcycle(int zbillcycle) {
		this.zbillcycle = zbillcycle;
	}

	public BigDecimal getZdedamt() {
		return this.zdedamt;
	}

	public void setZdedamt(BigDecimal zdedamt) {
		this.zdedamt = zdedamt;
	}

	public String getZdedtype() {
		return this.zdedtype;
	}

	public void setZdedtype(String zdedtype) {
		this.zdedtype = zdedtype;
	}

	public String getZdelby() {
		return this.zdelby;
	}

	public void setZdelby(String zdelby) {
		this.zdelby = zdelby;
	}

	public Date getZdeldate() {
		return this.zdeldate;
	}

	public void setZdeldate(Date zdeldate) {
		this.zdeldate = zdeldate;
	}

	public String getZdelfg() {
		return this.zdelfg;
	}

	public void setZdelfg(String zdelfg) {
		this.zdelfg = zdelfg;
	}

	public BigDecimal getZemiamt() {
		return this.zemiamt;
	}

	public void setZemiamt(BigDecimal zemiamt) {
		this.zemiamt = zemiamt;
	}

	public String getZgroup() {
		return this.zgroup;
	}

	public void setZgroup(String zgroup) {
		this.zgroup = zgroup;
	}

	public String getZnoemi() {
		return this.znoemi;
	}

	public void setZnoemi(String znoemi) {
		this.znoemi = znoemi;
	}

	public String getZrejby() {
		return this.zrejby;
	}

	public void setZrejby(String zrejby) {
		this.zrejby = zrejby;
	}

	public Date getZrejdate() {
		return this.zrejdate;
	}

	public void setZrejdate(Date zrejdate) {
		this.zrejdate = zrejdate;
	}

	public String getZremark1() {
		return this.zremark1;
	}

	public void setZremark1(String zremark1) {
		this.zremark1 = zremark1;
	}

	public String getZremark2() {
		return this.zremark2;
	}

	public void setZremark2(String zremark2) {
		this.zremark2 = zremark2;
	}

}