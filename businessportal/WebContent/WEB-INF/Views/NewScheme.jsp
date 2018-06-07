
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

<title>New Scheme Launch</title>

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


				<%@include file="Department.jsp"%>
<div class="custom-myCarousel">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<!-- 						<li data-target="#myCarousel" data-slide-to="0" class="active" -->
						<!-- 							contenteditable="false"></li> -->
						<!-- 						<li data-target="#myCarousel" data-slide-to="1" class="" -->
						<!-- 							contenteditable="false"></li> -->
						<!-- 						<li data-target="#myCarousel" data-slide-to="2" class="" -->
						<!-- 							contenteditable="false"></li> -->
					</ol>
					<div class="carousel-inner" role="listbox">
						<!-- 						<div class="item active"> -->
						<!-- 							<img src="resources/vendor-images/hatsun_bg_2.jpg" data-color="lightblue" alt="IMG-1"  -->
						<!-- 								>						 -->
						<!-- 						</div> -->
						<!-- 						<div class="item"> -->
						<!-- 						<iframe src="productImageById?itemNo=1&compCode=1000&departmentId=1" width="900" height="500" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe> -->
						<!-- <!-- 							<img src="resources/vendor-images/hatsun_bg_1.jpg" alt="IMG-2" -->
						<!-- <!-- 								class=""> -->
						<!-- 						</div> -->
						<!-- 						<div class="item" style=""> -->
						<!-- 							<img src="resources/vendor-images/hatsun_bg_3.jpg" alt="IMG-3" -->
						<!-- 								class=""> -->
						<!-- 						</div> -->
					</div>
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>

				<!-- <div id="bxsliderPos"> -->
				<!-- <ul class="bxslider"> -->
				<!--   <li> -->
				<!--   <div class="bx-caption"><span>My caption</span></div> -->
				<!--     <iframe src="productImageById?itemNo=1&compCode=1000&departmentId=1" width="900" height="500" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe> -->

				<!--   </li> -->

				<!--     <li> -->
				<!--   <div class="bx-caption"><span>My captionxxxx</span></div> -->
				<!--     <iframe src="productImageById?itemNo=1&compCode=1000&departmentId=1" width="900" height="500" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe> -->

				<!--   </li> -->
				<!--   <li> -->
				<!--   <div class="bx-caption"><span>My caption1</span></div> -->
				<!--   <img src="resources/vendor-images/hatsun_bg_2.jpg" /> -->
				<!--   </li> -->
				<!-- </ul> -->
				<!-- </div> -->
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
	<script src="resources/js/custom/NewScheme.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>














</body>


<script type="text/javascript">


	function getSelectedTabId() {
		return $("#myTab .active > a").attr("href");
	}



	function getProductImageList(depId) {

		//alert("calling new prd.."+depId);
		var output = "";
		$('.carousel-inner').empty();

		$.getJSON('getSchemeByDepartment?departmentId=' + depId, function(data) {
			$.each(data, function(index, value) {

				// alert(index + ' ' + value);
				$.each(this, function(k, v) {
					//  alert(k + ' itemNo ' + v.itemNo);
					// 	            alert(k + ' compCode ' + v.compCode);
					// 	            alert(k + ' department ' + v.department);

					// 	            $("#bxsliderPos ul").append('<li><a href="/user/messages"><span class="tab">Message Center</span></a></li>');

					///   output+='<li><iframe src="productImageById?itemNo='+v.itemNo+'&compCode='+v.compCode+'&departmentId='+v.department+'" width="900" height="500" name="'+v.productName+'"> frameborder="0" ></iframe></li>';

					if (k === 0) {
						output += '<div class="item active"><iframe src="schemeImageById?itemNo=' + v.itemNo + '&compCode=' + v.compCode + '&departmentId=' + v.department + '"" width="900" height="500" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe> <div class="carousel-caption"><h3>'+v.productName+'</h3><p></p> </div></div>';
					} else {

						output += '<div class="item"><iframe src="schemeImageById?itemNo=' + v.itemNo + '&compCode=' + v.compCode + '&departmentId=' + v.department + '"" width="900" height="500" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe> <div class="carousel-caption"><h3>'+v.productName+'</h3><p></p> </div></div>';
					}


				});
			});

			//   alert("output.."+output);

			$(".carousel-inner").append(output);
		});


		// 	alert("output.."+output);
		// 	$("ul.bxslider").append(output);

	// 	slider.reloadSlider();	
	}

	// $(function() {
	//     $( "#myTab" ).tabs();

	//     //update the display of the selected id 
	//     $("#myTab").click(function(e){
	//          alert(getSelectedTabId());
	//     });

	//     //initalize the selected id display    
	//     $("#myTab").click();

	//   });



	$(document).ready(function(e) {




		//alert(getSelectedTabId());

		var depId = getSelectedTabId();

		getProductImageList(depId);




		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			var target = $(e.target).attr("href");
			// alert("target.."+target);

			getProductImageList(target);
		});

		// 			var cur=$('#myTab .active').text();
		// 			alert("myTab.."+cur);

		// 			var tabValue = $("#myTab .active > a").attr("href");
		// 			alert("myTab.1111."+tabValue);


		// 			  $("#myTab").click(function(e){
		// 		          alert(getSelectedTabId());
		// 		     });


		// 		     $("#myTab").click();


		// 			var href = $("#myTab .active").attr("href");
		// 			href = href.substring(href.indexOf("#") + 1);
		// 			alert(href);

		// 			 $('a[data-toggle="tab"]').on('shown.bs.tab', function(e){
		// 			        var currentTab = $(e.target).text(); // get current tab
		// 			        var LastTab = $(e.relatedTarget).text(); // get last tab
		// 			        alert("curr"+currentTab); 
		// 			        alert("last"+LastTab);





		// 			    });








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