jQuery(document).ready(function() {
    
    $("#addNews").click(function(e) {
    	var title= $("input[id='informationHeader']").val();
    	var content = CKEDITOR.instances.informationEditor.getData();
    	//alert(header + content);
    	//组建班级数组
    	var classes="";
    	var obj = document.getElementById("class");
    	for(var i=0;i<obj.options.length;i++){
			if(obj.options[i].selected){
				classes += obj.options[i].value+",";
			}
    	}
    	classes = classes.substring(0,classes.length-1);
       	console.log(classes);
       	if(title==""){
       		alert("标题为空！");
       	}
       	else if (classes==""){
       		alert("请选择班级！")
       	}
       	else{
       		jQuery.ajax({
				url : "/base/addnews",
					processData : true,
					dataType : "text",
					method : "POST",
					data:{
						title : title,
						content : content,
						classes : classes,
					},
					success : function(data) {
						bootbox.alert({
							message :"发布成功",
							callback : function() {
								window.location.href = "/base/news";
							}
						});
					},
					error:function(data){
						alert("发布失败");
					}
			});
       	}
	});

    
    
});
