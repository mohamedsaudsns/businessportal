$(window).load(function() {
	$(".loader").fadeOut("slow");
});
$(document).ready(function(e) {
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';

	$('#AverageMilkMonthAverage').addClass("active");

	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Milk Month Average</a></li>");

	//$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 14px;'><span class="icon icon-double-angle-right"></span> <a href='#'>Hmb Summary</a></li>");


	//	$('#hmbYear').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});

//	$('#hmbYear').jqxDateTimeInput({
//		width : '100%',
//		height : '25px',
//		theme : theme,
//		formatString : 'yyyy',
//		culture : 'ko-KR',
//		showCalendarButton : false
//	});


	


	$('#hmbAvgMilkMonth').jqxGrid({
		width : '100%',
		height : 600,
		altrows : true,
		theme : theme,
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

				var row = $("#hmbAvgMilkMonth").jqxGrid('getselectedrowindex');
				if (row !== -1) {
					var socity = $('#hmbAvgMilkMonth').jqxGrid('getcellvalue', row, 'socity');
					var selectedYear = $('#hmbAvgMilkMonth').jqxGrid('getcellvalue', row, 'selectedyear');
					var selectedMonth = $('#hmbAvgMilkMonth').jqxGrid('getcellvalue', row, 'selectedMonth');
					
					
					var avgmonth = $('#hmbAvgMilkMonth').jqxGrid('getcellvalue', row, 'avgmonth');
					var avgMilk = $('#hmbAvgMilkMonth').jqxGrid('getcellvalue', row, 'avgMilk');
					var avgFat = $('#hmbAvgMilkMonth').jqxGrid('getcellvalue', row, 'avgFat');
					var avgSnf = $('#hmbAvgMilkMonth').jqxGrid('getcellvalue', row, 'avgSnf');

				
					
				

					$('#payemntTable tbody').empty();

				

					$('#hmbSummaryModel').modal('show');
					var dataString = 'socity=' + socity + '&selectedYear=' + selectedYear + '&selectedMonth=' + selectedMonth;

					$('#payemntTable tfoot').empty();
					$('#payemntTable tbody').empty();

					/////      HMB Payment


					$.ajax({
						type : "POST",
						url : "getAverageMilkMonthWiseLi",
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
//									if (item.particulars == null) {
//
//										if (item.holeTotal == 0) {
//
//										} else {
//											eachrow = "<tr>"
//												+ "<td class='table-header_align' colspan='3'> Total  </td>"
//												+ "<td class='table-header_align'> " + item.qtyKg + "  </td>"
//												+ "<td></td>"
//												+ "<td></td>"
//												+ "<td></td>"
//												+ "<td></td>"
//												+ "<td class='table-header-align-right'>" + item.holeTotal + "</td>"
//												//												+ "<td class='table-header-align-right'>" + item.incentiveAmount + "</td>"
//												+ "</tr>";
//											$('#payemntTable tbody').append(eachrow);
//
//										}
								 if (item.milktype == "TOTAL") {


										$("#payementTotalLtrs").text("" + item.qty);
										$("#payementTotalAmount").text("" + item.fat);
									
											$("#payementTotalDeduction").text("" + item.snf);
							
											
									} else {

										var newSDate = "";

										if (item.ssDate == "") {

											newSDate = item.ssDate;
										} else {

											newSDate = dateformat(item.ssDate);
										}


										eachrow = "<tr>"


										
											+ "<td  class='table-header_align'>" + newSDate + " "+item.shift+"</td>"
										

											+ "<td  class='table-header_align'>" + item.qty + "</td>"
											+ "<td  class='table-header_align'>" + item.fat + "</td>"
											+ "<td  class='table-header_align'>" + item.snf + "</td>"

										
										
											+ "</tr>";
										$('#payemntTable tbody').append(eachrow);
									}


									
								})
							})


						},
						dataType : "html"
					});


					$("#hmbAvgMilkMonth").jqxGrid('clearselection');

					



					$(".modal-title").text('Month ( ' + avgmonth +  ' ) Milk Avg ( '+avgMilk+' ) FAT Avg ( ' + avgFat + ' ) SNF Avg ( ' + avgSnf + ' ) ');

				} else {

				}

			});


		},
	
		columns : [
		

			{
				text : 'Month',
				datafield : 'avgmonth',
				width : '40%',
				align : 'center',
				cellsalign : 'center',
		
			},

			{
				text : 'Milk Average  ',
				datafield : 'avgMilk',
				width : '20%',
				cellsalign : 'center',
				align : 'center'
			
			},
			
			
			{
				text : 'FAT Average',
				datafield : 'avgFat',
				width : '20%',
				cellsalign : 'center',
				align : 'center'
			
			},
			
			
			{
				text : 'SNF Average  ',
				datafield : 'avgSnf',
				width : '20%',
				cellsalign : 'center',
				align : 'center'
			
			},
			
			
			
			
			{
				text : 'socity ',
				datafield : 'socity',
				width : '20%',
				cellsalign : 'center',
				align : 'center',
				hidden:true
			
			},
			{
				text : 'selectedyear ',
				datafield : 'selectedyear',
				width : '20%',
				cellsalign : 'center',
				align : 'center',
				hidden:true
			
			},
			{
				text : 'selectedMonth',
				datafield : 'selectedMonth',
				width : '20%',
				cellsalign : 'center',
				align : 'center',
				hidden:true
			
			}
		

			
		]
	});


	



	
	

	$('#getBtn').on("click", function(e) {

		 $(".loader").fadeIn("slow");
		var hmbYear = $('#lastThreeMonthYear').val();

		var fields = new Array();

		fields.push({
			name : 'avgmonth',
			type : 'string'
		}, {
			name : 'avgMilk',
			type : 'string'
	
			},
			{
				name : 'avgFat',
				type : 'string'
		
				},
				{
					name : 'avgSnf',
					type : 'string'
			
					},
				
				{
					name : 'socity',
					type : 'string'
			
					},
				
				{
					name : 'selectedyear',
					type : 'string'
			
					},
					{
						name : 'selectedMonth',
						type : 'string'
				
						}
					
					
				
				
				
				
				
				
				
		
		);

		var source_inventory = {
			datatype : 'json',
			datafields : fields,
			url : 'getAverageMilkMonthWise?selectedYear=' + hmbYear,
			async : false
		}
		var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
		$('#hmbAvgMilkMonth').jqxGrid({
			source : dataAdapter_inventory
		});
		
		
		$(".loader").fadeOut("slow");
		
		
	//		}
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
	
});