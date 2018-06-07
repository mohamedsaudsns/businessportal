$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#tdsCertificates').addClass("active");
	//$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>TDS Certificate</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> TDS Certificate</a></li>");
	

	
	
	 var fi_year = [
	        {value: "2017-18", label: "2017-18"},
	        {value: "2018-19", label: "2018-19"}
	    ];

	    $("#fiYear").jqxDropDownList({source: fi_year, selectedIndex: -1, width: "100%",theme:theme,
			height : '26',  dropDownHeight: 100});
	    
	    var renderer = function (id) {
	    	return '<input type="button" onClick="buttonclick(event)" class="gridButton" id="btn' + id + '" value="Download"/>'
	    }
	
	    
		var buttonclick = function (event) {
			var rows = event.target.id;
			
		
		        if (rows.length > 0) {
		        	
		        	
		     var fiYear= $('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'fiYear');
		     var quater=$('#landOwnerAgreementGrid').jqxGrid('getcellvalue', rows, 'quater');
		        	
		 	$('#hmbSummaryModel').modal('show');
		        	
		        	
		        	
		        	  window.open("tdsFileUploadById?fiYear=" + fiYear + "&quater=" + quater);




		        }
			
			
		}
	
	$('#tdsCertificatesGrid').jqxGrid({
		width:'100%',
		height:600,
		sortable:true,
		
		altrows:true,
		theme:theme,
		  showaggregates: true,
		columns:[
			
			{text: 'No', dataField: '', columntype: 'number', cellsalign: 'center', width: '7%',align: 'center',
                cellsrenderer: function (row, column, value) {
        return "<div style='text-align: center; padding: 6px'>" + (value + 1) + "</div>";
    }},
		         {text:'Quarter',datafield:'quater',width:'11%',cellsalign: 'center', align: 'center'},
		         {text:'TDS Certificate',datafield:'fileName',width:'45%',cellsalign: 'center', align: 'center'	},
		         {text:'PAN No',datafield:'panNo',width:'22%',cellsalign: 'center', align: 'center'},
		         {text:'fiYear',datafield:'fiYear',width:'20%',cellsalign: 'center', align: 'center',hidden:true},
		         
		         
		         {text:'Download',datafield:'Download',width:'15%',cellsalign: 'center', columntype: 'button', align: 'center', cellsrenderer: function () {
		        	   return 'Download';
//		        	    
//		        	    return ' <div style="width: 100%"><img src="resources/vendor-images/pdf-icon.ico" style="margin-left: 25%" /></div>';
		        	    
		        	   
//		             return '<img src="resources/vendor-images/pdf_icon.png" alt="lock" width="60" height="30">';
		         }, buttonclick: function (row) {
		           
		                 var dataRecord = $("#tdsCertificatesGrid").jqxGrid('getrowdata', row);
//		                 $("#firstName").val(dataRecord.firstname);
//		                 $("#lastName").val(dataRecord.lastname);
//		                 $("#product").val(dataRecord.productname);
//		                 $("#quantity").jqxNumberInput({ decimal: data	Record.quantity });
//		                 $("#price").jqxNumberInput({ decimal: dataRecord.price });
		                 
		              //   window.open("tdsFileUploadById?fiYear=" + dataRecord.fiYear + "&quater=" + dataRecord.quater);

//		             	$('#hmbSummaryModel').modal('show');
//		                 var url='tdsFileUploadById?fiYear=' + dataRecord.fiYear + '&quater=' + dataRecord.quater,''+dataRecord.fileName+'';
		             	
		              //   var windowSize = "width=" + window.innerWidth + ",height=" + window.innerHeight + ",scrollbars=no";
		              //   window.open('http://www.google.com', 'popup', windowSize);
		                 
		                window.open('tdsFileUploadById?fiYear=' + dataRecord.fiYear + '&quater=' + dataRecord.quater);
		                 
		            // 	popitup('tdsFileUploadById?fiYear=' + dataRecord.fiYear + '&quater=' + dataRecord.quater,''+dataRecord.fileName);
		                 
//		                 var w = window.open('tdsFileUploadById?fiYear=' + dataRecord.fiYear + '&quater=' + dataRecord.quater,''+dataRecord.fileName);
//		                 w.documentdocument.write('<title>'+dataRecord.fileName+'</title>'); 
		                // $('#hmbSummaryModel').modal('show');
		        
		             }
		         		       
		         }
     ]

		        
		
	});



	

	
	$('#getBtn').on("click",function(e){
		
		
		 $(".loader").fadeIn("slow");
		var fiYear = $('#fiYear').val();
		
		
			var fields= new Array();
		
			fields.push({name:'quater',type:'string'},{name:'fileName',type:'string'},{name:'panNo',type:'string'},
						{name:'fileType',type:'string'},{name:'fiYear',type:'string'}
					);

			var source_tds_data = {
				datatype:'json',
				datafields:fields,
				url:'getTDSData?fiYear='+fiYear,
				async:false
			}
			var dataAdapter_source_tds_data = new $.jqx.dataAdapter(source_tds_data);
			$('#tdsCertificatesGrid').jqxGrid({source:dataAdapter_source_tds_data});
//		}
			
			$(".loader").fadeOut("slow");
	});
	
	function popitup(url) {
		newwindow=window.open(url,'name','height=80%,width=80%');
		if (window.focus) {newwindow.focus()}
		return false;
		}

});