package org.clss.businessportal.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Time;

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

import org.clss.businessportal.custommodel.MenuAccessCustomModel;
import org.clss.businessportal.dao.HmbDao;
import org.clss.businessportal.dao.UserMasterDao;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.entity.OtpLoginHistory;
import org.clss.businessportal.entity.OtpLoginHistoryPK;
import org.clss.businessportal.entity.Role;
import org.clss.businessportal.entity.SmsConfiguration;
import org.clss.businessportal.entity.SocietyInchargeMapping;
import org.clss.businessportal.entity.UserMaster;
import org.clss.businessportal.entity.UserMenuAssignment;
import org.clss.businessportal.entity.UserTrack;
import org.clss.businessportal.entity.UserTrackPK;
import org.clss.businessportal.sms.SmsApi;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class LoginController {

	@Autowired
	private UserMasterDao userDao;
	
	@Autowired
	private SmsApi smsApi;
	
	@Autowired
	private HmbDao hmpDao;
	@Autowired
	private Util util;
	
	@Autowired
	private VendorMasterDao vendorMasterDao;

	@RequestMapping("/Login")
	public @ResponseBody String Login(String userName, String password,String superUser, HttpServletRequest req) {
		String ret = "E";
		try {
			UserMaster users = userDao.getUsermasterData(userName);
			if (users != null) {
				if (users.getPassword().equals(password)) {
					if (!users.getStatus().equals("X")) {
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
								
						
						
						if (users.getStatus().equals("N")) {

						ret = "NewUser";
						
						}else if (users.getStatus().equals("F")) {

							ret = "ForgetPasswordUser";
						}else if (users.getStatus().equals("A")){
							
							if (users.getId().getUserTypeId() == 1) {
								
								if(users.getAccGrpCode().equals("ATPY")) {
									
									
									userTrack.setUserTypeId(1);
									userTrack.setUserFlag("UL");
									saveUserTrack(userTrack);
									
									ret = "InchargeWelcome";
								}else if(users.getAccGrpCode()=="") {
									
									userTrack.setUserTypeId(1);
									userTrack.setUserFlag("AL");
									saveUserTrack(userTrack);
									ret = "AdminDashboard";
									
								}else {
									
									userTrack.setUserTypeId(1);
									userTrack.setUserFlag("UL");
									saveUserTrack(userTrack);
									ret = "Welcome";
									
								}
							}
							else if (users.getId().getUserTypeId() == 2) {
								if(users.getAccGrpCode().equals("ATPY")) {
								
									ret = "InchargeWelcome";
								}else {
									ret = "Welcome";
									
								}
								userTrack.setUserFlag("UL");
							}else if(users.getId().getUserTypeId() == 3) {
								userTrack.setUserTypeId(3);
								userTrack.setUserFlag("AL");
								saveUserTrack(userTrack);
							
								ret = "DemoWelcome";
								
							}else if(users.getId().getUserTypeId() == 4) {
								userTrack.setUserTypeId(4);
								userTrack.setUserFlag("AL");
								saveUserTrack(userTrack);
								session.setAttribute("superUserId", users.getId().getUserId());
								superUser="1";
							
								session.setAttribute("super_role_id", userMenuAssignments.get(0).getRoleId());
								ret = "SearchWelcomeValidation";
								
							
							
						}else if(users.getId().getUserTypeId() == 5) {
							userTrack.setUserTypeId(5);
							userTrack.setUserFlag("AL");
							saveUserTrack(userTrack);
						
							ret = "AdminDashboard";
							
						}
							
						
						}else if(users.getStatus().equals("O")){
							ret = "OTPUser";
							
						}
						session.setAttribute("superUser",superUser );
						
					} else {
						ret = "User ID blocked by admin";
					}
				} else {
					ret = "User Id & Password did not match";
				}
			} else {
				ret = "Invalid User Id";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	
	
	@RequestMapping("/searchUserValidation")
	public @ResponseBody String searchUserValidation(@RequestParam(value = "searchUserId") String searchUserId,@RequestParam(value = "searchUserFlag") String searchUserFlag, HttpServletRequest req) {
		String ret = "E";
		try {
			
			System.out.println("searchUserId.."+searchUserId);
			UserMaster users = userDao.getUsermasterData(searchUserId);
			if (users != null) {
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
			userTrack.setUserTypeId(4);
			userTrack.setUserFlag("AL");
			saveUserTrack(userTrack);
			
			
			System.out.println(users.getAccGrpCode());
		

					if (!users.getStatus().equals("X")) {
						HttpSession session = req.getSession();
						
						String companyCode = (String) req.getSession().getAttribute("companyCode");
						String roleId = (String) req.getSession().getAttribute("role_id");
						
						
						List<MenuAccessCustomModel> userMenuAssignments = userDao.getAssignedByUser(users.getId().getCompCode(),users.getId().getUserTypeId(),users.getId().getUserId());
						if(userMenuAssignments!=null){
							System.out.println("..."+userMenuAssignments.size());
							
							session.setAttribute("menuAccess", userMenuAssignments);
							
							session.setAttribute("role_id", userMenuAssignments.get(0).getRoleId());
								
							Role roleName=vendorMasterDao.getRoleNameData(users.getId().getCompCode(),userMenuAssignments.get(0).getRoleId());
							
							session.setAttribute("role",roleName.getRoleName() );
						
					}else{
						
						session.setAttribute("menuAccess", "");
					}
						
						boolean	validateRole=false;
						
						if(searchUserFlag.toString().equals("1")) {
							
							
							String superUserId = (String) req.getSession().getAttribute("super_role_id");
							validateRole=userDao.validateRole(companyCode, superUserId,""+userMenuAssignments.get(0).getRoleId());
						
						
					
						}else {
							
							validateRole=userDao.validateRole(companyCode, roleId,""+userMenuAssignments.get(0).getRoleId());
							
							
						}
					
					if(validateRole) {
						
						
					
							
						

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
							
						}
						else if(users.getAccGrpCode().equals("HMBO")) {
							
							 List<SocietyInchargeMapping> sm=hmpDao.getSocietyInchargeMappingList(users.getId().getCompCode(),users.getId().getUserId(),"BO");
							session.setAttribute("society", sm.get(0).getId().getSociety());
							
						}
						
						else {
							
							session.setAttribute("society", users.getSociety());
							
						}
						
						}
						
			
							
								
								
//								if (users.getStatus().equals("N")) {
//
//								ret = "NewUser";
//								}
//							else if (users.getStatus().equals("A")){
								
								if (users.getId().getUserTypeId() == 1) {
									
									if(users.getAccGrpCode().equals("ATPY")) {
										
										
									
										
										ret = "InchargeWelcome";
									}else {
										
									
										ret = "Welcome";
										
									}
								}
								else if (users.getId().getUserTypeId() == 2) {
									if(users.getAccGrpCode().equals("ATPY")) {
									
										ret = "InchargeWelcome";
									}else {
										ret = "Welcome";
										
									}
								}else if(users.getId().getUserTypeId() == 3) {
									
								
									ret = "DemoWelcome";
									
								}else if(users.getId().getUserTypeId() == 4) {
									
									
								
									ret = "SearchWelcomeValidation";
									
								}
								
							
//							}
//							else if(users.getStatus().equals("O")){
//								ret = "OTPUser";
								
//							}
								
								
						
//						if (users.getStatus().equals("N")) {
//
//						ret = "NewUser";
//						}
						
						
					
					}else {
						
						ret="Your Not Authorized User For This Login";
					}
					
					} else {
						ret = "User ID blocked by admin";
					}
			} else {
				ret = "Invalid User Id";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	
	
	public void saveUserTrack(UserTrack ut) {
		UserTrack userTrack=new UserTrack();
		UserTrackPK userTrackPK=new UserTrackPK();
		userTrackPK.setSessionId(ut.getId().getSessionId());
		userTrackPK.setUserId(ut.getId().getUserId());
		userTrack.setId(userTrackPK);
		userTrack.setLoggedDate(ut.getLoggedDate());
		userTrack.setLoggedTime(ut.getLoggedTime());
		userTrack.setLoginDate(ut.getLoginDate());
		userTrack.setLoginTime(ut.getLoginTime());
		userTrack.setLoginIp(ut.getLoginIp());
		userTrack.setServerIp(ut.getServerIp());
		userTrack.setUserTypeId(ut.getUserTypeId());
		userTrack.setUserFlag(ut.getUserFlag());
		
		
		userDao.saveUserTrack(userTrack);
		
	}
	
	
	
	@RequestMapping("/resetPassword")
	public @ResponseBody String resetPassword(String newPassword, HttpServletRequest req) {
		String ret = "E";
		
		String companyCode = (String) req.getSession().getAttribute("companyCode");
		String userId = (String) req.getSession().getAttribute("userId");
		int userType = (int) req.getSession().getAttribute("userType");
		try {
			userDao.restPassword(companyCode,userId,userType,newPassword);
			UserTrack userTrack=new UserTrack();
			UserTrackPK userTrackPK=new UserTrackPK();
			userTrackPK.setSessionId(req.getSession().getId());
			userTrackPK.setUserId(userId);
			userTrack.setId(userTrackPK);
			userTrack.setLoggedDate(new Date());
			userTrack.setLoggedTime(Calendar.getInstance().getTime());
			userTrack.setLoginDate(new Date());
			userTrack.setLoginTime(Calendar.getInstance().getTime());
			userTrack.setLoginIp(Util.getIP(req));
			userTrack.setServerIp(Util.getServerIP());
			userTrack.setUserTypeId(1);
			userTrack.setUserFlag("UL");
			saveUserTrack(userTrack);
			ret="success";
		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	
	
	@RequestMapping("/forgetPassword")
	public @ResponseBody String forgetPassword(String userId,String newPassword, HttpServletRequest req) {
		String ret = "E";
		
		
		try {
			userDao.forgotPassword(userId,newPassword);

	
			ret="success";
		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	
	
	
	@RequestMapping("/registerForgetPassword")
	public @ResponseBody String registerForgetPassword(String regMobileNo, HttpServletRequest req) {
		String ret = "E";
		
		
		try {
		
			UserMaster um =vendorMasterDao.getUserDataByMobileNo(regMobileNo);
			
			if(um!=null) {
				String outp = "" + util.generateSessionKey(5);
				System.out.println("outp.." + outp);

				SmsConfiguration smcon = vendorMasterDao.getSmsConfiguration("A");

			System.out.println("smcon.." + smcon.getSmsUrl());
			
			
			smsApi.sentSms("" + smcon.getSmsUrl(), "" + um.getMobileNo(),
					"Hi " + um.getUserName() + ", You are requested OTP is :: " + outp, smcon.getUserName(),
					smcon.getPassword(), smcon.getPId());
			userDao.updateForgetPasswordOtpCode(um.getId().getCompCode(), um.getId().getUserTypeId(), um.getId().getUserId(), outp,"","");
			
			OtpLoginHistory otpLoginHistory = new OtpLoginHistory();
			OtpLoginHistoryPK otpLoginHistoryPK = new OtpLoginHistoryPK();
			otpLoginHistoryPK.setCompCode(um.getId().getCompCode());
			otpLoginHistoryPK.setUserId(Integer.parseInt(um.getId().getUserId()));
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
			ret="success";
			//userDao.forgotPassword(userId,newPassword);
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	

}
