package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;



import java.sql.Time;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the user_master database table.
 * 
 */
@Entity
@Table(name="user_master")
@NamedQuery(name="UserMaster.findAll", query="SELECT u FROM UserMaster u")
public class UserMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserMasterPK id;

	@Column(length=200)
	private String address;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="EMAIL_ID", length=100)
	private String emailId;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="MOBILE_NO")
	private String mobileNo;

	@Column(name="OTP_CODE", length=25)
	private String otpCode;

	@Column(name="OTP_GEN_TIME")
	private Time otpGenTime;

	@Column(name="OTP_VALID_TIME")
	private Time otpValidTime;
	
	
	@Column(length=20)
	private String society;
	
	
	@Column(name="ACC_GRP_CODE", length=4)
	private String accGrpCode;

	@Column(name="PAN_NO", length=10)
	private String panNo;

	@Column(nullable=false, length=45)
	private String password;

	@Column(length=1)
	private String status;

	@Column(name="TIME_COUNT")
	private int timeCount;

	@Column(name="USER_NAME", nullable=false, length=100)
	private String userName;
	
	
	
	@Column(name="J_1KFTBUS")
	private String j1kftbus;
	

	//bi-directional many-to-one association to CompanyMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMP_CODE", nullable=false, insertable=false, updatable=false)
	private CompanyMaster companyMaster;

	//bi-directional many-to-one association to UserMenuAssignment
	@OneToMany(mappedBy="userMaster")
	private List<UserMenuAssignment> userMenuAssignments;

	public UserMaster() {
	}

	public UserMasterPK getId() {
		return this.id;
	}

	public void setId(UserMasterPK id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAccGrpCode() {
		return this.accGrpCode;
	}

	public void setAccGrpCode(String accGrpCode) {
		this.accGrpCode = accGrpCode;
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

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOtpCode() {
		return this.otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	public Time getOtpGenTime() {
		return this.otpGenTime;
	}

	public void setOtpGenTime(Time otpGenTime) {
		this.otpGenTime = otpGenTime;
	}

	public Time getOtpValidTime() {
		return this.otpValidTime;
	}

	public void setOtpValidTime(Time otpValidTime) {
		this.otpValidTime = otpValidTime;
	}

	public String getPanNo() {
		return this.panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTimeCount() {
		return this.timeCount;
	}

	public void setTimeCount(int timeCount) {
		this.timeCount = timeCount;
	}

	public String getSociety() {
		return this.society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	
	public String getJ1kftbus() {
		return this.j1kftbus;
	}

	public void setJ1kftbus(String j1kftbus) {
		this.j1kftbus = j1kftbus;
	}
	
	
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public CompanyMaster getCompanyMaster() {
		return this.companyMaster;
	}

	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
	}

	public List<UserMenuAssignment> getUserMenuAssignments() {
		return this.userMenuAssignments;
	}

	public void setUserMenuAssignments(List<UserMenuAssignment> userMenuAssignments) {
		this.userMenuAssignments = userMenuAssignments;
	}

	public UserMenuAssignment addUserMenuAssignment(UserMenuAssignment userMenuAssignment) {
		getUserMenuAssignments().add(userMenuAssignment);
		userMenuAssignment.setUserMaster(this);

		return userMenuAssignment;
	}

	public UserMenuAssignment removeUserMenuAssignment(UserMenuAssignment userMenuAssignment) {
		getUserMenuAssignments().remove(userMenuAssignment);
		userMenuAssignment.setUserMaster(null);

		return userMenuAssignment;
	}

}