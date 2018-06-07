package org.clss.businessportal.controller;

import java.net.UnknownHostException;

/**
*
* @author Mohamed Saud SNS
*/

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.clss.businessportal.custommodel.DepartmentAccessCustomModel;
import org.clss.businessportal.custommodel.MenuAccessCustomModel;
import org.clss.businessportal.dao.CountryDao;
import org.clss.businessportal.dao.UserMasterDao;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.entity.CountryMaster;
import org.clss.businessportal.entity.Menumaster;
import org.clss.businessportal.entity.RegionMaster;
import org.clss.businessportal.entity.Role;
import org.clss.businessportal.entity.UserMenuAssignment;
import org.clss.businessportal.entity.UserTrack;
import org.clss.businessportal.entity.UserTrackPK;
import org.clss.businessportal.entity.VendorMaster;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class WelcomeController {

	@Autowired
	private CountryDao countryDao;

	@Autowired
	private UserMasterDao userDao;

	@Autowired
	private VendorMasterDao vendorMasterDao;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/index")
	public String index1() {
		return "index";
	}

	@RequestMapping("/Admin")
	public String Admin() {
		return "Admin/Welcome";
	}
	
	@RequestMapping("/SecurityDebo")
	public String SecurityDebo() {
		return "Admin/SecurityDebo";
	}
	
	@RequestMapping("/SecurityDeboTa")
	public String SecurityDeboTa() {
		return "Admin/SecurityDeboTa";
	}
	
	
	@RequestMapping("/AdminDashboard")
	public String AdminDashboard(HttpServletRequest req) {
		menuAccess(req);
		return "Admin/AdminDashboard";
	}
	
	

	@RequestMapping("/VendorDetails")
	public String VendorDetails(HttpServletRequest req) {

		menuAccess(req);
		return "VendorDetails";

	}

	@RequestMapping("/VendorProfile")
	public String VendorProfile(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "NewProductLaunch");

		menuAccess(req);
		return "VendorProfile";

	}

	@RequestMapping("/tdsCertificateUpload")
	public String tdsCertificateUpload(HttpServletRequest req) {

		menuAccess(req);
		return "ImageUpload";

	}

	@RequestMapping("/CustomerDetails")
	public String CustomerDetails(HttpServletRequest req) {

		menuAccess(req);
		return "CustomerDetails";

	}

	@RequestMapping("/OutstandingReport")
	public String OutstandingReport(HttpServletRequest req) {

		menuAccess(req);
		return "OutstandingReport";

	}

	@RequestMapping("/CustomerOutstandingReport")
	public String CustomerOutstandingReport(HttpServletRequest req) {

		menuAccess(req);
		return "CustomerOutstandingReport";

	}

	@RequestMapping("/ChangePassword")
	public String ChangePassword(HttpServletRequest req) {

		menuAccess(req);
		return "ChangePassword";

	}

	@RequestMapping("/Welcome")
	public String Welcome(HttpServletRequest req) {

		menuAccess(req);

		return "Welcome";
	}

	@RequestMapping("/InchargeWelcome")
	public String InchargeWelcome(HttpServletRequest req) {

		menuAccess(req);

		return "HMBIncharge/InchargeWelcome";
	}

	// ....................... Admin Menu Start .............
	
	@RequestMapping("/UserHistory")
	public String UserHistory(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		menuAccess(req);

		return "Admin/UserHistory";
	}

	@RequestMapping("/ProductUpload")
	public String ProductUpload(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		menuAccess(req);

		return "ProductUpload";
	}

	@RequestMapping("/SchemeUpload")
	public String SchemeUpload(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		menuAccess(req);

		return "SchemeUpload";
	}

	@RequestMapping("/GroupFileUpload")
	public String GroupFileUpload(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		menuAccess(req);

		return "GroupFileUpload";
	}

	@RequestMapping("/FiledForceFileUpload")
	public String FiledForceFileUpload(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		menuAccess(req);

		return "Admin/FiledForceFileUpload";
	}
	
	@RequestMapping("/NewsLetterUpload")
	public String NewsLetterUpload(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		menuAccess(req);

		return "Admin/NewsLetterUpload";
	}

	

	// ....................... Admin Menu End .............

	// ....................... Super Admin Menu Start .............

	@RequestMapping("/SearchWelcome")
	public String SearchWelcome(HttpServletRequest req) {

		menuAccess(req);

		return "SearchWelcome";
	}

	// .......................Super Admin Menu End .............

	// ....................... Land Owner Menu Start .............

	@RequestMapping("/landOwnerAgreementStatus")
	public String landOwnerAgreementStatus(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		menuAccess(req);
		String companyCode = (String) req.getSession().getAttribute("companyCode");

		List<DepartmentAccessCustomModel> departmentAssignments = departmentAccess(req, "" + roleId,
				"landOwnerAgreementStatus");

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		List<DepartmentAccessCustomModel> departmentMenuAcess = userDao
				.getDepartmentLandOwnerAgreementStatusAccess(companyCode, departmentAssignments, "" + date);

		System.out.println("After Land Owner Department Access .." + departmentAssignments.size());
		req.setAttribute("departmentAccess", departmentMenuAcess);

		return "landOwnerAgreementStatus";
	}

	@RequestMapping("/rentalAdvancesStatus")
	public String rentalAdvancesStatus(HttpServletRequest req) {

		menuAccess(req);

		return "rentalAdvancesStatus";
	}

	@RequestMapping("/additionalConsumptioDepositStatus")
	public String additionalConsumptioDepositStatus(HttpServletRequest req) {

		menuAccess(req);

		return "additionalConsumptioDepositStatus";
	}

	@RequestMapping("/monthlyRentalPaymentStatuswithBreakup")
	public String monthlyRentalPaymentStatuswithBreakup(HttpServletRequest req) {

		menuAccess(req);

		return "monthlyRentalPaymentStatuswithBreakup";
	}

	@RequestMapping("/agreementRenewalStatusHikeStatus")
	public String agreementRenewalStatusHikeStatus(HttpServletRequest req) {

		menuAccess(req);

		return "agreementRenewalStatusHikeStatus";
	}

	@RequestMapping("/tdsCertificates")
	public String tdsCertificates(HttpServletRequest req) {

		menuAccess(req);

		return "tdsCertificates";
	}

	// @RequestMapping("/fieldForceContactNumber")
	// public String fieldForceContactNumber(HttpServletRequest req) {
	//
	// menuAccess(req);
	//
	// return "fieldForceContactNumber";
	// }
	@RequestMapping("/hmbFiledForceStaff")
	public String HmbFiledForceStaff(HttpServletRequest req) {

		menuAccess(req);
		return "Common/HmbFiledForceStaff";

	}

	// ....................... Land Owner Menu End .............

	///////////// Common Menu

	@RequestMapping("/fieldForceContactNumber")
	public String fieldForceContactNumber(HttpServletRequest req) {

		menuAccess(req);
		return "Common/FiledForce";

	}

	// ....................... Transporter Menu Start .............

	@RequestMapping("/SecurityDepositStatus")
	public String SecurityDepositStatus(HttpServletRequest req) {

		menuAccess(req);

		return "Transporter/SecurityDepositStatus";
	}

	@RequestMapping("/SecurityDepositRefundStatus")
	public String SecurityDepositRefundStatus(HttpServletRequest req) {

		menuAccess(req);

		return "Transporter/SecurityDepositRefundStatus";
	}

	@RequestMapping("/MonthlyVehicleDetails")
	public String MonthlyVehicleDetails(HttpServletRequest req) {

		menuAccess(req);

		return "Transporter/MonthlyVehicleDetails";
	}

	@RequestMapping("/MonthlyVehiclewiseDieselAmount")
	public String MonthlyVehiclewiseDieselAmount(HttpServletRequest req) {

		menuAccess(req);

		return "Transporter/MonthlyVehiclewiseDieselAmount";
	}

	@RequestMapping("/MonthlyVehicleWiseAdditionalAndDeductionDetails")
	public String MonthlyVehicleWiseAdditionalAndDeductionDetails(HttpServletRequest req) {

		menuAccess(req);

		return "Transporter/MonthlyVehicleWiseAdditionalAndDeductionDetails";
	}

	@RequestMapping("/ManpowerLoadingBoysStatement")
	public String ManpowerLoadingBoysStatement(HttpServletRequest req) {

		menuAccess(req);

		return "ManpowerLoadingBoysStatement";
	}

	@RequestMapping("/VehicleHistoryRCDateCrateCapacity")
	public String VehicleHistoryRCDateCrateCapacity(HttpServletRequest req) {

		menuAccess(req);

		return "Transporter/VehicleHistoryRCDateCrateCapacity";
	}

	@RequestMapping("/TransporterPayment")
	public String TransporterPayment(HttpServletRequest req) {

		menuAccess(req);

		return "Transporter/TransporterPayment";
	}

	// ....................... Transporter Menu End .............

	// ....................... Logistic Menu Start .............

	@RequestMapping("/MonthlyVehicleDetailsForLogistics")
	public String MonthlyVehicleDetailsForLogistics(HttpServletRequest req) {

		menuAccess(req);

		return "MonthlyVehicleDetailsForLogistics";
	}

	@RequestMapping("/LogisticSecurityDepositStatus")
	public String LogisticSecurityDepositStatus(HttpServletRequest req) {

		menuAccess(req);

		return "Logistic/LogisticSecurityDepositStatus";
	}

	// ....................... Logistic Menu End .............

	//// ....................... Transporter Menu Start .............
	//
	// @RequestMapping("/SecurityDepositStatus")
	// public String SecurityDepositStatus(HttpServletRequest req) {
	//
	// menuAccess(req);
	//
	// return "SecurityDepositStatus";
	// }
	//
	// @RequestMapping("/SecurityDepositRefundStatus")
	// public String SecurityDepositRefundStatus(HttpServletRequest req) {
	//
	// menuAccess(req);
	//
	// return "SecurityDepositRefundStatus";
	// }
	//
	//
	//
	// @RequestMapping("/MonthlyVehicleDetails")
	// public String MonthlyVehicleDetails(HttpServletRequest req) {
	//
	// menuAccess(req);
	//
	// return "MonthlyVehicleDetails";
	// }
	//
	// @RequestMapping("/MonthlyVehiclewiseDieselAmount")
	// public String MonthlyVehiclewiseDieselAmount(HttpServletRequest req) {
	//
	// menuAccess(req);
	//
	// return "MonthlyVehiclewiseDieselAmount";
	// }
	//
	//
	// @RequestMapping("/MonthlyVehicleWiseAdditionalAndDeductionDetails")
	// public String
	//// MonthlyVehicleWiseAdditionalAndDeductionDetails(HttpServletRequest req) {
	//
	// menuAccess(req);
	//
	// return "MonthlyVehicleWiseAdditionalAndDeductionDetails";
	// }
	//
	// @RequestMapping("/ManpowerLoadingBoysStatement")
	// public String ManpowerLoadingBoysStatement(HttpServletRequest req) {
	//
	// menuAccess(req);
	//
	// return "ManpowerLoadingBoysStatement";
	// }
	//
	//
	// @RequestMapping("/VehicleHistoryRCDateCrateCapacity")
	// public String VehicleHistoryRCDateCrateCapacity(HttpServletRequest req) {
	//
	// menuAccess(req);
	//
	// return "VehicleHistoryRCDateCrateCapacity";
	// }
	//
	//
	//
	//
	//
	//
	//// ....................... Transporter Menu End .............

	// ....................... CFA Menu Start .............

	@RequestMapping("/DGClaimsStatus")
	public String DGClaimsStatus(HttpServletRequest req) {

		menuAccess(req);

		return "DGClaimsStatus";
	}

	@RequestMapping("/NewProductLaunch")
	public String NewProductLaunch(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		System.out.println("roleId.." + roleId);

		String companyCode = (String) req.getSession().getAttribute("companyCode");

		menuAccess(req);
		List<DepartmentAccessCustomModel> departmentAssignments = departmentAccess(req, "" + roleId,
				"NewProductLaunch");

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		List<DepartmentAccessCustomModel> departmentMenuAcess = userDao.getDepartmentAccess(companyCode,
				departmentAssignments, "" + date);

		System.out.println("after check.." + departmentAssignments.size());
		req.setAttribute("departmentAccess", departmentMenuAcess);

		return "NewProductLaunch";
	}

	@RequestMapping("/NewScheme")
	public String NewScheme(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		System.out.println("roleId.." + roleId);

		String companyCode = (String) req.getSession().getAttribute("companyCode");

		menuAccess(req);
		List<DepartmentAccessCustomModel> departmentAssignments = departmentAccess(req, "" + roleId, "NewScheme");

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		List<DepartmentAccessCustomModel> departmentMenuAcess = userDao.getSchemeDepartmentAccess(companyCode,
				departmentAssignments, "" + date);

		System.out.println("after check.." + departmentAssignments.size());
		req.setAttribute("departmentAccess", departmentMenuAcess);
		return "NewScheme";
	}

	@RequestMapping("/EBClaimsStatus")
	public String EBClaimsStatus(HttpServletRequest req) {

		menuAccess(req);

		return "EBClaimsStatus";
	}

	@RequestMapping("/CommissionCharges")
	public String CommissionCharges(HttpServletRequest req) {

		menuAccess(req);

		return "CommissionCharges";
	}

	@RequestMapping("/TransportationCharges")
	public String TransportationCharges(HttpServletRequest req) {

		menuAccess(req);

		return "TransportationCharges";
	}

	// ....................... CFA Menu End .............

	// ....................... In shop Menu Start .............

	@RequestMapping("/BillPaymentDetail")
	public String BillPaymentDetail(HttpServletRequest req) {

		menuAccess(req);

		return "BillPaymentDetail";
	}

	@RequestMapping("/PoList")
	public String PoList(HttpServletRequest req) {

		menuAccess(req);

		return "PoList";
	}

	// ....................... In Shop Menu End .............

	// ....................... Bulk Farm Menu Start .............

	@RequestMapping("/PaymentDetail")
	public String PaymentDetail(HttpServletRequest req) {

		menuAccess(req);

		return "PaymentDetail";
	}

	@RequestMapping("/BulkHmbSummary")
	public String BulkHmbSummary(HttpServletRequest req) {

		menuAccess(req);

		return "BulkVendor/BulkHmbSummary";
	}

	// ....................... Bulk Farm Menu End .............

	// ....................... Farm Menu Start .............

	@RequestMapping("/FarmHmbSummary")
	public String FarmHmbSummary(HttpServletRequest req) {

		menuAccess(req);

		return "FarmVendor/FarmHmbSummary";
	}

	// ....................... Farm Menu End .............

	// ....................... HMB Menu Start .............

	@RequestMapping("/FarmerVendorProfile")
	public String FarmerVendorProfile(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "FarmerVendorProfile");

		menuAccess(req);
		return "HMB/FarmerVendorProfile";

	}

	@RequestMapping("/HmbSummary")
	public String HmbSummary(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "HmbSummary");

		menuAccess(req);
		return "HMB/HmbSummary";

	}

	@RequestMapping("/MaterialStockCanAndCanLid")
	public String MaterialStockCanAndCanLid(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "MaterialStockCanAndCanLid");

		menuAccess(req);
		return "HMB/MaterialStockCanAndCanLid";

	}

	@RequestMapping("/HmbInchargeSummary")
	public String HmbInchargeSummary(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "HmbSummary");

		menuAccess(req);
		return "HMB/HmbInchargeSummary";

	}
	
	@RequestMapping("/MilkDeductions")
	public String MilkDeductions(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "MilkDeductions");

		menuAccess(req);
		return "HMB/MilkDeductions";

	}
	
	
	
	@RequestMapping("/NewsLetter")
	public String NewsLetter(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "NewsLetter");

		menuAccess(req);
		return "HMB/NewsLetter";

	}
	@RequestMapping("/Circular")
	public String Circular(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "Circular");

		menuAccess(req);
		return "HMB/Circular";

	}
	
	
	
	
	
	
	

	@RequestMapping("/MilkPaymentDetails")
	public String MilkPaymentDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "MilkPaymentDetails");

		menuAccess(req);
		return "HMB/MilkPaymentDetails";

	}

	@RequestMapping("/Farmerdetails")
	public String Farmerdetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "Farmerdetails");

		menuAccess(req);
		return "HMB/Farmerdetails";

	}

	@RequestMapping("/DepositAmount")
	public String DepositAmount(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "DepositAmount");

		menuAccess(req);
		return "HMBIncharge/DepositAmount";

	}

	@RequestMapping("/NegativeMilkAdvanceDetails")
	public String NegativeMilkAdvanceDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "NegativeMilkAdvanceDetails");

		menuAccess(req);
		return "HMBIncharge/NegativeMilkAdvanceDetails";

	}

	@RequestMapping("/ServiceChargeDetails")
	public String ServiceChargeDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "ServiceChargeDetails");

		menuAccess(req);
		return "HMB/ServiceChargeDetails";

	}

	@RequestMapping("/FatAndSnfDetails")
	public String FatAndSnfDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "ServiceChargeDetails");

		menuAccess(req);
		return "HMB/FatAndSnfDetails";

	}

	@RequestMapping("/AverageMilkMonthAverage")
	public String AverageMilkMonthAverage(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "AverageMilkMonthAverage");

		menuAccess(req);
		return "HMB/AverageMilkMonthAverage";

	}

	@RequestMapping("/MaterialStock")
	public String MaterialStock(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "MaterialStock");

		menuAccess(req);
		return "HMB/MaterialStock";

	}

	@RequestMapping("/FssaiCertificateRenewalStatus")
	public String FssaiCertificateRenewalStatus(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "FssaiCertificateRenewalStatus");

		menuAccess(req);
		return "HMB/FssaiCertificateRenewalStatus";

	}

	@RequestMapping("/DeductionDetails")
	public String DeductionDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "DeductionDetails");

		menuAccess(req);
		return "HMB/DeductionDetails";

	}

	@RequestMapping("/SpoilageAdulterationAntibioticDetails")
	public String SpoilageAdulterationAntibioticDetails(HttpServletRequest req,
			@RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "SpoilageAdulterationAntibioticDetails");

		menuAccess(req);
		return "HMB/SpoilageAdulterationAntibioticDetails";

	}

	@RequestMapping("/MeetingDetailsNoticeBoard")
	public String MeetingDetailsNoticeBoard(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "MeetingDetailsNoticeBoard");

		menuAccess(req);
		return "HMB/MeetingDetailsNoticeBoard";

	}

	@RequestMapping("/FeedSalesHmbWise")
	public String FeedSalesHmbWise(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "FeedSalesHmbWise");

		menuAccess(req);
		return "HMB/FeedSalesHmbWise";

	}

	@RequestMapping("/FeedSalesFarmerwise")
	public String FeedSalesFarmerwise(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "FeedSalesFarmerwise");

		menuAccess(req);
		return "HMB/FeedSalesFarmerwise";

	}

	@RequestMapping("/UsageOfFeed")
	public String UsageOfFeed(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "UsageOfFeed");

		menuAccess(req);
		return "HMB/UsageOfFeed";

	}

	// ....................... HMB Menu End .............

	// ....................... HMB Land Lord Start .................

	@RequestMapping("/RentalPaymentStauswithmonth")
	public String RentalPaymentStauswithmonth(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "RentalPaymentStauswithmonth");

		menuAccess(req);
		return "HMBLandLord/RentalPaymentStauswithmonth";

	}

	// ....................... Field Staff Menu Start .................

	@RequestMapping("/DataPending")
	public String DataPending(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "DataPending");

		menuAccess(req);
		return "FieldStaff/DataPending";

	}

	@RequestMapping("/ComparisionStatement")
	public String ComparisionStatement(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "ComparisionStatement");

		menuAccess(req);
		return "FieldStaff/ComparisionStatement";

	}

	@RequestMapping("/TsRecovery")
	public String TsRecovery(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "TsRecovery");

		menuAccess(req);
		return "FieldStaff/TsRecovery";

	}

	@RequestMapping("/FfsPaymentDetails")
	public String FfsPaymentDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "FfsPaymentDetails");

		menuAccess(req);
		return "FieldStaff/FfsPaymentDetails";

	}

	@RequestMapping("/HoldFarmerList")
	public String HoldFarmerList(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "HoldFarmerList");

		menuAccess(req);
		return "FieldStaff/HoldFarmerList";

	}

	@RequestMapping("/MismatchDetails")
	public String MismatchDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "MismatchDetails");

		menuAccess(req);
		return "FieldStaff/MismatchDetails";

	}

	@RequestMapping("/FfsDeductionDetails")
	public String FfsDeductionDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "FfsDeductionDetails");

		menuAccess(req);
		return "FieldStaff/FfsDeductionDetails";

	}

	@RequestMapping("/FfsServiceChargeDetails")
	public String FfsServiceChargeDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "FfsServiceChargeDetails");

		menuAccess(req);
		return "FieldStaff/FfsServiceChargeDetails";

	}

	public String NegativeDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "NegativeDetails");

		menuAccess(req);
		return "FieldStaff/NegativeDetails";

	}

	public String NewFarmer(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "NewFarmer");

		menuAccess(req);
		return "FieldStaff/NewFarmer";

	}

	public String WithoutPannoDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "WithoutPannoDetails");

		menuAccess(req);
		return "FieldStaff/WithoutPannoDetails";

	}

	public String WithoutBankDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "WithoutBankDetails");

		menuAccess(req);
		return "FieldStaff/WithoutBankDetails";

	}

	public String FfsSecurityDeposit(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "FfsSecurityDeposit");

		menuAccess(req);
		return "FieldStaff/FfsSecurityDeposit";

	}

	public String ServiceChargeHoldPayment(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "ServiceChargeHoldPayment");

		menuAccess(req);
		return "FieldStaff/ServiceChargeHoldPayment";

	}

	public String CcRentAndDeposit(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "CcRentAndDeposit");

		menuAccess(req);
		return "FieldStaff/CcRentAndDeposit";

	}

	public String AbcRentAndDeposit(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "AbcRentAndDeposit");

		menuAccess(req);
		return "FieldStaff/AbcRentAndDeposit";

	}

	public String WithoutCellNo(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "WithoutCellNo");

		menuAccess(req);
		return "FieldStaff/WithoutCellNo";

	}

	public String CcAggrementDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "CcAggrementDetails");

		menuAccess(req);
		return "FieldStaff/CcAggrementDetails";

	}

	public String AbcAggrementDetails(HttpServletRequest req, @RequestParam(value = "roleId") int roleId) {

		departmentAccess(req, "" + roleId, "AbcAggrementDetails");

		menuAccess(req);
		return "FieldStaff/AbcAggrementDetails";

	}
	
	
	// ....................... Field Staff Menu End .................	
	

	@RequestMapping("/DemoWelcome")
	public String DemoWelcome() {
		return "DemoWelcome";
	}

	@RequestMapping("/getAssignedUser")
	public @ResponseBody String getAssignedUser(HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<>();
		try {
			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");
			int userType = (int) req.getSession().getAttribute("userType");

			try {
				List<UserMenuAssignment> userMenuAssignments = userDao.getAssignedUser(companyCode, userType, userId);
				if (userMenuAssignments != null) {

					for (UserMenuAssignment userMaster : userMenuAssignments) {
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("menuId", userMaster.getId());

						jsonObjects.add(jsonObject);
					}
				}
				return jsonObjects.toString();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(jsonObjects.size() + "" + jsonObjects.toString());
		return jsonObjects.toString();
	}

	@RequestMapping("/Logout")
	public String Logout(HttpServletRequest req) throws UnknownHostException {
		
		if(req.getSession()!=null) {
			String userId = (String) req.getSession().getAttribute("userId");
			if(userId!=null) {
				
		String sessionId = req.getSession().getId();
	
		
		

	
			
			
	

		
		UserTrack ut=userDao.findUserTrackById(sessionId, userId);
		
		UserTrack userTrack=new UserTrack();
		UserTrackPK userTrackPK=new UserTrackPK();
		userTrackPK.setSessionId(ut.getId().getSessionId());
		userTrackPK.setUserId(ut.getId().getUserId());
		userTrack.setId(userTrackPK);
		userTrack.setLoggedDate(new Date());
		userTrack.setLoggedTime(Calendar.getInstance().getTime());
		userTrack.setLoginDate(ut.getLoginDate());
		userTrack.setLoginTime(ut.getLoginTime());
		userTrack.setLoginIp(ut.getLoginIp());
		userTrack.setServerIp(ut.getServerIp());
		userTrack.setUserTypeId(ut.getUserTypeId());
		userTrack.setUserFlag(ut.getUserFlag());
	
		userDao.saveUserTrack(userTrack);
		
		
		
		HttpSession session = req.getSession();
		session.invalidate();
			}
		}
		return "index";
	}

	@RequestMapping("/getRoleList")
	public @ResponseBody String getRoleList(HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		try {

			List<Role> roles = vendorMasterDao.getRoleList("A");
			for (Role role : roles) {
				JSONObject jObject = new JSONObject();
				jObject.put("roleId", role.getId().getRoleId());
				jObject.put("roleName", role.getRoleName());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}

	@RequestMapping("/getMenuList")
	public @ResponseBody String getMenuList(String roleId, HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		try {

			List<Object[]> roles = vendorMasterDao.getDepartmentList(roleId, "A");
			for (Object[] outReport : roles) {
				JSONObject jObject = new JSONObject();
				jObject.put("menuId", outReport[0].toString());
				jObject.put("menuName", outReport[1].toString());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}

	@RequestMapping("/getAllCountries")
	public @ResponseBody String getAllCountries(HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		try {
			String companyCode = (String) req.getSession().getAttribute("companyCode");
			List<CountryMaster> countries = countryDao.findAll();
			for (CountryMaster country : countries) {
				JSONObject jObject = new JSONObject();
				jObject.put("countryId", country.getCountryCode());
				jObject.put("countryName", country.getCountryName());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}

	@RequestMapping("/getRegionsByCountryId")
	public @ResponseBody String getStatesByCountryId(String countryId, HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		try {
			String companyCode = (String) req.getSession().getAttribute("companyCode");
			List<RegionMaster> regions = countryDao.getRegionsByCountryId(countryId);
			for (RegionMaster region : regions) {
				JSONObject jObject = new JSONObject();
				jObject.put("regionId", region.getId().getRegionCode());
				jObject.put("regionName", region.getRegionName());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}

	private void menuAccess(HttpServletRequest req) {
		String companyCode = (String) req.getSession().getAttribute("companyCode");
		String userId = (String) req.getSession().getAttribute("userId");
		int userType = (int) req.getSession().getAttribute("userType");
		List<MenuAccessCustomModel> userMenuAssignments = userDao.getAssignedByUser(companyCode, userType, userId);

		System.out.println(".welcome page.." + userMenuAssignments.size());

		req.setAttribute("menuAccess", userMenuAssignments);

	}

	private List<DepartmentAccessCustomModel> departmentAccess(HttpServletRequest req, String roleId, String menuDesc) {
		String companyCode = (String) req.getSession().getAttribute("companyCode");

		Menumaster menu = menuAccess(menuDesc);

		List<DepartmentAccessCustomModel> departmentAssignments = userDao.getDepartmentAccess(companyCode, roleId,
				"" + menu.getMenuId());

		System.out.println("departmentAssignments...." + departmentAssignments.size());

		return departmentAssignments;

	}

	private Menumaster menuAccess(String menuValue) {

		Menumaster mas = userDao.getMenuId(menuValue);

		return mas;

	}

}
