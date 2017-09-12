jQuery(document).ready(function() {
	$( '.detail' ).click( function(e) {
		var dataset = e.currentTarget.dataset;
		$('#inform'+dataset.id).html(dataset.content);
	});
	
});