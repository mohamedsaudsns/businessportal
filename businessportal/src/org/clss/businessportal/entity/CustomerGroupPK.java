package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the customer_group database table.
 * 
 */
@Embeddable
public class CustomerGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CUSTOMER_GRP_CODE", unique=true, nullable=false, length=2)
	private String customerGrpCode;

	@Column(name="COMP_CODE", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String compCode;

	public CustomerGroupPK() {
	}
	public String getCustomerGrpCode() {
		return this.customerGrpCode;
	}
	public void setCustomerGrpCode(String customerGrpCode) {
		this.customerGrpCode = customerGrpCode;
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
		if (!(other instanceof CustomerGroupPK)) {
			return false;
		}
		CustomerGroupPK castOther = (CustomerGroupPK)other;
		return 
			this.customerGrpCode.equals(castOther.customerGrpCode)
			&& this.compCode.equals(castOther.compCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerGrpCode.hashCode();
		hash = hash * prime + this.compCode.hashCode();
		
		return hash;
	}
}