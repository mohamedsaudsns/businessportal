$(window).load(function() {
	$(".loader").fadeOut("slow");
});
$(document).ready(function(e) {
	$('#NewsLetterUpload').addClass("active");
	$("#breadcrumb-ol").append("<li class='breadcrumb-item active'><a href='#'>Letter Pad Upload </a></li>");

	var theme = 'ui-start';


//	
//	$('#newsLetterLanguage').jqxDropDownList({
//		width : '100%',
//		theme : theme,
//		selectedIndex : '-1',
//		height : 25
//	});
	
	$('#newsLetterCountry').jqxDropDownList({
		width : '100%',
		theme : theme,
		selectedIndex : '-1',
		height : 25
	});
	
	$('#newsLetterRegion').jqxDropDownList({
		width : '100%',
		theme : theme,
		selectedIndex : '-1',
		height : 25
	});
	
	$('#itemType').jqxDropDownList({
		width : '100%',
		theme : theme,
		selectedIndex : '-1',
		height : 25
	});

	

    var item_type_options = [
        {"value": "1", "label": "News Letter"},
        {"value": "2", "label": "Circular"}
    ];
    var source_options = {
        datatype: "array",
        datafields: [
            {name: 'value', type: 'string'},
            {name: 'label', type: 'string'}
        ],
        localdata: item_type_options
    };
    var dataAdapter_options = new $.jqx.dataAdapter(source_options);
    
    $('#itemType').jqxDropDownList({
		width : '100%',
		theme : theme,
		selectedIndex : '-1',
		height : 25,
		source : dataAdapter_options,
		valueMember : 'value',
		displayMember : 'label'
	});

    
    
    
	var source_countrieList = {
			datatype : 'json',
			datafields : [ {
				name : 'countryCode',
				type : 'string'
			}, {
				name : 'countryName',
				type : 'string'
			} ],
			async : false,
			url : "getNewsLetterCountryList"
		}
		var dataAdapter_countrieList = new $.jqx.dataAdapter(source_countrieList);
		$('#newsLetterCountry').jqxDropDownList({
			width : '100%',
			theme : theme,
			selectedIndex : '-1',
			height : 25,
			source : dataAdapter_countrieList,
			valueMember : 'countryCode',
			displayMember : 'countryName'
		});
    
    

//	var source_countries = {
//		datatype : 'json',
//		datafields : [ {
//			name : 'regionCode',
//			type : 'string'
//		}, {
//			name : 'regionName',
//			type : 'string'
//		} ],
//		async : false,
//		url : "getNewsLetterRegionList"
//	}
//	var dataAdapter_countries = new $.jqx.dataAdapter(source_countries);
//	$('#newsLetterRegion').jqxDropDownList({
//		width : '100%',
//		theme : theme,
//		selectedIndex : '-1',
//		height : 25,
//		source : dataAdapter_countries,
//		valueMember : 'regionCode',
//		displayMember : 'regionName'
//	});


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


	

//	$('#productListGrid').jqxGrid({
//		width : '100%',
//		height : 500,
//		sortable : true,
//		showfilterrow : true,
//		filterable : true,
//		altrows : true,
//		theme : theme,
//		showaggregates : true,
//		columns : [
//			{
//				text : 'No',
//				dataField : '',
//				columntype : 'number',
//				cellsalign : 'center',
//				width : '10%',
//				align : 'center',
//				cellsrenderer : function(row, column, value) {
//					return "<div style='text-align: center'>" + (value + 1) + "</div>";
//				}
//			},
//
//			{
//				text : 'Language Name',
//				datafield : 'prdName',
//				width : '20%',
//				align : 'center'
//			},
//			{
//				text : 'File Name',
//				datafield : 'fileName',
//				width : '17%',
//				cellsalign : 'center',
//				align : 'center'
//			},
//			{
//				text : 'itemId',
//				datafield : 'itemId',
//				width : '37%',
//				cellsalign : 'center',
//				align : 'center',
//				hidden : true
//			},
//			{
//				text : 'compCode',
//				datafield : 'compCode',
//				width : '37%',
//				cellsalign : 'center',
//				align : 'center',
//				hidden : true
//			},
//			{
//				text : 'departmentId',
//				datafield : 'departmentId',
//				width : '37%',
//				cellsalign : 'center',
//				align : 'center',
//				hidden : true
//			},
//		
//			{
//				text : 'Action',
//				datafield : 'action',
//				width : '15%',
//				cellsalign : 'center',
//				columntype : 'button',
//				align : 'center',
//				cellsrenderer : function() {
//					return 'Delete';
//				},
//				buttonclick : function(row) {
//					var dataRecord = $("#productListGrid").jqxGrid('getrowdata', row);
//				//	alert(dataRecord.itemId);
//					
//					deleteProduct(dataRecord.compCode,dataRecord.itemId,dataRecord.departmentId,dataRecord.prdName)
//					
//				}
//			}
//		]
//	});






});











var delayMillis = 1000;

//
//function getProductList() {
//	var newsLetterLanguage = $('#newsLetterLanguage').val();
//
//	var fields = new Array();
//
//	fields.push({
//		name : 'itemId',
//		type : 'string'
//	}, {
//		name : 'fileName',
//		type : 'string'
//	}, {
//		name : 'prdName',
//		type : 'string'
//	}, {
//		name : 'compCode',
//		type : 'string'
//	}, {
//		name : 'departmentId',
//		type : 'string'
//	},
//		{
//			name : 'fromaDate',
//			type : 'date',
//			format : 'dd/mm/yyyy'
//		}, {
//			name : 'toDate',
//			type : 'date',
//			format : 'dd/mm/yyyy'
//		});
//
//	var source_inventory = {
//		datatype : 'json',
//		datafields : fields,
//		url : 'getProductList?departmentId=' + newsLetterLanguage,
//		async : false
//	}
//	var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
//	$('#productListGrid').jqxGrid({
//		source : dataAdapter_inventory
//	});


//}

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

$('#newsLetterCountry').on('change select', function() {
//	getProductList();
	
	var countryId=$('#newsLetterCountry').val();
	
	var source_countries = {
			datatype : 'json',
			datafields : [ {
				name : 'regionCode',
				type : 'string'
			}, {
				name : 'regionName',
				type : 'string'
			} ],
			async : false,
			url : "getNewsLetterRegionList?countryId="+countryId
		}
		var dataAdapter_countries = new $.jqx.dataAdapter(source_countries);
		$('#newsLetterRegion').jqxDropDownList({
			width : '100%',
		
			selectedIndex : '-1',
			height : 25,
			source : dataAdapter_countries,
			valueMember : 'regionCode',
			displayMember : 'regionName'
		});

});