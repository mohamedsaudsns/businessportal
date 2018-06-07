<%	
	String userName1 = (String)session.getAttribute("userName");
%>
<header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<!--logo start-->
	<a href="#" class="logo"><b>EMSIS SALESPRO</b></a>
	<!--logo end-->
	
	<div class="nav notify-row" id="top_menu">
		<ul class="nav pull-right top-menu">
			
		</ul>
	</div>
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li class="dropdown">
				<a data-toggle="dropdown" class="dropdown-toggle login" href="#"> 
					<i class="fa fa-user"></i>
				</a>
				<ul class="dropdown-menu extended tasks-bar">
					<!-- <div class="notify-arrow notify-arrow-green"></div>	 -->				
					<li><a href="Profile">Profile</a></li>
					<li><a href="Change Password">Change Password</a></li>
				</ul>
			</li>
			<li><a class="login" href="#"><b><%=userName1%></b></a></li>
			<li><a class="login" href="Logout"><i
					class="fa fa-power-off" style="margin-top: 5px"></i></a></li>
		</ul>
	</div>	
</header>