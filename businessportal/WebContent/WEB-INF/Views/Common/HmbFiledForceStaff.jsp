
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

<title>Field Force</title>

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

<style type="text/css">
#vendorCode, #vendorName, #outstandingAmount {
	background: #252422 ! important;
	color: antiquewhite ! important;
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
					<div class="col-lg-2 col-md-3 col-sm-6 col-xs-6">
						<label class="label_stru">Customer Care No :</label>
					</div>
					
					<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5">
						<label class="label_stru_value" style="color: black;font-weight: bold; font-size: 14px;">18004253355</label>
					</div>
					
					<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5">
						<label class="label_stru">Mail ID :</label>
					</div>
					
					<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5">
						<label class="label_stru_value" style="color: black;font-weight: bold; font-size: 14px;" >customerservice@hap.in</label>
					</div>
				


				</div>

				<div id="filedForceGrid"></div>

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
	<script
		src="resources/js/custom/common/HmbFiledForceStaff.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>


</body>


<script type="text/javascript">
			

		$(document).ready(function(e) {
	
			 $.getJSON('getDailyUpdateDate?menuName=Filed Force Staff', function (data) {
				 
					if(data.address!="E"){
						$('#daily_update_date').text(data.dailyUpdateDate);

										
					}
				 
			      console.log(data);

			 });

	});
		
	
		
		var fields= new Array();
		
		fields.push({name:'plantCode',type:'string'},{name:'plantName',type:'string'},{name:'Hmb',type:'string'},{name:'hmbName',type:'string'},{name:'designation',type:'string'}
		,{name:'designationLevel',type:'string'},{name:'designationtype',type:'string'},{name:'vendor',type:'string'},
		{name:'vendorName',type:'string'},
		
		{name:'vendorMobileNo',type:'string'});

		var source_inventory = {
			datatype:'json',
			datafields:fields,
			url:'getHMBFiledForceStaffData',
			async:false
		}
		var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
		$('#filedForceGrid').jqxGrid({source:dataAdapter_inventory});
		
		
	</script>

		

</html>







<%}%>