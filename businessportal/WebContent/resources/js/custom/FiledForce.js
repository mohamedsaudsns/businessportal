$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#fieldForceContactNumber').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Field Force</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Field Force</a></li>");

	
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
		         {text:'Designation',datafield:'designation',width:'30%', align: 'center'},
		         {text:'Name',datafield:'empName',width:'23%',align: 'center'},
		         {text:'Mobile No',datafield:'empMobileNo',width:'20%', align: 'center'},
		         {text:'Email Id',datafield:'empEmailId',width:'20%', align: 'center'},
		      
       
     ]
		        
		
	});

	

});