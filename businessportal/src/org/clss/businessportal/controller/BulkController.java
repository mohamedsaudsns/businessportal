package org.clss.businessportal.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import org.clss.businessportal.custommodel.HmbDetailsCustomModel;
import org.clss.businessportal.custommodel.HmbServiceChargeCustomModel;
import org.clss.businessportal.custommodel.HmbSummaryCustomModel;
import org.clss.businessportal.custommodel.JqgridResponse;
import org.clss.businessportal.custommodel.ProductByDepartmentCustomModel;
import org.clss.businessportal.dao.AdminDao;
import org.clss.businessportal.dao.CfaDao;
import org.clss.businessportal.dao.DepartmentDao;
import org.clss.businessportal.dao.HmbDao;
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
public class BulkController {

	@Autowired
	private HmbDao hmpDao;

	
	@RequestMapping("/getBulkHmbSummary")
	public @ResponseBody JqgridResponse getBulkHmbSummary(@RequestParam(value = "selected_month") String selected_month,
			HttpServletRequest request) throws ParseException {

		System.out.println("selected_month.." + selected_month);

		String companyCode = (String) request.getSession().getAttribute("companyCode");
		String userId = (String) request.getSession().getAttribute("userId");

		String socity = (String) request.getSession().getAttribute("society");

		String todate = Util.convertmonthYearToMonthEndDay(selected_month);
		String fromdate = "" + Util.convertFullMonthToMonthNo(selected_month) + "-01";
		List<HmbSummaryCustomModel> hmbSummaryList = new ArrayList<HmbSummaryCustomModel>();

		List<Object[]> hmbSummary = hmpDao.getBulkHmpSummary(companyCode, userId, userId, fromdate, todate);

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

	@RequestMapping("/getBulkHmbDetails")
	public @ResponseBody JqgridResponse getHmbDetails(@RequestParam(value = "plant") String plant,
			@RequestParam(value = "socity") String socity, @RequestParam(value = "billNumber") String billNumber,
			HttpServletRequest request) throws ParseException {

		String companyCode = (String) request.getSession().getAttribute("companyCode");

		List<HmbDetailsCustomModel> HmbDetailsList = new ArrayList<HmbDetailsCustomModel>();

		List<Object[]> hmbPaymentDetails = hmpDao.getBulkHmpPaymentDetails(companyCode, plant, socity, billNumber);

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
		

		
		
		
		
		
		
		

		JqgridResponse<HmbDetailsCustomModel> dataGrid = new JqgridResponse<HmbDetailsCustomModel>(HmbDetailsList);
		return dataGrid;
	}


}
