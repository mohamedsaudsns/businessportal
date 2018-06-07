
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Hatsun Business Portal">

<title>Service Charge Details</title>

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

/* .table-responsive { */
/* 	max-height: 500px; */
/* 	overflow-y: auto; */
/* } */

.header_bold{
font-weight: 900;

}


.hmbServiceChargeTitle,.hmbNewServiceChargeTitle{


    color: #ffffff;
    font-weight: bolder;
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

#outstandingAmount{
text-align: right;

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
				
				
<!-- 					<div class="col-lg-1 col-md-1 col-sm-6 col-xs-6"> -->
<!-- 						<label class="label_stru">Month</label> -->
<!-- 					</div> -->
<!-- 					<div class="col-lg-2 col-md-2 col-sm-6 col-xs-4" -->
<!-- 						style="padding: 1px !important;"> -->
<!-- 						<div id="hmbMonth"></div> -->


<!-- 					</div> -->
						<div class="col-lg-1 col-md-1 col-sm-6 col-xs-2" >
						<button id="getBtn" class="btn btn-success btn-sm">Get</button>
					</div>
					
	
				


				</div>

			
	
				<div id="ffServiceChargeGrid"></div>

				
			


			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
		<%@include file="../footer.jsp"%>
		<!--footer end-->
		<input type="hidden" id="userId" value="<%=userId%>">
		<div class="loader"></div>



		


<!-- HMB New Payslip start -->

<div class="modal fade bd-example-modal-lg  footer-to-bottom"
			id="hmbNewServiceChargeModel" tabindex="-1" role="dialog"
			data-keyboard="false" data-backdrop="static"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="hmbNewServiceChargeTitle">Modal title</h4>

					</div>
					<!-- 					<div class="modal-body"> -->
					<div class="panel-new-payslip-body table-new-payslip-responsive">
						<table class="table  table-fixed" id="serviceTable">

							<thead style="backgroud-color: aliceblue;">
								<tr>
									<td colspan="4" class="table-header_align" style="font-weight: 900; font-size: 15px;     padding-bottom: 15px; ">Hatsun Agro Product Ltd</td>
									

								</tr>
								<tr>
									<td class="hmbNewSerAddress"></td>
										
											<td style="font-weight: 900; ">Chilling Centre	<td>
											<td class="hmbNewSerCity"></td>
										
<!-- 									<td class="hmbSerPincode"></td> -->

								</tr>
								<tr>
<!-- 									<td>Service Charge for the Period From           <span class="cStartDate"></span>          To -->
									
<!-- 									 <span class="cEndDate"></span> -->
<!-- 										</td> -->
										
										
								</tr>
							</thead>
							<tbody>

								<table class="table  table-fixed" id="serviceInnerTable">
									<tr style="border-top: 1px solid;">
										<td class="header_bold">HMB Code</td>
										<td  class="header_bold" >:</td>
										<td class="hmbNewCode"></td>
									
												
												<td  class="header_bold">Avg Qty / Day</td>
										<td class="header_bold">:</td>
										<td class="hmbNewAvgQtyDay" ></td>
										
<!-- 										<td  class="header_bold">HMB Route</td> -->
<!-- 										<td  class="header_bold">:</td> -->
<!-- 										<td class="hmbNewRoute">BRAMMADESAM</td> -->
									</tr>

									<tr>
										<td  class="header_bold">HMB Name</td>
										<td  class="header_bold" >:</td>
										<td class="hmbNewName" ></td>
										<td  class="header_bold">No.Of Days</td>
										<td  class="header_bold">:</td>
										<td class="hmbNewNoOfDays"></td>
										
									</tr>


									<tr>
										<td  class="header_bold">Banker Code</td>
										<td  class="header_bold">:</td>
										<td class="hmbNewBankerCode"></td>
										
											<td  class="header_bold">PAN No</td>
										<td  class="header_bold" >:</td>
										<td class="hmbNewPanNo"></td>

										
									</tr>

									<tr>
										<td  class="header_bold">Banker Name</td>
										<td  class="header_bold">:</td>
										<td class="hmbNewBankerName"></td>
									

									</tr>
								</table>

								<table class="table  table-fixed" id="serviceInnerTable2">

									<thead style="backgroud-color: aliceblue;">
										<tr style="border-top: 1px solid;  ">
<!-- 											<td colspan="3" style="font-weight: 900;" class="table-header_align">Payable</td> -->

<!-- 											<td colspan="3" style="font-weight: 900;" class="table-header_align">Deduction</td> -->

											<td colspan="6"></td>
												

										</tr>
									</thead>
									<tr>
									
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'>Payable</td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'>:</td>
									
									
										<td style="font-weight: 900;" class='table-header-align-left'>Qty Service Charge</td>
										<td style="font-weight: 900;" >:</td>
										<td class='table-header-align-right' id="hmbNewQtyServicecharge"></td>
										
									

									</tr>


									<tr>
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'></td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'></td>
										<td style="font-weight: 900;" class='table-header-align-left'>Ts Tally</td>
										<td style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbNewTsTally"></td>
										
										
										
									

									</tr>


									<tr>
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'></td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'></td>
										<td style="font-weight: 900;" class='table-header-align-left'>Nil Adultration</td>
										<td style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbNewNillAdul"></td>
										
									

									</tr>



									<tr>
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'></td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'></td>
										<td style="font-weight: 900;" class='table-header-align-left'>Testing</td>
										<td style="font-weight: 900;  ">:</td>
										<td class='table-header-align-right' id="hmbNewTesting"></td>
									
										

									</tr>


									<tr>
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'></td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'></td>
										<td style="font-weight: 900;" class='table-header-align-left'>Nil Spoilage</td>
										<td style="font-weight: 900;">:</td>
										<td  class='table-header-align-right' id="hmbNewNilSpilage"></td>
									
									

									</tr>


									<tr>
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'></td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'></td>
										<td style="font-weight: 900;" class='table-header-align-left'>TS ( Fat+SNF )</td>
										<td style="font-weight: 900;  ">:</td>
										<td  class='table-header-align-right' id="hmbNewMilkTsFat"></td>
									
										

									</tr>



									<tr>
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'></td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'></td>
										<td  style="font-weight: 900;" class='table-header-align-left'>Qty</td>
										<td  style="font-weight: 900; ">:</td>
										<td class='table-header-align-right' id="hmbNewQty"></td>
										
											

									</tr>



									<tr id="endstaticField1">
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'></td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'></td>
										<td  style="font-weight: 900;" class='table-header-align-left'>Feed</td>
										<td  style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbNewFeed"></td>
										
											

									</tr>
										<tr >
										<td colspan="3"></td>
										<td colspan="3" style="border-top: 1px solid; border-bottom: 1px solid;" ></td>
										</tr>


		<tr >
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'></td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'></td>
										<td  style="font-weight: 900;" class='table-header-align-left'>Total Payable Amt</td>
										<td  style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbNewTotalPayableAmt"></td>
										
										<td></td>
											

									</tr>
									<tr >
										<td colspan="3"></td>
										<td colspan="3" style="border-top: 1px solid; border-bottom: 1px solid;" ></td>
										</tr>

			<tr id="startDeduction">
									
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'>Deduction</td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'>:</td>
									
									
										<td style="font-weight: 900;" class='table-header-align-left'>TDS</td>
										<td style="font-weight: 900;" >:</td>
										<td class='table-header-align-right' id="hmbNewTds"></td>
										
									

									</tr>
					<tr >
										<td colspan="3"></td>
										<td colspan="3" style="border-top: 1px solid; border-bottom: 1px solid;" ></td>
										</tr>
	<tr >
										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'></td>
										
											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'></td>
										<td  style="font-weight: 900;" class='table-header-align-left'>Total Deduction Amt</td>
										<td  style="font-weight: 900;" >:</td>
										<td class='table-header-align-right' id="hmbNewTotalDeductionAmt"></td>
										
										<td></td>
											

									</tr>
									
									<tr >
										<td colspan="3"></td>
										<td colspan="3" style="border-top: 1px solid; border-bottom: 1px solid;" ></td>
										</tr>

<!-- 									<tr> -->
<!-- 										<td  style="font-weight: 900;" class='table-header-align-left'>SMS Amt</td> -->
<!-- 										<td  style="font-weight: 900;">:</td> -->
<!-- 										<td class='table-header-align-right' id="hmbSmsAmount"></td> -->
										
<!-- 										<td></td> -->
<!-- 										<td></td> -->

<!-- 									</tr> -->


<!-- 									<tr> -->
<!-- 										<td style="font-weight: 900;" class='table-header-align-left' id='leftHeaderAlign'></td> -->
										
<!-- 											<td style="font-weight: 900;" class='table-header-align-left' id='leftLineAlign'>:</td> -->
<!-- 										<td  style="font-weight: 900;" class='table-header-align-left'>Arrear Amt</td> -->
<!-- 										<td  style="font-weight: 900;">:</td> -->
<!-- 										<td class='table-header-align-right' id="hmbNewArrearAmount"></td> -->
<!-- 										<td  style="font-weight: 900;     padding-left: 11px;" class='table-header-align-left'>Total Deduction</td> -->
<!-- 										<td  style="font-weight: 900;">:</td> -->
<!-- 										<td class='table-header-align-right' id="hmbNewTotalDeduction"></td> -->

<!-- 									</tr> -->
									
									<tr style="border-top: 1px solid;   border-bottom: 1px solid;">
										
										<td  style="font-weight: 900;     padding-left: 11px;" class='table-header-align-left'>Net Amount</td>
										<td colspan="2"></td>
										<td  style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="netNewAmount"></td>
<td></td>
									</tr>



								</table>


							</tbody>
							<tfoot>
						<div class="pull-center" id="termAndCondition">* Conditions Apply </div>
							</tfoot>

						</table>



					</div>



<!-- 					<div class="modal-footer"> -->
<!-- 						<p id="termAndCondition"></p> -->

<!-- 					</div> -->
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->


<!-- HMB New Payslip end -->


<img src="resources/img/loading.gif" id="img" style="display:none"  >

		<div class="modal fade bd-example-modal-lg  footer-to-bottom"
			id="hmbServiceChargeModel" tabindex="-1" role="dialog"
			data-keyboard="false" data-backdrop="static"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="hmbServiceChargeTitle">Modal title</h4>

					</div>
					<!-- 					<div class="modal-body"> -->
					<div class="panel-body table-responsive">
						<table class="table  table-fixed" id="serviceTable">

							<thead style="backgroud-color: aliceblue;">
								<tr>
									<td colspan="4" class="table-header_align" style="font-weight: 900; font-size: 15px;     padding-bottom: 15px; ">Hatsun Agro Product Ltd</td>
									

								</tr>
								<tr>
									<td class="hmbSerAddress"></td>
										
											<td style="font-weight: 900; ">Chilling Centre	<td>
											<td class="hmbSerCity"></td>
										
<!-- 									<td class="hmbSerPincode"></td> -->

								</tr>
								<tr>
<!-- 									<td>Service Charge for the Period From           <span class="cStartDate"></span>          To -->
									
<!-- 									 <span class="cEndDate"></span> -->
<!-- 										</td> -->
										
										
								</tr>
							</thead>
							<tbody>

								<table class="table  table-fixed" id="serviceInnerTable">
									<tr style="border-top: 1px solid;">
										<td class="header_bold">HMB Code</td>
										<td  class="header_bold" >:</td>
										<td class="hmbCode"></td>
									
												
												<td  class="header_bold">Avg Qty / Day</td>
										<td class="header_bold">:</td>
										<td class="hmbAvgQtyDay" ></td>
										
<!-- 										<td  class="header_bold">HMB Route</td> -->
<!-- 										<td  class="header_bold">:</td> -->
<!-- 										<td class="hmbRoute">BRAMMADESAM</td> -->
									</tr>

									<tr>
										<td  class="header_bold">HMB Name</td>
										<td  class="header_bold" >:</td>
										<td class="hmbName" ></td>
										<td  class="header_bold">No.Of Days</td>
										<td  class="header_bold">:</td>
										<td class="hmbNoOfDays"></td>
										
									</tr>


									<tr>
										<td  class="header_bold">Banker Code</td>
										<td  class="header_bold">:</td>
										<td class="hmbBankerCode"></td>
										
											<td  class="header_bold">PAN No</td>
										<td  class="header_bold" >:</td>
										<td class="hmbPanNo"></td>

										
									</tr>

									<tr>
										<td  class="header_bold">Banker Name</td>
										<td  class="header_bold">:</td>
										<td class="hmbBankerName"></td>
									

									</tr>
								</table>

								<table class="table  table-fixed" id="serviceInnerTable2">

									<thead style="backgroud-color: aliceblue;">
										<tr style="border-top: 1px solid;   border-bottom: 1px solid;">
											<td colspan="3" style="font-weight: 900;" class="table-header_align">Payable</td>

											<td colspan="3" style="font-weight: 900;" class="table-header_align">Deduction</td>

											<td></td>

										</tr>
									</thead>
									<tr>
										<td style="font-weight: 900;" class='table-header-align-left'>Milk Tally</td>
										<td style="font-weight: 900;" >:</td>
										<td class='table-header-align-right' id="hmbMilkTally"></td>
										
										<td style="font-weight: 900;     padding-left: 11px;" class='table-header-align-left'>TDS</td>
										<td style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbTds"></td>

									</tr>


									<tr>
										<td style="font-weight: 900;" class='table-header-align-left'>Ts Tally</td>
										<td style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbTsTally"></td>
										
										
										
										<td style="font-weight: 900;     padding-left: 11px; "  id="ded_desc1" class='table-header-align-left' ></td>
										<td style="font-weight: 900;     display: none;" id="ded_clon1">:</td>
										<td class='table-header-align-right' id="ded_value1"></td>

									</tr>


									<tr>
										<td style="font-weight: 900;" class='table-header-align-left'>Nil Adultration</td>
										<td style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbNillAdul"></td>
										
										<td style="font-weight: 900;     padding-left: 11px; "  id="ded_desc2" class='table-header-align-left' ></td>
										<td style="font-weight: 900;  display: none;" id="ded_clon2">:</td>
										<td class='table-header-align-right' id="ded_value2"></td>

									</tr>



									<tr>
										<td style="font-weight: 900;" class='table-header-align-left'>Testing</td>
										<td style="font-weight: 900;  ">:</td>
										<td class='table-header-align-right' id="hmbTesting"></td>
									
											<td style="font-weight: 900;     padding-left: 11px; "  id="ded_desc3" class='table-header-align-left' ></td>
										<td style="font-weight: 900; display: none;" id="ded_clon3">:</td>
										<td class='table-header-align-right' id="ded_value3"></td>

									</tr>


									<tr>
										<td style="font-weight: 900;" class='table-header-align-left'>Nil Spoilage</td>
										<td style="font-weight: 900;">:</td>
										<td  class='table-header-align-right' id="hmbNilSpilage"></td>
									
										<td style="font-weight: 900;     padding-left: 11px; "  id="ded_desc4" class='table-header-align-left' ></td>
										<td style="font-weight: 900;  display: none;" id="ded_clon4">:</td>
										<td class='table-header-align-right' id="ded_value4"></td>

									</tr>


									<tr>
										<td style="font-weight: 900;" class='table-header-align-left'>TS ( Fat+SNF )</td>
										<td style="font-weight: 900;  ">:</td>
										<td  class='table-header-align-right' id="hmbMilkTsFat"></td>
									
										<td style="font-weight: 900;     padding-left: 11px; "  id="ded_desc5" class='table-header-align-left' ></td>
										<td style="font-weight: 900;  display: none;" id="ded_clon5">:</td>
										<td class='table-header-align-right' id="ded_value5"></td>

									</tr>



									<tr>
										<td  style="font-weight: 900;" class='table-header-align-left'>Qty</td>
										<td  style="font-weight: 900; ">:</td>
										<td class='table-header-align-right' id="hmbQty"></td>
										
											<td style="font-weight: 900;     padding-left: 11px; "  id="ded_desc6" class='table-header-align-left' ></td>
										<td style="font-weight: 900;  display: none;" id="ded_clon6">:</td>
										<td class='table-header-align-right' id="ded_value6"></td>

									</tr>



									<tr>
										<td  style="font-weight: 900;" class='table-header-align-left'>Feed</td>
										<td  style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbFeed"></td>
										
											<td style="font-weight: 900;     padding-left: 11px; "  id="ded_desc7" class='table-header-align-left' ></td>
										<td style="font-weight: 900;  display: none;" id="ded_clon7">:</td>
										<td class='table-header-align-right' id="ded_value7"></td>

									</tr>



									<tr>
										<td  style="font-weight: 900;" class='table-header-align-left'>Qty Incentive</td>
										<td  style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbQtyIncen"></td>
										
											<td style="font-weight: 900;     padding-left: 11px; "  id="ded_desc8" class='table-header-align-left' ></td>
										<td style="font-weight: 900;  display: none;" id="ded_clon8">:</td>
										<td class='table-header-align-right' id="ded_value8"></td>

									</tr>


<!-- 									<tr> -->
<!-- 										<td  style="font-weight: 900;" class='table-header-align-left'>SMS Amt</td> -->
<!-- 										<td  style="font-weight: 900;">:</td> -->
<!-- 										<td class='table-header-align-right' id="hmbSmsAmount"></td> -->
										
<!-- 										<td></td> -->
<!-- 										<td></td> -->

<!-- 									</tr> -->


									<tr>
										<td  style="font-weight: 900;" class='table-header-align-left'>Arrear Amt</td>
										<td  style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbArrearAmount"></td>
										<td  style="font-weight: 900;     padding-left: 11px;" class='table-header-align-left'>Total Deduction</td>
										<td  style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbTotalDeduction"></td>

									</tr>
									
									<tr style="border-top: 1px solid;   border-bottom: 1px solid;">
										<td  style="font-weight: 900;" class='table-header-align-left'>Service Charge</td>
										<td  style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="hmbServiceCharge"></td>
										<td  style="font-weight: 900;     padding-left: 11px;" class='table-header-align-left'>Net Amount</td>
										<td  style="font-weight: 900;">:</td>
										<td class='table-header-align-right' id="netAmount"></td>

									</tr>



								</table>


							</tbody>
							<tfoot>
							</tfoot>

						</table>



					</div>



					<div class="modal-footer">
						<p id="payementTotalValue"></p>

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
	<script src="resources/js/custom/FieldStaff/FfsServiceChargeDetails.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>


</body>
<style type="text/css">
#vendorCode, #vendorName, #outstandingAmount {
	background: #f1f0e8   ! important;
	color: #0a0a0a  ! important;
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
				 
// 				 alert("day.."+lastDates.getDate());
				
				var month =lastDates.getMonth();
// 				alert("month.."+month);
				
				
				 $('#lastThreeMonth').append('<option>' + monthNames[month] + '</option>');
				 $('#lastThreeMonth').append('<option>' + monthNames[month+1] + '</option>');
				 $('#lastThreeMonth').append('<option>' + monthNames[month+2] + '</option>');
				 
					var endMonth = (new Date()).getMonth();
					
					 $('#lastThreeMonth').append('<option>' + monthNames[endMonth] + '</option>');
				
// 				var inr=0;
// 				for (; month < monthNames.length; month++) {
// 					inr++;
// 					if(inr<=3){
// 				  $('#lastThreeMonth').append('<option>' + monthNames[month] + '</option>');
// 					}
					
// 				}
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
			

			
			
			
		//// Deposit Amount
		
		var lastThreeMonth=$("#lastThreeMonth").val();

			
			var lastThreeMonthYear=$("#lastThreeMonthYear").val();

			
			

			 $(".loader").fadeIn("slow");
		//	var hmbMonth = $('#hmbMonth').val();
			
			var hmbMonth=lastThreeMonth+"-"+lastThreeMonthYear;



	});
	</script>
	
	<script type="text/javascript">
			

		$(document).ready(function(e) {

			 $.getJSON('getDailyUpdateDate?menuName=HMB Summary', function (data) {
				 
					if(data.address!="E"){
						$('#daily_update_date').text(data.dailyUpdateDate);

										
					}
				 
			      console.log(data);

			 });
			

			

		

	});
	</script>  


</html>







<%}%>