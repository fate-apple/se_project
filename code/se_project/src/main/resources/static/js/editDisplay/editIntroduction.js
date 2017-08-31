jQuery(document).ready(function() {
    
    $("#editIntroduction").click(function(e) {
    	var content = CKEDITOR.instances.informationEditor.getData();
    	alert(content);

	});

    
    
});
