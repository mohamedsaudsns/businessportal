package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class MaterialStockCustomModel implements Serializable  {
	
	private String compCode;
	private String materialCode;
	private String materialName;
	
	private String quantity;

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "MaterialStockCustomModel [compCode=" + compCode + ", materialCode=" + materialCode + ", materialName="
				+ materialName + ", quantity=" + quantity + "]";
	}
	
	
	
}
