$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	$('#FarmerVendorProfile').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active'><a href='#'><span class="fa fa-arrow-right">Vendor Profile</span></a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Vendor Profile</a></li>");
	var theme='ui-start';
	
	
	
	
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#age').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#vendorAddress').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#vendorAddress2').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCity').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorPincode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#mobileNo1').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#mobileNo2').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorGstIn').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorState').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCountry').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#district').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	
	
	$('#streetName1').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#streetName2').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#streetName3').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#fatherHusbandName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#doorNo').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#panNo').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	$('#bankName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#accountNo').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#branchName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#ifcCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#branchCity').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#branchCountry').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	$('#aadharNo').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	
	
	$('#noOfCows').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#noOfBuffalos').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#noOfHeifer').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#noOfAnimal').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#milkProtential').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#varAnimals').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	

		loadVendorData();
	
	
	
});




function loadVendorData(){
	var source_vendor_data = {
			datatype:'json',
			url:'getFarmerVendorData',
			datafields:[{name:'vendorName',type:'string'},{name:'vendorName2',type:'string'},{name:'address',type:'string'},
			            {name:'city',type:'string'},{name:'pincode',type:'string'},{name:'phoneNo',type:'string'},
			            {name:'region',type:'string'},{name:'country',type:'string'},{name:'vendorCode',type:'string'},{name:'regionName',type:'string'},{name:'countryName',type:'string'}
			            ,{name:'age',type:'string'},{name:'fatherOrHusbund',type:'string'},{name:'doorNo',type:'string'},{name:'streetName1',type:'string'},
			            {name:'streetName2',type:'string'},{name:'streetName3',type:'string'},{name:'district',type:'string'},{name:'mobile1',type:'string'}
			            ,{name:'mobile2',type:'string'},{name:'bankName',type:'string'}, ,{name:'accountNo',type:'string'} ,{name:'branchName',type:'string'} ,{name:'ifcCode',type:'string'}
			            ,{name:'branchCity',type:'string'} ,{name:'branchCountry',type:'string'},,{name:'panNo',type:'string'}
			            ,{name:'noOfCows',type:'string'},{name:'noOfBuffalos',type:'string'},{name:'noOfAnimal',type:'string'}
			            ,{name:'milkProtential',type:'string'},{name:'varAnimals',type:'string'},{name:'noOfHeifer',type:'string'}
			            ],
			async:false
	}
	var dataAdapter_vendor_data = new $.jqx.dataAdapter(source_vendor_data,{autoBind:true,loadComplete:function(data){
		if(data.address!="E"){
			$('#vendorName').val(data.vendorName);
			$('#vendorCode').val(data.vendorCode);
			
			$('#age').val(data.vendorName2);
			$('#vendorAddress').val(data.address);
			$('#vendorCity').val(data.city);
			$('#vendorPincode').val(data.pincode);
			$('#vendorCountry').val(data.countryName);
		
			$('#vendorState').val(data.regionName);		
			
			$('#age').val(data.age);		
			$('#fatherHusbandName').val(data.fatherOrHusbund);		
			$('#streetName1').val(data.streetName1);		
			$('#streetName2').val(data.streetName2);		
			$('#streetName3').val(data.streetName3);		
			$('#district').val(data.district);		
			$('#mobileNo1').val(data.mobile1);
			$('#mobileNo2').val(data.mobile2);
			$('#doorNo').val(data.doorNo);
			$('#panNo').val(data.panNo);
			
			$('#bankName').val(data.bankName);
			$('#accountNo').val(data.accountNo);
			$('#branchName').val(data.branchName);
			$('#ifcCode').val(data.ifcCode);
			$('#branchCity').val(data.branchCity);
			$('#branchCountry').val(data.branchCountry);
			
			
			
			
			$('#noOfCows').val(data.noOfCows);
			$('#noOfBuffalos').val(data.noOfBuffalos);
			$('#noOfHeifer').val(data.noOfHeifer);
			$('#noOfAnimal').val(data.noOfAnimal);
//			$('#milkProtential').val(data.milkProtential);
//			$('#varAnimals').val(data.varAnimals);
			
			
							
		}else{
			
		}
	}});				
}