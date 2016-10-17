// JavaScript Document

$(document).ready(function(){
	var find_wrapper_toggle = 1;
	$("#find_near_me").click(function(){
		if(find_wrapper_toggle){
			$("#find_wrapper").show();
			find_wrapper_toggle = 0;
		} else {
			$("#find_wrapper").hide();
			find_wrapper_toggle = 1;
		}
	});
});

$(document).ready(function(){
	var subcategory_toggle = 1;
	$(".category").click(function(){
		if(subcategory_toggle){
			$(".subcategory").show();
			subcategory_toggle = 0;
		} else {
			$(".subcategory").hide();
			subcategory_toggle = 1;
		}
	});
});

$(document).ready(function(){
	var listing_toggle = 1;
	$(".subcategory").click(function(){
		if(listing_toggle){
			$(".listing").show();
			listing_toggle = 0;
		} else {
			$(".listing").hide();
			listing_toggle = 1;
		}
	});
});