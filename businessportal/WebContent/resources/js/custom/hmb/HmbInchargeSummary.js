$(window).load(function() {
	$(".loader").fadeOut("slow");
});
$(document).ready(function(e) {
	
	
	var getLocalization = function() {
		var localizationobj = {};
		localizationobj.firstDay = 1;
		localizationobj.percentsymbol = "%";
		localizationobj.currencysymbol = " ";
		localizationobj.currencysymbolposition = " ";
		localizationobj.decimalseparator = ".";
		
		localizationobj.thousandsseparator = ",";
		localizationobj.emptydatastring = "No records found! ";
		
		
		return localizationobj;
	};
	
	
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';

	$('#HmbInchargeSummary').addClass("active");

	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> HMB Summary</a></li>");

	//$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 14px;'><span class="icon icon-double-angle-right"></span> <a href='#'>Hmb Summary</a></li>");


	//	$('#hmbMonth').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	

	
	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});



	$('#oustandingReportGrid').jqxGrid({
		width : '100%',
		height : 200,
		sortable : true,
		
		altrows : true,
		theme : theme,
		showtoolbar : true,
		selectionmode : 'singlerow',
		toolbarheight : 40,

		showaggregates : true,
		rendertoolbar : function(toolbar) {
			var me = this;
			var container = $("<div style='margin: 5px;'></div>");
			var viewButton = $("<div style='float: right; margin-left: 5px;'> <img style='position: relative; margin-top: 2px;' src='resources/vendor-images/icon_eye.png'/><span style='margin-left: 4px; position: relative; top: 2px;'>View</span></div>");
var heading=$("<div style='margin: 14px;color: #fefefe;'>HMB Service Charge</div>");

			toolbar.append(container);
			toolbar.append(heading);
			container.append(viewButton);



			viewButton.jqxButton({
				width : 60,
				height : 20,
				theme : theme
			});

			viewButton.click(function(event) {

				var row = $("#oustandingReportGrid").jqxGrid('getselectedrowindex');
				if (row !== -1) {
					
					
					
					  $('.deductionDynamic').html('');
					  $('.arrearDynamic').html('');
					  

					//
					//						var plant = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'plant');
					//						var socity = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'socity');
					var billNumber = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'billName');
					
					var cStartDate = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'cStartDate');
					var cEndDate = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'cEndDate');
					var socity = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'socity');
					var cName = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'cName');
					var avgQty = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'avgQty');
					var vendorCode = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'vendorCode');
					var vendorName = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'vendorName');
					var noOfDays = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'noOfDays');
					var panNo = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'panNo');
					var plantAddress = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'plantAddress');
					var city = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'city');
					var pincode = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'pincode');
					var sampleMilkAmount = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'sampleMilkAmount');
					var arrearAmount = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'arrearAmount');
					var actDed = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'actDed');
					var tsTally = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'tsTally');
					var adltComm = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'adltComm');
					var testComm = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'testComm');
					var spilComm = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'spilComm');
					var tsComm = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'tsComm');
					var qtyComm = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'qtyComm');
					var feedAmount = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'feedAmount');
					var incAmount = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'incAmount');
					var smsAmount = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'smsAmount');
					
					var totalTds = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'tds');
					var neAmount = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'neAmount');
					var serviceCharge = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'serviceCharge');
					
					var totalDeductionAmount = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'totalDeductionAmount');
					var deductionDetails = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'deductionDetails');
					var plantDesc = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'plantDesc');
					
					var arrearCondition = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'arrearCondition');
				
		
					
					if(arrearCondition){
						
						$("#termAndCondition").show();
						
					}else{
						//salert("fasle");
						$("#termAndCondition").hide();
						
					}
					
					console.log("deductionDetails"+deductionDetails);
					
//					  $("#ded_desc1").text("asdasd")
					  var deductionSplit = deductionDetails.split("!");
					  for (var i=0; i < deductionSplit.length; i++) {
						  
						  console.log("deductionSplit"+deductionSplit[i]);
//						  $("#ded_desc1").val(deductionSplit[0]);
//						  $("#ded_value1").val(deductionSplit[1]);
						  
						  var deductiondescSplit = deductionSplit[i].split("^");
						  
						  console.log("deductiondescSplit"+deductiondescSplit);
						  console.log("i.."+i);
						  
						  
						  if(i==0 && deductiondescSplit!=""){
							 
							  $('#ded_clon1').css('display', 'block');
							  $('#ded_desc1').text(deductiondescSplit[0]);
							  $('#ded_value1').text(deductiondescSplit[1]);
							  
						  }else if(i==1 && deductiondescSplit!=""){
							  $('#ded_clon2').css('display', 'block');
							  $('#ded_desc2').text(deductiondescSplit[0]);
							  $('#ded_value2').text(deductiondescSplit[1]);
							  
						  } else if(i==2 && deductiondescSplit!=""){
							  $('#ded_clon3').css('display', 'block');
							  $('#ded_desc3').text(deductiondescSplit[0]);
							  $('#ded_value3').text(deductiondescSplit[1]);
							  
						  }else if(i==3 && deductiondescSplit!=""){
							  $('#ded_clon4').css('display', 'block');
							  $('#ded_desc4').text(deductiondescSplit[0]);
							  $('#ded_value4').text(deductiondescSplit[1]);
							  
						  }else if(i==4 && deductiondescSplit!=""){
							  $('#ded_clon5').css('display', 'block');
							  $('#ded_desc5').text(deductiondescSplit[0]);
							  $('#ded_value5').text(deductiondescSplit[1]);
							  
						  }else if(i==5 && deductiondescSplit!=""){
							  $('#ded_clon6').css('display', 'block');
							  $('#ded_desc6').text(deductiondescSplit[0]);
							  $('#ded_value6').text(deductiondescSplit[1]);
							  
						  }else if(i==6 && deductiondescSplit!=""){
							  $('#ded_clon7').css('display', 'block');
							  $('#ded_desc7').text(deductiondescSplit[0]);
							  $('#ded_value7').text(deductiondescSplit[1]);
							  
						  }else if(i==7 && deductiondescSplit!=""){
							  $('#ded_clon8').css('display', 'block');
							  $('#ded_desc8').text(deductiondescSplit[0]);
							  $('#ded_value8').text(deductiondescSplit[1]);
							  
						  }
						   
						}
					
					  
				//	  Header Part
				
					$(".hmbSerAddress").text(plantAddress+","+city+" - "+pincode);
					
					$(".hmbSerCity").text(plantDesc);
					//$(".hmbSerPincode").text(pincode);
//					$(".cStartDate").text(dateformat(cStartDate));
//					$(".cEndDate").text(dateformat(cEndDate));
					$(".hmbCode").text(socity);
					
					$(".hmbName").text(cName);
					$(".hmbAvgQtyDay").text(avgQty);
					$(".hmbBankerCode").text(vendorCode);
					$(".hmbNoOfDays").text(noOfDays);
					$(".hmbBankerName").text(vendorName);
					$(".hmbPanNo").text(panNo);
					
					
$(".hmbNewSerAddress").text(plantAddress+","+city+" - "+pincode);
					
					$(".hmbNewSerCity").text(plantDesc);
					//$(".hmbSerPincode").text(pincode);
//					$(".cStartDate").text(dateformat(cStartDate));
//					$(".cEndDate").text(dateformat(cEndDate));
					$(".hmbNewCode").text(socity);
					
					$(".hmbNewName").text(cName);
					$(".hmbNewAvgQtyDay").text(avgQty);
					$(".hmbNewBankerCode").text(vendorCode);
					$(".hmbNewNoOfDays").text(noOfDays);
					$(".hmbNewBankerName").text(vendorName);
					$(".hmbNewPanNo").text(panNo);
					
					
					
					
					
					
					
					$("#hmbNewQtyServicecharge").text(incAmount);
					
					$("#hmbNewTsTally").text(tsTally);
					$("#hmbNewNillAdul").text(adltComm);
					$("#hmbNewTesting").text(testComm);
					$("#hmbNewNilSpilage").text(spilComm);
					$("#hmbNewMilkTsFat").text(tsComm);
					
					$("#hmbNewQty").text(qtyComm);
					$("#hmbNewFeed").text(feedAmount);
					$("#hmbNewTds").text(totalTds+" -");
					
					
					$("#hmbNewTotalDeductionAmt").text(totalDeductionAmount+" -");
					
					$("#hmbMilkTally").text("0.00");
					
					$("#hmbTds").text(totalTds);
					$("#hmbTsTally").text(tsTally);
//					$("#hmbEkoSampleMilk").text("4.02");
					$("#hmbNillAdul").text(adltComm);
//					$("#hmbProc").text("1,147.92");
					$("#hmbTesting").text(testComm);
					$("#hmbNilSpilage").text(spilComm);
					$("#hmbMilkTsFat").text(tsComm);
					$("#hmbQty").text(qtyComm);
					$("#hmbFeed").text(feedAmount);
					$("#hmbQtyIncen").text(incAmount);
					$("#hmbSmsAmount").text(smsAmount);
					$("#hmbArrearAmount").text(arrearAmount);
					$("#hmbTotalDeduction").text(totalDeductionAmount);
					$("#netAmount").text(neAmount);
					$("#hmbServiceCharge").text(serviceCharge);
					
				
					$(".hmbServiceChargeTitle").text("HMB Service Payment Detail ( Bill No : "+billNumber+" ) Cut-Off Period "+dateformat(cStartDate)+" To "+dateformat(cEndDate));
					$(".hmbNewServiceChargeTitle").text("HMB Service Payment Detail ( Bill No : "+billNumber+" ) Cut-Off Period "+dateformat(cStartDate)+" To "+dateformat(cEndDate));
					
					
					var paySlipStatus = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'paySlipStatus');

					
					if(paySlipStatus){
						
						
						var arrearDetails = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'arrearDetails');
						var totalArrearAmount = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'totalArrearAmount');
						var totalPayable = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'totalPayable');
						console.log("deductionDetails"+deductionDetails);
						 
//						  $("#ded_desc1").text("asdasd")
						  var arrearSplit = arrearDetails.split("!");
						  for (var i=0; i < arrearSplit.length; i++) {
							  
							  var arrearLineName="";
							  
							//alert("arrearSplit"+arrearSplit[i]);

							  var arrearDescSplit = arrearSplit[i].split("^");
							  
							  for (var j=0; j < arrearDescSplit.length; j++) {
								//  alert("arrearDescSplit[1].."+arrearDescSplit[1]);
								  
								  if (arrearDescSplit[1] === undefined || arrearDescSplit[1] === null) {
									     // do something 
									}else{
								  
								arrearLineName=('<tr class="arrearDynamic" ><td style="font-weight: 900;" class="table-header-align-left" id="leftHeaderAlign"></td><td style="font-weight: 900;" class="table-header-align-left" id="leftLineAlign"></td><td  style="font-weight: 900;" class="table-header-align-left">'+arrearDescSplit[1]+'</td><td  style="font-weight: 900;">:</td><td class="table-header-align-right" >'+arrearDescSplit[2]+'</td></tr>');
									}
							  }
							 
							  
					
							  
							  $('#endstaticField1').after(arrearLineName);
							  
							 
							  
					
							   
							}
						  
						
						  
						  
						
							var deductionNewDetails = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'deductionDetails');
							
							  var deductionNewSplit = deductionNewDetails.split("!");
							  
							  
							  
							  for (var i=0; i < deductionNewSplit.length; i++) {
								  
								  var deductionNewLineName="";
								  
								//alert("arrearSplit"+arrearSplit[i]);

								  var deductionNewDescSplit = deductionNewSplit[i].split("^");
								 
								  
								  for (var j=0; j < deductionNewDescSplit.length; j++) {
									
									  
									  if (deductionNewDescSplit[1] === undefined || deductionNewDescSplit[1] === null) {
										     // do something 
										}else{
									  
											deductionNewLineName=('<tr class="deductionDynamic"><td style="font-weight: 900;" class="table-header-align-left" id="leftHeaderAlign"></td><td style="font-weight: 900;" class="table-header-align-left" id="leftLineAlign"></td><td  style="font-weight: 900;" class="table-header-align-left">'+deductionNewDescSplit[0]+'</td><td  style="font-weight: 900;">:</td><td class="table-header-align-right" >'+deductionNewDescSplit[1]+' -</td></tr>');
										}
								  }
								 
								  
						
								  
								  $('#startDeduction').after(deductionNewLineName);
						
								 
								}
							  
							
							
						  $('#hmbNewTotalPayableAmt').text(totalPayable);
						  
							var netAmount = $('#oustandingReportGrid').jqxGrid('getcellvalue', row, 'netAmount');
						  
						  
						  
						  
						  $('#netNewAmount').text(netAmount);
						  
						  
						  
						$('#hmbNewServiceChargeModel').modal('show');
						
						$('#oustandingReportGrid').jqxGrid('clearselection');
						
//						  $('#dynamicDection').text("");
//						  
//						  $('#dynamicArrear').text("");
						
				
					}else{
						$('#hmbServiceChargeModel').modal('show');
						//alert("old payslip"+paySlipStatus);
					}
					

				} else {

				}

			});


		},

		columns : [
			{
				text : 'No',
				dataField : '',
				columntype : 'number',
				cellsalign : 'center',
				width : '7%',
				align : 'center',
				cellsrenderer : function(row, column, value) {
					return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
				}
			},
			{
				text : 'Posting Date',
				datafield : 'postDate',
				width : '28%',
				cellsalign : 'center',
				align : 'center',
				columntype : 'date',
				cellsformat : 'dd/MM/yyyy',
			},
			{
				text : 'Bill Number',
				datafield : 'billName',
				width : '45%',
				cellsalign : 'center',
				align : 'center'
			},
			{
				text : 'Amount',
				datafield : 'totalAmount',
				width : '15%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			{
				text : 'TDS Amount ',
				datafield : 'tds',
				width : '15%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			
			{
				text : 'deductionDetails ',
				datafield : 'deductionDetails',
				width : '15%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			
			},
			{
				text : 'plantDesc ',
				datafield : 'plantDesc',
				width : '15%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			
			},
			
			
			{
				
				text : 'totalDeductionAmount ',
				datafield : 'totalDeductionAmount',
				width : '15%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
		
			},
			
			{
				text : 'Net Amount ',
				datafield : 'neAmount',
				width : '20%',
				align : 'center',
				cellsalign : 'right'
			},
			{
				text : 'cStartDate ',
				datafield : 'cStartDate',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'cEndDate ',
				datafield : 'cEndDate',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'socity ',
				datafield : 'socity',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'cName ',
				datafield : 'cName',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			
			{
				text : 'serviceCharge ',
				datafield : 'serviceCharge',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			
			{
				text : 'avgQty ',
				datafield : 'avgQty',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'vendorCode ',
				datafield : 'vendorCode',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'vendorName ',
				datafield : 'vendorName',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'noOfDays ',
				datafield : 'noOfDays',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'panNo ',
				datafield : 'panNo',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'plantAddress ',
				datafield : 'plantAddress',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'city ',
				datafield : 'city',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'pincode ',
				datafield : 'pincode',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'sampleMilkAmount ',
				datafield : 'sampleMilkAmount',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'arrearAmount ',
				datafield : 'arrearAmount',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'actDed ',
				datafield : 'actDed',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'tsTally ',
				datafield : 'tsTally',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'adltComm ',
				datafield : 'adltComm',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'testComm ',
				datafield : 'testComm',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'spilComm ',
				datafield : 'spilComm',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'tsComm ',
				datafield : 'tsComm',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'qtyComm ',
				datafield : 'qtyComm',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},	{
				text : 'feedAmount ',
				datafield : 'feedAmount',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			{
				text : 'incAmount ',
				datafield : 'incAmount',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			{
				text : 'smsAmount ',
				datafield : 'smsAmount',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			
			{
				text : 'paySlipStatus ',
				datafield : 'paySlipStatus',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			
			{
				text : 'arrearDetails ',
				datafield : 'arrearDetails',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			
			{
				text : 'totalArrearAmount ',
				datafield : 'totalArrearAmount',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			{
				text : 'totalPayable ',
				datafield : 'totalPayable',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			{
				text : 'netAmount ',
				datafield : 'netAmount',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			{
				text : 'arrearCondition ',
				datafield : 'arrearCondition',
				width : '18%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			}
			
			
			
			
			
			

		]
	});

	$('#DepositeReportGrid').jqxGrid({
		width : '100%',
		height : 200,
		sortable : true,

		altrows : true,
		theme : theme,
		showtoolbar : true,
		selectionmode : 'singlerow',
		toolbarheight : 40,
		 columnsResize: true,
		showaggregates : true,
		rendertoolbar : function(toolbar) {
			var me = this;
			var container = $("<div style='margin: 5px;'></div>");
		
var heading=$("<div style='margin: 14px;color: #fefefe;'>Deposit Received</div>");

			toolbar.append(container);
			toolbar.append(heading);





		},
		
		columns : [
			{
				text : 'No',
				dataField : '',
				columntype : 'number',
				cellsalign : 'center',
				width : '7%',
				align : 'center',
				cellsrenderer : function(row, column, value) {
					return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
				}
			},
			{
				text : 'Date',
				datafield : 'postingDate',
				width : '12%',
				cellsalign : 'center',
				align : 'center',
				columntype : 'date',
				cellsformat : 'dd/MM/yyyy',
			},
			{
				text : 'Vendor Code',
				datafield : 'vendorcode',
				width : '10%',
				cellsalign : 'center',
				align : 'center',
				hidden : true
			},
			{
				text : 'Vendor Name',
				datafield : 'vendorName',
				width : '20%',
				cellsalign : 'center',
				align : 'center',
				hidden : true
			},
			
			{
				text : 'Reference No',
				datafield : 'docNo',
				width : '15%',
				cellsalign : 'center',
				align : 'center'
			},
			{
				text : 'Year',
				datafield : 'fiYear',
				width : '10%',
				cellsalign : 'center',
				align : 'center'
			},
			{
				text : 'Doc Type',
				datafield : 'docTypeName',
				width : '18%',
				align : 'center',
				hidden : true
			},
			{
				text : 'Remark',
				datafield : 'remark',
				width : '39%',
				align : 'center'
			},
			{
				text : 'Doc Date',
				datafield : 'docDate',
				width : '10%',
				cellsalign : 'center',
				align : 'center',
				columntype : 'date',
				cellsformat : 'dd/MM/yyyy',
				hidden : true
			},
			{
				text : 'Debit ',
				datafield : 'debitAmount',
				width : '11%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			{
				text : 'Credit ',
				datafield : 'creditAmount',
				width : '11%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			
			 {text:'Deposit Amount',datafield:'securityDepositAmount',width:'17%',align: 'center', cellsalign: 'right'
	        	 , aggregates: ['sum']},		
			
//			{
//				text : 'Deposit Amount',
//				datafield : 'securityDepositAmount',
//				width : '17%',
//				align : 'center',
//				cellsalign : 'right',
//				cellsformat: 'c2',
//				aggregates : [ "sum" ],
//			},
			{
				text : 'TDS Amount ',
				datafield : 'tdsAmount',
				width : '13%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			{
				text : 'Net Amount ',
				datafield : 'netAmount',
				width : '13%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			}



			
			
			
			
			
			
			
		]
	});

	$('#hmbSummaryGrid').jqxGrid({
		width : '100%',
		height : 400,
		altrows : true,
		theme : theme,
		showaggregates : true,
		 columnsResize: true,
		 localization : getLocalization(),
		filterable : true,
		groupable : true,

		altrows : true,
		sortable : true,
		showtoolbar : true,
		selectionmode : 'singlerow',
		toolbarheight : 40,

		groups : [ 'farmerCode' ],
		groupsexpandedbydefault : true,
		showgroupaggregates : true,
		showaggregates : true,
		rendertoolbar : function(toolbar) {
			var me = this;
			var container = $("<div style='margin: 5px;'></div>");
			var viewButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='resources/vendor-images/icon_eye.png'/><span style='margin-left: 4px; position: relative; top: 2px;'>View</span></div>");


			toolbar.append(container);
			container.append(viewButton);



			viewButton.jqxButton({
				width : 60,
				height : 20,
				theme : theme
			});

			viewButton.click(function(event) {

				var row = $("#hmbSummaryGrid").jqxGrid('getselectedrowindex');
				if (row !== -1) {
					var cutOffValue = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'cutOff');
					var cutOffFromDate = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'dateFrom');
					var cutOffTodate = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'dateTo');

					var plant = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'plant');
					var socity = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'socity');
					var billNumber = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'billNumber');
					var netAmount = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'netAmount');

					var farmerCode = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'farmerCode');
					var farmerName = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'farmerName');

					$('#payemntTable tbody').empty();

					console.log("calling " + cutOffValue);
					//  $(".modal-title").val(''+cutOffValue+' '+cutOffFromDate+' - '+cutOffTodate);

					$('#hmbSummaryModel').modal('show');
					var dataString = 'plant=' + plant + '&socity=' + socity + '&billNumber=' + billNumber;

					$('#payemntTable tfoot').empty();
					$('#payemntTable tbody').empty();

					/////      HMB Payment


					$.ajax({
						type : "POST",
						url : "getHmbDetails",
						data : dataString,
						success : function(response) {
							//								alert("resp.."+response);

							var json_obj = $.parseJSON(response);

							var output = "";

							$('#payemntTable tfoot').empty();
							$('#payemntTable tbody').empty();

							var count = 0;
							$.each(json_obj, function(index, items) {
								//alert("i.."+index);
								//	alert("items.."+items)
								$.each(items, function(index, item) {
									var eachrow = "";
									if (item.particulars == null) {

										if (item.holeTotal == 0) {

										} else {
											eachrow = "<tr>"
												+ "<td class='table-header_align' colspan='3'> Total  </td>"
												+ "<td class='table-header_align'> " + item.qtyKg + "  </td>"
												+ "<td></td>"
												+ "<td></td>"
												+ "<td></td>"
												+ "<td></td>"
												+ "<td class='table-header-align-right'>" + item.holeTotal + "</td>"
//												+ "<td></td>"
												//												+ "<td class='table-header-align-right'>" + item.incentiveAmount + "</td>"
												+ "</tr>";
											$('#payemntTable tbody').append(eachrow);

										}
									} else if (item.particulars == "Total") {


										$("#payementTotalLtrs").text("" + item.rateLtrAmount);
										$("#payementTotalAmount").text("" + item.totalAmount);
									
											$("#payementTotalDeduction").text("" + item.incentiveAmount);
							
											$("#payementTotalArrear").text("" + item.addRateLtrAmount);
									
										$("#payementNetAmount").text(" " + item.holeTotal);
									} else {

										var newSDate = "";

										if (item.ssDate == "") {

											newSDate = item.ssDate;
										} else {

											newSDate = dateformat(item.ssDate);
										}


										eachrow = "<tr>"


											+ "<td>" + item.particulars + "</td>"
											+ "<td  class='table-header_align'>" + newSDate + " " + item.shift + "</td>"
											+ "<td  class='table-header_align'>" + item.milkType + "</td>"


											+ "<td  class='table-header_align'>" + item.qtyKg + "</td>"
											+ "<td  class='table-header_align'>" + item.fat + "</td>"
											+ "<td  class='table-header_align'>" + item.snf + "</td>"

											+ "<td class='table-header-align-right'>" + item.rateLtrAmount + "</td>"
											+ "<td class='table-header-align-right'>" + item.addRateLtrAmount + "</td>"
											+ "<td class='table-header-align-right'>" + item.holeTotal + "</td>"
//											+ "<td class='table-header-align-right'>0.00</td>"
											//											+ "<td class='table-header-align-right'>" + item.incentiveAmount + "</td>"
											+ "</tr>";
										$('#payemntTable tbody').append(eachrow);
									}


									count++;
								})
							})


						},
						dataType : "html"
					});


					$("#hmbSummaryGrid").jqxGrid('clearselection');

					/// HMB Deduction


					//					$.ajax({
					//						type : "POST",
					//						url : "getHmbDeduction",
					//						data : dataString,
					//						success : function(response) {
					//							//	alert("resp.."+response);
					//
					//							var json_obj = $.parseJSON(response);
					//
					//							var output = "";
					//
					//							//        	     				$('#payemntTable tfoot').empty();
					//							//        	     				$('#payemntTable tbody').empty();
					//
					//							var count = 0;
					//							$.each(json_obj, function(index, items) {
					//								//alert("i.."+index);
					//								//	alert("items.."+items)
					//								$.each(items, function(index, item) {
					//									var eachrow = "";
					//									if (item.particulars == null) {
					//										if (item.totalAmount == 0) {
					//
					//										} else {
					//
					//											eachrow = "<tr>"
					//												+ "<td class='table-header_align' colspan='6'> Total  </td>"
					//												+ "<td class='table-header-align-right'>" + item.totalAmount + "</td>"
					//												+ "</tr>";
					//											$('#payemntTable tbody').append(eachrow);
					//										}
					//
					//									} else {
					//										eachrow = "<tr>"
					//											+ "<td  class='table-header_align'>" + item.ssDate + "</td>"
					//											+ "<td>" + item.particulars + "</td>"
					//											+ "<td  class='table-header_align'>" + item.shift + "</td>"
					//											+ "<td  class='table-header_align'>" + item.qtyKg + "</td>"
					//											+ "<td  class='table-header_align'>" + item.fat + "</td>"
					//											+ "<td  class='table-header_align'>" + item.snf + "</td>"
					//											+ "<td class='table-header-align-right'>" + item.totalAmount + "</td>"
					//											+ "</tr>";
					//										$('#payemntTable tbody').append(eachrow);
					//									}
					//
					//
					//									count++;
					//								})
					//							})
					//
					//
					//						},
					//						dataType : "html"
					//					});


					///// HMB Recovery

					//
					//					$.ajax({
					//						type : "POST",
					//						url : "getHmbRecovery",
					//						data : dataString,
					//						success : function(response) {
					//							//	alert("resp.."+response);
					//
					//							var json_obj = $.parseJSON(response);
					//
					//							var output = "";
					//
					//							//        	     			
					//
					//							var count = 0;
					//							$.each(json_obj, function(index, items) {
					//								//alert("i.."+index);
					//								//	alert("items.."+items)
					//								$.each(items, function(index, item) {
					//									var eachrow = "";
					//									if (item.particulars == null) {
					//										if (item.totalAmount == 0) {
					//
					//										} else {
					//											eachrow = "<tr>"
					//												+ "<td class='table-header_align' colspan='6'> Total  </td>"
					//												+ "<td class='table-header-align-right'>" + item.totalAmount + "</td>"
					//												+ "</tr>";
					//											$('#payemntTable tbody').append(eachrow);
					//										}
					//									} else {
					//										eachrow = "<tr>"
					//											+ "<td  class='table-header_align'>" + item.ssDate + "</td>"
					//											+ "<td>" + item.particulars + "</td>"
					//											+ "<td  class='table-header_align'>" + item.shift + "</td>"
					//											+ "<td  class='table-header_align'>" + item.qtyKg + "</td>"
					//											+ "<td  class='table-header_align'>" + item.fat + "</td>"
					//											+ "<td  class='table-header_align'>" + item.snf + "</td>"
					//											+ "<td class='table-header-align-right'>" + item.totalAmount + "</td>"
					//											+ "</tr>";
					//										$('#payemntTable tbody').append(eachrow);
					//									}
					//
					//
					//									count++;
					//								})
					//							})
					//
					//
					//						},
					//						dataType : "html"
					//					});








					$(".modal-title").text('' + farmerName +  ' ( '+farmerCode+' ) ' + dateformat(cutOffFromDate) + ' - ' + dateformat(cutOffTodate) + ' ');

				} else {

				}

			});


		},

		columns : [
			{
				text : 'No',
				dataField : '',
				columntype : 'number',
				cellsalign : 'center',
				width : '7%',
				hidden : true,
				align : 'center',
				cellsrenderer : function(row, column, value) {
					return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
				}
			},

			//			{
			//				text : 'Cut Of Period',
			//				datafield : 'cutOff',
			//				width :'8%',
			//				cellsalign : 'center',
			//				align : 'center',
			//			},


			{
				text : 'View',
				datafield : 'View',
				width : '5%',
				cellsalign : 'center',
				columntype : 'button',
				align : 'center',
				hidden : true,
				cellsrenderer : function() {
					return 'View';

				},
				buttonclick : function(row) {
					var cutOffValue = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'cutOff');
					var cutOffFromDate = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'dateFrom');
					var cutOffTodate = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'dateTo');
					
					var farmerCode = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'farmerCode');
					var farmerName = $('#hmbSummaryGrid').jqxGrid('getcellvalue', row, 'farmerName');

					console.log("calling " + cutOffValue);
					
					
					
					//  $(".modal-title").val(''+cutOffValue+' '+cutOffFromDate+' - '+cutOffTodate);

					$('#hmbSummaryModel').modal('show');

					$(".modal-title").text('' + farmerName +  '( '+farmerCode+') ' + dateformat(cutOffFromDate) + ' - ' + dateformat(cutOffTodate) + ' )');
				}
			},





			{
				text : 'Farmer Code',
				datafield : 'farmerCode',
				width : '10%',
				cellsalign : 'center',
				align : 'center',
			},
			{
				text : 'Farmer Name',
				datafield : 'farmerName',
				width : '17%',

				align : 'center',
			},
			{
				text : 'P Code',
				datafield : 'pCode',
				width : '6%',
				cellsalign : 'center',
				align : 'center',
				
			},



			{
				text : 'From Date',
				datafield : 'dateFrom',
				width : '8.5%',
				cellsalign : 'center',
				align : 'center',
				columntype : 'date',
				cellsformat : 'dd/MM/yyyy',
			},
			{
				text : 'To Date',
				datafield : 'dateTo',
				width : '8.5%',
				cellsalign : 'center',
				align : 'center',
				columntype : 'date',
				cellsformat : 'dd/MM/yyyy',
			},

			{
				text : 'A/C No',
				datafield : 'acNo',
				width : '17%',
				cellsalign : 'center',
				align : 'center',
				hidden : true
			},

			{
				text : 'IFSC Code',
				datafield : 'ifcCode',
				width : '12%',
				cellsalign : 'center',

				align : 'center',
				hidden : true
			},
			
			{
				text : 'Total Ltrs',
				datafield : 'totalLtr',
				width : '9%',
				cellsalign : 'right',
				align : 'center',
			},
			
			

			{
				text : 'Payment ',
				datafield : 'milkPayment',
				width : '13%',
				aggregates : [ "sum" ],
				align : 'center',
				cellsformat: 'c2' ,
				cellsalign : 'right'
			},
			{
				text : 'Arrears ',
				datafield : 'arrears',
				aggregates : [ "sum" ],
				cellsformat: 'c2' ,
				width : '9%',
				align : 'center',
				cellsalign : 'right',
			
			},

			{
				text : 'Incentive ',
				datafield : 'incentive',
				aggregates : [ "sum" ],
				cellsformat: 'c2' ,
				width : '9%',
				align : 'center',
				cellsalign : 'right'
			},




			{
				text : 'Deductions ',
				datafield : 'deductions',
				aggregates : [ "sum" ],
				cellsformat: 'c2' ,
				width : '9%',
				align : 'center',
				cellsalign : 'right',
				
			},
			{
				text : 'Recoveries ',
				datafield : 'recoveries',
				cellsformat: 'c2' ,
				aggregates : [ "sum" ],
				width : '9%',
				align : 'center',
				cellsalign : 'right'
			},

			{
				text : 'Net Payment To Bank ',
				datafield : 'netAmount',
				aggregates : [ "sum" ],
				cellsformat: 'c2' ,
				width : '16%',
				align : 'center',
				cellsalign : 'right'
			},
			{
				text : 'billNumber ',
				datafield : 'billNumber',
				width : '11%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},

			{
				text : 'plant ',
				datafield : 'plant',
				width : '11%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			{
				text : 'socity ',
				datafield : 'socity',
				width : '11%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			},
			{
				text : 'actDed ',
				datafield : 'actDed',
				width : '11%',
				align : 'center',
				cellsalign : 'right',
				hidden : true
			}

		]
	});


	function getStrLenght(inputStr) {
		var result = "";
		var n = inputStr.length;
		// console.log("inputStr.."+inputStr+"...n.."+n);
		if (n == 1) {

			result = "0" + inputStr;

		} else {

			result = inputStr;
		}

		//  console.log("final result.."+result);
		return result;

	}

	function dateformat(inputdate) {
		var date = new Date(inputdate);

		var dateFormate = getStrLenght("" + date.getDate());
		var monthFormat = getStrLenght("" + (date.getMonth() + 1));
		var yearFormate = date.getFullYear();


		return (dateFormate + '.' + monthFormat + '.' + yearFormate);
	}





	$('#getBtn').on("click", function(e) {
		var lastThreeMonth=$("#lastThreeMonth").val();
		//	alert("lastThreeMonth.."+neadatepicker);
			
			var lastThreeMonthYear=$("#lastThreeMonthYear").val();
			//alert("lastThreeMonthYear.."+lastThreeMonthYear);
			
			

			 $(".loader").fadeIn("slow");
		//	var hmbMonth = $('#hmbMonth').val();
			
			var hmbMonth=lastThreeMonth+"-"+lastThreeMonthYear;
			
		var fields = new Array();

		fields.push({
			name : 'farmerCode',
			type : 'string'
		}, {
			name : 'farmerName',
			type : 'string'
		}, {
			name : 'cutOff',
			type : 'string'
		}, {
			name : 'grossAmount',
			type : 'string'
		},
			{
				name : 'arrears',
				type : 'string'
			}, {
				name : 'deductions',
				type: 'string'
			}, {
				name : 'recoveries',
				type : 'string'
			}, {
				name : 'netAmount',
				type : 'string'
			}, {
				name : 'billNumber',
				type : 'string'
			},

			{
				name : 'milkPayment',
				type : 'string'
			},

			{
				name : 'incentive',
				type : 'string'
			},
			{
				name : 'dateFrom',
				type : 'date',
				format : 'dd/mm/yyyy'
			}, {
				name : 'dateTo',
				type : 'date',
				format : 'dd/mm/yyyy'
			}, {
				name : 'plant',
				type : 'string'
			}, {
				name : 'socity',
				type : 'string'
			}, {
				name : 'actDed',
				type : 'string'
			},

			{
				name : 'acNo',
				type : 'string'
			},
			{
				name : 'ifcCode',
				type : 'string'
			}
			,
			{
				name : 'totalLtr',
				type : 'string'
			},
			{
				name : 'pCode',
				type : 'string'
			}
			
			




		);

		var source_inventory = {
			datatype : 'json',
			datafields : fields,
			url : 'getHmbInchargeSummary?selected_month=' + hmbMonth,
			async : false
		}
		var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
		$('#hmbSummaryGrid').jqxGrid({
			source : dataAdapter_inventory,

			groups : [ 'farmerCode' ]
		});












		var fields2 = new Array();

		fields2.push(
			{
				name : 'postDate',
				type : 'date',
				format : 'dd/mm/yyyy'
			}, {
				name : 'billName',
				type : 'string'
			}, {
				name : 'totalAmount',
				type : 'string'
			}, {
				name : 'tds',
				type : 'string'
			}
			, {
				name : 'neAmount',
				type : 'string'
			}
			
			, {
				name : 'cStartDate',
				type : 'string'
			}, {
				name : 'cEndDate',
				type : 'string'
			}, {
				name : 'socity',
				type : 'string'
			}, {
				name : 'cName',
				type : 'string'
			}, {
				name : 'avgQty',
				type : 'string'
			}, {
				name : 'vendorCode',
				type : 'string'
			}, {
				name : 'vendorName',
				type : 'string'
			}, {
				name : 'noOfDays',
				type : 'string'
			}, {
				name : 'panNo',
				type : 'string'
			}, {
				name : 'plantAddress',
				type : 'string'
			}, {
				name : 'city',
				type : 'string'
			}, {
				name : 'pincode',
				type : 'string'
			}, {
				name : 'sampleMilkAmount',
				type : 'string'
			}, {
				name : 'arrearAmount',
				type : 'string'
			}, {
				name : 'actDed',
				type : 'string'
			}, {
				name : 'tsTally',
				type : 'string'
			}, {
				name : 'adltComm',
				type : 'string'
			}, {
				name : 'testComm',
				type : 'string'
			}, {
				name : 'spilComm',
				type : 'string'
			}, {
				name : 'tsComm',
				type : 'string'
			}, {
				name : 'qtyComm',
				type : 'string'
			}, {
				name : 'feedAmount',
				type : 'string'
			},{
				name : 'incAmount',
				type : 'string'
			},{
				name : 'smsAmount',
				type : 'string'
			},
			{
				name : 'serviceCharge',
				type : 'string'
			},
			{
				name : 'deductionDetails',
				type : 'string'
			},{
				name : 'totalDeductionAmount',
				type : 'string'
			},
			{
				name : 'plantDesc',
				type : 'string'
			},
			{
				name : 'paySlipStatus',
				type : 'string'
			},
			
			{
				name : 'arrearDetails',
				type : 'string'
			},
			{
				name : 'totalArrearAmount',
				type : 'string'
			},	{
				name : 'totalPayable',
				type : 'string'
			},
			{
				name : 'netAmount',
				type : 'string'
			},
			{
				name : 'arrearCondition',
				type : 'string'
			}
			
			
			
			
			
			
			
			


		);

		var source_inventory1 = {
			datatype : 'json',
			datafields : fields2,
			url : 'getHmbServiceCharges?selected_month=' + hmbMonth,
			async : false
		}
		var dataAdapter_inventory1 = new $.jqx.dataAdapter(source_inventory1);
		$('#oustandingReportGrid').jqxGrid({
			source : dataAdapter_inventory1
		});

		$(".loader").fadeOut("slow");
		
		


	//		}
	});
});