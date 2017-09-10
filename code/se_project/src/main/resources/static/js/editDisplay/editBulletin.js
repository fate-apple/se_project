jQuery(document).ready(function() {
    
    $("#editIntroduction").click(function(e) {
    	var content = CKEDITOR.instances.informationEditor.getData();
    	

	});

    $('#myTab a').click(function (e) {
    	  e.preventDefault()
    	  $(this).tab('show')
    	})
    
});
