package org.clss.businessportal.controller;

/**
*
* @author Mohamed Saud SNS
*/


import javax.servlet.http.HttpServletRequest;
import org.clss.businessportal.dao.CustomerMasterDao;
import org.clss.businessportal.entity.CustomerMaster;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class CustomerController {

	@Autowired
	private CustomerMasterDao customerMasterDao;
	@Autowired
	private Util util;



	@RequestMapping("/getCustomerData")
	public @ResponseBody String getCustomerData(HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");
			 CustomerMaster  customerMaster = customerMasterDao.getCustomerData(companyCode,
					 String.valueOf(userId));
			if (customerMaster != null) {
				jsonObject.put("customerCode", customerMaster.getId().getCustomerCode());
				jsonObject.put("customerName", customerMaster.getName());
				jsonObject.put("customerName2", customerMaster.getName2());
				jsonObject.put("address", customerMaster.getStreet1());
				jsonObject.put("city", customerMaster.getCity());
				jsonObject.put("pincode", customerMaster.getPostalCode());
				jsonObject.put("phoneNo", customerMaster.getTelephoneNo());
				
				
				jsonObject.put("doorNo", customerMaster.getName2());
				jsonObject.put("streetName1", customerMaster.getStreetName1());
				jsonObject.put("streetName2", customerMaster.getStreetName2());
				jsonObject.put("streetName3", customerMaster.getStreetName3());
				
				jsonObject.put("district", customerMaster.getDistrict());
				jsonObject.put("postalCode", customerMaster.getPostalCode());
				jsonObject.put("landmark", customerMaster.getLandmark());
				jsonObject.put("mobileNo1", customerMaster.getMobileNo1());
				jsonObject.put("mobileNo2", customerMaster.getMobileNo2());
				jsonObject.put("panNo", customerMaster.getPanNo());
				jsonObject.put("gstin", customerMaster.getGstin());
				jsonObject.put("email", customerMaster.getEmail());
				jsonObject.put("createCapacity", customerMaster.getCrateCapacity());
				jsonObject.put("regionName", customerMaster.getRegionMaster().getRegionName());
				jsonObject.put("region", customerMaster.getRegionMaster().getId().getRegionCode());
				jsonObject.put("country", customerMaster.getRegionMaster().getCountryMaster().getCountryCode());
				jsonObject.put("countryName", customerMaster.getRegionMaster().getCountryMaster().getCountryName());
				if(customerMaster.getCustomerBankDetails().size()>0){
				
				jsonObject.put("customerBankName", customerMaster.getCustomerBankDetails().get(0).getBankName());
				jsonObject.put("customerAccountNo", customerMaster.getCustomerBankDetails().get(0).getId().getAccountNo());
				jsonObject.put("customerBranchName", customerMaster.getCustomerBankDetails().get(0).getBranchName());
				jsonObject.put("customerIfcCode", customerMaster.getCustomerBankDetails().get(0).getIfscCode());
				jsonObject.put("customerBankCity", customerMaster.getCustomerBankDetails().get(0).getBankCity());
				jsonObject.put("customerBankCountry", customerMaster.getCustomerBankDetails().get(0).getBankCountry());
				
				}else{
					
					jsonObject.put("customerBankName", "");
					jsonObject.put("customerAccountNo","");
					jsonObject.put("customerBranchName","");
					jsonObject.put("customerIfcCode","");
					jsonObject.put("customerBankCity","");
					jsonObject.put("customerBankCountry","");
					
				}
				

			} else {
				jsonObject.put("address", "E");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(jsonObject.size() + "" + jsonObject.toString());
		return jsonObject.toString();
	}

	
}
