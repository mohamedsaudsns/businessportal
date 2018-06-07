<%	
	String userName = (String)session.getAttribute("userName");
%>
<header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	          <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        <!-- Logo icon --><b>
                            <!-- Dark Logo icon -->
                            <img src="resources/vendor-images/hap_logo.png" alt="homepage" class="dark-logo"  style=" height: 48px;margin: 0px;    margin-top: 3px;"/>

                        </b>

</a>
                </div>
	
	<!--logo start-->
	<a href="#" class="logo"><b>BUSINESS PORTAL</b> <sup>Beta</sup></a>
	<!--logo end-->
	<div class="nav notify-row" id="top_menu">
		<!--  notification start -->
		<ul class="nav pull-right top-menu">

		</ul>
		<!--  notification end -->
	</div>
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li class="dropdown">
				<a data-toggle="dropdown" class="dropdown-toggle login" href="#"> 
<!-- 					<i class="fa fa-user"></i> -->
				</a>
				<ul class="dropdown-menu extended tasks-bar">
					<div class="notify-arrow notify-arrow-green"></div>					
					<li><a href="Profile">Profile</a></li>
					<li><a href="Change Password">Change Password</a></li>
				</ul>
			</li>
			<li><a class="login" href="#"><b>User Id</b></a></li>
			
				<li><a style="width: 262px;" class="login" href="#"><b>		<input type="text" id="searchUserCode" name="searchUserCode"/></b> </a></li>
			
		
			<li><a style="width: 262px;" class="login" href="#"><b>	<button id="getBtn" class="btn btn-success btn-sm">Get</button></b></a></li>
			<li><a class="login" href="#"><b><%=userName%></b></a></li>
			<li><a class="login" href="Logout"><i
					class="fa fa-power-off" style="margin-top: 5px"></i></a></li>
		</ul>
	</div>	
</header>