package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the vendor_vehicle_details database table.
 * 
 */
@Entity
@Table(name="vendor_vehicle_details")
@NamedQuery(name="VendorVehicleDetail.findAll", query="SELECT v FROM VendorVehicleDetail v")
public class VendorVehicleDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VendorVehicleDetailPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;

	@Column(name="CRATE_CAPACITY")
	private BigDecimal crateCapacity;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String deletion;

	@Column(name="DIESEL_CARD_NUMBER")
	private String dieselCardNumber;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String name1;

	@Column(name="PAYEE_VENDOR_NAME")
	private String payeeVendorName;

	@Column(name="PAYMENT_VENDOR")
	private String paymentVendor;

	@Column(name="PERMIT_STATUS")
	private String permitStatus;

	private String status;

	@Column(name="SUPPL1_DES")
	private String suppl1Des;

	@Column(name="SUPPL2_DES")
	private String suppl2Des;

	@Column(name="SUPPL3_DES")
	private String suppl3Des;

	@Column(name="SUPPL4_DES")
	private String suppl4Des;

	@Column(name="TRUCK_NUMBER")
	private String truckNumber;

	@Column(name="TRUCK_TYPE")
	private String truckType;

	@Column(name="VEHICLE_TYPE")
	private String vehicleType;

	public VendorVehicleDetail() {
	}

	public VendorVehicleDetailPK getId() {
		return this.id;
	}

	public void setId(VendorVehicleDetailPK id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public BigDecimal getCrateCapacity() {
		return this.crateCapacity;
	}

	public void setCrateCapacity(BigDecimal crateCapacity) {
		this.crateCapacity = crateCapacity;
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

	public String getDeletion() {
		return this.deletion;
	}

	public void setDeletion(String deletion) {
		this.deletion = deletion;
	}

	public String getDieselCardNumber() {
		return this.dieselCardNumber;
	}

	public void setDieselCardNumber(String dieselCardNumber) {
		this.dieselCardNumber = dieselCardNumber;
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

	public String getPayeeVendorName() {
		return this.payeeVendorName;
	}

	public void setPayeeVendorName(String payeeVendorName) {
		this.payeeVendorName = payeeVendorName;
	}

	public String getPaymentVendor() {
		return this.paymentVendor;
	}

	public void setPaymentVendor(String paymentVendor) {
		this.paymentVendor = paymentVendor;
	}

	public String getPermitStatus() {
		return this.permitStatus;
	}

	public void setPermitStatus(String permitStatus) {
		this.permitStatus = permitStatus;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSuppl1Des() {
		return this.suppl1Des;
	}

	public void setSuppl1Des(String suppl1Des) {
		this.suppl1Des = suppl1Des;
	}

	public String getSuppl2Des() {
		return this.suppl2Des;
	}

	public void setSuppl2Des(String suppl2Des) {
		this.suppl2Des = suppl2Des;
	}

	public String getSuppl3Des() {
		return this.suppl3Des;
	}

	public void setSuppl3Des(String suppl3Des) {
		this.suppl3Des = suppl3Des;
	}

	public String getSuppl4Des() {
		return this.suppl4Des;
	}

	public void setSuppl4Des(String suppl4Des) {
		this.suppl4Des = suppl4Des;
	}

	public String getTruckNumber() {
		return this.truckNumber;
	}

	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}

	public String getTruckType() {
		return this.truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

}