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

<title>Customer Details</title>

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
#customerCode,#customerName,#customerCity,#customerPincode,#customerMobileNo1,#customerMobileNo2,#customerGstIn,#customerRegion,#customerCountry,#customerDistrict,#customerStreetName1,#customerStreetName2,#customerStreetName3,#customerDoorNo,#panNo,#customerBankName,#customerAccountNo,#customerBranchName,#customerIfcCode,#customerBankCity,#customerBankCountry,
#customerPanNo,#customerEmail{
 
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
				<fieldset>
					<legend>Residential Address</legend>				
					<div class="row mt mb">
					
						<div class="col-lg-2 col-md-2 col-sm-6">Customer Code</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="customerCode" name="customerCode"/>
						
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6">Name</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="customerName" name="customerName"/>
						
						</div>
						
					</div>
						
					<div class="row mb">
					
					
						<div class="col-lg-2 col-md-2 col-sm-6">
						<label class="label_stru">	Door No </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="customerDoorNo" name="customerDoorNo"/>
						</div>
	
					
					<div class="col-lg-2 col-md-2 col-sm-6">
					<label class="label_stru">		Street Name 1 </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="customerStreetName1" name="customerStreetName1"/>
						</div>
						
					
						
					
					
						
					</div>	
					
					
					
					
					
					
					
					<div class="row mb">
					
						<div class="col-lg-2 col-md-2 col-sm-6">
						<label class="label_stru">	Street Name 2 </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="customerStreetName2" name="vendorAddress"/>
						</div>
						
					
										
					<div class="col-lg-2 col-md-2 col-sm-6">
				<label class="label_stru">		Street Name 3 </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="customerStreetName3" name="vendorAddress"/>
						</div>
			
						
						
					
					</div>
					
					
					
					<div class="row mb">
						<div class="col-lg-2 col-md-2 col-sm-6">
						<label class="label_stru">	City </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="customerCity" name="customerCity"/>
						</div>
						
						
						
							
							<div class="col-lg-2 col-md-2 col-sm-6">
					<label class="label_stru">		District </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="customerDistrict" name="customerDistrict"/>
						</div>
						</div>
						<div class="row mb">
							<div class="col-lg-2 col-md-2 col-sm-6">
						<label class="label_stru">	Pin code </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="customerPincode" name="customerPincode"/>
						</div>
						
							<div class="col-lg-2 col-md-2 col-sm-6">
						<label class="label_stru">	Region </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="customerRegion" name="customerRegion"/>
							
						</div>
						
						</div>
						
			
				
					<div class="row mb">
						<div class="col-lg-2 col-md-2 col-sm-6">
					<label class="label_stru">		Country </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						
							
								<input type="text" id="customerCountry" name="customerCountry"/>
						</div>
						
							<div class="col-lg-2 col-md-2 col-sm-6">
						<label class="label_stru">	GSTIN </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						
							<input type="text" id="customerGstIn" name="customerGstIn"/>
					
							
						</div>
					
					</div>
					
					
					<div class="row mb">
						<div class="col-lg-2 col-md-2 col-sm-6">
						<label class="label_stru">	PAN No </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						
							
								<input type="text" id="customerPanNo" name="customerPanNo"/>
						</div>
				
				
				<div class="col-lg-2 col-md-2 col-sm-6">
						<label class="label_stru">	Email </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						
							
								<input type="text" id="customerEmail" name="customerEmail"/>
						</div>
					
					</div>
					
					
					
						
									
						<div class="row mb">
							
					
						
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">Mobile Number 1 </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="customerMobileNo1" name="customerMobileNo1"/>
						</div>
						
								
						<div class="col-lg-2 col-md-2 col-sm-6">
						<label class="label_stru">	Mobile Number 2 </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="customerMobileNo2" name="customerMobileNo2"/>
						</div>
					
					</div>
			
				
				</fieldset>	
					
							<fieldset>
					<legend>Bank Details</legend>				
					<div class="row mt mb">
					
						<div class="col-lg-2 col-md-2 col-sm-6">Bank Name</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="customerBankName" name="customerBankName"/>
						
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6">Account No</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="customerAccountNo" name="customerAccountNo"/>
						
						</div>
						
					</div>
				
							<div class="row mt mb">
					
						<div class="col-lg-2 col-md-2 col-sm-6">Branch Name</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="customerBranchName" name="customerBranchName"/>
						
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6">IFC Code</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="customerIfcCode" name="customerIfcCode"/>
						
						</div>
						
					</div>
					
								<div class="row mt mb">
					
						<div class="col-lg-2 col-md-2 col-sm-6">City</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="customerBankCity" name="customerBankCity"/>
						
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6">Country</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="customerBankCountry" name="customerBankCountry"/>
						
						</div>
						
					</div>
						

						
					

					
					
				
				
				</fieldset>	
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
	<script src="resources/js/custom/CustomerDetails.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>
</body>
</html>
<%}%>