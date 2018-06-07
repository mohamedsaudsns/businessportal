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
	
//	$("#example").DataTable();
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#SecurityDepositStatus').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Security Deposit Status</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Security Deposit Status</a></li>");
	
	
//	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
//	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	
	
//	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});

	$('#oustandingReportGrid').jqxGrid({
		width:'100%',
		height:500,
		sortable:true,
		
		groupable : true,
		groups : [ 'vechNO' ],
		groupsexpandedbydefault : true,
		showgroupaggregates : true,
		filterable:true,
		 columnsResize: true,
		localization : getLocalization(),
		altrows:true,
		theme:theme,
		showaggregates: true,
		showstatusbar: true,
        statusbarheight: 30,
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',hidden:true,
                cellsrenderer: function (row, column, value) {
        return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
    }},
		{text:'Date',datafield:'postingDate',width:'12%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',},
		         {text:'Vendor Code',datafield:'vendorcode',width:'10%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'Vendor Name',datafield:'vendorName',width:'20%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'Vehicle No',datafield:'vechNO',width:'10%',cellsalign: 'center', align: 'center'},
		         {text:'Assigment',datafield:'assigment',width:'14%',cellsalign: 'center', align: 'center'},
		         {text:'Reference No',datafield:'docNo',width:'12%',cellsalign: 'center', align: 'center'},
		         {text:'Year',datafield:'fiYear',width:'8%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'Doc Type',datafield:'docTypeName',width:'18%', align: 'center',hidden:true},		
		         {text:'Remark',datafield:'remark',width:'36%', align: 'center'},		
		         {text:'Doc Date',datafield:'docDate',width:'10%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',hidden:true},		         
		         {text:'Debit ',datafield:'debitAmount',width:'11%',align: 'center', cellsalign: 'right',hidden:true},	
		         {text:'Credit ',datafield:'creditAmount',width:'11%',align: 'center', cellsalign: 'right',hidden:true},
		       
		         {text:'Amount',datafield:'securityDepositAmount',width:'16%',align: 'center', cellsalign: 'right',cellsformat: 'c2'
		        	 , aggregates: ['sum']},		
		         {text:'TDS Amount ',datafield:'tdsAmount',width:'13%',align: 'center', cellsalign: 'right',hidden:true},	
		         {text:'Net Amount ',datafield:'netAmount',width:'13%',align: 'center', cellsalign: 'right',hidden:true},
		         {text:'Amount ',datafield:'amount',width:'19%',align: 'center', cellsalign: 'right',hidden:true
       }
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
	
	

	
	
	
});