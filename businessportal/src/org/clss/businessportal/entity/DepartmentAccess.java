package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the department_access database table.
 * 
 */
@Entity
@Table(name="department_access")
@NamedQuery(name="DepartmentAccess.findAll", query="SELECT d FROM DepartmentAccess d")
public class DepartmentAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DepartmentAccessPK id;

	@Column(length=1)
	private String block;

	public DepartmentAccess() {
	}

	public DepartmentAccessPK getId() {
		return this.id;
	}

	public void setId(DepartmentAccessPK id) {
		this.id = id;
	}

	public String getBlock() {
		return this.block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

}