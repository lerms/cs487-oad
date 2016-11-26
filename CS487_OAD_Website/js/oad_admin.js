var url = "";
//var url = "50.179.64.156:8090";

//TEST LISTING OBJECT
function testListingObject(){
	var testObject = { 
	"name" : "Morton's",
	"image" : "images/test_image.gif",
	"address" : "123 South Ave, Chicago IL",
	"city" : "Chicago",
	"area" : "Bronzeville",
	"phone" : "(318) 265-1865",
	"description" : "Casual fare restaurant with best pizza in town.",
	"website" : "http://www.mortons.com",
	"featureType" : "category",
	"category" : "Restaurants",
	"subcategories" : [ "Pizza", "Burgers" ]
	}
	
	return testObject;
}

//TEST CATEGORY OBJECT
function testCategoryObject(){
	var testObject = {
	"name" : "Restaurant",
	"subcategories" : ["Pizza", "Burger", "Italian"]
	}
	
	return testObject;
}

//TEST CATEGORY ARRAY
function testCategoryArray(){
	var categoryArray = {
		"categories" : [
		{"name" : "Restaurant",
		"subcategories" : ["Pizza", "Burgers", "Wings"]
		},
		{"name" : "Entertainment",
		"subcategories" : ["Movies", "Bowling"]
		},
		{"name" : "Transportation",
		"subcategories" : ["Busses", "Taxis"]
		}, 
		{"name" : "Education",
		"subcategories" : ["Schools","Daycares"]
		}]
	}
	
	return categoryArray;
}


//TEST ADVERTISER OBJECT
function testAdvertisersObject(){
	var advertisers	= 
	[{	"name" : "Morton's",
		"email" : "example@example.com",
		"phone" : "18005555555",
		"website" : "example.com"		
	},
	{	"name" : "Bob's",
		"email" : "example@example.com",
		"phone" : "18005555555",
		"website" : "example.com"
	},
	{	"name" : "Yen's",
		"email" : "example@example.com",
		"phone" : "18005555555",
		"website" : "example.com"
	}
	];
	
	return advertisers;
}

//CREATE LISTING OBJECT
function createListingObject(name, advertiser, image, address, city, area, phone, description, website, startDate, endDate, featureType, category, subcategories){
	var listingObject = {
	"name" : name,
	"advertiser" : advertiser,
	"image" : image,
	"address" : address,
	"city" : city,
	"area" : area,
	"phone" : phone,
	"description" : description,
	"website" : website,
	"startDate" : startDate,
	"endDate" : endDate,
	"featureType" : featureType,
	"category" : category,
	"subcategories" : subcategories
	}
	
	return listingObject;
}

//CREATE CATEGORY OBJECT
function createCategoryObject(name, subcats){
	var categoryObject = {
	"name" : name,
	"subcategories" : subcats,	
	}
	
	return categoryObject;
}

//CREATE ADVERTISER OBJECT
function createAdvertiserObject(name, phone, website, email){
	var advertiserObject = {
		"name" : name,
		"phone" : phone,
		"website" : website,
		"email" : email	
	}
	
	return advertiserObject;
}

//CREATE ADVERTISER SUBMIT
function createAdvertiserSubmit(){
	var name = document.getElementById("business_name_input").value;
	var phone = document.getElementById("business_phone_input").value;
	var website = document.getElementById("business_website_input").value;
	var email = document.getElementById("business_email_input").value;
	
	var advertiserObject = createAdvertiserObject(name, phone, website, email);
	
	$.ajax({
    	type: "PUT",
    	url: url + "/admin/advertiser",
		beforeSend: function(xhr){
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
    	//contentType: "application/json",
    	data: JSON.stringify(advertiserObject),
		success: function(response){
			console.log(response);	
		}
	});
}

var subcategories = [];
//ADD SUBCATEGORY
function addSubcategory(){
	var subcategory = document.getElementById("subcategory_name_input").value;
	subcategories.push(subcategory);
	document.getElementById("subcategories").innerHTML = "Subcategories: " + subcategories;
}
//CREATE CATEGORY SUBMIT
function createCategorySubmit(){
	var name = document.getElementById("category_name_input").value;
	var categoryObject = createCategoryObject(name, subcategories);
	
	$.ajax({
    	type: "PUT",
    	url: url + "/admin/category",
		beforeSend: function(xhr){
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
    	//contentType: "application/json",
    	data: JSON.stringify(categoryObject),
		success: function(response){
			console.log(response);	
		}
	});
	
	subcategories = [];
}

//CREATE LISTING SUBMIT
function createListingSubmit(){
	var name = document.getElementById("listing_name").value;
	var advertiser = document.getElementById("listing_advertiser").value;
	var image = document.getElementById("listing_image").value;
	var address = document.getElementById("listing_address").value;
	var city = document.getElementById("listing_city").value;
	var area = document.getElementById("listing_area").value;
	var phone = document.getElementById("listing_phone").value;
	var description = document.getElementById("listing_description").value;
	var website = document.getElementById("listing_website").value;
	var startDate = document.getElementById("listing_start_date").value;
	var endDate = document.getElementById("listing_end_date").value;
	var featureType = $("input[name='featured_type']:checked").val();
	var category = $("input[name='listing_category']:checked").val();
	var subcategories = [];
	$("input:checkbox[name='listing_subcategory']:checked").each(function(){
		subcategories.push($(this).val());
	});
	
	console.log(startDate);
	var listingObject = createListingObject(name, advertiser, image, address, city, area, phone, description, website, startDate, endDate, featureType, category, subcategories);
	
	$.ajax({
    	type: "PUT",
    	url: url + "/listing",
		beforeSend: function(xhr){
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
    	//contentType: "application/json",
    	data: JSON.stringify(listingObject),
		success: function(response){
			console.log(response);	
		}
	});
}

//CHANGE PASSWORD SUBMIT
function changePasswordSubmit(){
	
}


//POPULATE LISTING CATEGORY LIST
function populateListingCategories(categoryArray){
	var catDiv = document.getElementById("listing_category_list");
	
	
	for (var i = 0; i < categoryArray.categories.length; i++){
		var label = document.createElement("label");
		var radio = document.createElement("input");
		radio.type = "radio";
		radio.name = "listing_category";
		radio.onclick = function(){populateListingSubcategories()};
		radio.value = i;
		radio.required = true;
		label.innerHTML = categoryArray.categories[i].name;
		catDiv.appendChild(radio);
		catDiv.appendChild(label);
		catDiv.appendChild(document.createElement("br"));
	}
}

//POPULATE LISTING SUBCATEGORY LIST
function populateListingSubcategories(){
	var selection = $("input[name='listing_category']:checked").val();
	var subcatDiv = document.getElementById("listing_subcategory_list");
	$(subcatDiv).empty();
	
	for (var i = 0; i < categoryArray.categories[selection].subcategories.length; i++){
		var label = document.createElement("label");
		var checkbox = document.createElement("input");
		checkbox.type = "checkbox";
		checkbox.name = "listing_subcategory";
		checkbox.value = categoryArray.categories[selection].subcategories[i];
		checkbox.required = true;
		label.innerHTML = categoryArray.categories[selection].subcategories[i];
		subcatDiv.appendChild(checkbox);
		subcatDiv.appendChild(label);
		subcatDiv.appendChild(document.createElement("br"));
	}
}

//POPULATE LISTING ADVERTISERS
function populateListingAdvertisers(advertisers){
	var advertiserDropdown = document.getElementById("listing_advertiser");
	for (var i = 0; i < advertisers.length; i++){
		var option = document.createElement("option");
		option.value = advertisers[i].name;
		option.textContent = advertisers[i].name;	
		advertiserDropdown.appendChild(option);
	}
}

//ON LOAD
function onLoad(){
	$(function() {
		$( "#admin_functions" ).tabs(); 
	});
	$(function() {
		$( "#advertisers" ).tabs(); 
	});
	$(function() {
		$( "#listings" ).tabs(); 
	});
	$(function() {
		$( "#account" ).tabs(); 
	});
	
	//categoryArray = testCategoryArray();
	$.get(url+"/admin/category", function(data, status){
        if (data != []){
			populateListingCategories(data);
		}
    });
	
	
	//advertisers = testAdvertisersObject();
	$.get(url+"/admin/advertiser", function(data, status){
        if (data != []){
			populateListingAdvertisers(data);
		}
    });
	

	document.getElementById("admin_wrapper").style.display="block";
}


//AJAX PUT DEFINITION


window.onload = onLoad();