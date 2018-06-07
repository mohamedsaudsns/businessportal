package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_access database table.
 * 
 */
@Entity
@Table(name="role_access")
@NamedQuery(name="RoleAccess.findAll", query="SELECT r FROM RoleAccess r")
public class RoleAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoleAccessPK id;

	@Column(length=1)
	private String block;

	public RoleAccess() {
	}

	public RoleAccessPK getId() {
		return this.id;
	}

	public void setId(RoleAccessPK id) {
		this.id = id;
	}

	public String getBlock() {
		return this.block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

}