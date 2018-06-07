
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

<title>Land Owner Agreement Status</title>

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
<link href="resources/jqwidgets/styles/jqx.bootstrap.css"
	rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-start.css"
	rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-redmond.css"
	rel="stylesheet">
	<link href="resources/css/common-style.css" rel="stylesheet">

<!-- <script src="assets/js/chart-master/Chart.js"></script> -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style type="text/css">
#agreementNo, #startDate, #endDate, #advanceAmount, #rentAmount,
	#renewalType, #noOfYears, #renewalDate, #rentIncrPercentage,
	#rentIncrYear, #plant, #notice,#ownerName,#shopAddress,#areaSqft,#previousRentSqft {
background: #f1f0e8  ! important;
	color: #080808 ! important;
	border-color: #f1f0e8;
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



<!-- <div class="container"> -->
<!--   <h1>Bootstrap Dynamic Tabs</h1> -->
<!--   <div class="well"> -->
    
<!--     <a href="#" id="btnAdd"><i class="icon-plus-sign-alt"></i> Add Tab</a> -->
<!--     <br><br> -->
<!--     <ul class="nav nav-tabs" id="tabs"> -->
<!--         <li class="active"><a href="#tab1">Tab 1</a></li> -->
<!--     </ul> -->
    
<!--     <div class="tab-content"> -->
<!--         <div class="tab-pane active" id="tab1">Hello tab #1 content...</div> -->
<!--     </div> -->
<!--   </div> -->
<!--   <a href="http://www.bootply.com/61679">Edit on Bootply</a>.. -->
<!-- </div> -->

<!--   <a href="#" id="btnAdd"><i class="icon-plus-sign-alt"></i> Add Tab</a> -->

				<ul id="myTab" class="nav nav-tabs">
				

				
					<li class="active"><a href="#freshProductMilk"
						data-toggle="tab"> Fresh Product - Milk </a></li>

					<li><a href="#ibaco" data-toggle="tab">Ibaco</a></li>
					<li><a href="#logistics" data-toggle="tab">Logistics</a></li>


	


				</ul>

				<div class="tab-content">
					<div id="ibaco" class="tab-pane fade">
						<h3></h3>
						<p></p>
					</div>
					<div id="logistics" class="tab-pane fade">
						<h3></h3>
						<p></p>
					</div>

				</div>



				<div class="row mt mb">

					<div id="landOwnerAgreementGrid"></div>
				</div>

	<fieldset>
					<legend>Agreement Details</legend>	
				<div class="row mt mb">

		

					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Agreement No</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6"
						style="padding: 1px !important;">

						<input type="text" id="agreementNo" />
					</div>

					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Start Date</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6"
						style="padding: 1px !important;">

						<input type="date" data-date="" data-date-format="DD MMMM YYYY" id="startDate" />
					</div>

					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">End Date</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6" style="padding-left: 3px;">

						<input type="date" data-date="" data-date-format="DD MMMM YYYY" id="endDate" />
					</div>

				</div>
				<div class="row mb">
					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Advance Amount</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6"
						style="padding: 1px !important;">
						<input type="text" id="advanceAmount" />
					</div>

					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Rent Amount</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6"
						style="padding: 1px !important;">
						<input type="text" id="rentAmount" />
					</div>


					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Renewal Type</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6" style="padding-left: 3px;">
						<input type="text" id="renewalType" />
					</div>

					<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" > -->
					<!-- 							<button id="getBtn" class="btn btn-success btn-sm">Get</button> -->
					<!-- 						</div>						 -->
				</div>




				<div class="row mb">
					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">No Of Years</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6"
						style="padding: 1px !important;">
						<input type="text" id="noOfYears" />
					</div>

					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Renewal Date</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6"
						style="padding: 1px !important;">
						<input type="date" data-date="" data-date-format="DD MMMM YYYY" id="renewalDate" />
					</div>


					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Rent Increment(%) </label></div>
					<div class="col-lg-2 col-md-2 col-sm-6" style="padding-left: 3px;">
						<input type="text" id="rentIncrPercentage" />
					</div>


				</div>


				<div class="row mb">
					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Rent Increment Year</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6"
						style="padding: 1px !important;">
						<input type="text" id="rentIncrYear" />
					</div>

					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Plant</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6"
						style="padding: 1px !important;">
						<input type="text" id="plant" />
					</div>


					<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Notice Period</label></div>
					<div class="col-lg-2 col-md-2 col-sm-6" style="padding-left: 3px;">
						<input type="text" id="notice" />
					</div>


				</div>
				
				</fieldset>
				
	
							<fieldset>
					<legend>Shop Details</legend>				
					<div class="row mt mb">
					
						<div class="col-lg-2 col-md-2 col-sm-6"><label class="label_stru">Owner Name</label></div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="ownerName" name="ownerName"/>
						
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6"><label class="label_stru">Shop Address</label></div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="shopAddress" name="shopAddress"/>
						
						</div>
						
					</div>
				
							<div class="row mt mb">
					
						<div class="col-lg-2 col-md-2 col-sm-6"><label class="label_stru">Area in Sq. Ft</label></div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="areaSqft" name="areaSqft"/>
						
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6"><label class="label_stru">Previous Rent per Sq. Ft</label></div>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<input type="text" id="previousRentSqft" name="previousRentSqft"/>
						
						</div>
						
					</div>
						
					

					
					
				
				
				</fieldset>	


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
	<script src="resources/js/custom/landOwnerAgreementStatus.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>


</body>


<script type="text/javascript">
			

		$(document).ready(function(e) {
			
			
			 $.getJSON('getVendorData', function (data) {
			//	 alert("dsd"+data.vendorName);
				 
					if(data.address!="E"){
						$('#vendorName').val(data.vendorName);
						$('#vendorCode').val(data.vendorCode);
							
										
					}
				 
			      console.log(data);

// 			      var items = data.items.map(function (item) {
// 			        return item.key + ': ' + item.value;
// 			      });
			 });
			

			
			
			
			$.ajax({
				type : "GET",
					url : "getVendorOutstandingAmount",
				success : function(response) {
					if (response !="E") {
						$('#outstandingAmount').val(response);
				
					} else {
						$('#outstandingAmount').val("0.00");
					}
				},
				error : function(error) {

				}
			});
		

	});
	</script>


</html>







<%}%>