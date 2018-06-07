package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the otp_login_history database table.
 * 
 */
@Embeddable
public class OtpLoginHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COMP_CODE", unique=true, nullable=false, length=10)
	private String compCode;

	@Column(name="USER_ID", unique=true, nullable=false)
	private int userId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OTP_GEN_TIME", unique=true, nullable=false)
	private java.util.Date otpGenTime;

	public OtpLoginHistoryPK() {
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public java.util.Date getOtpGenTime() {
		return this.otpGenTime;
	}
	public void setOtpGenTime(java.util.Date otpGenTime) {
		this.otpGenTime = otpGenTime;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OtpLoginHistoryPK)) {
			return false;
		}
		OtpLoginHistoryPK castOther = (OtpLoginHistoryPK)other;
		return 
			this.compCode.equals(castOther.compCode)
			&& (this.userId == castOther.userId)
			&& this.otpGenTime.equals(castOther.otpGenTime);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compCode.hashCode();
		hash = hash * prime + this.userId;
		hash = hash * prime + this.otpGenTime.hashCode();
		
		return hash;
	}
}