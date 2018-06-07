package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import org.clss.businessportal.entity.FtpConfig;



public interface FtpDao extends GenericDao<FtpConfig, Serializable>{
	
	public FtpConfig getFtpConfiguration(String  menuType,String  configType,String  status);
	

	



}
