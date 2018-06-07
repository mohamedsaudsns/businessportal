package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the daily_scheduler_log database table.
 * 
 */
@Entity
@Table(name="daily_scheduler_log")
@NamedQuery(name="DailySchedulerLog.findAll", query="SELECT d FROM DailySchedulerLog d")
public class DailySchedulerLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DailySchedulerLogPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="USER_ID")
	private String userId;

	public DailySchedulerLog() {
	}

	public DailySchedulerLogPK getId() {
		return this.id;
	}

	public void setId(DailySchedulerLogPK id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}