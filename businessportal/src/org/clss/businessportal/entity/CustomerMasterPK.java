package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the customer_master database table.
 * 
 */
@Embeddable
public class CustomerMasterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="CUSTOMER_CODE", unique=true, nullable=false, length=10)
	private String customerCode;

	public CustomerMasterPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getCustomerCode() {
		return this.customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomerMasterPK)) {
			return false;
		}
		CustomerMasterPK castOther = (CustomerMasterPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& this.customerCode.equals(castOther.customerCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.customerCode.hashCode();
		
		return hash;
	}
}