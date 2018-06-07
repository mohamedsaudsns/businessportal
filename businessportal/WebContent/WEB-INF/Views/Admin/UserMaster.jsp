<%
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			response.sendRedirect("Logout");
		} else {			
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

<title>User Master</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/style-responsive.css" rel="stylesheet">
<!-- jQWidgets CSS -->
<link href="resources/jqwidgets/styles/jqx.base.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-start.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.orange.css" rel="stylesheet">
<script type="text/javascript">
function goBack(){
	document.location.href="AdminUserManagement";
}
</script>
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
			<%@include file="AdminMenu.jsp" %>
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<div id="userViewDiv">
					<%@include file="Breadcrump.jsp" %>
					<div id="userMasterGrid"></div>
				</div>
				<!---------------------------- User Master Creation / Change ----------------------------------------------------------->
				<div id="userCreateDiv" style="display: none">
					<h4>
						<i class="fa fa-angle-right"></i> User Edit
					</h4>
					<hr>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<button class="btn btn-success btn-sm" id="saveBtn"><i class="fa fa-floppy-o" aria-hidden="true"></i>&nbsp;Save</button>
		          			<button class="btn btn-danger btn-sm" id="clearBtn"><i class="fa fa-ban" aria-hidden="true"></i>&nbsp;Clear</button>
		          			<button class="btn btn-warning btn-sm" id="backBtn"><i class="fa fa-arrow-circle-left" aria-hidden="true"></i>&nbsp;Back to Users</button>
						</div>
						<div class="panel-body">
							<div class="row mb mt">
									<div class="col-lg-1 col-md-1 col-sm-6"><label>User ID</label></div>
									<div class="col-lg-3 col-md-3 col-sm-6">
										<input type="text" id="userID" name="userID" readonly="readonly">
									</div>
									<div class="col-lg-1 col-md-1 col-sm-6">User&nbsp;Name</div>
									<div class="col-lg-7 col-md-7 col-sm-6">
										<input type="text" id="userName" name="userName">
									</div>
							</div>
							<div class="row mb">
								<div class="col-lg-1 col-md-1 col-sm-6"><label>User Type</label></div>
								<div class="col-lg-3 col-md-3 col-sm-6">
										<div id="userType"></div>
								</div>
								<div class="col-lg-1 col-md-1 col-sm-6"><label>Address</label></div>
								<div class="col-lg-7 col-md-7 col-sm-6">
									<input type="text" id="address" >
								</div>
							</div>
							<div class="row mb">
									<div class="col-lg-1 col-md-1 col-sm-6"><label>Mobile No</label></div>
									<div class="col-lg-3 col-md-3 col-sm-6">
										<input type="text" id="mobileNo" name="mobileNo" >
									</div>
									<div class="col-lg-1 col-md-1 col-sm-6">Email ID</div>
									<div class="col-lg-7 col-md-7 col-sm-6">
										<input type="text" id="emailID" name="emailID">
									</div>
							</div>
							<div class="row mb">
									<div class="col-lg-1 col-md-1 col-sm-6">User&nbsp;Status</div>
									<div class="col-lg-3 col-md-3 col-sm-6">
										<div id="userStatus" ></div>
									</div>
									<!-- <div class="col-lg-1 col-md-1 col-sm-6"><label>User&nbsp;Head</label></div>
									<div class="col-lg-7 col-md-7 col-sm-6">
										<div id="userHead"></div>
									</div> -->
							</div>
						</div>
						<div id='messageSuccess' style="color: red;margin-left: 16px;font-size: 20px;font-family:inherit;"></div>
					</div>
				</div>
			<!---------------------------- /User Master Creation / Change  ----------------------------------------------------------->
			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
			<%@include file="footer.jsp" %>
		<!--footer end-->
	</section>
<!-- /.modal -->
	<div id='messageSuccess'></div>
				
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery-1.11.1.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="resources/js/jquery.scrollTo.min.js"></script>
	<script src="resources/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="resources/js/jquery.sparkline.js"></script>
	<script src="resources/jqwidgets/jqx-all.js"></script>
	<!--common script for all pages-->
	<script src="resources/js/custom/admin/common-scripts.js"></script>
	<script src="resources/js/custom/Auth.js"></script>
	<script src="resources/js/custom/admin/UserMaster.js"></script>
	<script type="text/javascript">
		$(document).ready(function(e){
			$('#AdminUserManagement').addClass("active");
			$("#breadcrumb-ol").append("<li class='breadcrumb-item'><a href='Admin'>Home</a></li><li class='breadcrumb-item'><a href='AdminUserManagement'>User Management</a></li><li class='breadcrumb-item active'><a href='AdminUserMaster'>User Master</a></li>");
		});
	</script>
</body>
</html>
<%}%>