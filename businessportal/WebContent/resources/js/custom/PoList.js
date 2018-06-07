$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#PoList').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Purchase Order List</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Purchase Order List</a></li>");
	
	
	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy',maxDate: new Date()});
	$("#from_out_report_date").jqxDateTimeInput('setMinDate', addMonths(new Date(), -6));
	
//	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	


	
	$('#oustandingReportGrid').jqxGrid({
		width:'100%',
		height:500,
		sortable:true,
		
		
		altrows:true,
		theme:theme,
		  showaggregates: true,
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',
                cellsrenderer: function (row, column, value) {
        return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
    }},
		         
		         {text:'PO Number ',datafield:'poNumber',width:'15%',cellsalign: 'center', align: 'center'},
		         {text:'Doc Cat',datafield:'docCat',width:'6%',cellsalign: 'center', align: 'center'},
		         {text:'PO Date',datafield:'docDate',width:'10%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy'},		
		         {text:'Item No ',datafield:'poItemNo',width:'10%',cellsalign: 'center', align: 'center'},
		         {text:'Description',datafield:'shortText',width:'22%', align: 'center'},		
		         
		         {text:'Gross Amount ',datafield:'grossAmount',width:'15%',align: 'center', cellsalign: 'right'},
		         {text:'Net Amount ',datafield:'netAmount',width:'15%',align: 'center', cellsalign: 'right'
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
		var from_out_report_date = $('#from_out_report_date').val();
		
	var	to_out_report_date= $('#to_out_report_date').val();
	var itemType="";

			var fields= new Array();
		
			fields.push({name:'poNumber',type:'string'},{name:'poItemNo',type:'string'},{name:'docCat',type:'string'},{name:'shortText',type:'string'},
						{name:'grossAmount',type:'string'},{name:'docDate',type: 'date', format: 'dd/mm/yyyy'},{name:'netAmount',type:'string'}
						
		);

			var source_inventory = {
				datatype:'json',
				datafields:fields,
				url:'getPoListReport?selected_from_date='+from_out_report_date+'&selected_to_date='+to_out_report_date+'&itemType='+itemType,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#oustandingReportGrid').jqxGrid({source:dataAdapter_inventory});
//		}
	});
	
	function addMonths(date, months) {
		  date.setMonth(date.getMonth() + months);
		  return date;
		}
});