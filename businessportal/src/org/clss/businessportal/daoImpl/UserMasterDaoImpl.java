package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.clss.businessportal.custommodel.DepartmentAccessCustomModel;
import org.clss.businessportal.custommodel.MenuAccessCustomModel;
import org.clss.businessportal.dao.UserMasterDao;
import org.clss.businessportal.entity.Menumaster;
import org.clss.businessportal.entity.OtpLoginHistory;
import org.clss.businessportal.entity.SuperRoleAccess;
import org.clss.businessportal.entity.UserMaster;
import org.clss.businessportal.entity.UserMenuAssignment;
import org.clss.businessportal.entity.UserTrack;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("/userMasterDao")
@SuppressWarnings("unchecked")
public class UserMasterDaoImpl extends GenericDaoImpl<UserMaster, Serializable> implements UserMasterDao{

	@Override
	public UserMaster getUsermasterData(String userId) {
		UserMaster userMaster = (UserMaster)getSessioFactory().getCurrentSession().createCriteria(UserMaster.class)
				.add(Restrictions.eq("id.userId", userId)).uniqueResult();
	
		return userMaster;
	}
	
	public void updateOtpCode(String companyCode, int userType,String userId,String otpCode ){
		
		String sql = "update  user_master set STATUS='O', OTP_CODE='"+otpCode+"' where COMP_CODE='"+companyCode+"' and  USER_TYPE_ID='"+userType+"' and USER_ID='"+userId+"';";
		Query q = getSessioFactory().getCurrentSession().createSQLQuery(sql);
		int ret = q.executeUpdate();
		
		
		
	}
	
	
	public void updateOtpCode(String companyCode, int userType,String userId,String otpCode,String otpGenTime,String otpValidTime ){
		
		String sql = "update  user_master set STATUS='O', OTP_CODE='"+otpCode+"' where COMP_CODE='"+companyCode+"' and  USER_TYPE_ID='"+userType+"' and USER_ID='"+userId+"' ;";
		Query q = getSessioFactory().getCurrentSession().createSQLQuery(sql);
		int ret = q.executeUpdate();
		
		
		
	}
	
	public void updateForgetPasswordOtpCode(String companyCode, int userType,String userId,String otpCode,String otpGenTime,String otpValidTime ){
		
		String sql = "update  user_master set STATUS='F', OTP_CODE='"+otpCode+"' where COMP_CODE='"+companyCode+"' and  USER_TYPE_ID='"+userType+"' and USER_ID='"+userId+"' ;";
		
		System.out.println("sql.."+sql);
		Query q = getSessioFactory().getCurrentSession().createSQLQuery(sql);
		int ret = q.executeUpdate();
		
		
		
	}
	
	
	
	public void restPassword(String companyCode, String userId,int userType,String newPassword ){
		
		String sql = "update user_master set PASSWORD='"+newPassword+"',STATUS='A' where COMP_CODE='"+companyCode+"' and USER_ID='"+userId+"' and USER_TYPE_ID='"+userType+"';";
		Query q = getSessioFactory().getCurrentSession().createSQLQuery(sql);
		int ret = q.executeUpdate();
		
		
		
	}
	
	public void forgotPassword( String userId,String newPassword ){
		
		String sql = "update user_master set PASSWORD='"+newPassword+"',STATUS='A' where  USER_ID='"+userId+"' ;";
		Query q = getSessioFactory().getCurrentSession().createSQLQuery(sql);
		int ret = q.executeUpdate();
		
		
		
	}
	
	@Override
	public void saveOtpHistory(OtpLoginHistory otpLoginHistory) {
		
		
			
			getSessioFactory().getCurrentSession().saveOrUpdate(otpLoginHistory);
		
		
	}
	
	@Override
	public void saveUserTrack(UserTrack userTrack) {
		
		
			
			getSessioFactory().getCurrentSession().saveOrUpdate(userTrack);
		
		
	}
	
	
	 public Menumaster getMenuId(String menuvalue){
		 

		 Menumaster menumaster = (Menumaster) getSessioFactory().getCurrentSession().createCriteria(Menumaster.class)
	                .add(Restrictions.eq("menuValue", menuvalue)).uniqueResult();

	        return menumaster;
	    
	 }
	

    @Override
    public UserMaster CheckValidOtp(String companyCode, int userTypeId,String userId,String otpCode) {
    	UserMaster usermaster = null;
        List<UserMaster> list = getSessioFactory().getCurrentSession().createCriteria(UserMaster.class)
                .add(Restrictions.eq("id.compCode", companyCode)).add(Restrictions.eq("id.userId", userId)).add(Restrictions.eq("id.userTypeId", userTypeId)).add(Restrictions.eq("otpCode", otpCode)).list();
        if (list.size() > 0) {
            for (Iterator<UserMaster> it = list.iterator(); it.hasNext();) {
                usermaster = it.next();
              
                break;
            }
        }
        return usermaster;
    }
    
    
    @Override
    public UserMaster CheckForgetOtp(String userId,String otpCode) {
    	UserMaster usermaster = null;
        List<UserMaster> list = getSessioFactory().getCurrentSession().createCriteria(UserMaster.class)
                .add(Restrictions.eq("id.userId", userId)).add(Restrictions.eq("otpCode", otpCode)).list();
        if (list.size() > 0) {
            for (Iterator<UserMaster> it = list.iterator(); it.hasNext();) {
                usermaster = it.next();
              
                break;
            }
        }
        return usermaster;
    }
    
    

	@Override
	public UserMaster getUserMasterById(String companyCode, int userId) {
		UserMaster userMaster = (UserMaster) getSessioFactory().getCurrentSession().createCriteria(UserMaster.class)
				.add(Restrictions.eq("id.compCode", companyCode)).add(Restrictions.eq("id.userId", userId))
				.uniqueResult();
		if (userMaster != null) {
		
		}
		return userMaster;
	}

	@Override
	public List<UserMaster> getUserMasterByCompanyCode(String companyCode) {
		List<UserMaster> userMasters = getSessioFactory().getCurrentSession().createCriteria(UserMaster.class)
				.add(Restrictions.eq("id.compCode", companyCode)).list();
		if (userMasters.isEmpty()) {
			return null;
		} else {
			for (UserMaster userMaster : userMasters) {
				
			}
		}
		return userMasters;
	}
	
	
	
	
	
	@Override
public List<MenuAccessCustomModel> getAssignedByUser(String companyCode, int userTypeId,String userId) {
	
	System.out.println("Enter the XML Query...");

	String sql = "SELECT ra.MENU_ID,(SELECT MENU_DESC FROM menumaster where MENU_ID=ra.MENU_ID) as MENU_DESC,(SELECT MENU_VALUE FROM menumaster where MENU_ID=ra.MENU_ID) as MENU_VALUE,ura.ROLE_ID  FROM user_role_assignment ura INNER JOIN role_access ra ON ura.comp_code = ra.comp_code and ura.ROLE_ID=ra.ROLE_ID where ura.comp_code='"+companyCode+"' and ura.USER_ID='"+userId+"' and ura.USER_TYPE_ID='"+userTypeId+"'";
	System.out.println("XML Query..." + sql);

	List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

	System.out.println(" getOutstandingData size..." + getOutstandingData.size());
	

	List<MenuAccessCustomModel> rCustomModel = new ArrayList<MenuAccessCustomModel>();

	for (Object[] outReport : getOutstandingData) {

		MenuAccessCustomModel recModel = new MenuAccessCustomModel();

		recModel.setMenuAccessId(outReport[0].toString());
		recModel.setMenuAccessName(outReport[1].toString());
		recModel.setMenuAccessValue(outReport[2].toString());
		recModel.setRoleId(outReport[3].toString());
		
	
	
		

		rCustomModel.add(recModel);
	}
	return rCustomModel;
}
	
	
	public List<DepartmentAccessCustomModel> getDepartmentAccess(String companyCode, String roleId,String menuId){


		String sql = "SELECT (SELECT DEPARTMENT_ID FROM department where DEPARTMENT_ID=dacc.DEPARTMNET_ID and BLOCK='A') as DepartmentId,(SELECT DEPARTMENT_NAME FROM department where DEPARTMENT_ID=dacc.DEPARTMNET_ID and BLOCK='A') as departmentName FROM department_access  dacc where COMP_CODE='"+companyCode+"' and ROLE_ID='"+roleId+"' and MENU_ID='"+menuId+"' and BLOCK='A'";
		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getOutstandingData size..." + getOutstandingData.size());
		

		List<DepartmentAccessCustomModel> rCustomModel = new ArrayList<DepartmentAccessCustomModel>();

		for (Object[] outReport : getOutstandingData) {

			DepartmentAccessCustomModel recModel = new DepartmentAccessCustomModel();

			recModel.setDepartmentAccessId(outReport[0].toString());
			recModel.setDepartmentAccessValue(outReport[1].toString());
			rCustomModel.add(recModel);
		}
		return rCustomModel;
		
		
		
	}
	
	
	public List<DepartmentAccessCustomModel> getDepartmentAccess(String companyCode, List<DepartmentAccessCustomModel> depID,String validDate){
		
		List<DepartmentAccessCustomModel> rCustomModel = new ArrayList<DepartmentAccessCustomModel>();
		
		for (DepartmentAccessCustomModel outReport : depID) {

			DepartmentAccessCustomModel dacm=new DepartmentAccessCustomModel();
		String sql = "SELECT * FROM product_li where COMP_CODE='"+companyCode+"' and status='A' and DEPARTMENT_VISIBLE_ID='"+outReport.getDepartmentAccessId()+"' and FROM_DATE<='"+validDate+"' and TO_DATE>='"+validDate+"'";
		System.out.println("XML Query..." + sql);
		
		

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();
		
		dacm.setDepartmentAccessId(outReport.getDepartmentAccessId());
		dacm.setDepartmentAccessValue(outReport.getDepartmentAccessValue());
		
		if(getOutstandingData.size()>0){
			
			dacm.setDisplayflag(true);
			
		}else{
			
			dacm.setDisplayflag(false);	
		}
		
		rCustomModel.add(dacm);
		
		}

	
		return rCustomModel;
		
		
		
	}
	
	
	//................... Department Access Start .............//
	
	
	
	public List<DepartmentAccessCustomModel> getDepartmentLandOwnerAgreementStatusAccess(String companyCode, List<DepartmentAccessCustomModel> depID,String validDate){
		
		List<DepartmentAccessCustomModel> rCustomModel = new ArrayList<DepartmentAccessCustomModel>();
		
		for (DepartmentAccessCustomModel outReport : depID) {
			
		DepartmentAccessCustomModel dacm=new DepartmentAccessCustomModel();
		String sql = "SELECT * FROM agreement where COMP_CODE='"+companyCode+"' and status='A' and departmentData='"+outReport.getDepartmentAccessId()+"' and FROM_DATE<='"+validDate+"' and TO_DATE>='"+validDate+"'";
		System.out.println("LandOwner Agreement Status Query..." + sql);
		
		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();
		
		dacm.setDepartmentAccessId(outReport.getDepartmentAccessId());
		dacm.setDepartmentAccessValue(outReport.getDepartmentAccessValue());
		
		if(getOutstandingData.size()>0){
			dacm.setDisplayflag(true);	
		}else{
			dacm.setDisplayflag(false);	
		}
		rCustomModel.add(dacm);
		
		}

	
		return rCustomModel;
		
		
		
	}
	
	
	
	
	//................... Department Access End .............//
	
	
	public List<DepartmentAccessCustomModel> getSchemeDepartmentAccess(String companyCode, List<DepartmentAccessCustomModel> depID,String vaildDate){
		
		List<DepartmentAccessCustomModel> rCustomModel = new ArrayList<DepartmentAccessCustomModel>();
		
		for (DepartmentAccessCustomModel outReport : depID) {

			DepartmentAccessCustomModel dacm=new DepartmentAccessCustomModel();
		String sql = "SELECT * FROM scheme_li where COMP_CODE='"+companyCode+"' and status='A' and DEPARTMENT_VISIBLE_ID='"+outReport.getDepartmentAccessId()+"' and FROM_DATE<='"+vaildDate+"' and TO_DATE>='"+vaildDate+"'";
		System.out.println("XML Query..." + sql);
		
		

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();
		
		dacm.setDepartmentAccessId(outReport.getDepartmentAccessId());
		dacm.setDepartmentAccessValue(outReport.getDepartmentAccessValue());
		
		if(getOutstandingData.size()>0){
			
			dacm.setDisplayflag(true);
			
		}else{
			
			dacm.setDisplayflag(false);	
		}
		
		rCustomModel.add(dacm);
		
		}

	
		return rCustomModel;
		
		
		
	}
	
	
	
	@Override
	public List<UserMenuAssignment> getAssignedUser(String companyCode, int userTypeId,String userId) {
		List<UserMenuAssignment> userMenuAssignment = getSessioFactory().getCurrentSession().createCriteria(UserMenuAssignment.class)
				.add(Restrictions.eq("id.compCode", companyCode)).add(Restrictions.eq("id.userId", userId)).add(Restrictions.eq("id.userTypeId", userTypeId)).list();
		if (userMenuAssignment.isEmpty()) {
			return null;
		} else {
		
		}
		return userMenuAssignment;
	}
	
	
	@Override
	public  UserTrack findUserTrackById(String sessionId, String userId) {
		UserTrack userTrack = (UserTrack) getSessioFactory().getCurrentSession().createCriteria(UserTrack.class)
				.add(Restrictions.eq("id.sessionId", sessionId)).add(Restrictions.eq("id.userId", userId))
				.uniqueResult();
		
		return userTrack;
	}

	
    @Override
    public boolean validateRole(String compCode,String roleId,String AccessRoleId) {
    	
    	System.out.println("roleId.."+roleId+"AccessRoleId.."+AccessRoleId);
    	boolean result=false;
        List<SuperRoleAccess> list = getSessioFactory().getCurrentSession().createCriteria(SuperRoleAccess.class)
                .add(Restrictions.eq("id.compCode", compCode)).add(Restrictions.eq("id.roleId", Integer.parseInt(roleId)))
                		.add(Restrictions.eq("id.accessRoleId", Integer.parseInt(AccessRoleId))).list();
        if (list.size() > 0) {
        	result=true;
        }
        return result;
    }
	
	
//	@Override
//	public int updateUserTrack(String sessionId, String userId,int userType, java.sql.Date loggedDate,java.util.Date loggedTime) {
//		int ret = 0;
//
//		Query query = getSessioFactory()
//				.getCurrentSession()
//				.createQuery(
//						"update UserTrack set loggedDate=:loggedDate,loggedTime=:loggedTime  where id.sessionId=:sessionId and id.userId=:userId and userTypeId=:userTypeId");
//		query.setParameter("sessionId", sessionId);
//		query.setParameter("userId", userId);
//		query.setParameter("loggedDate", loggedDate);
//		query.setParameter("loggedTime", loggedTime);
//		 query.setParameter("userTypeId", userType);
//
//		query.executeUpdate();
//
//		System.out.println("updated user login.." + query);
//
//		return ret;
//	}
	
	
}
