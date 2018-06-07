$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	$('#CustomerManagement').addClass("active");
	$("#breadcrumb-ol").append("<li class='breadcrumb-item active'><a href='CustomerManagement'>Customer Management</a></li><li class='breadcrumb-item active'><a href='#'>Customer Outstanding</a></li>");
	
	var theme='ui-start';
	$('#advertiser').jqxComboBox({width:'100%',height:25,theme:theme});
	$('#brand').jqxComboBox({width:'100%',height:25,theme:theme});	
	$('#fdate').jqxDateTimeInput({width:'100%',theme:theme,height:25});
	$('#tdate').jqxDateTimeInput({width:'100%',theme:theme,height:25});
	$('#outstandingAmt').jqxInput({rtl: true,width:'100%',theme:theme,height:25,disabled:true});
	$('#paidAmt').jqxInput({rtl: true,width:'100%',theme:theme,height:25,disabled:true});
	
	$('#tdate').on('change close open',function(e){
		var fdate = $('#fdate').val();
		var ffdate = fdate.split("/");
		$('#tdate').jqxDateTimeInput('setMinDate',new Date(ffdate[2],ffdate[1]-1,ffdate[0]));
	});
	
	$('#balanceGrid').jqxGrid({
		width:'100%',
		height:'350',
		theme:theme,
		altrows:true,
		filterable:true,
		showfilterrow:true,
		sortable:true,
		groupable:true,
		columns:[
		         {text:'Channel Name',datafield:'channelName',width:'20%',align:'center'},
		         {text:'RO No',datafield:'roNo',width:'15%',align:'center'},
		         {text:'Doc No',datafield:'docNo',width:'15%',align:'center'},
		         {text:'Doc Date',datafield:'docDate',width:'10%',align:'center'},
		         {text:'Doc Type',datafield:'docType',hidden:true,align:'center'},
		         {text:'Amount',datafield:'amount',hidden:true,align:'center',cellsalign:'right'},
		         {text:'Outstanding Amt',datafield:'dueAmount',width:'20%',align:'center',cellsalign:'right'},
		         {text:'Advance Amt',datafield:'paidAmount',width:'20%',align:'center',cellsalign:'right'},
		]
		/*showstatusbar: true,
        statusbarheight: 25,
        renderstatusbar: function (statusbar) {
        	var container = $("<div style='overflow: hidden; position: relative; margin: 5px;'><div id='totalValue' style='text-align:right;margin-right:5px'><b>Sum:0.00</b></div>");
        	statusbar.append(container);
        }*/
	});
	
	var positionId = $('#positionId_hidden').val();
	var custId = $('#custId_hidden').val();
	var source_customers = {
			datatype:'json',
			datafields:[{name:'agencyId',type:'string'},{name:'agencyName',type:'string'}],
			url:'getAssignedCustomersByPosition?positionId='+positionId,
			async:false					
	}
	var dataAdapter_customers = new $.jqx.dataAdapter(source_customers);
	$('#custId').jqxComboBox({width:'100%',height:25,theme:theme,source:dataAdapter_customers,valueMember:'agencyId',displayMember:'agencyName'});
	if(custId!=0){
		$('#custId').val(custId);
		loadAdvertiser(custId);
	}
	
	var source_channels = {
		datatype:'json',
		datafields:[{name:'channelId',type:'string'},{name:'channelName',type:'string'}],
		url:'getAllChannels',
		async:false
	}
	var dataAdapter_channels = new $.jqx.dataAdapter(source_channels);
	$('#channel').jqxComboBox({width:'100%',height:25,theme:theme,source:dataAdapter_channels,valueMember:'channelId',displayMember:'channelName'});
	
	$('#custId').on('change',function(e){
		var args = e.args;
		if(args){
			var item = args.item;
			var agencyId = item.value;
			if(agencyId!=""){
				loadAdvertiser(agencyId);
			}
		}
	});
	
	$('#advertiser').on('change',function(e){
		var args = e.args;
		if (args) {
			var item = args.item;
			var advertiserId = item.value;
			if(advertiserId!=""){				
				var source_brand = {
						datatype:'json',
						url:"getBrandByAdvertiserId?advertiserId="+advertiserId,
						datafields:[{name:'brandId',type:'string'},{name:'brandName',type:'string'}]
				}
				var dataAdapter_brand = new $.jqx.dataAdapter(source_brand);
				$('#brand').jqxComboBox({source:dataAdapter_brand,valueMember:'brandId',displayMember:'brandName'});
			}
		}
	});
	
	$('#getBtn').on('click',function(e){
		var custId = $('#custId').val();
		var advId = $('#advertiser').val();
		var brandId = $('#brand').val();
		var channelId = $('#channelId').val();
		var fdate = $('#fdate').val();
		var tdate = $('#tdate').val();
		
		if(advId==null || advId==undefined || advId==""){
			advId=0;
		}
		if(brandId==null || brandId==undefined || brandId==""){
			brandId=0;
		}
		if(channelId==null || channelId==undefined || channelId==""){
			channelId=0;
		}
		if(custId==null || custId==undefined || custId=="" || custId==0){
			/*alert("Select Customer");*/
			callAlert("orange","Warning","Select Customer");
		}else{
			var source_datas={
				datatype:'json',
				datafields:[{name:'channelName'},{name:'roNo'},{name:'docNo'},
				            {name:'docDate'},{name:'docType'},{name:'amount'}],
				url:'getCustomerOutstanding?custId='+custId+"&advId="+advId+"&brandId="+brandId+"&channelId="+channelId+"&fdate="+fdate+"&tdate="+tdate,
				async:false
			}
			var dataArray = new Array();
			var dataAdapter_datas = new $.jqx.dataAdapter(source_datas,{autoBind:true,loadComplete:function(data){
				$('#balanceGrid').jqxGrid('clear');
				if(data.length>0){
					for(var i=0;i<data.length-1;i++){
						dataArray.push(data[i]);
					}
					$('#balanceGrid').jqxGrid('addrow',null,dataArray);
					$('#outstandingAmt').val(data[data.length-1].dueAmount);
					$('#paidAmt').val(data[data.length-1].paidAmount);
				}else{
					$('#outstandingAmt').val(0.00);
					$('#paidAmt').val(0.00);
				}
			}});
		}
	});
});

function loadAdvertiser(custId){
	var source_advertisers = {
			datatype:'json',
			url:"getAdvertisersByAgencyId?agencyId="+custId,
			datafields:[{name:'advertiserId',type:'string'},{name:'advertiserName',type:'string'}],
			async:false
	}
	var dataAdapter_advertiser = new $.jqx.dataAdapter(source_advertisers);
	$('#advertiser').jqxComboBox({source:dataAdapter_advertiser,valueMember:'advertiserId',displayMember:'advertiserName'});
}