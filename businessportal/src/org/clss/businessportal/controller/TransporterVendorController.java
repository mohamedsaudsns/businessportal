package org.clss.businessportal.controller;

import java.math.BigDecimal;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.MonthlyVehicleDetailsCustomModel;
import org.clss.businessportal.custommodel.OutstandingReportCustomModel;
import org.clss.businessportal.custommodel.VendorVehicleDetailsCustomModel;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TransporterVendorController {

	@Autowired
	private VendorMasterDao vendorMasterDao;

	@Autowired
	private Util util;

	@RequestMapping("/getTransporterPayment")
	public @ResponseBody JqgridResponse getTransporterPayment(
			@RequestParam(value = "selected_from_date") String selected_date,
			@RequestParam(value = "selected_to_date") String selected_to_date,
			@RequestParam(value = "itemType") String itemType, HttpServletRequest request) throws ParseException {

		System.out.println("selected_date.." + selected_date);

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

		List<Object[]> getOutstandingReport = vendorMasterDao.getTransporterPayment(companyCode, String.valueOf(userId),
				"" + parsedDate, "" + parsedDate_to, itemType);

		List<OutstandingReportCustomModel> rCustomModel = new ArrayList<OutstandingReportCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			OutstandingReportCustomModel recModel = new OutstandingReportCustomModel();

			recModel.setDocDate(outReport[0].toString());
			recModel.setFiYear(outReport[1].toString());
			recModel.setDocNo(outReport[2].toString());
			if (outReport[3] != null) {
				recModel.setAssigment(outReport[3].toString());
			} else {

				recModel.setAssigment("");
			}

			recModel.setItemText(outReport[4].toString());
			if (outReport[5].toString().equals("H")) {
				recModel.setDb_ind("Credit");

			} else if (outReport[5].toString().equals("S")) {
				recModel.setDb_ind("Debit");
			}

			recModel.setAmount(outReport[6].toString());

			rCustomModel.add(recModel);
		}

		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(
				rCustomModel);
		return dataGrid;
	}

	@RequestMapping("/getVendorVehicleReport")
	public @ResponseBody JqgridResponse getVendorVehicleReport(
			@RequestParam(value = "selected_from_date") String selected_date,
			@RequestParam(value = "selected_to_date") String selected_to_date,
			@RequestParam(value = "itemType") String itemType, HttpServletRequest request) throws ParseException {

	


		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");



		List<Object[]> getOutstandingReport = vendorMasterDao.getVendorVehicleReport(companyCode,
				String.valueOf(userId), "" + selected_date, "" + selected_to_date);

		List<VendorVehicleDetailsCustomModel> rCustomModel = new ArrayList<VendorVehicleDetailsCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			VendorVehicleDetailsCustomModel recModel = new VendorVehicleDetailsCustomModel();

			recModel.setTruckNo(outReport[0].toString());

			if (outReport[1].toString().equals("S")) {

				recModel.setPermitStatus("State");
			} else if (outReport[1].toString().equals("N")) {
				recModel.setPermitStatus("National");

			} else {

				recModel.setPermitStatus(outReport[1].toString());

			}

			recModel.setRcDate(outReport[2].toString());

			recModel.setCrateCapacity("" + Util.indianRupeeFormat("" + outReport[4].toString()));
			recModel.setDieselCardNumber(outReport[5].toString());

			recModel.setName(outReport[6].toString());
			recModel.setVendorVechileCode(outReport[7].toString());
			recModel.setVehcileModel1(outReport[8].toString());
			recModel.setVehcileModel2(outReport[9].toString());
			if (outReport[10] != null && outReport[10].toString().trim().length()>0 ) {

				recModel.setVehicleStatus("In Active");

			} else {
				recModel.setVehicleStatus("Active");

			}

			rCustomModel.add(recModel);
		}

		JqgridResponse<VendorVehicleDetailsCustomModel> dataGrid = new JqgridResponse<VendorVehicleDetailsCustomModel>(
				rCustomModel);
		return dataGrid;
	}

	@RequestMapping("/getMonthlyVehicleDetailsReport")
	public @ResponseBody JqgridResponse getMonthlyVehicleDetailsReport(
			@RequestParam(value = "selected_from_date") String selected_date,
			@RequestParam(value = "selected_to_date") String selected_to_date,
			@RequestParam(value = "itemType") String itemType, HttpServletRequest request) throws ParseException {

		System.out.println("selected_date.." + selected_date);

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

		List<Object[]> getOutstandingReport = vendorMasterDao.getMonthlyVehicleDetailsReport(companyCode,
				String.valueOf(userId), "" + parsedDate, "" + parsedDate_to);

		List<MonthlyVehicleDetailsCustomModel> rCustomModel = new ArrayList<MonthlyVehicleDetailsCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			MonthlyVehicleDetailsCustomModel recModel = new MonthlyVehicleDetailsCustomModel();
			recModel.setPlant(outReport[0].toString());
			recModel.setPlantDesc(outReport[1].toString());
			recModel.setShipmentNo(outReport[2].toString());
			recModel.setRoute(outReport[3].toString());
			recModel.setRouteDesc(outReport[4].toString());
			recModel.setVehicleNumber(outReport[5].toString());
			recModel.setRouteMasterDistance(outReport[6].toString());
			recModel.setStartKM(outReport[7].toString());
			recModel.setEndKM(outReport[8].toString());
			recModel.setRunningKM(outReport[9].toString());
			recModel.setActualKM(outReport[10].toString());
			recModel.setRatePerKm(outReport[11].toString());
			if (outReport[12] != null) {
				recModel.setTollgateAmount("" + outReport[12].toString());
			} else {

				recModel.setTollgateAmount("");
			}
			recModel.setStageFixedAmt("" + outReport[13].toString());
			recModel.setAdditionalAmt("" + outReport[14].toString());

			recModel.setDeductionAmt("" + outReport[15].toString());
			recModel.setFreight("" + outReport[16].toString());
			recModel.setFreightFixed("" + outReport[17].toString());
			recModel.setSupplm1("" + outReport[18].toString());
			recModel.setSupplm2("" + outReport[19].toString());
			recModel.setSecRouteFreightRate("" + outReport[20].toString());
			recModel.setSecRouteFreight("" + outReport[21].toString());

			Date shipDate = new SimpleDateFormat("yyyy-MM-dd").parse(outReport[22].toString());
			SimpleDateFormat formatshipDate = new SimpleDateFormat("dd-MM-yyyy");
			String shipmentDate = formatshipDate.format(selected_date_for);
			recModel.setShipmentDate(shipmentDate);

			recModel.setFreightRateKG("" + outReport[23].toString());
			recModel.setTotalAddnAmt("" + outReport[24].toString());
			recModel.setFreightDeduction("" + outReport[25].toString());
			recModel.setFlatAmtDeduction("" + outReport[26].toString());
			recModel.setvTrackDeduction("" + outReport[27].toString());
			recModel.setkMNotRunningDeduction("" + outReport[28].toString());
			recModel.setaCNotRunningDeduction("" + outReport[29].toString());
			recModel.setVehicleAgeingDeduction("" + outReport[30].toString());
			recModel.setInvoicingPartywiseCost("" + outReport[31].toString());
			recModel.setCurrentLoadingDate("" + outReport[32].toString());
			recModel.setServiceAgent("" + outReport[33].toString());

			rCustomModel.add(recModel);
		}

		JqgridResponse<MonthlyVehicleDetailsCustomModel> dataGrid = new JqgridResponse<MonthlyVehicleDetailsCustomModel>(
				rCustomModel);
		return dataGrid;
	}

	@RequestMapping("/getSecurityDepositStatusReport")
	public @ResponseBody JqgridResponse getSecurityDepositStatusReport(
			@RequestParam(value = "selected_from_date") String selected_date,
			@RequestParam(value = "selected_to_date") String selected_to_date,
			@RequestParam(value = "itemType") String itemType, HttpServletRequest request) throws ParseException {

		System.out.println("selected_date.." + selected_date);
		String date="";


		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

//		Date selected_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_date);
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		String parsedDate = formatter.format(selected_date_for);
//
//		Date selected_to_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_to_date);
//		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
//		String parsedDate_to = formatter1.format(selected_to_date_for);

		List<Object[]> getOutstandingReport = vendorMasterDao.getSecurityDepositStatusReport(companyCode,
				String.valueOf(userId), "" + date, "" + date, itemType);

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
				recModel.setAmount("-" + Util.indianRupeeFormat("" + outReport[7].toString()));
				recModel.setCreditAmount("" + Util.indianRupeeFormat("" + outReport[7].toString()));

			} else if (outReport[8].toString().equals("S")) {
				recModel.setAmount("" + Util.indianRupeeFormat("" + outReport[7].toString()));
				recModel.setDebitAmount("" + Util.indianRupeeFormat("" + outReport[7].toString()));

			}
			if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 15) {
				recModel.setTo15(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 30) {
				recModel.setTo30(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 45) {
				recModel.setTo45(outReport[7].toString());

			}
			recModel.setVendorName(outReport[9].toString());
			recModel.setDocTypeName(outReport[10].toString());

			if (outReport[13] != null) {
				recModel.setRemark("" + outReport[13].toString());
			} else {

				recModel.setRemark("");
			}

			if (outReport[7] != null) {
				recModel.setSecurityDepositAmount("" + outReport[7].toString());
			} else {

				recModel.setSecurityDepositAmount("");
			}

			if (outReport[12] != null) {
				recModel.setTdsAmount("" + Util.indianRupeeFormat("" + outReport[12].toString()));
			} else {

				recModel.setTdsAmount("");
			}

			if (outReport[13] != null) {
				recModel.setItemText("" + outReport[13].toString());
			} else {

				recModel.setItemText("");
			}

			if (outReport[14] != null) {
				recModel.setAssigment("" + outReport[14].toString());
			} else {

				recModel.setAssigment("");
			}

			if (outReport[15] != null) {
				recModel.setVechNO("" + outReport[15].toString());
			} else {

				recModel.setVechNO("");
			}

			BigDecimal rentAmountBig = new BigDecimal(outReport[7].toString().replace("-", ""));
			BigDecimal tedAmountBig = new BigDecimal(outReport[12].toString());

			BigDecimal netAmount;

			netAmount = rentAmountBig.subtract(tedAmountBig);

			recModel.setNetAmount("" + Util.indianRupeeFormat("" + netAmount));

			recModel.setPaymentAmount("" + Util.indianRupeeFormat("" + outReport[7].toString().replace("-", "")));

			rCustomModel.add(recModel);
		}

		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(
				rCustomModel);
		return dataGrid;
	}
	
	
	
	@RequestMapping("/getMonthlyVehiclewiseAdditionalAmountReport")
	public @ResponseBody JqgridResponse getMonthlyVehiclewiseAdditionalAmountReport(
			@RequestParam(value = "selected_from_date") String selected_date,
			@RequestParam(value = "selected_to_date") String selected_to_date,
			@RequestParam(value = "itemType") String itemType, @RequestParam(value = "docType") String docType,
			HttpServletRequest request) throws ParseException {

		System.out.println("selected_date.." + selected_date);

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

		List<Object[]> getOutstandingReport = vendorMasterDao.MonthlyVehiclewiseAdditionalAmount(companyCode,
				String.valueOf(userId), "" + parsedDate, "" + parsedDate_to, itemType, docType);

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
				recModel.setAmount("-" + Util.indianRupeeFormat("" + outReport[7].toString()));
				recModel.setCreditAmount("" + Util.indianRupeeFormat("" + outReport[7].toString()));

			} else if (outReport[8].toString().equals("S")) {
				recModel.setAmount("" + Util.indianRupeeFormat("" + outReport[7].toString()));
				recModel.setDebitAmount("" + Util.indianRupeeFormat("" + outReport[7].toString()));

			}
			if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 15) {
				recModel.setTo15(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 30) {
				recModel.setTo30(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 45) {
				recModel.setTo45(outReport[7].toString());

			}
			recModel.setVendorName(outReport[9].toString());
			recModel.setDocTypeName(outReport[10].toString());

			if (outReport[13] != null) {
				recModel.setRemark("" + outReport[13].toString());
			} else {

				recModel.setRemark("");
			}
			
			

			if (outReport[7] != null && outReport[7].toString().trim().length()>0) {
				
				if(Util.getSpecialCharacterCheck(outReport[7].toString())) {
					if(outReport[7] != null && outReport[7].toString().trim().length()>0) {
					
					recModel.setAdditionalAmount("" + outReport[7].toString().replace("-", ""));
					}else {
						
						recModel.setAdditionalAmount("0.00");
					}
					
				}else {
					recModel.setAdditionalAmount("0.00");
					recModel.setSecurityDepositAmount("" + outReport[7].toString());
				}
			
			} else {
				recModel.setAdditionalAmount("0.00" );
				recModel.setSecurityDepositAmount("0.00");
			}

			if (outReport[12] != null) {
				recModel.setTdsAmount("" + Util.indianRupeeFormat("" + outReport[12].toString()));
			} else {

				recModel.setTdsAmount("");
			}

			if (outReport[14] != null) {
				recModel.setAssigment(outReport[14].toString());

			} else {

				recModel.setAssigment("");
			}

			if (outReport[15] != null) {
				recModel.setVechNO("" + outReport[15].toString());
			} else {

				recModel.setVechNO("");
			}
			
			if (outReport[16] != null) {
				recModel.setClrDocNo("" + outReport[16].toString());
			} else {

				recModel.setClrDocNo("");
			}

			BigDecimal rentAmountBig = new BigDecimal(outReport[7].toString().replace("-", ""));
			BigDecimal tedAmountBig = new BigDecimal(outReport[12].toString());

			BigDecimal netAmount;

			netAmount = rentAmountBig.subtract(tedAmountBig);

			recModel.setNetAmount("" + Util.indianRupeeFormat("" + netAmount));

			recModel.setPaymentAmount("" + Util.indianRupeeFormat("" + outReport[7].toString().replace("-", "")));

			rCustomModel.add(recModel);
		}

		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(
				rCustomModel);
		return dataGrid;
	}

	@RequestMapping("/getMonthlyVehiclewiseDieselAmountReport")
	public @ResponseBody JqgridResponse getMonthlyVehiclewiseDieselAmountReport(
			@RequestParam(value = "selected_from_date") String selected_date,
			@RequestParam(value = "selected_to_date") String selected_to_date,
			@RequestParam(value = "itemType") String itemType, @RequestParam(value = "docType") String docType,
			HttpServletRequest request) throws ParseException {

		System.out.println("selected_date.." + selected_date);

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

		List<Object[]> getOutstandingReport = vendorMasterDao.MonthlyVehiclewiseDieselAmount(companyCode,
				String.valueOf(userId), "" + parsedDate, "" + parsedDate_to, itemType, docType);

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
				recModel.setAmount("-" + Util.indianRupeeFormat("" + outReport[7].toString()));
				recModel.setCreditAmount("" + Util.indianRupeeFormat("" + outReport[7].toString()));

			} else if (outReport[8].toString().equals("S")) {
				recModel.setAmount("" + Util.indianRupeeFormat("" + outReport[7].toString()));
				recModel.setDebitAmount("" + Util.indianRupeeFormat("" + outReport[7].toString()));

			}
			if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 15) {
				recModel.setTo15(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 30) {
				recModel.setTo30(outReport[7].toString());

			} else if (util.getNoOfDaysBtwnDates(outReport[5].toString()) <= 45) {
				recModel.setTo45(outReport[7].toString());

			}
			recModel.setVendorName(outReport[9].toString());
			recModel.setDocTypeName(outReport[10].toString());

			if (outReport[13] != null) {
				recModel.setRemark("" + outReport[13].toString());
			} else {

				recModel.setRemark("");
			}

			if (outReport[7] != null) {
				recModel.setSecurityDepositAmount("" + outReport[7].toString().replace("-", ""));
			} else {

				recModel.setSecurityDepositAmount("");
			}

			if (outReport[12] != null) {
				recModel.setTdsAmount("" + Util.indianRupeeFormat("" + outReport[12].toString()));
			} else {

				recModel.setTdsAmount("");
			}

			if (outReport[14] != null) {
				recModel.setAssigment(outReport[14].toString());

			} else {

				recModel.setAssigment("");
			}

			if (outReport[15] != null) {
				recModel.setVechNO("" + outReport[15].toString());
			} else {

				recModel.setVechNO("");
			}
			
			if (outReport[16] != null) {
				recModel.setBunkName("" + outReport[16].toString());
			} else {

				recModel.setBunkName("");
			}
			
			

			BigDecimal rentAmountBig = new BigDecimal(outReport[7].toString().replace("-", ""));
			BigDecimal tedAmountBig = new BigDecimal(outReport[12].toString());

			BigDecimal netAmount;

			netAmount = rentAmountBig.subtract(tedAmountBig);

			recModel.setNetAmount("" + Util.indianRupeeFormat("" + netAmount));

			recModel.setPaymentAmount("" + Util.indianRupeeFormat("" + outReport[7].toString().replace("-", "")));

			rCustomModel.add(recModel);
		}

		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(
				rCustomModel);
		return dataGrid;
	}

	@RequestMapping("/getSecurityDepositAmount")
	public @ResponseBody String getVendorOutstandingAmount(HttpServletRequest req) {
		String ret = "E";
		try {

			String companyCode = (String) req.getSession().getAttribute("companyCode");
			String userId = (String) req.getSession().getAttribute("userId");

			String ret1 = vendorMasterDao.getVendorOutstandingAmount(companyCode, String.valueOf(userId));

			ret = ret1;

		} catch (Exception e) {
			e.printStackTrace();
			ret = "E";
		}
		return ret;
	}

}
