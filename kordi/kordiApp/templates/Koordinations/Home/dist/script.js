const header = document.querySelector(".header");
const headerTop = header.getBoundingClientRect().top;

document.body.style.setProperty("--_header-h", `${header.offsetHeight}px`);

window.addEventListener("scroll", function () {
  header.classList.toggle(
  "is-sticky",
  window.scrollY > headerTop + header.offsetHeight);

});


/* initialize */
function initialize() {
	/* set options */
	var mapOptions = {
		center: new google.maps.LatLng(50.8503396, 4.351710300000036),
		zoom: 10,
		mapTypeId: google.maps.MapTypeId.TERRAIN,
		scrollwheel: false,
	    navigationControl: false,
	    mapTypeControl: false,
	    scaleControl: false,
	    draggable: true,
	};
	var autocompleteOptions = {
		componentRestrictions: {country: "be"}
	};
	
	/* set datas */
	// delivery map
	var order_map 			= new google.maps.Map(document.getElementById('order_map'), mapOptions),
		geocoder			= new google.maps.Geocoder(),
		PU_address_input 	= document.getElementById("PU_address"),
		PU_position_input 	= document.getElementById("PU_position"),
		D_address_input		= document.getElementById("D_address"),
		D_position_input	= document.getElementById("D_position"),
		distance_input		= document.getElementById("distance")
		
	
	var PU = {
		autocomplete:	new google.maps.places.Autocomplete(PU_address_input, autocompleteOptions),
		place:			"",
		name:			"",
		vicinity:		"",
		position:		""
	};
	
	var D = {
		autocomplete:	new google.maps.places.Autocomplete(D_address_input, autocompleteOptions),
		place:			"",
		name:			"",
		vicinity:		"",
		position:		""
	};
	
	
	/* event listeners */
	// PU_address
	google.maps.event.addListener(PU.autocomplete, 'place_changed', function () {
		// set datas
		PU.place 		= PU.autocomplete.getPlace();
		PU.name 		= PU.place.name;
		PU.vicinity		= PU.place.vicinity;
		PU.position		= PU.place.geometry.location;
		
		//console datas
		//console.log("name: " + PU.name)
		//console.log("vicinity: " + PU.vicinity)
		//console.log("position: " + PU.position.toString())
		
		// set form info input
		PU_position_input.value = PU.place.geometry.location.toString()
		
		// add marker
		PU.marker = new google.maps.Marker({
		    position: PU.position,
		    title:"Hello World!"
		});
		PU.marker.setMap(order_map);
		
		// get distance
		var distance = ((google.maps.geometry.spherical.computeDistanceBetween( PU.position, D.position ))/1000).toFixed(3);
		distance_input.value = distance;

	});
	
	// D_address
	google.maps.event.addListener(D.autocomplete, 'place_changed', function () {
		// set datas
		D.place 		= D.autocomplete.getPlace();
		D.name 			= D.place.name;
		D.vicinity		= D.place.vicinity;
		D.position		= D.place.geometry.location;
		
		//console datas
		//console.log("name: " + D.name)
		//console.log("vicinity: " + D.vicinity)
		//console.log("position: " + D.position.toString())
		
		// set form info input
		D_position_input.value = D.place.geometry.location.toString()
		
		// add marker
		D.marker = new google.maps.Marker({
		    position: D.position,
		    title:"Hello World!"
		});
		D.marker.setMap(order_map);
		
		// get distance
		var distance = ((google.maps.geometry.spherical.computeDistanceBetween( PU.position, D.position ))/1000).toFixed(3);
		distance_input.value = distance;

	});
	
	
}

google.maps.event.addDomListener(window, 'load', initialize);
