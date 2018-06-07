package org.clss.businessportal.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.clss.businessportal.custommodel.MenuAccessCustomModel;
import org.clss.businessportal.dao.CustomerMasterDao;
import org.clss.businessportal.dao.UserMasterDao;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.entity.CustomerMaster;
import org.clss.businessportal.entity.UserMaster;
import org.clss.businessportal.entity.VendorMaster;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class RestWebController {

	@Autowired
	private UserMasterDao userDao;

	@Autowired
	private CustomerMasterDao customerMasterDao;

	@RequestMapping(value = "/getLoginStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject getLoginStatus(HttpEntity<String> httpEntity) {

		String inputJson = httpEntity.getBody();
		System.out.println("request body: " + httpEntity.getBody());
		HttpHeaders headers = httpEntity.getHeaders();
		System.out.println("request headers " + headers);
		System.out.println("httpEntity.." + httpEntity.toString());
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		JSONObject jsonObjectsMain = new JSONObject();
		JSONArray array = new JSONArray(inputJson);

		String userName, password;

		userName = array.getJSONObject(0).getString("USER_NAME").toString();
		password = array.getJSONObject(0).getString("PASSWORD").toString();

		JSONObject jObject = new JSONObject();

		try {
			UserMaster users = userDao.getUsermasterData(userName);
			if (users != null) {
				if (users.getPassword().equals(password)) {
					if (!users.getStatus().equals("X")) {

						if (users.getStatus().equals("N")) {

							jObject.put("STATUS", "You are new user");
						} else if (users.getStatus().equals("A")) {

							// if (users.getId().getUserTypeId() == 1) {
							// jObject.put("STATUS", "You are new user");
							// }
							// else
							if (users.getId().getUserTypeId() == 2) {

								String companyCode = users.getId().getCompCode();
								String userId = users.getId().getUserId();
								CustomerMaster customerMaster = customerMasterDao.getCustomerData(companyCode,
										String.valueOf(userId));
								if (customerMaster != null) {
									jObject.put("CUSTOMER_CODE", customerMaster.getId().getCustomerCode());
									jObject.put("CUSTOMER_GROUP", customerMaster.getId().getCustomerCode());
									jObject.put("CUSTOMER_NAME", customerMaster.getName());
									jObject.put("CUSTOMER_NAME2", customerMaster.getName2());
									jObject.put("DOOR_NO", customerMaster.getName2());
									jObject.put("STREET_NAME_1", customerMaster.getStreetName1());
									jObject.put("STREET_NAME_2", customerMaster.getStreetName2());
									jObject.put("STREET_NAME_3", customerMaster.getStreetName3());
									jObject.put("CITY", customerMaster.getCity());
									jObject.put("DISTRICT", customerMaster.getDistrict());
									jObject.put("POSTAL_CODE", customerMaster.getPostalCode());
									jObject.put("LANDMARK", customerMaster.getLandmark());
									jObject.put("MOBILE_NO_1", customerMaster.getMobileNo1());
									jObject.put("MOBILE_NO_2", customerMaster.getMobileNo2());
									jObject.put("PAN_NO", customerMaster.getPanNo());
									jObject.put("GSTIN_NO", customerMaster.getGstin());
									jObject.put("EMAIL", customerMaster.getEmail());
									jObject.put("CRATE_CAPACITY", customerMaster.getCrateCapacity());
									jObject.put("REGION_CODE",
											customerMaster.getRegionMaster().getId().getRegionCode());
									jObject.put("REGION_NAME", customerMaster.getRegionMaster().getRegionName());
									jObject.put("COUNTRY_CODE",
											customerMaster.getRegionMaster().getCountryMaster().getCountryCode());
									jObject.put("COUNTRY_NAME",
											customerMaster.getRegionMaster().getCountryMaster().getCountryName());
									
									if(customerMaster.getCustomerBankDetails().size()>0){
									
									jObject.put("BANK_NAME", customerMaster.getCustomerBankDetails().get(0).getBankName());
									jObject.put("ACCOUNT_NO", customerMaster.getCustomerBankDetails().get(0).getId().getAccountNo());
									jObject.put("BRNCH_NAME", customerMaster.getCustomerBankDetails().get(0).getBranchName());
									jObject.put("IFC_CODE", customerMaster.getCustomerBankDetails().get(0).getIfscCode());
									jObject.put("BANK_CITY", customerMaster.getCustomerBankDetails().get(0).getBankCity());
									jObject.put("BANK_COUNTRY", customerMaster.getCustomerBankDetails().get(0).getBankCountry());
									}else{
										
										jObject.put("BANK_NAME", "");
										jObject.put("ACCOUNT_NO","");
										jObject.put("BRNCH_NAME","");
										jObject.put("IFC_CODE","");
										jObject.put("BANK_CITY","");
										jObject.put("BANK_COUNTRY","");
									}
									jObject.put("STATUS", "ACTIVE");
								} else {

									jObject.put("STATUS", "No customer data");
								}

							}

						} else if (users.getStatus().equals("O")) {
							jObject.put("STATUS", "You are wating for OTP Verification ");

						}

					} else {
						jObject.put("STATUS", "User ID blocked by admin");
					}
				} else {
					jObject.put("STATUS", "User name and password did not match");

				}
			} else {
				jObject.put("STATUS", "Invalid user Name");

			}
		} catch (Exception e) {
			e.printStackTrace();

			jObject.put("STATUS", "Connection Error");

		}
		jsonObjects.add(jObject);

		jsonObjectsMain.accumulate("LOGIN_DATA", jsonObjects);

		return jsonObjectsMain;

	}

}
