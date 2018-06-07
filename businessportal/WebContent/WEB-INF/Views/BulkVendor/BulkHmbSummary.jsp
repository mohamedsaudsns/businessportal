
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

<title>Bulk Summary</title>

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
<link href="resources/jqwidgets/styles/jqx.bootstrap.css"
	rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-start.css"
	rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-redmond.css"
	rel="stylesheet">

<!-- <script src="assets/js/chart-master/Chart.js"></script> -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
.tableHeader {
	font-weight: 800;
}

/* #serviceTable, #serviceInnerTable, #serviceInnerTable2 { */
/* 	font-size: 10px; */
/* } */

.table-responsive {
	max-height: 500px;
	overflow-y: auto;
}

.table-fixed thead {
	width: 97%;
}

.table-fixed tbody {
	max-height: 300px;
	overflow-y: auto;
	width: 100%;
}

#serviceInnerTable td {
	border-top: 0px solid ! important;
}

#serviceInnerTable2 td {
	border-top: 0px solid ! important;
}

#serviceTable td {
	border-top: 0px solid ! important;
}
/* .table-fixed thead, .table-fixed tbody, .table-fixed tr, .table-fixed td, .table-fixed th { */
/*   display: block; */
/* } */
/* .table-fixed tbody td, .table-fixed thead > tr> th { */
/*   float: left; */
/*   border-bottom-width: 0; */
/* } */
.table-header_align_payment {
	text-align: center;
	background-color: #92e2b5;
}

.table-header_align {
	text-align: center;
}

.table-header-align-right {
	text-align: right;
}

.table-header-align-left {
	text-align: left;
}

#payementTotalValue {
	font-size: 14px;
	padding-right: 19px;
}

#payementTotalLtrs, #payementTotalAmount, #payementTotalDeduction,
	#payementTotalArrear, #payementNetAmount {
	font-size: 14px;
	
}
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
		<%@include file="../header.jsp"%>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<%@include file="../menu.jsp"%>
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<%@include file="../Breadcrump.jsp"%>


				<div class="row mb">
											<div class="col-lg-1 col-md-1 col-sm-6 col-xs-5">
						<label class="label_stru">Month</label>
					</div>
					
					<div class="col-lg-2 col-md-1 col-sm-6 col-xs-5">
					
					
					<select id="lastThreeMonth" class="selectTagDesign">

</select>
</div>

	<div class="col-lg-1 col-md-1 col-sm-6 col-xs-5">
						<label class="label_stru">Year</label>
					</div>
					
					<div class="col-lg-2 col-md-1 col-sm-6 col-xs-5">
					
					
					<select id="lastThreeMonthYear" class="selectTagDesign">

</select>
</div>
				
<!-- 					<div class="col-lg-2 col-md-1 col-sm-6 col-xs-4"> -->
<!-- 						<label class="label_stru">Month</label> -->
<!-- 					</div> -->
<!-- 					<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5" -->
<!-- 						style="padding: 1px !important;"> -->
<!-- 						<div id="hmbMonth"></div> -->


<!-- 					</div> -->
					<div class="col-lg-1 col-md-1 col-sm-6 col-xs-2">
						<button id="getBtn" class="btn btn-success btn-sm">Get</button>
					</div>


				</div>

				<div id="hmbSummaryGrid"></div>

			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
		<%@include file="../footer.jsp"%>
		<!--footer end-->
		<input type="hidden" id="userId" value="<%=userId%>">
		<div class="loader"></div>


<div class="modal fade bd-example-modal-lg  footer-to-bottom"
			id="hmbSummaryModel" tabindex="-1" role="dialog"
			data-keyboard="false" data-backdrop="static"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Modal title</h4>

					</div>
					<!-- 					<div class="modal-body"> -->
					<div class="panel-body table-responsive">
						<table class="table table-bordered table-fixed" id="payemntTable">

							<thead style="backgroud-color: aliceblue;">
								<tr>
									<th class="table-header_align_payment">Particulars</th>
									<th class="table-header_align_payment">Date / Shift</th>
									
									<th class="table-header_align_payment">Ltrs</th>
									<th class="table-header_align_payment">FAT</th>
									<th class="table-header_align_payment">SNF</th>
									<th class="table-header_align_payment">Rate/Ltr</th>
									<th class="table-header_align_payment">Add.Rate/Ltr</th>
									<th class="table-header_align_payment">Total.Amt</th>
									<!-- 										<th class="table-header_align">Incentive</th> -->

								</tr>
							</thead>
							<tbody>

							</tbody>
							<tfoot>
							</tfoot>

						</table>

						<table class="table table-bordered table-fixed"
							id="deductionTable">

							<thead>
								<tr>
									<!-- 									<th class="table-header_align">S.No</th> -->
									<!-- 									<th class="table-header_align">Particulars</th> -->
									<!-- 									<th class="table-header_align">Amount</th> -->

								</tr>
							</thead>
							<tbody>

							</tbody>
							<tfoot>
							</tfoot>

						</table>

						<table class="table table-bordered table-fixed" id="recoveryTable">

							<thead>
								<!-- 								<tr> -->
								<!-- 									<th class="table-header_align">S.No</th> -->
								<!-- 									<th class="table-header_align">Particulars</th> -->
								<!-- 									<th class="table-header_align">Amount</th> -->

								<!-- 								</tr> -->
							</thead>
							<tbody>

							</tbody>
							<tfoot>
							</tfoot>

						</table>
					</div>


					<!-- 					</div> -->
					<div class="modal-footer">
						<div class="pull-right">


							<table class="table table-bordered table-fixed" id="footerTotal">

								<tbody>
									<tr id="payementTotalLtrsTr">


										<td class='table-header-align-left'>Total Ltrs</td>

										<td class='table-header-align-right'><span
												id="payementTotalLtrs"></span></td>
									</tr>


									<tr id="payementTotalAmountTr">


										<td class='table-header-align-left'>Total Amt</td>

										<td class='table-header-align-right'><span
												id="payementTotalAmount"></span></td>
									</tr>


									<tr id="payementTotalDeductionTr">

										<td class='table-header-align-left'>Deduction</td>

										<td class='table-header-align-right'><span
												id="payementTotalDeduction"></span></td>
									</tr>

									<tr id="payementTotalArrearTr">

										<td class='table-header-align-left'>Arrear</td>

										<td class='table-header-align-right'><span
												id="payementTotalArrear"></span></td>
									</tr>




									<tr id="payementNetAmountTr">

										<td class='table-header-align-left'>Net.Amt</td>

										<td class='table-header-align-right'><span
												id="payementNetAmount"></span></td>
									</tr>


								</tbody>


							</table>
						</div>

					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

		




		<div id="hmbSummaryModel122" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body">
						<!--       	<div id="hmbPaymentSummaryGrid"></div> -->


					</div>
					<div class="modal-footer">
						<!--        <label class="col-xs-3 control-label">Enter Your OTP Code</label> -->
						<!--                         <div class="col-xs-5"> -->
						<!--                             <input type="password" class="form-control" name="currentOtp" id="currentOtp"  /> -->
						<!--                         </div> -->
						<!--                           <div class="col-xs-2"> -->
						<!--         <button type="button" class="btn btn-success login" onclick="validateOtp()">Verify</button> -->
					</div>
				</div>
			</div>

		</div>
		<!-- </div> -->



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
	<script src="resources/js/custom/BulkVendor/BulkHmbSummary.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>


</body>
<style type="text/css">
#vendorCode, #vendorName, #outstandingAmount {
	background: #252422 ! important;
	color: antiquewhite ! important;
}

.ui-datepicker-calendar {
	display: none;
}
</style>


<script type="text/javascript">

function setMonthAndYear(){
	
	var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
	 var lastDates = new Date();
	 lastDates.setDate(lastDates.getDate()-90);
	 
//		 alert("day.."+lastDates.getDate());
	
	var month =lastDates.getMonth();
//		alert("month.."+month);
	
	
	 $('#lastThreeMonth').append('<option>' + monthNames[month] + '</option>');
	 $('#lastThreeMonth').append('<option>' + monthNames[month+1] + '</option>');
	 $('#lastThreeMonth').append('<option>' + monthNames[month+2] + '</option>');
	 
		var endMonth = (new Date()).getMonth();
		
		 $('#lastThreeMonth').append('<option>' + monthNames[endMonth] + '</option>');
	
//		var inr=0;
//		for (; month < monthNames.length; month++) {
//			inr++;
//			if(inr<=3){
//		  $('#lastThreeMonth').append('<option>' + monthNames[month] + '</option>');
//			}
		
//		}
	var d = new Date();
	d.setMonth(d.getMonth() - 2);
	
	var startYear = d.getFullYear();
	 $('#lastThreeMonthYear').append('<option>' + startYear + '</option>');


	var endYearMonth = new Date();
	endYearMonth.setMonth(d.getMonth());
	
	var endYear = endYearMonth.getFullYear();
	 $('#lastThreeMonthYear').append('<option>' + endYear + '</option>');
	 
	 var map = {};
	 $('select option').each(function () {
	     if (map[this.value]) {
	         $(this).remove()
	     }
	     map[this.value] = true;
	 })
	
}
			

		$(document).ready(function(e) {
			
			setMonthAndYear();
			$('#lastThreeMonth option:last-child').attr('selected', 'selected');
			$('#lastThreeMonthYear option:last-child').attr('selected', 'selected');

			 $.getJSON('getDailyUpdateDate?menuName=Bulk HMB Summary', function (data) {
				 
					if(data.address!="E"){
						$('#daily_update_date').text(data.dailyUpdateDate);

										
					}
				 
			      console.log(data);

			 });
			

			

		

	});
	</script>  

</html>







<%}%>