package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the fleet_card_master database table.
 * 
 */
@Entity
@Table(name="fleet_card_master")
@NamedQuery(name="FleetCardMaster.findAll", query="SELECT f FROM FleetCardMaster f")
public class FleetCardMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FLEET_CARD")
	private String fleetCard;

	@Column(name="CARD_TYPE")
	private String cardType;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DUE_DAYS")
	private String dueDays;

	private String expgl;

	@Column(name="IOC_LIFNR")
	private String iocLifnr;

	private String kostl;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String lastchanged;

	private String lifnr;

	private String prctr;

	private String status;

	private String umskz;

	@Column(name="VEH_NO")
	private String vehNo;

	@Column(name="VEH_TYPE")
	private String vehType;

	private String vendstat;

	public FleetCardMaster() {
	}

	public String getFleetCard() {
		return this.fleetCard;
	}

	public void setFleetCard(String fleetCard) {
		this.fleetCard = fleetCard;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
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

	public String getDueDays() {
		return this.dueDays;
	}

	public void setDueDays(String dueDays) {
		this.dueDays = dueDays;
	}

	public String getExpgl() {
		return this.expgl;
	}

	public void setExpgl(String expgl) {
		this.expgl = expgl;
	}

	public String getIocLifnr() {
		return this.iocLifnr;
	}

	public void setIocLifnr(String iocLifnr) {
		this.iocLifnr = iocLifnr;
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

	public String getLastchanged() {
		return this.lastchanged;
	}

	public void setLastchanged(String lastchanged) {
		this.lastchanged = lastchanged;
	}

	public String getLifnr() {
		return this.lifnr;
	}

	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}

	public String getPrctr() {
		return this.prctr;
	}

	public void setPrctr(String prctr) {
		this.prctr = prctr;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUmskz() {
		return this.umskz;
	}

	public void setUmskz(String umskz) {
		this.umskz = umskz;
	}

	public String getVehNo() {
		return this.vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public String getVehType() {
		return this.vehType;
	}

	public void setVehType(String vehType) {
		this.vehType = vehType;
	}

	public String getVendstat() {
		return this.vendstat;
	}

	public void setVendstat(String vendstat) {
		this.vendstat = vendstat;
	}

}