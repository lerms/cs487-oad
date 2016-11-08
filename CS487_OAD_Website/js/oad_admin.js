

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
	var advertisers	= {
			
	}
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
	
	console.log(JSON.stringify(advertiserObject));
	
	$.ajax({
    	type: "PUT",
    	url:"http://localhost:8090/admin/advertiser",
    	contentType: "application/json",
    	data: JSON.stringify(advertiserObject)
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
    	url:"http://localhost:8090/admin/categories",
    	contentType: "application/json",
    	data: JSON.stringify(categoryObject)
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
	var startDate = document.getElementById("listing_start_date");
	var endDate = document.getElementById("listing_end_date");
	var featureType = $("input[name='featured_type']:checked").val();
	var category = $("input[name='listing_category']:checked").val();
	var subcategories = [];
	$("input:checkbox[name='listing_subcategory']:checked").each(function(){
		subcategories.push($(this).val());
	});
	
	var listingObject = createListingObject(name, advertiser, image, address, city, area, phone, description, website, startDate, endDate, featureType, category, subcategories);
	
	$.ajax({
    	type: "PUT",
    	url:"http://localhost:8090/listings",
    	contentType: "application/json",
    	data: JSON.stringify(listingObject)
	});
}

//CHANGE PASSWORD SUBMIT
function changePasswordSubmit(){
	
}

var categoryArray;

//POPULATE LISTING CATEGORY LIST
function populateListingCategories(){
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
	
	categoryArray = testCategoryArray();
	populateListingCategories();
	
	//TEST CODE, REMOVE FOR FINAL
	$.get("http://localhost:8090/admin/advertisers", function(data, status){
        //createHTML(data);
		console.log(JSON.stringify(data));
    });

	document.getElementById("admin_wrapper").style.display="block";
}


//AJAX PUT DEFINITION


window.onload = onLoad();