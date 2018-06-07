package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the sap_logon database table.
 * 
 */
@Entity
@Table(name="sap_logon")
@NamedQuery(name="SapLogon.findAll", query="SELECT s FROM SapLogon s")
public class SapLogon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SAP_CLIENT", unique=true, nullable=false, length=3)
	private String sapClient;

	@Column(length=50)
	private String hostname;

	@Column(length=4)
	private String language;

	@Column(length=20)
	private String password;

	@Column(name="SCHEDULE_TIME")
	private Time scheduleTime;

	@Column(length=1)
	private String status;

	@Column(name="SYS_ID", length=4)
	private String sysId;

	@Column(name="SYS_NUM", length=2)
	private String sysNum;

	@Column(nullable=false, length=20)
	private String userid;

	public SapLogon() {
	}

	public String getSapClient() {
		return this.sapClient;
	}

	public void setSapClient(String sapClient) {
		this.sapClient = sapClient;
	}

	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Time getScheduleTime() {
		return this.scheduleTime;
	}

	public void setScheduleTime(Time scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSysId() {
		return this.sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String getSysNum() {
		return this.sysNum;
	}

	public void setSysNum(String sysNum) {
		this.sysNum = sysNum;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}