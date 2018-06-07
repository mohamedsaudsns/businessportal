package org.clss.businessportal.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.clss.businessportal.custommodel.AverageMilkMonthCustomModel;
import org.clss.businessportal.custommodel.AverageMilkMonthLiCustomModel;
import org.clss.businessportal.custommodel.EkoMaterialStockCustomModel;
import org.clss.businessportal.custommodel.HmbDetailsCustomModel;
import org.clss.businessportal.custommodel.HmbServiceChargeCustomModel;
import org.clss.businessportal.custommodel.HmbSummaryCustomModel;
import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.MaterialStockCustomModel;
import org.clss.businessportal.custommodel.MilkDeductionDetailCustomModel;
import org.clss.businessportal.custommodel.MilkFeedsCustomModel;
import org.clss.businessportal.custommodel.MilkLiabilityCustomModel;
import org.clss.businessportal.custommodel.OutstandingReportCustomModel;
import org.clss.businessportal.dao.HmbDao;
import org.clss.businessportal.entity.EkoMaterialStock;
import org.clss.businessportal.entity.MaterialStock;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HmbController {

	@Autowired
	private HmbDao hmpDao;
	
	
	
	@RequestMapping("/getMilkLiability")
	public @ResponseBody JqgridResponse getMilkLiability(
			 HttpServletRequest request)
			throws ParseException {

		

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");

	
		List<MilkLiabilityCustomModel> hmbSummaryList = new ArrayList<MilkLiabilityCustomModel>();

		List<Object[]> hmbServiceCharges = hmpDao.getMilkLiability(socity);



		for (Object[] outReport : hmbServiceCharges) {

			MilkLiabilityCustomModel recModel = new MilkLiabilityCustomModel();
			recModel.setInputDate(outReport[0].toString());
			recModel.setFromDate(outReport[1].toString());
			recModel.setToDate(outReport[2].toString());
			recModel.setLpd(outReport[3].toString());
			recModel.setNop(outReport[4].toString());
			recModel.setFatPer(outReport[5].toString());
			recModel.setSnfPer(outReport[6].toString());
		
			
		
		
			hmbSummaryList.add(recModel);
		}


		JqgridResponse<MilkLiabilityCustomModel> dataGrid = new JqgridResponse<MilkLiabilityCustomModel>(hmbSummaryList);
		return dataGrid;
	}
	
	@RequestMapping("/getFeedQty")
	public @ResponseBody JqgridResponse getFeedQty(
			 HttpServletRequest request)
			throws ParseException {

		

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");

	
		List<MilkFeedsCustomModel> hmbSummaryList = new ArrayList<MilkFeedsCustomModel>();

		List<Object[]> hmbServiceCharges = hmpDao.MilkFeeds(socity);



		for (Object[] outReport : hmbServiceCharges) {

			MilkFeedsCustomModel recModel = new MilkFeedsCustomModel();
			recModel.setInputDate(outReport[0].toString());
			recModel.setSumOfFeed(outReport[1].toString());
			
		
			
		
		
			hmbSummaryList.add(recModel);
		}


		JqgridResponse<MilkFeedsCustomModel> dataGrid = new JqgridResponse<MilkFeedsCustomModel>(hmbSummaryList);
		return dataGrid;
	}
	
	
	
	public List<HmbServiceChargeCustomModel> getOldPayslip(List<Object[]> hmbServiceCharges,String companyCode,String userId,String fromdate,String todate){
		
		List<HmbServiceChargeCustomModel> hmbSummaryList = new ArrayList<HmbServiceChargeCustomModel>();

		

BigDecimal servicChargeamount=new BigDecimal("0");
BigDecimal lineDeductionAmount=new BigDecimal("0");
		for (Object[] outReport : hmbServiceCharges) {
			

			HmbServiceChargeCustomModel recModel = new HmbServiceChargeCustomModel();
			recModel.setPaySlipStatus(false);
			recModel.setPostDate(outReport[0].toString());
			recModel.setBillName(outReport[1].toString());
			recModel.setTotalAmount(Util.indianRupeeFormat(""+outReport[2].toString()));
			recModel.setTds(Util.convertToSpecialCharacterAmount(""+outReport[3].toString()));
			
			recModel.setNeAmount(Util.indianRupeeFormat(""+outReport[4].toString().trim()));
			
			recModel.setcStartDate(outReport[5].toString());
			recModel.setcEndDate(outReport[6].toString());
			recModel.setSocity(outReport[7].toString());
			recModel.setcName(outReport[8].toString());
			recModel.setAvgQty(outReport[9].toString());
			recModel.setVendorCode(outReport[10].toString());
			recModel.setVendorName(outReport[11].toString());
			recModel.setNoOfDays(outReport[12].toString());
			recModel.setPanNo(outReport[13].toString());
			recModel.setPlantAddress(outReport[14].toString());
			recModel.setCity(outReport[15].toString());
			recModel.setPincode(outReport[16].toString());
			
			
			recModel.setSampleMilkAmount(Util.indianRupeeFormat(""+outReport[17].toString()));
			recModel.setArrearAmount(Util.indianRupeeFormat(""+outReport[18].toString()));
			recModel.setActDed(Util.indianRupeeFormat(""+outReport[19].toString()));
			recModel.setTsTally(Util.indianRupeeFormat(""+outReport[20].toString()));
			recModel.setAdltComm(Util.indianRupeeFormat(""+outReport[21].toString()));
			recModel.setTestComm(Util.indianRupeeFormat(""+outReport[22].toString()));
			recModel.setSpilComm(Util.indianRupeeFormat(""+outReport[23].toString()));
			recModel.setTsComm(Util.indianRupeeFormat(""+outReport[24].toString()));
			recModel.setQtyComm(Util.indianRupeeFormat(""+outReport[25].toString()));
			
			recModel.setFeedAmount(Util.indianRupeeFormat(""+outReport[26].toString()));
			
			recModel.setIncAmount(Util.indianRupeeFormat(""+outReport[27].toString()));
			recModel.setSmsAmount(Util.indianRupeeFormat(""+outReport[28].toString()));
			recModel.setPlantDesc(""+outReport[29].toString());
			
			
			servicChargeamount=new BigDecimal(outReport[20].toString())
					.add(new BigDecimal(outReport[21].toString()))
					.add(new BigDecimal(outReport[22].toString()))
					.add(new BigDecimal(outReport[23].toString()))
					.add(new BigDecimal(outReport[24].toString()))
					.add(new BigDecimal(outReport[25].toString()))
					.add(new BigDecimal(outReport[26].toString()))
					.add(new BigDecimal(outReport[27].toString()))
					.add(new BigDecimal(outReport[18].toString()));
			
			String Dedutiondetails="";
			String TotalDeductionAmount="";
			
			
			
			List<Object[]> hmbServiceDeduction = hmpDao.getHmServiceChargeDeduction(userId, outReport[7].toString(), outReport[5].toString(), outReport[6].toString());
			for (Object[] outReport1 : hmbServiceDeduction) {
				Dedutiondetails+=""+outReport1[0]+"^"+outReport1[2]+"!";
				
				lineDeductionAmount = lineDeductionAmount.add(new BigDecimal(outReport1[2].toString()));
//				lineDeductionAmount = lineDeductionAmount.add(new BigDecimal(outReport1[2].toString()));
				System.out.println("line amount"+lineDeductionAmount);
			}
			
			System.out.println("tds amount.."+outReport[3].toString());
			TotalDeductionAmount=""+new BigDecimal(Util.convertToSpecialCharacterAmount(""+outReport[3].toString())).add(lineDeductionAmount);
			
			System.out.println("Dedutiondetails.."+Dedutiondetails);
			System.out.println("TotalDeductionAmount.."+TotalDeductionAmount);
			System.out.println("lineDeductionAmount.."+lineDeductionAmount);
			
			recModel.setDeductionDetails(Dedutiondetails);
			recModel.setTotalDeductionAmount(TotalDeductionAmount);
			
//			
			recModel.setServiceCharge(""+servicChargeamount);
		
		
			hmbSummaryList.add(recModel);
		}
		
		
		return hmbSummaryList;
	}
	
	
	
	public List<HmbServiceChargeCustomModel> getNewPayslip(List<Object[]> hmbServiceCharges,String companyCode,String userId,String fromdate,String todate){
		
		List<HmbServiceChargeCustomModel> hmbSummaryList = new ArrayList<HmbServiceChargeCustomModel>();

		

BigDecimal servicChargeamount=new BigDecimal("0");
BigDecimal lineDeductionAmount=new BigDecimal("0");
BigDecimal lineArrearAmount=new BigDecimal("0");
		for (Object[] outReport : hmbServiceCharges) {
			

			HmbServiceChargeCustomModel recModel = new HmbServiceChargeCustomModel();
			recModel.setPaySlipStatus(true);
		
			recModel.setPostDate(outReport[0].toString());
			recModel.setBillName(outReport[1].toString());
			recModel.setTotalAmount(Util.indianRupeeFormat(""+outReport[2].toString()));
			recModel.setTds(Util.convertToSpecialCharacterAmount(""+outReport[3].toString()));
			
			recModel.setNeAmount(Util.indianRupeeFormat(""+outReport[4].toString().trim()));
			
			recModel.setcStartDate(outReport[5].toString());
			recModel.setcEndDate(outReport[6].toString());
			recModel.setSocity(outReport[7].toString());
			recModel.setcName(outReport[8].toString());
			recModel.setAvgQty(outReport[9].toString());
			recModel.setVendorCode(outReport[10].toString());
			recModel.setVendorName(outReport[11].toString());
			recModel.setNoOfDays(outReport[12].toString());
			recModel.setPanNo(outReport[13].toString());
			recModel.setPlantAddress(outReport[14].toString());
			recModel.setCity(outReport[15].toString());
			recModel.setPincode(outReport[16].toString());
			
			
			recModel.setSampleMilkAmount(Util.indianRupeeFormat(""+outReport[17].toString()));
			recModel.setArrearAmount(Util.indianRupeeFormat(""+outReport[18].toString()));
			recModel.setActDed(Util.indianRupeeFormat(""+outReport[19].toString()));
			recModel.setTsTally(Util.indianRupeeFormat(""+outReport[20].toString()));
			recModel.setAdltComm(Util.indianRupeeFormat(""+outReport[21].toString()));
			recModel.setTestComm(Util.indianRupeeFormat(""+outReport[22].toString()));
			recModel.setSpilComm(Util.indianRupeeFormat(""+outReport[23].toString()));
			recModel.setTsComm(Util.indianRupeeFormat(""+outReport[24].toString()));
			recModel.setQtyComm(Util.indianRupeeFormat(""+outReport[25].toString()));
			
			recModel.setFeedAmount(Util.indianRupeeFormat(""+outReport[26].toString()));
			
			recModel.setIncAmount(Util.indianRupeeFormat(""+outReport[27].toString()));
			recModel.setSmsAmount(Util.indianRupeeFormat(""+outReport[28].toString()));
			recModel.setPlantDesc(""+outReport[29].toString());
			
			
			servicChargeamount=new BigDecimal(outReport[20].toString())
					.add(new BigDecimal(outReport[21].toString()))
					.add(new BigDecimal(outReport[22].toString()))
					.add(new BigDecimal(outReport[23].toString()))
					.add(new BigDecimal(outReport[24].toString()))
					.add(new BigDecimal(outReport[25].toString()))
					.add(new BigDecimal(outReport[26].toString()))
					.add(new BigDecimal(outReport[27].toString()))
					.add(new BigDecimal(outReport[18].toString()));
			
			String Dedutiondetails="";
			String TotalDeductionAmount="";
			
			
			
			List<Object[]> hmbServiceDeduction = hmpDao.getHmServiceChargeDeduction(userId, outReport[7].toString(), outReport[5].toString(), outReport[6].toString());
			for (Object[] outReport1 : hmbServiceDeduction) {
				Dedutiondetails+=""+outReport1[0]+"^"+Util.indianRupeeFormat(""+outReport1[2])+"!";
				
				lineDeductionAmount = lineDeductionAmount.add(new BigDecimal(outReport1[2].toString()));
				System.out.println("line amount"+lineDeductionAmount);
			}
			
			System.out.println("tds amount.."+outReport[3].toString());
			TotalDeductionAmount=""+new BigDecimal(Util.convertToSpecialCharacterAmount(""+outReport[3].toString())).add(lineDeductionAmount);
			
			System.out.println("Dedutiondetails.."+Dedutiondetails);
			System.out.println("TotalDeductionAmount.."+TotalDeductionAmount);
			System.out.println("lineDeductionAmount.."+lineDeductionAmount);
			
			recModel.setDeductionDetails(Dedutiondetails);
			recModel.setTotalDeductionAmount(Util.indianRupeeFormat(""+TotalDeductionAmount));
			
			
			// Arrear Line Item
			String ArrearDetails="";
			
			boolean arrearCondition=false;
			
			
			List<Object[]> hmbServiceArrear= hmpDao.getHmServiceArrear( outReport[7].toString(), outReport[5].toString(), outReport[6].toString());
			for (Object[] outReport2 : hmbServiceArrear) {
				ArrearDetails+=""+outReport2[0]+"^"+outReport2[1]+"^"+Util.indianRupeeFormat(""+outReport2[2])+"!";
				if(!arrearCondition) {
				if(outReport2[0].toString().equals("SAI")) {
					
					
						arrearCondition=true;
					}
					
					
				}
				
				lineArrearAmount = lineArrearAmount.add(new BigDecimal(outReport2[2].toString()));
				System.out.println("lineArrearAmount "+lineArrearAmount);
			}
	
			System.out.println("ArrearAmount "+lineArrearAmount);
		System.out.println("arrearCondition.."+arrearCondition);
			recModel.setArrearCondition(arrearCondition);
			
			recModel.setArrearDetails(ArrearDetails);
			recModel.setTotalArrearAmount(""+Util.indianRupeeFormat(""+lineArrearAmount));
			
			
			// Toatal Payable Amount calculation
			
			BigDecimal totalPayable=new BigDecimal("0");
			BigDecimal netAmount=new BigDecimal("0");
			
			totalPayable=totalPayable.add(lineArrearAmount).add(new BigDecimal(outReport[27].toString()))
					.add(new BigDecimal(outReport[20].toString())).add(new BigDecimal(outReport[21].toString()))
					.add(new BigDecimal(outReport[22].toString())).add(new BigDecimal(outReport[23].toString()))
					.add(new BigDecimal(outReport[24].toString())).add(new BigDecimal(outReport[25].toString()))
					.add(new BigDecimal(outReport[26].toString()));
			
			
			System.out.println("totalPayable.."+totalPayable);
			recModel.setTotalPayable(""+Util.indianRupeeFormat(""+totalPayable));

			netAmount=totalPayable.subtract(new BigDecimal(TotalDeductionAmount));
			
			recModel.setNetAmount(""+Util.convertToSpecialCharacterAmount(""+netAmount));
//			
			recModel.setServiceCharge(""+servicChargeamount);
		
		
			hmbSummaryList.add(recModel);
		}
		
		
		return hmbSummaryList;
	}
	
	
	
	@RequestMapping("/getHmbServiceCharges")
	public @ResponseBody JqgridResponse getHmbServiceCharges(
			@RequestParam(value = "selected_month") String selected_month, HttpServletRequest request)
			throws ParseException {

		System.out.println("selected_month.." + selected_month);

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");

		String todate = Util.convertmonthYearToMonthEndDay(selected_month);
		String fromdate = "" + Util.convertFullMonthToMonthNo(selected_month) + "-01";
		List<Object[]> hmbServiceCharges = hmpDao.getHmServiceCharge(companyCode, userId, fromdate, todate);	
		
		List<HmbServiceChargeCustomModel> hmbSummaryList = null;
		
		for (Object[] outReport : hmbServiceCharges) {
			if(outReport[27].toString().equals("0.00")) {
				hmbSummaryList= getOldPayslip(hmbServiceCharges,companyCode, userId, fromdate, todate);
				System.out.println("calling Old payslip");
				
			}else {
				System.out.println("calling New payslip");
				hmbSummaryList = getNewPayslip(hmbServiceCharges,companyCode, userId, fromdate, todate);
			}
		}

		


		JqgridResponse<HmbServiceChargeCustomModel> dataGrid = new JqgridResponse<HmbServiceChargeCustomModel>(hmbSummaryList);
		return dataGrid;
	}
	
	@RequestMapping("/getHmbInchargeDeductions")
	public @ResponseBody JqgridResponse getHmbInchargeDeductions(
			@RequestParam(value = "selected_month") String selected_month, HttpServletRequest request)
			throws ParseException {

		System.out.println("selected_month.." + selected_month);

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");

		String todate = Util.convertmonthYearToMonthEndDay(selected_month);
		String fromdate = "" + Util.convertFullMonthToMonthNo(selected_month) + "-01";
		List<HmbSummaryCustomModel> hmbSummaryList = new ArrayList<HmbSummaryCustomModel>();

		List<Object[]> hmbSummary = hmpDao.getHmbInchargeDeductions(companyCode, userId, fromdate, todate);

		int count = 0;
		
		for (Object[] outReport : hmbSummary) {

			HmbSummaryCustomModel recModel = new HmbSummaryCustomModel();
		
		
			recModel.setDateFrom(outReport[0].toString());
			recModel.setDateTo(outReport[1].toString());
			recModel.setPlant(outReport[2].toString());
			recModel.setSocity(outReport[3].toString());
			recModel.setDeductions(outReport[5].toString());
			
			
			
	

			hmbSummaryList.add(recModel);

		}

		

		
		
		

		JqgridResponse<HmbSummaryCustomModel> dataGrid = new JqgridResponse<HmbSummaryCustomModel>(hmbSummaryList);
		return dataGrid;
	}
	
	
	
	@RequestMapping("/getHmbInchargeDeductionsDetails")
	public @ResponseBody JqgridResponse getHmbInchargeDeductionsDetails(
			@RequestParam(value = "fromDate") String fromDate,@RequestParam(value = "toDate") String toDate, HttpServletRequest request)
			throws ParseException {

		System.out.println("From Date.." + fromDate);
		
		
//		 String parsedDate = Util.jsDateFormateToJavaformat(fromDate);
//		 
//
//		 String parsedDate_to = Util.jsDateFormateToJavaformat(fromDate);

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");



	
		List<HmbSummaryCustomModel> hmbSummaryList = new ArrayList<HmbSummaryCustomModel>();

		List<MilkDeductionDetailCustomModel> hmbSummary = hmpDao.getHmbInchargeDeductionsDetails(companyCode, userId, fromDate, toDate);

		BigDecimal totalamount = new BigDecimal(0);
		
		for (MilkDeductionDetailCustomModel outReport : hmbSummary) {

			
			totalamount = totalamount.add(new BigDecimal(outReport.getDeductionamount()));

		}
		
		MilkDeductionDetailCustomModel deModel = new MilkDeductionDetailCustomModel();
		
		deModel.setFarmerCode("Total");
		deModel.setFarmerName("Total");
		deModel.setpCode("");
		deModel.setEntryDate("");
		deModel.setDeductionName("");
		deModel.setDeductionamount("");
		deModel.setDeductiontotalAmount(""+ Util.indianRupeeFormat(""+totalamount));
		
		
		


		hmbSummary.add(deModel);

		

		Collections.sort(hmbSummary, MilkDeductionDetailCustomModel.EntrydateComparator);
		
		

		JqgridResponse<MilkDeductionDetailCustomModel> dataGrid = new JqgridResponse<MilkDeductionDetailCustomModel>(hmbSummary);
		return dataGrid;
	}
	
	

	@RequestMapping("/getHmbInchargeSummary")
	public @ResponseBody JqgridResponse getHmbInchargeSummary(
			@RequestParam(value = "selected_month") String selected_month, HttpServletRequest request)
			throws ParseException {

		System.out.println("selected_month.." + selected_month);

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");

		String todate = Util.convertmonthYearToMonthEndDay(selected_month);
		String fromdate = "" + Util.convertFullMonthToMonthNo(selected_month) + "-01";
		List<HmbSummaryCustomModel> hmbSummaryList = new ArrayList<HmbSummaryCustomModel>();

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
			HmbSummaryCustomModel recModel = new HmbSummaryCustomModel();
			count++;
			recModel.setCompCode(outReport[0].toString());
			recModel.setBillNumber(outReport[1].toString());
			recModel.setDateFrom(outReport[2].toString());
			recModel.setDateTo(outReport[3].toString());
			recModel.setCutOff("P-" + count);
			recModel.setMilkPayment(""+  outReport[17].toString());
			
			
			// recModel.setCutOff(""+outReport[2].toString()+" -
			// "+outReport[3].toString());
			recModel.setPlant(outReport[4].toString());
			recModel.setSocity(outReport[5].toString());
			recModel.setFarmerCode(outReport[6].toString());
			recModel.setGrossAmount(outReport[7].toString());

			if (!outReport[8].toString().equals("0.00")) {
				recModel.setDeductions(outReport[8].toString());
			} else {
				recModel.setDeductions("" + outReport[8].toString());
			}

			if (!outReport[9].toString().equals("0.00")) {
				recModel.setRecoveries(outReport[9].toString());
			} else {
				recModel.setRecoveries("" + outReport[9].toString());
			}

			

			if (!outReport[14].toString().equals("0.00")) {
				recModel.setIncentive(outReport[14].toString());
			} else {
				recModel.setIncentive("" + outReport[14].toString());
			}
			
			recModel.setAcNo(outReport[15].toString());
			recModel.setIfcCode(outReport[16].toString());
			
			recModel.setArrears( outReport[10].toString());
			recModel.setNetAmount(outReport[11].toString());
			recModel.setActDed(outReport[12].toString());
			recModel.setFarmerName(outReport[13].toString());
			
			if(outReport[18]!=null) {
			recModel.setTotalLtr(outReport[18].toString());
			}else{
				recModel.setTotalLtr("0.000");
				
			}
			
			if(outReport[19]!=null) {
				recModel.setpCode(outReport[19].toString());
				}else{
					recModel.setpCode("");
					
				}
			
			
			totalamount = totalamount.add(new BigDecimal(outReport[11].toString()));
			paymentAmount = paymentAmount.add(new BigDecimal(outReport[7].toString()));
			arrearAmount = arrearAmount.add(new BigDecimal(outReport[10].toString()));
			deductionAmount = deductionAmount.add(new BigDecimal(outReport[8].toString()));

			recoveryAmount = recoveryAmount.add(new BigDecimal(outReport[9].toString()));

			// totalamount+=new Double([11].toString()));

			hmbSummaryList.add(recModel);
}
		}

		System.out.println("totalamount.." + totalamount);

		
		
		

		JqgridResponse<HmbSummaryCustomModel> dataGrid = new JqgridResponse<HmbSummaryCustomModel>(hmbSummaryList);
		return dataGrid;
	}

	@RequestMapping("/getHmbSummary")
	public @ResponseBody JqgridResponse getHmbSummary(@RequestParam(value = "selected_month") String selected_month,
			HttpServletRequest request) throws ParseException {

		System.out.println("selected_month.." + selected_month);

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");

		String todate = Util.convertmonthYearToMonthEndDay(selected_month);
		String fromdate = "" + Util.convertFullMonthToMonthNo(selected_month) + "-01";
		List<HmbSummaryCustomModel> hmbSummaryList = new ArrayList<HmbSummaryCustomModel>();

		List<Object[]> hmbSummary = hmpDao.getHmpSummary(companyCode, socity, userId, fromdate, todate);

		int count = 0;
		BigDecimal totalamount = new BigDecimal(0);
		BigDecimal paymentAmount = new BigDecimal(0);
		BigDecimal arrearAmount = new BigDecimal(0);
		BigDecimal deductionAmount = new BigDecimal("0.00");
		BigDecimal recoveryAmount = new BigDecimal("0.00");
		BigDecimal incentiveAmount = new BigDecimal(0);
		BigDecimal milkAmount = new BigDecimal(0);

		for (Object[] outReport : hmbSummary) {

			HmbSummaryCustomModel recModel = new HmbSummaryCustomModel();
			count++;
			recModel.setCompCode(outReport[0].toString());
			recModel.setBillNumber(outReport[1].toString());
			recModel.setDateFrom(outReport[2].toString());
			recModel.setDateTo(outReport[3].toString());
			recModel.setCutOff("P-" + count);
			// recModel.setCutOff(""+outReport[2].toString()+" -
			// "+outReport[3].toString());
			recModel.setPlant(outReport[4].toString());
			recModel.setSocity(outReport[5].toString());
			recModel.setFarmerCode(outReport[6].toString());
			recModel.setGrossAmount( Util.indianRupeeFormat(""+outReport[7].toString()));
			recModel.setMilkPayment(""+  Util.indianRupeeFormat(""+outReport[17].toString()));
			recModel.setpCode(outReport[18].toString());
			recModel.setcName(outReport[19].toString());

			if (!outReport[8].toString().equals("0.00")) {
				recModel.setDeductions("-" +  Util.indianRupeeFormat(""+outReport[8].toString()));
			} else {
				recModel.setDeductions("" + outReport[8].toString());
			}

			if (!outReport[9].toString().equals("0.00")) {
				recModel.setRecoveries("-" + Util.indianRupeeFormat(""+ outReport[9].toString()));
			} else {
				recModel.setRecoveries("" + outReport[9].toString());
			}

			if (!outReport[14].toString().equals("0.00")) {
				recModel.setIncentive("" +  Util.indianRupeeFormat(outReport[14].toString()));
			} else {
				recModel.setIncentive("" + outReport[14].toString());
			}
			
			recModel.setAcNo(outReport[15].toString());
			recModel.setIfcCode(outReport[16].toString());
			
			recModel.setArrears( Util.indianRupeeFormat(""+outReport[10].toString()));
			recModel.setNetAmount( Util.indianRupeeFormat(""+outReport[11].toString()));
			recModel.setActDed(outReport[12].toString());
			recModel.setFarmerName(outReport[13].toString());
			totalamount = totalamount.add(new BigDecimal(outReport[11].toString()));
			paymentAmount = paymentAmount.add(new BigDecimal(outReport[7].toString()));
			arrearAmount = arrearAmount.add(new BigDecimal(outReport[10].toString()));
			deductionAmount = deductionAmount.add(new BigDecimal(outReport[8].toString()));

			recoveryAmount = recoveryAmount.add(new BigDecimal(outReport[9].toString()));
			incentiveAmount = incentiveAmount.add(new BigDecimal(outReport[14].toString()));
			
			milkAmount = milkAmount.add(new BigDecimal(outReport[17].toString()));
			
			
			
			// totalamount+=new Double([11].toString()));

			hmbSummaryList.add(recModel);
		}

		System.out.println("totalamount.." + totalamount);
		HmbSummaryCustomModel recModel2 = new HmbSummaryCustomModel();
		recModel2.setNetAmount("" +  Util.indianRupeeFormat(""+totalamount));
		recModel2.setGrossAmount("" +  Util.indianRupeeFormat(""+paymentAmount));
		recModel2.setArrears("" +  Util.indianRupeeFormat(""+arrearAmount));
		recModel2.setIncentive("" +  Util.indianRupeeFormat(""+incentiveAmount));
		recModel2.setMilkPayment("" +  Util.indianRupeeFormat(""+milkAmount));
		
		
		if (!deductionAmount.toString().equals("0.00")) {
			recModel2.setDeductions("-" +  Util.indianRupeeFormat(""+deductionAmount));
		} else {
			recModel2.setDeductions("" + deductionAmount);

		}

		if (!recoveryAmount.toString().equals("0.00")) {
			recModel2.setRecoveries("-" +  Util.indianRupeeFormat(""+recoveryAmount));
		} else {
			recModel2.setRecoveries("" + recoveryAmount);

		}

		hmbSummaryList.add(recModel2);

		JqgridResponse<HmbSummaryCustomModel> dataGrid = new JqgridResponse<HmbSummaryCustomModel>(hmbSummaryList);
		return dataGrid;
	}

	@RequestMapping("/getHmbDetails")
	public @ResponseBody JqgridResponse getHmbDetails(@RequestParam(value = "plant") String plant,
			@RequestParam(value = "socity") String socity, @RequestParam(value = "billNumber") String billNumber,
			HttpServletRequest request) throws ParseException {

		String companyCode = (String) request.getSession().getAttribute("companyCode");

		List<HmbDetailsCustomModel> HmbDetailsList = new ArrayList<HmbDetailsCustomModel>();

		List<Object[]> hmbPaymentDetails = hmpDao.getHmpPaymentDetails(companyCode, plant, socity, billNumber);

		int count = 0;
		BigDecimal totalamount = new BigDecimal(0);
		BigDecimal artotalamount = new BigDecimal("0.00");
		
		BigDecimal dectotalamount = new BigDecimal("0.00");
		BigDecimal rectotalamount = new BigDecimal(0);
		
		BigDecimal qtyTotalamount = new BigDecimal(0);
		
		BigDecimal incentiveTotalamount = new BigDecimal(0);
		
		BigDecimal	rateLtrAmount= new BigDecimal(0);
		BigDecimal	addRateLtrAmount= new BigDecimal(0);
		BigDecimal holeTotal= new BigDecimal(0);
		
		BigDecimal grandHoleTotal= new BigDecimal(0);
		

		HmbDetailsCustomModel recModelPayementHeader = new HmbDetailsCustomModel();

		recModelPayementHeader.setCompCode(companyCode);
		recModelPayementHeader.setsNo("");

		recModelPayementHeader.setParticulars("Payment");
		recModelPayementHeader.setFat("");
		recModelPayementHeader.setShift("");
		recModelPayementHeader.setQtyKg("");
		recModelPayementHeader.setSnf("");
		recModelPayementHeader.setSsDate("");
		recModelPayementHeader.setTotalAmount("");
		recModelPayementHeader.setIncentiveAmount("");
		
		recModelPayementHeader.setMilkType("");
		recModelPayementHeader.setRateLtrAmount("");
		recModelPayementHeader.setAddRateLtrAmount("");
		recModelPayementHeader.setHoleTotal("");

		HmbDetailsList.add(recModelPayementHeader);

		for (Object[] outReport : hmbPaymentDetails) {

			HmbDetailsCustomModel recModel = new HmbDetailsCustomModel();

			count++;
			recModel.setCompCode(companyCode);
			recModel.setsNo("" + count);
			recModel.setParticulars("Milk Payment");
			recModel.setTotalAmount( Util.indianRupeeFormat(""+outReport[0].toString()));
			recModel.setFat(outReport[2].toString());
		
			recModel.setQtyKg(outReport[1].toString());
			recModel.setShift(outReport[6].toString());
			recModel.setSnf(outReport[3].toString());
			recModel.setSsDate(outReport[5].toString());
		
			
			if(outReport[7]!=null) {
			recModel.setIncentiveAmount(Util.indianRupeeFormat(""+outReport[7].toString()));
			incentiveTotalamount=incentiveTotalamount.add(new BigDecimal(outReport[7].toString()));
			}else {
				
				recModel.setIncentiveAmount("0.00");
			}

			qtyTotalamount=	qtyTotalamount.add(new BigDecimal(outReport[1].toString()));
			totalamount = totalamount.add(new BigDecimal(outReport[0].toString()));
			
			//...... amount/qty
			
			rateLtrAmount=(new BigDecimal(outReport[0].toString())).divide(new BigDecimal(outReport[1].toString()), 2, RoundingMode.HALF_UP);
//			rateLtrAmount=rateLtrAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			
			/////............ ( Incentive Amount + amount ) /Qty
			
			if(outReport[7]!=null) {
			addRateLtrAmount=(new BigDecimal(outReport[7].toString())).add(new BigDecimal(outReport[0].toString())).divide(new BigDecimal(outReport[1].toString()), 2, RoundingMode.HALF_UP);
			}else {
				addRateLtrAmount=(new BigDecimal(0)).add(new BigDecimal(outReport[0].toString())).divide(new BigDecimal(outReport[1].toString()), 2, RoundingMode.HALF_UP);
				
			}
		//	addRateLtrAmount=addRateLtrAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			
			/////////.............. Additional Rate/Ltr *  Qty
			
			
			holeTotal=addRateLtrAmount.multiply(new BigDecimal(outReport[1].toString()));
			holeTotal=holeTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			if(outReport[8].toString().equals("M")) {
				
				recModel.setMilkType("Mixed");
				
			}else if(outReport[8].toString().equals("C")){
				
				recModel.setMilkType("Cow");
				
			}else if(outReport[8].toString().equals("B")) {
				recModel.setMilkType("Buffalo");
				
			}else {
				
				recModel.setMilkType(outReport[8].toString());
			}
			
		//	recModel.setMilkType(outReport[8].toString());
			
			
			
			recModel.setRateLtrAmount("" +  Util.indianRupeeFormat(""+rateLtrAmount));
			recModel.setAddRateLtrAmount("" +  Util.indianRupeeFormat(""+addRateLtrAmount));
			recModel.setHoleTotal("" +  Util.indianRupeeFormat(""+holeTotal));
			
			grandHoleTotal = grandHoleTotal.add(holeTotal);
			
			HmbDetailsList.add(recModel);	
		}

		List<Object[]> hmbArrearDetails = hmpDao.getHmpArrearDetails(companyCode, plant, socity, billNumber);

		for (Object[] outReport : hmbArrearDetails) {

			HmbDetailsCustomModel recModel = new HmbDetailsCustomModel();

			recModel.setCompCode(companyCode);
			recModel.setsNo("" + count);
			recModel.setParticulars(outReport[0].toString());
			recModel.setTotalAmount( Util.indianRupeeFormat(""+outReport[1].toString()));
			recModel.setFat("");
			recModel.setShift("");
			recModel.setQtyKg("");
			recModel.setSnf("");
			recModel.setIncentiveAmount("");
			recModel.setSsDate(""+outReport[2].toString());
			recModel.setMilkType("");
			recModel.setRateLtrAmount("");
			recModel.setAddRateLtrAmount("");
			recModel.setHoleTotal(Util.indianRupeeFormat(""+outReport[1].toString()));

			
			
			artotalamount = artotalamount.add(new BigDecimal(outReport[1].toString()));
			totalamount = totalamount.add(new BigDecimal(outReport[1].toString()));

			HmbDetailsList.add(recModel);
		}

		System.out.println("artotalamount.." + totalamount);
		HmbDetailsCustomModel recModel2 = new HmbDetailsCustomModel();
		recModel2.setTotalAmount("" +  Util.indianRupeeFormat(""+totalamount));
		recModel2.setQtyKg("" +  Util.indianRupeeFormat(""+qtyTotalamount));
		recModel2.setIncentiveAmount("" +  Util.indianRupeeFormat(""+incentiveTotalamount));
		recModel2.setHoleTotal("" +  Util.indianRupeeFormat(""+grandHoleTotal));
		
		recModel2.setMilkType("");
		recModel2.setRateLtrAmount("");
		recModel2.setAddRateLtrAmount("");
		

		HmbDetailsList.add(recModel2);
		
		
		
		
		List<Object[]> hmbDeductionDetailsSd = hmpDao.getHmpDeductionSdDetails(companyCode, plant, socity, billNumber);
		
		
		if(hmbDeductionDetailsSd.size()>0){
			HmbDetailsCustomModel recModelPayementHeadersd = new HmbDetailsCustomModel();

			recModelPayementHeadersd.setCompCode(companyCode);
			recModelPayementHeadersd.setsNo("");

			recModelPayementHeadersd.setParticulars("Deductions");
			recModelPayementHeadersd.setFat("");
			recModelPayementHeadersd.setShift("");
			recModelPayementHeadersd.setQtyKg("");
			recModelPayementHeadersd.setSnf("");
			recModelPayementHeadersd.setSsDate("");
			recModelPayementHeadersd.setTotalAmount("");
			recModelPayementHeadersd.setIncentiveAmount("");
			
			recModelPayementHeadersd.setMilkType("");
			recModelPayementHeadersd.setRateLtrAmount("");
			recModelPayementHeadersd.setAddRateLtrAmount("");
			recModelPayementHeadersd.setHoleTotal("");
			HmbDetailsList.add(recModelPayementHeadersd);

			
		}

		for (Object[] outReport : hmbDeductionDetailsSd) {

			HmbDetailsCustomModel recModel = new HmbDetailsCustomModel();

			count++;
			recModel.setCompCode(companyCode);
			recModel.setsNo("" + count);
			recModel.setParticulars("" + outReport[0].toString());
			recModel.setFat("");
			recModel.setShift("");
			recModel.setQtyKg("");
			recModel.setSnf("");
			recModel.setIncentiveAmount("");
			
			recModel.setMilkType("");
			recModel.setRateLtrAmount("");
			recModel.setAddRateLtrAmount("");
			//recModel.setHoleTotal("");
			
			recModel.setSsDate("" + outReport[2].toString());
			if (!outReport[1].toString().equals("0.00")) {
				recModel.setHoleTotal("-" +  Util.indianRupeeFormat(""+outReport[1].toString()));
			} else {
				recModel.setHoleTotal("" + outReport[1].toString());

			}

			dectotalamount = dectotalamount.add(new BigDecimal(outReport[1].toString()));

			HmbDetailsList.add(recModel);
		}
		
		
		
		
		List<Object[]> hmbPaymentDetail = hmpDao.getHmpDeductionDetails(companyCode, plant, socity, billNumber);
		



		int count1 = 0;
		BigDecimal totalamountd = new BigDecimal(0);

		for (Object[] outReport : hmbPaymentDetail) {

			HmbDetailsCustomModel recModel = new HmbDetailsCustomModel();

			count++;
			recModel.setCompCode(companyCode);
			recModel.setsNo("" + count);
			recModel.setParticulars("" + outReport[0].toString());
			recModel.setFat("");
			recModel.setShift("");
			recModel.setQtyKg("");
			recModel.setSnf("");
			recModel.setIncentiveAmount("");
			
			recModel.setMilkType("");
			recModel.setRateLtrAmount("");
			recModel.setAddRateLtrAmount("");
			//recModel.setHoleTotal("");
			
			recModel.setSsDate(""+outReport[2].toString());
			if (!outReport[1].toString().equals("0.00")) {
				recModel.setHoleTotal("-" + Util.indianRupeeFormat(""+ outReport[1].toString()));
			} else {
				recModel.setHoleTotal("" + outReport[1].toString());

			}

			dectotalamount = dectotalamount.add(new BigDecimal(outReport[1].toString()));

			HmbDetailsList.add(recModel);
		}

//		
//		for (Object[] outReport : hmbPaymentDetailsd) {
//
//			HmbDetailsCustomModel recModel = new HmbDetailsCustomModel();
//
//			count++;
//			recModel.setCompCode(companyCode);
//			recModel.setsNo("" + count);
//			recModel.setParticulars("" + outReport[0].toString());
//			recModel.setFat("");
//			recModel.setShift("");
//			recModel.setQtyKg("");
//			recModel.setSnf("");
//			recModel.setSsDate("");
//			if (!outReport[1].toString().equals("0.00")) {
//				recModel.setTotalAmount("-" +  Util.indianRupeeFormat(""+outReport[1].toString()));
//			} else {
//				recModel.setTotalAmount("" + outReport[1].toString());
//
//			}
//
//			dectotalamount = dectotalamount.add(new BigDecimal(outReport[1].toString()));
//
//			HmbDetailsList.add(recModel);
//		}

		System.out.println("dectotalamount.." + dectotalamount);
		HmbDetailsCustomModel recModel2d = new HmbDetailsCustomModel();
		recModel2d.setHoleTotal("-" +  Util.indianRupeeFormat(""+dectotalamount));
		recModel2d.setQtyKg("");
		
		recModel2d.setMilkType("");
		recModel2d.setRateLtrAmount("");
		recModel2d.setAddRateLtrAmount("");
	//	recModel2d.setHoleTotal("");
		
		HmbDetailsList.add(recModel2d);
		
		
		
		List<Object[]> hmbPaymentDetailsrec = hmpDao.getHmpRecoveryDetails(companyCode, plant, socity, billNumber);
		
		if(hmbPaymentDetailsrec.size()>0){
			HmbDetailsCustomModel recModelPayementHeadersre = new HmbDetailsCustomModel();

			recModelPayementHeadersre.setCompCode(companyCode);
			recModelPayementHeadersre.setsNo("");
			recModelPayementHeadersre.setIncentiveAmount("");
			recModelPayementHeadersre.setParticulars("Recovery");
			recModelPayementHeadersre.setFat("");
			recModelPayementHeadersre.setShift("");
			recModelPayementHeadersre.setQtyKg("");
			recModelPayementHeadersre.setSnf("");
			recModelPayementHeadersre.setSsDate("");
			recModelPayementHeadersre.setTotalAmount("");
			
			recModelPayementHeadersre.setMilkType("");
			recModelPayementHeadersre.setRateLtrAmount("");
			recModelPayementHeadersre.setAddRateLtrAmount("");
			recModelPayementHeadersre.setHoleTotal("");
			HmbDetailsList.add(recModelPayementHeadersre);

			
		}

		int count2 = 0;
		BigDecimal totalamountre = new BigDecimal(0);

		for (Object[] outReport : hmbPaymentDetailsrec) {

			HmbDetailsCustomModel recModel = new HmbDetailsCustomModel();

			count++;
			recModel.setCompCode(companyCode);
			recModel.setsNo("" + count);
			recModel.setParticulars("" + outReport[0].toString());
			recModel.setFat("");
			recModel.setShift("");
			recModel.setQtyKg("");
			recModel.setSnf("");
			recModel.setIncentiveAmount("");
			recModel.setMilkType("");
			recModel.setRateLtrAmount("");
			recModel.setAddRateLtrAmount("");
			//recModel.setHoleTotal("");
			
			recModel.setSsDate("" + outReport[2].toString());
			if (!outReport[1].toString().equals("0.00")) {
				recModel.setHoleTotal("-" +  Util.indianRupeeFormat(""+outReport[1].toString()));
			} else {
				recModel.setHoleTotal("" + outReport[1].toString());

			}

			rectotalamount = rectotalamount.add(new BigDecimal(outReport[1].toString()));

			HmbDetailsList.add(recModel);
		}

		System.out.println("rectotalamount.." +  Util.indianRupeeFormat(""+rectotalamount));
		HmbDetailsCustomModel recModel2r = new HmbDetailsCustomModel();
		recModel2r.setTotalAmount("-" + rectotalamount);
		recModel2r.setHoleTotal("-" + rectotalamount);
		recModel2r.setQtyKg("");
		HmbDetailsList.add(recModel2r);
		
		
		///////////////// total amount
		
		
		BigDecimal netTotal=new BigDecimal(0);
		
		HmbDetailsCustomModel recModelPayementHeadersre = new HmbDetailsCustomModel();
		
					recModelPayementHeadersre.setCompCode(companyCode);
					recModelPayementHeadersre.setsNo("");
		
					recModelPayementHeadersre.setParticulars("Total");
					
					
					/// ..... total ltrs
					recModelPayementHeadersre.setRateLtrAmount("" +  Util.indianRupeeFormat(""+qtyTotalamount));
					
					
				////...... total amount
					recModelPayementHeadersre.setTotalAmount("" +  Util.indianRupeeFormat(""+grandHoleTotal));
					
					//////.......... total deduction
					
					
					
					recModelPayementHeadersre.setIncentiveAmount("" +  Util.indianRupeeFormat(""+dectotalamount));
					
					////////////...... total arrear
					
					recModelPayementHeadersre.setAddRateLtrAmount("" +  Util.indianRupeeFormat(""+artotalamount)); 
					
					////////////...... net amount
					netTotal=grandHoleTotal.add(artotalamount).subtract(dectotalamount);
					
					
					recModelPayementHeadersre.setHoleTotal("" +  Util.indianRupeeFormat(""+netTotal));
					
					
					HmbDetailsList.add(recModelPayementHeadersre);
		
		
		//////////////// HMB Incentive Start
		
//		
//List<Object[]> hmbPaymentIncentive = hmpDao.getHmpIncentiveDetails(companyCode, plant, socity, billNumber,"2017-11-01");
//		
//		if(hmbPaymentIncentive.size()>0){
//			HmbDetailsCustomModel recModelPayementHeadersre = new HmbDetailsCustomModel();
//
//			recModelPayementHeadersre.setCompCode(companyCode);
//			recModelPayementHeadersre.setsNo("");
//
//			recModelPayementHeadersre.setParticulars("Incentive");
//			recModelPayementHeadersre.setFat("");
//			recModelPayementHeadersre.setShift("");
//			recModelPayementHeadersre.setQtyKg("");
//			recModelPayementHeadersre.setSnf("");
//			recModelPayementHeadersre.setSsDate("");
//			recModelPayementHeadersre.setTotalAmount("");
//			recModelPayementHeadersre.setIncentiveAmount("");
//			HmbDetailsList.add(recModelPayementHeadersre);
//
//			
//		}
//
//	
//		BigDecimal incentiveTotalAmount = new BigDecimal(0);
//
//		for (Object[] outReport : hmbPaymentIncentive) {
//
//			HmbDetailsCustomModel recModel = new HmbDetailsCustomModel();
//
////			count++;
//			recModel.setCompCode(companyCode);
//			recModel.setsNo("" + count);
//			recModel.setParticulars("" + outReport[1].toString());
//			recModel.setFat("");
//			recModel.setShift("");
//			recModel.setQtyKg("");
//			recModel.setSnf("");
//			recModel.setIncentiveAmount("");
//			recModel.setSsDate("" + outReport[0].toString());
//			if (!outReport[2].toString().equals("0.00")) {
//				recModel.setTotalAmount("" +  Util.indianRupeeFormat(""+outReport[2].toString()));
//			} else {
//				recModel.setTotalAmount("" + outReport[2].toString());
//
//			}
//
//			incentiveTotalAmount = incentiveTotalAmount.add(new BigDecimal(outReport[2].toString()));
//
//			HmbDetailsList.add(recModel);
//		}
//
//		System.out.println("incentive total.." +  Util.indianRupeeFormat(""+rectotalamount));
//		HmbDetailsCustomModel recModelIncentive = new HmbDetailsCustomModel();
//		recModelIncentive.setTotalAmount("" + incentiveTotalAmount);
//		recModelIncentive.setQtyKg("");
//		HmbDetailsList.add(recModelIncentive);
//		
//		
		
		
		
		
		
		
		

		JqgridResponse<HmbDetailsCustomModel> dataGrid = new JqgridResponse<HmbDetailsCustomModel>(HmbDetailsList);
		return dataGrid;
	}

	@RequestMapping("/getHmbDeduction")
	public @ResponseBody JqgridResponse getHmbDeduction(@RequestParam(value = "plant") String plant,
			@RequestParam(value = "socity") String socity, @RequestParam(value = "billNumber") String billNumber,
			HttpServletRequest request) throws ParseException {

		String companyCode = (String) request.getSession().getAttribute("companyCode");

		List<HmbDetailsCustomModel> HmbDetailsList = new ArrayList<HmbDetailsCustomModel>();

		List<Object[]> hmbPaymentDetails = hmpDao.getHmpDeductionDetails(companyCode, plant, socity, billNumber);

		int count = 0;
		BigDecimal totalamount = new BigDecimal(0);

		for (Object[] outReport : hmbPaymentDetails) {

			HmbDetailsCustomModel recModel = new HmbDetailsCustomModel();

			count++;
			recModel.setCompCode(companyCode);
			recModel.setsNo("" + count);
			recModel.setParticulars("" + outReport[0].toString());
			recModel.setFat("");
			recModel.setShift("");
			recModel.setQtyKg("");
			recModel.setSnf("");
			recModel.setSsDate("");
			if (!outReport[1].toString().equals("0.00")) {
				recModel.setTotalAmount("-" + Util.indianRupeeFormat(""+ outReport[1].toString()));
			} else {
				recModel.setTotalAmount("" + outReport[1].toString());

			}

			totalamount = totalamount.add(new BigDecimal(outReport[1].toString()));

			HmbDetailsList.add(recModel);
		}

		List<Object[]> hmbDeductionDetails = hmpDao.getHmpDeductionSdDetails(companyCode, plant, socity, billNumber);

		for (Object[] outReport : hmbDeductionDetails) {

			HmbDetailsCustomModel recModel = new HmbDetailsCustomModel();

			count++;
			recModel.setCompCode(companyCode);
			recModel.setsNo("" + count);
			recModel.setParticulars("" + outReport[0].toString());
			recModel.setFat("");
			recModel.setShift("");
			recModel.setQtyKg("");
			recModel.setSnf("");
			recModel.setSsDate("");
			if (!outReport[1].toString().equals("0.00")) {
				recModel.setTotalAmount("-" +  Util.indianRupeeFormat(""+outReport[1].toString()));
			} else {
				recModel.setTotalAmount("" + outReport[1].toString());

			}

			totalamount = totalamount.add(new BigDecimal(outReport[1].toString()));

			HmbDetailsList.add(recModel);
		}

		System.out.println("totalamount.." + totalamount);
		HmbDetailsCustomModel recModel2 = new HmbDetailsCustomModel();
		recModel2.setTotalAmount("-" +  Util.indianRupeeFormat(""+totalamount));

		HmbDetailsList.add(recModel2);

		JqgridResponse<HmbDetailsCustomModel> dataGrid = new JqgridResponse<HmbDetailsCustomModel>(HmbDetailsList);
		return dataGrid;
	}

	@RequestMapping("/getHmbRecovery")
	public @ResponseBody JqgridResponse getHmbRecovery(@RequestParam(value = "plant") String plant,
			@RequestParam(value = "socity") String socity, @RequestParam(value = "billNumber") String billNumber,
			HttpServletRequest request) throws ParseException {

		String companyCode = (String) request.getSession().getAttribute("companyCode");

		List<HmbDetailsCustomModel> HmbDetailsList = new ArrayList<HmbDetailsCustomModel>();

		List<Object[]> hmbPaymentDetails = hmpDao.getHmpRecoveryDetails(companyCode, plant, socity, billNumber);

		int count = 0;
		BigDecimal totalamount = new BigDecimal(0);

		for (Object[] outReport : hmbPaymentDetails) {

			HmbDetailsCustomModel recModel = new HmbDetailsCustomModel();

			count++;
			recModel.setCompCode(companyCode);
			recModel.setsNo("" + count);
			recModel.setParticulars("" + outReport[0].toString());
			recModel.setFat("");
			recModel.setShift("");
			recModel.setQtyKg("");
			recModel.setSnf("");
			recModel.setSsDate("");
			if (!outReport[1].toString().equals("0.00")) {
				recModel.setTotalAmount("-" +  Util.indianRupeeFormat(""+outReport[1].toString()));
			} else {
				recModel.setTotalAmount("" + outReport[1].toString());

			}

			totalamount = totalamount.add(new BigDecimal(outReport[1].toString()));

			HmbDetailsList.add(recModel);
		}

		System.out.println("totalamount.." +  Util.indianRupeeFormat(""+totalamount));
		HmbDetailsCustomModel recModel2 = new HmbDetailsCustomModel();
		recModel2.setTotalAmount("-" + totalamount);

		HmbDetailsList.add(recModel2);

		JqgridResponse<HmbDetailsCustomModel> dataGrid = new JqgridResponse<HmbDetailsCustomModel>(HmbDetailsList);
		return dataGrid;
	}
	
	
	
	
	@RequestMapping("/getEkoMaterialStock")
	public @ResponseBody JqgridResponse getEkoMaterialStock(HttpServletRequest request) throws ParseException {

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");
		
		String accountGroup = (String) request.getSession().getAttribute("accountGroup");
		
		if(accountGroup.equals("BLVN")) {
			
			 socity = (String) request.getSession().getAttribute("userId");
			
		}else {
			
			 socity = (String) request.getSession().getAttribute("society");
		}
		
		

		List<EkoMaterialStockCustomModel> materialStockList = new ArrayList<EkoMaterialStockCustomModel>();

		List<Object[]> materialStocks = hmpDao.getEkoMaterialStock(socity);

		for (Object[] outReport : materialStocks) {

			EkoMaterialStockCustomModel ekoMaterialStock = new EkoMaterialStockCustomModel();
			ekoMaterialStock.setPlant(outReport[0].toString());
			ekoMaterialStock.setEquipment(outReport[1].toString());
			ekoMaterialStock.setRoomNumber(outReport[2].toString());
			ekoMaterialStock.setEquipmentDescription(outReport[3].toString());
			ekoMaterialStock.setInventoryNumber(outReport[4].toString());
			materialStockList.add(ekoMaterialStock);
		}

		JqgridResponse<EkoMaterialStockCustomModel> dataGrid = new JqgridResponse<EkoMaterialStockCustomModel>(
				materialStockList);
		return dataGrid;
	}
	
	
	

	@RequestMapping("/getMaterialStock")
	public @ResponseBody JqgridResponse getMaterialStock(HttpServletRequest request) throws ParseException {

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");
		
		String accountGroup = (String) request.getSession().getAttribute("accountGroup");
		
		if(accountGroup.equals("BLVN")) {
			
			 socity = (String) request.getSession().getAttribute("userId");
			
		}else {
			
			 socity = (String) request.getSession().getAttribute("society");
		}
		
		

		List<MaterialStockCustomModel> materialStockList = new ArrayList<MaterialStockCustomModel>();

		List<Object[]> materialStocks = hmpDao.getMaterialStock(companyCode, socity);

		for (Object[] outReport : materialStocks) {

			MaterialStockCustomModel recModel = new MaterialStockCustomModel();

			recModel.setCompCode(companyCode);
			recModel.setMaterialCode(outReport[0].toString());
			recModel.setMaterialName(outReport[1].toString());
			recModel.setQuantity(outReport[2].toString());

			materialStockList.add(recModel);
		}

		JqgridResponse<MaterialStockCustomModel> dataGrid = new JqgridResponse<MaterialStockCustomModel>(
				materialStockList);
		return dataGrid;
	}

	@RequestMapping("/getAverageMilkMonthWise")
	public @ResponseBody JqgridResponse getAverageMilkMonthWise(
			@RequestParam(value = "selectedYear") String selectedYear, HttpServletRequest request)
			throws ParseException {

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");

		List<AverageMilkMonthCustomModel> avgMilkMonthList = new ArrayList<AverageMilkMonthCustomModel>();

		List<Object[]> avgMilkMonth = hmpDao.getAvgMilkMonth(companyCode, socity, selectedYear,userId);

		for (Object[] outReport : avgMilkMonth) {

			AverageMilkMonthCustomModel recModel = new AverageMilkMonthCustomModel();

			recModel.setCompCode(companyCode);
			
			recModel.setAvgmonth(Util.getMonthDescByYear(Integer.parseInt(outReport[0].toString())));
			recModel.setAvgMilk(Util.getAvgByTwoString(outReport[1].toString(), outReport[6].toString()));
			recModel.setAvgFat(Util.getAvgByTwoString(outReport[2].toString(), outReport[6].toString()));
			recModel.setAvgSnf(Util.getAvgByTwoString(outReport[3].toString(), outReport[6].toString()));
			

//			recModel.setAvgmonth(Util.getMonthDescByYear(Integer.parseInt(outReport[0].toString())));
//			recModel.setAvgMilk(Util.getAvgByTwoString(outReport[1].toString(), outReport[3].toString()));
//			
//			
//	//....................		KG Quantity * fat/100
//			
			BigDecimal avgFat=new BigDecimal(0);
			BigDecimal avgSNf=new BigDecimal(0);
			
			
	
			
			avgFat=new BigDecimal(Util.getAvgByTwoString1(outReport[2].toString(), outReport[7].toString())).multiply(new BigDecimal(100));
			avgSNf=new BigDecimal(Util.getAvgByTwoString1(outReport[3].toString(), outReport[7].toString())).multiply(new BigDecimal(100));
			
			avgFat=avgFat.setScale(2, RoundingMode.FLOOR);
			avgSNf=avgSNf.setScale(2, RoundingMode.FLOOR);
			
			recModel.setAvgFat(""+avgFat);
			recModel.setAvgSnf(""+avgSNf);
			
//			recModel.setAvgFat(Util.getAvgByTwoString(outReport[2].toString(), outReport[6].toString()));
//			recModel.setAvgSnf(Util.getAvgByTwoString(outReport[3].toString(), outReport[6].toString()));
//			
			recModel.setSelectedMonth(outReport[0].toString());
			recModel.setSelectedyear(outReport[4].toString());
			recModel.setSocity(outReport[5].toString());
			

			avgMilkMonthList.add(recModel);
		}

		JqgridResponse<AverageMilkMonthCustomModel> dataGrid = new JqgridResponse<AverageMilkMonthCustomModel>(
				avgMilkMonthList);
		
		System.out.println("dataGrid.."+dataGrid.toString());
		return dataGrid;
	}
	
	
	@RequestMapping("/getAverageMilkMonthWiseLi")
	public @ResponseBody JqgridResponse getAverageMilkMonthWiseLi(
			@RequestParam(value = "socity") String socity,
			@RequestParam(value = "selectedYear") String selectedYear,
			@RequestParam(value = "selectedMonth") String selectedMonth,HttpServletRequest request)
			throws ParseException {

		

		List<AverageMilkMonthLiCustomModel> avgMilkMonthList = new ArrayList<AverageMilkMonthLiCustomModel>();

		List<Object[]> avgMilkMonth = hmpDao.getAvgMilkMonthLi(socity, selectedYear, selectedMonth);
		BigDecimal qtyTotal = new BigDecimal(0);
		BigDecimal qtyFat = new BigDecimal(0);
		BigDecimal qtySnf = new BigDecimal(0);
		

		for (Object[] outReport : avgMilkMonth) {

			AverageMilkMonthLiCustomModel recModel = new AverageMilkMonthLiCustomModel();
			
			recModel.setSsDate(outReport[0].toString());
			recModel.setShift(outReport[1].toString());
			recModel.setMilktype(outReport[1].toString());
			recModel.setQty(outReport[2].toString());
			recModel.setFat(outReport[3].toString());
			recModel.setSnf(outReport[4].toString());
			

			qtyTotal = qtyTotal.add(new BigDecimal(outReport[2].toString()));
			qtyFat = qtyFat.add(new BigDecimal(outReport[3].toString()));
			qtySnf = qtySnf.add(new BigDecimal(outReport[4].toString()));
			
			

			avgMilkMonthList.add(recModel);
		}
		
		if(avgMilkMonth.size()>0) {
	AverageMilkMonthLiCustomModel recModel = new AverageMilkMonthLiCustomModel();
			
			recModel.setSsDate("");
			recModel.setShift("");
			recModel.setMilktype("TOTAL");
			recModel.setQty(""+qtyTotal);
			recModel.setFat(""+qtyFat);
			recModel.setSnf(""+qtySnf);
			avgMilkMonthList.add(recModel);
			
			
			
		}
		
		

		JqgridResponse<AverageMilkMonthLiCustomModel> dataGrid = new JqgridResponse<AverageMilkMonthLiCustomModel>(
				avgMilkMonthList);
		return dataGrid;
	}
	

}
