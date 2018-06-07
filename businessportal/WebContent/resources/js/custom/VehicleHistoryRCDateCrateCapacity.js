$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#VehicleHistoryRCDateCrateCapacity').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Vehicle History RC Date CrateCapacity</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-arrow-right'></span> Vehicle History RC Date CrateCapacity</a></li>");
	
	
//	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
//	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	
	
//	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	
	
//	 var item_type = [
//	        {value: "All", label: "All"},
//	        {value: "Open", label: "Open Item"}
//	    ];
//
//	    $("#itemType").jqxDropDownList({source: item_type, selectedIndex: 0, width: "65%",
//			height : '25',  dropDownHeight: 100});

	

	
	$('#oustandingReportGrid').jqxGrid({
		width:'100%',
		height:500,
		sortable:true,
		showfilterrow: true,
		filterable:true,
		groupable:true,
		
		altrows:true,
		theme:theme,
		  showaggregates: true,
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',
                cellsrenderer: function (row, column, value) {
        return "<div style='text-align: center'>" + (value + 1) + "</div>";
    }},
//		{text:'Date',datafield:'postingDate',width:'12%',cellsalign: 'center', align: 'center',columntype: 'date'},
		         {text:'Truck No',datafield:'truckNo',width:'10%',cellsalign: 'center', align: 'center'},
		         {text:'Name',datafield:'name',width:'20%',cellsalign: 'center', align: 'center'},
		         {text:'Permit Status',datafield:'permitStatus',width:'10%',cellsalign: 'center'},
		         {text:'Rc Date',datafield:'rcDate',width:'15%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',},
		         {text:'Crate Capacity ',datafield:'crateCapacity',width:'18%',cellsalign: 'right', align: 'center'},		
		         {text:'Diesel Card Number',datafield:'dieselCardNumber',width:'21%', align: 'center',cellsalign: 'center'},		
		   
       
     ]

		        
		
	});


	
	
	
	var cellsrenderer = function (row, column, value, defaultHtml) {
		var totalDuration = $('#oustandingReportGrid').jqxGrid('getcellvalue',row,'totalDuration');
		totalDuration = parseInt(totalDuration);
		if(value!=''){
			var percent = (parseInt(value)/totalDuration)*100;
			if(parseFloat(percent)<0){
				var element = $(defaultHtml);
	            element.css('color', '#FF0000');
	            return element[0].outerHTML;
			}else if(parseFloat(percent)>0 && parseFloat(percent)<=50){
				var element = $(defaultHtml);
	            element.css('color', '#0000A0');
	            return element[0].outerHTML;
			}else if(parseFloat(percent)>50 && parseFloat(percent)<=100){
				var element = $(defaultHtml);
	            element.css('color', '#00FF00');
	            return element[0].outerHTML;
			}
		}
        return defaultHtml;
    }
	
	
	
	
	
	
	
	
	
	$('#getBtn').on("click",function(e){
//		var from_out_report_date = $('#from_out_report_date').val();
//		
//	var	to_out_report_date= $('#to_out_report_date').val();
		
		var from_out_report_date ="";
		
		var	to_out_report_date= "";
	
	var	itemType= "ALL";

			var fields= new Array();
		
			fields.push({name:'truckNo',type:'string'},{name:'name',type:'string'},{name:'permitStatus',type:'string'},{name:'crateCapacity',type:'string'},
						{name:'rcDate',type: 'date', format: 'dd/mm/yyyy'},{name:'dieselCardNumber',type:'string'});

			var source_inventory = {
				datatype:'json',
				datafields:fields,
				url:'getVendorVehicleReport?selected_from_date='+from_out_report_date+'&selected_to_date='+to_out_report_date+'&itemType='+itemType,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#oustandingReportGrid').jqxGrid({source:dataAdapter_inventory});
//		}
	});
});