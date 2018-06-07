$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	$('#VendorDetails').addClass("active");
	$("#breadcrumb-ol").append("<li class='breadcrumb-item active'><a href='#'>Vendor Profile</a></li>");
	
	var theme='ui-start';
	
	
	
	
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName1').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorAddress').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorAddress2').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCity').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorPincode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorPhone').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorGstIn').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorState').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCountry').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	

		
		loadVendorData();
	
	
	
});


function loadVendorData(){
	var source_vendor_data = {
			datatype:'json',
			url:'getVendorData',
			datafields:[{name:'vendorName',type:'string'},{name:'vendorName2',type:'string'},{name:'address',type:'string'},
			            {name:'city',type:'string'},{name:'pincode',type:'string'},{name:'phoneNo',type:'string'},
			            {name:'region',type:'string'},{name:'country',type:'string'},{name:'vendorCode',type:'string'},{name:'regionName',type:'string'},{name:'countryName',type:'string'}
			            ,{name:'noOfCows',type:'string'},{name:'noOfBuffalos',type:'string'},{name:'noOfAnimal',type:'string'}
			            ,{name:'milkProtential',type:'string'},{name:'varAnimals',type:'string'},{name:'noOfHeifer',type:'string'}
			            
			            
			            ],
			async:false
	}
	var dataAdapter_vendor_data = new $.jqx.dataAdapter(source_vendor_data,{autoBind:true,loadComplete:function(data){
		if(data.address!="E"){
			$('#vendorName').val(data.vendorName);
			$('#vendorCode').val(data.vendorCode);
			
			$('#vendorName1').val(data.vendorName2);
			$('#vendorAddress').val(data.address);
			$('#vendorCity').val(data.city);
			$('#vendorPincode').val(data.pincode);
			$('#vendorCountry').val(data.countryName);
		
			$('#vendorState').val(data.regionName);						
							
		}else{
			
		}
	}});				
}