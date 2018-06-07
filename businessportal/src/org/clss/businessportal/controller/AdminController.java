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
import org.clss.businessportal.custommodel.HmbSummaryCustomModel;
import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.OutstandingReportCustomModel;
import org.clss.businessportal.custommodel.ProductByDepartmentCustomModel;
import org.clss.businessportal.custommodel.UserTrackCustomModel;
import org.clss.businessportal.dao.AdminDao;
import org.clss.businessportal.dao.CfaDao;
import org.clss.businessportal.dao.DepartmentDao;
import org.clss.businessportal.dao.HmbDao;
import org.clss.businessportal.entity.CountryMaster;
import org.clss.businessportal.entity.Department;
import org.clss.businessportal.entity.FiledForce;
import org.clss.businessportal.entity.FiledForcePK;
import org.clss.businessportal.entity.GroupPosition;
import org.clss.businessportal.entity.GroupPositionPK;
import org.clss.businessportal.entity.NewsLetter;
import org.clss.businessportal.entity.NewsLetterLanguage;
import org.clss.businessportal.entity.NewsLetterPK;

import org.clss.businessportal.entity.Product;
import org.clss.businessportal.entity.ProductLi;
import org.clss.businessportal.entity.ProductLiPK;
import org.clss.businessportal.entity.ProductPK;
import org.clss.businessportal.entity.RegionMaster;
import org.clss.businessportal.entity.Scheme;
import org.clss.businessportal.entity.SchemeLi;
import org.clss.businessportal.entity.SchemeLiPK;
import org.clss.businessportal.entity.SchemePK;
import org.clss.businessportal.entity.UserTrack;
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
public class AdminController {

	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private CfaDao cfaDao;
	
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private HmbDao hmpDao;
	
//	...............   User Track .............
	
	@RequestMapping("/getUserTrackList")
	public @ResponseBody JqgridResponse getUserTrackList(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,
			@RequestParam(value = "entryVendorCode") String entryVendorCode	,	HttpServletRequest request) throws ParseException {

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");		
		
		 Date selected_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_date);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate = formatter.format(selected_date_for);
		 
		 Date selected_to_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_to_date);
		 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate_to = formatter1.format(selected_to_date_for);

		List<Object[]> getUserTrackData = adminDao.getUserTrackList(String.valueOf(entryVendorCode),"" + parsedDate,	""+parsedDate_to);

		List<UserTrackCustomModel> rCustomModel = new ArrayList<UserTrackCustomModel>();

		for (Object[] outReport : getUserTrackData) {

			UserTrackCustomModel recModel = new UserTrackCustomModel();
			recModel.setSessionId(outReport[0].toString());
			recModel.setUserId(outReport[1].toString());
			recModel.setUserTypeId(outReport[2].toString());
			recModel.setLoginIp(outReport[3].toString());
			recModel.setServerIp(outReport[4].toString());
			recModel.setLoginDate(outReport[5].toString());
			recModel.setLoginTime(outReport[6].toString());
			recModel.setLogoutDate(outReport[7].toString());
			recModel.setLogoutTime(outReport[8].toString());
			rCustomModel.add(recModel);
		}
		JqgridResponse<UserTrackCustomModel> dataGrid = new JqgridResponse<UserTrackCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	
	@RequestMapping("/getSchedullerError")
	public @ResponseBody JqgridResponse getSchedullerError(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,
			@RequestParam(value = "entryVendorCode") String entryVendorCode	,	HttpServletRequest request) throws ParseException {

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");		
		
		 Date selected_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_date);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate = formatter.format(selected_date_for);
		 
		 Date selected_to_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_to_date);
		 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate_to = formatter1.format(selected_to_date_for);

		List<Object[]> getUserTrackData = adminDao.getUserTrackList(String.valueOf(entryVendorCode),"" + parsedDate,	""+parsedDate_to);

		List<UserTrackCustomModel> rCustomModel = new ArrayList<UserTrackCustomModel>();

		for (Object[] outReport : getUserTrackData) {

			UserTrackCustomModel recModel = new UserTrackCustomModel();
			recModel.setSessionId(outReport[0].toString());
			recModel.setUserId(outReport[1].toString());
			recModel.setUserTypeId(outReport[2].toString());
			recModel.setLoginIp(outReport[3].toString());
			recModel.setServerIp(outReport[4].toString());
			recModel.setLoginDate(outReport[5].toString());
			recModel.setLoginTime(outReport[6].toString());
			recModel.setLogoutDate(outReport[7].toString());
			recModel.setLogoutTime(outReport[8].toString());
			rCustomModel.add(recModel);
		}
		JqgridResponse<UserTrackCustomModel> dataGrid = new JqgridResponse<UserTrackCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	
	
	
	

	@RequestMapping("/getDepartmentList")
	public @ResponseBody String getDepartmentList(HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		try {

			List<Department> departments = departmentDao.getDepartmentList("A");
			for (Department dep : departments) {
				JSONObject jObject = new JSONObject();
				jObject.put("departmentId", dep.getDepartmentId());
				jObject.put("departmentName", dep.getDepartmentName());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}
	
	@RequestMapping("/getDepartmentSearchList")
	public @ResponseBody String getDepartmentSearchList(HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		String searchStr = req.getParameter("searchStr");
		System.out.println("searchStr.."+searchStr);
		try {

			List<Department> departments = departmentDao.getDepartmentSearchList("A",searchStr);
			System.out.println("departments.."+departments.size());
			for (Department dep : departments) {
				JSONObject jObject = new JSONObject();
				jObject.put("departmentId", dep.getDepartmentId());
				jObject.put("departmentName", dep.getDepartmentName());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}
	
	
	@RequestMapping("/getMilkHeaderData")
	public@ResponseBody String getMilkHeaderData(
			@RequestParam(value = "selected_month") String selected_month, HttpServletRequest request)
			throws ParseException {

	

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");

		String todate = Util.convertmonthYearToMonthEndDay(selected_month);
		String fromdate = "" + Util.convertFullMonthToMonthNo(selected_month) + "-01";
	//	List<HmbSummaryCustomModel> hmbSummaryList = new ArrayList<HmbSummaryCustomModel>();
		
		List<JSONObject> hmbSummaryList = new ArrayList<JSONObject>();

		List<Object[]> hmbSummary = hmpDao.getHmpInchargeSummary(companyCode, userId, fromdate, todate);

		int count = 0;
		BigDecimal totalamount = new BigDecimal(0);

		BigDecimal paymentAmount = new BigDecimal(0);
		BigDecimal arrearAmount = new BigDecimal(0);
		BigDecimal deductionAmount = new BigDecimal(0);
		BigDecimal recoveryAmount = new BigDecimal(0);
		BigDecimal incentiveAmount = new BigDecimal(0);

		for (Object[] outReport : hmbSummary) {
if(outReport[6]!=null && !outReport[19].toString().equals("0")) {
		//	HmbSummaryCustomModel recModel = new HmbSummaryCustomModel();
			
			JSONObject jObject = new JSONObject();
			count++;
			
		
			
			
			
			jObject.put("compCode", outReport[0].toString());
			jObject.put("billNumber", outReport[1].toString());
			jObject.put("cutOff", "P-" + count);
			jObject.put("dateFrom", outReport[2].toString());
			jObject.put("dateTo", outReport[3].toString());
			jObject.put("plant", outReport[4].toString());
			jObject.put("socity", outReport[5].toString());
			jObject.put("farmerCode", outReport[6].toString());
			jObject.put("grossAmount", outReport[7].toString());
			
				if (!outReport[8].toString().equals("0.00")) {
					jObject.put("deductions", outReport[8].toString());
				} else {
					jObject.put("deductions", outReport[8].toString());
				}
			
				if (!outReport[9].toString().equals("0.00")) {
					jObject.put("recoveries", outReport[9].toString());
				} else {
					jObject.put("recoveries", outReport[9].toString());
				}
			
			
			
			jObject.put("arrears", outReport[10].toString());
			
			
			
			jObject.put("netAmount", outReport[11].toString());
			
			
			jObject.put("actDed", outReport[12].toString());
			jObject.put("farmerName", outReport[13].toString());
			
			
			
			if (!outReport[14].toString().equals("0.00")) {
				jObject.put("incentive", outReport[14].toString());
				} else {
					jObject.put("incentive", outReport[14].toString());
				}
			
			
			jObject.put("acNo", outReport[15].toString());
			jObject.put("ifcCode", outReport[16].toString());
			jObject.put("milkPayment", outReport[17].toString());
			
				if(outReport[19]!=null) {
					jObject.put("pCode", outReport[19].toString());
					}else{
						jObject.put("pCode", "");
						
					}
			
			jObject.put("cName", outReport[0].toString());
			
				if(outReport[18]!=null) {
				jObject.put("totalLtr", outReport[18].toString());
				}else{
					jObject.put("totalLtr", "0.000");
					
				}
			
			
			totalamount = totalamount.add(new BigDecimal(outReport[11].toString()));
			paymentAmount = paymentAmount.add(new BigDecimal(outReport[7].toString()));
			arrearAmount = arrearAmount.add(new BigDecimal(outReport[10].toString()));
			deductionAmount = deductionAmount.add(new BigDecimal(outReport[8].toString()));

			recoveryAmount = recoveryAmount.add(new BigDecimal(outReport[9].toString()));



			hmbSummaryList.add(jObject);
}
		}

		System.out.println("totalamount.." + totalamount);

		
		
		

		
		return hmbSummaryList.toString();
	}
	
	@RequestMapping("/getNewsLetterLanguageList")
	public @ResponseBody String getNewsLetterLanguageList(HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		try {

			List<NewsLetterLanguage> departments = departmentDao.getNewsLetterLanguageList("A");
			for (NewsLetterLanguage dep : departments) {
				JSONObject jObject = new JSONObject();
				jObject.put("languageId", dep.getLanguageId());
				jObject.put("languageName", dep.getLanguageName());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}
	
	@RequestMapping("/getNewsLetterRegionList")
	public @ResponseBody String getNewsLetterRegionList(@RequestParam(value = "countryId") String countryId,HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		try {

			List<RegionMaster> regionData = departmentDao.getNewsLetterRegionList("A",countryId);
			for (RegionMaster dep : regionData) {
				JSONObject jObject = new JSONObject();
				jObject.put("regionCode", dep.getId().getRegionCode());
				jObject.put("regionName", dep.getRegionName());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}
	
	@RequestMapping("/getNewsLetterCountryList")
	public @ResponseBody String getNewsLetterCountryList(HttpServletRequest req) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		try {

			List<CountryMaster> countryData = departmentDao.getNewsLetterCountryList("A");
			for (CountryMaster dep : countryData) {
				JSONObject jObject = new JSONObject();
				jObject.put("countryCode", dep.getCountryCode());
				jObject.put("countryName", dep.getCountryName());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}
	

//..................... Product File Upload Start ...................
	
	@RequestMapping(value = "/productFileUpload",method=RequestMethod.POST)
	public @ResponseBody String productFileUpload(MultipartHttpServletRequest file,HttpServletResponse response,HttpServletRequest request) {
		String ret = null;
		try{
			HttpSession session = request.getSession();
			
			List<ProductLi> prdList = new ArrayList<ProductLi>();
			
			 Date selected_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("productFromDate").toString());
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 String parsedDate = formatter.format(selected_date_for);
			 
			 
			 Date selected_to_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("productToDate").toString());
			 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			 String parsedDate_to = formatter1.format(selected_to_date_for);
			
			Date fromDate = new Date();
			fromDate
					.setDate(Integer.parseInt(parsedDate.substring(8, 10)));
			fromDate
					.setMonth(Integer.parseInt(parsedDate.substring(5, 7)) - 1);
			fromDate
					.setYear(Integer.parseInt(parsedDate.substring(0, 4)) - 1900);

			System.out.println("fromDate Air Date=" + fromDate.toString());
			
		 	String companyCode = (String) request.getSession().getAttribute("companyCode");
		 	String userId = (String) request.getSession().getAttribute("userId");
			Date todate = new Date();
			todate					.setDate(Integer.parseInt(parsedDate_to.substring(8, 10)));
			todate
					.setMonth(Integer.parseInt(parsedDate_to.substring(5, 7)) - 1);
			todate
					.setYear(Integer.parseInt(parsedDate_to.substring(0, 4)) - 1900);

			System.out.println("todate Air Date=" + fromDate.toString());
			
			List<Product> prodList1=cfaDao.getProductList(companyCode, ""+request.getParameter("productDepartment").toString());
			int	itemNoHa=prodList1.size()+1;
			
			//1. get the files from the request object
		     Iterator<String> itr =  file.getFileNames();
		     MultipartFile mpf = file.getFile(itr.next());
	
			 if (mpf.getSize()>0) {
				 
				 Product prd=new Product();
				 ProductPK prdPK=new ProductPK();
				 prdPK.setItemNo(itemNoHa);
				 prdPK.setCompCode(companyCode);
				 prdPK.setDepartmentId(Integer.parseInt(request.getParameter("productDepartment").toString()));
				 prd.setId(prdPK);
				 	
				prd.setProductName(request.getParameter("productName").toString());
				 prd.setFromDate(fromDate);
				 prd.setToDate(todate);
				 prd.setStatus("A");
				 prd.setFileName(mpf.getOriginalFilename());
				 prd.setFileType(mpf.getContentType());
				 prd.setFileContent(mpf.getBytes());
				 prd.setCreatedBy(Integer.parseInt(userId));
				 prd.setCreatedOn(new Date());
				 prd.setLastChangedBy(Integer.parseInt(userId));
				 prd.setLastChangedOn(new Date());
				 cfaDao.saveProduct(prd);
					List<Product> prodList=cfaDao.getProductList(companyCode, ""+request.getParameter("productDepartment").toString());
					
				int	itemNo=prodList.size();
					
					JSONObject jSONObject = JSONObject.fromObject(request.getParameter("productData").toString());
					JSONArray jSONArray = jSONObject.getJSONArray("rows");

					int jsonsize = jSONArray.size() - 1;
					System.out.println("array size" + jsonsize);
					System.out.println("array Data" + jSONArray.toString());

					for (int i = 0; i <= jsonsize; i++) {
						JSONObject jObject = jSONArray.getJSONObject(i);
						String departmentId = jObject.getString("Department Id");
						
						
						ProductLi prdli=new ProductLi();
						ProductLiPK prdlipk=new ProductLiPK();
						prdlipk.setCompCode(companyCode);
						prdlipk.setDepartmentId(Integer.parseInt(request.getParameter("productDepartment").toString()));
						prdlipk.setItemNo(itemNo);
					
						prdlipk.setDepartmentVisibleId(Integer.parseInt(departmentId));
						prdli.setId(prdlipk);
						prdli.setFromDate(fromDate);
						prdli.setToDate(todate);
						prdli.setStatus("A");
						prdli.setCreatedBy(Integer.parseInt(userId));
						prdli.setCreatedOn(new Date());
						prdli.setLastChangedBy(Integer.parseInt(userId));
						prdli.setLastChangedOn(new Date());
						
						cfaDao.saveProductLi(prdli);
					}
					
					
					
					
				 System.out.println("prd.item no."+prodList.size());
		           }
			 ret = "S";
		}catch(Exception e){
			e.printStackTrace();
			ret="E";
		}
		
		return ret;
	}
	
	
	
	
	@RequestMapping(value = "/newsLetterFileUpload",method=RequestMethod.POST)
	public @ResponseBody String newsLetterFileUpload(MultipartHttpServletRequest file,HttpServletResponse response,HttpServletRequest request) {
		String ret = null;
		try{
			HttpSession session = request.getSession();
			
			List<ProductLi> prdList = new ArrayList<ProductLi>();
			
			
			
			
		 	String userId = (String) request.getSession().getAttribute("userId");
			
			
		
			
			//1. get the files from the request object
		     Iterator<String> itr =  file.getFileNames();
		     MultipartFile mpf = file.getFile(itr.next());
	
			 if (mpf.getSize()>0) {
				 NewsLetter newsLetterLanguage=new NewsLetter();
				 NewsLetterPK newsletterPK=new NewsLetterPK();
				 newsletterPK.setCountryCode(request.getParameter("newsLetterCountry").toString());
				 newsletterPK.setRegionCode(request.getParameter("newsLetterRegion").toString());
				 newsletterPK.setTypeId(Integer.parseInt(request.getParameter("itemType").toString()));
				
				 newsLetterLanguage.setId(newsletterPK);
				 newsLetterLanguage.setStatus("A");
				 newsLetterLanguage.setFileName(mpf.getOriginalFilename());
				 newsLetterLanguage.setFileType(mpf.getContentType());
				 newsLetterLanguage.setFileContent(mpf.getBytes());
				 newsLetterLanguage.setCreatedBy(userId);
				 newsLetterLanguage.setCreatedOn(new Date());
				 newsLetterLanguage.setLastChangedBy(userId);
				 newsLetterLanguage.setLastChangedOn(new Date());
				 cfaDao.saveNewsLetter(newsLetterLanguage);
					
					
					
					
				
		           }
			 ret = "S";
		}catch(Exception e){
			e.printStackTrace();
			ret="E";
		}
		
		return ret;
	}
	
	
	@RequestMapping("/getProductList")
	public @ResponseBody String getProductList(HttpServletRequest req,@RequestParam(value = "departmentId") String departmentId) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		String companyCode = (String) req.getSession().getAttribute("companyCode");
		String userId = (String) req.getSession().getAttribute("userId");
		try {
			
			List<Product> prodList=cfaDao.getProductList(companyCode, departmentId);
			for (Product prd : prodList) {
				JSONObject jObject = new JSONObject();
				jObject.put("itemId", prd.getId().getItemNo());
				jObject.put("compCode", prd.getId().getCompCode());
				jObject.put("departmentId", prd.getId().getDepartmentId());
				jObject.put("fileName", prd.getFileName());
				jObject.put("prdName", prd.getProductName());
				jObject.put("fromaDate", ""+prd.getFromDate());
				jObject.put("toDate", ""+prd.getToDate());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}
	
	
	
	@RequestMapping("/deleteProduct")
	public @ResponseBody String deleteProduct(@RequestParam(value = "compCode") String compCode,@RequestParam(value = "itemId") String itemId,@RequestParam(value = "departmentId") String departmentId, HttpServletRequest req) {
		String ret = "E";

		String companyCode = (String) req.getSession().getAttribute("companyCode");
	
		try {
			int  result = cfaDao.deleteProduct(companyCode, itemId, departmentId);
			if(result!=0){
				ret="S";
				
			}else {
				
				ret="E";
				
			}

		
		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	
	//..................... Product File Upload End ...................
	
	
	
	//..................... Scheme File Upload Start ...................
	
	@RequestMapping(value = "/schemeFileUpload",method=RequestMethod.POST)
	public @ResponseBody String schemeFileUpload(MultipartHttpServletRequest file,HttpServletResponse response,HttpServletRequest request) {
		String ret = null;
		try{
			HttpSession session = request.getSession();
			
			List<ProductLi> prdList = new ArrayList<ProductLi>();
			
			 Date selected_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("schemeFromDate").toString());
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 String parsedDate = formatter.format(selected_date_for);
			 
			 
			 Date selected_to_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("schemeToDate").toString());
			 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			 String parsedDate_to = formatter1.format(selected_to_date_for);
			
			Date fromDate = new Date();
			fromDate
					.setDate(Integer.parseInt(parsedDate.substring(8, 10)));
			fromDate
					.setMonth(Integer.parseInt(parsedDate.substring(5, 7)) - 1);
			fromDate
					.setYear(Integer.parseInt(parsedDate.substring(0, 4)) - 1900);

			System.out.println("fromDate Air Date=" + fromDate.toString());
			
			
			Date todate = new Date();
			todate					.setDate(Integer.parseInt(parsedDate_to.substring(8, 10)));
			todate
					.setMonth(Integer.parseInt(parsedDate_to.substring(5, 7)) - 1);
			todate
					.setYear(Integer.parseInt(parsedDate_to.substring(0, 4)) - 1900);

			System.out.println("todate Air Date=" + fromDate.toString());
			String companyCode = (String) request.getSession().getAttribute("companyCode");
			String userId = (String) request.getSession().getAttribute("userId");
			
			//1. get the files from the request object
		     Iterator<String> itr =  file.getFileNames();
		     MultipartFile mpf = file.getFile(itr.next());
		     
		     List<Scheme> prodList1=cfaDao.getSchemeList(companyCode, ""+request.getParameter("schemeDepartment").toString());
		     
		 	int	itemNoHa=prodList1.size()+1;
			 if (mpf.getSize()>0) {
				 
				 Scheme prd=new Scheme();
				 SchemePK prdPK=new SchemePK();
				 prdPK.setItemNo(itemNoHa);
				 prdPK.setCompCode(companyCode);
				 prdPK.setDepartmentId(Integer.parseInt(request.getParameter("schemeDepartment").toString()));
				 prd.setId(prdPK);
				 	
				prd.setSchemeName(request.getParameter("schemeName").toString());
				 prd.setFromDate(fromDate);
				 prd.setToDate(todate);
				 prd.setStatus("A");
				 prd.setFileName(mpf.getOriginalFilename());
				 prd.setFileType(mpf.getContentType());
				 prd.setFileContent(mpf.getBytes());
				 prd.setCreatedBy(Integer.parseInt(userId));
				 prd.setCreatedOn(new Date());
				 prd.setLastChangedBy(Integer.parseInt(userId));
				 prd.setLastChangedOn(new Date());
				 cfaDao.saveScheme(prd);
					List<Scheme> prodList=cfaDao.getSchemeList(companyCode, ""+request.getParameter("schemeDepartment").toString());
					
				int	itemNo=prodList.size();
					
					JSONObject jSONObject = JSONObject.fromObject(request.getParameter("schemeData").toString());
					JSONArray jSONArray = jSONObject.getJSONArray("rows");

					int jsonsize = jSONArray.size() - 1;
					System.out.println("array size" + jsonsize);
					System.out.println("array Data" + jSONArray.toString());

					for (int i = 0; i <= jsonsize; i++) {
						JSONObject jObject = jSONArray.getJSONObject(i);
						String departmentId = jObject.getString("Department Id");
						
						
						SchemeLi prdli=new SchemeLi();
						SchemeLiPK prdlipk=new SchemeLiPK();
						prdlipk.setCompCode(companyCode);
						prdlipk.setDepartmentId(Integer.parseInt(request.getParameter("schemeDepartment").toString()));
						prdlipk.setItemNo(itemNo);
					
						prdlipk.setDepartmentVisibleId(Integer.parseInt(departmentId));
						prdli.setId(prdlipk);
						prdli.setStatus("A");
						prdli.setFromDate(fromDate);
						prdli.setToDate(todate);
						prdli.setCreatedBy(Integer.parseInt(userId));
						prdli.setCreatedOn(new Date());
						prdli.setLastChangedBy(Integer.parseInt(userId));
						prdli.setLastChangedOn(new Date());
						
						cfaDao.saveSchemeLi(prdli);
					}
					
					
					
					
				 System.out.println("prd.item no."+prodList.size());
		           }
			 ret = "S";
		}catch(Exception e){
			e.printStackTrace();
			ret="E";
		}
		
		return ret;
	}
	
	
	
	
	
	@RequestMapping("/getSchemeList")
	public @ResponseBody String getSchemeList(HttpServletRequest req,@RequestParam(value = "departmentId") String departmentId) {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		String companyCode = (String) req.getSession().getAttribute("companyCode");
		String userId = (String) req.getSession().getAttribute("userId");
		try {
			
			List<Scheme> prodList=cfaDao.getSchemeList(companyCode, departmentId);
			for (Scheme prd : prodList) {
				JSONObject jObject = new JSONObject();
				jObject.put("itemId", prd.getId().getItemNo());
				jObject.put("compCode", prd.getId().getCompCode());
				jObject.put("departmentId", prd.getId().getDepartmentId());
				jObject.put("fileName", prd.getFileName());
				jObject.put("schemeName", prd.getSchemeName());
				jObject.put("fromaDate", ""+prd.getFromDate());
				jObject.put("toDate", ""+prd.getToDate());
				jsonObjects.add(jObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}
	
	
	
	@RequestMapping("/deleteScheme")
	public @ResponseBody String deleteScheme(@RequestParam(value = "compCode") String compCode,@RequestParam(value = "itemId") String itemId,@RequestParam(value = "departmentId") String departmentId, HttpServletRequest req) {
		String ret = "E";

		String companyCode = (String) req.getSession().getAttribute("companyCode");
	
		try {
			int  result = cfaDao.deleteScheme(companyCode, itemId, departmentId);
			if(result!=0){
				ret="S";
				
			}else {
				
				ret="E";
				
			}

		
		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}
	
	
	//..................... Scheme File Upload End ...................
	
	
	
	//..................... Field Force File Upload Start ...................
	
	
	@RequestMapping(value = "/FiledForceFileUploadAction",method=RequestMethod.POST)
	public @ResponseBody String FiledForceFileUploadAction(MultipartHttpServletRequest file,HttpServletResponse response,HttpServletRequest request) {
		String ret = null;
		String companyCode = (String) request.getSession().getAttribute("companyCode");
		try{
			HttpSession session = request.getSession();
		     Iterator<String> itr =  file.getFileNames();
		     MultipartFile mpf = file.getFile(itr.next());
		     
		 	String userId = (String) request.getSession().getAttribute("userId");
		     
			 if (mpf.getSize()>0) {
				 int rowStaring = 1;

					Workbook wb = WorkbookFactory.create(mpf.getInputStream());
					Sheet sheet = wb.getSheetAt(0);
					Row row = null;
					boolean isNull = false;
					
					List<FiledForce> FiledForceList = new ArrayList<FiledForce>();
					do{
						try{
							
							
							int colCount = sheet.getRow(0).getLastCellNum();
							System.out.println("colCount.."+colCount);
							row = sheet.getRow(rowStaring);
					
							FiledForce gpp=new FiledForce();
							FiledForcePK gppPK=new FiledForcePK();
							gppPK.setCompCode(companyCode);
							 Double vendorCustomerCode = new Double(""+row.getCell(0).toString());
						        Integer vencus = vendorCustomerCode.intValue(); // i becomes 5Double d = 5.25;
						        System.out.println("i......"+ Long.parseLong(""+vencus));
							
							gppPK.setVendorCustomerCode(""+Long.parseLong(""+vencus));
							gppPK.setPositionCode(""+row.getCell(1));
							gpp.setId(gppPK);
							gpp.setCreatedBy(Integer.parseInt(userId));
							gpp.setCreatedOn(new Date());
							Double empCode = new Double(""+row.getCell(0).toString());
					        Integer emcode = empCode.intValue(); // i becomes 5Double d = 5.25;
					        System.out.println("emcode......"+ Long.parseLong(""+emcode));
							
							gpp.setEmpCode(""+Long.parseLong(""+emcode));
							gpp.setEmpName(""+row.getCell(3));
							gpp.setEmpMobileNo(""+(row.getCell(4).toString()).replace("-", ""));
							gpp.setEmpEmailId(""+row.getCell(5));
							gpp.setLastChangedBy(Integer.parseInt(userId));
							gpp.setLastChangedOn(new Date());
							gpp.setStatus("A");
							FiledForceList.add(gpp);
							

						row.getOutlineLevel();	
						rowStaring++;
						} catch(Exception e) {
							System.out.println("error"+e);
							isNull = true;
						}
						
					}while(isNull!=true);

					adminDao.saveFiledForce(FiledForceList);

	        
			    }
			 

		           
			 ret = "S";
		}catch(Exception e){
			e.printStackTrace();
			ret="E";
		}
		
		return ret;
	}
	
	
	
	
	
	
	@RequestMapping(value = "/NewGroupFileUpload",method=RequestMethod.POST)
	public @ResponseBody String NewGroupFileUpload(MultipartHttpServletRequest file,HttpServletResponse response,HttpServletRequest request) {
		String ret = null;
		try{
			HttpSession session = request.getSession();
		     Iterator<String> itr =  file.getFileNames();
		     MultipartFile mpf = file.getFile(itr.next());
		     
		 	String userId = (String) request.getSession().getAttribute("userId");
		     
			 if (mpf.getSize()>0) {
				 int rowStaring = 1;

					Workbook wb = WorkbookFactory.create(mpf.getInputStream());
					Sheet sheet = wb.getSheetAt(0);
					Row row = null;
					String filedStaffId,filedStaffName,filedStaffContactNo = null;
					boolean isNull = false;
					
					List<GroupPosition> grpPoList = new ArrayList<GroupPosition>();
					do{
						try{
							
							
							int colCount = sheet.getRow(0).getLastCellNum();
							System.out.println("colCount.."+colCount);
							
						
							
						row = sheet.getRow(rowStaring);
						
						int loopCount=colCount/4;
						int rowconut=0;
						
						for(int i=0;i>=loopCount;i++){
							
							GroupPosition gpp=new GroupPosition();
							GroupPositionPK gppPk=new GroupPositionPK();
							gppPk.setGroupId(""+i);
							gppPk.setPositionId(""+row.getCell(1+rowconut));
							gpp.setId(gppPk);
							gpp.setEmpId(""+row.getCell(2+rowconut));
							gpp.setEmpName(""+row.getCell(3+rowconut));
							gpp.setMobileNo(""+row.getCell(4+rowconut));
							gpp.setStatus("A");
						
							gpp.setCreatedBy(Integer.parseInt(userId));
							gpp.setCreatedOn(new Date());
							gpp.setLastChangedBy(Integer.parseInt(userId));
							gpp.setLastChangedOn(new Date());
							
							System.out.println("gpp.."+gpp.toString());
							grpPoList.add(gpp);
							rowconut=rowconut+4;
							
						}
						
						
						
						
//						filedStaffId = ""+row.getCell(1);
//						filedStaffName = ""+row.getCell(2);
//						filedStaffContactNo = ""+row.getCell(3);
						
						row.getOutlineLevel();
						
						System.out.println("grpPoList.."+grpPoList.toString());
//						System.out.println("filedStaffId.."+filedStaffId+"..filedStaffName.."+filedStaffName+"..filedStaffContactNo.."+filedStaffContactNo.toString());
						rowStaring++;
						} catch(Exception e) {
							System.out.println("error"+e);
							isNull = true;
						}
						
					}while(isNull!=true);


//			        Sheet firstSheet = workbook.getSheetAt(0);
//			        Iterator<Row> iterator = firstSheet.iterator();
//			         
//			        while (iterator.hasNext()) {
//			            Row nextRow = iterator.next();
//			            Iterator<Cell> cellIterator = nextRow.cellIterator();
//			             
//			            while (cellIterator.hasNext()) {
//			                Cell cell = cellIterator.next();
//			                
//			                
//			                
//			                
//			                 
//			                switch (cell.getCellType()) {
//			                    case Cell.CELL_TYPE_STRING:
//			                        System.out.print(cell.getStringCellValue());
//			                        break;
//			                    case Cell.CELL_TYPE_BOOLEAN:
//			                        System.out.print(cell.getBooleanCellValue());
//			                        break;
//			                    case Cell.CELL_TYPE_NUMERIC:
//			                        System.out.print(cell.getNumericCellValue());
//			                        break;
//			                }
//			                System.out.print(" - ");
//			            }
//			            System.out.println();
//			        }
//			         
//			        workbook.close();
//			        
			    }
//				 

		           
			 ret = "S";
		}catch(Exception e){
			e.printStackTrace();
			ret="E";
		}
		
		return ret;
	}
	

	
//	  public void import1(  MultipartFile mpf) {
//
//    ByteArrayInputStream bis = new ByteArrayInputStream(mpf.getBytes());
//    Workbook workbook;
//    try {
//        if (mpf.getOriginalFilename().endsWith("xls")) {
//            workbook = new HSSFWorkbook(bis);
//        } else if (mpf.getOriginalFilename().endsWith("xlsx")) {
//            workbook = new XSSFWorkbook(bis);
//        } else {
//            throw new IllegalArgumentException("Received file does not have a standard excel extension.");
//        }
//
//        for (Row row : sheet) {
//           if (row.getRowNum() == 0) {
//              Iterator<Cell> cellIterator = row.cellIterator();
//              while (cellIterator.hasNext()) {
//                  Cell cell = cellIterator.next();
//                  //go from cell to cell and do create sql based on the content
//              }
//           }
//        }
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
	
	//..................... Field Force File Upload End ...................
	
	
	

}
