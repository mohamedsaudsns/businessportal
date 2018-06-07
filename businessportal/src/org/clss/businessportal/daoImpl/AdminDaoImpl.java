package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.dao.AdminDao;
import org.clss.businessportal.entity.FiledForce;
import org.springframework.stereotype.Repository;

@Repository("/adminDao")
public class AdminDaoImpl extends GenericDaoImpl<FiledForce, Serializable> implements AdminDao{

	@Override
	public void saveFiledForce(List<FiledForce> ff){
		
		for(FiledForce filedForce : ff){
		getSessioFactory().getCurrentSession().saveOrUpdate(filedForce);
		}
	
	}
	
	@Override
	public List<Object[]> getUserTrackList(String vendorCode, String fromDate, String toDate) {

		String sql = "SELECT SESSION_ID,USER_ID,USER_TYPE_ID,LOGIN_IP,SERVER_IP,DATE_FORMAT(LOGIN_DATE,'%d/%m/%Y') as LOGIN_DATE,LOGIN_TIME,(case when (concat(LOGIN_DATE,LOGIN_TIME)=concat(LOGGED_DATE,LOGGED_TIME)) THEN '' ELSE DATE_FORMAT(LOGGED_DATE,'%d/%m/%Y')  END) as LOGGED_DATE,(case when (concat(LOGIN_DATE,LOGIN_TIME)=concat(LOGGED_DATE,LOGGED_TIME)) THEN '' ELSE LOGGED_TIME END) as LOGGED_TIME  FROM user_track where USER_ID='"+vendorCode+"' and LOGIN_DATE Between '"+fromDate+"' and '"+toDate+"' order by LOGIN_DATE DESC,LOGIN_TIME DESC";

		System.out.println("XML Query..." + sql);

		List<Object[]> getUserTrackData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" User Track size..." + getUserTrackData.size());

		return getUserTrackData;
	}
	
	
	
	
	

}
