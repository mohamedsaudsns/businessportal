package org.clss.businessportal.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.OutstandingReportCustomModel;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.entity.NewsLetter;

import org.clss.businessportal.entity.VendorMaster;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HmpInChargeController {
	
	@Autowired
	private VendorMasterDao vendorMasterDao;
	
	 @Autowired
		private Util util;
	 
	 @Autowired ServletContext context;
	 
	 
	 
	 
	 @RequestMapping(value = "/newsLetterImageById")
		public @ResponseBody void newsLetterImageById(
													HttpServletResponse response,HttpServletRequest request) throws IOException {
			try{
			 String filepath = null;
				String userId = (String) request.getSession().getAttribute("userId");

				VendorMaster vendor=vendorMasterDao.getVendorRegionCode(userId, "A");
		
			 
			String cpath = context.getRealPath("/");

			NewsLetter	 image = vendorMasterDao.getNewsLetterImageById(vendor.getRegionMaster().getId().getCountryCode(),vendor.getRegionMaster().getId().getRegionCode(),"A","1");
				 if(image!=null){
					 
					 System.out.println("image..noy eqal null"+image.getFileType());
					 response.setContentType(image.getFileType());
				    response.getOutputStream().write(image.getFileContent());
				    response.getOutputStream().close();
				 }else{
					 filepath = cpath + "/resources/img/TDSCertificate.png";
					 File file = new File(filepath);
					 FileInputStream fis = new FileInputStream(file);
//					 byte[] bFile = new byte[(int) file.length()];
					 BufferedInputStream bis = new BufferedInputStream(fis); 
					 response.setContentType("application/pdf");
//					 response.getOutputStream().write(bFile);
			         BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
			         for (int data; (data = bis.read()) > -1;) {
			           output.write(data);
			         }             
					 
//					 response.getOutputStream().write(bis.read());
					 response.getOutputStream().close();
				 }
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	 
	 @RequestMapping(value = "/circularImageById")
		public @ResponseBody void circularImageById(
													HttpServletResponse response,HttpServletRequest request) throws IOException {
			
		 String userId = (String) request.getSession().getAttribute("userId");

			VendorMaster vendor=vendorMasterDao.getVendorRegionCode(userId, "A");
		 
		 try{
			 String filepath = null;
		
		
			 
			String cpath = context.getRealPath("/");

			NewsLetter	 image = vendorMasterDao.getNewsLetterImageById(vendor.getRegionMaster().getId().getCountryCode(),vendor.getRegionMaster().getId().getRegionCode(),"A","2");
				 if(image!=null){
					 
					 System.out.println("image..noy eqal null"+image.getFileType());
					 response.setContentType(image.getFileType());
				    response.getOutputStream().write(image.getFileContent());
				    response.getOutputStream().close();
				 }else{
					 filepath = cpath + "/resources/img/TDSCertificate.png";
					 File file = new File(filepath);
					 FileInputStream fis = new FileInputStream(file);
//					 byte[] bFile = new byte[(int) file.length()];
					 BufferedInputStream bis = new BufferedInputStream(fis); 
					 response.setContentType("application/pdf");
//					 response.getOutputStream().write(bFile);
			         BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
			         for (int data; (data = bis.read()) > -1;) {
			           output.write(data);
			         }             
					 
//					 response.getOutputStream().write(bis.read());
					 response.getOutputStream().close();
				 }
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	 
	
	
	@RequestMapping("/getDepositAmountReport")
	public @ResponseBody JqgridResponse getDepositAmountReport(@RequestParam(value = "selected_month") String selected_month,@RequestParam(value = "itemType") String itemType,
			HttpServletRequest request) throws ParseException {

		System.out.println("selected_month.."+selected_month);
		
		

		String companyCode = (String) request.getSession().getAttribute("companyCode");	
		String userId = (String) request.getSession().getAttribute("userId");
		
		
	
		String todate = Util.convertmonthYearToMonthEndDay(selected_month);
		String fromdate = "" + Util.convertFullMonthToMonthNo(selected_month) + "-01";
		List<Object[]> getOutstandingReport = vendorMasterDao.getHmbDepositAmountReport(companyCode,
				String.valueOf(userId),
				"" + fromdate,	""+todate,itemType);

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
			
			if(outReport[13]!=null){
				recModel.setRemark(""+outReport[13].toString());
			}else{
				
				recModel.setRemark("");
			}
			
			if(outReport[7]!=null){
				recModel.setSecurityDepositAmount(""+(outReport[7].toString()));
			}else{
				
				recModel.setSecurityDepositAmount("");
			}
			
			if(outReport[12]!=null){
				recModel.setTdsAmount(""+outReport[12].toString());
			}else{
				
				recModel.setTdsAmount("");
			}
			
			if(outReport[13]!=null){
				recModel.setItemText(""+outReport[13].toString());
			}else{
				
				recModel.setItemText("");
			}
			
			
			
			
//			 BigDecimal rentAmountBig = new BigDecimal(outReport[7].toString());
//			 BigDecimal tedAmountBig = new BigDecimal(outReport[12].toString());
//			 
//			 BigDecimal netAmount ;
//			 
//			 
//			
//			 netAmount=rentAmountBig.subtract(tedAmountBig);
//	
//			recModel.setNetAmount(""+netAmount);
//			
//			recModel.setPaymentAmount(""+outReport[7].toString().replace("-",""));
			

			rCustomModel.add(recModel);
		}

		
		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	@RequestMapping("/NegativeMilkAdvanceDetailsReport")
	public @ResponseBody JqgridResponse NegativeMilkAdvanceDetailsReport(@RequestParam(value = "itemType") String itemType,
			HttpServletRequest request) throws ParseException {

		String companyCode = (String) request.getSession().getAttribute("companyCode");	
		String userId = (String) request.getSession().getAttribute("userId");
		
		
		
		
		List<Object[]> getOutstandingReport = vendorMasterDao.NegativeMilkAdvanceDetailsReport(companyCode,
				String.valueOf(userId),
				itemType);

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
			
			if(outReport[13]!=null){
				recModel.setRemark(""+outReport[13].toString());
			}else{
				
				recModel.setRemark("");
			}
			
			if(outReport[7]!=null){
				recModel.setSecurityDepositAmount(""+outReport[7].toString());
			}else{
				
				recModel.setSecurityDepositAmount("");
			}
			
			if(outReport[12]!=null){
				recModel.setTdsAmount(""+outReport[12].toString());
			}else{
				
				recModel.setTdsAmount("");
			}
			
			if(outReport[13]!=null){
				recModel.setItemText(""+outReport[13].toString());
			}else{
				
				recModel.setItemText("");
			}
			
			
			if(outReport[14]!=null){
				recModel.setSplGlDesc(""+outReport[14].toString());
			}else{
				
				recModel.setSplGlDesc("");
			}
			
			
			
			
			 BigDecimal rentAmountBig = new BigDecimal(outReport[7].toString().replace("-",""));
			 BigDecimal tedAmountBig = new BigDecimal(outReport[12].toString());
			 
			 BigDecimal netAmount ;
			 
			 
			
			 netAmount=rentAmountBig.subtract(tedAmountBig);
	
			recModel.setNetAmount(""+netAmount);
			
			recModel.setPaymentAmount(""+outReport[7].toString().replace("-",""));
			

			rCustomModel.add(recModel);
		}

		
		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	
	
	
	
	
	
	

}
