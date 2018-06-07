$(window).load(function() {
    $(".loader").fadeOut("slow");
});
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
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#TransporterPayment').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Security Deposit Status</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Payment Details</a></li>");
	
	
	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	
	
//	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});

	$('#oustandingReportGrid').jqxGrid({
		width:'100%',
		height:600,
		sortable:true,
		 columnsResize: true,
		filterable:true,
		
		localization : getLocalization(),
		altrows:true,
		theme:theme,
		showaggregates: true,
		showstatusbar: true,
        statusbarheight: 30,
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',
                cellsrenderer: function (row, column, value) {
        return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
    }},
		{text:'Date',datafield:'docDate',width:'12%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',},
		  {text:'Year',datafield:'fiYear',width:'7%',cellsalign: 'center', align: 'center',hidden:true},    
		       
		         {text:'Assigment',datafield:'assigment',width:'13%', align: 'center'},
		         {text:'Reference No',datafield:'docNo',width:'12%', align: 'center'},
		         {text:'Remark',datafield:'itemText',width:'30%', align: 'center'},		
		         {text:'Credit / Debit ',datafield:'db_ind',width:'11%',align: 'center', cellsalign: 'center'},	
		         {text:'Amount',datafield:'amount',width:'15%',align: 'center', cellsalign: 'right',cellsformat: 'c2'
		        	 , aggregates: ['sum']
		       
		     
       }
     ]

		        
		
	});



	

	
	
	$('#getBtn').on("click",function(e){
		 $(".loader").fadeIn("slow");
		
		var from_out_report_date = $('#from_out_report_date').val();
		
	var	to_out_report_date= $('#to_out_report_date').val();
	
	var	itemType= "Open";

			var fields= new Array();
		
			fields.push({name:'docNo',type:'string'},{name:'fiYear',type:'string'},{name:'itemText',type:'string'},
						{name:'docTypeName',type:'string'},{name:'docDate',type: 'date', format: 'dd/mm/yyyy'},{name:'amount',type:'string'},{name:'db_ind',type:'string'}
						,{name:'amount',type:'number'}
						,{name:'assigment',type:'string'});

			var source_inventory = {
				datatype:'json',
				datafields:fields,
				url:'getTransporterPayment?selected_from_date='+from_out_report_date+'&selected_to_date='+to_out_report_date+'&itemType='+itemType,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#oustandingReportGrid').jqxGrid({source:dataAdapter_inventory});
			$(".loader").fadeOut("slow");
//		}
	});
});