$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#monthlyRentalPaymentStatuswithBreakup').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Monthly Rental Payment Status with Breakup</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'	></span> Monthly Rental Payment Status with Breakup</a></li>");
	
	
	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	
	
//	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	
	
	 var item_type = [
	        {value: "All", label: "All"},
	        {value: "Open", label: "Open Item"}
	    ];

	    $("#itemType").jqxDropDownList({source: item_type, selectedIndex: 0, width: "65%",
			height : '25',  dropDownHeight: 100});

	

	
	$('#oustandingReportGrid').jqxGrid({
		width:'100%',
		height:500,
		
		altrows:true,
		theme:theme,
		  showaggregates: true,
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',
                cellsrenderer: function (row, column, value) {
                	return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
    }},
		{text:'Date',datafield:'postingDate',width:'12%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',},
		         {text:'Vendor Code',datafield:'vendorcode',width:'10%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'Vendor Name',datafield:'vendorName',width:'20%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'Reference No',datafield:'docNo',width:'15%',cellsalign: 'center', align: 'center'},
		         {text:'Year',datafield:'fiYear',width:'6%',cellsalign: 'center', align: 'center'},
		         {text:'Doc Type',datafield:'docTypeName',width:'18%', align: 'center',hidden:true},		
		         {text:'Remark',datafield:'remark',width:'21%', align: 'center'},		
		         {text:'Doc Date',datafield:'docDate',width:'10%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',hidden:true},		         
		         {text:'Debit ',datafield:'debitAmount',width:'11%',align: 'center', cellsalign: 'right',hidden:true},	
		         {text:'Credit ',datafield:'creditAmount',width:'11%',align: 'center', cellsalign: 'right',hidden:true},
		         {text:'Rent Amount',datafield:'rentAmount',width:'13%',align: 'center', cellsalign: 'right'},		
		         {text:'TDS Amount ',datafield:'tdsAmount',width:'13%',align: 'center', cellsalign: 'right'},	
		         {text:'Net Amount ',datafield:'netAmount',width:'13%',align: 'center', cellsalign: 'right'},
		         
		         
		       	
		         {text:'Amount ',datafield:'amount',width:'18%',align: 'center', cellsalign: 'right',hidden:true
       }
     ]
//		         {text:'Cr / Dr',datafield:'db_ind',width:'5%',cellsalign: 'center', align: 'center'},
//		         {text:'0 - 15',datafield:'to15',width:'10%',cellsalign: 'right', align: 'center'},
//		         {text:'15 - 30',datafield:'to30',width:'10%',cellsalign: 'right', align: 'center'},
//		         {text:'30 - 45',datafield:'to45',width:'10%',cellsalign: 'right', align: 'center'},
		        
		
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
		var from_out_report_date = $('#from_out_report_date').val();
		
	var	to_out_report_date= $('#to_out_report_date').val();
	
	var	itemType= $('#itemType').val();

			var fields= new Array();
		
			fields.push({name:'vendorcode',type:'string'},{name:'docNo',type:'string'},{name:'fiYear',type:'string'},{name:'remark',type:'string'},
						{name:'docTypeName',type:'string'},{name:'docDate',type: 'date', format: 'dd/mm/yyyy'},{name:'postingDate',type: 'date', format: 'dd.MM.yyyy'},{name:'amount',type:'string'},{name:'debitAmount',type:'string'},{name:'creditAmount',type:'string'},{name:'db_ind',type:'string'}
						,{name:'0_15',type:'string'},{name:'15_30',type:'string'},{name:'30_45',type:'string'},{name:'vendorName',type:'string'}
						,{name:'rentAmount',type:'string'},{name:'tdsAmount',type:'string'},{name:'netAmount',type:'string'});

			var source_inventory = {
				datatype:'json',
				datafields:fields,
				url:'getMonthlyRentalPaymentReport?selected_from_date='+from_out_report_date+'&selected_to_date='+to_out_report_date+'&itemType='+itemType,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#oustandingReportGrid').jqxGrid({source:dataAdapter_inventory});
//		}
	});
});