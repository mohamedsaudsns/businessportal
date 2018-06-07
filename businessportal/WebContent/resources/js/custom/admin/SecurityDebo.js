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
	
	

	
	
	$('#getBtn').on("click",function(e){
		
		 $(".loader").fadeIn("slow");
//		var from_out_report_date = $('#from_out_report_date').val();
		var from_out_report_date = "";
		
//	var	to_out_report_date= $('#to_out_report_date').val();
	var	to_out_report_date= "";
	
	var	itemType= "Open";

			var fields= new Array();
		
			fields.push({name:'vendorcode',type:'string'},{name:'docNo',type:'string'},{name:'fiYear',type:'string'},{name:'remark',type:'string'},
						{name:'docTypeName',type:'string'},{name:'docDate',type: 'date', format: 'dd/mm/yyyy'},{name:'postingDate',type: 'date', format: 'dd.MM.yyyy'},{name:'amount',type:'string'},{name:'debitAmount',type:'string'},{name:'creditAmount',type:'string'},{name:'db_ind',type:'string'}
						,{name:'0_15',type:'string'},{name:'15_30',type:'string'},{name:'30_45',type:'string'},{name:'vendorName',type:'string'}
						,{name:'rentAmount',type:'string'},{name:'tdsAmount',type:'string'},{name:'netAmount',type:'string'},{name:'securityDepositAmount',type:'number'}
						,{name:'assigment',type:'string'},{name:'vechNO',type:'string'});

			var source_inventory = {
				datatype:'json',
				datafields:fields,
				url:'getSecurityDepositStatusReport?selected_from_date='+from_out_report_date+'&selected_to_date='+to_out_report_date+'&itemType='+itemType,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#oustandingReportGrid').jqxGrid({source:dataAdapter_inventory,
				groups : [ 'vechNO' ],
				});
//		}
			
			
			
//			   $('#example').DataTable( {
//				   "bDestroy": true,
//				   "aaData": testdata,
//				   "columns": [
//		            { "rows": "compCode" },
//		            { "rows": "avgmonth" },
//		            { "rows": "avgMilk" },
//		            { "rows": "avgFat" },
//		            { "rows": "socity" },
//		            { "rows": "selectedyear" }
//		        ]
////				   "bDestroy": true,
//////				   "processing": true,
//////			        "serverSide": true,
////			        "ajax": {
////			            "url": "getAverageMilkMonthWise?selectedYear=2017",
////			            "contentType": "application/json; charset=utf-8",
////			            "dataType": "json",
////			            "dataSrc": "rows"
//////			            "columns": [
//////			                { "rows": "avgmonth" },
//////			                { "rows": "avgMilk" },
//////			                { "rows": "avgFat" },
//////			                { "rows": "avgSnf" },
//////			                { "rows": "socity" },
//////			                { "rows": "selectedyear" }
//////			            ]
////			        }
//			   
//			    } );
			
			$(".loader").fadeOut("slow");
	});
});