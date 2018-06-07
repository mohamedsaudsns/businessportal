$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#agreementRenewalStatusHikeStatus').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>Agreement Renewal Status</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> Agreement Renewal Status</a></li>");
	
	

	 
	
//	$('#agreementNo').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#startDate').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#endDate').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	
//	$('#advanceAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#rentAmount').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#renewalType').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	
//	$('#noOfYears').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#renewalDate').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#rentIncrPercentage').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	
//	$('#rentIncrYear').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#plant').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
//	$('#notice').jqxInput({width:'100%',theme:theme,height:25,disabled:true});
	
	
	
	var cellrendererForNumberRange = function(row, columnfield, value, defaulthtml, columnproperties, rowdata) {
		if (rowdata.status === "A") {
			 var element = $(defaulthtml);
             element.css({ 'background-color': '#87BFA1', 'width': '100%', 'height': '100%', 'padding': '1px' });
             return "<div style='text-align: center ; background-color: #87BFA1 width: 100%, height: 100%,     margin-top: 5px;'> Active</div>";
		} else if (rowdata.status === "X") {
			  var element = $(defaulthtml);
              element.css({ 'background-color': '#FFFF66', 'width': '100%', 'height': '100%', 'padding': '1px' });
              return "<div style='text-align: center ; background-color: #87BFA1 width: 100%, height: 100%,     margin-top: 5px;'>In Active</div>";
		} 
	};

		
	$('#landOwnerAgreementGrid').jqxGrid({
		width:'100%',
		height:350,
		
		
		altrows:true,
		theme:theme,
		  showaggregates: true,
		columns:[
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',
                cellsrenderer: function (row, column, value) {
                	return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
    }},

		         {text:'Agreement No',datafield:'agreementNo',width:'20%',cellsalign: 'center', align: 'center'},
		         {text:'Fiscal Year',datafield:'fiYear',width:'6%',cellsalign: 'center', align: 'center'},
		         {text:'Location',datafield:'location',width:'25%', align: 'center'},		
		         {text:'Brand',datafield:'brand',width:'15%', align: 'center',hidden:true},		
		         {text:'Current Status ',datafield:'currentStatus',width:'30%',align: 'center',hidden:true},
		        
		         {text:'startDate ',datafield:'startDate',width:'25%',align: 'center', cellsalign: 'right',hidden:true,columntype: 'date', cellsformat: 'dd/MM/yyyy'},

		    	 {text:'endDate ',datafield:'endDate',width:'25%',align: 'center', cellsalign: 'center',hidden:true,columntype: 'date', cellsformat: 'dd/MM/yyyy'},
		    	 {text:'advanceAmount ',datafield:'advanceAmount',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'rentAmount ',datafield:'rentAmount',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'Renewal Type ',datafield:'renewalType',width:'23%',align: 'center',},
		    	 {text:'noOfYears ',datafield:'noOfYears',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'Renewal Date ',datafield:'renewalDate',width:'12%',align: 'center', cellsalign: 'center',columntype: 'date', cellsformat: 'dd/MM/yyyy'},
		    	 {text:'Rent Increment(%) ',datafield:'rentIncrPercentage',width:'13%',align: 'center',cellsalign: 'center',hidden:true},
		    	 {text:'Rent Increment Year ',datafield:'rentIncrYear',width:'13%',align: 'center', cellsalign: 'center',hidden:true},
		    	 {text:'plant ',datafield:'plant',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'notice ',datafield:'notice',width:'25%',align: 'center', cellsalign: 'right',hidden:true},
		    	 {text:'Status ',datafield:'status',width:'7%',align: 'center', cellsrenderer: cellrendererForNumberRange,cellsalign: 'center'},

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
				{name:'brand',type:'string'},{name:'renewalDate',type: 'date', format: 'dd/mm/yyyy'},{name:'rentIncrYear',type:'string'},{name:'plant',type:'string'},{name:'currentStatus',type:'string'},
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
	

    var rows=0;
    	
//    	$('#agreementNo').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'agreementNo'));
//    	
//    	$('#startDate').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'startDate'));
//    	$('#endDate').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'endDate'));
//    	$('#advanceAmount').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'advanceAmount'));
//    	$('#rentAmount').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'rentAmount'));
//    	$('#renewalType').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'renewalType'));
//    	$('#noOfYears').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'noOfYears'));
//    	$('#renewalDate').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'renewalDate'));
//    	
//    	$('#rentIncrPercentage').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'rentIncrPercentage'));
//    	$('#rentIncrYear').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'rentIncrYear'));
//    	$('#plant').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'plant'));
//    	$('#notice').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'notice'));
    	
    	
	
//    $('#landOwnerAgreementGrid').bind('rowdoubleclick', function(event) {
//
//        var outer_row = event.args.rowindex;
//        var rows = $('#landOwnerAgreementGrid').jqxGrid('getselectedrowindexes');
//        if (rows.length > 0) {
//        	
//        	$('#agreementNo').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'agreementNo'));
//        	
//        	$('#startDate').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'startDate'));
//        	$('#endDate').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'endDate'));
//        	$('#advanceAmount').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'advanceAmount'));
//        	$('#rentAmount').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'rentAmount'));
//        	$('#renewalType').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'renewalType'));
//        	$('#noOfYears').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'noOfYears'));
//        	$('#renewalDate').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'renewalDate'));
//        	
//        	$('#rentIncrPercentage').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'rentIncrPercentage'));
//        	$('#rentIncrYear').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'rentIncrYear'));
//        	$('#plant').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'plant'));
//        	$('#notice').val($('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'notice'));
//        	
//        	
//
//
//
//
//
//        } else {
//            alert_popUp('Warning', "Please select a row");
//        }
//    });
	
	
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