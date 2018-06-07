package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import org.clss.businessportal.dao.FtpDao;
import org.clss.businessportal.entity.FtpConfig;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("/ftpDao")
public class FtpDaoImpl extends GenericDaoImpl<FtpConfig, Serializable> implements FtpDao{

	@Override
	public FtpConfig getFtpConfiguration(String  menuType,String  configType,String  status) {
		
		FtpConfig ftpConfig = (FtpConfig)getSessioFactory().getCurrentSession().createCriteria(FtpConfig.class)
//				.add(Restrictions.eq("id.menuType", menuType))
//				.add(Restrictions.eq("id.configType", configType))
				.add(Restrictions.eq("status", status))
				.uniqueResult();
		
	
		return ftpConfig;
	}
	

}
