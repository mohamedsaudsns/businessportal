package org.clss.businessportal.controller;

import java.math.BigDecimal;

/**
*
* @author Mohamed Saud SNS
*/

import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.MenuAccessCustomModel;
import org.clss.businessportal.custommodel.OutstandingReportCustomModel;
import org.clss.businessportal.dao.CountryDao;
import org.clss.businessportal.dao.HmbDao;
import org.clss.businessportal.dao.UserMasterDao;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.entity.CountryMaster;
import org.clss.businessportal.entity.OtpLoginHistory;
import org.clss.businessportal.entity.OtpLoginHistoryPK;
import org.clss.businessportal.entity.Role;
import org.clss.businessportal.entity.SmsConfiguration;
import org.clss.businessportal.entity.SocietyInchargeMapping;
import org.clss.businessportal.entity.UserMaster;
import org.clss.businessportal.entity.UserMasterPK;
import org.clss.businessportal.entity.UserTrack;
import org.clss.businessportal.entity.UserTrackPK;
import org.clss.businessportal.entity.VendorMaster;
import org.clss.businessportal.mail.Mailer;
import org.clss.businessportal.sms.SmsApi;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class VendorController {

	@Autowired
	private VendorMasterDao vendorMasterDao;
	@Autowired
	private Util util;

	@Autowired
	private Mailer mailer;

	@Autowired
	private SmsApi smsApi;

	@Autowired
	private UserMasterDao userDao;
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private HmbDao hmpDao;
	
	
	
	@RequestMapping("/getVendorDataById")
	public @ResponseBody String getVendorData(@RequestParam(value = "selectedUserId") String selectedUserId,HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");
			UserMaster userMaster = vendorMasterDao.getUserData(companyCode, String.valueOf(selectedUserId));
			if (userMaster != null) {
				jsonObject.put("vendorCode", userMaster.getId().getUserId());
				jsonObject.put("vendorName", userMaster.getUserName());
		
			} else {
				jsonObject.put("address", "E");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(jsonObject.size() + "" + jsonObject.toString());
		return jsonObject.toString();
	}
	
	
	
	
	
	@RequestMapping("/getDailyUpdateDate")
	public @ResponseBody String getDailyUpdateDate(@RequestParam(value = "menuName") String menuName,HttpServletRequest req) {
		System.out.println("menuName.."+menuName);
		JSONObject jsonObject = new JSONObject();
		try {
			
			List<Object[]> dailyUpdateDate = null;
			
			
				dailyUpdateDate=vendorMasterDao.getDailyDashboardUpdateDate(menuName);
			
		
				if (dailyUpdateDate != null) {
			
			
			for(Object dailyu : dailyUpdateDate) {	
				jsonObject.put("dailyUpdateDate",dailyu.toString());
				
				
				
			}
			
				}else {
				jsonObject.put("dailyUpdateDate", "E");
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(jsonObject.size() + "" + jsonObject.toString());
		return jsonObject.toString();
	}
	

	@RequestMapping("/getVendorData")
	public @ResponseBody String getVendorData(HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");
			VendorMaster vendorMaster = vendorMasterDao.getVendorData(companyCode, String.valueOf(userId));
			if (vendorMaster != null) {
				jsonObject.put("vendorCode", vendorMaster.getId().getVendorCode());
				jsonObject.put("vendorName", vendorMaster.getName());
				jsonObject.put("vendorName2", vendorMaster.getName2());
				jsonObject.put("address", vendorMaster.getStreet());
				jsonObject.put("city", vendorMaster.getCity());
				jsonObject.put("pincode", vendorMaster.getPostalCode());
				jsonObject.put("phoneNo", vendorMaster.getTelephoneNo());
				jsonObject.put("regionName", vendorMaster.getRegionMaster().getRegionName());
				jsonObject.put("region", vendorMaster.getRegionMaster().getId().getRegionCode());
				jsonObject.put("country", vendorMaster.getRegionMaster().getCountryMaster().getCountryCode());
				jsonObject.put("countryName", vendorMaster.getRegionMaster().getCountryMaster().getCountryName());

				jsonObject.put("age", vendorMaster.getAge());
				jsonObject.put("fatherOrHusbund", vendorMaster.getFatherOrHusbandName());
				jsonObject.put("doorNo", vendorMaster.getDoorNo());
				jsonObject.put("streetName1", vendorMaster.getStreetName1());
				jsonObject.put("streetName2", vendorMaster.getStreetName2());
				jsonObject.put("streetName3", vendorMaster.getStreetName3());
				jsonObject.put("district", vendorMaster.getDistrict());
				jsonObject.put("mobile1", vendorMaster.getMobileNo1());
				jsonObject.put("mobile2", vendorMaster.getMobileNo2());
				jsonObject.put("panNo", vendorMaster.getPanNo());
				
				
				jsonObject.put("bankName", vendorMaster.getVendorBankDetails().get(0).getBankName());
				jsonObject.put("accountNo", vendorMaster.getVendorBankDetails().get(0).getId().getAccountNo());
				jsonObject.put("branchName", vendorMaster.getVendorBankDetails().get(0).getBranchName());
				jsonObject.put("ifcCode", vendorMaster.getVendorBankDetails().get(0).getIfscCode());
				jsonObject.put("branchCity", vendorMaster.getVendorBankDetails().get(0).getBankCity());
				
				
				if(vendorMaster.getVendorBankDetails().get(0).getBankCountry()!=null) {
					
					String countryCode=""+vendorMaster.getVendorBankDetails().get(0).getBankCountry();
					
					System.out.println("countryCode.."+countryCode);
					
					CountryMaster getCountries=countryDao.findById(countryCode);
					
					System.out.println("country Name.."+getCountries.getCountryName());
					
					jsonObject.put("branchCountry",getCountries.getCountryName());
				}else {
					
					
					
					
					jsonObject.put("branchCountry","");
				}
				
				
				
				
				

			} else {
				jsonObject.put("address", "E");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(jsonObject.size() + "" + jsonObject.toString());
		return jsonObject.toString();
	}
	
	
	@RequestMapping("/getFarmerVendorData")
	public @ResponseBody String getFarmerVendorData(HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");
			VendorMaster vendorMaster = vendorMasterDao.getVendorData(companyCode, String.valueOf(userId));
			if (vendorMaster != null) {
				jsonObject.put("vendorCode", vendorMaster.getId().getVendorCode());
				jsonObject.put("vendorName", vendorMaster.getName());
				jsonObject.put("vendorName2", vendorMaster.getName2());
				jsonObject.put("address", vendorMaster.getStreet());
				jsonObject.put("city", vendorMaster.getCity());
				jsonObject.put("pincode", vendorMaster.getPostalCode());
				jsonObject.put("phoneNo", vendorMaster.getTelephoneNo());
				jsonObject.put("regionName", vendorMaster.getRegionMaster().getRegionName());
				jsonObject.put("region", vendorMaster.getRegionMaster().getId().getRegionCode());
				jsonObject.put("country", vendorMaster.getRegionMaster().getCountryMaster().getCountryCode());
				jsonObject.put("countryName", vendorMaster.getRegionMaster().getCountryMaster().getCountryName());

				jsonObject.put("age", vendorMaster.getAge());
				jsonObject.put("fatherOrHusbund", vendorMaster.getFatherOrHusbandName());
				jsonObject.put("doorNo", vendorMaster.getDoorNo());
				jsonObject.put("streetName1", vendorMaster.getStreetName1());
				jsonObject.put("streetName2", vendorMaster.getStreetName2());
				jsonObject.put("streetName3", vendorMaster.getStreetName3());
				jsonObject.put("district", vendorMaster.getDistrict());
				jsonObject.put("mobile1", vendorMaster.getMobileNo1());
				jsonObject.put("mobile2", vendorMaster.getMobileNo2());
				jsonObject.put("panNo", vendorMaster.getPanNo());
				
				jsonObject.put("noOfCows", vendorMaster.getNoCows());
				jsonObject.put("noOfBuffalos", vendorMaster.getNoBuffalos());
				jsonObject.put("noOfAnimal", vendorMaster.getNoAnimals());
				jsonObject.put("milkProtential", vendorMaster.getMilkProtential());
				jsonObject.put("varAnimals", vendorMaster.getVarAnimals());
				jsonObject.put("noOfHeifer", vendorMaster.getNoHeifer());
				
				
				
				jsonObject.put("bankName", vendorMaster.getVendorBankDetails().get(0).getBankName());
				jsonObject.put("accountNo", vendorMaster.getVendorBankDetails().get(0).getId().getAccountNo());
				jsonObject.put("branchName", vendorMaster.getVendorBankDetails().get(0).getBranchName());
				jsonObject.put("ifcCode", vendorMaster.getVendorBankDetails().get(0).getIfscCode());
				jsonObject.put("branchCity", vendorMaster.getVendorBankDetails().get(0).getBankCity());
				
				
				if(vendorMaster.getVendorBankDetails().get(0).getBankCountry()!=null) {
					
					String countryCode=""+vendorMaster.getVendorBankDetails().get(0).getBankCountry();
					
					System.out.println("countryCode.."+countryCode);
					
					CountryMaster getCountries=countryDao.findById(countryCode);
					
					System.out.println("country Name.."+getCountries.getCountryName());
					
					jsonObject.put("branchCountry",getCountries.getCountryName());
				}else {
					
					
					
					
					jsonObject.put("branchCountry","");
				}
				
				
				
				
				

			} else {
				jsonObject.put("address", "E");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(jsonObject.size() + "" + jsonObject.toString());
		return jsonObject.toString();
	}
	
	
//	
//	@RequestMapping("/getVendorBankData")
//	public @ResponseBody String getVendorBankData(HttpServletRequest req) {
//		JSONObject jsonObject = new JSONObject();
//		try {
//			String companyCode = (String) req.getSession().getAttribute("companyCode");
//			int userId = (int) req.getSession().getAttribute("userId");
//			VendorMaster vendorMaster = vendorMasterDao.getVendorData(companyCode, String.valueOf(userId));
//			if (vendorMaster != null) {
//				jsonObject.put("vendorCode", vendorMaster.getId().getVendorCode());
//				jsonObject.put("vendorName", vendorMaster.getName());
//				jsonObject.put("vendorName2", vendorMaster.getName2());
//				jsonObject.put("address", vendorMaster.getStreet());
//				jsonObject.put("city", vendorMaster.getCity());
//				jsonObject.put("pincode", vendorMaster.getPostalCode());
//				jsonObject.put("phoneNo", vendorMaster.getTelephoneNo());
//				jsonObject.put("regionName", vendorMaster.getRegionMaster().getRegionName());
//				jsonObject.put("region", vendorMaster.getRegionMaster().getId().getRegionCode());
//				jsonObject.put("country", vendorMaster.getRegionMaster().getCountryMaster().getCountryCode());
//				jsonObject.put("countryName", vendorMaster.getRegionMaster().getCountryMaster().getCountryName());
//
//				jsonObject.put("age", vendorMaster.getAge());
//				jsonObject.put("fatherOrHusbund", vendorMaster.getFatherOrHusbandName());
//				jsonObject.put("doorNo", vendorMaster.getDoorNo());
//				jsonObject.put("streetName1", vendorMaster.getStreetName1());
//				jsonObject.put("streetName2", vendorMaster.getStreetName2());
//				jsonObject.put("streetName3", vendorMaster.getStreetName3());
//				jsonObject.put("district", vendorMaster.getDistrict());
//				jsonObject.put("mobile1", vendorMaster.getMobileNo1());
//				jsonObject.put("mobile2", vendorMaster.getMobileNo2());
//
//			} else {
//				jsonObject.put("address", "E");
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		System.out.println(jsonObject.size() + "" + jsonObject.toString());
//		return jsonObject.toString();
//	}
	

	@RequestMapping("/generateVendorPasswordOtp")
	public @ResponseBody String generateVendorPasswordOtp(HttpServletRequest req) {
		String ret = "E";
		try {

			String vendorName = (String) req.getSession().getAttribute("userName");
			String vendorEmailId = (String) req.getSession().getAttribute("vendorEmailId");
			String vendorPhoneNo = (String) req.getSession().getAttribute("vendorPhoneNo");
			

			String outp = "" + util.generateSessionKey(5);
			System.out.println("outp.." + outp);

			SmsConfiguration smcon = vendorMasterDao.getSmsConfiguration("A");

			System.out.println("smcon.." + smcon.getSmsUrl());

			smsApi.sentSms("" + smcon.getSmsUrl(), "" + vendorPhoneNo,
					"Hi " + vendorName + ", You are requested OTP is :: " + outp, smcon.getUserName(),
					smcon.getPassword(), smcon.getPId());
			// mailer.sendMail("Requested OTP", "Hi " + vendorName+",", " You
			// are requested OTP is :: " + outp, vendorEmailId,
			// "", vendorEmailId);

			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");
			int userType = (int) req.getSession().getAttribute("userType");

			 java.util.Date today = new java.util.Date();
			    System.out.println(new java.sql.Timestamp(today.getTime()));
	
			    LocalTime time = LocalTime.now();
			     System.out.println("Current time of the day: " + time);
			    
			userDao.updateOtpCode(companyCode, userType, userId, outp,"","");

			OtpLoginHistory otpLoginHistory = new OtpLoginHistory();
			OtpLoginHistoryPK otpLoginHistoryPK = new OtpLoginHistoryPK();
			otpLoginHistoryPK.setCompCode(companyCode);
			otpLoginHistoryPK.setUserId(Integer.parseInt(userId));
			otpLoginHistoryPK.setOtpGenTime(new Date());
			otpLoginHistory.setId(otpLoginHistoryPK);
			otpLoginHistory.setOtpCode(outp);
			otpLoginHistory.setOtpValidTime(new Date(System.currentTimeMillis()+3*60*1000));
			otpLoginHistory.setStatus("A");
			otpLoginHistory.setCreatedBy(1000);
			otpLoginHistory.setCreatedOn(new Date());
			otpLoginHistory.setLastChangedBy(1000);
			otpLoginHistory.setLastChangedOn(new Date());

			userDao.saveOtpHistory(otpLoginHistory);

			ret = "S";

		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}

	@RequestMapping("/OtpValidation")
	public @ResponseBody String OtpValidation(String otpCode, HttpServletRequest req) {
		String ret = "E";

		String companyCode = (String) req.getSession().getAttribute("companyCode");
		String userId = (String) req.getSession().getAttribute("userId");
		int userType = (int) req.getSession().getAttribute("userType");
		try {
			UserMaster users = userDao.CheckValidOtp(companyCode, userType, userId, otpCode);

			if (users != null) {
				ret = "success";

			} else {
				ret = "Invalid User Name";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	
	
	@RequestMapping("/forgetOtpValidation")
	public @ResponseBody String forgetOtpValidation(String userid,String otpCode, HttpServletRequest req) {
		String ret = "E";

	
		try {
			UserMaster users = userDao.CheckForgetOtp( userid, otpCode);

			if (users != null) {
				ret = "success";
				HttpSession session = req.getSession();
				UserTrack userTrack=new UserTrack();
				UserTrackPK userTrackPK=new UserTrackPK();
				userTrackPK.setSessionId(req.getSession().getId());
				userTrackPK.setUserId(users.getId().getUserId().toString().trim());
				userTrack.setId(userTrackPK);
				userTrack.setLoggedDate(new Date());
				userTrack.setLoggedTime(Calendar.getInstance().getTime());
				userTrack.setLoginDate(new Date());
				userTrack.setLoginTime(Calendar.getInstance().getTime());
				userTrack.setLoginIp(Util.getIP(req));
				userTrack.setServerIp(Util.getServerIP());
			
				

				session.setAttribute("userId", users.getId().getUserId());
				session.setAttribute("userName", users.getUserName());
				session.setAttribute("userType", users.getId().getUserTypeId());
				session.setAttribute("companyCode", users.getId().getCompCode());
				session.setAttribute("vendorEmailId", users.getEmailId());
				session.setAttribute("vendorPhoneNo", users.getMobileNo());
				session.setAttribute("panNo", users.getPanNo());
				session.setAttribute("accountGroup", users.getAccGrpCode());
				
				if(users.getAccGrpCode()!=null) {
					
					
					
					if(users.getAccGrpCode().equals("ATPY")) {
						
					 List<SocietyInchargeMapping> sm=hmpDao.getSocietyInchargeMappingList(users.getId().getCompCode(),users.getId().getUserId(),"IN");
						session.setAttribute("society", sm.get(0).getId().getSociety());
						System.out.println(" ATPY socity.."+sm.get(0).getId().getSociety());
						
					}
					else if(users.getAccGrpCode().equals("HMBO")) {
						
						 List<SocietyInchargeMapping> sm=hmpDao.getSocietyInchargeMappingList(users.getId().getCompCode(),users.getId().getUserId(),"BO");
						session.setAttribute("society", sm.get(0).getId().getSociety());
						System.out.println(" HMBO socity.."+sm.get(0).getId().getSociety());
						
					}
					
					else {
						
						session.setAttribute("society", users.getSociety());
						
					}
					
					
					}
				List<MenuAccessCustomModel> userMenuAssignments = userDao.getAssignedByUser(users.getId().getCompCode(),users.getId().getUserTypeId(),users.getId().getUserId());
				System.out.println("..."+userMenuAssignments.size());
				
				if(userMenuAssignments!=null && userMenuAssignments.size()>0){
					
					
					session.setAttribute("menuAccess", userMenuAssignments);
					
					session.setAttribute("role_id", userMenuAssignments.get(0).getRoleId());
						
					Role roleName=vendorMasterDao.getRoleNameData(users.getId().getCompCode(),userMenuAssignments.get(0).getRoleId());
					
					session.setAttribute("role",roleName.getRoleName() );
				
			}else{
				
				session.setAttribute("menuAccess", "");
			}
				
				userTrack.setUserTypeId(1);
				userTrack.setUserFlag("UL");
				userDao.saveUserTrack(userTrack);

			} else {
				ret = "Invalid User Name";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}

}
