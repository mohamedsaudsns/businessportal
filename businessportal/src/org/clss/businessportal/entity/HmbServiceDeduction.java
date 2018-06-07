package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the hmb_service_deduction database table.
 * 
 */
@Entity
@Table(name="hmb_service_deduction")
@NamedQuery(name="HmbServiceDeduction.findAll", query="SELECT h FROM HmbServiceDeduction h")
public class HmbServiceDeduction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HmbServiceDeductionPK id;

	@Column(name="BILL_NUM")
	private String billNum;

	private String bukrs;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="P_AMT")
	private BigDecimal pAmt;

	private String paid;

	private String quantity;

	@Column(name="ROUTE_NO")
	private String routeNo;

	@Column(name="S_AMT")
	private BigDecimal sAmt;

	private String saknr;

	private String status;

	@Column(name="TRUCK_NO")
	private String truckNo;

	private String uom;

	private String werks;

	private BigDecimal zamount;

	@Temporal(TemporalType.DATE)
	private Date zappdate;

	private String zapprby;

	private String zappsta;

	private BigDecimal zbalance;

	private String zbankey;

	private int zbillcycle;

	@Column(name="ZCC_HMB")
	private String zccHmb;

	private String zcustomer;

	private BigDecimal zdedamt;

	private String zdeddoc;

	private String zdedtype;

	private String zdelby;

	@Temporal(TemporalType.DATE)
	private Date zdeldate;

	private String zdelfg;

	@Temporal(TemporalType.DATE)
	private Date zedate;

	private BigDecimal zemiamt;

	private String zloanac;

	private String zloantype;

	private String zprsta;

	private String zrejby;

	@Temporal(TemporalType.DATE)
	private Date zrejdate;

	private String zremark1;

	private String zremark2;

	@Temporal(TemporalType.DATE)
	private Date zsdate;

	private int zsequence;

	private String zvendor;

	private String zwerks;

	public HmbServiceDeduction() {
	}

	public HmbServiceDeductionPK getId() {
		return this.id;
	}

	public void setId(HmbServiceDeductionPK id) {
		this.id = id;
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

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRouteNo() {
		return this.routeNo;
	}

	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}

	public BigDecimal getSAmt() {
		return this.sAmt;
	}

	public void setSAmt(BigDecimal sAmt) {
		this.sAmt = sAmt;
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

	public String getWerks() {
		return this.werks;
	}

	public void setWerks(String werks) {
		this.werks = werks;
	}

	public BigDecimal getZamount() {
		return this.zamount;
	}

	public void setZamount(BigDecimal zamount) {
		this.zamount = zamount;
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

	public BigDecimal getZbalance() {
		return this.zbalance;
	}

	public void setZbalance(BigDecimal zbalance) {
		this.zbalance = zbalance;
	}

	public String getZbankey() {
		return this.zbankey;
	}

	public void setZbankey(String zbankey) {
		this.zbankey = zbankey;
	}

	public int getZbillcycle() {
		return this.zbillcycle;
	}

	public void setZbillcycle(int zbillcycle) {
		this.zbillcycle = zbillcycle;
	}

	public String getZccHmb() {
		return this.zccHmb;
	}

	public void setZccHmb(String zccHmb) {
		this.zccHmb = zccHmb;
	}

	public String getZcustomer() {
		return this.zcustomer;
	}

	public void setZcustomer(String zcustomer) {
		this.zcustomer = zcustomer;
	}

	public BigDecimal getZdedamt() {
		return this.zdedamt;
	}

	public void setZdedamt(BigDecimal zdedamt) {
		this.zdedamt = zdedamt;
	}

	public String getZdeddoc() {
		return this.zdeddoc;
	}

	public void setZdeddoc(String zdeddoc) {
		this.zdeddoc = zdeddoc;
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

	public Date getZedate() {
		return this.zedate;
	}

	public void setZedate(Date zedate) {
		this.zedate = zedate;
	}

	public BigDecimal getZemiamt() {
		return this.zemiamt;
	}

	public void setZemiamt(BigDecimal zemiamt) {
		this.zemiamt = zemiamt;
	}

	public String getZloanac() {
		return this.zloanac;
	}

	public void setZloanac(String zloanac) {
		this.zloanac = zloanac;
	}

	public String getZloantype() {
		return this.zloantype;
	}

	public void setZloantype(String zloantype) {
		this.zloantype = zloantype;
	}

	public String getZprsta() {
		return this.zprsta;
	}

	public void setZprsta(String zprsta) {
		this.zprsta = zprsta;
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

	public Date getZsdate() {
		return this.zsdate;
	}

	public void setZsdate(Date zsdate) {
		this.zsdate = zsdate;
	}

	public int getZsequence() {
		return this.zsequence;
	}

	public void setZsequence(int zsequence) {
		this.zsequence = zsequence;
	}

	public String getZvendor() {
		return this.zvendor;
	}

	public void setZvendor(String zvendor) {
		this.zvendor = zvendor;
	}

	public String getZwerks() {
		return this.zwerks;
	}

	public void setZwerks(String zwerks) {
		this.zwerks = zwerks;
	}

}