package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_menu_assignment database table.
 * 
 */
@Entity
@Table(name="user_menu_assignment")
@NamedQuery(name="UserMenuAssignment.findAll", query="SELECT u FROM UserMenuAssignment u")
public class UserMenuAssignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserMenuAssignmentPK id;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(length=1)
	private String status;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="COMP_CODE", referencedColumnName="COMP_CODE", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="USER_ID", referencedColumnName="USER_ID", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="USER_TYPE_ID", referencedColumnName="USER_TYPE_ID", nullable=false, insertable=false, updatable=false)
		})
	private UserMaster userMaster;

	public UserMenuAssignment() {
	}

	public UserMenuAssignmentPK getId() {
		return this.id;
	}

	public void setId(UserMenuAssignmentPK id) {
		this.id = id;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}