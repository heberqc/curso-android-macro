(function() {
  window.onload = function() {
    alert('Ubicacion del Peru....!');  
	// refrencia al div que mostrara el mapa
    var mapDiv = document.getElementById('mapa_peru');
    
    // referencia de longitud y latitud
    var latlng = new google.maps.LatLng(-12.05,-77.05);
    // propiedades del mapa  
    var options = {
      center: latlng,
      zoom: 4,
      mapTypeId:google.maps.MapTypeId.ROADMAP
    };
    // creacion del mapa
    var map = new google.maps.Map(mapDiv, options);
	var image = 'peru.png';
	        var marker = new google.maps.Marker({
            position: latlng,
            map: map,
			icon: image,
            title: 'Hola Peru!'
        });
	
	}
})
();

