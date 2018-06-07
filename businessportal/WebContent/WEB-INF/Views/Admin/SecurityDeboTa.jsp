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

<title>Security Deposit Status</title>

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

<!-- <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/> -->


<link rel="stylesheet" type="text/css" href="resources/jquery-ui-1.11.4.custom/jquery-ui.css"/>

<!-- Tabulator  -->

	<link type="text/css" href="resources/tabulator/css/tabulator_custom.css" rel="stylesheet">


 <style type="text/css">
        .loaderimg
        {
            background: url(resources/img/loader.gif);
            background-repeat: no-repeat;
            background-position: right;
        }
    </style>


 



<!-- <script src="assets/js/chart-master/Chart.js"></script> -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
 <style type="text/css">
.tabulator .tabulator-col-title{
    text-align:center;
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
			<%@include file="..//header.jsp" %>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<%@include file="..//menu.jsp" %>
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<%@include file="..//Breadcrump.jsp" %>
				
			
					<div class="row mt mb" style="padding-top: 7px">

					
						
							<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5" ><label class="label_stru">Vendor Code</label></div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5" style="padding: 1px !important;" >
							
								<input type="text" id="vendorCode"   />
						</div>
						
							<div class="col-lg-2 col-md-2 col-sm-6 col-xs-5"  ><label class="label_stru">Vendor Name</label></div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-5" style="padding: 1px !important;" >
							
								<input type="text" id="vendorName"  />
						</div>
				
					<div class="col-lg-1 col-md-2 col-sm-6 col-xs-2" >
						<button   id="getBtn" class="btn btn-success btn-sm">Get</button>
						</div>	
						<div class="col-lg-12 col-md-2 col-sm-6 col-xs-5" >
      
         
   
    </div>

						<div id="example-table"></div>





		
				<div id="oustandingReportGrid"></div>
				</div>
				
			</section>
		</section>
		<!--main content end-->
		<!--footer start-->
			<%@include file="..//footer.jsp" %>
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
	<script src="resources/js/custom/admin/SecurityDeboTa.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>
	
	
	
	
	
	
<!-- 	 Jquery UI -->

<script type="text/javascript" src="resources/jquery-ui-1.11.4.custom/jquery-ui.js"></script>






<!-- Tabulator -->




<script type="text/javascript" src="resources/tabulator/js/tabulator.min.js"></script>
	
	
	
	
	
	
	
	

	
</body>



	
			<script type="text/javascript">


		$(document).ready(function(e) {
			$('#getBtn').on("click",function(e){
			$("#example-table").tabulator("setData", "getMilkHeaderData?selected_month=August-2017");
			});
			$("#example-table").tabulator({
			    height:540, // set height of table (in CSS or here), this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
			    layout:"fitColumns", //fit columns to width of table (optional)
// 			    pagination:"local",
// 			    paginationSize:6,
 placeholder: "No Data Set",
//  ajaxURL:"getMilkHeaderData?selected_month=August-2017",
//  ajaxProgressiveLoad:"scroll",
			    movableColumns:true,
			    movableColumns:true,
			    groupBy:["farmerCode"],
			    groupHeader: [ function (value, count, data) {
		           
		            return value + "<span style='color:#d00; margin-left:10px;'>(" + count + " item)</span>";
		        }],

			    columns:[ //Define Table Columns
			        {title:"Farmer Code", field:"farmerCode", width:150},
			        {title:"Farmer Name", field:"farmerName", align:"left"},
			        {title:"P Code", field:"pCode"},
			        {title:"From Date", field:"dateFrom", align:"center"},
			        {title:"To Date", field:"dateTo", align:"center"},
			        {title:"Total Ltr", field:"totalLtr", align:"center"},
			        
			        {title:"Payment", field:"milkPayment", align:"center"},
			        {title:"Incentive", field:"incentive", align:"center"},
			        {title:"Deductions", field:"deductions", align:"center"},
			        {title:"Recoveries", field:"recoveries", align:"center"},
			        {title:"Net Payment To Bank", field:"netAmount", align:"center",  bottomCalc :"sum"}
			       
			        
			        
			        
			    ],
			    rowClick:function(e, row){ //trigger an alert message when the row is clicked
			        alert("Row " + row.getData().netAmount + " Clicked!!!!");
			    },
			    rowContext:function(e, row){
			        alert("Row " + row.getIndex() + " Context Clicked!!!!")
			    }
			});
			
			//define some sample data
			var tabledata = [
			    {id:1, name:"Oli Bob", age:"12", col:"red", dob:""},
			    {id:2, name:"Mary May", age:"1", col:"blue", dob:"14/05/1982"},
			    {id:3, name:"Christine Lobowski", age:"42", col:"green", dob:"22/05/1982"},
			    {id:4, name:"Brendon Philips", age:"125", col:"orange", dob:"01/08/1980"},
			    {id:5, name:"Margret Marmajuke", age:"16", col:"yellow", dob:"31/01/1999"},
			];
			
			$("#example-table").tabulator("setData", "getMilkHeaderData?selected_month=August-2017");
			
			$.ajax({
				type : "POST",
				url : "getMilkHeaderData?selected_month=August-2017",
				
				success : function(response) {
	

// 					$("#example-table").tabulator("setData", "getMilkHeaderData?selected_month=August-2017");


					
				},
				dataType : "html"
			});

			//load sample data into the table
			

			
		

	});
	</script> 


</html>







<%}%>