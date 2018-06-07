package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/

import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.dao.AgreementDao;
import org.clss.businessportal.entity.AgreementHa;
import org.clss.businessportal.entity.AgreementLi;
import org.clss.businessportal.entity.FiledForce;
import org.clss.businessportal.entity.TdsCetificate;
import org.clss.businessportal.entity.VendorMaster;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("/AgreementDao")
@SuppressWarnings("unchecked")
public class AgreementDaoImpl extends GenericDaoImpl<AgreementHa, Serializable> implements AgreementDao {

	@Override
	public List<AgreementHa> getAgreementData(String compCode, String vendorCode) {

		List<AgreementHa> agreementList = null;

		agreementList = (List<AgreementHa>) getSessioFactory().getCurrentSession().createCriteria(AgreementHa.class)
				.add(Restrictions.eq("id.compCode", compCode)).add(Restrictions.eq("id.vendorCode", vendorCode)).list();

		return agreementList;
	}

	public List<TdsCetificate> getTDSData(String compCode,String fiYear,String panNo) {

		List<TdsCetificate> tdsList = null;

		tdsList = (List<TdsCetificate>) getSessioFactory().getCurrentSession().createCriteria(TdsCetificate.class)
				.add(Restrictions.eq("id.compCode", compCode)).add(Restrictions.eq("id.panNo", panNo))
				.add(Restrictions.eq("id.ficsalYear", fiYear)).list();

		return tdsList;
	}
	
public List<AgreementLi> getAgreementLineItem(String  compCode,String vendorCode,String fiYear,String AgreementNo) {
	
	System.out.println("compCode.."+compCode+"..vendorCode..."+vendorCode+"..fiYear.."+fiYear+"....AgreementNo"+AgreementNo);

		List<AgreementLi> tdsList = null;

		tdsList = (List<AgreementLi>) getSessioFactory().getCurrentSession().createCriteria(AgreementLi.class)
				.add(Restrictions.eq("id.compCode", compCode)).add(Restrictions.eq("id.vendorCode", vendorCode))
				.add(Restrictions.eq("id.fiscalYear", fiYear)).add(Restrictions.eq("id.agreementNo", AgreementNo)).list();

		return tdsList;
	}

	public void saveTds(TdsCetificate tds) {
		getSessioFactory().getCurrentSession().saveOrUpdate(tds);

	}
	
	
	@Override
	public FiledForce getFiledForce(String companyCode, String vendorCode) {
		
		
		System.out.println("companyCode.."+companyCode+"..vendorCode"+vendorCode);
		FiledForce vendorMaster = (FiledForce)getSessioFactory().getCurrentSession().createCriteria(FiledForce.class)
				.add(Restrictions.eq("id.compCode", companyCode))
				.add(Restrictions.eq("id.vendorCode",vendorCode)).uniqueResult();
		
	
		return vendorMaster;
	}

	public TdsCetificate getTdsCertificateById(String compCode,  String fiyear, String quater,String panNo) {
		TdsCetificate image = (TdsCetificate) getSessioFactory().getCurrentSession().createCriteria(TdsCetificate.class)
				.add(Restrictions.eq("id.compCode", compCode)).add(Restrictions.eq("id.panNo", panNo))
				.add(Restrictions.eq("id.ficsalYear", fiyear)).add(Restrictions.eq("id.quater", quater)).uniqueResult();

		return image;
	}

//	public List<FiledForce> getFiledForce(String compCode, String vendorCode) {
//
//		List<FiledForce> tdsList = null;
//
//		tdsList = (List<FiledForce>) getSessioFactory().getCurrentSession().createCriteria(FiledForce.class)
//				.add(Restrictions.eq("id.compCode", compCode)).add(Restrictions.eq("id.vendorCode", vendorCode)).list();
//
//		return tdsList;
//	}

}
