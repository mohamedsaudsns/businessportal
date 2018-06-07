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

<title>Dashboard</title>

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
  <script src="resources/js/chart-master/Chart.js"></script>

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
			<%@include file="../header.jsp" %>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<%@include file="../menu.jsp" %>
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<%@include file="../Breadcrump.jsp" %>
				
 <div class="row mt" >
                      <div class="col-lg-12">
                          <div class="content-panel">
							  <h4><i class="fa fa-angle-right" style="color: #ea2424;"></i> Active User  </h4>
							
                              <div class="panel-body text-center">
                                						<div class="col-lg-2 col-md-4 mb">
                      		<div class="darkblue-panel pn">
                      			<div class="darkblue-header">
                      				<div class="pull-center">
									<h5>  In-charge</h5>
																		</div>
									<div class="pull-right">
										<h5>  <a class="text-left" href="#">   <i class=" glyphicon glyphicon-download-alt  fa-lg"></i> </a></h5>
										
									</div>
<!-- 						  			<h5>In-charge <a class="text-left" href="#">   <i class=" glyphicon glyphicon-download-alt  fa-lg"></i> </a>	  </h5>  -->
						  		
						  		
       
                      			</div>
                      	
								<canvas id="inchargeChart" height="130" width="140"></canvas>
								<script>
									var doughnutData = [
											{
												value: 1402,
												color:"#df4b55"
											},
											{
												value : 1662,
												color : "#444c57"
											}
										];
										var myDoughnut = new Chart(document.getElementById("inchargeChart").getContext("2d")).Doughnut(doughnutData);
								</script>
								
								
								
								<footer>
									<div class="pull-left">
									<h5>  Total User</h5>
										<h5>  787879</h5>
									</div>
									<div class="pull-right">
										<h5>  Active User</h5>
										<h5>  1</h5>
									</div>
								</footer>
                      		</div><!-- /darkblue panel -->
						</div><!-- /col-md-4 -->
						
						
						
						
						          						<div class="col-lg-2 col-md-4 mb">
                      		<div class="darkblue-panel pn">
                      			<div class="darkblue-header">
						  			<h5>Farmer</h5>
                      			</div>
								<canvas id="serverstatus021" height="130" width="140"></canvas>
								<script>
									var doughnutData = [
											{
												value: 1400,
												color:"#ea922e"
											},
											{
												value : 1662,
												color : "#444c57"
											}
										];
										var myDoughnut = new Chart(document.getElementById("serverstatus021").getContext("2d")).Doughnut(doughnutData);
								</script>
								
								
								
								<footer>
									<div class="pull-left">
									<h5>  Total User</h5>
										<h5>  787879</h5>
									</div>
									<div class="pull-right">
										<h5>  Active User</h5>
										<h5>  1</h5>
									</div>
								</footer>
                      		</div><!-- /darkblue panel -->
						</div><!-- /col-md-4 -->
						
						
						
						
							          						<div class="col-lg-2 col-md-4 mb">
                      		<div class="darkblue-panel pn">
                      			<div class="darkblue-header">
						  			<h5>Bulk Vendor</h5>
                      			</div>
								<canvas id="bulkVendorReport" height="130" width="140"></canvas>
								<script>
									var doughnutData = [
											{
												value: 1400,
												color:"#955893"
											},
											{
												value : 1662,
												color : "#444c57"
											}
										];
										var myDoughnut = new Chart(document.getElementById("bulkVendorReport").getContext("2d")).Doughnut(doughnutData);
								</script>
								
								
								
								<footer>
									<div class="pull-left">
									<h5>  Total User</h5>
										<h5>  787879</h5>
									</div>
									<div class="pull-right">
										<h5>  Active User</h5>
										<h5>  1</h5>
									</div>
								</footer>
                      		</div><!-- /darkblue panel -->
						</div><!-- /col-md-4 -->
						
						
						
						
							          						<div class="col-lg-2 col-md-4 mb">
                      		<div class="darkblue-panel pn">
                      			<div class="darkblue-header">
						  			<h5>Farm Vendor</h5>
                      			</div>
								<canvas id="farmVendorReport" height="130" width="140"></canvas>
								<script>
									var doughnutData = [
											{
												value: 1400,
												color:"#6fb17a"
											},
											{
												value : 1662,
												color : "#444c57"
											}
										];
										var myDoughnut = new Chart(document.getElementById("farmVendorReport").getContext("2d")).Doughnut(doughnutData);
								</script>
								
								
								
								<footer>
									<div class="pull-left">
									<h5>  Total User</h5>
										<h5>  787879</h5>
									</div>
									<div class="pull-right">
										<h5>  Active User</h5>
										<h5>  1</h5>
									</div>
								</footer>
                      		</div><!-- /darkblue panel -->
						</div><!-- /col-md-4 -->
						
						
						
						
											<div class="col-lg-2 col-md-4 mb">
                      		<div class="darkblue-panel pn">
                      			<div class="darkblue-header">
						  			<h5>HMB ( Land Owner )</h5>
                      			</div>
								<canvas id="hmbLandOwnerReport" height="130" width="140"></canvas>
								<script>
									var doughnutData = [
											{
												value: 1400,
												color:"#68dff0"
											},
											{
												value : 1662,
												color : "#fffff"
											}
										];
										var myDoughnut = new Chart(document.getElementById("hmbLandOwnerReport").getContext("2d")).Doughnut(doughnutData);
								</script>
								
								
								
								<footer>
									<div class="pull-left">
									<h5>  Total User</h5>
										<h5>  787879</h5>
									</div>
									<div class="pull-right">
										<h5>  Active User</h5>
										<h5>  1</h5>
									</div>
								</footer>
                      		</div><!-- /darkblue panel -->
						</div><!-- /col-md-4 -->
						
						
                              </div>
                          </div>
                      </div>
        
                      
                      
                     
                  </div>
			
				
			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
			<%@include file="../footer.jsp" %>
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
	<script src="resources/js/custom/admin/AdminDashboard.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>

	
</body>



</html>







<%}%>