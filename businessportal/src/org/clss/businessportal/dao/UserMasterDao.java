package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.clss.businessportal.custommodel.DepartmentAccessCustomModel;
import org.clss.businessportal.custommodel.MenuAccessCustomModel;
import org.clss.businessportal.entity.Menumaster;
import org.clss.businessportal.entity.OtpLoginHistory;
import org.clss.businessportal.entity.UserMaster;
import org.clss.businessportal.entity.UserMenuAssignment;
import org.clss.businessportal.entity.UserTrack;

public interface UserMasterDao extends GenericDao<UserMaster, Serializable>{

	public UserMaster getUsermasterData(String userId);
	
	public UserMaster getUserMasterById(String companyCode, int userId);
	
	public List<UserMaster> getUserMasterByCompanyCode(String companyCode);
	
	public List<UserMenuAssignment> getAssignedUser(String companyCode, int userTypeId,String userId);
	
	
	public List<MenuAccessCustomModel> getAssignedByUser(String companyCode, int userTypeId,String userId);
	public List<DepartmentAccessCustomModel> getDepartmentAccess(String companyCode, String roleId,String menuId);
	
	public List<DepartmentAccessCustomModel> getDepartmentAccess(String companyCode, List<DepartmentAccessCustomModel> depID,String validDate);
	
	public List<DepartmentAccessCustomModel> getSchemeDepartmentAccess(String companyCode, List<DepartmentAccessCustomModel> depID,String vaildDate);
	
	
	
	
	 public UserMaster CheckValidOtp(String companyCode, int userTypeId,String userId,String otpCode );
	 public UserMaster CheckForgetOtp(String userId,String otpCode );
	 
	 public Menumaster getMenuId(String menuvalue);
	
	
	 public void updateOtpCode(String companyCode, int userId,String userType,String otpCode,String otpGenTime,String otpValidTime );
	 
	 public void updateForgetPasswordOtpCode(String companyCode, int userId,String userType,String otpCode,String otpGenTime,String otpValidTime );
	
	public void restPassword(String companyCode, String userId,int userType,String newPassword );
	
	public void forgotPassword( String userId,String newPassword );
	
//	public void registerForgetPassword( String userId,String newPassword );
	
	
	
	public void saveOtpHistory(OtpLoginHistory otpLoginHistory);
	
	public void saveUserTrack(UserTrack userTrack);
	
	public UserTrack findUserTrackById(String sessionId,String userId);
	
	public boolean validateRole(String compCode,String roleId,String AccessRoleId);
	
	
	//................... Department Access Start .............//
	
	
	public List<DepartmentAccessCustomModel> getDepartmentLandOwnerAgreementStatusAccess(String companyCode, List<DepartmentAccessCustomModel> depID,String validDate);
	
	//................... Department Access End .............//
	
	
	
	
	
	
}
