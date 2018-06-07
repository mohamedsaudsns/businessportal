package org.clss.businessportal.dao;

/**
*
* @author Mohamed Saud SNS
*/


import java.io.Serializable;
import java.util.List;

import org.clss.businessportal.entity.NewsLetter;
import org.clss.businessportal.entity.Product;
import org.clss.businessportal.entity.ProductLi;
import org.clss.businessportal.entity.Scheme;
import org.clss.businessportal.entity.SchemeLi;
import org.clss.businessportal.entity.TdsCetificate;



public interface CfaDao extends GenericDao<Product, Serializable>{
	
	public void saveProduct(Product prd);
	
	public void saveNewsLetter(NewsLetter prd);
	
	public void saveProductLi(ProductLi prd);
	
	public int deleteProduct(String compCode,String itemCode,String departmentId);
	
	public List<Product> getProductList(String comp,String department);
	
	
	
public void saveScheme(Scheme prd);
	
	public void saveSchemeLi(SchemeLi prd);
	
	public int deleteScheme(String compCode,String itemCode,String departmentId);
	
	public List<Scheme> getSchemeList(String comp,String department);
	
	public List<Object[]> getProductByDepartment(String comp,String department,String validDate);
	
	public List<Object[]> getSchemeByDepartment(String comp,String department,String validDate);
	
	
	
	Product getProductImageById(String itemNo, String compCode,String departmentId);
	
	Scheme getSchemeImageById(String itemNo, String compCode,String departmentId);
	
	

	



}
