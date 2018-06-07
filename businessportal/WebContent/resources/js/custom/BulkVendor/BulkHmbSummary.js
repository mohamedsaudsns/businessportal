$(window).load(function() {
	$(".loader").fadeOut("slow");
});
$(document).ready(function(e) {
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';

	$('#BulkHmbSummary').addClass("active");

	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Milk Summary</a></li>");

	//$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 14px;'><span class="icon icon-double-angle-right"></span> <a href='#'>Hmb Summary</a></li>");


	//	$('#hmbMonth').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});

//	$('#hmbMonth').jqxDateTimeInput({
//		width : '100%',
//		height : '25px',
//		theme : theme,
//		formatString : 'MMMM-yyyy',
//		culture : 'ko-KR',
//	//	showCalendarButton : false
//	});




	$('#hmbSummaryGrid').jqxGrid({
		width : '100%',
		height : 600,
		altrows : true,
		theme : theme,
		 columnsResize: true,
		showaggregates : true,
		altrows : true,
		sortable : true,
		showtoolbar : true,
		selectionmode : 'singlerow',
		toolbarheight : 40,
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
						url : "getBulkHmbDetails",
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
												+ "<td class='table-header_align' colspan='2'> Total  </td>"
												+ "<td class='table-header_align'> " + item.qtyKg + "  </td>"
												+ "<td></td>"
												+ "<td></td>"
												+ "<td></td>"
												+ "<td></td>"
												+ "<td class='table-header-align-right'>" + item.holeTotal + "</td>"
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
//											+ "<td  class='table-header_align'>" + item.milkType + "</td>"


											+ "<td  class='table-header_align'>" + item.qtyKg + "</td>"
											+ "<td  class='table-header_align'>" + item.fat + "</td>"
											+ "<td  class='table-header_align'>" + item.snf + "</td>"

											+ "<td class='table-header-align-right'>" + item.rateLtrAmount + "</td>"
											+ "<td class='table-header-align-right'>" + item.addRateLtrAmount + "</td>"
											+ "<td class='table-header-align-right'>" + item.holeTotal + "</td>"
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








					$(".modal-title").text('' + dateformat(cutOffFromDate) + ' - ' + dateformat(cutOffTodate) + ' ');

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

			{
				text : 'Cut Of Period',
				datafield : 'cutOff',
				width : '9%',
				cellsalign : 'center',
				align : 'center',
			},


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

					console.log("calling " + cutOffValue);
					//  $(".modal-title").val(''+cutOffValue+' '+cutOffFromDate+' - '+cutOffTodate);

					$('#hmbSummaryModel').modal('show');

					$(".modal-title").text('' + cutOffValue + ' ( ' + dateformat(cutOffFromDate) + ' - ' + dateformat(cutOffTodate) + ' )');
				}
			},





			{
				text : 'Farmer Code',
				datafield : 'farmerCode',
				width : '11%',
				cellsalign : 'center',
				align : 'center',
				hidden : true
			},
			{
				text : 'Farmer Name',
				datafield : 'farmerName',
				width : '20%',

				align : 'center',
				hidden : true
			},



			{
				text : 'From Date',
				datafield : 'dateFrom',
				width : '10%',
				cellsalign : 'center',
				align : 'center',
				columntype : 'date',
				cellsformat : 'dd/MM/yyyy',
			},
			{
				text : 'To Date',
				datafield : 'dateTo',
				width : '10%',
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
				text : 'Payment ',
				datafield : 'milkPayment',
				width : '13%',
				align : 'center',
				cellsalign : 'right'
			},
			{
				text : 'Arrears ',
				datafield : 'arrears',
				width : '10.5%',
				align : 'center',
				cellsalign : 'right'
			},
			{
				text : 'Incentive ',
				datafield : 'incentive',
//				aggregates: ["sum"],
				width : '10.5%',
				align : 'center',
				cellsalign : 'right'
			},
			{
				text : 'Deductions ',
				datafield : 'deductions',
				width : '10.5%',
				align : 'center',
				cellsalign : 'right'
			},
			{
				text : 'Recoveries ',
				datafield : 'recoveries',
				width : '10.5%',
				align : 'center',
				cellsalign : 'right',
			},

			{
				text : 'Net Payment To Bank ',
				datafield : 'netAmount',
				width : '16%',
				align : 'center',
				cellsalign : 'right',
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
		  var result="";
		    var n = inputStr.length;
		   // console.log("inputStr.."+inputStr+"...n.."+n);
		    if(n==1){
		    	
		    	result="0"+inputStr;
		    	
		    }else{
		    	
		    	result=inputStr;
		    }
		    
		  //  console.log("final result.."+result);
		    return result;
		   
		}
		
		function dateformat(inputdate) {
			var date = new Date(inputdate);

			var dateFormate=getStrLenght(""+date.getDate());
			var monthFormat=getStrLenght(""+(date.getMonth() + 1));
			var yearFormate=date.getFullYear();
			

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
		//	alert();


	//	var hmbMonth = $('#hmbMonth').val();

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
				type : 'string'
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
			
			
			
			{name:'incentive',
				type:'string'}
			
			, {
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
			
			
			
		);

		var source_inventory = {
			datatype : 'json',
			datafields : fields,
			url : 'getBulkHmbSummary?selected_month=' + hmbMonth,
			async : false
		}
		var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
		$('#hmbSummaryGrid').jqxGrid({
			source : dataAdapter_inventory
		});
	//		}
		
		$(".loader").fadeOut("slow");
	});
});