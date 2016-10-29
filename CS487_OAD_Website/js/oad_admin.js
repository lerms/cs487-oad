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

//CREATE LISTING OBJECT
function createListingObject(name, image, address, city, area, phone, description, website, featureType, category, subcategories){
	var listingObject = {
	"name" : name,
	"image" : image,
	"address" : address,
	"city" : city,
	"area" : area,
	"phone" : phone,
	"description" : description,
	"website" : website,
	"featureType" : featureType,
	"category" : category,
	"subcategories" : subcategories
	}
	
	return listingObject;
}

//CREATE CATEGORY OBJECT
function createCategoryObject(name, subcategories){
	var categoryObject = {
	"name" : name,
	"subcategories" : subcategories,	
	}
	
	return categoryObject;
}

//AJAX PUT DEFINITION
$.put = function(url, data, callback, type){
	if ($.isFunction(data)){
		type = type || callback,
		callback = data,
		data = {}	
	}
	
	return $.ajax({
		url: url,
		type: 'PUT',
		success: callback,
		data: data,
		contentType: type
	});
}