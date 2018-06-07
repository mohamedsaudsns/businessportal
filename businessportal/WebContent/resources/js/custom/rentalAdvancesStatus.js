$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#rentalAdvancesStatus').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Rental Advances Status</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Rental Advances Status</a></li>");
	
	

	 

	
	
	var cellrendererForNumberRange = function(row, columnfield, value, defaulthtml, columnproperties, rowdata) {
		if (rowdata.status === "A") {
			 var element = $(defaulthtml);
             element.css({ 'background-color': '#87BFA1', 'width': '100%', 'height': '100%', 'padding': '1px' });
             return "<div style='text-align: center; padding: 6px; background-color: #87BFA1; color: #FFFFFF;' > Active</div>";
		} else if (rowdata.status === "X") {
			  var element = $(defaulthtml);
              element.css({ 'background-color': '#FFFF66', 'width': '100%', 'height': '100%', 'padding': '1px' });
              return "<div style='text-align: center; padding: 6px; background-color: #87BFA1; color: #FFFFFF;'>In Active</div>";
		} 
	};

		
	$('#landOwnerAgreementGrid').jqxGrid({
		width:'100%',
		height:250,
		theme:theme,
		
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',
                cellsrenderer: function (row, column, value) {
        return "<div style='text-align: center; padding: 6px;'>" + (value + 1) + "</div>";
    }},

		         {text:'Agreement No',datafield:'agreementNo',width:'20%',cellsalign: 'center', align: 'center'},
		         {text:'Fiscal Year',datafield:'fiYear',width:'6%',cellsalign: 'center', align: 'center'},
		         {text:'Location',datafield:'location',width:'15%', align: 'center'},		
		         {text:'Brand',datafield:'brand',width:'15%', align: 'center'},		
		         {text:'Current Status ',datafield:'currentStatus',width:'30%',align: 'center'},
		         {text:'Status ',datafield:'status',width:'7%',align: 'center', cellsrenderer: cellrendererForNumberRange,cellsalign: 'center'},
		         {text:'startDate ',datafield:'startDate',width:'25%',align: 'center', cellsalign: 'right',hidden:true,columntype: 'date', cellsformat: 'dd/MM/yyyy'},

		    	 {text:'endDate ',datafield:'endDate',width:'25%',align: 'center', cellsalign: 'right',hidden:true,columntype: 'date', cellsformat: 'dd/MM/yyyy'},
		    	 {text:'advanceAmount ',datafield:'advanceAmount',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'rentAmount ',datafield:'rentAmount',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'renewalType ',datafield:'renewalType',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'noOfYears ',datafield:'noOfYears',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'renewalDate ',datafield:'renewalDate',width:'25%',align: 'center', cellsalign: 'right',columntype: 'date', cellsformat: 'dd/MM/yyyy',hidden:true},
		    	 {text:'rentIncrPercentage ',datafield:'rentIncrPercentage',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'rentIncrYear ',datafield:'rentIncrYear',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'plant ',datafield:'plant',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'notice ',datafield:'notice',width:'25%',align: 'center', cellsalign: 'right',hidden:true},

     ]
	
		        
	});


	
	$('#landOwnerAgreementLiGrid').jqxGrid({
		width:'100%',
		height:350,
		altrows:true,
		theme:theme,
		
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',
                cellsrenderer: function (row, column, value) {
        return "<div style='text-align: center; padding: 6px;'>" + (value + 1) + "</div>";
    }},

		         {text:'Agreement No',datafield:'agreementNo',width:'20%',cellsalign: 'center', align: 'center'},
		         {text:'Activity Name',datafield:'activityNam',width:'23%', align: 'center'},
		         {text:'Start Date',datafield:'startDate',width:'10%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',},
		         {text:'End Date',datafield:'endDate',width:'10%',cellsalign: 'center', align: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy',},		
		         {text:'Previous Advance Amount',datafield:'prvAdvanceAmount',width:'15%', align: 'center',cellsalign: 'right',hidden:true},		
		       	
		         {text:'Current Advance Amount',datafield:'currentAdvanceAmount',width:'15%', align: 'center',cellsalign: 'right'},		
		         {text:'Previous RentAmount',datafield:'prvRentAmount',width:'15%', align: 'center',cellsalign: 'right',hidden:true},		
		         {text:'Current Rent',datafield:'currentRent',width:'15%', align: 'center',cellsalign: 'right'},		
		        

     ]
	
		        
	});
	
	

	
	
	
	
	
	var cellsrenderer = function (row, column, value, defaultHtml) {
		var totalDuration = $('#landOwnerAgreementGrid').jqxGrid('getcellvalue',row,'totalDuration');
		totalDuration = parseInt(totalDuration);
		if(value!=''){
			var percent = (parseInt(value)/totalDuration)*100;
			if(parseFloat(percent)<0){
				var element = $(defaultHtml);
	            element.css('color', '#FF0000');
	            return element[0].outerHTML;
			}else if(parseFloat(percent)>0 && parseFloat(percent)<=50){
				var element = $(defaultHtml);
	            element.css('color', '#0000A0');
	            return element[0].outerHTML;
			}else if(parseFloat(percent)>50 && parseFloat(percent)<=100){
				var element = $(defaultHtml);
	            element.css('color', '#00FF00');
	            return element[0].outerHTML;
			}	
		}
        return defaultHtml;
    }
	
	
	
	var fields= new Array();
	
	fields.push({name:'agreementNo',type:'string'},{name:'fiYear',type:'string'},{name:'location',type:'string'},{name:'rentIncrYear',type:'string'},{name:'notice',type:'string'},
				{name:'brand',type:'string'},{name:'renewalDate',type: 'string'},{name:'rentIncrYear',type:'string'},{name:'plant',type:'string'},{name:'currentStatus',type:'string'},
				{name:'status',type:'string'},{name:'startDate',type: 'string'},{name:'endDate',type: 'string'},{name:'advanceAmount',type:'string'},
				{name:'rentAmount',type:'string'},{name:'renewalType',type:'string'},{name:'noOfYears',type:'string'},{name:'rentIncrPercentage',type:'string'});

	var source_agreement = {
		datatype:'json',
		datafields:fields,
		url:'getAgreementData',
		async:false
	}
	var dataAdapter_source_agreement= new $.jqx.dataAdapter(source_agreement);
	$('#landOwnerAgreementGrid').jqxGrid({source:dataAdapter_source_agreement});
	


    	
    	
	
    $('#landOwnerAgreementGrid').bind('rowdoubleclick', function(event) {
    	

        var outer_row = event.args.rowindex;
        var rows = $('#landOwnerAgreementGrid').jqxGrid('getselectedrowindexes');
        if (rows.length > 0) {
        	
      
        var	fiYear=	$('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'fiYear');
        var agreementNo=$('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'agreementNo');
        	
        	var fields= new Array();
        	

        	
        	fields.push({name:'agreementNo',type:'string'},{name:'startDate',type: 'date', format: 'dd/mm/yyyy'},{name:'activityNam',type:'string'},{name:'endDate',type: 'date', format: 'dd/mm/yyyy'}
        	,{name:'prvAdvanceAmount',type:'string'},{name:'currentAdvanceAmount',type:'string'},{name:'prvRentAmount',type:'string'},{name:'currentRent',type:'string'});

        	var source_agreement = {
        		datatype:'json',
        		datafields:fields,
        		url:'getAgreementLi?fiYear='+fiYear+'&agr_no='+agreementNo,
        		async:false
        	}
        	var dataAdapter_source_agreement= new $.jqx.dataAdapter(source_agreement);
        	$('#landOwnerAgreementLiGrid').jqxGrid({source:dataAdapter_source_agreement});
        	
        	





        } else {
            alert_popUp('Warning', "Please select a row");
        }
    });
	
	
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