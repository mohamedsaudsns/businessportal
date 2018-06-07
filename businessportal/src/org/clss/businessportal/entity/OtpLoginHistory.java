package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the otp_login_history database table.
 * 
 */
@Entity
@Table(name="otp_login_history")
@NamedQuery(name="OtpLoginHistory.findAll", query="SELECT o FROM OtpLoginHistory o")
public class OtpLoginHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OtpLoginHistoryPK id;

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

	@Column(name="OTP_CODE", length=25)
	private String otpCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OTP_VALID_TIME")
	private Date otpValidTime;

	@Column(length=1)
	private String status;

	public OtpLoginHistory() {
	}

	public OtpLoginHistoryPK getId() {
		return this.id;
	}

	public void setId(OtpLoginHistoryPK id) {
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

	public String getOtpCode() {
		return this.otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	public Date getOtpValidTime() {
		return this.otpValidTime;
	}

	public void setOtpValidTime(Date otpValidTime) {
		this.otpValidTime = otpValidTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}