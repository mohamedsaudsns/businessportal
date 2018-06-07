$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#hmbFiledForceStaff').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Field Force</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Field Force Staff</a></li>");

	
	$('#filedForceGrid').jqxGrid({
		width:'100%',
		height:600,
		sortable:true,
	
		
		altrows:true,
		theme:theme,
		
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',
                cellsrenderer: function (row, column, value) {
        return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
    }},
		         
		         {text:'Plant Name',datafield:'plantName',width:'20%',align: 'center'},
		       
		         {text:'HMB Name',datafield:'hmbName',width:'20%', align: 'center'},
		         {text:'Designation',datafield:'designationtype',width:'12%', align: 'center'},
		         {text:'Name',datafield:'vendorName',width:'26%', align: 'center'},
		         {text:'Mobile No',datafield:'vendorMobileNo',width:'15%',cellsalign: 'center', align: 'center'},
		         
		         
		         {text:'Plant Code',datafield:'plantCode',width:'30%', align: 'center',hidden:true},
		         
		         {text:'Designation',datafield:'designation',width:'20%', align: 'center',hidden:true},
		          {text:'Hmb',datafield:'Hmb',width:'20%', align: 'center',hidden:true},
		         {text:'Designation Level',datafield:'designationLevel',width:'20%', align: 'center',hidden:true},
		       
		         {text:'Vendor',datafield:'vendor',width:'25%', align: 'center',hidden:true}
		      
		         

       
     ]
		        
		
	});

	

});