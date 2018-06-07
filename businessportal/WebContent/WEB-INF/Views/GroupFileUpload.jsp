<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<%@include file="header.jsp"%>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<%@include file="menu.jsp"%>
		</aside>
		<!--sidebar end-->
		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<%@include file="DemoBreadcrump.jsp" %>

						<div class="row mt mb">

					<form:form action="tdsFileUpload" method="POST" id="tdsFileUpload" enctype="multipart/form-data">
						
							<div class="col-lg-2 col-md-1 col-sm-6" >File Upload</div>
							
							
							<div class="col-lg-3 col-md-1 col-sm-6" >
									
								<div>
									<input type='file' id="image" name="image" class="ui-btn ui-btn-d ui-mini"/>	
								</div>
						
				</div>
						
									<div class="col-lg-2 col-md-1 col-sm-6">
								<input type="submit" class="btn btn-success btn-sm" id="tdsFileUploadok" class="tdsFileUploadok" value="Upload"/>
							</div>	
							</form:form>			
					
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

	
	

	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
<script src="resources/js/custom/Auth.js"></script>
	<script src="resources/js/custom/DemoWelcome.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>
	
	
		<script type="text/javascript">
		
		
		$("#tdsFileUploadok").on('click',function(e){
			e.preventDefault();
			var image = $("#image").val();
			var files = $('#image').prop('files');
			var formData = new FormData();
			formData.append("file", files[0]);
			if(image!==''){
			  $.ajax({
			    url: 'NewGroupFileUpload',
			    type: 'POST',
			    data: formData,
//		 	    enctype: 'multipart/form-data',
			    async: false,
			    cache: false,
			    contentType: false,
			    processData: false,
			    success: function (res) {
			      if(res=="S"){
			    	  $('#target').remove();
			    	  $("#image").val('');
			    	  $('#ImageUploadSuccessWindow').jqxWindow("open");
			      }
			    }
			  });
			
			}
			
		});

	</script>
</body>



</html>
<%}%>