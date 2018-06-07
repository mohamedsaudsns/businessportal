$(window).load(function() {
    $(".loader").fadeOut("slow");
});

$(document).ready(function(e){
	
	var getLocalization1 = function() {
		var localizationobj = {};
		localizationobj.firstDay = 1;
		localizationobj.percentsymbol = "%";
		localizationobj.currencysymbol = " ";
		localizationobj.currencysymbolposition = " ";
		localizationobj.decimalseparator = ".";
		localizationobj.thousandsseparator = "";
		localizationobj.emptydatastring = "No records found! ";
		
		
		return localizationobj;
	};
	
	var lastThreeMonth = new Date();
	lastThreeMonth.setMonth(lastThreeMonth.getMonth() - 3);
	
	alert("Year.."+lastThreeMonth.getFullYear());
	
	var lastThreeMonthDate=lastThreeMonth.getFullYear()+"-"+(lastThreeMonth.getMonth()+1)+"-01";
	alert("full last three month "+lastThreeMonthDate);
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#MonthlyVehicleDetails').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Monthly Vehicle Details</a></li>");
	
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Monthly Vehicle Details</a></li>");
	
	
	$('#from_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy', maxDate: new Date(), minDate: lastThreeMonthDate});
	$('#to_out_report_date').jqxDateTimeInput({width:'100%',height:'25',theme:theme,formatString:'dd/MM/yyyy', maxDate: new Date(), minDate: lastThreeMonthDate});
	
	
//	$('#outstandingAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorCode').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	$('#vendorName').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	

   
    
	$('#oustandingReportGrid').jqxGrid({
		width:'100%',
		height:500,
		 columnsResize: true,
			groupable : true,
			groups : [ 'serviceAgent' ],
			groupsexpandedbydefault : true,
			showgroupaggregates : true,
		altrows:true,
		theme:theme,
		showaggregates: true,
		showstatusbar: true,
        statusbarheight: 30,
        localization : getLocalization1(),
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',hidden:true,
                cellsrenderer: function (row, column, value) {
                	 return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
    }},
    			 {text:'Plant',datafield:'plant',width:'10%',cellsalign: 'center', align: 'center'},
    			 {text:'Plant Description',datafield:'plantDesc',width:'17%', align: 'center'},
    			 {text:'Vehicle Vendor Code' ,datafield:'serviceAgent',width:'15%',cellsalign: 'center', align: 'center'},
    			 {text:'Shipment No',datafield:'shipmentNo',width:'10%',cellsalign: 'center', align: 'center'},
    			
    			 
    				{text:'Current Loading Date',datafield:'currentLoadingDate',width:'12%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',},
    			
    			 {text:'Shipment Route',datafield:'route',width:'10%',cellsalign: 'center', align: 'center'},
    			 {text:'Route Description',datafield:'routeDesc',width:'20%', align: 'center'},
		         {text:'Truck Number',datafield:'vehicleNumber',width:'10%', align: 'center'},
		         {text:'Supplmt',datafield:'supplm1',width:'20%', align: 'center'},
		         {text:'Supplmt1',datafield:'supplm2',width:'20%', align: 'center'},
		         {text:'Route Master Distance',datafield:'routeMasterDistance',width:'10%',cellsalign: 'center', align: 'center',columntype: 'date', },
		         
		         {text:'Start KM',datafield:'startKM',width:'10%',cellsalign: 'center', align: 'center'},
		         {text:'End KM',datafield:'endKM',width:'10%',cellsalign: 'center', align: 'center'},
		         
		         {text:'Distance Travelled',datafield:'runningKM',width:'11%',cellsalign: 'center', align: 'center'},		
		         {text:'Passing KM',datafield:'actualKM',width:'11%', cellsalign: 'right',align: 'center',cellsformat: 'c2',aggregates: ['sum']},
		         
		         {text:'Freight Rate(KG)',datafield:'freightRateKG',width:'11%',align: 'center',cellsalign: 'right',cellsformat: 'c2'},
		       
		         {text:'Freight(KM)',datafield:'freight',width:'14%',align: 'center',cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'Freight (Fixed Amount)',datafield:'freightFixed',width:'11%',align: 'center',cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'Secondary Route Freight Rate(KM)',datafield:'secRouteFreightRate',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'Secondary Route Freight(KM)',datafield:'secRouteFreight',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'Stage Fixed Amount',datafield:'stageFixedAmt',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'Additional Amount',datafield:'additionalAmt',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'Toll Fees',datafield:'tollgateAmount',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         
		         
		         
		         {text:'Total Addn Amt',datafield:'totalAddnAmt',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'Freight Deduction',datafield:'freightDeduction',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'Flat Amt Deduction',datafield:'flatAmtDeduction',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'V-Track Deduction',datafield:'vTrackDeduction',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         
		         {text:'KM Not Running Deduction',datafield:'kMNotRunningDeduction',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'AC Not Running Deduction',datafield:'aCNotRunningDeduction',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         {text:'Vehicle Ageing Deduction',datafield:'vehicleAgeingDeduction',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		       
		         
		         
		      
		      
		         
		      
		         
		        
		        
		        
		       
		         
		        
		         {text:'Total Deduction Amt',datafield:'deductionAmt',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         
		         {text:'Invoicing Party Wise Cost',datafield:'invoicingPartywiseCost',width:'18%',align: 'center', cellsalign: 'right',cellsformat: 'c2',aggregates: ['sum']},
		         
		         
		         
     ]
//		         {text:'Cr / Dr',datafield:'db_ind',width:'5%',cellsalign: 'center', align: 'center'},
//		         {text:'0 - 15',datafield:'to15',width:'10%',cellsalign: 'right', align: 'center'},
//		         {text:'15 - 30',datafield:'to30',width:'10%',cellsalign: 'right', align: 'center'},
//		         {text:'30 - 45',datafield:'to45',width:'10%',cellsalign: 'right', align: 'center'},
		        
		
	});


	
	
	
	
	
	
	
	
	$('#getBtn').on("click",function(e){
		 $(".loader").fadeIn("slow");
		
		
		var from_out_report_date = $('#from_out_report_date').val();
		
	var	to_out_report_date= $('#to_out_report_date').val();
	
	var	itemType= "ALL";

			var fields= new Array();
		
			fields.push({name:'plant',type:'string'},
					    {name:'plantDesc',type:'string'},
					    {name:'shipmentNo',type:'string'},
					    {name:'shipmentDate',type:'string'},
					    {name:'route',type:'string'},
					    {name:'routeDesc',type:'string'},
					    {name:'vehicleNumber',type:'string'},
					    {name:'supplm1',type:'string'},
					    {name:'supplm2',type:'string'},
						
						{name:'routeMasterDistance',type:'string'},
						{name:'startKM',type:'string'},
						{name:'endKM',type:'string'},
						{name:'runningKM',type:'string'},
						{name:'actualKM',type:'string'},
						{name:'ratePerKm',type:'string'},
						{name:'freight',type:'number'},
						{name:'freightFixed',type:'number'},
						{name:'tollgateAmount',type:'number'},
						{name:'stageFixedAmt',type:'number'},
						{name:'secRouteFreightRate',type:'number'},
						{name:'secRouteFreight',type:'number'},
						{name:'additionalAmt',type:'number'},
						{name:'deductionAmt',type:'number'},
						{name:'currentLoadingDate',type: 'date', format: 'dd/mm/yyyy'},
						
						{name:'totalAddnAmt',type:'number'},
						{name:'freightDeduction',type:'number'},
						{name:'flatAmtDeduction',type:'number'},
						{name:'vTrackDeduction',type:'number'},
						{name:'kMNotRunningDeduction',type:'number'},
						{name:'aCNotRunningDeduction',type:'number'},
						{name:'vehicleAgeingDeduction',type:'number'},
						{name:'invoicingPartywiseCost',type:'number'},
						{name:'freightRateKG',type:'string'},
						{name:'serviceAgent',type:'string'}
					
						
						
					  
						
						);

			var source_inventory = {
				datatype:'json',
				datafields:fields,
				url:'getMonthlyVehicleDetailsReport?selected_from_date='+from_out_report_date+'&selected_to_date='+to_out_report_date+'&itemType='+itemType,
				async:false
			}
			var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
			$('#oustandingReportGrid').jqxGrid({source:dataAdapter_inventory,	groups : [ 'serviceAgent' ]});
			$(".loader").fadeOut("slow");
			
			
//		}
	});
});