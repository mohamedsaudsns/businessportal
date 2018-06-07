package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;



import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vendor_master database table.
 * 
 */
@Entity
@Table(name="vendor_master")
@NamedQuery(name="VendorMaster.findAll", query="SELECT v FROM VendorMaster v")
public class VendorMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VendorMasterPK id;

	private String age;

	@Column(name="BULD_SPEC")
	private String buldSpec;

	private String city;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String district;

	@Column(name="DOOR_NO")
	private String doorNo;

	@Column(name="FAMILY_BACK")
	private String familyBack;

	@Column(name="FATHER_OR_HUSBAND_NAME")
	private String fatherOrHusbandName;

	@Column(name="GREEEN_FODDER")
	private String greeenFodder;

	private String landmark;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="LATITUDE_D")
	private String latitudeD;

	@Column(name="LATITUDE_DIR")
	private String latitudeDir;

	@Column(name="LATITUDE_T")
	private String latitudeT;

	@Column(name="LONGITUDE_D")
	private String longitudeD;

	@Column(name="LONGITUDE_DIR")
	private String longitudeDir;

	@Column(name="LONGITUDE_T")
	private String longitudeT;

	@Column(name="MILK_PROTENTIAL")
	private String milkProtential;

	@Column(name="MOBILE_NO_1")
	private String mobileNo1;

	@Column(name="MOBILE_NO_2")
	private String mobileNo2;

	private String name;

	@Column(name="NAME_2")
	private String name2;

	@Column(name="NO_ANIMALS")
	private String noAnimals;

	@Column(name="NO_BUFFALOS")
	private String noBuffalos;

	@Column(name="NO_COWS")
	private String noCows;

	@Column(name="NO_HEIFER")
	private String noHeifer;

	@Column(name="NO_HOUSE_HOLDER")
	private String noHouseHolder;

	@Column(name="NO_HUMAN")
	private String noHuman;

	@Column(name="PAN_NO")
	private String panNo;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	@Column(name="REF_FROM")
	private String refFrom;

	private String society;

	private String status;

	private String street;

	@Column(name="STREET_NAME_1")
	private String streetName1;

	@Column(name="STREET_NAME_2")
	private String streetName2;

	@Column(name="STREET_NAME_3")
	private String streetName3;

	@Column(name="TELEPHONE_NO")
	private String telephoneNo;

	@Column(name="VAR_ANIMALS")
	private String varAnimals;

	@Column(name="VENDOR_ACC_GRP_CODE")
	private String vendorAccGrpCode;

	@Column(name="WATER_FACILITY")
	private String waterFacility;
	
	
	@Column(name="J_1KFTBUS")
	private String j1kftbus;
	

	

	//bi-directional many-to-one association to VendorBankDetail
	@OneToMany(mappedBy="vendorMaster")
	private List<VendorBankDetail> vendorBankDetails;

	//bi-directional many-to-one association to CompanyMaster
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="COMP_CODE", nullable=false, insertable=false, updatable=false)
		private CompanyMaster companyMaster;

		//bi-directional many-to-one association to RegionMaster
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumns({
			@JoinColumn(name="COUNTRY_CODE", referencedColumnName="COUNTRY_CODE"),
			@JoinColumn(name="REGION_CODE", referencedColumnName="REGION_CODE")
			})
		private RegionMaster regionMaster;

	public VendorMaster() {
	}

	public VendorMasterPK getId() {
		return this.id;
	}

	public void setId(VendorMasterPK id) {
		this.id = id;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBuldSpec() {
		return this.buldSpec;
	}

	public void setBuldSpec(String buldSpec) {
		this.buldSpec = buldSpec;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDoorNo() {
		return this.doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getFamilyBack() {
		return this.familyBack;
	}

	public void setFamilyBack(String familyBack) {
		this.familyBack = familyBack;
	}

	public String getFatherOrHusbandName() {
		return this.fatherOrHusbandName;
	}

	public void setFatherOrHusbandName(String fatherOrHusbandName) {
		this.fatherOrHusbandName = fatherOrHusbandName;
	}

	public String getGreeenFodder() {
		return this.greeenFodder;
	}

	public void setGreeenFodder(String greeenFodder) {
		this.greeenFodder = greeenFodder;
	}

	public String getLandmark() {
		return this.landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
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

	public String getLatitudeD() {
		return this.latitudeD;
	}

	public void setLatitudeD(String latitudeD) {
		this.latitudeD = latitudeD;
	}

	public String getLatitudeDir() {
		return this.latitudeDir;
	}

	public void setLatitudeDir(String latitudeDir) {
		this.latitudeDir = latitudeDir;
	}

	public String getLatitudeT() {
		return this.latitudeT;
	}

	public void setLatitudeT(String latitudeT) {
		this.latitudeT = latitudeT;
	}

	public String getLongitudeD() {
		return this.longitudeD;
	}

	public void setLongitudeD(String longitudeD) {
		this.longitudeD = longitudeD;
	}

	public String getLongitudeDir() {
		return this.longitudeDir;
	}

	public void setLongitudeDir(String longitudeDir) {
		this.longitudeDir = longitudeDir;
	}

	public String getLongitudeT() {
		return this.longitudeT;
	}

	public void setLongitudeT(String longitudeT) {
		this.longitudeT = longitudeT;
	}

	public String getMilkProtential() {
		return this.milkProtential;
	}

	public void setMilkProtential(String milkProtential) {
		this.milkProtential = milkProtential;
	}

	public String getMobileNo1() {
		return this.mobileNo1;
	}

	public void setMobileNo1(String mobileNo1) {
		this.mobileNo1 = mobileNo1;
	}

	public String getMobileNo2() {
		return this.mobileNo2;
	}

	public void setMobileNo2(String mobileNo2) {
		this.mobileNo2 = mobileNo2;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName2() {
		return this.name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getNoAnimals() {
		return this.noAnimals;
	}

	public void setNoAnimals(String noAnimals) {
		this.noAnimals = noAnimals;
	}

	public String getNoBuffalos() {
		return this.noBuffalos;
	}

	public void setNoBuffalos(String noBuffalos) {
		this.noBuffalos = noBuffalos;
	}

	public String getNoCows() {
		return this.noCows;
	}

	public void setNoCows(String noCows) {
		this.noCows = noCows;
	}

	public String getNoHeifer() {
		return this.noHeifer;
	}

	public void setNoHeifer(String noHeifer) {
		this.noHeifer = noHeifer;
	}

	public String getNoHouseHolder() {
		return this.noHouseHolder;
	}

	public void setNoHouseHolder(String noHouseHolder) {
		this.noHouseHolder = noHouseHolder;
	}

	public String getNoHuman() {
		return this.noHuman;
	}

	public void setNoHuman(String noHuman) {
		this.noHuman = noHuman;
	}

	public String getPanNo() {
		return this.panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRefFrom() {
		return this.refFrom;
	}

	public void setRefFrom(String refFrom) {
		this.refFrom = refFrom;
	}

	public String getSociety() {
		return this.society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetName1() {
		return this.streetName1;
	}

	public void setStreetName1(String streetName1) {
		this.streetName1 = streetName1;
	}

	public String getStreetName2() {
		return this.streetName2;
	}

	public void setStreetName2(String streetName2) {
		this.streetName2 = streetName2;
	}

	public String getStreetName3() {
		return this.streetName3;
	}

	public void setStreetName3(String streetName3) {
		this.streetName3 = streetName3;
	}

	public String getTelephoneNo() {
		return this.telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getVarAnimals() {
		return this.varAnimals;
	}

	public void setVarAnimals(String varAnimals) {
		this.varAnimals = varAnimals;
	}

	public String getVendorAccGrpCode() {
		return this.vendorAccGrpCode;
	}

	public void setVendorAccGrpCode(String vendorAccGrpCode) {
		this.vendorAccGrpCode = vendorAccGrpCode;
	}

	public String getWaterFacility() {
		return this.waterFacility;
	}

	public void setWaterFacility(String waterFacility) {
		this.waterFacility = waterFacility;
	}

//	public List<ApReport> getApReports() {
//		return this.apReports;
//	}
//
//	public void setApReports(List<ApReport> apReports) {
//		this.apReports = apReports;
//	}
	
	public String getJ1kftbus() {
		return this.j1kftbus;
	}

	public void setJ1kftbus(String j1kftbus) {
		this.j1kftbus = j1kftbus;
	}

//	public ApReport addApReport(ApReport apReport) {
//		getApReports().add(apReport);
//		apReport.setVendorMaster(this);
//
//		return apReport;
//	}
//
//	public ApReport removeApReport(ApReport apReport) {
//		getApReports().remove(apReport);
//		apReport.setVendorMaster(null);
//
//		return apReport;
//	}

	public List<VendorBankDetail> getVendorBankDetails() {
		return this.vendorBankDetails;
	}

	public void setVendorBankDetails(List<VendorBankDetail> vendorBankDetails) {
		this.vendorBankDetails = vendorBankDetails;
	}

	public VendorBankDetail addVendorBankDetail(VendorBankDetail vendorBankDetail) {
		getVendorBankDetails().add(vendorBankDetail);
		vendorBankDetail.setVendorMaster(this);

		return vendorBankDetail;
	}

	public VendorBankDetail removeVendorBankDetail(VendorBankDetail vendorBankDetail) {
		getVendorBankDetails().remove(vendorBankDetail);
		vendorBankDetail.setVendorMaster(null);

		return vendorBankDetail;
	}

	public CompanyMaster getCompanyMaster() {
		return this.companyMaster;
	}

	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
	}

	public RegionMaster getRegionMaster() {
		return this.regionMaster;
	}

	public void setRegionMaster(RegionMaster regionMaster) {
		this.regionMaster = regionMaster;
	}

}