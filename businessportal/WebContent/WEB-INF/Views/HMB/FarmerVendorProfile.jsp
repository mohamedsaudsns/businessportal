
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

<title>Vendor Details</title>

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
				<fieldset>
					<legend>Residential Address</legend>
					<div class="row mt mb">

						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">Vendor Code</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="vendorCode" name="vendorCode" />

						</div>
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">Name</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="vendorName" name="vendorName" />

						</div>

					</div>
					<div class="row mb">

						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Age </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="age" name="age" />

						</div>


						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Father / Husband Name </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="fatherHusbandName"
								name="fatherHusbandName" />

						</div>



					</div>



					<div class="row mb">
			<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Door No </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="doorNo" name="doorNo" />
						</div>


						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Street Name 1 </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="streetName1" name="vendorAddress" />
						</div>

					</div>







					<div class="row mb">

						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Street Name 2 </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="streetName2" name="vendorAddress" />
						</div>



						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Street Name 3 </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="streetName3" name="vendorAddress" />
						</div>




					</div>



					<div class="row mb">
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> City </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="vendorCity" name="vendorCity" />
						</div>




						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> District </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="district" name="district" />
						</div>
					</div>
					<div class="row mb">
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Pin code </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="vendorPincode" name="vendorPincode" />
						</div>

						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Region </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="vendorState" name="vendorState" />

						</div>

					</div>



					<div class="row mb">
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Country </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">


							<input type="text" id="vendorCountry" name="vendorCountry" />
						</div>

						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> GSTIN </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">

							<input type="text" id="vendorGstIn" name="vendorGstIn" />


						</div>

					</div>


					<div class="row mb">
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> PAN No </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">


							<input type="text" id="panNo" name="panNo" />
						</div>
						
						
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Aadhar No </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">


							<input type="text" id="aadharNo" name="aadharNo" />
						</div>


					</div>





					<div class="row mb">



						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">Telephone No </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="mobileNo1" name="mobileNo1" />
						</div>


						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru"> Mobile Number </label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="mobileNo2" name="mobileNo2" />
						</div>

					</div>



				</fieldset>

				<fieldset>
					<legend>Bank Details</legend>
					<div class="row mt mb">

						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">Bank Name</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="bankName" name="bankName" />

						</div>
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">Account No</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="accountNo" name="accountNo" />

						</div>

					</div>

					<div class="row mt mb">

						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">Branch Name</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="branchName" name="branchName" />

						</div>
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">IFSC Code</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="ifcCode" name="ifcCode" />

						</div>

					</div>
					
					<div class="row mt mb">

						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">City</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="branchCity" name="branchCity" />

						</div>
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">Country</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="branchCountry" name="branchCountry" />

						</div>

					</div>







				</fieldset>
				
				
<!-- Animal Detail -->

<fieldset>
					<legend>Animal Details</legend>
					<div class="row mt mb">

						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">No Of Cows</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="noOfCows" name="noOfCows" />

						</div>
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">No Of Buffalos</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="noOfBuffalos" name="noOfBuffalos" />

						</div>

					</div>

					<div class="row mt mb">

						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">No Of Heifer</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="noOfHeifer" name="noOfHeifer" />

						</div>
						<div class="col-lg-2 col-md-2 col-sm-6">
							<label class="label_stru">No Of Animal</label>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<input type="text" id="noOfAnimal" name="noOfAnimal" />

						</div>

					</div>
					
<!-- 					<div class="row mt mb"> -->

<!-- 						<div class="col-lg-2 col-md-2 col-sm-6"> -->
<!-- 							<label class="label_stru">Milk Protential</label> -->
<!-- 						</div> -->
<!-- 						<div class="col-lg-4 col-md-4 col-sm-6"> -->
<!-- 							<input type="text" id="milkProtential" name="milkProtential" /> -->

<!-- 						</div> -->
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6"> -->
<!-- 							<label class="label_stru">Var Animals </label> -->
<!-- 						</div> -->
<!-- 						<div class="col-lg-4 col-md-4 col-sm-6"> -->
<!-- 							<input type="text" id="varAnimals" name="varAnimals" /> -->

<!-- 						</div> -->

<!-- 					</div> -->







				</fieldset>
				
				
				
				
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
	<script src="resources/js/custom/hmb/FarmerVendorProfile.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>
</body>
<script type="text/javascript">
			

		$(document).ready(function(e) {

			 $.getJSON('getDailyUpdateDate?menuName=Vendor Master', function (data) {
				 
					if(data.address!="E"){
						$('#daily_update_date').text(data.dailyUpdateDate);

										
					}
				 
			      console.log(data);

			 });
			

			

		

	});
	</script> 
</html>
<%}%>