<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>Security Deposit Status</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/jquery-confirm.min.css" rel="stylesheet">
	<link href="resources/css/common-style.css" rel="stylesheet">

<link href="resources/jqwidgets/styles/jqx.base.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.bootstrap.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-start.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-redmond.css" rel="stylesheet">

<!-- <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/> -->
<link rel="stylesheet" type="text/css" href="resources/datatables/css/datatables.min.css"/>

<link rel="stylesheet" type="text/css" href="resources/jquery-ui-1.11.4.custom/jquery-ui.css"/>

<link rel="stylesheet" type="text/css" href="resources/EasyAutocomplete-1.3.5/easy-autocomplete.css"/>
<link rel="stylesheet" type="text/css" href="resources/EasyAutocomplete-1.3.5/easy-autocomplete.min.css"/>
<link rel="stylesheet" type="text/css" href="resources/EasyAutocomplete-1.3.5/easy-autocomplete.themes.css"/>
<link rel="stylesheet" type="text/css" href="resources/EasyAutocomplete-1.3.5/easy-autocomplete.themes.min.css"/>


 <style type="text/css">
        .loaderimg
        {
            background: url(resources/img/loader.gif);
            background-repeat: no-repeat;
            background-position: right;
        }
    </style>


 



<!-- <script src="assets/js/chart-master/Chart.js"></script> -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
 <style type="text/css">

	
</style>
	<%
		String userId = (String) session.getAttribute("userId");
	
		if (userId == null) {
			response.sendRedirect("Logout");
		} else {			
	%>
</head>

<body>

	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
			<%@include file="..//header.jsp" %>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<%@include file="..//menu.jsp" %>
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<%@include file="..//Breadcrump.jsp" %>
				
			
					<div class="row mt mb" style="padding-top: 7px">

					
						
							<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5" ><label class="label_stru">Vendor Code</label></div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5" style="padding: 1px !important;" >
							
								<input type="text" id="vendorCode"   />
						</div>
						
							<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5"  ><label class="label_stru">Vendor Name</label></div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-5" style="padding: 1px !important;" >
							
								<input type="text" id="vendorName"  />
						</div>
				
					<div class="col-lg-1 col-md-2 col-sm-6 col-xs-2" >
						<button   id="getBtn" class="btn btn-success btn-sm">Get</button>
						</div>	
						<div class="col-lg-5 col-md-2 col-sm-6 col-xs-5" >
      
            <label for="txtEmployeeNamed">Developer:</label>
           <input type="text" id="txtSearch" />
   
    </div>

						
<!-- 						 <div class="col-lg-5 col-md-2 col-sm-6 col-xs-5" > -->
<!-- 						<label>Department</label><input type="text" id="depList"> -->
<!-- 						</div> -->
						
<!-- 						  <div class="col-lg-12 col-md-2 col-sm-6 col-xs-5" > -->
<!-- 						<input id="basics" /> -->
<!-- 						</div> -->


			 <div class="row clearfix">
		<div class="col-lg-12 col-md-12 column">
			<table class="table table-bordered table-hover" id="dynamicTableRows">
				<thead>
					<tr >
			
<!-- 						<th class="text-center"> -->
<!-- 							# -->
<!-- 						</th> -->
						<th class="text-center">
							Product Name
						</th>
						<th class="text-center">
							Price
						</th>
						<th class="text-center">
							Qty
						</th>
						<th class="text-center">
							Discount
						</th>
						<th class="text-center">
							Sub Total
						</th>
						<th class="text-center"><i class="fa fa-trash-o tip pointer posdel" id="1524823613364" title="Remove"></i></th>
					</tr>
				</thead>
				<tbody>

<!--                     <tr id='rowAdd'></tr> -->
				</tbody>
			</table>
		</div>
			
	</div>



		 <div class="row clearfix">
		<div class="col-lg-12 col-md-12 column">
			<table class="table table-bordered table-hover" id="tab_logic">
				<thead>
					<tr >
					<th class="text-center">
						<i class='fa fa-2x fa-plus-circle' onclick='AddLine(0);'></i>
						</th>
<!-- 						<th class="text-center"> -->
<!-- 							# -->
<!-- 						</th> -->
						<th class="text-center">
							Product Name
						</th>
						<th class="text-center">
							Price
						</th>
						<th class="text-center">
							Qty
						</th>
						<th class="text-center">
							Discount
						</th>
						<th class="text-center">
							Sub Total
						</th>
						<th class="text-center"><i class="fa fa-trash-o tip pointer posdel" id="1524823613364" title="Remove"></i></th>
					</tr>
				</thead>
				<tbody>
					<tr id='addr0'>
					
						<td class="text-center">
						<i class='fa fa-2x fa-plus-circle' onclick='AddLine(0);'></i></td>
						
<!-- 						<td> -->
<!-- 						1 -->
<!-- 				</td> -->
						<td>
						
					
						<input type="text" name='name0' value=''  placeholder='Name' class="form-control"/>
						</td>
						<td>
						<input type="text" name='price0' id='price0' placeholder='Price' onkeyup="checkDec(this);"  class="form-control"/>
						</td>
						<td>
						<input type="text" name='qty0' id='qty0' onkeypress="return onlyNos(event,this);" onkeyup="subTotalUpdate(0);" onkeydown="subTotalUpdate(0);" placeholder='Qty' class="form-control"/>
						
						</td>
						<td>
						<input type="text" name='discount0' id='discount0' onkeypress="return onlyNos(event,this);" onkeyup="calculateDiscount(0);" onkeydown="calculateDiscount(0);" placeholder='Discount %' class="form-control"/>
						
						</td>
						
						<td>
						<input type="text" name='subTotal0' id='subTotal0' placeholder='Sub Total' class="form-control"/>
						
						</td>
						<td class="text-center"><i class="fa fa-trash-o tip pointer posdel" onclick="removeLine(0);" id="1524823613364" title="Remove"></i></td>
					</tr>
                    <tr id='addr1'></tr>
				</tbody>
			</table>
		</div>
			
	</div>


			
<!-- 				<div class="col-lg-12 col-md-2 col-sm-6 col-xs-5" > -->
<!-- 				<a id="add_row" class="btn btn-default pull-left">Add Row</a><a id='delete_row' class="pull-right btn btn-default">Delete Row</a> -->
<!-- 				</div>		 -->
				
				<div class="col-lg-12 col-md-2 col-sm-6 col-xs-5" >
				
<!-- 				<a id="exportData" class="btn btn-default pull-left">Export json</a> -->
				
				<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5 pull-right"  ><input type="text" name='discount' id='discount'  onkeyup="totalDiscount(0);" onkeydown="totalDiscount(0);"  placeholder='Discount' class="form-control"/></div>
				<div class="col-lg-1 col-md-2 col-sm-6 col-xs-5 pull-right"  ><label class="label_stru">Discount</label></div>
				</div>
				
					
				<div class="col-lg-12 col-md-2 col-sm-6 col-xs-5" >
				
<!-- 				<a id="exportData" class="btn btn-default pull-left">Export json</a> -->
				
				<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5 pull-right"  ><input type="text" name='totalPrice' id='totalPrice'    placeholder='Total' class="form-control"/></div>
				<div class="col-lg-1 col-md-2 col-sm-6 col-xs-5 pull-right"  ><label class="label_stru">Total</label></div>
				</div>
				
				
				
						
							<div class="col-lg-12 col-md-2 col-sm-6 col-xs-5" >
<table id="example" class="table table-striped table-bordered display compact hover order-column " class="cell-border" width="100%">
<thead>
 <tr>
                <th rowspan="1">Farmer Details</th>
                <th colspan="3">Cut Off</th>
                <th colspan="3">Payment Details</th>
            </tr>
        <tr>
            <th>FarmerCode</th>
            <th>Farmer Name</th>
            <th>P Code</th>
            <th>Date From</th>
            <th>date To</th>
            <th>Total Ltr</th>
            <th>Gross Amount</th>
        </tr>
    </thead>
     <tfoot>
            <tr>
                <th colspan="6" style="text-align:right">Total:</th>
                <th></th>
            </tr>
        </tfoot>
    </table>
    </div>
<!-- 		<div class="col-lg-2 col-md-1 col-sm-6" >Outstanding Amount</div> -->
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" style="padding-left: 3px;" > -->
							
<!-- 								<input type="text" id="outstandingAmount" /> -->
<!-- 						</div> -->
													
					</div>
<!-- 				 <div class="row mb">												 -->
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" ><label class="label_stru">From Date</label></div> -->
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" style="padding: 1px !important;" > -->
<!-- 							<div id="from_out_report_date"></div> -->
<!-- 						</div> -->
						
<!-- 							<div class="col-lg-2 col-md-2 col-sm-6" ><label class="label_stru">To Date</label></div> -->
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" style="padding: 1px !important;" > -->
<!-- 							<div id="to_out_report_date"></div> -->
<!-- 						</div> -->
						
<!-- <!-- 						<div class="col-lg-2 col-md-1 col-sm-6" >Item Type</div> --> 
<!-- <!-- 						<div class="col-lg-2 col-md-2 col-sm-6" style="padding: 1px !important;" > --> 
							
<!-- <!-- 								<div id="itemType"  style="float: left;" > </div> 	 --> 
<!-- <!-- 						</div> --> 
						
<!-- 						<div class="col-lg-1 col-md-2 col-sm-6" > -->
<!-- 						<button style="float: right;     margin-right: 15px;"  id="getBtn" class="btn btn-success btn-sm">Get</button> -->
<!-- 						</div>						 -->
<!-- 					</div>  -->
		
				<div id="oustandingReportGrid"></div>
				
			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
			<%@include file="..//footer.jsp" %>
		<!--footer end-->
		<input type="hidden" id="userId" value="<%=userId%>">
		<div class="loader"></div>
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/jquery-1.11.1.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/js/jquery.scrollTo.min.js"></script>
	<script src="resources/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="resources/js/jquery.sparkline.js"></script>
	
	<script src="resources/jqwidgets/jqxcore.js"></script>
	<script src="resources/jqwidgets/jqx-all.js"></script>
	<script src="resources/jqwidgets/globalization/globalize.js"></script>
	
	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
	<script src="resources/js/custom/Auth.js"></script>
	<script src="resources/js/custom/admin/SecurityDebo.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>
	
	<script type="text/javascript" src="resources/datatables/js/datatables.min.js"></script>
	<script type="text/javascript" src="resources/datatables/js/dataTables.buttons.min.js"></script>
	<script type="text/javascript" src="resources/datatables/js/buttons.html5.min.js"></script>
	
	<script type="text/javascript" src="resources/datatables/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script type="text/javascript" src="resources/datatables/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
	
	<script type="text/javascript" src="resources/datatables/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
	
	<script type="text/javascript" src="resources/jqueryJsonConverter/js/jquery.tabletojson.js"></script>
	
	<script type="text/javascript" src="resources/jqueryJsonConverter/js/jquery.tabletojson.min.js"></script>
	
	
	
	
<!-- 	 Jquery UI -->

<script type="text/javascript" src="resources/jquery-ui-1.11.4.custom/jquery-ui.js"></script>


<script type="text/javascript" src="resources/EasyAutocomplete-1.3.5/jquery.easy-autocomplete.js"></script>
<script type="text/javascript" src="resources/EasyAutocomplete-1.3.5/jquery.easy-autocomplete.min.js"></script>










	
	
	
	
	
	
	
	
	

	
</body>
    <script type="text/javascript">
        $(function () {
        	
        	var departmentId;
            $("#txtSearch").autocomplete({
                source: function (request, response) {
                    $.ajax({
                        url: 'getDepartmentSearchList?searchStr='+$("#txtSearch").val(),
//                         data: {
// //                         	searchStr : request.term
// 							searchStr:'sdds'

                          
//                         },
//                         data: "{ 'searchStr': '" + request.term + "'}",
                        dataType: "json",
                        type: "POST",
                        contentType: "application/json; charset=utf-8",
                        success: function (data) {
                            response($.map(data, function (item) {
                                return {
//                                     label: item.split('-')[0],
//                                     val: item.split('-')[1]
                                
                                label: item.departmentName+"-"+item.departmentId,
                                val: item.departmentId,
                                departmentId: item.departmentId
                                }
                            }))
                        }
                    });
                },
                minLength: 2,
    		    select: function(event, ui)
			    {
// 			    	alert("ui.label..."+ui.item.label);
// 	                	alert("ui.departmentId.."+ui.item.departmentId);
// 	                	alert("ui.nop.."+ui.item);
                	
                	AddDepartment(ui.item.val,ui.item.label);
				        $(this).val(ui.item.label);
				        $("input#drawing_number").val(ui.item.departmentName); 
			        return false;
			    },
                search: function (e, u) {
                	
                
                    $(this).addClass('loaderimg');
                },
                response: function (e, u) {
                    $(this).removeClass('loaderimg');
                }
            });
        });
    </script>


	
			<script type="text/javascript">
			
		
		
			function removeLine(lineNumber){
				
				 $("#addr"+lineNumber).html('');
				 updateQuoteTotal();
				
			}
			
				function AddDepartment(departId,departName){
					
					
					var qty=1;
					
					var dupilcateflag=false;
				
	

					var i=0;
					var depID='';
					var currentRowCount='';
					
					var incr= $("#dynamicTableRows td").closest("tr").length;
// 					$("#dynamicTableRows >tbody >tr").each(function() {
// 						alert("i incr.."+i);
						
// 						if(i>0){
							
// 							incr=i;
// // 							// dupilcateflag=true;	
// // 						alert("Secound rowCount.."+i-1);
						
// // 						depID = $("#depID"+i-1).val();
// // 						alert("depID.."+depID+"..departId.."+departId);
						
// // 						if(depID==departId){
// // 							 dupilcateflag=true;	
// // 							 currentRowCount=i-1;
// // 							 return false;
// // 						}
// 					}
// 						i++;
// 					});
					
// 					alert("toatl Row count.."+i);
// 					alert("toatl Row incr.."+incr);
					
					var j=0;
					
			$("#dynamicTableRows >tbody >tr").each(function() {
						
						if(j>0){
							// dupilcateflag=true;	
						//alert("Secound rowCount.."+j);
						
						depID = $("#depID"+(j-1)).val();
					//	alert("depID.."+depID+""+(j-1)+"..departId.."+departId);
						
						if(depID==departId){
							 dupilcateflag=true;	
							 currentRowCount=j-1;
							 return false;
						}
					}
						j++;
					});

					  if(dupilcateflag){
						var oldQty=$("#qty"+currentRowCount).val();
						$("#qty"+currentRowCount).val(parseInt(oldQty)+1);
						
						  
// 					  var newRow="<tr id='newRow"+dupId+"'><td><input type='hidden' name='depID"+dupId+"' value='"+departId+"'  /><input type='text' name='name"+departId+"' value='"+departName+"'  placeholder='Name' class='form-control'/></td><td><input type='text' name='price"+dupId+"' id='price"+dupId+"' onkeypress='return isNumberKey(event);' placeholder='Price' class='form-control'/></td><td><input type='text' name='qty'"+dupId+"'  id='qty"+dupId+"' value='"+qty+"' onkeyup='subTotalUpdate("+(i+1)+");' onkeydown='subTotalUpdate("+(i+1)+");' placeholder='Qty' class='form-control'/></td><td><input type='text' name='discount"+(i+1)+"' id='discount"+(i+1)+"' onkeypress='return onlyNos(event,this);' onkeyup='calculateDiscount("+dupId+");' onkeydown='calculateDiscount("+dupId+");' placeholder='Discount %' class='form-control'/></td><td><input type='text' name='subTotal"+(i+1)+"' id='subTotal"+(i+1)+"' placeholder='Sub Total' class='form-control'/></td><td class='text-center'><i class='fa fa-trash-o tip pointer posdel' id='1524823613364' onclick='removeLine("+(i+1)+");' title='Remove'></i></td><tr>";
// 					  $("#dynamicTableRows tbody").append(newRow);
					  }else{
						  
						  var newRow="<tr id='newRow"+incr+"'><td><input type='hidden' id='depID"+incr+"' value='"+departId+"'  /><input type='text' name='name"+departId+"' value='"+departName+"'  placeholder='Name' class='form-control'/></td><td><input type='text' name='price"+(incr)+"' id='price"+(incr)+"' onkeypress='return isNumberKey(event);' placeholder='Price' class='form-control'/></td><td><input type='text' name='qty'"+incr+"'  id='qty"+incr+"' value='"+qty+"' onkeyup='subTotalUpdate("+incr+");' onkeydown='subTotalUpdate("+incr+");' placeholder='Qty' class='form-control'/></td><td><input type='text' name='discount"+incr+"' id='discount"+incr+"' onkeypress='return onlyNos(event,this);' onkeyup='calculateDiscount("+incr+");' onkeydown='calculateDiscount("+incr+");' placeholder='Discount %' class='form-control'/></td><td><input type='text' name='subTotal"+i+"' id='subTotal"+i+"' placeholder='Sub Total' class='form-control'/></td><td class='text-center'><i class='fa fa-trash-o tip pointer posdel' id='1524823613364' onclick='removeLine("+incr+");' title='Remove'></i></td><tr>";
						  $("#dynamicTableRows tbody").append(newRow);  
						  
					  }
				}
				 
					
					 
					
				
			
			
			
			function totalDiscount(){
				var	discount=$("#discount").val();	
				
				var mainRow		= $("#tab_logic tr").length;
				
				if(discount!=undefined && discount!=''){
				for(var i=0; i<mainRow; i++){
					//alert(i);
				   $("#discount"+i).attr("readonly","true");
				}
				}else{
					
					for(var i=0; i<mainRow; i++){
						   $("#discount"+i).removeAttr("readonly");
						}
				}
				
				updateQuoteTotal();
				
// 			var oldSubTotal=$("#totalPrice").val();

// 			var	totalDiscount=$("#discount").val();	
// 			if(!isNumber(totalDiscount)){
				
// 				totalDiscount=0.00;
				
// 			}
// 		if(!isNumber(oldSubTotal)){
				
// 			oldSubTotal=0.00;
				
// 			}
				
// var discountCalculation=((parseFloat(oldSubTotal).toFixed(2)*parseFloat(totalDiscount).toFixed(2))/100);
				
// 				var afterDisount=parseFloat(oldSubTotal).toFixed(2)-discountCalculation;
// 				$("#totalPrice").val(afterDisount.toFixed(2));
				
			}
	
			
			function calculateDiscount(row){
				
				var price=$("#price"+row).val();
				var qty=$("#qty"+row).val();
				var subtotal=price*qty;
				
				var discount=$("#discount"+row).val();
				if(!isNumber(discount)){
					
					discount=0.00;
					
				}
				
				var discountCalculation=((subtotal.toFixed(2)*parseFloat(discount).toFixed(2))/100);
				
				var afterDisount=subtotal.toFixed(2)-discountCalculation;
				
				
				$("#subTotal"+row).val(afterDisount.toFixed(2));
				updateQuoteTotal();
			
				
// 				var olToatlCalu=parseFloat(oldTotal)+parseFloat(subtotal);
// 				$("#totalPrice").val(olToatlCalu);
			
				//alert("qty.."+qty);
				
			}
			
			
			function checkLineDiscount(){
				
				var j = 0;
				var discountFlag=false;
				$("#tab_logic tr").each(function() {
				
				
				var	discount = $("#discount"+j).val();
			//	alert("discount.."+discount);
					if(discount!=undefined && discount!=''){
						discountFlag=true;
					}
					
				
					j++;
				});
				
				//alert("discountFlag.."+discountFlag);
				
				
				if(discountFlag){
					 $("#discount").attr("readonly","true");
					
				}else{
					
					 $("#discount").removeAttr("readonly");
				}
				
				
			}
	
			
			function updateQuoteTotal(){
				
				checkLineDiscount();
				var total = 0;
				var i = 0;
				$("#tab_logic tr").each(function() {
				
				
					unitTotal = $("#subTotal"+i).val();
					//alert(i+",,,,,"+unitTotal);
					if (isNumber(unitTotal)) {
						total += parseFloat(unitTotal);
					 // alert(total);
						
					}
					i++;
				});
				
				/*var subtotal = total;
				// total=total;
				var gst = total * 0.07;
				var grandtotal = total + gst;
			*/
// 				$("#subtotal").val(total.toFixed(2));

	var	totalDiscount=$("#discount").val();	
	if(!isNumber(totalDiscount)){
		
		totalDiscount=0.00;
		
	}
	
	var discountCalculation=((total.toFixed(2)*parseFloat(totalDiscount).toFixed(2))/100);
	
	var afterDisount=total.toFixed(2)-discountCalculation;
			
				$("#totalPrice").val(afterDisount.toFixed(2));
			}
			
			
			function subTotalUpdate(row){
	
				var price=$("#price"+row).val();
				var qty=$("#qty"+row).val();
				var subtotal=price*qty;
				
				calculateDiscount(row);
				
			//	$("#subTotal"+row).val(subtotal.toFixed(2));
				
// 				var olToatlCalu=parseFloat(oldTotal)+parseFloat(subtotal);
// 				$("#totalPrice").val(olToatlCalu);
			
				//alert("qty.."+qty);
				updateQuoteTotal();
			}
			
			
			function isNumber(n) {
				return !isNaN(parseFloat(n)) && isFinite(n);
			}
			
			function checkDec(el){
				 var ex = /^[0-9]+\.?[0-9]*$/;
				 if(ex.test(el.value)==false){
				   el.value = el.value.substring(0,el.value.length - 1);
				  }
				}
			
			  function onlyNos(e, t) {

		            try {

		                if (window.event) {

		                    var charCode = window.event.keyCode;

		                }

		                else if (e) {

		                    var charCode = e.which;

		                }

		                else { return true; }

		                if (charCode > 31 && (charCode < 48 || charCode > 57)) {

		                    return false;

		                }

		                return true;

		            }

		            catch (err) {

		                alert(err.Description);

		            }

		        }
			
			  function isNumberKey(evt, obj) {

		            var charCode = (evt.which) ? evt.which : event.keyCode
		            var value = obj.value;
		            var dotcontains = value.indexOf(".") != -1;
		            if (dotcontains)
		                if (charCode == 46) return false;
		            if (charCode == 46) return true;
		            if (charCode > 31 && (charCode < 48 || charCode > 57))
		                return false;
		            return true;
		        }
			  
			 function isNumberKey(evt)
		       {
		          var charCode = (evt.which) ? evt.which : evt.keyCode;
		          if (charCode != 46 && charCode > 31 
		            && (charCode < 48 || charCode > 57))
		             return false;

		          return true;
		       }
			
			
			$('#exportData').click( function() {
				
			var tableData=	$("#tab_logic").find('input').serializeArray();
			alert("tableData.."+JSON.stringify(tableData));
// 				 var rows = [];
// 		           $('#tab_logic tr').each(function(i, n){
// 		                var $row = $(n);
// 		                rows.push({
// 		                    display_name: $row.find('td:eq(0)').val(),
// 		                    first_name:   $row.find('td:eq(1)').val(),
// 		                    last_name:    $row.find('td:eq(2)').val(),
// 		                    street:       $row.find('td:eq(3)').val(),
// 		                    city:         $row.find('td:eq(4)').val(),
// 		                    state:        $row.find('td:eq(5)').val(),
// 		                    zip:          $row.find('td:eq(6)').val()
// 		                });
// 		            });
		         //  alert("JSON.stringify(rows).."+JSON.stringify(rows));
		           

				  var table = $('#tab_logic').tableToJSON(); // Convert the table into a javascript object
				  console.log(table);
				  alert(JSON.stringify(table));
				});
			
		function removeLine(lineNumber){
			
			 $("#addr"+lineNumber).html('');
			 updateQuoteTotal();
			
		}
		
			function AddLine(i){
				  $('#addr'+(i+1)).html("<td class='text-center'><i class='fa fa-2x fa-plus-circle' onclick='AddLine("+(i+1)+");'></i></td><td><input type='text' name='name"+(i+1)+"' value=''  placeholder='Name' class='form-control'/></td><td><input type='text' name='price"+(i+1)+"' id='price"+(i+1)+"' onkeypress='return isNumberKey(event);' placeholder='Price' class='form-control'/></td><td><input type='text' name='qty'"+(i+1)+"'  id='qty"+(i+1)+"' onkeyup='subTotalUpdate("+(i+1)+");' onkeydown='subTotalUpdate("+(i+1)+");' placeholder='Qty' class='form-control'/></td><td><input type='text' name='discount"+(i+1)+"' id='discount"+(i+1)+"' onkeypress='return onlyNos(event,this);' onkeyup='calculateDiscount("+(i+1)+");' onkeydown='calculateDiscount("+(i+1)+");' placeholder='Discount %' class='form-control'/></td><td><input type='text' name='subTotal"+(i+1)+"' id='subTotal"+(i+1)+"' placeholder='Sub Total' class='form-control'/></td><td class='text-center'><i class='fa fa-trash-o tip pointer posdel' id='1524823613364' onclick='removeLine("+(i+1)+");' title='Remove'></i></td>");

			      $('#tab_logic').append('<tr id="addr'+(i+1)+'"></tr>');
				
				 
				
			}
			









	
	
	
	

		$(document).ready(function(e) {
			
// 			var options = {
// 					data: ["blue", "green", "pink", "red", "yellow"]
// 				};

// 				$("#basics").easyAutocomplete(options);
				
// 				var options = {
// 						url: "getDepartmentList",

// 						getValue: "departmentName",

// 						list: {
// 							match: {
// 								enabled: true
// 							}
// 						}
// 					};

// 					$("#basics").easyAutocomplete(options);


// var options = {
// 	url: "getHmbInchargeSummary?selected_month=August-2017",

// 	listLocation: "rows",

// 	getValue: "billNumber"
// };

// $("#basics").easyAutocomplete(options);

// var options = {
// 	url: "getHmbInchargeSummary?selected_month=August-2017",

// 	listLocation: "rows",

// 	getValue: "farmerCode",
// 	template: {
// 		type: "description",
// 		fields: {
// 			description: "billNumber"
// 		}
// 	}
// };

// $("#basics").easyAutocomplete(options);


var options = {
	url: "getHmbInchargeSummary?selected_month=August-2017",

	listLocation: "rows",

	getValue: "farmerCode",
	template: {
		type: "custom",
		method: function(value, item) {
			return ""+item.farmerCode+"-"+item.billNumber+"-"+item.dateFrom;
		}
	},
	theme: "dark",
	placeholder: "Please Select Farmer Code",
	list: {
		maxNumberOfElements: 10,
		match: {
			enabled: true
		},
		showAnimation: {
			type: "fade", //normal|slide|fade
			time: 400,
			callback: function() {}
		},

		hideAnimation: {
			type: "slide", //normal|slide|fade
			time: 400,
			callback: function() {}
		}
	},
	highlightPhrase: true

};

$("#basics").easyAutocomplete(options);

// 	$.ajax({
// 	type : "POST",
// 	url : "getMilkLiability",

// 	success : function(response) {
		
// 		var options = {
// 				data: response,

// 				listLocation: "rows",

// 				getValue: "farmerCode",
// 				template: {
// 					type: "custom",
// 					method: function(value, item) {
// 						return ""+item.farmerCode+"-"+item.billNumber+"-"+item.dateFrom;
// 					}
// 				},
// 				theme: "dark",
// 				placeholder: "Please Select Farmer Code",
// 				list: {
// 					maxNumberOfElements: 10,
// 					match: {
// 						enabled: true
// 					},
// 					showAnimation: {
// 						type: "fade", //normal|slide|fade
// 						time: 400,
// 						callback: function() {}
// 					},

// 					hideAnimation: {
// 						type: "slide", //normal|slide|fade
// 						time: 400,
// 						callback: function() {}
// 					}
// 				},
// 				highlightPhrase: true

// 			};

// 			$("#basics").easyAutocomplete(options);

// 	},
// 	dataType : "html"
// });





			
			
// 			$.getJSON("getMilkLiability", function(data){
// 			    $.each(data, function (index, value) {
			    	
// 			    	$.each(value, function(index, item) {
// 			        alert(item.inputDate);
// 			    	});
// 			    });
// 			});
			
			
// 			var dataArray = [];			
// 			$.ajax({
// 				type : "POST",
// 				url : "getMilkLiability",
				
// 				success : function(response) {
// 												//	alert("resp.."+response);

// // 					var json_obj = $.parseJSON(response);

// 					var obj =JSON.stringify(response);
				
					
// // 					 for( key in obj ) 
// // 						  dataArray.push([key.toString(), obj [key]]);

// 					$.each(obj, function (index, value) {
// 						alert("item.inputDate.."+JSON.stringify(value));
						
// // 					    dataArray.push([value.toString(), value[obj.inputDate] ]);
// 					});

					
// // 					alert("dataArray.."+dataArray);
					
// 					$.each(obj, function(index, items) {
// 						//alert("i.."+index);
// 						//	alert("items.."+items)
// 							$.each(items, function(index, item) {
						
// 					})
// 					})
					
// // 					alert("objArry.."+objArry);
// 				},
// 				dataType : "html"
// 			});
			
			
			
// 			function () {
// 				 $("#search").autocomplete({
// 				source: data,
// 				 autoFocus: true,
// 				});
// 				}
// 		);
		
		
// 		var opResult=getData();
			
			//alert("opResult.."+getData());
		
			 var customers = [{"name":"Urban Development","id":1},{"name":"Ball Corporation","id":2},{"name":"Apache Software Foundation","id":3},{"name":"The Coca-Cola Company","id":4},{"name":"Discovery Communications, Inc.","id":5},{"name":"Electronic Data Systems","id":6},{"name":"FreeWave Technologies, Inc.","id":7}] ;
// 			    $("#customer").autocomplete({ source: customers });
			
			
			
// 			$( "#search" ).autocomplete({ 
//     source: customers,
//     minLength: 1,
//     select: function( event, ui ) {
//         $( "#hd" ).val( ui.item.emp_id );
//         return false;
//     }       
// });
			
						$.ajax({
				type : "POST",
				url : "getDepartmentList",
				
				success : function(response) {
												//	alert("resp.."+response);

					var json_obj = response;

				//	alert("json_obj.."+json_obj);

					var op=null;


							$( "#searchList" ).autocomplete({
							     delay: 45,
							    source: json_obj,
								dataType: "json",
							    select: function(event, ui)
							    {
							    	alert("ui.item.nop.."+ui.item.departmentId);
					                //	alert("ui.nop.."+ui.nop);
				                	
								        $(this).val(ui.item.departmentName);
								        $("input#drawing_number").val(ui.item.departmentName); 
							        return false;
							    }
							});
						


					
				},
				dataType : "html"
			});
			
			
// 			$( "#searchList" ).autocomplete({
// 			     delay: 45,
// 			    source: 'getDepartmentList',
				
// 			    select: function(event, ui)
// 			    {
// 			    	alert("ui.item.nopdasas.."+ui.item.departmentId);
	                
               	
// 				        $(this).val(ui.item.departmentName);
// 				        $("input#drawing_number").val(ui.item.departmentName); 
// 			        return false;
// 			    }
// 			});
		
// 			$.ajax({
// 				type : "POST",
// 				url : "getMilkLiability",
				
// 				success : function(response) {
// 												//	alert("resp.."+response);

// 					var json_obj = $.parseJSON(response);

					

// 					var op=null;
// 					$.each(json_obj, function(index, items) {
// 						//alert("i.."+index);
// 						//	alert("items.."+items)
// 						$.each(items, function(index, item) {
							
// 							//console.log("item.inputDate.."+item.inputDate);
// 							alert("item.."+item.nop);
				
// // 							 $("search").autocomplete({
// // 					                source: item,
// // 					                select: function(event, ui)
// // 								    {
// // 					                	alert("ui.item.nop.."+ui.item.nop);
// // 					                	alert("ui.nop.."+ui.nop);
					                	
// // 								        $(this).val(ui.item.nop);
// // 								        $("input#drawing_number").val(ui.item.nop); 
// // 								        return false;
// // 								    }
// // 					            });

// op=item;

						


							
// 						})
// 					})
					
// 				},
// 				dataType : "html"
// 			});
		
// 			  $.ajax({
// 			        type: "POST",
// 			        url: "getMilkLiability",
// 			        dataType: "json",
// 			        data: "{}",
// 			        contentType: "application/json; charset=utf-8",
// 			        success: function(data) {
// 			            var datafromServer = JSON.stringify(data);
// 			            alert("datafromServer.sss."+datafromServer.split(":"));
// // 			            $("search").autocomplete({
// // 			                source: datafromServer
// // 			            });
// 			        },
// 			        error: function(XMLHttpRequest, textStatus, errorThrown) {
// 			           alert(textStatus);
// 			        }
// 			    });
		
			partTags = [{"label":"Part1","dwg":"A"},{"label":"Part2","dwg":"B"}]
// 			$( "#search33" ).autocomplete({
// 			     delay: 45,
// 			    source: 'getMilkLiability',
// 				dataType: "json",
// 			    select: function(event, ui)
// 			    {
// 			        $(this).val(JSON.stringify(ui.rows.item.inputDate));
// 			        $("input#drawing_number").val(JSON.stringify(ui.rows.item.inputDate)); 
// 			        return false;
// 			    }
// 			});
			
			
			
// 			$("#search").autocomplete({
// 			    source: function (request, response) {
// 			        $.ajax({
// 			            url: 'getHmbInchargeSummary?selected_month=August-2017',
// 			            dataType: "json",
// 			            data: {
// 			                SearchTerm: request.term
// 			            },
// 			            success: function (data) {
// 			                var parsed = JSON.stringify(data);
// 			                var newArray = new Array(parsed.length);
// 			                var i = 0;

// 			                parsed.forEach(function (entry) {
// 			                    var newObject = {
// 			                        label: entry.kwrdKeyWord
// 			                    };
// 			                    newArray[i] = newObject;
// 			                    i++;
// 			                });

// 			                response(newArray);
// 			            },
// 			            error: function (message) {
// 			                response([]);
// 			            }
// 			        });
// 			    },
// 			    minLength: 2
// 			});
			
// 			$( "#search").autocomplete({
// 			    source: function (request, response) {
// 					$.ajax(
// 						{
// 							url: 'getHmbInchargeSummary?selected_month=August-2017',
// 							dataType: "json",
// 							data:
// 							{
// 								term: request.term,
// 							},
// 							success: function (data)
// 							{
// 								alert("res.."+data);
// 								response( $.map( JSON.stringify(data.rows), function( item ) {
									
// 									//alert("data.rows.."+JSON.stringify(data.rows));
// 									  return {
// 										label: item.billNumber,
// 										value: item.billNumber,
									
// 										};
// 									}
// 								 ));
// 							}
// 						});
// 			    },
// // 			    search: function () {
// // 		         var term = extractLast(this.value);
// // 			     },
// // 			    focus: function () {
// // 			         return false;
// // 			    },
// 			    select: function (event, ui) {
// 			    	   this.value = ui.item.billNumber;
// 			    	    $("#search").val(ui.item.billNumber);
// // 			  	    updateQuoteReference(ui.item.customercode);
// // 			  	    valueset(ui.item.value);
// 			         return false;
// 			    }
// 			});
			
			
			
			
			
// 			$( "#search" ).autocomplete({
// 			     delay: 45,
// 			    source: 'getHmbInchargeSummary?selected_month=August-2017',
// 			    select: function(event, ui)
// 			    {

// 			        $(this).val(ui.item.rows.billNumber+"-"+ui.item.billNumber);
// 			        $(this).closest('tr').find("input[id^='drawing_number']").val(ui.item.rows.billNumber); 
// 			        return false; // find the drawing number input on that row
// 			    }
// 			 });
// 			    }).data( "autocomplete" )._renderItem = function(ul, item){
// 			        if(item.dwg!=null ||  item.dwg!='') // if the drawing is null or empty
// 			        {
// 			            return $( "<li></li>" ).data( "item.autocomplete", item ).append( "<a><strong>" + item.label + "</strong> - Rev " + item.dwg + "</a>" ).appendTo( ul );
// 			        }
// 			        else
// 			        {
// 			            return $( "<li></li>" ).data( "item.autocomplete", item ).append( "<a><strong>" + item.label + "</strong></a>" ).appendTo( ul );
// 			        }
// 			    };
			
			
// 		
			
// 			$( "#search" ).autocomplete({
// 			     delay: 45,
// 			    source: partTags,
// 			    select: function(event, ui)
// 			    {

// 			        $(this).val(ui.item.label);
// 			        $(this).closest('tr').find("input[id^='drawing_number']").val(ui.item.dwg); 
// 			        return false; // find the drawing number input on that row
// 			    }
// 			    }).data( "autocomplete" )._renderItem = function(ul, item){
// 			        if(item.dwg!=null ||  item.dwg!='') // if the drawing is null or empty
// 			        {
// 			            return $( "<li></li>" ).data( "item.autocomplete", item ).append( "<a><strong>" + item.label + "</strong> - Rev " + item.dwg + "</a>" ).appendTo( ul );
// 			        }
// 			        else
// 			        {
// 			            return $( "<li></li>" ).data( "item.autocomplete", item ).append( "<a><strong>" + item.label + "</strong></a>" ).appendTo( ul );
// 			        }
// 			    };
			
	
			
			
			

			
			
			
			  var i=1;
			     $("#add_row").click(function(){
			      $('#addr'+i).html(" <td class='text-center'><i class='fa fa-2x fa-plus-circle' onclick='AddLine("+i+");'></i></td>     <td>"+ (i+1) +"</td><td><input name='name"+i+"' type='text' placeholder='Name' class='form-control input-md'  /> </td><td><input  name='mail"+i+"' type='text' placeholder='Mail'   class='form-control input-md'></td><td><input  name='mobile"+i+"' type='text' placeholder='Mobile'  class='form-control input-md'></td>");

			      $('#tab_logic').append('<tr id="addr'+(i+1)+'"></tr>');
			      i++; 
			  });
			     $("#delete_row").click(function(){
			    	 if(i>1){
					 $("#addr"+(i-1)).html('');
					 i--;
					 }
				 });
			
	
			 var buttonCommon = {
				        exportOptions: {
				            format: {
				                body: function ( data, row, column, node ) {
				                    // Strip $ from salary column to make it numeric
				                    return column === 5 ?
				                        data.replace( /[$,]/g, '' ) :
				                        data;
				                }
				            }
				        }
				    };
			
// 			  $('#example').DataTable( {
// 				  "processing": true,
// 			        "serverSide": true,
// 			        "ajax": "getAverageMilkMonthWise?selectedYear=2017",
// 			        "columns": [
// 			            { "data": "compCode" },
// 			            { "data": "avgmonth" },
// 			            { "data": "compCode" },
// 			            { "data": "avgmonth" }
// 			        ]
// 			    } );

//   $('#example').DataTable( {
// 	  "processing": true,
// 	  dataType : 'json',
//         "ajax": 'getAverageMilkMonthWise?selectedYear=2017',
//         	 dataSrc: 'rows'
        	 
//     } );
			function LoadCurrentReport(oResults) {
				alert("oResults.."+oResults);
 
//     var aDemoItems  = oResults.lDemographicItems; 
//     alert("aDemoItems.."+aDemoItems);
    //
     var jsonString = JSON.stringify(oResults  ) //for testing
    
    alert("jsonString.."+jsonString);
     
   //Load  datatable
    var oTblReport = $("#example");
 
    oTblReport.DataTable ({
        "data" : jsonString,

        "columns" : [
            { "rows" : "compCode" },
            { "rows" : "avgmonth" },
            { "rows" : "avgMilk" },
            { "rows" : "avgFat" }
         
        ]
    });
}
// 			 $('#example').DataTable({
// 			        "processing" : true,
// 			        "ajax" : {
// 			            "url" : "https://api.myjson.com/bins/14t4g",
// 			            dataSrc : ''
// 			        },
// 			        "columns" : [ {
// 			            "data" : "id"
// 			        }, {
// 			            "data" : "name"
// 			        }, {
// 			            "data" : "lat"
// 			        }, {
// 			            "data" : "lon"
// 			        }]
// 			    });
			 
			 $('#example').DataTable({
			//	 "dom": '<"top"i>rt<"bottom"flp><"clear">',
			//	 "order": [[ 3, "asc" ]],
// 			  "dom": '<"top"iflp<"clear">>rt<"bottom"iflp<"clear">>'

			 "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
			     "columnDefs": [ {
			            "targets": [ 0 ],
			            "orderData": [ 0, 1 ]
// 			            "visible": false,
// 		                "searchable": false
			        }, {
			        	"targets": [ 1 ],
			        	"orderData": [ 1, 0 ]
			        }, {
			        	"targets": [ 3 ],
			        	"orderData": [ 3, 0 ]
			        } ]
			        ,
			        "pagingType": "full_numbers",
			        "ajax" : {
			            "url" : "getHmbInchargeSummary?selected_month=August-2017",
			            dataSrc : 'rows'
			        },
			        dom: 'Bfrtip',
			        buttons: [
			            $.extend( true, {}, buttonCommon, {
			                extend: 'copyHtml5'
			            } ),
			            $.extend( true, {}, buttonCommon, {
			                extend: 'excelHtml5'
			            } ),
			            $.extend( true, {}, buttonCommon, {
			                extend: 'pdfHtml5'
			            } )
			        ],
// 			        "createdRow": function ( row, data, index ) {
// 			        	alert("data"+data[3]);
// 			            if ( data[5].replace(/[\$,]/g, '') * 1 > 150000 ) {
// 			                $('td', row).eq(5).addClass('highlight');
// 			            }
// 			        },

       "displayLength": 10,
       "deferRender": true,
        "drawCallback": function ( settings ) {
            var api = this.api();
            var rows = api.rows( {page:'current'} ).nodes();
            var last=null;
 
            api.column(0, {page:'current'} ).data().each( function ( group, i ) {
                if ( last !== group ) {
                    $(rows).eq( i ).before(
                        '<tr class="group"><td colspan="5">'+group+'</td></tr>'
                    );
 
                    last = group;
                }
            } );
        },
        "footerCallback": function ( row, data, start, end, display ) {
            var api = this.api(), data;
 
            // Remove the formatting to get integer data for summation
            var intVal = function ( i ) {
                return typeof i === 'string' ?
                    i.replace(/[\$,]/g, '')*1 :
                    typeof i === 'number' ?
                        i : 0;
            };
 
            // Total over all pages
            total = api
                .column( 6 )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
 
            // Total over this page
            pageTotal = api
                .column( 6, { page: 'current'} )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
 
            // Update footer
            $( api.column( 6 ).footer() ).html(
                ''+parseFloat(pageTotal).toFixed(2) +' ('+ parseFloat(total).toFixed(2) +' total)'
            );
        },
			        "columns" : [ {
			            "data" : "farmerCode"
			        }, {
			            "data" : "farmerName"
			        }, {
			            "data" : "pCode"
			        }, {
			            "data" : "dateFrom"
			        },
			        {
			            "data" : "dateTo"
			        },
			        {
			            "data" : "totalLtr"
			        },{
			            "data" : "grossAmount"
			        }]
			    });
	
			
// 			$('#example').DataTable({
// 				  //'deferRender': false,
// 				  'ajax'       : {
// 				    "type"   : "POST",
// 				    "url"    :"getAverageMilkMonthWise?selectedYear=2017",
// 				    "dataSrc": function (json) {
// 				    	alert("json.."+ JSON.stringify(json));
// 				    	var local= JSON.stringify(json);
// 				    	alert("local.."+local);
// 				      var return_data = new Array();
// 				      for(var i=0;i< local.length; i++){
// 				    	  alert("json[i].compCode"+json[i].rows[0]);
// 				        return_data.push({
// 				          'title': json[i].compCode,
// 				          'url'  :  json[i].compCode,
// 				          'date' : json[i].compCode
// 				        })
// 				      }
// 				      return return_data;
// 				    }
// 				  },
// 				  "columns"    : [
// 				    {'data': 'url'},
// 				    {'data': 'title'},
// 				    {'data': 'date'}
// 				  ]
// 				});
		
			
// 			$('#example').dataTable( {
// 				  "ajax": {
// 				    "url": "getAverageMilkMonthWise?selectedYear=2017",
// 				    "contentType": "application/json",
// 				    "type": "POST",
// 				    "data": function ( d ) {
// 				      return JSON.stringify( d );
// 				    }
// 				  }
// 				} );
			
			 $.getJSON('getAverageMilkMonthWise?selectedYear=2017', function (data) {
				 //alert("dsd"+JSON.stringify(data));
				 
				//  $("#example").html(data.rows[0].avgmonth );
				//LoadCurrentReport(data);
// 				   $.each(data, function(i, field){
// 			           alert(field.rows + " ");
// 			        });
				 
			      console.log(data);

		
			 });
// 			 var table = $('#example').DataTable();
// 			  $('#example tbody').on( 'click', 'tr.group', function () {
// 			        var currentOrder = table.order()[0];
// 			        if ( currentOrder[0] === 2 && currentOrder[1] === 'asc' ) {
// 			            table.order( [ 2, 'desc' ] ).draw();
// 			        }
// 			        else {
// 			            table.order( [ 2, 'asc' ] ).draw();
// 			        }
// 			    } );
		
// 			 var table = $('#example').DataTable();
// 			 $('#example tbody').on('click', 'tr', function () {
// 			        var data = table.row( this ).data();
// 			        alert( 'You clicked on '+data[1]+'\'s row' );
// 			    } );
			
			 $.getJSON('getVendorData', function (data) {
			//	 alert("dsd"+data.vendorName);
				 
					if(data.address!="E"){
						$('#vendorName').val(data.vendorName);
						$('#vendorCode').val(data.vendorCode);
							
										
					}
				 
			      console.log(data);

// 			      var items = data.items.map(function (item) {
// 			        return item.key + ': ' + item.value;
// 			      });
			 });
			
			 $.getJSON('getDailyUpdateDate?menuName=Security Deposit Status', function (data) {
				 
					if(data.address!="E"){
						$('#daily_update_date').text(data.dailyUpdateDate);

										
					}
				 
			      console.log(data);

			 });
			
		

	});
	</script> 


</html>







<%}%>