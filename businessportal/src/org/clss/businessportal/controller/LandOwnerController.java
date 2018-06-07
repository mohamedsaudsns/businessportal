package org.clss.businessportal.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.clss.businessportal.custommodel.FiledForceCustomModel;
import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.OutstandingReportCustomModel;
import org.clss.businessportal.dao.AgreementDao;
import org.clss.businessportal.dao.FtpDao;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.entity.AgreementHa;
import org.clss.businessportal.entity.AgreementLi;
import org.clss.businessportal.entity.FiledForce;
import org.clss.businessportal.entity.FtpConfig;
import org.clss.businessportal.entity.Role;
import org.clss.businessportal.entity.TdsCetificate;
import org.clss.businessportal.entity.TdsCetificatePK;
import org.clss.businessportal.entity.VendorMaster;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.sf.json.JSONObject;

@Controller
public class LandOwnerController {
	
	
	@Autowired
	private AgreementDao agreementDao;
	
	
	 @Autowired ServletContext context;
	 
	 @Autowired
		private VendorMasterDao vendorMasterDao;
	 
	 @Autowired
	 private FtpDao ftpDao;
	 
	 @Autowired
		private Util util;
	 
	 
	 
	  private static byte[] readBytesFromFile(String filePath) {

	        FileInputStream fileInputStream = null;
	        byte[] bytesArray = null;

	        try {

	            File file = new File(filePath);
	            bytesArray = new byte[(int) file.length()];

	            //read file into bytes[]
	            fileInputStream = new FileInputStream(file);
	            fileInputStream.read(bytesArray);

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (fileInputStream != null) {
	                try {
	                    fileInputStream.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }

	        }

	        return bytesArray;

	    }
	 
	 
		@RequestMapping(value = "/tdsFileReader",method=RequestMethod.GET)
		public @ResponseBody String tdsFileReader( HttpServletResponse response,HttpServletRequest request) {
			String ret = null;
			try{
				HttpSession session = request.getSession();
				   FTPClient ftpClient = new FTPClient();
				  
		         
				
				
				FtpConfig ftpcon=ftpDao.getFtpConfiguration("1", "2", "A");
				
				if(ftpcon.getId().getMenuType().equals("1") &&  ftpcon.getId().getConfigType().equals("2")) {
					
					System.out.println("first block");
					
					 ftpClient.connect(ftpcon.getIp());
					  
		             ftpClient.login(ftpcon.getUsername(), ftpcon.getPassword());
		             ftpClient.enterLocalPassiveMode();
		             FTPFile[] result = ftpClient.listFiles("/"+ftpcon.getUrl());
		             
				        for(FTPFile f: result){
				            System.out.println(f.getName());
//				            String filePath = parentDir + "/" + currentDir + "/"
//				                    + currentFileName;
				            System.out.println(ftpcon.getUrl()+"/"+f.getName());
//				             Path path = Paths.get("///"+f.getName());
				            byte[] data =IOUtils.toByteArray("/"+ftpcon.getUrl()+"/"+ftpClient.retrieveFileStream(f.getName()));
				            
				         
				        	 TdsCetificate tds=new TdsCetificate();
						 
						 TdsCetificatePK tdsPk=new TdsCetificatePK();
						 
						 tdsPk.setCompCode("1000");
						 tdsPk.setFicsalYear(f.getName().substring(14,21).trim());
						 tdsPk.setQuater(f.getName().substring(11,13).trim());
						
						 tdsPk.setPanNo(f.getName().substring(0,10));
						 tds.setId(tdsPk);
						 tds.setStatus("A");
						 tds.setFileName(f.getName().replace(".pdf", ""));
						 tds.setFileType(f.getName().substring(12, 15).toUpperCase());
						 tds.setFileContent(data);
						 tds.setCreatedBy(1000);
						 tds.setCreatedOn(new Date());
						 tds.setLastChangedBy(1000);
						 tds.setLastChangedOn(new Date());
						 	agreementDao.saveTds(tds);
				           }
				        ftpClient.logout();
				  	  
			             ftpClient.disconnect();
				}else 	if(ftpcon.getId().getMenuType().equals("2") &&  ftpcon.getId().getConfigType().equals("2")) {
					
					System.out.println("second block");
					
					
					 File file = new File(ftpcon.getUrl());
				        File[] files = file.listFiles();
				        for(File f: files){
				            System.out.println(f.getName());
				             Path path = Paths.get(f.getAbsolutePath());
				            byte[] data = Files.readAllBytes(path);
				            
				            System.out.println(f.getAbsolutePath());
				        	 TdsCetificate tds=new TdsCetificate();
						 
						 TdsCetificatePK tdsPk=new TdsCetificatePK();
						 
						 tdsPk.setCompCode("1000");
						 tdsPk.setFicsalYear(f.getName().substring(14,21).trim());
						 tdsPk.setQuater(f.getName().substring(11,13).trim());
						
						 tdsPk.setPanNo(f.getName().substring(0,10));
						 tds.setId(tdsPk);
						 tds.setStatus("A");
						 tds.setFileName(f.getName().replace(".pdf", ""));
						 tds.setFileType(f.getName().substring(12, 15).toUpperCase());
						 tds.setFileContent(data);
						 tds.setCreatedBy(1000);
						 tds.setCreatedOn(new Date());
						 tds.setLastChangedBy(1000);
						 tds.setLastChangedOn(new Date());
						 	agreementDao.saveTds(tds);
					
					
				}
				
				
				  
			           }
				 ret = "S";
			}catch(Exception e){
				e.printStackTrace();
				ret="E";
			}
			
			return ret;
		}
	 
	 

		@RequestMapping("/getMonthlyRentalPaymentReport")
		public @ResponseBody JqgridResponse getMonthlyRentalPaymentReport(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,@RequestParam(value = "itemType") String itemType,
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

			List<Object[]> getOutstandingReport = vendorMasterDao.getMonthlyRentalPaymentReport(companyCode,
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
	 
	 
	 
	 @RequestMapping("/getTDSData")
		public @ResponseBody String getTDSData(HttpServletRequest req,@RequestParam(value = "fiYear") String fiYear) {
			List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
			
			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String panNo = (String) req.getSession().getAttribute("panNo");
			String userId = (String) req.getSession().getAttribute("userId");
			try {
				
				List<TdsCetificate> TDSDs = agreementDao.getTDSData(companyCode,fiYear,panNo);
				for (TdsCetificate TDS : TDSDs) {
					JSONObject jObject = new JSONObject();
					jObject.put("quater",TDS.getId().getQuater());
					jObject.put("fileName", TDS.getFileName());
					jObject.put("panNo", TDS.getId().getPanNo());
					jObject.put("fiYear", TDS.getId().getFicsalYear());
					
					jObject.put("fileType", TDS.getFileType());
					
					
			
					jsonObjects.add(jObject);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return jsonObjects.toString();
		
		}
	 
	 
	 
	 
	 
	 @RequestMapping("/getAgreementLi")
		public @ResponseBody String getAgreementLi(HttpServletRequest req,@RequestParam(value = "fiYear") String fiYear,@RequestParam(value = "agr_no") String agr_no) {
			List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
			
			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");
			try {
				
				List<AgreementLi> agreementLi = agreementDao.getAgreementLineItem(companyCode, String.valueOf(userId),fiYear,agr_no);
				for (AgreementLi TDS : agreementLi) {
					JSONObject jObject = new JSONObject();
					jObject.put("agreementNo",TDS.getId().getAgreementNo());
					jObject.put("activityNam", TDS.getActivityName());
					jObject.put("startDate", ""+TDS.getActualStartDate());
					jObject.put("endDate", ""+TDS.getActualEndDate());
					jObject.put("prvAdvanceAmount","" +  Util.indianRupeeFormat(""+covertdecimalValue(""+TDS.getPrvAdance())));
					jObject.put("currentAdvanceAmount", "" +  Util.indianRupeeFormat(""+covertdecimalValue(""+TDS.getCurAdvance())));
					jObject.put("prvRentAmount","" +  Util.indianRupeeFormat(""+covertdecimalValue(""+ TDS.getPrvRent())));
					jObject.put("currentRent","" +  Util.indianRupeeFormat(""+covertdecimalValue(""+ TDS.getCurRent())));
					
					
			
					jsonObjects.add(jObject);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			
			System.out.println("jsonObjects.."+jsonObjects.size()+"...."+jsonObjects.toString());
			return jsonObjects.toString();
		
		}
	 
	 
	 
	 
		@RequestMapping("/getFieldForceData")
		public @ResponseBody String getFieldForceData(HttpServletRequest req) {
			JSONObject jsonObject = new JSONObject();
			try {
				String companyCode = (String) req.getSession().getAttribute("companyCode");
				String userId = (String) req.getSession().getAttribute("userId");
				FiledForce TDS = agreementDao.getFiledForce(companyCode, String.valueOf(userId));
				
				if (TDS != null) {
					jsonObject.put("filedForceName","");
					jsonObject.put("contactNo", "");

				} else {
					jsonObject.put("address", "E");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			System.out.println(jsonObject.size() + "" + jsonObject.toString());
			return jsonObject.toString();
		}
	 
//	 @RequestMapping("/getFieldForceData")
//		public @ResponseBody String getFieldForceData(HttpServletRequest req) {
//			List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
//			
//			String companyCode = (String) req.getSession().getAttribute("companyCode");
//			int userId = (int) req.getSession().getAttribute("userId");
//			try {
//				
//				List<FiledForce> filedForce = agreementDao.getFiledForce(companyCode, String.valueOf(userId));
//				for (FiledForce TDS : filedForce) {
//					JSONObject jObject = new JSONObject();
//					jObject.put("filedForceName",TDS.getFiledStaffName());
//					jObject.put("contactNo", TDS.getContactNo());
//					
//					
//					
//			
//					jsonObjects.add(jObject);
//				}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//			
//			System.out.println("jsonObjects.."+jsonObjects.size() + "" + jsonObjects.toString());
//			return jsonObjects.toString();
//		
//		}
	 
	 
	
//	@RequestMapping("/getAgreementData")
//	public @ResponseBody String getAgreementData(HttpServletRequest req) {
//		JSONObject jsonObject = new JSONObject();
//		try {
//			String companyCode = (String) req.getSession().getAttribute("companyCode");
//			int userId = (int) req.getSession().getAttribute("userId");
//			VendorMaster vendorMaster = vendorMasterDao.getVendorData(companyCode,
//					String.valueOf(userId));
//			if (vendorMaster != null) {
//				jsonObject.put("vendorCode", vendorMaster.getId().getVendorCode());
//				jsonObject.put("vendorName", vendorMaster.getName());
//				jsonObject.put("vendorName2", vendorMaster.getName2());
//				jsonObject.put("address", vendorMaster.getStreet());
//				jsonObject.put("city", vendorMaster.getCity());
//				jsonObject.put("pincode", vendorMaster.getPostalCode());
//				jsonObject.put("phoneNo", vendorMaster.getTelephoneNo());
//				jsonObject.put("regionName", vendorMaster.getRegionMaster().getRegionName());
//				jsonObject.put("region", vendorMaster.getRegionMaster().getId().getRegionCode());
//				jsonObject.put("country", vendorMaster.getRegionMaster().getCountryMaster().getCountryCode());
//				jsonObject.put("countryName", vendorMaster.getRegionMaster().getCountryMaster().getCountryName());
//
//			} else {
//				jsonObject.put("address", "E");
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		System.out.println(jsonObject.size() + "" + jsonObject.toString());
//		return jsonObject.toString();
//	}
	
		
		public String covertdecimalValue(String inputValue){
			
			String result="";
			  BigDecimal outputValue = new BigDecimal(inputValue);
			  
			  result=String.format("%.2f", outputValue);
		        System.out.println(String.format("$%.2f", outputValue));
		        
		        return result;
		}
	
	
	@RequestMapping("/getAgreementData")
	public @ResponseBody String getAgreementData(HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		
		String companyCode = (String) req.getSession().getAttribute("companyCode");
		String userId = (String) req.getSession().getAttribute("userId");
		try {
			
			List<AgreementHa> agreements = agreementDao.getAgreementData(companyCode, String.valueOf(userId));
			for (AgreementHa agreementHa : agreements) {
				JSONObject jObject = new JSONObject();
				jObject.put("agreementNo", agreementHa.getId().getAgreementNo());
				jObject.put("fiYear", agreementHa.getId().getFiscalYear());
				
				jObject.put("location", agreementHa.getLocation());
				jObject.put("brand", agreementHa.getBrandName());
				jObject.put("status", agreementHa.getStatus());
				jObject.put("currentStatus", agreementHa.getCurrentStatus());
				
				jObject.put("shopOwner", agreementHa.getVendorName());
				jObject.put("ShopAddress", agreementHa.getShopAddress());
				jObject.put("areaInSqft", agreementHa.getAreaInSqft());
				jObject.put("preRentSqrFit", agreementHa.getPreRentInSqft());
				
				jObject.put("startDate", ""+agreementHa.getStartDate());
				jObject.put("endDate", ""+agreementHa.getEndDate());
				jObject.put("advanceAmount",  ""+ Util.indianRupeeFormat(""+covertdecimalValue(""+agreementHa.getCurAdvance())));
				jObject.put("rentAmount", "" +  Util.indianRupeeFormat(""+covertdecimalValue(""+agreementHa.getCurRent())));
				jObject.put("renewalType", agreementHa.getRenewalType());
				jObject.put("noOfYears", agreementHa.getAgreementNoOfPeriod());
				jObject.put("renewalDate", ""+agreementHa.getRenewalDate());
				jObject.put("rentIncrPercentage", agreementHa.getRentIncreasePer());
				jObject.put("rentIncrYear", agreementHa.getRentIncreaseYear());
				jObject.put("plant", agreementHa.getPlant());
				jObject.put("notice", agreementHa.getNoticePeriod());
				
		
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	
	}
	
	
	
	@RequestMapping(value = "/tdsFileUpload",method=RequestMethod.POST)
	public @ResponseBody String tdsFileUpload(MultipartHttpServletRequest file, HttpServletResponse response,HttpServletRequest request) {
		String ret = null;
		try{
			HttpSession session = request.getSession();
		
			
			//1. get the files from the request object
		     Iterator<String> itr =  file.getFileNames();
		     MultipartFile mpf = file.getFile(itr.next());
//		 	String companyCode = (String) request.getSession().getAttribute("companyCode");
//			int userId = (int) request.getSession().getAttribute("userId");
			 if (mpf.getSize()>0) {
				 TdsCetificate tds=new TdsCetificate();
				 
				 TdsCetificatePK tdsPk=new TdsCetificatePK();
				 
				 tdsPk.setCompCode("1000");
				 tdsPk.setFicsalYear(mpf.getOriginalFilename().substring(14,21).trim());
				 tdsPk.setQuater(mpf.getOriginalFilename().substring(11,13).trim());
				
				 tdsPk.setPanNo(mpf.getOriginalFilename().substring(0,10));
				 
				 
				 System.out.println("mpf.."+mpf.getContentType().substring(12, 15));
				 System.out.println("mpf.."+mpf.getContentType());
				 System.out.println("mpf.."+mpf.getOriginalFilename());
				 System.out.println("mpf.."+mpf.getName());
				 System.out.println("mpf.."+mpf.getSize());

				 tds.setId(tdsPk);
				 tds.setStatus("A");
				 
				
				 tds.setFileName(mpf.getOriginalFilename().replace(".pdf", ""));
				 tds.setFileType(mpf.getContentType().substring(12, 15).toUpperCase());
				 tds.setFileContent(mpf.getBytes());
				 tds.setCreatedBy(1000);
				 tds.setCreatedOn(new Date());
				 tds.setLastChangedBy(1000);
				 tds.setLastChangedOn(new Date());
				 	agreementDao.saveTds(tds);
		           }
			 ret = "S";
		}catch(Exception e){
			e.printStackTrace();
			ret="E";
		}
		
		return ret;
	}
	
	
	
	
	@RequestMapping(value = "/tdsFileUploadById")
	public @ResponseBody void tdsFileUploadById(@RequestParam(value = "fiYear") String fiYear,@RequestParam(value = "quater") String quater,
												HttpServletResponse response,HttpServletRequest request) throws IOException {
		try{
		 String filepath = null;
	
		 	String companyCode = (String) request.getSession().getAttribute("companyCode");
			String userId = (String) request.getSession().getAttribute("userId");
			String panNo = (String) request.getSession().getAttribute("panNo");
		 
		String cpath = context.getRealPath("/");
		TdsCetificate image = agreementDao.getTdsCertificateById(companyCode,fiYear,quater,panNo);
			 if(image!=null){
				 response.setContentType("application/pdf");
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
	

	@RequestMapping("/getfiledForceData")
	public @ResponseBody JqgridResponse getfiledForceData(
			HttpServletRequest req) throws ParseException {
		String companyCode = (String) req.getSession().getAttribute("companyCode");
		String userId = (String) req.getSession().getAttribute("userId");

		List<Object[]> getOutstandingReport = vendorMasterDao.getFiledForceDataById(companyCode,""+userId);

		List<FiledForceCustomModel> rCustomModel = new ArrayList<FiledForceCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			FiledForceCustomModel recModel = new FiledForceCustomModel();

			recModel.setDesignation(outReport[0].toString());
			recModel.setEmpName(outReport[1].toString());
			recModel.setEmpMobileNo(outReport[2].toString());
			recModel.setEmpEmailId(outReport[3].toString());
			rCustomModel.add(recModel);
		}
		JqgridResponse<FiledForceCustomModel> dataGrid = new JqgridResponse<FiledForceCustomModel>(rCustomModel);
		return dataGrid;
	}
	

}
