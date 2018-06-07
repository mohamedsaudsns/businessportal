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

<title>Customer Assignment</title>

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
<link href="resources/jqwidgets/styles/jqx.bootstrap.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-start.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-redmond.css" rel="stylesheet">

<!-- <script src="assets/js/chart-master/Chart.js"></script> -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
 <style type="text/css">
	
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
				<div class="row mt mb">
					<div class="col-lg-1 col-md-1 col-sm-6">Select</div>
					<div class="col-lg-3 col-md-3 col-sm-6">
						<div id="salexPerson"></div>
					</div>
					<div class="col-lg-1 col-md-1 col-sm-6">From Date</div>
					<div class="col-lg-2 col-md-2 col-sm-6">
						<div id="fdate"></div>
					</div>
					<div class="col-lg-1 col-md-1 col-sm-6">To Date</div>
					<div class="col-lg-2 col-md-2 col-sm-6">
						<div id="tdate"></div>					
					</div>					
					<div class="col-lg-2 col-md-2 col-sm-6">
						<button id="saveBtn" class="btn btn-success btn-sm">Save</button>
					</div>
				</div>
				<div class="row mb">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div style="float: left;width:45%">
							<div id="customerGrid"></div>
						</div>
						<div style="float: left;width:5%;margin-top:15%;margin-left: 1%">
							<button id="addBtn" class="btn btn-square">&gt;</button><br/><br/>
							<button id="removeBtn" class="btn btn-square">&lt;</button>
						</div>
						<div style="float: left;width:48%">
							<div id="customerAssignGrid"></div>
						</div>
					</div>
				</div>	
				<div id="customerWindow" style="display: none">
					<div>Transfer</div>
					<div>
						<div class="row mt mb">
							<div class="col-lg-6 col-md-6 col-sm-12">Agency Name</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<input type="text" id="agencyNameWindow" name="agencyNameWindow">
								<input type="hidden" id="agencyIdWindow" name="agencyIdWindow">
								<input type="hidden" id="sdateHidden" name="sdateHidden">
								<input type="hidden" id="salexHidden" name="salexHidden"> 
							</div>
						</div>
						<div class="row mb">
							<div class="col-lg-6 col-md-6 col-sm-12">To Sales Executive</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div id="salesPersonWindow"></div> 
							</div>
						</div>
						<div class="row mb">
							<div class="col-lg-6 col-md-6 col-sm-12">From Date</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div id="sdateWindow"></div> 
							</div>
						</div>
						<div class="row mb">
							<div class="col-lg-6 col-md-6 col-sm-12">To Date</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div id="edateWindow"></div> 
							</div>
						</div>
						<div class="row mb centered">
							<div class="col-lg-12 col-md-12 col-sm-12">
								<button id="transferBtn" class="btn btn-sm btn-success">Transfer</button>&nbsp;
								<button id="closeBtn" class="btn btn-sm btn-danger">Close</button>
							</div>
						</div>
					</div>
				</div>		
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
	<script src="resources/js/custom/CustomerAssignment.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>
</body>
</html>
<%}%>