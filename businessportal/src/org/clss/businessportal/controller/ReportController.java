package org.clss.businessportal.controller;

/**
*
* @author Mohamed Saud SNS
*/


import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import org.clss.businessportal.custommodel.CustomerOutstandingReportCustomModel;
import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.OutstandingReportCustomModel;
import org.clss.businessportal.dao.CustomerMasterDao;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReportController {

	@Autowired
	private VendorMasterDao vendorMasterDao;
	
	private CustomerMasterDao customerMasterDao;

	@Autowired
	private Util util;

	@RequestMapping("/getOutstandingReport")
	public @ResponseBody JqgridResponse getOutstandingReport(@RequestParam(value = "selected_date") String selected_date,
			HttpServletRequest request) throws ParseException {

		Format format = com.ibm.icu.text.NumberFormat.getCurrencyInstance(new Locale("en", "in"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		List<Object[]> getOutstandingReport = vendorMasterDao.getOutstandingData(companyCode,
				String.valueOf(userId),
				"" + sdf.parse(util.formatDate(selected_date, "dd/MM/yyyy", "yyyy-MM-dd")));

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
				recModel.setAmount("-"+outReport[7].toString());
				recModel.setCreditAmount(outReport[7].toString());

			} else if (outReport[8].toString().equals("S")) {
				recModel.setAmount(outReport[7].toString());
				recModel.setDebitAmount(outReport[7].toString());

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
			
		
			

			rCustomModel.add(recModel);
		}

		
		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	
	

	

	@RequestMapping("/getOutstandingMonthlyReport")
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

		List<Object[]> getOutstandingReport = vendorMasterDao.getOutstandingWithMonthData(companyCode,
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
				recModel.setAmount("-" +  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));
				recModel.setCreditAmount("" +  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));

			} else if (outReport[8].toString().equals("S")) {
				recModel.setAmount( ""+  Util.convertToSpecialCharacterAmount(""+outReport[7].toString()));
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
			
			if(outReport[11]!=null){
				recModel.setRemark(""+outReport[11].toString());
			}else{
				
				recModel.setRemark("");
			}
			
			
		
			

			rCustomModel.add(recModel);
		}

		
		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	
	@RequestMapping("/getCustomerOutstandingReport")
	public @ResponseBody JqgridResponse getCustomerOutstandingReport(@RequestParam(value = "selected_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,@RequestParam(value = "itemType") String itemType,
			HttpServletRequest request) throws ParseException {
		
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

		List<Object[]> getOutstandingReport = customerMasterDao.getCustomerOutstandingData(companyCode,
				String.valueOf(userId),
				"" + parsedDate,	""+parsedDate_to,itemType);

		List<CustomerOutstandingReportCustomModel> rCustomModel = new ArrayList<CustomerOutstandingReportCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			CustomerOutstandingReportCustomModel recModel = new CustomerOutstandingReportCustomModel();

			recModel.setCompCode(outReport[0].toString());
			recModel.setCustomerName(outReport[1].toString());
			recModel.setDocNo(outReport[2].toString());
			recModel.setFiYear(outReport[3].toString());
			recModel.setDocType(outReport[4].toString());
			recModel.setDocDate(outReport[5].toString());
			recModel.setPostingDate(outReport[6].toString());
			

			if (outReport[8].toString().equals("H")) {
				recModel.setAmount("-"+outReport[7].toString());
				recModel.setCreditAmount(outReport[7].toString());

			} else if (outReport[8].toString().equals("S")) {
				recModel.setAmount(outReport[7].toString());
				recModel.setDebitAmount(outReport[7].toString());

			}
			if (util.getNoOfDaysBtwnDates(outReport[5].toString())<=15) {
				recModel.setTo15(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 30) {
				recModel.setTo30(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 45) {
				recModel.setTo45(outReport[7].toString());

			} 
			recModel.setCustomerName(outReport[9].toString());
			recModel.setDocTypeName(outReport[10].toString());
			
		
			

			rCustomModel.add(recModel);
		}

		
		JqgridResponse<CustomerOutstandingReportCustomModel> dataGrid = new JqgridResponse<CustomerOutstandingReportCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	
	@RequestMapping("/getVendorOutstandingAmount")
	public @ResponseBody String getVendorOutstandingAmount(HttpServletRequest req) {
		String ret = "E";
		try {

			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");

			
		String 	ret1= vendorMasterDao.getVendorOutstandingAmount(companyCode,
				String.valueOf(userId));
			
		ret=ret1;
			

		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	
	
	
	@RequestMapping("/getDepositeOutstandingAmount")
	public @ResponseBody String getDepositeOutstandingAmount(HttpServletRequest req) {
		String ret = "E";
		try {

			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");

			
		String 	ret1= vendorMasterDao.getDepositeTotalAmount(companyCode,
				String.valueOf(userId));
			
		ret=ret1;
			

		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	
	
	
	@RequestMapping("/getCustomerOutstandingAmount")
	public @ResponseBody String getCustomerOutstandingAmount(HttpServletRequest req) {
		String ret = "E";
		try {
		

			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");

			
			String ret1= customerMasterDao.getCustomerOutstandingAmount(companyCode,
					String.valueOf(userId));
			
	
			ret=ret1;


		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	

	

}
