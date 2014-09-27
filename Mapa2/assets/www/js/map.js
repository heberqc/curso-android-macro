(function() {
  window.onload = function() {

    // Creating a MapOptions object with the required properties
	var options = { 
  zoom: 7, 
  center: new google.maps.LatLng(-12.05,-77.051), 
  mapTypeId: google.maps.MapTypeId.ROADMAP, 
  mapTypeControl: true, 
  mapTypeControlOptions: { 
    mapTypeIds: [ 
      google.maps.MapTypeId.ROADMAP, 
      google.maps.MapTypeId.SATELLITE
    ] 
  } 
}; 
	
	
    // Creating the map  
    var map = new google.maps.Map(document.getElementById('mapa_peru'), options);
    
    // Attaching click events to the buttons
    
    // Getting values
    document.getElementById('getValues').onclick = function() {
      alert('Nivel ' + map.getZoom());
      alert('Centrado ' + map.getCenter());
      alert('Tipo' + map.getMapTypeId());
    }

    // Changing values
    document.getElementById('changeValues2').onclick = function() {
      map.setOptions({
        center: new google.maps.LatLng(-12.05,-77.051),
        zoom: 7,
        mapTypeId: google.maps.MapTypeId.SATELLITE
      });
    }

    // Changing values
    document.getElementById('changeValues').onclick = function() {
      map.setOptions({
        center: new google.maps.LatLng(-13.164317,-72.545372),
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.SATELLITE
      });
    }

  };
})();