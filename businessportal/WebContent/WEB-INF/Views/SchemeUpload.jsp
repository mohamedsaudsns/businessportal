<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>Scheme Upload</title>

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
#vendorCode, #vendorName, #vendorName1, #vendorAddress, #vendorAddress2,
	#vendorCity, #vendorPincode, #vendorPhone, #vendorCountry, #vendorState,
	#vendorGstIn, #age, #fatherHusbandName, #streetName1, #streetName2,
	#streetName3, #fatherHusbandName, #doorNo, #mobileNo1, #mobileNo2,
	#district, #bankName, #accountNo, #branchName, #ifcCode, #panNo {
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
				<%@include file="Breadcrump.jsp"%>

				<form:form action="tdsFileUpload" method="POST" id="tdsFileUpload"
					enctype="multipart/form-data">
					<div class="row mt mb">
						<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Department</label></div>
						<div class="col-lg-2 col-md-2 col-sm-6"
							style="padding: 1px !important;">

							<div id="schemeDepartment"></div>
						</div>
						<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Scheme Name</label></div>
						<div class="col-lg-2 col-md-2 col-sm-6"
							style="padding: 1px !important;">

							<input type="text" id="schemeName" />
						</div>

	<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">File Upload</label></div>

						<div class="col-lg-1 col-md-1 col-sm-6">
							<input type='file' id="image" name="image"
								class="ui-btn ui-btn-d ui-mini" />
						</div>
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" style="padding-left: 3px;"> -->
<!-- 							<img id="target" /> -->
<!-- 						</div> -->

					</div>
					<div class="row mt mb">
						<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">From Date</label></div>
						<div class="col-lg-2 col-md-2 col-sm-6"
							style="padding: 1px !important;">
							<div id="schemeFromDate"></div>
						</div>
						<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">To Date</label></div>
						<div class="col-lg-2 col-md-2 col-sm-6" style="padding-left: 3px;">
							<div id="schemeToDate"></div>
						</div>
						<div class="col-lg-2 col-md-1 col-sm-6">
							<input type="submit" class="btn btn-success btn-sm"
								id="productUpload" class="productUpload" value="Upload" />
						</div>

					</div>
					
				</form:form>

				<div class="row mt mb">
					<div class="col-lg-3 col-md-1 col-sm-6">
						<div id="assignDepartment"></div>
					</div>
					<div class="col-lg-9 col-md-1 col-sm-6">
						<div id="schemeListGrid"></div>

					</div>
				</div>

			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
		<%@include file="footer.jsp"%>
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
	<script src="resources/js/custom/SchemeUpload.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>


	<script type="text/javascript">

	var selectedRecords = new Array();
		$("#productUpload").on('click', function(e) {
			e.preventDefault();
			
			var grid_json = " ";
			var rows = $("#assignDepartment").jqxGrid('selectedrowindexes');
			var rowslen = rows.length;
			if (rowslen > 0) {
				for (var m = 0; m < rows.length; m++) {
					var row = $("#assignDepartment").jqxGrid('getrowdata', rows[m]);
					selectedRecords[selectedRecords.length] = row;



				}
				
				
			grid_json = '{"rows":' + $('#assignDepartment').jqxGrid('exportdata', 'json', null, false, selectedRecords, true) + '}';
			
			var schemeDepartment=$("#schemeDepartment").val();
			var schemeFromDate=$("#schemeFromDate").val();
			var schemeToDate=$("#schemeToDate").val();
			var schemeName=$("#schemeName").val();
			var image = $("#image").val();
			var files = $('#image').prop('files');
			var formData = new FormData();
			formData.append("file", files[0]);
			formData.append("schemeDepartment",schemeDepartment);
			formData.append("schemeFromDate",schemeFromDate);
			formData.append("schemeToDate",schemeToDate);
			formData.append("schemeName",schemeName);
			formData.append("schemeData",grid_json);
			if (image !== '') {
				$.ajax({
					url : 'schemeFileUpload',
					type : 'POST',
					data : formData,
					//		 	    enctype: 'multipart/form-data',
					async : false,
					cache : false,
					contentType : false,
					processData : false,
					success : function(res) {
						if (res == "S") {
							$('#target').remove();
							$("#image").val('');
							$("#schemeName").val(" ");
							callAlert("green","Alert","Scheme successfully uploaded");
							getSchemeList();
// 							$('#ImageUploadSuccessWindow').jqxWindow("open");
						}
					}
				});
	
			}
			}else{
				
				callAlert("red","Alert","Please select Assign Department");
				
			}
	
		});
	</script>
</body>
</html>
<%}%>