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
import org.clss.businessportal.custommodel.OutstandingReportCustomModel;
import org.clss.businessportal.dao.LogisticTransHeaderDao;
import org.clss.businessportal.dao.VendorMasterDao;
import org.clss.businessportal.entity.LogisticTransHeader;
import org.clss.businessportal.entity.LogisticTransItem;
import org.clss.businessportal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class LogisticsController {
	
	@Autowired
	private LogisticTransHeaderDao logisticTransHeaderDao;
	 
	@Autowired
	private Util util;
	
	 @Autowired
		private VendorMasterDao vendorMasterDao;
	
	
	
	
	@RequestMapping("/getLogisticSecurityDepositStatus")
	public @ResponseBody JqgridResponse getLogisticSecurityDepositStatus(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,@RequestParam(value = "itemType") String itemType,
			@RequestParam(value = "dateFilterType") String dateFilterType,	
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
		 
		 
		 
		 

		List<Object[]> getOutstandingReport = vendorMasterDao.getLogisticSecurityDepositStatus(companyCode,
				String.valueOf(userId),
				"" + parsedDate,	""+parsedDate_to,itemType,dateFilterType);

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
		
			
			if(outReport[14].toString().equals("Y")) {
				
				if(outReport[7]!=null){
					recModel.setSecurityDepositAmount("" +outReport[7].toString().replace("-",""));
				}else{
					
					recModel.setSecurityDepositAmount("");
				}
				
				
			}else if(outReport[14].toString().equals("L")) {
				if(outReport[7]!=null){
					recModel.setVtrackAmount("" +outReport[7].toString().replace("-",""));
				}else{
					
					recModel.setVtrackAmount("");
				}
				
			}
			
			

			if (outReport[8].toString().equals("H")) {
				recModel.setAmount("-" +  Util.indianRupeeFormat(""+outReport[7].toString()));
				recModel.setCreditAmount("" +  Util.indianRupeeFormat(""+outReport[7].toString()));

			} else if (outReport[8].toString().equals("S")) {
				recModel.setAmount("" +  Util.indianRupeeFormat(""+outReport[7].toString()));
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
			
			if(outReport[13]!=null){
				recModel.setRemark(""+outReport[13].toString());
			}else{
				
				recModel.setRemark("");
			}
			
		
			
			if(outReport[12]!=null){
				recModel.setTdsAmount("" +  Util.indianRupeeFormat(""+outReport[12].toString()));
			}else{
				
				recModel.setTdsAmount("");
			}
			
			if(outReport[13]!=null){
				recModel.setItemText(""+outReport[13].toString());
			}else{
				
				recModel.setItemText("");
			}
			
			
			
			
			 BigDecimal rentAmountBig = new BigDecimal(outReport[7].toString().replace("-",""));
			 BigDecimal tedAmountBig = new BigDecimal(outReport[12].toString());
			 
			 BigDecimal netAmount ;
			 
			 
			
			 netAmount=rentAmountBig.subtract(tedAmountBig);
	
			recModel.setNetAmount("" +  Util.indianRupeeFormat(""+netAmount));
			
			recModel.setPaymentAmount("" +  Util.indianRupeeFormat(""+outReport[7].toString().replace("-","")));
			

			rCustomModel.add(recModel);
		}

		
		JqgridResponse<OutstandingReportCustomModel> dataGrid = new JqgridResponse<OutstandingReportCustomModel>(rCustomModel);
		return dataGrid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping("/getMonthlyVehicleDetailsReportForLogistics")
	public @ResponseBody String getMonthlyVehicleDetailsReportForLogistics(@RequestParam(value = "selected_from_date") String selected_date,@RequestParam(value = "selected_to_date") String selected_to_date,
			HttpServletRequest request) throws ParseException {
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		
		
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

		List<LogisticTransHeader> getOutstandingReport = logisticTransHeaderDao.getMonthlyVehicleDetailsReportForLogistics(companyCode,
				String.valueOf(userId),
				"" + parsedDate,	""+parsedDate_to);

		for (LogisticTransHeader outReport : getOutstandingReport) {
			JSONObject jObject = new JSONObject();
			jObject.put("routeNo", outReport.getId().getRoute());
			jObject.put("billNo", outReport.getId().getBillNum());
			jObject.put("billStrDate", outReport.getId().getBillPrdStr().toString());
			jObject.put("billEndDate", outReport.getId().getBillPrdEnd().toString());
			jObject.put("plant", outReport.getId().getPlant());
			jObject.put("vehicle", outReport.getVehicle());
			jObject.put("initAmt", util.indianRupeeFormat(outReport.getInitAmt().toString()));
			jObject.put("arrearAmt", util.indianRupeeFormat(outReport.getArrears().toString()));
			jObject.put("deductionAmt", util.indianRupeeFormat(outReport.getDeduction().toString()));
			jObject.put("grossAmt", util.indianRupeeFormat(outReport.getGrossAmt().toString()));
			jObject.put("netAmt", util.indianRupeeFormat(outReport.getNetAmt().toString()));
			jsonObjects.add(jObject);
		}
		return jsonObjects.toString();
	}

	
	@RequestMapping("/getLogisticTransItemDetails")
	public @ResponseBody String getLogisticTransItemDetails(String plant,String route,String sdate,String edate,HttpServletRequest request){
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		try{
			String companyCode = (String) request.getSession().getAttribute("companyCode");	
			String userId = (String) request.getSession().getAttribute("userId");
			List<LogisticTransItem> datas = logisticTransHeaderDao.getTransItems(companyCode, userId, plant, route, sdate, edate);
			
			/*-------Item Details----------*/
			double km=0.00,hire=0.00;
			for (LogisticTransItem logisticTransItem : datas) {
				JSONObject jObject = new JSONObject();
				jObject.put("title", "PaymentSummary");
				jObject.put("plant", logisticTransItem.getId().getWerks());
				jObject.put("plantName", logisticTransItem.getName());
				jObject.put("route", logisticTransItem.getId().getRouteNo());
				jObject.put("routeName", logisticTransItem.getRouteDescr());
				jObject.put("vehicleModel", logisticTransItem.getTransType());
				jObject.put("bdate", logisticTransItem.getId().getCrdat().toString());
				jObject.put("km", util.indianRupeeFormat(logisticTransItem.getSoDis().toEngineeringString()));
				jObject.put("fixed", util.indianRupeeFormat(logisticTransItem.getFixedKmRate().toString()));
				jObject.put("rate", util.indianRupeeFormat(logisticTransItem.getKmRate().toString()));
				jObject.put("hire", util.indianRupeeFormat(logisticTransItem.getTotal().toString()));
				jObject.put("vehicle", logisticTransItem.getTruckNo());
				jsonObjects.add(jObject);
				km+=logisticTransItem.getSoDis().doubleValue();
				hire+=logisticTransItem.getTotal().doubleValue();
			}	
			double totalKm = Round(km, 2);
			double totalHire = Round(hire,2);
			JSONObject item_total = new JSONObject();
			item_total.put("title", "PaymentSummary");
			item_total.put("plant", "<b>Total</b>");
			item_total.put("plantName", "");
			item_total.put("route", "");
			item_total.put("routeName", "");
			item_total.put("vehicleModel","");
			item_total.put("bdate", "");
			item_total.put("km", "<b>"+util.indianRupeeFormat(setFloatAmount(""+totalKm))+"</b>");
			item_total.put("fixed", "");
			item_total.put("rate", "");
			item_total.put("hire", "<b>"+util.indianRupeeFormat(setFloatAmount(""+totalHire))+"</b>");
			item_total.put("vehicle", "");
			jsonObjects.add(item_total);	
			
			/*-------Arrear Details----------*/
			double arrear = 0.00;
			List<Object[]> arrearDetails = logisticTransHeaderDao.getArrearDetails(companyCode, userId, plant, route, sdate, edate);
			for (Object[] obj : arrearDetails) {
				JSONObject jObject = new JSONObject();
				jObject.put("title", "ArrearSummary");
				jObject.put("bdate", (String)obj[0]+"-"+(String)obj[1]);
				BigDecimal amt = (BigDecimal)obj[2];
				arrear+=amt.doubleValue();
				jObject.put("km", util.indianRupeeFormat(amt.toString()));
				jsonObjects.add(jObject);
			}
			double totalArrear = Round(arrear,2);
			JSONObject arrear_total = new JSONObject();
			arrear_total.put("title", "ArrearSummary");
			arrear_total.put("bdate", "Total");
			arrear_total.put("km", util.indianRupeeFormat(setFloatAmount(""+totalArrear)));
			jsonObjects.add(arrear_total);
			
			/*-------Deduction Details----------*/
			double deduction = 0.00;
			List<Object[]> deductionDetails = logisticTransHeaderDao.getDeductionDetails(companyCode, userId, plant, route, sdate, edate);
			for (Object[] obj : deductionDetails) {
				JSONObject jObject = new JSONObject();
				jObject.put("title", "DeductionSummary");
				jObject.put("bdate", (String)obj[0]+"-"+(String)obj[1]);
				BigDecimal amt = (BigDecimal)obj[2];
				deduction+=amt.doubleValue();
				jObject.put("km", util.indianRupeeFormat(amt.toString()));
				jsonObjects.add(jObject);
			}
			double totalDeduction = Round(deduction, 2);
			JSONObject deduction_total = new JSONObject();
			deduction_total.put("title", "DeductionSummary");
			deduction_total.put("bdate", "Total");
			deduction_total.put("km", util.indianRupeeFormat(setFloatAmount(""+totalDeduction)));
			jsonObjects.add(deduction_total);			
			
			double total = (totalHire+totalArrear)-totalDeduction;
			double totalValue = Round(total,2);
			JSONObject jObj = new JSONObject();
			jObj.put("title", "FinalSummary");
			jObj.put("km", util.indianRupeeFormat(setFloatAmount(""+totalValue)));
			jsonObjects.add(jObj);	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return jsonObjects.toString();
	}
	
	// function for rounding
    public double Round(double Rval, int Rpl) {
        double p = (double) Math.pow(10, Rpl);
        Rval = Rval * p;
        double tmp = Math.round(Rval);
        return (double) tmp / p;
    }

    public String setFloatAmount(String price) {
        try {
            price = price.replace(".", "/");

            if (price.contains("/")) {

                String[] q = price.split("/");

                int k = q[1].length();

                for (int i = k; i < 2; i++) {

                    q[1] += "0";
                }

                price = q[0] + "." + q[1];
            } else {
                price = price + ".00";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return price;
    }
}
