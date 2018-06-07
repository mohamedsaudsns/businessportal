package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the agreement_li database table.
 * 
 */
@Entity
@Table(name="agreement_li")
@NamedQuery(name="AgreementLi.findAll", query="SELECT a FROM AgreementLi a")
public class AgreementLi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AgreementLiPK id;

	@Column(name="ACTIVITY_NAME", length=100)
	private String activityName;

	@Column(name="ACTIVITY_TYPE", length=45)
	private String activityType;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_END_DATE")
	private Date actualEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_START_DATE")
	private Date actualStartDate;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="CUR_ADVANCE", precision=13, scale=2)
	private BigDecimal curAdvance;

	@Column(name="CUR_RENT", precision=13, scale=2)
	private BigDecimal curRent;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="NO_OF_PERIOD", length=4)
	private String noOfPeriod;

	@Column(name="PRV_ADANCE", precision=13, scale=2)
	private BigDecimal prvAdance;

	@Column(name="PRV_RENT", precision=13, scale=2)
	private BigDecimal prvRent;

	@Temporal(TemporalType.DATE)
	@Column(name="RENEWAL_DATE")
	private Date renewalDate;

	@Column(name="REQUEST_NO", length=45)
	private String requestNo;

	@Column(length=1)
	private String status;

	//bi-directional many-to-one association to AgreementHa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="AGREEMENT_NO", referencedColumnName="AGREEMENT_NO", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="COMP_CODE", referencedColumnName="COMP_CODE", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="FISCAL_YEAR", referencedColumnName="FISCAL_YEAR", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="VENDOR_CODE", referencedColumnName="VENDOR_CODE", nullable=false, insertable=false, updatable=false)
		})
	private AgreementHa agreementHa;

	public AgreementLi() {
	}

	public AgreementLiPK getId() {
		return this.id;
	}

	public void setId(AgreementLiPK id) {
		this.id = id;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityType() {
		return this.activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public Date getActualEndDate() {
		return this.actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public Date getActualStartDate() {
		return this.actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
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

	public BigDecimal getCurAdvance() {
		return this.curAdvance;
	}

	public void setCurAdvance(BigDecimal curAdvance) {
		this.curAdvance = curAdvance;
	}

	public BigDecimal getCurRent() {
		return this.curRent;
	}

	public void setCurRent(BigDecimal curRent) {
		this.curRent = curRent;
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

	public String getNoOfPeriod() {
		return this.noOfPeriod;
	}

	public void setNoOfPeriod(String noOfPeriod) {
		this.noOfPeriod = noOfPeriod;
	}

	public BigDecimal getPrvAdance() {
		return this.prvAdance;
	}

	public void setPrvAdance(BigDecimal prvAdance) {
		this.prvAdance = prvAdance;
	}

	public BigDecimal getPrvRent() {
		return this.prvRent;
	}

	public void setPrvRent(BigDecimal prvRent) {
		this.prvRent = prvRent;
	}

	public Date getRenewalDate() {
		return this.renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}

	public String getRequestNo() {
		return this.requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AgreementHa getAgreementHa() {
		return this.agreementHa;
	}

	public void setAgreementHa(AgreementHa agreementHa) {
		this.agreementHa = agreementHa;
	}

}