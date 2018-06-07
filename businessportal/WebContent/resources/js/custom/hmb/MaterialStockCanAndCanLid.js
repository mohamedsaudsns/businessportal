$(window).load(function() {
	$(".loader").fadeOut("slow");
});
$(document).ready(function(e) {
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';

	$('#MaterialStockCanAndCanLid').addClass("active");

	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Material Stock </a></li>");

	//$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 14px;'><span class="icon icon-double-angle-right"></span> <a href='#'>Hmb Summary</a></li>");






	$('#materialStockGrid').jqxGrid({
		width : '100%',
		height : 300,
		altrows : true,
		theme : theme,
		showtoolbar : true,
		rendertoolbar : function(toolbar) {
			var me = this;
			var container = $("<div style='margin: 5px;'></div>");
			var viewButton = $("<div style='float: right; margin-left: 5px;'> <img style='position: relative; margin-top: 2px;' src='resources/vendor-images/icon_eye.png'/></div>");
var heading=$("<div style='margin: 10px;color: #fefefe;'>Can Material Stock</div>");

			toolbar.append(container);
			toolbar.append(heading);
		
		},

		columns : [


			{
				text : 'Material Code',
				datafield : 'materialCode',
				width : '30%',
				cellsalign : 'center',
				align : 'center',
				
			},
			{
				text : 'Material Name',
				datafield : 'materialName',
				width : '50%',

				align : 'center',
				
			},



			{
				text : 'Quantity',
				datafield : 'quantity',
				width : '20%',
				cellsalign : 'center',
				align : 'center',
				
				
			},
			
		]
	});
	
	
	$('#ekoMaterialStockGrid').jqxGrid({
		width : '100%',
		height : 400,
		altrows : true,
		theme : theme,
		showtoolbar : true,
		rendertoolbar : function(toolbar) {
			var me = this;
			var container = $("<div style='margin: 5px;'></div>");
			var viewButton = $("<div style='float: right; margin-left: 5px;'> <img style='position: relative; margin-top: 2px;' src='resources/vendor-images/icon_eye.png'/></div>");
var heading=$("<div style='margin: 10px;color: #fefefe;'>Eko Material Stock</div>");

			toolbar.append(container);
			toolbar.append(heading);
		
		},

		columns : [
			{
				text : 'Equipment',
				datafield : 'equipment',
				width : '30%',
				cellsalign : 'center',
				align : 'center',
				hidden:true
			
				
				
			},

			{
				text : 'Equipment Description',
				datafield : 'equipmentDescription',
				width : '65%',
			
				align : 'center',
				
			},
			{
				text : 'Inventory Number',
				datafield : 'inventoryNumber',
				width : '35%',
				cellsalign : 'center',
				align : 'center',
				
				
			},



			{
				text : 'plant',
				datafield : 'plant',
				width : '20%',
				cellsalign : 'center',
				align : 'center',
				hidden:true
				
				
			},
			
			{
				text : 'roomNumber',
				datafield : 'roomNumber',
				width : '20%',
				cellsalign : 'center',
				align : 'center',
				hidden:true
				
				
			}
			
			
		]
	});

	loadStockData();



	
});

function loadStockData(){

	var fields = new Array();

	fields.push({
		name : 'compCode',
		type : 'string'
	}, {
		name : 'materialCode',
		type : 'string'
	}, {
		name : 'materialName',
		type : 'string'
	}, {
		name : 'quantity',
		type : 'string'
	}
		);

	var source_inventory = {
		datatype : 'json',
		datafields : fields,
		url : 'getMaterialStock',
		async : false
	}
	var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
	$('#materialStockGrid').jqxGrid({
		source : dataAdapter_inventory
	});
	
	var ekofields = new Array();

	ekofields.push({
		name : 'equipmentDescription',
		type : 'string'
	}, {
		name : 'inventoryNumber',
		type : 'string'
	}, {
		name : 'plant',
		type : 'string'
	}, {
		name : 'equipment',
		type : 'string'
	},
	{
		name : 'roomNumber',
		type : 'string'
	}
	
	
		);

	var source_eko_material = {
		datatype : 'json',
		datafields : ekofields,
		url : 'getEkoMaterialStock',
		async : false
	}
	var dataAdapter_eko_material = new $.jqx.dataAdapter(source_eko_material);
	$('#ekoMaterialStockGrid').jqxGrid({
		source : dataAdapter_eko_material
	});

}