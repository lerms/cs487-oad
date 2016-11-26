var url = "${pageContext.request.contextPath}";

//TEST OBJECT
function testObject(){
	
	var testListings = 
		{ "categories":[
			{"name":"Restaurants",
			"subcategories":[
				{"name":"Pizza",
				"listings":[
					{"name":"Morton's",
					"image":"images/test_image.gif",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"http://www.mortons.com",
					"featureType":"category"
					},
					{"name":"Bubba's",
					"image":"images/test_image.gif",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"http://www.bubbas.com",
					"featureType":"regular"
					}]
				},
				{"name":"Burgers",
				"listings":[
					{"name":"Morton's",
					"image":"images/test_image.gif",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"http://www.mortons.com",
					"featureType":"category"
					}]
				}
			]}			
		]};
	
	return testListings;
}

//TEST OBJECT WITH FEATURED LISTINGS
function testObject2(){
		
	var testListings = 
		{"homeFeaturedListing": {
			"name":"Magic Pizza",
			"image":"images/test_image.gif",
			"address":"123 South Ave, Chicago IL",
			"phone":"(318) 265-1865",
			"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
			"category":"Restaurants",
			"website":"http://www.mortons.com"
		}, 
		"categories":[
			{"name":"Restaurants",
			"categoryFeaturedListing":{
				"name":"Joe's Grill",
				"image":"images/test_image.gif",
				"address":"123 South Ave, Chicago IL",
				"phone":"(318) 265-1865",
				"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
				"category":"Restaurants",
				"website":"http://www.mortons.com"
			},
			"subcategories":[
				{"name":"Pizza",
				"subcategoryFeaturedListing":
					{"name":"Flying Pizza Pie",
					"image":"images/test_image.gif",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"http://www.mortons.com"
					},
				"listings":[
					{"name":"Morton's",
					"image":"images/test_image.gif",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"http://www.mortons.com"
					},
					{"name":"Bubba's",
					"image":"images/test_image.gif",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"http://www.bubbas.com"
					}]
				},
				{"name":"Burgers",
				"subcategoryFeaturedListing":
					{"name":"Ray's Burgers",
					"image":"images/test_image.gif",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"http://www.mortons.com"
					},
				"listings":[
					{"name":"Morton's",
					"image":"images/test_image.gif",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"http://www.mortons.com"
					}]
				}
			]}			
		]};
	
	return testListings;
}

//DOM INJECTION
function createHTML(object){
	
	for (var i = 0; i < object.categories.length; i++){
		var category = createCategory(object.categories[i]);
		
		var category_subcategories = document.createElement("div");
		category_subcategories.className = "category_subcategories";
		
		for (var j = 0; j < object.categories[i].subcategories.length; j++){
			var subcategory = document.createElement("div");
			subcategory.className = "subcategory";
			
			var subcategory_wrapper = document.createElement("div");
			subcategory_wrapper.className = "subcategory_wrapper";
			var subcategory_name = document.createElement("div");
			subcategory_name.className = "subcategory_name";
			subcategory_name.innerHTML = object.categories[i].subcategories[j].name;
			subcategory_wrapper.appendChild(subcategory_name);
			var subcat_button = document.createElement("img");
			subcat_button.className = "subcategory_show_button";
			subcat_button.src="images/plus_button.png";
			subcategory_wrapper.appendChild(subcat_button);
			subcategory.appendChild(subcategory_wrapper);
			
			var listings = document.createElement("div");
			listings.className = "listings";
						
			var count = 0;
			for (var k = 0; k < object.categories[i].subcategories[j].listings.length; k++){
				count++
				var listing = createListing(object.categories[i].subcategories[j].listings[k]);
				listings.appendChild(listing);
			}			
			
			var listing_count = document.createElement("div");
			listing_count.className = "listing_count";
			listing_count.innerHTML = "(" + count + ")";
			
			subcategory_name.appendChild(listing_count);

			subcategory.appendChild(listings);			
			category_subcategories.appendChild(subcategory);
		}
		
		category.appendChild(category_subcategories);
		document.getElementById("categories").appendChild(category);
	}
}

//DOM INJECTION WITH FEATURED ITEM INJECTION
function createHTML2(object){
	
	var homeFeaturedListing = createFeaturedListing(object.homeFeaturedListing);
	document.getElementById("home_featured_listing").appendChild(homeFeaturedListing);	
	
	for (var i = 0; i < object.categories.length; i++){
		var category = createCategory(object.categories[i]);
		var categoryFeaturedListing = createFeaturedListing(object.categories[i].categoryFeaturedListing);
		categoryFeaturedListing.className = "category_featured_listing";
		var leftCategoryFeaturedListing = createFeaturedListing(object.categories[i].categoryFeaturedListing);
		leftCategoryFeaturedListing.className = "left_category_featured_listing";
		
		var left_category = document.createElement("div");
		left_category.className = "left_category";
		left_category.innerHTML = "Featured " + object.categories[i].name;
		document.getElementById("featured_list").appendChild(left_category);
		document.getElementById("featured_list").appendChild(leftCategoryFeaturedListing);
		
		var category_subcategories = document.createElement("div");
		category_subcategories.className = "category_subcategories";
		category_subcategories.appendChild(categoryFeaturedListing);
		for (var j = 0; j < object.categories[i].subcategories.length; j++){
			var subcategory = document.createElement("div");
			subcategory.className = "subcategory";			
			var subcategory_wrapper = document.createElement("div");
			subcategory_wrapper.className = "subcategory_wrapper";
			var subcategory_name = document.createElement("div");
			subcategory_name.className = "subcategory_name";
			subcategory_name.innerHTML = object.categories[i].subcategories[j].name;
			subcategory_wrapper.appendChild(subcategory_name);
			var subcat_button = document.createElement("img");
			subcat_button.className = "subcategory_show_button";
			subcat_button.src="images/plus_button.png";
			subcategory_wrapper.appendChild(subcat_button);
			subcategory.appendChild(subcategory_wrapper);
			
			var listings = document.createElement("div");
			listings.className = "listings";
			
			var subcategory_featured_listing = createFeaturedListing(object.categories[i].subcategories[j].subcategoryFeaturedListing);
			subcategory_featured_listing.className = "subcategory_featured_listing";
			listings.appendChild(subcategory_featured_listing);
			
			var count = 1;
			for (var k = 0; k < object.categories[i].subcategories[j].listings.length; k++){
				count++
				var listing = createListing(object.categories[i].subcategories[j].listings[k]);
				listings.appendChild(listing);
			}			
			
			var listing_count = document.createElement("div");
			listing_count.className = "listing_count";
			listing_count.innerHTML = "(" + count + ")";
			
			subcategory_name.appendChild(listing_count);

			subcategory.appendChild(listings);			
			category_subcategories.appendChild(subcategory);
		}
		
		category.appendChild(category_subcategories);
		document.getElementById("categories").appendChild(category);
	}
}

//CREATE CATEGORY
function createCategory(object){
	var category = document.createElement("div");
	category.className = "category";
	
	var category_wrapper = document.createElement("div");
	category_wrapper.className = "category_wrapper";
	var category_name = document.createElement("div");
	category_name.className = "category_name";
	category_name.innerHTML = object.name;
	category_wrapper.appendChild(category_name);
	var cat_button = document.createElement("img");
	cat_button.className = "category_show_button";
	cat_button.src="images/plus_button.png";
	category_wrapper.appendChild(cat_button);
	category.appendChild(category_wrapper);
	
	return category;
}

//CREATE LISTING
function createListing(object){
	var listing = document.createElement("div");
	listing.className = "listing";
	
	var listing_top_wrapper = document.createElement("div");
	listing_top_wrapper.className = "listing_top_wrapper";
	var image_cropper = document.createElement("div");
	image_cropper.className = "image_cropper";
	var listing_image = document.createElement("img");
	listing_image.className = "listing_image";
	listing_image.src = object.image;
	image_cropper.appendChild(listing_image);
	listing_top_wrapper.appendChild(image_cropper);
	var listing_name_wrapper = document.createElement("div");
	listing_name_wrapper.className = "listing_name_wrapper";
	var listing_name = document.createElement("div");
	listing_name.className = "listing_name";
	listing_name.innerHTML = object.name;
	listing_name_wrapper.appendChild(listing_name);
	var listing_rule = document.createElement("hr");
	listing_rule.className = "listing_rule";
	listing_name_wrapper.appendChild(listing_rule);
	var listing_address = document.createElement("div");
	listing_address.className = "listing_address";
	listing_address.innerHTML = object.address;
	listing_name_wrapper.appendChild(listing_address);
	var listing_phone = document.createElement("div");
	listing_phone.className = "listing_phone";
	listing_phone.innerHTML = object.phone;
	listing_name_wrapper.appendChild(listing_phone);
	listing_top_wrapper.appendChild(listing_name_wrapper);
	var listing_button = document.createElement("img");
	listing_button.className = "listing_show_button";
	listing_button.src = "images/plus_button.png";
	listing_top_wrapper.appendChild(listing_button);
	listing.appendChild(listing_top_wrapper);
	
	var listing_bottom_wrapper = document.createElement("div");
	listing_bottom_wrapper.className = "listing_bottom_wrapper";
	var listing_description = document.createElement("div");
	listing_description.className = "listing_description";
	listing_description.innerHTML = object.description;
	listing_bottom_wrapper.appendChild(listing_description);
	var listing_links = document.createElement("div");
	listing_links.className = "listing_links";
	var listing_map = document.createElement("a");
	listing_map.className = "listing_map";
	listing_map.innerHTML = "MAP";
	listing_map.href = "https://maps.google.com/?q=" + object.address;
	listing_links.appendChild(listing_map);
	var listing_website = document.createElement("a");
	listing_website.className = "listing_website";
	listing_website.innerHTML = "WEBSITE";
	listing_website.href = object.website;
	listing_links.appendChild(listing_website);
	listing_bottom_wrapper.appendChild(listing_links);
	listing.appendChild(listing_bottom_wrapper);
	
	return listing;
}

//CREATE FEATURED LISTING
function createFeaturedListing(object){
	var listing = document.createElement("div");
	listing.className = "listing";
	
	var listing_top_wrapper = document.createElement("div");
	listing_top_wrapper.className = "listing_top_wrapper";
	var image_cropper = document.createElement("div");
	image_cropper.className = "image_cropper";
	var listing_image = document.createElement("img");
	listing_image.className = "listing_image";
	listing_image.src = object.image;
	image_cropper.appendChild(listing_image);
	listing_top_wrapper.appendChild(image_cropper);
	var listing_name_wrapper = document.createElement("div");
	listing_name_wrapper.className = "listing_name_wrapper";
	var listing_name = document.createElement("div");
	listing_name.className = "listing_name";
	listing_name.innerHTML = object.name;
	listing_name_wrapper.appendChild(listing_name);
	var listing_rule = document.createElement("hr");
	listing_rule.className = "listing_rule";
	listing_name_wrapper.appendChild(listing_rule);
	var listing_address = document.createElement("div");
	listing_address.className = "listing_address";
	listing_address.innerHTML = object.address;
	listing_name_wrapper.appendChild(listing_address);
	var listing_phone = document.createElement("div");
	listing_phone.className = "listing_phone";
	listing_phone.innerHTML = object.phone;
	listing_name_wrapper.appendChild(listing_phone);
	listing_top_wrapper.appendChild(listing_name_wrapper);
	var featured_banner = document.createElement("img");
	featured_banner.className = "featured_banner";
	featured_banner.src="images/featured_banner.png";
	listing_top_wrapper.appendChild(featured_banner);
	var listing_button = document.createElement("img");
	listing_button.className = "listing_show_button";
	listing_button.src = "images/plus_button.png";
	listing_top_wrapper.appendChild(listing_button);
	listing.appendChild(listing_top_wrapper);
	
	var listing_bottom_wrapper = document.createElement("div");
	listing_bottom_wrapper.className = "listing_bottom_wrapper";
	var listing_description = document.createElement("div");
	listing_description.className = "listing_description";
	listing_description.innerHTML = object.description;
	listing_bottom_wrapper.appendChild(listing_description);
	var listing_links = document.createElement("div");
	listing_links.className = "listing_links";
	var listing_map = document.createElement("a");
	listing_map.className = "listing_map";
	listing_map.innerHTML = "MAP";
	listing_map.href = "https://maps.google.com/?q=" + object.address;
	listing_links.appendChild(listing_map);
	var listing_website = document.createElement("a");
	listing_website.className = "listing_website";
	listing_website.innerHTML = "WEBSITE";
	listing_website.href = object.website;
	listing_links.appendChild(listing_website);
	listing_bottom_wrapper.appendChild(listing_links);
	listing.appendChild(listing_bottom_wrapper);
	
	return listing;
}

$(document).ready(function(){
	$.get(url+"/listing", function(data, status){
        createHTML(data);
		//console.log(JSON.stringify(data));
    });
});

//window.onload = createHTML2(testObject2());