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

<title>Monthly Vehicle Details</title>

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
			<%@include file="header.jsp" %>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<%@include file="menu.jsp" %>
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<%@include file="Breadcrump.jsp" %>
				
							
			
					<div class="row mt mb" style="padding-top: 7px">

					
						
							<div class="col-lg-2 col-md-1 col-sm-6 col-xs-5" ><label class="label_stru">Vendor Code</label></div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5" style="padding: 1px !important;" >
							
								<input type="text" id="vendorCode"   />
						</div>
						
							<div class="col-lg-2 col-md-1 col-sm-6 col-xs-5"  ><label class="label_stru">Vendor Name</label></div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-5" style="padding: 1px !important;" >
							
								<input type="text" id="vendorName"  />
						</div>
				
<!-- 		<div class="col-lg-2 col-md-1 col-sm-6" ><label class="label_stru">Outstanding Amount</label></div> -->
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" style="padding-left: 3px;" > -->
							
<!-- 								<input type="text" id="outstandingAmount" /> -->
<!-- 						</div> -->
													
					</div>
				 <div class="row mb">												
						<div class="col-lg-2 col-md-1 col-sm-6 col-xs-5" ><label class="label_stru">From Date</label></div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5" style="padding: 1px !important;" >
							<div id="from_out_report_date"></div>
						</div>
						
							<div class="col-lg-2 col-md-1 col-sm-6 col-xs-5" ><label class="label_stru">To Date</label></div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5" style="padding: 1px !important;" >
							<div id="to_out_report_date"></div>
						</div>
						
<!-- 						<div class="col-lg-2 col-md-1 col-sm-6" ><label class="label_stru">Item Type</label></div> -->
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" style="padding: 1px !important;" > -->
							
<!-- 								<div id="itemType"  style="float: left;" > </div> 	<button style="float: right;     margin-right: 15px;"  id="getBtn" class="btn btn-success btn-sm">Get</button> -->
<!-- 						</div> -->
						
						<div class="col-lg-1 col-md-1 col-sm-6 col-xs-2" >
						<button   id="getBtn" class="btn btn-success btn-sm">Get</button>
						</div>						
					</div> 
		
				<div id="oustandingGrid"></div>
				<div class="modal fade bd-example-modal-lg  footer-to-bottom"
					id="hmbSummaryModel" tabindex="-1" role="dialog"
					data-keyboard="false" data-backdrop="static"
					aria-labelledby="myLargeModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h6 class="modal-title">Procurement Logistics Transporter Payment Summary Report</h6>
							</div>
							<div class="panel-body table-responsive">
								<!-- <div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12" style="text-align: center;">
										<h3><b>HATSUN AGRO PRODUCT LIMITED</b></h3><br/>
										<h6><b>Procurement Logistics Transporter Payment Summary Report</b></h6>
									</div>
								</div> -->
								<div class="row">									
									<div class="col-lg-2 col-md-3 col-sm-6">Transport Vendor</div>
									<div class="col-lg-4 col-md-3 col-sm-6"><div id="transporterCodeM"></div></div>
									<div class="col-lg-2 col-md-3 col-sm-6">Transport Name</div>
									<div class="col-lg-4 col-md-3 col-sm-6"><div id="transporterNameM"></div></div>
								</div>
								<div class="row">
									<div class="col-lg-2 col-md-3 col-sm-6">Transporter City</div>
									<div class="col-lg-4 col-md-3 col-sm-6"><div id="transporterCityM"></div></div>
									<div class="col-lg-2 col-md-3 col-sm-6">Cutoff</div>
									<div class="col-lg-4 col-md-3 col-sm-6"><div id="cutoffM"></div></div>
									
								</div>
								<div class="row">
									<div class="col-lg-2 col-md-3 col-sm-6">PAN</div>
									<div class="col-lg-4 col-md-3 col-sm-6"><div id="panM"></div></div>
									<div class="col-lg-2 col-md-3 col-sm-6">Account Number</div>
									<div class="col-lg-4 col-md-3 col-sm-6"><div id="accNoM"></div></div>
								</div>
								<div class="row">
									<div class="col-lg-2 col-md-3 col-sm-6">Bank Name</div>
									<div class="col-lg-4 col-md-3 col-sm-6"><div id="bankNameM"></div></div>
									<div class="col-lg-2 col-md-3 col-sm-6">IFSC Code</div>
									<div class="col-lg-4 col-md-3 col-sm-6"><div id="ifscCodeM"></div></div>									
								</div>
								<div class="row mb">
									<div class="col-lg-2 col-md-3 col-sm-6">Contact Number</div>
									<div class="col-lg-4 col-md-3 col-sm-6"><div id="contactNoM"></div></div>
									<div class="col-lg-2 col-md-3 col-sm-6">Division</div>
									<div class="col-lg-4 col-md-3 col-sm-6"><div id="divisionM">Procurement Logistics</div></div>
								</div>	
								<div class="row mb">
									<div class="col-lg-12 col-md-12 col-sm-12">						
										<table class="table table-bordered table-fixed"
											id="payemntTable">
											<thead style="backgroud-color: aliceblue;">
												<tr>
													<th class="table-header_align_payment">Plant</th>
													<th class="table-header_align_payment">Plant Desc</th>
													<th class="table-header_align_payment">Route</th>
													<th class="table-header_align_payment">Route Desc</th>
													<th class="table-header_align_payment">Date</th>
													<th class="table-header_align_payment">KM</th>
													<th class="table-header_align_payment">Fixed</th>
													<th class="table-header_align_payment">Rate</th>
													<th class="table-header_align_payment">Hire</th>
													<th class="table-header_align_payment">Vehicle Number</th>
													<th class="table-header_align_payment">Vehicle Model</th>
												</tr>
											</thead>
											<tbody>
		
											</tbody>
											<tfoot>
											</tfoot>
										</table>
									</div>
								</div>
								<div class="row mb">
									<div class="col-lg-6 col-md-6 col-sm-12">
										<table class="table table-bordered table-fixed"
											id="arrearTable">
											<thead style="backgroud-color: aliceblue;">
												<tr>
													<th class="table-header_align_payment">Arrear Description</th>
													<th class="table-header_align_payment">Amount</th>
												</tr>
											</thead>
											<tbody></tbody>
										</table>	
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12">
										<table class="table table-bordered table-fixed"
											id="deductionTable">
											<thead style="backgroud-color: aliceblue;">
												<tr>
													<th class="table-header_align_payment">Deduction Description</th>
													<th class="table-header_align_payment">Amount</th>
												</tr>
											</thead>
											<tbody></tbody>
										</table>	
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12" style="text-align: left;"><div>Net Payable Amount(INR):<span id="netAmount"></span></div></div>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				
			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
			<%@include file="footer.jsp" %>
		<!--footer end-->
		<input type="hidden" id="userId" value="<%=userId%>">
		<div class="loader"></div>
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/jquery-1.11.1.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/js/jquery.scrollTo.min.js"></script>
	<script src="resources/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="resources/js/jquery.sparkline.js"></script>
	
	<script src="resources/jqwidgets/jqxcore.js"></script>
	<script src="resources/jqwidgets/jqx-all.js"></script>
	<script src="resources/jqwidgets/globalization/globalize.js"></script>
	
	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
	<script src="resources/js/custom/Auth.js"></script>
	<script src="resources/js/custom/MonthlyVehicleDetailsForLogistics.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>

	
</body>

	
			<script type="text/javascript">
			

		$(document).ready(function(e) {
			 $.getJSON('getVendorData', function (data) {
				if(data.address!="E"){
					$('#vendorName').val(data.vendorName);
					$('#vendorCode').val(data.vendorCode);
					$('#transporterCodeM').text(data.vendorCode);	
					$('#transporterNameM').text(data.vendorName);
					$('#panM').text(data.panNo);
					$('#accNoM').text(data.accountNo);
					$('#transporterCityM').text(data.city);
					$('#bankNameM').text(data.bankName);
					$('#ifscCodeM').text(data.ifcCode);
					$('#contactNoM').text(data.mobile1);
				}				 
			    console.log(data);
			 });	

	});
		
		 $.getJSON('getDailyUpdateDate?menuName=Monthly Vehicle Details For Logistics', function (data) {
			 
				if(data.address!="E"){
					$('#daily_update_date').text(data.dailyUpdateDate);

									
				}
			 
		      console.log(data);

		 });

		
		
	</script> 


</html>







<%}%>