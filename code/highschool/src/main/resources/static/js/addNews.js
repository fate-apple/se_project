jQuery(document).ready(function() {
    
    $("#addNews").click(function(e) {
    	var header= $("input[id='informationHeader']").val();
    	var content = CKEDITOR.instances.informationEditor.getData();
    	//alert(header + content);

	});
    
    $("#grade").change(function(e) {
    	var grade=[];
    	var obj = document.getElementById("grade");
    	for(var i=0;i<obj.options.length;i++){
			if(obj.options[i].selected){
				grade.push( obj.options[i].value);
			}
    	}
    	alert(grade);
    });
    
    
});
