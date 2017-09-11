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
	var name = $('#courseware1').val();
	formData.append("file",$("#courseware1").get(0).files[0]);
	var classes="";
	var obj = document.getElementById("class");
	for(var i=0;i<obj.options.length;i++){
		if(obj.options[i].selected){
			classes += obj.options[i].value+",";
		}
	}
	classes = classes.substring(0,classes.length-1);
	if (classes==""){
   		alert("请选择班级！")
   	}
	else if(name==""){
   		alert("请选择要上传的文件！");
   	}
	else{
		formData.append("classes",classes);
		$.ajax({
		    url: '/edu/addcourseware',
		    type: 'POST',
		    cache: false,
		    data: formData,
		    processData: false,
		    contentType: false,         
		    success: function (returndata) {  
		    	alert("上传成功");
		    	location.reload();
	          },  
	        error: function (returndata) {  
	              alert("上传失败！");  
	         } 
		})
	}
});
})