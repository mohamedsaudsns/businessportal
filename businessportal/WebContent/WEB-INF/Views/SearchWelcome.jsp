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

<title>Welcome</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/to-do.css" rel="stylesheet">
<link href="resources/css/jquery-confirm.min.css" rel="stylesheet">

<link href="resources/jqwidgets/styles/jqx.base.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-redmond.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-start.css" rel="stylesheet">

<!-- <script src="assets/js/chart-master/Chart.js"></script> -->


</head>
	<%
		String userId = (String) session.getAttribute("userId");

	
		if (userId == null) {
			response.sendRedirect("Logout");
		} else {	
			
			Integer userType = (Integer) session.getAttribute("userType");
			
		System.out.println("userType.."+userType);
		
	%>
		
<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
			<%@include file="SearchHeader.jsp" %>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
		

<%@include file="SearchMenu.jsp" %>

		
		
		
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<%@include file="SearchBreadcrump.jsp" %>
			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
			<%@include file="footer.jsp" %>
		<!--footer end-->
		<input type="hidden" id="userId" value="<%=userId%>">
<%-- 		<input type="hidden" id="financialYear_hidden" value="<%=financialYear%>"> --%>
<%-- 		<input type="hidden" id="positionId_hidden" value="<%=positionId%>"> --%>
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

	
	

	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
<script src="resources/js/custom/Auth.js"></script>
	<script src="resources/js/custom/SearchWelcome.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>
	
	
		<script type="text/javascript">
		
		
		
		function disableScreen() {

		//	alert();
			
		
			$('#breadcrumb-ol li').remove();
		$("#breadcrumb-ol").append("<li class='breadcrumb-item'><a href='#'>Home</a></li>");
			$("#tabMenu").css("display", "none");
			
// 			$("#breadcrumb-ol").css("display", "none");
			
		}
	function enableScreen() {

		
		//alert();
		
		$("#tabMenu").css("display", "block");
// 		$("#breadcrumb-ol").css("display", "block");
		
		
		
	
		
	}
	</script>
</body>



</html>
<%}%>