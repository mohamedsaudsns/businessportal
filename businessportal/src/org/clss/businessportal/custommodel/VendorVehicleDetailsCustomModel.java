package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class VendorVehicleDetailsCustomModel implements Serializable  {
	
	private String truckNo;
	private String name	;
	private String permitStatus;
	private String rcDate;
	private String crateCapacity;
	private String dieselCardNumber;
	private String vehicleStatus;
	
	
	private String vendorVechileCode;
	private String vehcileModel1;
	private String vehcileModel2;
	public String getTruckNo() {
		return truckNo;
	}
	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPermitStatus() {
		return permitStatus;
	}
	public void setPermitStatus(String permitStatus) {
		this.permitStatus = permitStatus;
	}
	public String getRcDate() {
		return rcDate;
	}
	public void setRcDate(String rcDate) {
		this.rcDate = rcDate;
	}
	public String getCrateCapacity() {
		return crateCapacity;
	}
	public void setCrateCapacity(String crateCapacity) {
		this.crateCapacity = crateCapacity;
	}
	public String getDieselCardNumber() {
		return dieselCardNumber;
	}
	public void setDieselCardNumber(String dieselCardNumber) {
		this.dieselCardNumber = dieselCardNumber;
	}
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public String getVendorVechileCode() {
		return vendorVechileCode;
	}
	public void setVendorVechileCode(String vendorVechileCode) {
		this.vendorVechileCode = vendorVechileCode;
	}
	public String getVehcileModel1() {
		return vehcileModel1;
	}
	public void setVehcileModel1(String vehcileModel1) {
		this.vehcileModel1 = vehcileModel1;
	}
	public String getVehcileModel2() {
		return vehcileModel2;
	}
	public void setVehcileModel2(String vehcileModel2) {
		this.vehcileModel2 = vehcileModel2;
	}
	
	
	
	
}
