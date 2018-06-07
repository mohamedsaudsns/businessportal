$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	var getLocalization = function() {
		var localizationobj = {};
		localizationobj.firstDay = 1;
		localizationobj.percentsymbol = "%";
		localizationobj.currencysymbol = " ";
		localizationobj.currencysymbolposition = " ";
		localizationobj.decimalseparator = ".";
		localizationobj.thousandsseparator = "";
		localizationobj.emptydatastring = "No records found! ";
		
		
		return localizationobj;
	};
	
	$('#UserHistory').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Negative Milk Advance Details</a></li>");
	
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> User History</a></li>");
	
	
	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	
	
//	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#entryVendorCode').jqxInput({width:'100%',theme:theme,height:25});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});

	$('#userTrackReportGrid').jqxGrid({
		width:'100%',
		height:500,
		localization : getLocalization(),
		 columnsResize: true,
		 altrows:true,
		theme:theme, 
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',
                cellsrenderer: function (row, column, value) {
                	 return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
    }},
	
    			{text:'Login IP',datafield:'loginIp',width:'33%', align: 'center'},
		         {text:'Login Date',datafield:'loginDate',width:'15%',cellsalign: 'center', align: 'center'},
		         {text:'Login Time',datafield:'loginTime',width:'15%',cellsalign: 'center', align: 'center'},
		         {text:'Logout Date',datafield:'logoutDate',width:'15%',cellsalign: 'center', align: 'center'},
		         {text:'Logout Time',datafield:'logoutTime',width:'15%',cellsalign: 'center',align: 'center'},
		        
		         {text:'User Id',datafield:'userId',width:'10%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'sessionId',datafield:'sessionId',width:'10%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'userTypeId',datafield:'userTypeId',width:'10%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'serverIp',datafield:'serverIp',width:'10%',cellsalign: 'center', align: 'center',hidden:true},
		        
     ]

		        
		
	});



	
	
	$('#getBtn').on("click",function(e){
	var	selected_from_date= $('#from_out_report_date').val();
	var	selected_to_date= $('#to_out_report_date').val();
	var	entryVendorCode= $('#entryVendorCode').val();
	
	 $.getJSON('getVendorDataById?selectedUserId='+entryVendorCode, function (data) {
			if(data.address!="E"){
				$('#vendorName').val(data.vendorName);
				$('#vendorCode').val(data.vendorCode);				
			}
	 });

			var fields= new Array();
			fields.push({name:'sessionId',type:'string'},{name:'userId',type:'string'},{name:'userTypeId',type:'string'},{name:'loginIp',type:'string'},
						{name:'serverIp',type:'string'},{name:'loginDate',type:'string'},{name:'loginTime',type:'string'},{name:'logoutDate',type:'string'},
						{name:'logoutTime',type:'string'});

			var source_inventory = {	
				datatype:'json',
				datafields:fields,
				url:'getUserTrackList?selected_from_date='+selected_from_date+'&selected_to_date='+selected_to_date+'&entryVendorCode='+entryVendorCode,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#userTrackReportGrid').jqxGrid({source:dataAdapter_inventory});
	});
});