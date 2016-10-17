function testObject(){
	
	var testListings = 
		{ "categories":[
			{"name":"Restaurants",
			"subcategories":[
				{"name":"Pizza",
				"listings":[
					{"name":"Morton's",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"mortons.com",
					"featureType":"category"
					},
					{"name":"Bubba's",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"bubbas.com",
					"featureType":"regular"
					}]
				},
				{"name":"Burgers",
				"listings":[
					{"name":"Morton's",
					"address":"123 South Ave, Chicago IL",
					"phone":"(318) 265-1865",
					"description":"Casual fare restaurant with best pizza in town. Specials every day of the week. Like us on Facebook for daily new specials. Open every day 9 - 11pm",
					"category":"Restaurants",
					"website":"mortons.com",
					"featureType":"category"
					}]
				}
			]}
		]};
	
	return testListings;
}

function createHTML(object){
	
	for (var i = 0; i < object.categories.length; i++){
		var category = document.createElement("div");
		category.className = "category";
		var category_name = document.createElement("div");
		category_name.className = "category_name";
		category_name.innerHTML = object.categories[i].name;
		category.appendChild(category_name);
		var category_subcategories = document.createElement("div");
		category_subcategories.className = "category_subcategories";
		
		for (var j = 0; j < object.categories[i].subcategories.length; j++){
			var subcategory = document.createElement("div");
			subcategory.className = "subcategory";
			var subcategory_name = document.createElement("div");
			subcategory_name.className = "subcategory_name";
			subcategory_name.innerHTML = object.categories[i].subcategories[j].name;

			var listings = document.createElement("div");
			listings.className = "listings";
			
			var count = 0;
			for (var k = 0; k < object.categories[i].subcategories[j].listings.length; k++){
				count++
				var listing = document.createElement("div");
				listing.className = "listing";
				var listing_name = document.createElement("div");
				listing_name.className = "listing_name";
				listing_name.innerHTML = object.categories[i].subcategories[j].listings[k].name;
				listing.appendChild(listing_name);
				var listing_rule = document.createElement("hr");
				listing_rule.className = "listing_rule";
				listing.appendChild(listing_rule);
				var listing_address = document.createElement("div");
				listing_address.className = "listing_address";
				listing_address.innerHTML = object.categories[i].subcategories[j].listings[k].address;
				listing.appendChild(listing_address);
				var listing_phone = document.createElement("div");
				listing_phone.className = "listing_phone";
				listing_phone.innerHTML = object.categories[i].subcategories[j].listings[k].phone;
				listing.appendChild(listing_phone);
				var listing_description = document.createElement("div");
				listing_description.className = "listing_description";
				listing_description.innerHTML = object.categories[i].subcategories[j].listings[k].description;
				listing.appendChild(listing_description);
				var listing_links = document.createElement("div");
				listing_links.className = "listing_links";
				var listing_map = document.createElement("div");
				listing_map.className = "listing_map";
				listing_map.innerHTML = "MAP";
				listing_links.appendChild(listing_map);
				var listing_website = document.createElement("div");
				listing_website.className = "listing_website";
				listing_website.innerHTML = "WEBSITE";
				listing_links.appendChild(listing_website);
				listing.appendChild(listing_links);
				listings.appendChild(listing);
			}			
			
			var listing_count = document.createElement("div");
			listing_count.className = "listing_count";
			listing_count.innerHTML = "(" + count + ")";
			
			subcategory_name.appendChild(listing_count);
			subcategory.appendChild(subcategory_name);
			subcategory.appendChild(listings);			
			category_subcategories.appendChild(subcategory);
		}
		
		category.appendChild(category_subcategories);
		document.getElementById("categories").appendChild(category);
	}
}
/*
$(document).ready(function(){
	$.get("http://localhost:8090/listing", function(data, status){
        //createHTML(data);
		console.log(JSON.stringify(data));
    });
});
*/
window.onload = createHTML(testObject());