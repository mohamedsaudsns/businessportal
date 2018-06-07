$(window).load(function() {
	$(".loader").fadeOut("slow");
});
$(document).ready(function(e) {
	$('#VendorDetails').addClass("active");
	$("#breadcrumb-ol").append("<li class='breadcrumb-item active'><a href='#'>New Product Upload</a></li>");

	var theme = 'ui-start';


	$('#productFromDate').jqxDateTimeInput({
		width : '100%',
		height : '25',
		theme : theme,
		formatString : 'dd/MM/yyyy'
	});
	$('#productToDate').jqxDateTimeInput({
		width : '100%',
		height : '25',
		theme : theme,
		formatString : 'dd/MM/yyyy'
	});

	$('#productName').jqxInput({
		width : '100%',
		theme : theme,
		height : 25
	});
	$('#productDepartment').jqxDropDownList({
		width : '100%',
		theme : theme,
		selectedIndex : '-1',
		height : 25
	});



	var source_countries = {
		datatype : 'json',
		datafields : [ {
			name : 'departmentId',
			type : 'string'
		}, {
			name : 'departmentName',
			type : 'string'
		} ],
		async : false,
		url : "getDepartmentList"
	}
	var dataAdapter_countries = new $.jqx.dataAdapter(source_countries);
	$('#productDepartment').jqxDropDownList({
		width : '100%',
		theme : theme,
		selectedIndex : '-1',
		height : 25,
		source : dataAdapter_countries,
		valueMember : 'departmentId',
		displayMember : 'departmentName'
	});


	var source_department = {
		datatype : 'json',
		datafields : [ {
			name : 'departmentId',
			type : 'string'
		}, {
			name : 'departmentName',
			type : 'string'
		} ],
		async : false,
		url : "getDepartmentList"
	}
	var dataAdapter_department = new $.jqx.dataAdapter(source_department);


	$('#assignDepartment').jqxGrid({
		width : '100%',
		height : 500,
		altRows : "true",
		source : dataAdapter_department,
		showfilterrow : true,
		filterable : true,
		enabletooltips : true,
		theme : theme,
		selectionmode : 'checkbox',
		columns : [
			{
				text : 'Assign To Department',
				datafield : 'departmentName',
				width : '90%',
				align : 'center'
			},
			{
				text : 'Department Id',
				datafield : 'departmentId',
				hidden : true
			}
		]
	});

	$('#productListGrid').jqxGrid({
		width : '100%',
		height : 500,
		sortable : true,
		showfilterrow : true,
		filterable : true,
		altrows : true,
		theme : theme,
		showaggregates : true,
		columns : [
			{
				text : 'No',
				dataField : '',
				columntype : 'number',
				cellsalign : 'center',
				width : '10%',
				align : 'center',
				cellsrenderer : function(row, column, value) {
					return "<div style='text-align: center'>" + (value + 1) + "</div>";
				}
			},

			{
				text : 'Product Name',
				datafield : 'prdName',
				width : '20%',
				align : 'center'
			},
			{
				text : 'File Name',
				datafield : 'fileName',
				width : '17%',
				cellsalign : 'center',
				align : 'center'
			},
			{
				text : 'itemId',
				datafield : 'itemId',
				width : '37%',
				cellsalign : 'center',
				align : 'center',
				hidden : true
			},
			{
				text : 'compCode',
				datafield : 'compCode',
				width : '37%',
				cellsalign : 'center',
				align : 'center',
				hidden : true
			},
			{
				text : 'departmentId',
				datafield : 'departmentId',
				width : '37%',
				cellsalign : 'center',
				align : 'center',
				hidden : true
			},
			{
				text : 'From Date',
				datafield : 'fromaDate',
				width : '19%',
				cellsalign : 'center',
				align : 'center',
				columntype : 'date',
				cellsformat : 'dd/MM/yyyy'
			},
			{
				text : 'To Date',
				datafield : 'toDate',
				width : '19%',
				cellsalign : 'center',
				align : 'center',
				columntype : 'date',
				cellsformat : 'dd/MM/yyyy'
			},
			{
				text : 'Action',
				datafield : 'action',
				width : '15%',
				cellsalign : 'center',
				columntype : 'button',
				align : 'center',
				cellsrenderer : function() {
					return 'Delete';
				},
				buttonclick : function(row) {
					var dataRecord = $("#productListGrid").jqxGrid('getrowdata', row);
				//	alert(dataRecord.itemId);
					
					deleteProduct(dataRecord.compCode,dataRecord.itemId,dataRecord.departmentId,dataRecord.prdName)
					
				}
			}
		]
	});






});











var delayMillis = 1000;


function getProductList() {
	var productDepartment = $('#productDepartment').val();

	var fields = new Array();

	fields.push({
		name : 'itemId',
		type : 'string'
	}, {
		name : 'fileName',
		type : 'string'
	}, {
		name : 'prdName',
		type : 'string'
	}, {
		name : 'compCode',
		type : 'string'
	}, {
		name : 'departmentId',
		type : 'string'
	},
		{
			name : 'fromaDate',
			type : 'date',
			format : 'dd/mm/yyyy'
		}, {
			name : 'toDate',
			type : 'date',
			format : 'dd/mm/yyyy'
		});

	var source_inventory = {
		datatype : 'json',
		datafields : fields,
		url : 'getProductList?departmentId=' + productDepartment,
		async : false
	}
	var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
	$('#productListGrid').jqxGrid({
		source : dataAdapter_inventory
	});


}

function deleteProduct(compCode,itemId,departmentId,prdName){
$.ajax({
	type : "GET",
		url : "deleteProduct?compCode="+compCode+"&itemId="+itemId+"&departmentId="+departmentId,
	success : function(response) {
		if (response !="E") {
		
			callAlert("green", "Alert", "'"+prdName+"' successfully deleted");
			   $("#productListGrid").jqxGrid('updatebounddata', 'cells');
               $("#productListGrid").jqxGrid('clearselection');
		//	getProductList();
		} else {
			
		}
	},
	error : function(error) {

	}
});

}

$('#productDepartment').on('change select', function() {
	getProductList();

});