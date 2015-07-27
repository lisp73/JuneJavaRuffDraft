(function setupMap(){
	var grandCircusCoordinates = {lat: 42.336, lng: -83.05 };
	var mapInput = {
		zoom: 8,
		center: grandCircusCoordinates
	};
	var mapElement = document.getElementById('map-canvas');
	var map = new google.maps.Map(mapElement, mapInput);
	return map;
})

function loadMap(places){
	var grandCircusCoordinates = {lat: 42.336, lng: -83.05 };
	var mapInput = {
		zoom: 8,
		center: grandCircusCoordinates
	};
	var mapElement = document.getElementById('map-canvas');
	var map = new google.maps.Map(mapElement, mapInput);
	
	var markers = [];
	for(var index = 0; index < places.length; index++){
		var place = places[index]; 
		var placeCoordinates = { lat: place.location.latitude, lng: place.location.longitude };
		var markerInput = {
		    position: placeCoordinates,
		    label: place.name,
		    map: map
		  };
		markers.push(new google.maps.Marker(markerInput));	
	}
	
	return { map: map, markers :markers};
}


var app = angular.module('app', []);
app.controller('MainController', function($scope, $http){
	$scope.getDataFromServer=function(){
		$http({
			method : 'GET',
			url : 'pizzerias'
		}).success(function(data, status, headers, config) {
            window.mapInfo = loadMap(data);
			$scope.pizzerias = data;
		}).error(function(data, status, headers, config) {

			// called asynchronously if an error occurs
			// or server returns response with an error status.

		});
	}

})
