
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

<title>News Letter</title>

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
	#rentIncrYear, #plant, #notice, #ownerName, #shopAddress, #areaSqft,
	#previousRentSqft {
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
				
<!-- 				<div class="row mt mb"> -->
<!-- 						<div class="col-lg-2 col-md-1 col-sm-6"><label class="label_stru">Language</label></div> -->
<!-- 						<div class="col-lg-2 col-md-2 col-sm-6" -->
<!-- 							style="padding: 1px !important;"> -->

<!-- 							<div id="newsLetterLanguage"></div> -->
<!-- 						</div> -->
		


<!-- 	<div class="col-lg-2 col-md-2 col-sm-6" > -->
<!-- 							<button id="getBtn" class="btn btn-success btn-sm">Get</button> -->
<!-- 						</div> -->

<!-- 					</div> -->
					<div class="row mt mb">
					<iframe id="testIframe" style="border: 0; top:0; width: 100%; "  height="680" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>
				
			</div>

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
	<script src="resources/js/custom/hmb/NewsLetter.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>














</body>


<script type="text/javascript">






// 	function getNewsLetterImage() {
// 		var languageId=$("newsLetterLanguage").val();
		
// 		 document.getElementById("testIframe").src ='newsLetterImageById?languageId='+languageId;




// 	}

	

	$(document).ready(function(e) {
		 $('#daily_update_text').css('display', 'none');
		
		var loc='newsLetterImageById';
		
		$('#testIframe').attr("src",loc);
		
		$('#getBtn').click(function (e) {
			var languageId=$("#newsLetterLanguage").val();
			//alert("languageId.."+languageId);
var loc='newsLetterImageById';
			
			$('#testIframe').attr("src",loc);
			
			// document.getElementById("testIframe").src ='newsLetterImageById?languageId='+languageId+'#zoom=100';

		});
		 

		
	});
</script>
<link href="resources/css/jquery.bxslider.css" rel="stylesheet">
<link href="resources/css/jquery.bxslider.min.css" rel="stylesheet">


<script src="resources/js/jquery.bxslider.min.js"></script>
<script src="resources/js/jquery.bxslider.js"></script>

<script src="resources/js/jquery.easing.1.3.js"></script>
<script src="resources/js/jquery.fitvids.js"></script>

</html>







<%}%>