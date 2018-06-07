package org.clss.businessportal.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.clss.businessportal.custommodel.FiledStaffCustomModel;
import org.clss.businessportal.custommodel.HmbServiceChargeCustomModel;
import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.MilkSnfCompareCustomModel;
import org.clss.businessportal.custommodel.TsRecoveryCustomModel;
import org.clss.businessportal.dao.FieldStaffDao;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FieldStaffController {

	@Autowired
	private FieldStaffDao fieldStaffDao;

	
	@RequestMapping("/getCcHmbCompareReport")
	public @ResponseBody JqgridResponse getCcHmbCompareReport(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,
			HttpServletRequest request) throws ParseException {

		System.out.println("selected_date.."+selected_date);
		


		String companyCode = (String) request.getSession().getAttribute("companyCode");	
		String userId = (String) request.getSession().getAttribute("userId");
		
		
		
		 Date selected_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_date);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate = formatter.format(selected_date_for);
		 
		 
		 Date selected_to_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_to_date);
		 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate_to = formatter1.format(selected_to_date_for);

		List<Object[]> getOutstandingReport = fieldStaffDao.getCcHmbCompareReport(
				String.valueOf(userId),
				"" + parsedDate,	""+parsedDate_to);

		List<FiledStaffCustomModel> rCustomModel = new ArrayList<FiledStaffCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			FiledStaffCustomModel recModel = new FiledStaffCustomModel();
			recModel.setPlantCode(outReport[0].toString());
			recModel.setPlantName(outReport[1].toString());
			recModel.setSocity(outReport[2].toString());
			recModel.setSocityName(outReport[3].toString());
			recModel.setEntryDate(outReport[4].toString());
			recModel.setShiftName(outReport[5].toString());
			recModel.setHmbQty(outReport[6].toString());
			recModel.setReceptionQty(outReport[7].toString());
			recModel.setDifferent(outReport[8].toString());
			

			

			rCustomModel.add(recModel);
		}

		
		JqgridResponse<FiledStaffCustomModel> dataGrid = new JqgridResponse<FiledStaffCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	
	
	@RequestMapping("/getComparisionStatementReport")
	public @ResponseBody JqgridResponse getComparisionStatementReport(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,
			HttpServletRequest request) throws ParseException {

		System.out.println("selected_date.."+selected_date);
		


		String companyCode = (String) request.getSession().getAttribute("companyCode");	
		String userId = (String) request.getSession().getAttribute("userId");
		
		
		
		 Date selected_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_date);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate = formatter.format(selected_date_for);
		 
		 
		 Date selected_to_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_to_date);
		 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate_to = formatter1.format(selected_to_date_for);

		List<Object[]> getOutstandingReport = fieldStaffDao.getComparisionStatementReport(
				String.valueOf(userId),
				"" + parsedDate,	""+parsedDate_to);

		List<MilkSnfCompareCustomModel> rCustomModel = new ArrayList<MilkSnfCompareCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			MilkSnfCompareCustomModel recModel = new MilkSnfCompareCustomModel();
			
			recModel.setPlant(outReport[0].toString());
			recModel.setPlantName(outReport[1].toString());
			recModel.setSociety(outReport[2].toString());
			recModel.setSocietyName(outReport[3].toString());
			recModel.setSsDate(outReport[4].toString()+" "+outReport[5].toString());
			recModel.setpName(outReport[6].toString());
			recModel.setsName(outReport[7].toString());
			recModel.setQuantity(outReport[8].toString());
			recModel.setQuantityKg(outReport[9].toString());
			recModel.setFat(outReport[10].toString());
			recModel.setSnf(outReport[11].toString());
			recModel.setCts(outReport[12].toString());
			recModel.setCkgfat(outReport[13].toString());
			recModel.setCkgsnf(outReport[14].toString());
			recModel.setErfmgLtr(outReport[15].toString());
			recModel.setFatN(outReport[16].toString());
			recModel.setSnfN(outReport[17].toString());
			recModel.setTsN(outReport[18].toString());
			recModel.setDkgfat(outReport[19].toString());
			recModel.setDkgsnf(outReport[20].toString());
			recModel.setRoute(outReport[21].toString());	
			recModel.setrName(outReport[22].toString());
			recModel.setErfmgLtrS(outReport[23].toString());
			recModel.setCkgfatS(outReport[24].toString());
			recModel.setCkgsnfS(outReport[25].toString());
			recModel.setFatS(outReport[26].toString());
			recModel.setSnfS(outReport[27].toString());
			recModel.setErfmgLtrE(outReport[28].toString());
			recModel.setCkgfatE(outReport[29].toString());
			recModel.setCkgsnfE(outReport[30].toString());
			recModel.setFatE(outReport[31].toString());
			recModel.setSnfE(outReport[32].toString());
			rCustomModel.add(recModel);
		}

		
		JqgridResponse<MilkSnfCompareCustomModel> dataGrid = new JqgridResponse<MilkSnfCompareCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	
	@RequestMapping("/getTsRecoveryReport")
	public @ResponseBody JqgridResponse getTsRecoveryReport(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,
			HttpServletRequest request) throws ParseException {

		System.out.println("selected_date.."+selected_date);
		


		String companyCode = (String) request.getSession().getAttribute("companyCode");	
		String userId = (String) request.getSession().getAttribute("userId");
		
		
		
		 Date selected_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_date);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate = formatter.format(selected_date_for);
		 
		 
		 Date selected_to_date_for = new SimpleDateFormat("dd/MM/yyyy").parse(selected_to_date);
		 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		 String parsedDate_to = formatter1.format(selected_to_date_for);

		List<Object[]> getOutstandingReport = fieldStaffDao.getTsRecoveryReport(
				String.valueOf(userId),
				"" + parsedDate,	""+parsedDate_to);

		List<TsRecoveryCustomModel> rCustomModel = new ArrayList<TsRecoveryCustomModel>();

		for (Object[] outReport : getOutstandingReport) {

			TsRecoveryCustomModel recModel = new TsRecoveryCustomModel();
			
			recModel.setPlantCode(outReport[0].toString());
			recModel.setPlantName(outReport[1].toString());
			recModel.setHmb(outReport[2].toString());
			recModel.setHmbName(outReport[3].toString());
			recModel.setSumLtCenter(outReport[4].toString());
			recModel.setSumKgFatCenter(outReport[5].toString());
			recModel.setSumKgSnfCenter(outReport[6].toString());
			recModel.setSumLtScan(outReport[7].toString());
			recModel.setSumKgFatScan(outReport[8].toString());
			recModel.setSumKgSnfScan(outReport[9].toString());
			recModel.setDiffLt(outReport[10].toString());
			recModel.setDiffPer(outReport[11].toString());
			recModel.setDiffSumKgFat(outReport[12].toString());
			recModel.setDiffSumKgSnf(outReport[13].toString());
			recModel.setTotalSolid(outReport[14].toString());
			recModel.setAmtDiffScanQtyLtr(outReport[15].toString());	
			recModel.setTotalSolidAmt(outReport[16].toString());
			recModel.setTotalTs(outReport[17].toString());
			recModel.setSamMilk(outReport[18].toString());
			recModel.setFmilkShAmt(outReport[19].toString());
			recModel.setFtsShAmt(outReport[20].toString());
			recModel.setDateFrm(outReport[21].toString());
			recModel.setDateTo(outReport[22].toString());
			recModel.setRdeName(outReport[23].toString());
			recModel.setArdoccName(outReport[24].toString());
			recModel.setRdoccName(outReport[25].toString());
			
			rCustomModel.add(recModel);
		}

		
		JqgridResponse<TsRecoveryCustomModel> dataGrid = new JqgridResponse<TsRecoveryCustomModel>(rCustomModel);
		return dataGrid;
	}
public List<HmbServiceChargeCustomModel> getOldFfsPayslip(List<Object[]> hmbServiceCharges,String companyCode,String userId,String fromdate,String todate){
		
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
			
			
			
			List<Object[]> hmbServiceDeduction = fieldStaffDao.getFfsServiceChargeDeduction(userId, outReport[7].toString(), outReport[5].toString(), outReport[6].toString());
			for (Object[] outReport1 : hmbServiceDeduction) {
				Dedutiondetails+=""+outReport1[0]+"^"+outReport1[2]+"!";
				
				lineDeductionAmount = lineDeductionAmount.add(new BigDecimal(outReport1[2].toString()));

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
	
public List<HmbServiceChargeCustomModel> getNewFfsPayslip(List<Object[]> hmbServiceCharges,String companyCode,String userId,String fromdate,String todate){
	
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
		
		
		
		List<Object[]> hmbServiceDeduction = fieldStaffDao.getFfsServiceChargeDeduction(userId, outReport[7].toString(), outReport[5].toString(), outReport[6].toString());
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
		
		
		List<Object[]> hmbServiceArrear= fieldStaffDao.getFfsServiceArrear( outReport[7].toString(), outReport[5].toString(), outReport[6].toString());
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
	
	
	@RequestMapping("/getFfsServiceCharges")
	public @ResponseBody JqgridResponse getFfsServiceCharges(
			@RequestParam(value = "selected_month") String selected_month, HttpServletRequest request)
			throws ParseException {

	

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");

		String todate = Util.convertmonthYearToMonthEndDay(selected_month);
		String fromdate = "" + Util.convertFullMonthToMonthNo(selected_month) + "-01";
		List<Object[]> hmbServiceCharges = fieldStaffDao.getFfsServiceCharge(companyCode, userId, fromdate, todate);	
		
		List<HmbServiceChargeCustomModel> hmbSummaryList = null;
		
		for (Object[] outReport : hmbServiceCharges) {
			if(outReport[27].toString().equals("0.00")) {
				hmbSummaryList= getOldFfsPayslip(hmbServiceCharges,companyCode, userId, fromdate, todate);
				System.out.println("calling Old payslip");
				
			}else {
				System.out.println("calling New payslip");
				hmbSummaryList = getNewFfsPayslip(hmbServiceCharges,companyCode, userId, fromdate, todate);
			}
		}

		


		JqgridResponse<HmbServiceChargeCustomModel> dataGrid = new JqgridResponse<HmbServiceChargeCustomModel>(hmbSummaryList);
		return dataGrid;
	}




}
