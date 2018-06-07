package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class UserTrackCustomModel implements Serializable  {
	
	private String sessionId;
	private String userId;
	private String userTypeId;
	private String loginIp;
	private String serverIp;
	private String loginDate;
	private String loginTime;
	private String logoutDate;
	private String logoutTime;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogoutDate() {
		return logoutDate;
	}
	public void setLogoutDate(String logoutDate) {
		this.logoutDate = logoutDate;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	@Override
	public String toString() {
		return "UserTrackCustomModel [sessionId=" + sessionId + ", userId=" + userId + ", userTypeId=" + userTypeId
				+ ", loginIp=" + loginIp + ", serverIp=" + serverIp + ", loginDate=" + loginDate + ", loginTime="
				+ loginTime + ", logoutDate=" + logoutDate + ", logoutTime=" + logoutTime + "]";
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	
	
}
