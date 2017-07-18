jQuery(document).ready(function() {
    
    $("#addNews").click(function(e) {
    	var header= $("input[id='informationHeader']").val();
    	var content = CKEDITOR.instances.informationEditor.getData();
    	//alert(header + content);

	});

    
    
});
