package org.clss.businessportal.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.OutstandingReportCustomModel;
import org.clss.businessportal.custommodel.ProductByDepartmentCustomModel;
import org.clss.businessportal.dao.CfaDao;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.entity.Product;
import org.clss.businessportal.entity.ProductLi;
import org.clss.businessportal.entity.Scheme;
import org.clss.businessportal.entity.TdsCetificate;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class CfaController {
	
	@Autowired
	private CfaDao cfaDao;
	
	@Autowired
	private VendorMasterDao vendorMasterDao;
	
	 @Autowired ServletContext context;
	 
		@Autowired
		private Util util;
	 
	 
	///...... New Product Launch Start .... 
	
	@RequestMapping("/getProductByDepartment")
	public @ResponseBody JqgridResponse getProductByDepartment(HttpServletRequest req,@RequestParam(value = "departmentId") String departmentId) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		String companyCode = (String) req.getSession().getAttribute("companyCode");
		List<ProductByDepartmentCustomModel> rCustomModel = new ArrayList<ProductByDepartmentCustomModel>();
		String userId = (String) req.getSession().getAttribute("userId");
		try {
			   long millis=System.currentTimeMillis();  
		        java.sql.Date date=new java.sql.Date(millis);  
			
			List<Object[]> getOutstandingReport=cfaDao.getProductByDepartment(companyCode, departmentId,""+date);
			for (Object[] outReport : getOutstandingReport) {
				ProductByDepartmentCustomModel jObject = new ProductByDepartmentCustomModel();
				
				jObject.setCompCode(outReport[1].toString());
				jObject.setItemNo(outReport[0].toString());
				jObject.setDepartment(outReport[2].toString());
				jObject.setProductName(outReport[3].toString());
				jObject.setFileName(outReport[4].toString());
				rCustomModel.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JqgridResponse<ProductByDepartmentCustomModel> dataGrid = new JqgridResponse<ProductByDepartmentCustomModel>(rCustomModel);
		
		return dataGrid;
	}
	
	
	@RequestMapping(value = "/productImageById")
	public @ResponseBody void productImageById(@RequestParam(value = "itemNo") String itemNo,@RequestParam(value = "compCode") String compCode,@RequestParam(value = "departmentId") String departmentId,
												HttpServletResponse response,HttpServletRequest request) throws IOException {
		try{
		 String filepath = null;
	
	
		 
		String cpath = context.getRealPath("/");
		Product image = cfaDao.getProductImageById(itemNo,compCode,departmentId);
			 if(image!=null){
				 response.setContentType(image.getFileType());
			    response.getOutputStream().write(image.getFileContent());
			    response.getOutputStream().close();
			 }else{
				 filepath = cpath + "/resources/img/TDSCertificate.png";
				 File file = new File(filepath);
				 FileInputStream fis = new FileInputStream(file);
//				 byte[] bFile = new byte[(int) file.length()];
				 BufferedInputStream bis = new BufferedInputStream(fis); 
				 response.setContentType("application/pdf");
//				 response.getOutputStream().write(bFile);
		         BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
		         for (int data; (data = bis.read()) > -1;) {
		           output.write(data);
		         }             
				 
//				 response.getOutputStream().write(bis.read());
				 response.getOutputStream().close();
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	///...... New Product Launch End .... 
	
	///...... New Scheme Launch Start .... 
	
	@RequestMapping("/getSchemeByDepartment")
	public @ResponseBody JqgridResponse getSchemeByDepartment(HttpServletRequest req,@RequestParam(value = "departmentId") String departmentId) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		String companyCode = (String) req.getSession().getAttribute("companyCode");
		List<ProductByDepartmentCustomModel> rCustomModel = new ArrayList<ProductByDepartmentCustomModel>();
		String userId = (String) req.getSession().getAttribute("userId");
		try {
			   long millis=System.currentTimeMillis();  
		        java.sql.Date date=new java.sql.Date(millis);  
			
			List<Object[]> getOutstandingReport=cfaDao.getSchemeByDepartment(companyCode, departmentId,""+date);
			for (Object[] outReport : getOutstandingReport) {
				ProductByDepartmentCustomModel jObject = new ProductByDepartmentCustomModel();
				
				jObject.setCompCode(outReport[1].toString());
				jObject.setItemNo(outReport[0].toString());
				jObject.setDepartment(outReport[2].toString());
				jObject.setProductName(outReport[3].toString());
				jObject.setFileName(outReport[4].toString());
				rCustomModel.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JqgridResponse<ProductByDepartmentCustomModel> dataGrid = new JqgridResponse<ProductByDepartmentCustomModel>(rCustomModel);
		
		return dataGrid;
	}
	
	
	
	@RequestMapping(value = "/schemeImageById")
	public @ResponseBody void schemeImageById(@RequestParam(value = "itemNo") String itemNo,@RequestParam(value = "compCode") String compCode,@RequestParam(value = "departmentId") String departmentId,
												HttpServletResponse response,HttpServletRequest request) throws IOException {
		try{
		 String filepath = null;
	
	
		 
		String cpath = context.getRealPath("/");

		Scheme image = cfaDao.getSchemeImageById(itemNo,compCode,departmentId);
			 if(image!=null){
				 response.setContentType(image.getFileType());
			    response.getOutputStream().write(image.getFileContent());
			    response.getOutputStream().close();
			 }else{
				 filepath = cpath + "/resources/img/TDSCertificate.png";
				 File file = new File(filepath);
				 FileInputStream fis = new FileInputStream(file);
//				 byte[] bFile = new byte[(int) file.length()];
				 BufferedInputStream bis = new BufferedInputStream(fis); 
				 response.setContentType("application/pdf");
//				 response.getOutputStream().write(bFile);
		         BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
		         for (int data; (data = bis.read()) > -1;) {
		           output.write(data);
		         }             
				 
//				 response.getOutputStream().write(bis.read());
				 response.getOutputStream().close();
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	///...... New Scheme Launch End .... 
	
	
	@RequestMapping("/getTransportationChargeReport")
	public @ResponseBody JqgridResponse getTransportationChargeReport(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,@RequestParam(value = "itemType") String itemType,
			HttpServletRequest request) throws ParseException {

		System.out.println("selected_date.."+selected_date);
		
		Format format = com.ibm.icu.text.NumberFormat.getCurrencyInstance(new Locale("en", "in"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");
		
		
		
		 Date selected_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_date);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate = formatter.format(selected_date_for);
		 
		 
		 Date selected_to_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_to_date);
		 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate_to = formatter1.format(selected_to_date_for);

		List<Object[]> getOutstandingReport = vendorMasterDao.getTransportationChargeReport(companyCode,
				String.valueOf(userId),
				"" + parsedDate,	""+parsedDate_to,itemType);

		List<OutstandingReportCustomModel> rCustomModel = new ArrayList<OutstandingReportCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			OutstandingReportCustomModel recModel = new OutstandingReportCustomModel();

			recModel.setCompCode(outReport[0].toString());
			recModel.setVendorcode(outReport[1].toString());
			recModel.setDocNo(outReport[2].toString());
			recModel.setFiYear(outReport[3].toString());
			recModel.setDocType(outReport[4].toString());
			recModel.setDocDate(outReport[5].toString());
			recModel.setPostingDate(outReport[6].toString());
		
			
			

			if (outReport[8].toString().equals("H")) {
				recModel.setAmount("" +  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));
				recModel.setCreditAmount("" +  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));

			} else if (outReport[8].toString().equals("S")) {
				recModel.setAmount("" +  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));
				recModel.setDebitAmount("" +  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));

			}
			if (util.getNoOfDaysBtwnDates(outReport[5].toString())<=15) {
				recModel.setTo15(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 30) {
				recModel.setTo30(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 45) {
				recModel.setTo45(outReport[7].toString());

			} 
			recModel.setVendorName(outReport[9].toString());
			recModel.setDocTypeName(outReport[10].toString());
			
			if(outReport[12]!=null){
				recModel.setRemark(""+outReport[12].toString());
			}else{
				
				recModel.setRemark("");
			}
			
			
		
			

			rCustomModel.add(recModel);
		}

		
		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	
	
	@RequestMapping("/getCommissionChargeReport")
	public @ResponseBody JqgridResponse getOutstandingMonthlyReport(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,@RequestParam(value = "itemType") String itemType,
			HttpServletRequest request) throws ParseException {

		System.out.println("selected_date.."+selected_date);
		
		Format format = com.ibm.icu.text.NumberFormat.getCurrencyInstance(new Locale("en", "in"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");
		
		
		
		 Date selected_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_date);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate = formatter.format(selected_date_for);
		 
		 
		 Date selected_to_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_to_date);
		 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate_to = formatter1.format(selected_to_date_for);

		List<Object[]> getOutstandingReport = vendorMasterDao.getCommissionChargeReport(companyCode,
				String.valueOf(userId),
				"" + parsedDate,	""+parsedDate_to,itemType);

		List<OutstandingReportCustomModel> rCustomModel = new ArrayList<OutstandingReportCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			OutstandingReportCustomModel recModel = new OutstandingReportCustomModel();

			recModel.setCompCode(outReport[0].toString());
			recModel.setVendorcode(outReport[1].toString());
			recModel.setDocNo(outReport[2].toString());
			recModel.setFiYear(outReport[3].toString());
			recModel.setDocType(outReport[4].toString());
			recModel.setDocDate(outReport[5].toString());
			recModel.setPostingDate(outReport[6].toString());
		
			
			

			if (outReport[8].toString().equals("H")) {
				recModel.setAmount("" +  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));
				recModel.setCreditAmount("" +  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));

			} else if (outReport[8].toString().equals("S")) {
				recModel.setAmount("" +  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));
				recModel.setDebitAmount("" +  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));

			}
			if (util.getNoOfDaysBtwnDates(outReport[5].toString())<=15) {
				recModel.setTo15(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 30) {
				recModel.setTo30(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 45) {
				recModel.setTo45(outReport[7].toString());

			} 
			recModel.setVendorName(outReport[9].toString());
			recModel.setDocTypeName(outReport[10].toString());
			
			if(outReport[12]!=null){
				recModel.setRemark(""+outReport[12].toString());
			}else{
				
				recModel.setRemark("");
			}
			
			
		
			

			rCustomModel.add(recModel);
		}

		
		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(rCustomModel);
		return dataGrid;
	}

}
