package org.clss.businessportal.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.dao.LogisticTransHeaderDao;
import org.clss.businessportal.entity.LogisticTransHeader;
import org.clss.businessportal.entity.LogisticTransItem;
import org.springframework.stereotype.Repository;

@Repository("/logisticTransHeaderDao")
public class LogisticTransHeaderDaoImpl  extends GenericDaoImpl<LogisticTransHeader, Serializable> implements LogisticTransHeaderDao{

	@Override
	public List<LogisticTransHeader> getMonthlyVehicleDetailsReportForLogistics(String compCode, String vendorCode,
			String fromDate, String toDate) {
		String sql = "select * from logistic_trans_header where transporter='"+vendorCode+"' and comp_code='"+compCode+"' and ((bill_prd_str between '"+fromDate+"' and '"+toDate+"') or (bill_prd_end between '"+fromDate+"' and '"+toDate+"'))";
		return getSessioFactory().getCurrentSession().createSQLQuery(sql).addEntity(LogisticTransHeader.class).list();
	}

	@Override
	public List<LogisticTransItem> getTransItems(String compCode, String vendorCode, String plant, String route,
			String fdate, String edate) {
		String sql = "select * from logistic_trans_item where comp_code='"+compCode+"' and transporter='"+vendorCode+"' "
				+ "and werks='"+plant+"' and route_no='"+route+"' and (crdat between '"+fdate+"' and '"+edate+"')";
		return getSessioFactory().getCurrentSession().createSQLQuery(sql).addEntity(LogisticTransItem.class).list();
	}

	@Override
	public List<Object[]> getArrearDetails(String compCode, String vendorCode, String plant, String route, String fdate,
			String edate) {
		String sql = "select a.arrear_code,b.arrear_name,a.amt from logistic_arrear as a inner join arrear_master as b on a.arrear_code=b.arrear_code "
				+ "where a.comp_code='"+compCode+"' and a.transporter='"+vendorCode+"' and a.plant='"+plant+"' "
				+ "and a.route_no='"+route+"' and (a.arrear_dat between '"+fdate+"' and '"+edate+"')";
		return getSessioFactory().getCurrentSession().createSQLQuery(sql).list();
	}

	@Override
	public List<Object[]> getDeductionDetails(String compCode, String vendorCode, String plant, String route,
			String fdate, String edate) {
		String sql = "select a.zdedtype,b.deduction_desc,a.zdedamt from logistic_deduction as a inner join deduction_master as b on a.zdedtype=b.deduction_code "
				+ "where a.comp_code='"+compCode+"' and a.zvendor='"+vendorCode+"' and a.zwerks='"+plant+"' "
				+ "and a.route_no='"+route+"' and (a.zedate between '"+fdate+"' and '"+edate+"')";
		return getSessioFactory().getCurrentSession().createSQLQuery(sql).list();
	}
}
