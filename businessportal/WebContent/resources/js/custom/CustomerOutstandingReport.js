$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#CustomerOutstandingReport').addClass("active");
	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Account Receivable Report</a></li>");
	
	
	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	
	
	
	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	
	
	

	

	
	$('#customerOustandingReportGrid').jqxGrid({
		width:'100%',
		height:600,
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
		{text:'Date',datafield:'postingDate',width:'8%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',},
		         {text:'Vendor Code',datafield:'customerCode',width:'10%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'Vendor Name',datafield:'customerName',width:'20%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'Reference No',datafield:'docNo',width:'8%',cellsalign: 'center', align: 'center'},
		         {text:'Year',datafield:'fiYear',width:'6%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'Doc Type',datafield:'docTypeName',width:'16%', align: 'center'},		         
		         {text:'Doc Date',datafield:'docDate',width:'10%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',hidden:true},		         
		         {text:'Remark',datafield:'remark',width:'35%', align: 'center'},	
		         {text:'Credit ',datafield:'creditAmount',width:'13%',align: 'center', cellsalign: 'right'},
		         {text:'Debit ',datafield:'debitAmount',width:'13%',align: 'center', cellsalign: 'right'},
		        
		         {text:'Amount ',datafield:'amount',width:'12%',align: 'center', cellsalign: 'right',hidden:true
       }
     ]

		        
		
	});


	
	
	
	var cellsrenderer = function (row, column, value, defaultHtml) {
		var totalDuration = $('#customerOustandingReportGrid').jqxGrid('getcellvalue',row,'totalDuration');
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
		var out_report_date = $('#from_out_report_date').val();
		var selected_to_date = $('#to_out_report_date').val();
		var itemType="ALL";
		
			var fields= new Array();

			fields.push({name:'customerCode',type:'string'},{name:'docNo',type:'string'},{name:'fiYear',type:'string'},
						{name:'docTypeName',type:'string'},{name:'docDate',type: 'date', format: 'dd/mm/yyyy'},{name:'postingDate',type: 'date', format: 'dd.MM.yyyy'},{name:'amount',type:'string'},{name:'debitAmount',type:'string'},{name:'creditAmount',type:'string'},{name:'db_ind',type:'string'}
						,{name:'0_15',type:'string'},{name:'15_30',type:'string'},{name:'30_45',type:'string'},{name:'customerName',type:'string'});

			var source_inventory = {
				datatype:'json',
				datafields:fields,
				url:'getCustomerOutstandingReport?selected_date='+out_report_date+'&selected_to_date='+selected_to_date+'&itemType='+itemType,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#customerOustandingReportGrid').jqxGrid({source:dataAdapter_inventory});
//		}
	});
});