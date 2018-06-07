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

<title>Change Password</title>

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
<link href="resources/jqwidgets/styles/jqx.bootstrap.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-start.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-redmond.css" rel="stylesheet">

<!-- <script src="assets/js/chart-master/Chart.js"></script> -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<%
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			response.sendRedirect("Logout");
		} else {	
	%>
	
	<style type="text/css">
	.container{
	
/* 	  padding-left: 20%; */
/*     padding-right: 20%; */
/*     padding-top: 10%; */
	
	}
	
	</style>
	
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
				 <div id="login-page">
	  	<div class="container">
					<div class="row mt mb" style="    border-top: #1c5f8e 2px solid; border-right: #1c5f8e 2px solid; border-left: #1c5f8e 2px solid;padding: 7px; margin-bottom: 0px;     padding-top: 12px">
					
						<div class="col-lg-4 col-md-4 col-sm-6" ><label class="label_stru">Old Password</label></div>
						<div class="col-lg-6 col-md-6 col-sm-6">
						<input type="text" id="oldPassword" name="oldPassword"/>
						
						</div>
						</div>
						<div class="row mt mb" style="border-right: #1c5f8e 2px solid; border-left: #1c5f8e 2px solid;padding: 7px; margin-bottom: 0px;">
					
					
						<div class="col-lg-4 col-md-4 col-sm-6" style="border:thin"><label class="label_stru">New Password</label></div>
						<div class="col-lg-6 col-md-6 col-sm-6">
						<input type="text" id="newPassword" name="newPassword"/>
						
						</div>
						
						</div>
							<div class="row mt mb" style="border-right: #1c5f8e 2px solid; border-left: #1c5f8e 2px solid;padding: 7px; margin-bottom: 0px;">
						<div class="col-lg-4 col-md-4 col-sm-6"><label class="label_stru">Confirm Password</label></div>
						<div class="col-lg-6 col-md-6 col-sm-6">
					  <input type="password" class="form-control" id="confirmPassword" name="confirmpassword" onblur="checkPassword();" />
						
							</div>
						</div>
						<div class="row mt mb" style="border-bottom: #1c5f8e 2px solid; border-right: #1c5f8e 2px solid; border-left: #1c5f8e 2px solid; padding: 7px; margin-bottom: 0px;">
						<div class="col-lg-6 col-md-6 col-sm-6"><label class="label_stru"></label></div>
						<div class="col-lg-3 col-md-3 col-sm-6">
						
						 <button type="button" class="btn btn-success btn-sm login" onclick="callOtpScreen()">Reset</button>
						</div>
				
					</div>
					
					
					
					
			<div class="modal fade" id="otpGeneratorModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Reset Password OTP Generate</h5>
            </div>

            <div class="modal-body">

  <p>You are new user, so please generate OTP for reset password.</p>

</div>

                   <div class="modal-footer">
                        <div class="col-xs-5 col-xs-offset-3">
                            <button type="button" class="btn btn-success login" onclick="generateOtp()">Generate OTP</button>
<!--                             <button type="button" class="btn btn-danger cancel" data-dismiss="modal">Cancel</button> -->
                        </div>
                    </div>
           
            
        </div>
    </div>
</div>
				
				
				
				
				<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Confirmation</h4>
      </div>
      <div class="modal-body">
        <p>Your code has been sent to your mobile No, Please enter it below to complete the verification.</p>
           
                  
      </div>
      <div class="modal-footer">
       <label class="col-xs-3 control-label">Enter Your OTP Code</label>
                        <div class="col-xs-5">
                            <input type="password" class="form-control" name="currentOtp" id="currentOtp"  />
                        </div>
                          <div class="col-xs-2" style="text-align: center;">
        <button type="button" class="btn btn-success login" onclick="validateOtp()">Verify</button>
        </div>
      </div>
    </div>

  </div>
</div>
				</div>
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
	<script src="resources/jqwidgets/globalization/globalize.js"></script>
	
	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
	<script src="resources/js/custom/Auth.js"></script>
	<script src="resources/js/custom/ChangePassword.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>
</body>


<script type="text/javascript">


	

	$(document).ready(function(e) {
		 $('#daily_update_text').css('display', 'none');
		
	
		 

		
	});
</script>
</html>
<%}%>