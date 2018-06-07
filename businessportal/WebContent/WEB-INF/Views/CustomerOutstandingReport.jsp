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

<title>Account Receivable Report</title>

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
<link href="resources/jqwidgets/styles/jqx.bootstrap.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-start.css" rel="stylesheet">
<link href="resources/jqwidgets/styles/jqx.ui-redmond.css" rel="stylesheet">

<!-- <script src="assets/js/chart-master/Chart.js"></script> -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
 <style type="text/css">
 #customerCode,#customerName,#outstandingAmount{
 
 background: #252422 ! important;
    color: antiquewhite ! important;
 
 }
	
</style>
	<%
		Integer userId = (Integer) session.getAttribute("userId");
	
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
			
					<div class="row mt mb">

					
						
							<div class="col-lg-2 col-md-1 col-sm-6" >Customer Code</div>
						<div class="col-lg-2 col-md-2 col-sm-6" style="padding: 1px !important;" >
							
								<input type="text" id="customerCode"   />
						</div>
						
							<div class="col-lg-2 col-md-1 col-sm-6"  >Customer Name</div>
						<div class="col-lg-2 col-md-2 col-sm-6" style="padding: 1px !important;" >
							
								<input type="text" id="customerName"  />
						</div>
				
		<div class="col-lg-2 col-md-1 col-sm-6" >Outstanding Amount</div>
						<div class="col-lg-2 col-md-2 col-sm-6" style="padding-left: 3px;" >
							
								<input type="text" id="outstandingAmount" />
						</div>
													
					</div>
				 <div class="row mb">												
						<div class="col-lg-2 col-md-1 col-sm-6" >From Date</div>
						<div class="col-lg-2 col-md-2 col-sm-6" style="padding: 1px !important;" >
							<div id="from_out_report_date"></div>
						</div>
						
						<div class="col-lg-2 col-md-1 col-sm-6" >To Date</div>
						<div class="col-lg-2 col-md-2 col-sm-6" style="padding: 1px !important;" >
							<div id="to_out_report_date"></div>
						</div>
						
						<div class="col-lg-2 col-md-2 col-sm-6" >
							<button id="getBtn" class="btn btn-success btn-sm">Get</button>
						</div>						
					</div> 
		
				<div id="customerOustandingReportGrid"></div>
				
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
	<script src="resources/js/custom/CustomerOutstandingReport.js"></script>
	<script src="resources/js/jquery-confirm.min.js"></script>

	
</body>

	
			<script type="text/javascript">
			

		$(document).ready(function(e) {
			
			var source_customer_data = {
					datatype:'json',
					url:'getCustomerData',
					datafields:[{name:'customerName',type:'string'},{name:'customerName2',type:'string'},{name:'address',type:'string'},
					            {name:'city',type:'string'},{name:'pincode',type:'string'},{name:'phoneNo',type:'string'},
					            {name:'region',type:'string'},{name:'country',type:'string'},{name:'customerCode',type:'string'}],
					async:false
			}
			var dataAdapter_customer_data = new $.jqx.dataAdapter(source_customer_data,{autoBind:true,loadComplete:function(data){
				if(data.address!="E"){
					$('#customerName').val(data.customerName);
					$('#customerCode').val(data.customerCode);
						
									
				}else{
					
				}
			}});
			
			
			
			
			
			var out_report_date = $('#from_out_report_date').val();
			var selected_to_date = $('#to_out_report_date').val();
			var itemType="INT";
			
				var fields= new Array();

				fields.push({name:'customerCode',type:'string'},{name:'docNo',type:'string'},{name:'fiYear',type:'string'},
							{name:'docTypeName',type:'string'},{name:'docDate',type: 'date', format: 'dd/mm/yyyy'},{name:'postingDate',type: 'date', format: 'dd.MM.yyyy'},{name:'amount',type:'string'},{name:'debitAmount',type:'string'},{name:'creditAmount',type:'string'},{name:'db_ind',type:'string'}
							,{name:'0_15',type:'string'},{name:'15_30',type:'string'},{name:'30_45',type:'string'},{name:'customerName',type:'string'});

				var source_inventory = {
					datatype:'json',
					datafields:fields,
					url:'getCustomerOutstandingReport?selected_date='+out_report_date+'&selected_to_date='+selected_to_date+'&itemType='+itemType,
					async:false
				}
				var dataAdapter_inventory = new $.jqx.dataAdapter(source_inventory);
				$('#customerOustandingReportGrid').jqxGrid({source:dataAdapter_inventory});
			
			$.ajax({
				type : "GET",
					url : "getCustomerOutstandingAmount",
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