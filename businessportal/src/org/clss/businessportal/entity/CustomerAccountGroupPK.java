package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the customer_account_group database table.
 * 
 */
@Embeddable
public class CustomerAccountGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CUSTOMER_ACC_GRP_CODE", unique=true, nullable=false, length=4)
	private String customerAccGrpCode;

	@Column(name="COMP_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String compCode;

	public CustomerAccountGroupPK() {
	}
	public String getCustomerAccGrpCode() {
		return this.customerAccGrpCode;
	}
	public void setCustomerAccGrpCode(String customerAccGrpCode) {
		this.customerAccGrpCode = customerAccGrpCode;
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomerAccountGroupPK)) {
			return false;
		}
		CustomerAccountGroupPK castOther = (CustomerAccountGroupPK)other;
		return 
			this.customerAccGrpCode.equals(castOther.customerAccGrpCode)
			&& this.compCode.equals(castOther.compCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerAccGrpCode.hashCode();
		hash = hash * prime + this.compCode.hashCode();
		
		return hash;
	}
}