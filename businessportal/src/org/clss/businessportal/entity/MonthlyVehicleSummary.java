package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the monthly_vehicle_summary database table.
 * 
 */
@Entity
@Table(name="monthly_vehicle_summary")
@NamedQuery(name="MonthlyVehicleSummary.findAll", query="SELECT m FROM MonthlyVehicleSummary m")
public class MonthlyVehicleSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MonthlyVehicleSummaryPK id;

	@Column(name="ADDITIONAL_AMOUNT", length=15)
	private String additionalAmount;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DEDUCTION_AMOUNT", length=15)
	private String deductionAmount;

	@Column(length=40)
	private String descripton;

	@Column(name="DISTANCE_TRAVELLED", length=15)
	private String distanceTravelled;

	@Column(name="ENDING_KM", length=15)
	private String endingKm;

	@Column(length=15)
	private String freight;

	@Column(name="FREIGHT_RATE", length=15)
	private String freightRate;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(length=45)
	private String name1;

	@Column(name="PASSING_KM", length=15)
	private String passingKm;

	@Column(name="PAYMENT_VENDOR", length=10)
	private String paymentVendor;

	@Column(length=45)
	private String plant;

	@Column(name="PLANT_DESCRIPTON", length=20)
	private String plantDescripton;

	@Column(length=6)
	private String route;

	@Column(name="ROUTE_DESCRIPTON", length=40)
	private String routeDescripton;

	@Column(name="ROUTE_MASTER_DISTANCE", length=15)
	private String routeMasterDistance;

	@Column(name="SERVICE_AGENT", length=10)
	private String serviceAgent;

	@Temporal(TemporalType.DATE)
	@Column(name="SHIP_COMPLETION_DATE")
	private Date shipCompletionDate;

	@Column(name="SHIPMENT_TYPE", length=4)
	private String shipmentType;

	@Column(name="SPL_PROCESSING_INDICATOR", length=4)
	private String splProcessingIndicator;

	@Column(name="STAGE_FIXED_AMT", length=15)
	private String stageFixedAmt;

	@Column(name="STARTING_KM", length=15)
	private String startingKm;

	@Column(length=1)
	private String status;

	@Column(name="TOLL_FEES", length=15)
	private String tollFees;

	@Column(name="TRUCK_NUMBER", length=10)
	private String truckNumber;

	public MonthlyVehicleSummary() {
	}

	public MonthlyVehicleSummaryPK getId() {
		return this.id;
	}

	public void setId(MonthlyVehicleSummaryPK id) {
		this.id = id;
	}

	public String getAdditionalAmount() {
		return this.additionalAmount;
	}

	public void setAdditionalAmount(String additionalAmount) {
		this.additionalAmount = additionalAmount;
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

	public String getDeductionAmount() {
		return this.deductionAmount;
	}

	public void setDeductionAmount(String deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public String getDescripton() {
		return this.descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	public String getDistanceTravelled() {
		return this.distanceTravelled;
	}

	public void setDistanceTravelled(String distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public String getEndingKm() {
		return this.endingKm;
	}

	public void setEndingKm(String endingKm) {
		this.endingKm = endingKm;
	}

	public String getFreight() {
		return this.freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getFreightRate() {
		return this.freightRate;
	}

	public void setFreightRate(String freightRate) {
		this.freightRate = freightRate;
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

	public String getPassingKm() {
		return this.passingKm;
	}

	public void setPassingKm(String passingKm) {
		this.passingKm = passingKm;
	}

	public String getPaymentVendor() {
		return this.paymentVendor;
	}

	public void setPaymentVendor(String paymentVendor) {
		this.paymentVendor = paymentVendor;
	}

	public String getPlant() {
		return this.plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getPlantDescripton() {
		return this.plantDescripton;
	}

	public void setPlantDescripton(String plantDescripton) {
		this.plantDescripton = plantDescripton;
	}

	public String getRoute() {
		return this.route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getRouteDescripton() {
		return this.routeDescripton;
	}

	public void setRouteDescripton(String routeDescripton) {
		this.routeDescripton = routeDescripton;
	}

	public String getRouteMasterDistance() {
		return this.routeMasterDistance;
	}

	public void setRouteMasterDistance(String routeMasterDistance) {
		this.routeMasterDistance = routeMasterDistance;
	}

	public String getServiceAgent() {
		return this.serviceAgent;
	}

	public void setServiceAgent(String serviceAgent) {
		this.serviceAgent = serviceAgent;
	}

	public Date getShipCompletionDate() {
		return this.shipCompletionDate;
	}

	public void setShipCompletionDate(Date shipCompletionDate) {
		this.shipCompletionDate = shipCompletionDate;
	}

	public String getShipmentType() {
		return this.shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	public String getSplProcessingIndicator() {
		return this.splProcessingIndicator;
	}

	public void setSplProcessingIndicator(String splProcessingIndicator) {
		this.splProcessingIndicator = splProcessingIndicator;
	}

	public String getStageFixedAmt() {
		return this.stageFixedAmt;
	}

	public void setStageFixedAmt(String stageFixedAmt) {
		this.stageFixedAmt = stageFixedAmt;
	}

	public String getStartingKm() {
		return this.startingKm;
	}

	public void setStartingKm(String startingKm) {
		this.startingKm = startingKm;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTollFees() {
		return this.tollFees;
	}

	public void setTollFees(String tollFees) {
		this.tollFees = tollFees;
	}

	public String getTruckNumber() {
		return this.truckNumber;
	}

	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}

}