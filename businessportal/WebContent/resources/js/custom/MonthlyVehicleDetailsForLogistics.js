$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#MonthlyVehicleDetailsForLogistics').addClass("active");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'	></span> Monthly Vehicle Details</a></li>");
	
	
	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});

	$('#oustandingGrid').jqxGrid({
		width:'100%',
		height:400,
		sortable:true,
//		showfilterrow: true,
//		filterable:true,
//		groupable:true,		
		altrows:true,
		theme:theme,
		selectionmode : 'singlerow',
		columns:[
		         {text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '5%',align: 'center',
		        	 cellsrenderer: function (row, column, value) {
		        		 return "<div style='text-align: center'>" + (value + 1) + "</div>";
		        	 }
		         },		
		         {text:'Vehicle No',datafield:'vehicle',width:'10%',cellsalign: 'center', align: 'center'},
		         {text:'Plant',datafield:'plant',width:'5%',cellsalign: 'center', align: 'center'},
		         {text:'Route',datafield:'routeNo',width:'5%',cellsalign: 'center', align: 'center'},
		         {text:'Bill No',datafield:'billNo',width:'10%',cellsalign: 'center', align: 'center'},
		         {text:'Start Date',datafield:'billStrDate',width:'10%',cellsalign: 'center', align: 'center'},
		         {text:'End Date',datafield:'billEndDate',width:'10%',cellsalign: 'center', align: 'center'},
		         {text:'Init Amount',datafield:'initAmt',hidden:true,align: 'center', cellsalign: 'right'},
		         {text:'Arrear Amount',datafield:'arrearAmt',width:'10%',align: 'center', cellsalign: 'right'},
		         {text:'Deduction Amount',datafield:'deductionAmt',width:'11%',align: 'center', cellsalign: 'right'},
		         {text:'Gross Amount',datafield:'grossAmt',width:'12%',align: 'center', cellsalign: 'right'},
		         {text:'Net Amount',datafield:'netAmt',width:'12%',align: 'center', cellsalign: 'right'}
		],
		showtoolbar : true,		
		toolbarheight : 40,
		rendertoolbar : function(toolbar) {
			var container = $("<div style='overflow: hidden; position: relative; margin: 5px;'></div>");
			var viewButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='resources/vendor-images/icon_eye.png'/><span style='margin-left: 4px; position: relative; top: 2px;'>View</span></div>");
			container.append(viewButton);
			toolbar.append(container);
			viewButton.jqxButton({
				width : 60,
				height : 20,
				theme : theme
			});
			
			viewButton.click(function(event) {
			var row = $("#oustandingGrid").jqxGrid('getselectedrowindex');
			if (row !== -1) {
				var cutOffFromDate = $('#oustandingGrid').jqxGrid('getcellvalue', row, 'billStrDate');
				var cutOffTodate = $('#oustandingGrid').jqxGrid('getcellvalue', row, 'billEndDate');

				var plant = $('#oustandingGrid').jqxGrid('getcellvalue', row, 'plant');
				var routeNo = $('#oustandingGrid').jqxGrid('getcellvalue', row, 'routeNo');

				$('#cutoffM').text(cutOffFromDate +" to "+ cutOffTodate);
				$('#hmbSummaryModel').modal('show');
				var dataString = 'plant=' + plant + '&route=' + routeNo + '&sdate=' + cutOffFromDate+"&edate="+cutOffTodate;

				$('#payemntTable tbody').empty();
				$('#arrearTable tbody').empty();
				$('#deductionTable tbody').empty();
				$.ajax({
					type : "POST",
					url : "getLogisticTransItemDetails",
					data : dataString,
					success : function(response) {
						var json_obj = $.parseJSON(response);
						var paymentTable_data = "",arrearTable_data="",deductionTable_data="";						
						for(var i=0;i<json_obj.length;i++){
							if(json_obj[i].title=="PaymentSummary"){
								eachrow = "<tr>"
									+ "<td  class='table-header_align'>" + json_obj[i].plant + "</td>"
									+ "<td  class='table-header-align-left'>" + json_obj[i].plantName + "</td>"
									+ "<td  class='table-header_align'>" + json_obj[i].route + "</td>"
									+ "<td  class='table-header-align-left'>" + json_obj[i].routeName + "</td>"
									+ "<td  class='table-header_align'>" + json_obj[i].bdate + "</td>"
									+ "<td  class='table-header-align-right'>" + json_obj[i].km + "</td>"
									+ "<td  class='table-header-align-right'>" + json_obj[i].fixed + "</td>"
									+ "<td  class='table-header-align-right'>" + json_obj[i].rate + "</td>"
									+ "<td  class='table-header-align-right'>" + json_obj[i].hire + "</td>"
									+ "<td  class='table-header-align-left'>" + json_obj[i].vehicle + "</td>"
									+ "<td  class='table-header-align-left'>" + json_obj[i].vehicleModel + "</td>"
									+ "</tr>";
								paymentTable_data+=eachrow;
							}
						}
						$('#payemntTable tbody').append(paymentTable_data);
						
						for(var i=0;i<json_obj.length;i++){
							if(json_obj[i].title=="ArrearSummary"){
								eachrow = "<tr>"
									+ "<td  class='table-header-align-left'>" + json_obj[i].bdate + "</td>"
									+ "<td  class='table-header-align-right'>" + json_obj[i].km + "</td>"
									+ "</tr>";
								arrearTable_data+=eachrow;
							}
						}
						$('#arrearTable tbody').append(arrearTable_data);
						
						for(var i=0;i<json_obj.length;i++){
							if(json_obj[i].title=="DeductionSummary"){
								eachrow = "<tr>"
									+ "<td  class='table-header-align-left'>" + json_obj[i].bdate + "</td>"
									+ "<td  class='table-header-align-right'>" + json_obj[i].km + "</td>"
									+ "</tr>";
								deductionTable_data+=eachrow;
							}
						}
						$('#deductionTable tbody').append(deductionTable_data);
						if(json_obj[json_obj.length-1].title=="FinalSummary"){
							$('#netAmount').text(json_obj[json_obj.length-1].km);
						}
					},
					dataType : "html"
				});


				$("#oustandingGrid").jqxGrid('clearselection');
//				$(".modal-title").text('' + farmerName +  ' ( '+farmerCode+' ) ' + dateformat(cutOffFromDate) + ' - ' + dateformat(cutOffTodate) + ' ');
			} else {

			}
		});

		}
	});
	
	$('#getBtn').on("click",function(e){
		
		 $(".loader").fadeIn("slow");
		var from_out_report_date = $('#from_out_report_date').val();
		var	to_out_report_date= $('#to_out_report_date').val();
		var fields= new Array();		
		fields.push({name:'vehicle',type:'string'},{name:'plant',type:'string'},{name:'routeNo',type:'string'},{name:'billNo',type:'string'},
					{name:'initAmt',type:'string'},{name:'billStrDate',type:'string'},{name:'billEndDate',type:'string'},{name:'arrearAmt',type:'string'},
					{name:'deductionAmt',type:'string'},{name:'grossAmt',type:'string'},{name:'netAmt',type:'string'});

		var source_inventory = {
			datatype:'json',
			datafields:fields,
			url:'getMonthlyVehicleDetailsReportForLogistics?selected_from_date='+from_out_report_date+'&selected_to_date='+to_out_report_date,
			async:false
		}
		var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
		$('#oustandingGrid').jqxGrid({source:dataAdapter_inventory});
		
		$(".loader").fadeOut("slow");
	});
});