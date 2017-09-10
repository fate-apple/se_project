jQuery(document).ready(function() {
    
    $("#editIntroduction").click(function(e) {
    	var content = CKEDITOR.instances.informationEditor.getData();
    	if(content==""){
    		alert("内容为空！");
    	}
    	else{
       		jQuery.ajax({
				url : "/editDisplay/editIntroduction",
					processData : true,
					dataType : "text",
					method : "POST",
					data:{
						content : content,
					},
					success : function(data) {
						alert("修改成功");
						location.reload();
					},
					error:function(data){
						alert("修改失败");
					}
			});
    	}

	});

    
    
});
