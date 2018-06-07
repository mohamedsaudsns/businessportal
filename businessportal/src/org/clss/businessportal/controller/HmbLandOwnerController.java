package org.clss.businessportal.controller;

import java.math.BigDecimal;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.clss.businessportal.custommodel.FiledForceCustomModel;
import org.clss.businessportal.custommodel.FiledForceStaffCustomModel;
import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.OutstandingReportCustomModel;
import org.clss.businessportal.custommodel.ProductByDepartmentCustomModel;
import org.clss.businessportal.dao.AdminDao;
import org.clss.businessportal.dao.CfaDao;
import org.clss.businessportal.dao.DepartmentDao;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.entity.Department;
import org.clss.businessportal.entity.FiledForce;
import org.clss.businessportal.entity.FiledForcePK;
import org.clss.businessportal.entity.GroupPosition;
import org.clss.businessportal.entity.GroupPositionPK;
import org.clss.businessportal.entity.Product;
import org.clss.businessportal.entity.ProductLi;
import org.clss.businessportal.entity.ProductLiPK;
import org.clss.businessportal.entity.ProductPK;
import org.clss.businessportal.entity.Scheme;
import org.clss.businessportal.entity.SchemeLi;
import org.clss.businessportal.entity.SchemeLiPK;
import org.clss.businessportal.entity.SchemePK;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class HmbLandOwnerController {

	 @Autowired
		private VendorMasterDao vendorMasterDao;

	
	 @RequestMapping("/getRentalPaymentStauswithmonth")
		public @ResponseBody JqgridResponse getRentalPaymentStauswithmonth(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,@RequestParam(value = "itemType") String itemType,
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

			List<Object[]> getOutstandingReport = vendorMasterDao.getRentalPaymentStauswithmonth(companyCode,
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
					recModel.setAmount("-" +  Util.indianRupeeFormat(""+outReport[7].toString()));
					recModel.setCreditAmount( ""+  Util.indianRupeeFormat(""+outReport[7].toString()));

				} else if (outReport[8].toString().equals("S")) {
					recModel.setAmount( ""+  Util.indianRupeeFormat(""+outReport[7].toString()));
					recModel.setDebitAmount("" +  Util.indianRupeeFormat(""+outReport[7].toString()));

				}
				if (Util.getNoOfDaysBtwnDates(outReport[5].toString())<=15) {
					recModel.setTo15(outReport[7].toString());

				} else if (Util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 30) {
					recModel.setTo30(outReport[7].toString());

				} else if (Util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 45) {
					recModel.setTo45(outReport[7].toString());

				} 
				recModel.setVendorName(outReport[9].toString());
				recModel.setDocTypeName(outReport[10].toString());
				
				if(outReport[11]!=null){
					recModel.setRemark(""+outReport[11].toString());
				}else{
					
					recModel.setRemark("");
				}
				
				if(outReport[7]!=null){
					recModel.setRentAmount("" +  Util.indianRupeeFormat(""+outReport[7].toString().replace("-","")));
				}else{
					
					recModel.setRentAmount("");
				}
				
				if(outReport[12]!=null){
					recModel.setTdsAmount(""+   Util.indianRupeeFormat(""+outReport[12].toString()));
				}else{
					
					recModel.setTdsAmount("");
				}
				
				
				 BigDecimal rentAmountBig = new BigDecimal(outReport[7].toString().replace("-",""));
				 BigDecimal tedAmountBig = new BigDecimal(outReport[12].toString());
				 
				 BigDecimal netAmount ;
				 
				 
				
				 netAmount=rentAmountBig.subtract(tedAmountBig);
		
				recModel.setNetAmount(""+   Util.indianRupeeFormat(""+netAmount));
				
			
				

				rCustomModel.add(recModel);
			}

			
			JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(rCustomModel);
			return dataGrid;
		}
	 
	
	

}
