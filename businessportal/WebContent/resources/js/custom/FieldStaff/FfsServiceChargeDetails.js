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

	$('#FfsServiceChargeDetails').addClass("active");

	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Service Charge Details</a></li>");


	$('#ffServiceChargeGrid').jqxGrid({
		width : '100%',
		height : 550,
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

				var row = $("#ffServiceChargeGrid").jqxGrid('getselectedrowindex');
				if (row !== -1) {
					
					
					
					  $('.deductionDynamic').html('');
					  $('.arrearDynamic').html('');
					  

					//
					//						var plant = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'plant');
					//						var socity = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'socity');
					var billNumber = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'billName');
					
					var cStartDate = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'cStartDate');
					var cEndDate = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'cEndDate');
					var socity = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'socity');
					var cName = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'cName');
					var avgQty = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'avgQty');
					var vendorCode = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'vendorCode');
					var vendorName = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'vendorName');
					var noOfDays = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'noOfDays');
					var panNo = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'panNo');
					var plantAddress = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'plantAddress');
					var city = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'city');
					var pincode = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'pincode');
					var sampleMilkAmount = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'sampleMilkAmount');
					var arrearAmount = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'arrearAmount');
					var actDed = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'actDed');
					var tsTally = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'tsTally');
					var adltComm = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'adltComm');
					var testComm = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'testComm');
					var spilComm = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'spilComm');
					var tsComm = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'tsComm');
					var qtyComm = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'qtyComm');
					var feedAmount = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'feedAmount');
					var incAmount = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'incAmount');
					var smsAmount = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'smsAmount');
					
					var totalTds = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'tds');
					var neAmount = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'neAmount');
					var serviceCharge = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'serviceCharge');
					
					var totalDeductionAmount = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'totalDeductionAmount');
					var deductionDetails = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'deductionDetails');
					var plantDesc = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'plantDesc');
					
					var arrearCondition = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'arrearCondition');
				
		
					
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
					
					
					var paySlipStatus = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'paySlipStatus');

					
					if(paySlipStatus){
						
						
						var arrearDetails = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'arrearDetails');
						var totalArrearAmount = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'totalArrearAmount');
						var totalPayable = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'totalPayable');
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
						  
						
						  
						  
						
							var deductionNewDetails = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'deductionDetails');
							
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
						  
							var netAmount = $('#ffServiceChargeGrid').jqxGrid('getcellvalue', row, 'netAmount');
						  
						  
						  
						  
						  $('#netNewAmount').text(netAmount);
						  
						  
						  
						$('#hmbNewServiceChargeModel').modal('show');
						
						$('#ffServiceChargeGrid').jqxGrid('clearselection');
						
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
			url : 'getFfsServiceCharges?selected_month=' + hmbMonth,
			async : false
		}
		var dataAdapter_inventory1 = new $.jqx.dataAdapter(source_inventory1);
		$('#ffServiceChargeGrid').jqxGrid({
			source : dataAdapter_inventory1
		});

		$(".loader").fadeOut("slow");
		
		


	//		}
	});
});