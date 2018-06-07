package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the super_role_access database table.
 * 
 */
@Entity
@Table(name="super_role_access")
@NamedQuery(name="SuperRoleAccess.findAll", query="SELECT s FROM SuperRoleAccess s")
public class SuperRoleAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SuperRoleAccessPK id;

	private String block;

	public SuperRoleAccess() {
	}

	public SuperRoleAccessPK getId() {
		return this.id;
	}

	public void setId(SuperRoleAccessPK id) {
		this.id = id;
	}

	public String getBlock() {
		return this.block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

}