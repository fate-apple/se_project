
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
	
//	$(".uploadFile").click(function(e){
//		var formData = new FormData();
//		var name = $('#image1').val();
//		formData.append("file",$("#image1").get(0).files[0]);
//		$.ajax({
//		    url: '/editDisplay/uploadAlbum',
//		    type: 'POST',
//		    cache: false,
//		    data: formData,
//		    processData: false,
//		    contentType: false,         
//		    success: function (returndata) {  
//		    	alert(returndata);
//	            $("#realImg1").attr("src",returndata); 
//	          },  
//	        error: function (returndata) {  
//	              alert("上传失败！");  
//	         } 
//		})
//	});


function uploadimg(id){
	var formData = new FormData();
	var name = $('#image'+id).val();
	formData.append("file",$("#image"+id).get(0).files[0]); 
	formData.append("id",id);
	$.ajax({
	    url: '/editDisplay/uploadAlbum',
	    type: 'POST',
	    cache: false,
	    data: formData,
	    processData: false,
	    contentType: false, 
	    success: function (returndata) {  
            $("#realImg"+id).attr("src",returndata);
//            $("#realImg1").html('<img scr="'+returndata+'" />');
          },  
        error: function (returndata) {  
              alert("修改失败！");  
         } 
	});
}
