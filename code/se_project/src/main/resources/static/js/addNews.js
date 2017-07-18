jQuery(document).ready(function() {
    
    $("#addNews").click(function(e) {
    	var header= $("input[id='informationHeader']").val();
    	var content = CKEDITOR.instances.informationEditor.getData();
<<<<<<< HEAD
    	alert(header + content);
		
	});
=======
    	//alert(header + content);

	});

>>>>>>> cf14035ebec2295d395762a50c1696656ddd5378
    
    
});
