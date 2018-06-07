$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#ComparisionStatement').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Negative Milk Advance Details</a></li>");
	
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'  ></span> Comparision Statement</a></li>");
	
	
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
		
		         {text:'Date & Shift',datafield:'ssDate',width:'10%', align: 'center',cellsalign: 'center'},
		         {text:'Center Milk Ltrs',datafield:'quantity',width:'9%', align: 'center',cellsalign: 'right'},
		         {text:'Center Kg FAT',datafield:'ckgfat',width:'9%',cellsalign: 'right', align: 'center'},
		         {text:'Center Kg SNF',datafield:'ckgsnf',width:'9%', align: 'center',cellsalign: 'right'},
		        {text:'Center FAT %',datafield:'fat',width:'8%', align: 'center',	cellsalign: 'right'},		
		         {text:'Center SNF %',datafield:'snf',width:'8%', align: 'center',cellsalign: 'right'},	
		         
		         {text:'Dairy Milk Ltrs',datafield:'erfmgLtr',width:'9%', align: 'center',cellsalign: 'right'},
		         {text:'Dairy Kg FAT',datafield:'dkgfat',width:'9%',cellsalign: 'right', align: 'center'},
		         {text:'Dairy Kg SNF',datafield:'dkgsnf',width:'9%', align: 'center',cellsalign: 'right'},
		        {text:'Dairy FAT %',datafield:'fatN',width:'8%', align: 'center',	cellsalign: 'right'},		
		         {text:'Dairy SNF %',datafield:'snfN',width:'8%', align: 'center',cellsalign: 'right'},	
		         
		         
		         {text:'Shortage Milk Ltrs',datafield:'erfmgLtrS',width:'10%', align: 'center',cellsalign: 'right'},
		         {text:'Shortage Kg FAT',datafield:'ckgfatS',width:'10%',cellsalign: 'right', align: 'center'},
		         {text:'Shortage Kg SNF',datafield:'ckgsnfS',width:'10%', align: 'center',cellsalign: 'right'},
		        {text:'Shortage FAT %',datafield:'fatS',width:'10%', align: 'center',	cellsalign: 'right'},		
		         {text:'Shortage SNF %',datafield:'snfS',width:'10%', align: 'center',cellsalign: 'right'},	
		         
		         
		         {text:'Excess Milk Ltrs',datafield:'erfmgLtrE',width:'10%', align: 'center',cellsalign: 'right'},
		         {text:'Excess Kg FAT',datafield:'ckgfatE',width:'10%',cellsalign: 'right', align: 'center'},
		         {text:'Excess Kg SNF',datafield:'ckgsnfE',width:'10%', align: 'center',cellsalign: 'right'},
		        {text:'Excess FAT %',datafield:'fatE',width:'10%', align: 'center',	cellsalign: 'right'},		
		         {text:'Excess SNF %',datafield:'snfE',width:'10%', align: 'center',cellsalign: 'right'
	
		        
       }
     ]

		        
		
	});


	
	
	$('#getBtn').on("click",function(e){
		var from_out_report_date = $('#from_out_report_date').val();
		
	var	to_out_report_date= $('#to_out_report_date').val();
	
	var	itemType= "Open";

			var fields= new Array();
		
			fields.push({name:'ssDate',type:'string'},{name:'quantity',type:'string'},{name:'ckgfat',type:'string'},{name:'ckgsnf',type:'string'},
						{name:'fat',type:'string'},{name:'snf',type:'string'},{name:'erfmgLtr',type:'string'},{name:'dkgfat',type:'string'},{name:'dkgsnf',type:'string'}
						,{name:'fatN',type:'string'},{name:'snfN',type:'string'},{name:'erfmgLtrS',type:'string'},{name:'ckgfatS',type:'string'},{name:'ckgsnfS',type:'string'}
						,{name:'fatS',type:'string'},{name:'snfS',type:'string'},{name:'erfmgLtrE',type:'string'},{name:'ckgfatE',type:'string'},{name:'ckgsnfE',type:'string'}
						,{name:'fatE',type:'string'},{name:'snfE',type:'string'});

			var source_inventory = {
				datatype:'json',
				datafields:fields,
				url:'getComparisionStatementReport?selected_from_date='+from_out_report_date+'&selected_to_date='+to_out_report_date,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#comparisionStatementGrid').jqxGrid({source:dataAdapter_inventory});
//		}
	});
});