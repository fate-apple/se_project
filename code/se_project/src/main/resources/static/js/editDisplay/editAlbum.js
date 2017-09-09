jQuery(document).ready(function() {
	//根据选择文件修改按钮文字
	$( '.inputfile' ).click( function(e) {
	    var $input = $( this ),
	        $label = $input.next( 'label' ),
	        labelVal = $label.html();

	    $( this ).on( 'change', function( e ) {
	        var fileName = '';

	        if( this.files && this.files.length > 1 )
	            fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
	        else if( e.target.value )
	            fileName = e.target.value.split( '\\' ).pop();

	        if( fileName )
	            $label.html( fileName );
	        else
	            $label.html( labelVal );
	    });
	});
	
	$(".uploadFile").click(function(e){
		var formData = new FormData();
		var name = $('#image1').val();
		var $input = $("#image1");
		formData.append("file", $input.files[0]);
		$.ajax({
		    url: '/editDisplay/uploadAlbum',
		    type: 'POST',
		    cache: false,
		    data: new FormData($('#uploadForm')[0]),
		    processData: false,
		    contentType: false,         
		    success: function (returndata) {  
	              alert(returndata);  
	          },  
	        error: function (returndata) {  
	              alert(returndata);  
	         } 
		})
	});
})
