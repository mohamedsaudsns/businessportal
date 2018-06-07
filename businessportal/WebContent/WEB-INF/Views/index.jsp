

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
	content="vendor portal">

<title>Login</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/style-responsive.css" rel="stylesheet">
<link href="resources/css/jquery-confirm.min.css" rel="stylesheet">

<!-- <script src="assets/js/chart-master/Chart.js"></script> -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	/* display: none; <- Crashes Chrome on hover */
	-webkit-appearance: none;
	margin: 0;
	/* <-- Apparently some margin are still there even though it's hidden */
}
</style>
</head>

	<%
		String vendorEmailId = (String) session.getAttribute("vendorEmailId");
	
	%>

<body>

	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
		
		          <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">
                        <!-- Logo icon --><b>
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            <!-- Dark Logo icon -->
<!--                                <img src="resources/vendor-images/hap_logo_name.png" alt="homepage" class="dark-logo" style="width: 80%;"  /> -->
                               
                                <img src="resources/vendor-images/hap_logo.png" alt="homepage" class="dark-logo"  style=" height: 48px;margin: 0px;    margin-top: 3px;"/>
                            <!-- Light Logo icon -->
<!--                             <img src="../assets/images/logo-light-icon.png" alt="homepage" class="light-logo" /> -->
                        </b>
                        <!--End Logo icon -->
                        <!-- Logo text -->
<!--                         <span> -->
                         <!-- dark Logo text -->
<!--                          <img src="../assets/images/logo-text.png" alt="homepage" class="dark-logo" /> -->
                         <!-- Light Logo text -->    
<!--                          <img src="../assets/images/logo-light-text.png" class="light-logo" alt="homepage" /></span> </a> -->
</a>
<a href="#" class="logo"><b>BUSINESS PORTAL</b> <sup>Beta</sup></a>
                </div>
			<!-- <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div> -->
			<!--logo start-->
			
			<!--logo end-->
<!-- 			<div class="nav notify-row" id="top_menu"> -->
<!-- 				 notification start -->
<!-- 				<ul class="nav pull-right top-menu"> -->

<!-- 				</ul> -->
<!-- 				 notification end -->
<!-- 			</div> -->
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li id="indexLogin">
						
					
					<div class="col-lg-5 col-md-2 col-sm-6 col-xs-4"  id="cust-padding-1"><a class="login"><input type="text" name="username"
							id="username" class="form-control" placeholder="User ID"
							autofocus ></a></div>
							<div class="col-lg-5 col-md-2 col-sm-6 col-xs-4" id="cust-padding-1" >
							<a class="login"><input type="password"
							name="password" id="password" class="form-control"
							placeholder="Password" onkeypress="return runScript(event)"></a>
							</div>
							
							<div class="col-lg-2 col-md-2 col-sm-6 col-xs-1" id="cust-padding-1" >
							<a class="login"><button class="btn btn-info" class="form-control"
								type="button" onclick="validateLogin()">
								<i class="fa fa-lock"></i>&nbsp;Login
							</button></a>
							</div>
						
							</li>
							
							
							
							
								<div class="top-menu">
				<ul class="nav pull-left top-menu">
					<li id="forgetPasswordLi">
		
						
					
					<div class="col-lg-12 col-md-2 col-sm-6 col-xs-12"  >
					
					
					
					<a href="#forgetPasswordModal" data-toggle="modal" id="forgotDesc">Forgot your password 	?</a>
					
			</div>
						
							</li>
							
								<li id="resetPasswordLi">
		
						
					
					<div class="col-lg-12 col-md-2 col-sm-6 col-xs-12"  >
					
					
					
					<a href="#forgetOtpModal" data-toggle="modal" id="resetPasswordDesc">Reset your password </a>
					
			</div>
						
							</li>

							
					
							

							
								
				</ul>
			</div>
							
							
<!-- 					<li> -->
<!-- 					</li> -->
<!-- 					<li> -->
							
					
							
<!-- 							</li> -->
<!-- 							<li>		<a class="login"><button class="btn btn-info" class="form-control" -->
<!-- 								type="button" onclick="validateLogin()"> -->
<!-- 								<i class="fa fa-lock"></i>&nbsp;Forget Password -->
<!-- 							</button></a></li> -->
							
								
				</ul>
			</div>
			
			
			
			
			
			
			
			
			
		</header>
		


		
		
		<!--header end-->		
		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
	
		

			<section class="wrapper" style="
    height: 100%;
" >
<section id="main-content"></section>

<p class="text-center" style="margin-top: inherit;background-image:url('./resources/vendor-images/hap_bg.png');/* width: 100%; */height: 80%;background-repeat: no-repeat;background-position: bottom;background-size: contain;" >

<!-- <img src="resources/vendor-images/hap_bg.png"  class="center-block img-responsive"  alt="IMG-1"> -->
</p>
			
					<div class="container-fluid no-padding">
					<div class="clearfix"></div>
					
					
				

</div>
			

			</section>
		<!--main content end-->

		<!--footer start-->
<%-- 		<%@include file="indexfooter.jsp" %> --%>
		
			<div class="modal fade" tabindex="-1" role="dialog" id="login">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Login</h4>
				</div>
					 <form method="post" action="Welcome" onsubmit="return loginvalidation();">
				<div class="modal-body">
					<div class="row custRow">
						<div class="col-md-12"> 
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-user" aria-hidden="true"></i></span>
							  <input type="text" class="form-control" placeholder="Username" id="uname" name="uname" onkeypress="return isNumber(event);" maxlength="6" aria-describedby="basic-addon1">
							</div>
						</div>
<!-- 						<div class="col-md-6">  -->
<!-- 							<input type="text" tabindex="1" placeholder="UserName" id="uname" name="uname" onkeypress="return isNumber(event);" maxlength="6"> -->
<!-- 						</div> -->
					</div>
					<div class="row custRow">
						<div class="col-md-12">
							<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1"><i class="fa fa-key" aria-hidden="true"></i></span>
							  <input type="password" class="form-control" placeholder="Password" id="password" name="password" tabindex="2">
							</div> 
							
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							 <input type="submit" value="Login" class="btn btn-success login"  tabindex="4">
							 <input type="button" value="Cancel" class="btn btn-danger cancel"  tabindex="4" data-dismiss="modal">
						</div>
					</div>
					<div style="visibility: hidden;text-align: center; vertical-align: middle;margin-top: 10px;" id="errorDiv"></div>
				</div>
				</form>
<!-- 				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	</div>
	
	
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Reset Your Password</h5>
            </div>

            <div class="modal-body">
                <!-- The form is placed inside the body of modal -->
                <form id="loginForm" method="post" class="form-horizontal">
<!--                     <div class="form-group"> -->
<!--                         <label class="col-xs-3 control-label">User Id</label> -->
<!--                         <div class="col-xs-5"> -->
<!--                             <input type="text" class="form-control" name="userId"  /> -->
<!--                         </div> -->
<!--                     </div> -->

         
                    
                               <div class="form-group">
                        <label class="col-xs-3 control-label">New Password</label>
                        <div class="col-xs-5">
                            <input type="password" id="newPassword" class="form-control" name="newPassword"  />
                        </div>
                    </div>
                    
                              <div class="form-group">
                        <label class="col-xs-3 control-label">Confirm Password</label>
                        <div class="col-xs-5">
                            <input type="password" class="form-control" id="confirmPassword" name="confirmpassword" onblur="checkPassword();" />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-5 col-xs-offset-3">
                            <button type="button" class="btn btn-success login" onclick="resetPassword()">Submit</button>
                            <button type="button" class="btn btn-danger cancel" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
	
		<div class="modal fade" id="forgetLoginModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Forgot Password</h5>
            </div>

            <div class="modal-body">
                <!-- The form is placed inside the body of modal -->
                <form id="loginForm" method="post" class="form-horizontal">
<!--                     <div class="form-group"> -->
<!--                         <label class="col-xs-3 control-label">User Id</label> -->
<!--                         <div class="col-xs-5"> -->
<!--                             <input type="text" class="form-control" name="userId"  /> -->
<!--                         </div> -->
<!--                     </div> -->
         <div class="form-group">
                        <label class="col-xs-3 control-label">User Id</label>
                        <div class="col-xs-5">
                            <input type="text" id="fpUserId" class="form-control" name="newPassword"  />
                        </div>
                    </div>
         
                    
                               <div class="form-group">
                        <label class="col-xs-3 control-label">New Password</label>
                        <div class="col-xs-5">
                            <input type="password" id="fpNewPassword" class="form-control" name="newPassword"  />
                        </div>
                    </div>
                    
                              <div class="form-group">
                        <label class="col-xs-3 control-label">Confirm Password</label>
                        <div class="col-xs-5">
                            <input type="password" class="form-control" id="fpConfirmPassword" name="confirmpassword" onblur="checkPassword();" />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-5 col-xs-offset-3">
                            <button type="button" class="btn btn-success login" onclick="forgetPassword()">Submit</button>
                            <button type="button" class="btn btn-danger cancel" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
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
                          <div class="col-xs-2">
        <button type="button" class="btn btn-success login" onclick="validateOtp()">Verify</button>
        </div>
      </div>
    </div>

  </div>
</div>




<div id="searchWelcomeModel" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">View As</h4>
      </div>
      <div class="modal-body">
        <div class="col-lg-5 col-md-1 col-sm-6 col-xs-8">
                            <input type="text" class="form-control" name="searchUserId" id="searchUserId"  />
                        </div>
                          <div class=" col-lg-2 col-md-1 col-sm-6 col-xs-2">
        <button type="button" class="btn btn-success login" onclick="validateSearchUser()">Login</button>
        </div>

                  
      </div>
      <div class="modal-footer">
     
                        
      </div>
    </div>

  </div>
</div>

 <!-- Modal -->
  <div class="modal fade" id="myModal1232" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Forgot Password</h4>
        </div>
        <div class="modal-body">
          <p> <div class="col-lg-5 col-xs-4"> Enter Your Register Mobile No</div> <div class="col-lg-4 col-xs-4"> <input type="text" id="regMobileNo" class="form-control" name="currentPassword"  /></div></p>
         
        </div>
        <div class="modal-footer">
          <div class=" col-lg-5 col-xs-8 col-xs-offset-3">
                            <button type="button" class="btn btn-success login" style="float: right;" onclick="generateForgetPassword()">Submit</button>
                            <button type="button" class="btn btn-danger cancel" style="float: left;" data-dismiss="modal">Cancel</button>
                        </div>
        </div>
      </div>
      </div>
      </div>


<div class="modal fade" id="forgetPasswordModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Forgot Password</h5>
            </div>

            <div class="modal-body">
                <!-- The form is placed inside the body of modal -->
                <form id="loginForm" method="post" class="form-horizontal">
              

                    <div class="form-group">
                      <label style="font-weight: 700;" class="col-lg-5 col-xs-8 control-label">Enter Your Register Mobile No</label>
                      
                        <div class="col-lg-4 col-xs-4">
                            <input type="text" id="regMobileNo" class="form-control" name="currentPassword"  />
                        </div>
                       
                    </div>
                    
                        <div class="form-group">
                        <div class=" col-lg-5 col-xs-8 col-xs-offset-3">
                            <button type="button" class="btn btn-success login" style="float: right;" onclick="generateForgetPassword()">Submit</button>
                            <button type="button" class="btn btn-danger cancel" style="float: left;" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
          

<!--                     <div class="form-group"> -->
<!--                         <div class="col-xs-5 col-xs-offset-3"> -->
<!--                             <button type="submit" class="btn btn-success login">Verify</button> -->
<!-- <!--                             <button type="button" class="btn btn-danger cancel" data-dismiss="modal">Cancel</button> --> 
<!--                         </div> -->
<!--                     </div> -->
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="forgetOtpModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Reset Password</h5>
            </div>

            <div class="modal-body">
                <!-- The form is placed inside the body of modal -->
                <form id="loginForm" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-xs-12 control-label">Your code has been sent to your mobile no, Please enter it below to complete the verification.</label>
                       
                    </div>
 <div class="form-group">
  <label class="col-xs-4 control-label">User Id</label>
                        <div class="col-xs-5">
                            <input type="text" class="form-control" id="reForUserId"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 control-label">OTP Code</label>
                        <div class="col-xs-5">
                            <input type="password" class="form-control" id="reForOtp"  />
                        </div>
                         <div class="col-xs-2">
                          <button type="button" class="btn btn-success login" onclick="validateForgetPasswordOtp()">Verify</button>
                          </div>
                    </div>
                    
                   
                    
          


                </form>
            </div>
        </div>
    </div>
</div>


	<div class="modal fade" id="otpConfirmationModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Login</h5>
            </div>

            <div class="modal-body">
                <!-- The form is placed inside the body of modal -->
                <form id="loginForm" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-xs-12 control-label">Your code has been sent to your mobile no, Please enter it below to complete the verification.</label>
                       
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Enter Your OTP Code</label>
                        <div class="col-xs-5">
                            <input type="password" class="form-control" name="currentPassword"  />
                        </div>
                         <div class="col-xs-2">
                          <button type="submit" class="btn btn-success login">Verify</button>
                          </div>
                    </div>
                    
          


                </form>
            </div>
        </div>
    </div>
</div>



	
	
	
	<!-- /.modal -->
		
		<!--footer end-->		   
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
	<script src="resources/js/jquery.modal.min.js"></script>

	<!--common script for all pages-->
	<script src="resources/js/common-scripts.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>
	
	
	
	 <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="resources/js/jquery.backstretch.min.js"></script>
    <script>
//         $.backstretch("resources/vendor-images/hap_bg.png", {speed: 500});
    </script>

	<script type="text/javascript">
	
	function checkPassword(){
		var newPassword = $("#newPassword").val();
		var confirmPassword = $("#confirmPassword").val();
		if(newPassword!=''){
		if(newPassword!=confirmPassword){
			
			callAlert("red","Error","New password and confirm password are not matching please enter correct password...");
		}
		}else{
			
		}
	}
	
	
	
		$(document).ready(function(e) {
			


			/* $('#myCarousel').carousel();
			var winWidth = $(window).innerWidth();
			$(window).resize(function() {

				if ($(window).innerWidth() < winWidth) {
					$('.carousel-inner>.item>img').css({
						'min-width' : winWidth,
						'width' : winWidth
					});
				} else {
					winWidth = $(window).innerWidth();
					$('.carousel-inner>.item>img').css({
						'min-width' : '',
						'width' : ''
					});
				}
			}); */
		});
		function forgetPassword() {
			var userId = $('#fpUserId').val();
		
			var newPassword = $('#fpNewPassword').val();
			var confirmPassword = $('#fpConfirmPassword').val();
			if (userId == "" || userId == undefined || userId == null) {

				callAlert("orange","Warning","Please Enter User Id");
				return false; 
			}else if (newPassword == "" || newPassword == undefined || newPassword == null) {

				callAlert("orange","Warning","Please Enter Password");
				return false; 
			
			} else if (confirmPassword == "" || confirmPassword == undefined || confirmPassword == null) {

				callAlert("orange","Warning","Please Enter Confirm Password");
				return false; 
			
			}	else {
				
				 $('#forgetLoginModal').modal('toggle');
				$.ajax({
					type : "GET",
					url : "forgetPassword?userId="+userId+"&newPassword=" + newPassword,
					success : function(response) {
						if (response == "success") {
							
							callAlert("green","Success","Your Password has been reset");
				
						} else {
							callAlert("red","Error","Unable to reset password");
						}
					},
					error : function(error) {

					}
				});
			}
		}
		
		
		function generateForgetPassword() {
			var regMobileNo = $('#regMobileNo').val();
		
		
			if (regMobileNo == "" || regMobileNo == undefined || regMobileNo == null) {

				callAlert("orange","Warning","Please Enter User Id");
				return false; 
			}	else {
				
				
				$.ajax({
					type : "GET",
					url : "registerForgetPassword?regMobileNo="+regMobileNo,
					success : function(response) {
						if (response == "success") {
							 $('#forgetPasswordModal').modal('toggle');
							 $('#regMobileNo').val("");
							
							 callAlert("green","Alert","OTP Successfully Sent");
				
						} else {
							callAlert("red","Error","OTP not Sent, so please enter correct mobile no");	
						}
					},
					error : function(error) {

					}
				});
			}
		}
		
		
		
		function resetPassword() {
			var newPassword = $('#newPassword').val();
			var confirmPassword = $('#confirmPassword').val();
			if (newPassword == "" || newPassword == undefined || newPassword == null) {

				callAlert("orange","Warning","Please Enter Password");
				return false; 
			
			} else if (confirmPassword == "" || confirmPassword == undefined || confirmPassword == null) {

				callAlert("orange","Warning","Please Enter Confirm Password");
				return false; 
			
			}	else {
				$.ajax({
					type : "GET",
					url : "resetPassword?newPassword=" + newPassword,
					success : function(response) {
						if (response == "success") {
							
							window.location.href = 'Welcome';
				
						} else {
							callAlert("red","Error","Unable to reset password");
						}
					},
					error : function(error) {

					}
				});
			}
		}
		
		
		function generateOtp() {

			 $('#otpGeneratorModal').modal('toggle');

				$.ajax({
					type : "GET",
					url : "generateVendorPasswordOtp",
					success : function(response) {
						if (response == "S") {
							
							callAlert("green","Alert","OTP Successfully Sent");
							
						}else{
							
							callAlert("red","Error","OTP not Sent");	
							
						}
					},
					error : function(error) {
						callAlert("red","Error","OTP not Sent");	

					}
				});
			
		}
		
		
		
		function validateOtp() {
			var currentOtp = $('#currentOtp').val();
			var password = $('#password').val();
			if (currentOtp == "" || currentOtp == undefined || currentOtp == null) {

				callAlert("orange","Warning","Please Enter OTP Code");
				return false; 
			
			} else {
				$.ajax({
					type : "GET",
					url : "OtpValidation?otpCode=" + currentOtp,
					success : function(response) {
						if (response == "success") {
							
							 $('#myModal').modal('toggle');
							$('#loginModal').modal('show'); 
				
						} else {
							callAlert("red","Error","Incorrect OTP Code ");
						}
					},
					error : function(error) {

					}
				});
			}
		}
		
		function validateForgetPasswordOtp() {
			var userId = $('#reForUserId').val();
			var currentOtp = $('#reForOtp').val();
			if (userId == "" || userId == undefined || userId == null) {

				callAlert("orange","Warning","Please Enter User Id");
				return false; 
			
			}else if (currentOtp == "" || currentOtp == undefined || currentOtp == null) {

				callAlert("orange","Warning","Please Enter OTP Code");
				return false; 
			
			} else {
				$.ajax({
					type : "GET",
					url : "forgetOtpValidation?userid="+userId+"&otpCode=" + currentOtp,
					success : function(response) {
						if (response == "success") {
							
							 $('#forgetOtpModal').modal('toggle');
							$('#loginModal').modal('show'); 
				
						} else {
							callAlert("red","Error","Incorrect User Id Or OTP Code ");
						}
					},
					error : function(error) {

					}
				});
			}
		}
		
		
		
		function validateSearchUser() {
			var searchUserId = $('#searchUserId').val();
		
			if (searchUserId == "" || searchUserId == undefined || searchUserId == null) {
			
				callAlert("orange","Warning","Please Enter User Id");
				return false; 
			
			} else {
	
				$.ajax({
					type : "GET",
					url : "searchUserValidation?searchUserId=" + searchUserId+"&searchUserFlag=0",
					success : function(response) {
						
						if (response == "Your Not Authorized User For This Login") {
							callAlert("orange","Warning",response);
						
						}else if (response == "Admin") {
							window.location.href = 'Admin';
						} else if (response == "NewUser") {
							
							
							$('#otpGeneratorModal').modal('show'); 
// 							window.location.href = 'Welcome';
							
						} else if (response == "Welcome") {
							window.location.href = 'Welcome';
							
						} 
					 else if (response == "DemoWelcome") {
						window.location.href = 'DemoWelcome';
						
					}
						
					 else if (response == "SearchWelcome") {
						 
// 						 $('#searchWelcomeModel').modal('show'); 
							window.location.href = 'SearchWelcome';
							
							
							
						} else if(response == "InchargeWelcome"){
							window.location.href = 'InchargeWelcome';
							
							
						}
						
						
						else if (response == "OTPUser") {
							
							
							$('#myModal').modal('show'); 
							
							
								
							
						} else if (response == "E") {
							/* alert("Server Down"); */
							callAlert("red","Error","Server Down");
						} else {
							/* alert(response); */
							callAlert("orange","Warning",response);
						}
						
						$('#searchUserId').val("");
						 $('#searchWelcomeModel').modal('toggle');
					},
					error : function(error) {

					}
				});
			}
		}
		
		function validateLogin() {
			var userName = $('#username').val();
			var password = $('#password').val();
			var superUser= $('#superUser').val();
			if (userName == "" || userName == undefined || userName == null) {
				/* alert("Please Enter User Name"); */
				callAlert("orange","Warning","Please Enter User Name");
				return false; 
			} else if (password == "" || password == undefined || password == null) {
				/* alert("Please Enter Password"); */
				callAlert("orange","Warning","Please Enter Password");
				return false;
			} else {
				$.ajax({
					type : "GET",
					url : "Login?userName=" + userName + "&password="
							+ password+"&superUser="+superUser,
					success : function(response) {
						if (response == "Admin") {
							window.location.href = 'Admin';
						} else if (response == "NewUser") {
							
							
							$('#otpGeneratorModal').modal('show'); 
// 							window.location.href = 'Welcome';
							
						} else if (response == "Welcome") {
							window.location.href = 'Welcome';
							
						} 
					 else if (response == "DemoWelcome") {
						window.location.href = 'DemoWelcome';
						
					}
						
					 else if (response == "SearchWelcomeValidation") {
						 
						 $('#searchWelcomeModel').modal('show'); 
							//window.location.href = 'SearchWelcome';
							
							
							
						} else if(response == "InchargeWelcome"){
							window.location.href = 'InchargeWelcome';
							
							
						}
						
						
						else if (response == "OTPUser") {
							
							
							$('#myModal').modal('show'); 
							
							
								
							
						} 
		else if (response == "ForgetPasswordUser") {
							
							
							$('#otpConfirmationModal').modal('show'); 
							
							
								
							
						 
						
					} else if(response == "AdminDashboard"){
						window.location.href = 'AdminDashboard';
						
						
					}
						
						
						else if (response == "E") {
							/* alert("Server Down"); */
							callAlert("red","Error","Server Down");
						} else {
							/* alert(response); */
							callAlert("orange","Warning",response);
						}
					},
					error : function(error) {

					}
				});
			}
		}

		function runScript(e) {
			if (e.keyCode == 13) {
				e.preventDefault();
				validateLogin();
			}
		}
	</script>

</body>
</html>
