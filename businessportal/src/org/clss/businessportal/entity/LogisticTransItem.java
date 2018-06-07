package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the logistic_trans_item database table.
 * 
 */
@Entity
@Table(name="logistic_trans_item")
@NamedQuery(name="LogisticTransItem.findAll", query="SELECT l FROM LogisticTransItem l")
public class LogisticTransItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LogisticTransItemPK id;

	@Column(length=10)
	private String ebeln;

	@Column(precision=10, scale=2)
	private BigDecimal erfmg;

	@Column(name="FIXED_KM_RATE", precision=10, scale=2)
	private BigDecimal fixedKmRate;

	@Column(name="KM_RATE", precision=10, scale=2)
	private BigDecimal kmRate;

	@Column(name="LTR_RATE", precision=10, scale=2)
	private BigDecimal ltrRate;

	@Column(length=30)
	private String name;
	
	@Column(name="ROUTE_DESCR", length=40)
	private String routeDescr;

	@Column(name="SO_DIS", precision=10, scale=2)
	private BigDecimal soDis;

	@Column(precision=10, scale=2)
	private BigDecimal total;

	@Column(name="TOTAL_KM", precision=10, scale=2)
	private BigDecimal totalKm;

	@Column(name="TOTAL_LTR", precision=10, scale=2)
	private BigDecimal totalLtr;

	@Column(name="TRANS_TYPE", length=10)
	private String transType;

	@Column(name="TRUCK_NO", length=10)
	private String truckNo;
	
	public LogisticTransItem() {
	}

	public LogisticTransItemPK getId() {
		return this.id;
	}

	public void setId(LogisticTransItemPK id) {
		this.id = id;
	}

	public String getEbeln() {
		return this.ebeln;
	}

	public void setEbeln(String ebeln) {
		this.ebeln = ebeln;
	}

	public BigDecimal getErfmg() {
		return this.erfmg;
	}

	public void setErfmg(BigDecimal erfmg) {
		this.erfmg = erfmg;
	}

	public BigDecimal getFixedKmRate() {
		return this.fixedKmRate;
	}

	public void setFixedKmRate(BigDecimal fixedKmRate) {
		this.fixedKmRate = fixedKmRate;
	}

	public BigDecimal getKmRate() {
		return this.kmRate;
	}

	public void setKmRate(BigDecimal kmRate) {
		this.kmRate = kmRate;
	}

	public BigDecimal getLtrRate() {
		return this.ltrRate;
	}

	public void setLtrRate(BigDecimal ltrRate) {
		this.ltrRate = ltrRate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRouteDescr() {
		return routeDescr;
	}

	public void setRouteDescr(String routeDescr) {
		this.routeDescr = routeDescr;
	}

	public BigDecimal getSoDis() {
		return this.soDis;
	}

	public void setSoDis(BigDecimal soDis) {
		this.soDis = soDis;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotalKm() {
		return this.totalKm;
	}

	public void setTotalKm(BigDecimal totalKm) {
		this.totalKm = totalKm;
	}

	public BigDecimal getTotalLtr() {
		return this.totalLtr;
	}

	public void setTotalLtr(BigDecimal totalLtr) {
		this.totalLtr = totalLtr;
	}

	public String getTransType() {
		return this.transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTruckNo() {
		return this.truckNo;
	}

	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}

}