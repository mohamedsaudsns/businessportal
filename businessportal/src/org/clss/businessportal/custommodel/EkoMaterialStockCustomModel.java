package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class EkoMaterialStockCustomModel implements Serializable  {
	
	private String plant;
	private String Equipment;
	private String roomNumber;
	
	private String equipmentDescription;
	private String inventoryNumber;
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getEquipment() {
		return Equipment;
	}
	public void setEquipment(String equipment) {
		Equipment = equipment;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getEquipmentDescription() {
		return equipmentDescription;
	}
	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}
	public String getInventoryNumber() {
		return inventoryNumber;
	}
	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}
	@Override
	public String toString() {
		return "EkoMaterialStockCustomModel [plant=" + plant + ", Equipment=" + Equipment + ", roomNumber=" + roomNumber
				+ ", equipmentDescription=" + equipmentDescription + ", inventoryNumber=" + inventoryNumber + "]";
	}

	
	
	
	
}
