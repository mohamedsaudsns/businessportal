
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

<title>Field Force Contact Number</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/jquery-confirm.min.css" rel="stylesheet">

<link href="resources/jqwidgets/styles/jqx.base.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.bootstrap.css"
	rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-start.css"
	rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-redmond.css"
	rel="stylesheet">
		<link href="resources/css/common-style.css" rel="stylesheet">

<!-- <script src="assets/js/chart-master/Chart.js"></script> -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style type="text/css">
#filedForceName, #contactNo, #endDate, #advanceAmount, #rentAmount,
	#renewalType, #noOfYears, #renewalDate, #rentIncrPercentage,
	#rentIncrYear, #plant, #notice {
	background: #252422 ! important;
	color: antiquewhite ! important;
}
</style>
<%
		Integer userId = (Integer) session.getAttribute("userId");
	
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
		<ul id="myTab" class="nav nav-tabs">
				
				<%if(userId==5405281){ %>
				
					<li class="active"><a href="#freshProductMilk"
						data-toggle="tab"> Fresh Product - Milk </a></li>

					<li><a href="#ibaco" data-toggle="tab">Ibaco</a></li>
					<li><a href="#logistics" data-toggle="tab">Logistics</a></li>

	<%}%>
	
	<%if(userId==5406531){ %>
				
					<li ><a href="#freshProductMilk"
						data-toggle="tab"> Fresh Product - Milk </a></li>

					<li class="active"><a href="#ibaco" data-toggle="tab">Ibaco</a></li>
					<li><a href="#logistics" data-toggle="tab">Logistics</a></li>

	<%}%>

				</ul>

				<div class="tab-content">
					<div id="ibaco1" class="tab-pane fade">
						<h3></h3>
						<p></p>
					</div>
					<div id="Logistics" class="tab-pane fade">
						<h3></h3>
						<p></p>
					</div>

				</div>



		

				<div class="row mt mb" style="padding-top: 7px">



					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Filed Member</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6"
						style="padding: 1px !important;">

						<input type="text" id="filedForceName" />
					</div>

					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Contact No</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6"
						style="padding: 1px !important;">

							<input type="text" id="contactNo" />
					</div>


				</div>
				



			


			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
		<%@include file="../footer.jsp"%>
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
	<script src="resources/js/custom/FiledForce.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>


</body>


<script type="text/javascript">
			

		$(document).ready(function(e) {
			
			
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
			

			
			
			
			$.ajax({
				type : "GET",
					url : "getVendorOutstandingAmount",
				success : function(response) {
					if (response !="E") {
						$('#outstandingAmount').val(response);
				
					} else {
						$('#outstandingAmount').val("0.00");
					}
				},
				error : function(error) {

				}
			});
		

	});
	</script>


</html>







<%}%>