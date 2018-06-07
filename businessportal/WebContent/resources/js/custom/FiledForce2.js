$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#OutstandingReport').addClass("active");
	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Field Force Contact Number</a></li>");
	
	

	 
	
	$('#filedForceName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#contactNo').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	
	
	 $.getJSON('getFieldForceData', function (data) {
//				 alert("dsd"+data.contactNo);
				 
//					if(data.address!="E"){
						$('#filedForceName').val(data.filedForceName);
						$('#contactNo').val(data.vendorCode);
							
//										
//					}
				 
			      console.log(data);

//			      var items = data.items.map(function (item) {
//			        return item.key + ': ' + item.value;
//			      });
			 });
	
	loadVendorData();

	function loadVendorData(){
		var source_vendor_data = {
				datatype:'json',
				url:'getFieldForceData',
				datafields:[{name:'filedForceName',type:'string'},{name:'contactNo',type:'string'}],
				async:false
		}
		var dataAdapter_vendor_data = new $.jqx.dataAdapter(source_vendor_data,{autoBind:true,loadComplete:function(data){
//			alert(data.filedForceName);
			
				$('#filedForceName').val(data.filedForceName);
				$('#contactNo').val(data.contactNo);
				
			
		
		}});				

	}

	
	
//	$('#getBtn').on("click",function(e){
//
//			var fields= new Array();
//			
//			fields.push({name:'agreementNo',type:'string'},{name:'fiYear',type:'string'},{name:'location',type:'string'},{name:'rentIncrYear',type:'string'},{name:'notice',type:'string'}
//						{name:'brand',type:'string'},{name:'renewalDate',type: 'date', format: 'dd/mm/yyyy'},{name:'rentIncrYear',type:'string'},{name:'plant',type:'string'},
//						,{name:'status',type:'string'},{name:'startDate',type: 'date', format: 'dd/mm/yyyy'},{name:'endDate',type: 'date', format: 'dd/mm/yyyy'},{name:'advanceAmount',type:'string'}
//						,{name:'rentAmount',type:'string'},{name:'renewalType',type:'string'},{name:'noOfYears',type:'string'},{name:'rentIncrPercentage',type:'string'});
//
//			var source_agreement = {
//				datatype:'json',
//				datafields:fields,
//				url:'getAgreementData',
//				async:false
//			}
//			var dataAdapter_source_agreement= new $.jqx.dataAdapter(source_agreement);
//			$('#landOwnerAgreementGrid').jqxGrid({source:dataAdapter_source_agreement});
////		}
//	});
});