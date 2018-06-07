$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#NewProductLaunch').addClass("active");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>New Product Launch</a></li>");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> New Product Launch</a></li>");
	
	
	$('#btnAdd').click(function (e) {
	  	var nextTab = $('#myTab li').size()+1;		
		
	  	// create the tab
//	  	$('<li><a href="#tab'+nextTab+'" data-toggle="tab">Tab '+nextTab+'</a></li>').appendTo('#tabs');
	  	
	  	$('<li><a href="" data-toggle="tab"> '+nextTab+' </a></li>').appendTo('#myTab');
	  	
	  	// create the tab content
	  	$('<div class="tab-pane" id="tab'+nextTab+'" class="tab-pane fade">tab' +nextTab+' content</div>').appendTo('.tab-content');
	  	
	  	// make the new tab active
	  	$('#myTab a:last').tab('show');
	});

	
	var slider = $('.bxslider').bxSlider({
		 mode: 'horizontal',
		  useCSS: false,
		  infiniteLoop: false,
		  hideControlOnEnd: true,
		  easing: 'easeOutElastic',
		  speed: 2000,
		  captions: true
		});
	 
	

});