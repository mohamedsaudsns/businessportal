$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	$('#CustomerDetails').addClass("active");
	$("#breadcrumb-ol").append("<li class='breadcrumb-item active'><a href='#'>Customer Profile</a></li>");
	
	var theme='ui-start';
	
	
	
	
	$('#customerCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerCity').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerPincode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerMobileNo1').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerMobileNo2').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerGstIn').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerRegion').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerCountry').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerDistrict').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerEmail').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	
	
	
	$('#customerStreetName1').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerStreetName2').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerStreetName3').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerDoorNo').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerPanNo').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	
	
	$('#customerBankName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerAccountNo').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerBranchName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerIfcCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	$('#customerBankCity').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#customerBankCountry').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	
	
		
	loadCustomerData();
	
	
	
});



function loadCustomerData(){
	var source_customer_data = {
			datatype:'json',
			url:'getCustomerData',
			datafields:[{name:'customerName',type:'string'},{name:'customerName2',type:'string'},{name:'address',type:'string'},
			            {name:'city',type:'string'},{name:'pincode',type:'string'},{name:'phoneNo',type:'string'},
			            {name:'region',type:'string'},{name:'country',type:'string'},{name:'customerCode',type:'string'},{name:'regionName',type:'string'},{name:'countryName',type:'string'},
			            {name:'doorNo',type:'string'},{name:'streetName1',type:'string'},{name:'streetName2',type:'string'},{name:'streetName3',type:'string'},{name:'district',type:'string'},
			            {name:'postalCode',type:'string'},{name:'landmark',type:'string'},{name:'mobileNo1',type:'string'},{name:'mobileNo2',type:'string'}
			            ,{name:'panNo',type:'string'},{name:'gstin',type:'string'},{name:'email',type:'string'},{name:'createCapacity',type:'string'}],
			async:false
	}
	var dataAdapter_customer_data = new $.jqx.dataAdapter(source_customer_data,{autoBind:true,loadComplete:function(data){
		if(data.address!="E"){
			$('#customerName').val(data.customerName);
			$('#customerCode').val(data.customerCode);
			
			$('#customerName1').val(data.customerName2);
			$('#customerAddress').val(data.address);
			$('#customerCity').val(data.city);
			$('#customerPincode').val(data.pincode);
			$('#customerCountry').val(data.countryName);

			$('#customerState').val(data.regionName);						
							
		}else{
			
		}
	}});				
}