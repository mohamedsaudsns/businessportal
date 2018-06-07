package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the logistic_trans_header database table.
 * 
 */
@Entity
@Table(name="logistic_trans_header")
@NamedQuery(name="LogisticTransHeader.findAll", query="SELECT l FROM LogisticTransHeader l")
public class LogisticTransHeader implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LogisticTransHeaderPK id;

	@Column(name="ACT_DED", precision=10, scale=2)
	private BigDecimal actDed;

	@Column(precision=10, scale=2)
	private BigDecimal arrears;

	@Column(precision=10, scale=2)
	private BigDecimal deduction;

	@Column(name="GROSS_AMT", precision=10, scale=2)
	private BigDecimal grossAmt;

	@Column(name="INIT_AMT", precision=10, scale=2)
	private BigDecimal initAmt;

	@Column(name="NET_AMT", precision=10, scale=2)
	private BigDecimal netAmt;

	@Column(name="PAID_BY", length=25)
	private String paidBy;

	@Temporal(TemporalType.DATE)
	@Column(name="PAID_DAT")
	private Date paidDat;

	@Column(precision=10, scale=2)
	private BigDecimal recoveries;

	@Column(name="TRANSPORTER_DESC", length=50)
	private String transporterDesc;

	@Column(length=10)
	private String vehicle;

	public LogisticTransHeader() {
	}

	public LogisticTransHeaderPK getId() {
		return this.id;
	}

	public void setId(LogisticTransHeaderPK id) {
		this.id = id;
	}

	public BigDecimal getActDed() {
		return this.actDed;
	}

	public void setActDed(BigDecimal actDed) {
		this.actDed = actDed;
	}

	public BigDecimal getArrears() {
		return this.arrears;
	}

	public void setArrears(BigDecimal arrears) {
		this.arrears = arrears;
	}

	public BigDecimal getDeduction() {
		return this.deduction;
	}

	public void setDeduction(BigDecimal deduction) {
		this.deduction = deduction;
	}

	public BigDecimal getGrossAmt() {
		return this.grossAmt;
	}

	public void setGrossAmt(BigDecimal grossAmt) {
		this.grossAmt = grossAmt;
	}

	public BigDecimal getInitAmt() {
		return this.initAmt;
	}

	public void setInitAmt(BigDecimal initAmt) {
		this.initAmt = initAmt;
	}

	public BigDecimal getNetAmt() {
		return this.netAmt;
	}

	public void setNetAmt(BigDecimal netAmt) {
		this.netAmt = netAmt;
	}

	public String getPaidBy() {
		return this.paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	public Date getPaidDat() {
		return this.paidDat;
	}

	public void setPaidDat(Date paidDat) {
		this.paidDat = paidDat;
	}

	public BigDecimal getRecoveries() {
		return this.recoveries;
	}

	public void setRecoveries(BigDecimal recoveries) {
		this.recoveries = recoveries;
	}

	public String getTransporterDesc() {
		return this.transporterDesc;
	}

	public void setTransporterDesc(String transporterDesc) {
		this.transporterDesc = transporterDesc;
	}

	public String getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

}