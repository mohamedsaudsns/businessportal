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

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
	<%
		Integer userId = (Integer) session.getAttribute("userId");

	
		if (userId == null) {
			response.sendRedirect("Logout");
		} else {	
			
			Integer userType = (Integer) session.getAttribute("userType");
			
		System.out.println("userType.."+userType);
			String financialYear = "1";
			int positionId = 1;
	%>
		
<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
			<%@include file="DemoHeader.jsp" %>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
		

<%@include file="DemoMenu.jsp" %>

		
		
		
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<%@include file="DemoBreadcrump.jsp" %>
				
				<ul id = "myTab" class = "nav nav-tabs">
   <li class = "active">
      <a href = "#home" data-toggle = "tab">
       Ibaco
      </a>
   </li>
   
   <li><a href = "#ios" data-toggle = "tab">Logistics</a></li>
	

	
</ul>

<!-- <div id = "myTabContent" class = "tab-content"> -->

<!--    <div class = "tab-pane fade in active" id = "home"> -->
<!--       <p>Ibaco</p> -->
<!--    </div> -->
   
<!--    <div class = "tab-pane fade" id = "ios"> -->
<!--       <p>Logistics</p> -->
<!--    </div> -->
<!-- 		</div>			 -->
					
					<ul class="nav nav-tabs" style="display: none" id="tabMenu">
  <li class="active"><a href="#ibaco">Ibaco</a></li>
<!--   <li class="dropdown"> -->
<!--     <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1 -->
<!--     <span class="caret"></span></a> -->
<!--     <ul class="dropdown-menu"> -->
<!--       <li><a href="#">Submenu 1-1</a></li> -->
<!--       <li><a href="#">Submenu 1-2</a></li> -->
<!--       <li><a href="#">Submenu 1-3</a></li>  -->
<!--     </ul> -->
<!--   </li> -->
  <li><a href="#Logistics">Logistics</a></li>
<!--   <li><a href="#">Menu 3</a></li> -->
</ul>


<div class="tab-content">
  <div id="ibaco" class="tab-pane fade">
    <h3>Ibaco</h3>
    <p></p>
  </div>
  <div id="Logistics" class="tab-pane fade">
    <h3>Logistics</h3>
    <p></p>
  </div>

</div>
<!-- 						<div class="row mt mb"> -->

					
						
<!-- 							<div class="col-lg-2 col-md-1 col-sm-6" >Role</div> -->
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" style="padding: 1px !important;" > -->
							
<!-- 							<div id="roleList"></div> -->
<!-- 						</div> -->
						
<!-- 							<div class="col-lg-2 col-md-1 col-sm-6"  >Department</div> -->
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" style="padding: 1px !important;" > -->
							
<!-- 								<div id="departmentList"></div> -->
<!-- 						</div> -->
				
<!-- 		<div class="col-lg-2 col-md-2 col-sm-6" > -->
<!-- 							<button id="getBtn" class="btn btn-success btn-sm">Get</button> -->
<!-- 						</div>				 -->
													
<!-- 					</div> -->
		
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
	<script src="resources/js/custom/DemoWelcome.js"></script>
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