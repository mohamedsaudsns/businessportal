package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.entity.AgreementHa;
import org.clss.businessportal.entity.AgreementLi;
import org.clss.businessportal.entity.FiledForce;
import org.clss.businessportal.entity.TdsCetificate;
import org.clss.businessportal.entity.VendorMaster;



public interface AgreementDao extends GenericDao<AgreementHa, Serializable>{

	
	public List<AgreementHa> getAgreementData(String  compCode,String vendorCode);
	
	public List<TdsCetificate> getTDSData(String  compCode,String fiYear,String panNo);
	
	public List<AgreementLi> getAgreementLineItem(String  compCode,String vendorCode,String fiYear,String AgreementNo);
	
	void saveTds(TdsCetificate tds);
	
	TdsCetificate getTdsCertificateById(String compCode, String fiyear,String quater,String panNo);
	
//	List<FiledForce> getFiledForce(String compCode, String vendorCode);
	
	public FiledForce getFiledForce(String companyCode,String vendorCode);
	

}
