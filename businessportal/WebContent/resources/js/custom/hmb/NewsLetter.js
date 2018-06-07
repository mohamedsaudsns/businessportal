$(window).load(function() {
    $(".loader").fadeOut("slow");
});
$(document).ready(function(e){
	var theme = 'ui-start';
	var popup_theme = 'ui-redmond';
	
	$('#NewsLetter').addClass("active");
	$("#breadcrumb-ol").append("<li style='font-size: 14px;'><a href='#'><span class='fa fa-chevron-circle-right' id='header_span_icon'></span> News Letter</a></li>");
//	$("#breadcrumb-ol").append("<li class='breadcrumb-item active style=font-size: 16px;'><a href='#'>New Scheme Launch</a></li>");
	
	
//	$('#newsLetterLanguage').jqxDropDownList({
//		width : '100%',
//		theme : theme,
//		selectedIndex : '-1',
//		height : 25
//	});



//	var source_countries = {
//		datatype : 'json',
//		datafields : [ {
//			name : 'languageId',
//			type : 'string'
//		}, {
//			name : 'languageName',
//			type : 'string'
//		} ],
//		async : false,
//		url : "getNewsLetterLanguageList"
//	}
//	var dataAdapter_countries = new $.jqx.dataAdapter(source_countries);
//	$('#newsLetterLanguage').jqxDropDownList({
//		width : '100%',
//		theme : theme,
//		selectedIndex : '-1',
//		height : 25,
//		source : dataAdapter_countries,
//		valueMember : 'languageId',
//		displayMember : 'languageName'
//	});
	


	
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