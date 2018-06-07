package org.clss.businessportal.daoImpl;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.dao.CfaDao;
import org.clss.businessportal.entity.NewsLetter;
import org.clss.businessportal.entity.Product;
import org.clss.businessportal.entity.ProductLi;
import org.clss.businessportal.entity.Scheme;
import org.clss.businessportal.entity.SchemeLi;
import org.clss.businessportal.entity.TdsCetificate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("/cfaDao")
public class CfaDaoImpl extends GenericDaoImpl<Product, Serializable> implements CfaDao{

	@Override
	public void saveProduct(Product prd){
		getSessioFactory().getCurrentSession().saveOrUpdate(prd);
	
		
		
	}
	
	@Override
	public void saveNewsLetter(NewsLetter prd){
		getSessioFactory().getCurrentSession().saveOrUpdate(prd);
	
		
		
	}
	
	@Override
	public void saveProductLi(ProductLi prd){
	
		getSessioFactory().getCurrentSession().saveOrUpdate(prd);

		
		
	}
	
	public int deleteProduct(String compCode,String itemCode,String departmentId){
		
		
		
		String sql = "update product set status='X' where ITEM_NO='"+itemCode+"' and COMP_CODE='"+compCode+"' and DEPARTMENT_ID='"+departmentId+"';";
		Query q = getSessioFactory().getCurrentSession().createSQLQuery(sql);
		int ret = q.executeUpdate();
		
		
		
		String sql1 = "update product_li set status='X' where ITEM_NO='"+itemCode+"' and COMP_CODE='"+compCode+"' and DEPARTMENT_ID='"+departmentId+"';";
		Query q1 = getSessioFactory().getCurrentSession().createSQLQuery(sql1);
		int ret1 = q1.executeUpdate();
		
		return ret;
	}
	
	
	@Override
	public List<Product> getProductList(String comp,String depart) {

		List<Product> productList = null;

		productList = (List<Product>) getSessioFactory().getCurrentSession().createCriteria(Product.class)
				.add(Restrictions.eq("id.compCode", comp)).add(Restrictions.eq("id.departmentId", Integer.parseInt(depart))).add(Restrictions.eq("status", "A")).list();

		return productList;
	}
	
	
	
	
	@Override
	public void saveScheme(Scheme prd){
		getSessioFactory().getCurrentSession().saveOrUpdate(prd);
	
		
		
	}
	
	@Override
	public void saveSchemeLi(SchemeLi prd){
	
		getSessioFactory().getCurrentSession().saveOrUpdate(prd);

		
		
	}
	
	public int deleteScheme(String compCode,String itemCode,String departmentId){
		
		
		
		String sql = "update scheme set status='X' where ITEM_NO='"+itemCode+"' and COMP_CODE='"+compCode+"' and DEPARTMENT_ID='"+departmentId+"';";
		Query q = getSessioFactory().getCurrentSession().createSQLQuery(sql);
		int ret = q.executeUpdate();
		
		
		String sql1 = "update scheme_li set status='X' where ITEM_NO='"+itemCode+"' and COMP_CODE='"+compCode+"' and DEPARTMENT_ID='"+departmentId+"';";
		Query q1 = getSessioFactory().getCurrentSession().createSQLQuery(sql1);
		int ret1 = q1.executeUpdate();
		
		return ret;
	}
	
	
	@Override
	public List<Scheme> getSchemeList(String comp,String depart) {

		List<Scheme> productList = null;

		productList = (List<Scheme>) getSessioFactory().getCurrentSession().createCriteria(Scheme.class)
				.add(Restrictions.eq("id.compCode", comp)).add(Restrictions.eq("id.departmentId", Integer.parseInt(depart))).add(Restrictions.eq("status", "A")).list();

		return productList;
	}
	
	
	
	

	
	@Override
	public List<Object[]> getProductByDepartment(String comp,String department,String validDate){

		String sql = "";


			sql = "SELECT prd.ITEM_NO,prd.COMP_CODE,prd.DEPARTMENT_ID,prd.PRODUCT_NAME,prd.FILE_NAME FROM product_li li,product prd where li.DEPARTMENT_VISIBLE_ID='"+department+"' and li.STATUS='A' and  prd.FROM_DATE<='"+validDate+"' and prd.TO_DATE>='"+validDate+"' and prd.item_no=li.item_no and prd.comp_code=li.comp_code and prd.department_id=li.department_id";
	

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getProductByDepartment size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	@Override
	public List<Object[]> getSchemeByDepartment(String comp,String department,String validDate){

		String sql = "";


			sql = "SELECT prd.ITEM_NO,prd.COMP_CODE,prd.DEPARTMENT_ID,prd.SCHEME_NAME,prd.FILE_NAME FROM scheme_li li,scheme prd where li.DEPARTMENT_VISIBLE_ID='"+department+"' and li.STATUS='A' and  prd.FROM_DATE<='"+validDate+"' and prd.TO_DATE>='"+validDate+"' and prd.item_no=li.item_no and prd.comp_code=li.comp_code and prd.department_id=li.department_id";
	

		System.out.println("XML Query..." + sql);

		List<Object[]> getOutstandingData = getSessioFactory().getCurrentSession().createSQLQuery(sql).list();

		System.out.println(" getProductByDepartment size..." + getOutstandingData.size());

		return getOutstandingData;
	}
	
	
	
	
	
	public	Product getProductImageById(String itemNo, String compCode,String departmentId) {
		Product image = (Product) getSessioFactory().getCurrentSession().createCriteria(Product.class)
				.add(Restrictions.eq("id.itemNo", Integer.parseInt(itemNo))).add(Restrictions.eq("id.compCode", compCode))
				.add(Restrictions.eq("id.departmentId", Integer.parseInt(departmentId))).uniqueResult();

		return image;
	}
	
	
	public	Scheme getSchemeImageById(String itemNo, String compCode,String departmentId)  {
		Scheme image = (Scheme) getSessioFactory().getCurrentSession().createCriteria(Scheme.class)
				.add(Restrictions.eq("id.itemNo", Integer.parseInt(itemNo))).add(Restrictions.eq("id.compCode", compCode))
				.add(Restrictions.eq("id.departmentId", Integer.parseInt(departmentId))).uniqueResult();

		return image;
	}
	
	

}
