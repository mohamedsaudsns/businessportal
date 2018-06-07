$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#TsRecovery').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Negative Milk Advance Details</a></li>");
	
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'  ></span> Ts Recovery</a></li>");
	
	
	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	
	
//	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});

	$('#comparisionStatementGrid').jqxGrid({
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
    
    {text:'Plant',datafield:'plantCode',width:'10%', align: 'center',cellsalign: 'center'},
    {text:'Center',datafield:'hmb',width:'10%', align: 'center',cellsalign: 'center'},
    {text:'Center Name',datafield:'hmbName',width:'10%', align: 'center',cellsalign: 'center'},
		         {text:'Dairy Milk Qty',datafield:'sumLtCenter',width:'10%', align: 'center',cellsalign: 'center'},
		         {text:'Center Milk Qty',datafield:'sumLtScan',width:'9%', align: 'center',cellsalign: 'right'},
		         {text:'Diff Milk Qty',datafield:'diffLt',width:'9%',cellsalign: 'right', align: 'center'},
		         {text:'Dairy FAT Kgs',datafield:'sumKgFatCenter',width:'9%', align: 'center',cellsalign: 'right'},
		        {text:'Dairy SNF Kgs',datafield:'sumKgSnfCenter',width:'8%', align: 'center',	cellsalign: 'right'},		
		         {text:'Center FAT Kgs',datafield:'sumKgFatScan',width:'8%', align: 'center',cellsalign: 'right'},	
		         {text:'Center SNF Kgs',datafield:'sumKgSnfScan',width:'8%', align: 'center',	cellsalign: 'right'},
		         
		         {text:'Diff Milk %',datafield:'diffPer',width:'9%', align: 'center',cellsalign: 'right'},
		         {text:'Diff FAT Kgs',datafield:'diffSumKgFat',width:'9%',cellsalign: 'right', align: 'center'},
		         {text:'Diff SNF Kgs',datafield:'diffSumKgSnf',width:'9%', align: 'center',cellsalign: 'right'},
		        {text:'Ts',datafield:'totalSolid',width:'8%', align: 'center',	cellsalign: 'right'},		
		         {text:'Milk Excess / Shortage Amt',datafield:'amtDiffScanQtyLtr',width:'8%', align: 'center',cellsalign: 'right'},	
		         
		         
		         {text:'TS Excess / Shortage Amt',datafield:'totalSolidAmt',width:'10%', align: 'center',cellsalign: 'right'},
		         {text:'Total Amount',datafield:'totalTs',width:'10%',cellsalign: 'right', align: 'center'},
		         {text:'Sample Amount',datafield:'samMilk',width:'10%', align: 'center',cellsalign: 'right'},
		        {text:'Final Milk Shortage Amt',datafield:'fmilkShAmt',width:'10%', align: 'center',	cellsalign: 'right'},		
		         {text:'Final TS Shortage Amt',datafield:'ftsShAmt',width:'10%', align: 'center',cellsalign: 'right'},	
		         
		         
		         {text:'Total Ded Amount',datafield:'totalDed',width:'10%', align: 'center',cellsalign: 'right'},
		         {text:'From Date',datafield:'dateFrm',width:'10%',cellsalign: 'right', align: 'center'},
		         {text:'To Date',datafield:'dateTo',width:'10%', align: 'center',cellsalign: 'right'},
		        {text:'RDE Name',datafield:'rdeName',width:'10%', align: 'center',	cellsalign: 'right'},		
		         {text:'ARDOCC Name',datafield:'ardoccName',width:'10%', align: 'center',cellsalign: 'right'  },
		         {text:' RDOCC Name',datafield:'rdoccName',width:'10%', align: 'center',cellsalign: 'right'
		        	
		        
       }
     ]

		        
		
	});


	
	
	$('#getBtn').on("click",function(e){
		var from_out_report_date = $('#from_out_report_date').val();
		
	var	to_out_report_date= $('#to_out_report_date').val();
	
	var	itemType= "Open";

			var fields= new Array();
		
			fields.push({name:'plantCode',type:'string'},{name:'hmb',type:'string'},{name:'hmbName',type:'string'},{name:'sumLtScan',type:'string'},{name:'sumLtCenter',type:'string'},{name:'diffLt',type:'string'},{name:'sumKgFatCenter',type:'string'},
						{name:'sumKgSnfCenter',type:'string'},{name:'sumKgFatScan',type:'string'},{name:'sumKgSnfScan',type:'string'},{name:'diffPer',type:'string'},{name:'diffSumKgFat',type:'string'}
						,{name:'diffSumKgSnf',type:'string'},{name:'totalSolid',type:'string'},{name:'amtDiffScanQtyLtr',type:'string'},{name:'totalTs',type:'string'},{name:'samMilk',type:'string'}
						,{name:'fmilkShAmt',type:'string'},{name:'ftsShAmt',type:'string'},{name:'totalDed',type:'string'},{name:'dateFrm',type:'string'},{name:'dateTo',type:'string'}
						,{name:'rdeName',type:'string'},{name:'ardoccName',type:'string'},{name:'rdoccName',type:'string'});

			var source_inventory = {
				datatype:'json',
				datafields:fields,
				url:'getTsRecoveryReport?selected_from_date='+from_out_report_date+'&selected_to_date='+to_out_report_date,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#comparisionStatementGrid').jqxGrid({source:dataAdapter_inventory});
//		}
	});
});