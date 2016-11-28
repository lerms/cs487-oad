// JavaScript Document

/*
//FIND TOGGLE
$(document).ready(function(){
	var find_wrapper_toggle = 1;
	$("#arrow").click(function(){
		if($("#find_wrapper").css("display") === ("none")){
			$("#find_wrapper").show();
			$(this).attr("src", "images/up_button.png");
			find_wrapper_toggle = 0;
		} else {
			$("#find_wrapper").hide();
			$(this).attr("src", "images/down_button.png");
			find_wrapper_toggle = 1;
		}
	});
});

//SUBCATEGORY TOGGLE
$(document).ready(function(){
	$(".category_show_button").click(function(){
		if($(this).parent().next(".category_subcategories").css("display") === ("none")){
			$(this).parent().next(".category_subcategories").show();
			$(this).attr("src", "images/minus_button.png");
		} else {
			$(this).parent().next(".category_subcategories").hide();
			$(this).attr("src", "images/plus_button.png");
		}
	});
});

//LISTING TOGGLE
$(document).ready(function(){
	$(".subcategory_show_button").click(function(){
		if($(this).parent().next(".listings").css("display") === ("none")){
			$(this).parent().next(".listings").show();
			$(this).attr("src", "images/minus_button.png");
		} else {
			$(this).parent().next(".listings").hide();
			$(this).attr("src", "images/plus_button.png");
		}
	});
});

//LISTING DESCRIPTION TOGGLE
$(document).ready(function(){
	$(".listing_show_button").click(function(){
		if($(this).parent().next(".listing_bottom_wrapper").css("display") === ("none")){
			$(this).parent().next(".listing_bottom_wrapper").show();
			$(this).attr("src", "images/minus_button.png");
		} else {
			$(this).parent().next(".listing_bottom_wrapper").hide();
			$(this).attr("src", "images/plus_button.png");
		}
	});
});*/

function listeners(){
//FIND TOGGLE
//$(window).on('load',function(){
	var find_wrapper_toggle = 1;
	$("#arrow").click(function(){
		if($("#find_wrapper").css("display") === ("none")){
			$("#find_wrapper").show();
			$(this).attr("src", "images/up_button.png");
			find_wrapper_toggle = 0;
		} else {
			$("#find_wrapper").hide();
			$(this).attr("src", "images/down_button.png");
			find_wrapper_toggle = 1;
		}
	});
//});

//SUBCATEGORY TOGGLE
//$(window).on('load',function(){
	$(".category_show_button").click(function(){
		if($(this).parent().next(".category_subcategories").css("display") === ("none")){
			$(this).parent().next(".category_subcategories").show();
			$(this).attr("src", "images/minus_button.png");
		} else {
			$(this).parent().next(".category_subcategories").hide();
			$(this).attr("src", "images/plus_button.png");
		}
	});
//});

//LISTING TOGGLE
//$(window).on('load',function(){
	$(".subcategory_show_button").click(function(){
		if($(this).parent().next(".listings").css("display") === ("none")){
			$(this).parent().next(".listings").show();
			$(this).attr("src", "images/minus_button.png");
		} else {
			$(this).parent().next(".listings").hide();
			$(this).attr("src", "images/plus_button.png");
		}
	});
//});

//LISTING DESCRIPTION TOGGLE
//$(window).on('load',function(){
	$(".listing_show_button").click(function(){
		if($(this).parent().next(".listing_bottom_wrapper").css("display") === ("none")){
			$(this).parent().next(".listing_bottom_wrapper").show();
			$(this).attr("src", "images/minus_button.png");
		} else {
			$(this).parent().next(".listing_bottom_wrapper").hide();
			$(this).attr("src", "images/plus_button.png");
		}
	});
//});
}