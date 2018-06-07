$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#DataPending').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Negative Milk Advance Details</a></li>");
	
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'  ></span> Data Pending</a></li>");
	
	
	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy'});
	
	
//	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});

	$('#dataPendingGrid').jqxGrid({
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
		
		         {text:'Plant code',datafield:'plantCode',width:'10%', align: 'center',hidden:true},
		         {text:'Plant Name',datafield:'plantName',width:'21%', align: 'center'},
		         {text:'Socity',datafield:'socity',width:'25%',cellsalign: 'center', align: 'center',hidden:true},
		         {text:'Socity Name',datafield:'socityName',width:'22%', align: 'center'},
		         {text:'Date',datafield:'entryDate',width:'12%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy'},
		         
		         {text:'Shift',datafield:'shiftName',width:'7%', align: 'center',	cellsalign: 'center'},		
		         {text:'HMB Qty',datafield:'hmbQty',width:'7%', align: 'center',cellsalign: 'right'},			        
		         {text:'Reception Qty ',datafield:'receptionQty',width:'12%',align: 'center', cellsalign: 'right'},
		         {text:'Difference ',datafield:'different',width:'12%',align: 'center', cellsalign: 'right'
       }
     ]

		        
		
	});


	
	
	$('#getBtn').on("click",function(e){
		var from_out_report_date = $('#from_out_report_date').val();
		
	var	to_out_report_date= $('#to_out_report_date').val();
	
	var	itemType= "Open";

			var fields= new Array();
		
			fields.push({name:'plantCode',type:'string'},{name:'plantName',type:'string'},{name:'socity',type:'string'},{name:'socityName',type:'string'},
						{name:'socity',type:'string'},{name:'entryDate',type:'string'},{name:'shiftName',type:'string'},{name:'hmbQty',type:'string'},{name:'receptionQty',type:'string'}
						,{name:'different',type:'string'});

			var source_inventory = {
				datatype:'json',
				datafields:fields,
				url:'getCcHmbCompareReport?selected_from_date='+from_out_report_date+'&selected_to_date='+to_out_report_date,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#dataPendingGrid').jqxGrid({source:dataAdapter_inventory});
//		}
	});
});