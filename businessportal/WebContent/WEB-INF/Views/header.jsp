<%	
	String userName = (String)session.getAttribute("userName");
String role = (String)session.getAttribute("role");
String superUser=(String)session.getAttribute("superUser");  

%>
<header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			></div>
	</div>
	          <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        <!-- Logo icon --><b>
                            <!-- Dark Logo icon -->
                            <img src="resources/vendor-images/hap_logo.png" alt="homepage" class="dark-logo"  style=" height: 48px;margin: 0px;    margin-top: 3px;"/>

                        </b>

</a>
<a href="#" class="logo"><b>BUSINESS PORTAL</b> <sup>Beta</sup></a>	
                </div>
	
	<!--logo start-->
	
	<!--logo end-->
<!-- 	<div class="nav notify-row" id="top_menu"> -->
<!-- 		<!--  notification start --> 
<!-- 		<ul class="nav pull-right top-menu"> -->

<!-- 		</ul> -->
<!-- 		<!--  notification end --> 
<!-- 	</div> -->
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
<!-- 			<li class="dropdown"> -->
<!-- 				<a data-toggle="dropdown" class="dropdown-toggle login" href="#">  -->
<!-- 					<i class="fa fa-user"></i> -->
<!-- 				</a> -->
<!-- 				<ul class="dropdown-menu extended tasks-bar"> -->
<!-- 					<div class="notify-arrow notify-arrow-green"></div>					 -->
<!-- 					<li><a href="Profile">Profile</a></li> -->
<!-- 					<li><a href="Change Password">Change Password</a></li> -->
<!-- 				</ul> -->
<!-- 			</li> -->
<!-- <li><a class="login" href="#" style="color: red;width: 300px;"><marquee>* Last updated date : 25/10/2017 </marquee>  </a></li> -->
			<li><a class="login" href="#"><b><%=role%></b></a></li>
			<li><a class="login" href="#"><b><%=userName%></b></a></li>
			<input type="hidden" id="superUser" value="<%=superUser%>">
			<li><a class="login"  onclick="loginAsCheck()"><i
					class="fa fa-power-off" style="margin-top: 5px"></i></a></li>
		</ul>
	</div>	
</header>

	<div class="modal fade" id="SuperUserModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="con-modal-title ">Confirmation</h5>
            </div>

            <div class="super-user-modal-body">

   <div class="col-lg-12 col-md-1 col-sm-6 col-xs-12 ">Do you want switch to another user or logout ?</div>

</div>

                   <div class="modal-footer">
                   
                  <div class="col-lg-3 col-md-1 col-sm-6 col-xs-5 col-lg-offset-3">   <button type="button" class="btn btn-success login" onclick="superUserModel()">Switch User </button></div>
                       
                         <div class="col-lg-3 col-md-1 col-sm-6 col-xs-5">    <button type="button" class="btn btn-danger cancel" onclick="superUserLogOut()" >Logout</button></div>
                       
<!--                         <div class="col-xs-5 col-xs-offset-3"> -->
                          
                          
<!--                         </div> -->
                    </div>
           
            
        </div>
    </div>
</div>



	<div class="modal fade" id="logoutUserModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="logout-modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="con-modal-title ">Confirm Logout</h5>
            </div>

            <div class="super-user-modal-body">

   <div class="col-lg-12 col-md-1 col-sm-6 col-xs-12 ">Are your sure you want to Logout ?</div>

</div>
   <div class="modal-footer">
                   
                  <div class="col-lg-4 col-md-1 col-sm-6 col-xs-5 col-lg-offset-2">   <button type="button"  class="btn btn-success login okButtonSize" onclick="superUserLogOut()">Ok </button></div>
                       
                         <div class="col-lg-4 col-md-1 col-sm-6 col-xs-5">    <button type="button" class="btn btn-danger cancel cancelButtonSize" onclick="closeLogoutModel()"  >Cancel</button></div>
                       
<!--                         <div class="col-xs-5 col-xs-offset-3"> -->
                          
                          
<!--                         </div> -->
                    </div>
           
            
        </div>
    </div>
</div>

<div id="searchsuperWelcomeModel" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="loginas_modal-title">View As</h4>
      </div>
      <div class="modal-body">
        <div class="col-xs-8">
                            <input type="text" class="form-control" name="searchUserId" id="searchUserId"  />
                        </div>
                          <div class="col-xs-2">
        <button type="button" class="btn btn-success login" onclick="validateSuperUser()">Login</button>
        </div>

                  
      </div>
      <div class="modal-footer">
     
                        
      </div>
    </div>

  </div>
</div>
<script type="text/javascript">

function closeLogoutModel(){
	 $('#logoutUserModal').modal('toggle');
	
	
}
function superUserLogOut() {
	
	window.location.href = 'Logout';
	
}

function validateSuperUser() {
	var searchUserId = $('#searchUserId').val();

	if (searchUserId == "" || searchUserId == undefined || searchUserId == null) {
	
		callAlert("orange","Warning","Please Enter User Id");
		return false; 
	
	} else {

		$.ajax({
			type : "GET",
			url : "searchUserValidation?searchUserId=" + searchUserId+"&searchUserFlag=1",
			success : function(response) {
				
				if (response == "Your Not Authorized User For This Login") {
					callAlert("orange","Warning",response);
				
				}else if (response == "Admin") {
					window.location.href = 'Admin';
				} else if (response == "NewUser") {
					
					
					$('#otpGeneratorModal').modal('show'); 
//						window.location.href = 'Welcome';
					
				} else if (response == "Welcome") {
					window.location.href = 'Welcome';
					
				} 
			 else if (response == "DemoWelcome") {
				window.location.href = 'DemoWelcome';
				
			}
				
			 else if (response == "SearchWelcome") {
				 
//					 $('#searchWelcomeModel').modal('show'); 
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


function superUserModel() {
	 $('#SuperUserModal').modal('toggle');
	$('#searchsuperWelcomeModel').modal('show'); 

	
}



	function loginAsCheck() {
			var roleId = $('#superUser').val();
			console.log("roleId.."+roleId);
		
			if (roleId == "1" ) {
				$('#SuperUserModal').modal('show'); 
			
			
			} else  {
				$('#logoutUserModal').modal('show'); 
				
// 				window.location.href = 'Logout';
			
			}	
		}
		</script>