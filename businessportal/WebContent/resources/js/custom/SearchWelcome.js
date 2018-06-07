$(window).load(function() {
	$(".loader").fadeOut("slow");
});

$(document).ready(function(e) {
	var theme = 'ui-start';
	$('#Welcome').addClass("active");
	//	$("#breadcrumb-ol").append("<li class='breadcrumb-item'><a href='#'>Home</a></li>");

	var d = new Date();
	var curYear = d.getFullYear();
	var curMonth = d.getMonth();


	$('#searchUserCode').jqxInput({width:'100%',theme:theme,height:25});


	var source_countries = {
		datatype : 'json',
		datafields : [ {
			name : 'roleId',
			type : 'string'
		}, {
			name : 'roleName',
			type : 'string'
		} ],
		async : false,
		url : "getRoleList"
	}
	var dataAdapter_countries = new $.jqx.dataAdapter(source_countries);
	
	
	
	$('#getBtn').on("click",function(e){
		alert("dsds");
		var dataString = 'roleId=19';
		
		$.ajax({
			type : "POST",
			url : "getMenuList",
			data : dataString,
			success : function(response) {
										alert("resp.."+response);
										var output = "";	
				var json_obj = $.parseJSON(response);

				$.each(json_obj, function(index, items) {
					//alert("i.."+index);
						//alert("items.."+items)
					$.each(items, function(index, item) {
						output += "<li class='mt' style='display: none'><a id='#' href='#' title=''> <i class='fa fa-chevron-circle-right' style='color: #fae700;' ></i> <span>"+ item.menuName + "</span></a></li>" ;
						

						
					})
				})
console.log(output);
				$("ul.sidebar-menu").append(output);
			},
			dataType : "html"
		});
		
	});


//	
//	  $("ul.sidebar-menu li").click(function(e) 
//			   { 
//			   alert(this);
//			    
//			   $( this ).( "li" ).each( function( index, element ){
//			        console.log( $( this ).text() );
//			        alert($( this ).text());
//			    });
//			   });



//	$('#roleList').on('change', function() {
//		var roleList = $('#roleList').val();
//
//
//		var dataString = 'roleId=' + roleList;
//
//
//
//		$.ajax({
//			type : "POST",
//			url : "getMenuList",
//			data : dataString,
//			success : function(response) {
//
//				var json_obj = $.parseJSON(response);
//
//				//    alert("json_obj.."+json_obj[0].menuName);
//
//				var output = "";	
//				//              $("ul.sidebar-menu").append(output);
//
//
//				$("#tabMenu").css("display", "none");
//
//				$("#breadcrumb-ol").css("display", "none");
//
//				$('ul.sidebar-menu').empty();
//				//
//				for (i = 0; i < json_obj.length; i++) {
//
//					if (i == 0 && json_obj[i].menuId == 101) {
//						output += "<li class='mt' style='display: block'>  <a id='landOwner' onclick='enableScreen();' href='#'><span>" + json_obj[i].menuName + "</span></a></li>";
//					} else {
//
//						output += "<li class='mt' style='display: block'>  <a id='#' onclick='disableScreen();' href='#'><span>" + json_obj[i].menuName + "</span></a></li>";
//					}
//					//            	  alert("json_obj.."+json_obj[i].menuName);
//
//
//				}
//				//
//				//              output += "</ul>";
//
//
//
//				//              alert("vcxvxcv.."+output);
//				$("ul.sidebar-menu").append(output);
//
//				//              $("#sidebar ul li:last").append(output);
//
//				//              $("#sidebar ul").append(output);
//				//              $('#sidebar ul').html(output);
//
//			},
//			dataType : "html"
//		});
//
//
//
//	});


});