var findObject;

//SET FIND OBJECT
function setFindObject(object){
	findObject = object;	
}

//TEST OBJECT
function testFindGetObject(){
	var testObject = 
		{"locations":[
			{"city":"Chicago",
			"neighborhoods":["Magnificent Mile", "Chicago Loop", "Wicker Park", "Chinatown", "Logan Square", "Lincoln Park"]
			},
			{"city":"Schaumburg",
			"neighborhoods":[]
			},
			{"city":"Evanston",
			"neighborhoods":["Skokie","Wilmette","Highland"]
			}]
		}		
	return testObject;
}

//POPULATE FIND CITY LIST
function populateFindCityList(){
		
		var cityList = document.getElementById("city_drop_list");
		
		for (var i = 0; i < findObject.locations.length; i++){
			var cityOption = document.createElement("option");
			var city = findObject.locations[i].city;
			
			cityOption.textContent = city;
			cityOption.value = city;
			cityList.appendChild(cityOption);
		}
}

//POPULATE FIND NEIGHBORHOOD LIST
function populateFindNeighborhoodList(value){
	$("#neighborhood_drop_list").empty();
	var neighborhoodList = document.getElementById("neighborhood_drop_list");
	var defaultOption = document.createElement("option");
	defaultOption.selected = true;
	defaultOption.disabled = true;
	defaultOption.textContent = "Select neighborhood...";
	neighborhoodList.appendChild(defaultOption);
	
	for (var i = 0; i < findObject.locations[value].neighborhoods.length; i++){
		var neighborhoodOption = document.createElement("option");
		var neighborhood = findObject.locations[value].neighborhoods[i];
		
		neighborhoodOption.textContent = neighborhood;
		neighborhoodOption.value = neighborhood;
		neighborhoodList.appendChild(neighborhoodOption);	
	}
	
}

//FIND LISTINGS
function findListings(){
	var listing = document.getElementById("listing_search").value;
	var city = document.getElementById("city_drop_list").value;
	var neighborhood = document.getElementById("neighborhood_drop_list").value;
	
	if (listing === ""){
		document.getElementById("listing_search").style.border = "5px solid #FF0000";
	}
	
	//TODO ADD FIND LISTING GET REQUEST
	
}

//TODO ADD LOCATIONS GET REQUEST

//PAGE LOAD
function pageLoad(){
	setFindObject(testFindGetObject());
	populateFindCityList();
	
	document.getElementById("search_button").addEventListener("click", findListings);
}

window.onload = pageLoad();