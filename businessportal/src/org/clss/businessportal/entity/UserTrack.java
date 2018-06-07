package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;



import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the user_track database table.
 * 
 */
@Entity
@Table(name="user_track")
@NamedQuery(name="UserTrack.findAll", query="SELECT u FROM UserTrack u")
public class UserTrack implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserTrackPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="LOGGED_DATE")
	private Date loggedDate;

	@Temporal(TemporalType.TIME)
	@Column(name="LOGGED_TIME")
	private Date loggedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="LOGIN_DATE")
	private Date loginDate;

	@Column(name="LOGIN_IP")
	private String loginIp;

	@Temporal(TemporalType.TIME)
	@Column(name="LOGIN_TIME")
	private Date loginTime;

	@Column(name="SERVER_IP")
	private String serverIp;

	@Column(name="USER_TYPE_ID")
	private int userTypeId;
	
	@Column(name="USER_FLAG")
	private String userFlag;
	


	public UserTrack() {
	}

	public UserTrackPK getId() {
		return this.id;
	}

	public void setId(UserTrackPK id) {
		this.id = id;
	}

	public Date getLoggedDate() {
		return this.loggedDate;
	}

	public void setLoggedDate(Date loggedDate) {
		this.loggedDate = loggedDate;
	}

	public Date getLoggedTime() {
		return this.loggedTime;
	}

	public void setLoggedTime(Date loggedTime) {
		this.loggedTime = loggedTime;
	}

	public Date getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getServerIp() {
		return this.serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public int getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}	
	public String getUserFlag() {
		return this.userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}	

}

