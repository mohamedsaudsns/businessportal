$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	$('#ChangePassword').addClass("active");
	//$("#breadcrumb-ol").append("<li class='breadcrumb-item active'><a href='#'>Change Password</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Change Password</a></li>");
	
	var theme='ui-start';
	
	
	
	$('#oldPassword').jqxInput({width:'100%',theme:theme,height:25});
	$('#newPassword').jqxInput({width:'100%',theme:theme,height:25});
	$('#confirmPassword').jqxInput({width:'100%',theme:theme,height:25});
	
	
	
});


function checkPassword(){
	var newPassword = $("#newPassword").val();
	var confirmPassword = $("#confirmPassword").val();
	if(newPassword!=''){
	if(newPassword!=confirmPassword){
		
		callAlert("red","Error","New password and confirm password are not matching please enter correct password...");
	}
	}else{
		
	}
}



function generateOtp() {

	 $('#otpGeneratorModal').modal('toggle');

		$.ajax({
			type : "GET",
			url : "generateVendorPasswordOtp",
			success : function(response) {
				if (response == "S") {
					
					callAlert("green","Alert","OTP Successfully Sent");
					 $('#myModal').modal('show');
						
					
				}else{
					
					callAlert("red","Error","OTP not Sent");	
					
				}
			},
			error : function(error) {
				callAlert("red","Error","OTP not Sent");	

			}
		});
	
}


function validateOtp() {
	var currentOtp = $('#currentOtp').val();
	var password = $('#password').val();
	if (currentOtp == "" || currentOtp == undefined || currentOtp == null) {

		callAlert("orange","Warning","Please Enter OTP Code");
		return false; 
	
	} else {
		$.ajax({
			type : "GET",
			url : "OtpValidation?otpCode=" + currentOtp,
			success : function(response) {
				if (response == "success") {
					
					 $('#myModal').modal('toggle');
						
						resetPassword();
						
					
		
				} else {
					callAlert("red","Error","Incorrect OTP Code ");
				}
			},
			error : function(error) {

			}
		});
	}
}


function callOtpScreen() {
	var newPassword = $('#newPassword').val();
	var confirmPassword = $('#confirmPassword').val();
	if (newPassword == "" || newPassword == undefined || newPassword == null) {

		callAlert("orange","Warning","Please Enter Password");
		return false; 
	
	} else if (confirmPassword == "" || confirmPassword == undefined || confirmPassword == null) {

		callAlert("orange","Warning","Please Enter Confirm Password");
		return false; 
	
	} else if (confirmPassword != newPassword ) {

		callAlert("orange","error","New password and confirm password are not matching please enter correct password...");
		return false; 
	
	}	else {
		
	//	$('#otpGeneratorModal').modal('show'); 
		$.ajax({
			type : "GET",
			url : "resetPassword?newPassword=" + newPassword,
			success : function(response) {
				if (response == "success") {
					
//					callAlert("green","Alert","Successfully password reset");
//					
//					 $('#newPassword').val("");
//						 $('#confirmPassword').val("");
//						 $('#oldPassword').val("");
						 
							window.location.href = 'Logout';
		
				} else {
					callAlert("red","Error","Unable to reset password");
				}
			},
			error : function(error) {

			}
		});
	}
}

var delayMillis = 1000;

function resetPassword() {
	var newPassword = $('#newPassword').val();
	var confirmPassword = $('#confirmPassword').val();
	if (newPassword == "" || newPassword == undefined || newPassword == null) {

		callAlert("orange","Warning","Please Enter Password");
		return false; 
	
	} else if (confirmPassword == "" || confirmPassword == undefined || confirmPassword == null) {

		callAlert("orange","Warning","Please Enter Confirm Password");
		return false; 
	
	}	else {
		$.ajax({
			type : "GET",
			url : "resetPassword?newPassword=" + newPassword,
			success : function(response) {
				if (response == "success") {
					
					
					callAlert("green","Alert","Successfully password reset");
					
					setTimeout(function() {
						window.location.href = 'index';
						}, delayMillis);
					
					
		
					
				} else {
					callAlert("red","Error","Unable to reset password");
				}
			},
			error : function(error) {

			}
		});
	}
}

function loadVendorData(){
	var source_vendor_data = {
			datatype:'json',
			url:'getVendorData',
			datafields:[{name:'vendorName',type:'string'},{name:'vendorName2',type:'string'},{name:'address',type:'string'},
			            {name:'city',type:'string'},{name:'pincode',type:'string'},{name:'phoneNo',type:'string'},
			            {name:'region',type:'string'},{name:'country',type:'string'},{name:'vendorCode',type:'string'},{name:'regionName',type:'string'},{name:'countryName',type:'string'}
			            ,{name:'age',type:'string'},{name:'fatherOrHusbund',type:'string'},{name:'doorNo',type:'string'},{name:'streetName1',type:'string'},
			            {name:'streetName2',type:'string'},{name:'streetName3',type:'string'},{name:'district',type:'string'},{name:'mobile1',type:'string'}
			            ,{name:'mobile2',type:'string'}],
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
			
			

			
			
			
			
							
		}else{
			
		}
	}});				
}