package org.clss.businessportal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
public class CommonController {

	 @Autowired
		private VendorMasterDao vendorMasterDao;

	
	
	@RequestMapping("/getHMBFiledForceStaffData")
	public @ResponseBody JqgridResponse getHMBFiledForceStaffData(
			HttpServletRequest req) throws ParseException {
		String companyCode = (String) req.getSession().getAttribute("companyCode");
		String society = "";
		String accountGroup = (String) req.getSession().getAttribute("accountGroup");
		String roleId = (String) req.getSession().getAttribute("role_id");
		
		if(accountGroup.equals("BLVN")) {
			
			 society = (String) req.getSession().getAttribute("userId");
		}else {
			
			society = (String) req.getSession().getAttribute("society");
		}
		
		
		
		

		List<Object[]> getOutstandingReport = vendorMasterDao.getHMBFiledForceDataById(society,accountGroup,roleId);

		List<FiledForceStaffCustomModel> rCustomModel = new ArrayList<FiledForceStaffCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			if(outReport[5]!=null &&  outReport[6]!=null&&  outReport[7]!=null) {
				
				FiledForceStaffCustomModel recModel = new FiledForceStaffCustomModel();
				
				recModel.setPlantCode(outReport[0].toString());
				recModel.setPlantName(outReport[1].toString());
				recModel.setHmb(outReport[2].toString());
				recModel.setHmbName(outReport[3].toString());
				recModel.setDesignation(outReport[4].toString());
				recModel.setDesignationLevel(outReport[5].toString());
				recModel.setDesignationtype(outReport[6].toString());
				recModel.setVendor(outReport[7].toString());
				recModel.setVendorName(outReport[8].toString());
				if(outReport[9]!=null) {
					
					recModel.setVendorMobileNo(outReport[9].toString());
				}else {
					
					recModel.setVendorMobileNo("");
				}
				
				
				rCustomModel.add(recModel);
			}
			
			System.out.println("rCustomModel.."+rCustomModel.toString());
		
		}
		JqgridResponse<FiledForceStaffCustomModel> dataGrid = new JqgridResponse<FiledForceStaffCustomModel>(rCustomModel);
		return dataGrid;
	}	
	
	

}
