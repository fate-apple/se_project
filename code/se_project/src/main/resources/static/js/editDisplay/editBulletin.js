jQuery(document).ready(function() {
	var acontent1 = $("#bullet1").val();
	var acontent2 = $("#bullet2").val();
	var acontent3 = $("#bullet3").val();
	CKEDITOR.instances.content1.setData(acontent1);
	CKEDITOR.instances.content2.setData(acontent2);
	CKEDITOR.instances.content3.setData(acontent3);
	
    $("#editBulletin1").click(function(e) {
    	var content = CKEDITOR.instances.content1.getData();
    	var title = $("#title1").val();
    	
    	var id = 1;
    	console.log(content,title);
   		jQuery.ajax({
			url : "/editDisplay/editBulletin",
				processData : true,
				dataType : "text",
				method : "POST",
				data:{
					content : content,
					title :title,
					id : id
				},
				success : function(data) {
					alert("修改成功");
					$("#title1").val(title);
					$("#content1p").attr("text",content);
				},
				error:function(data){
					alert("修改失败");
					location.reload();
				}
		});

	});
    
    $("#editBulletin2").click(function(e) {
    	var content = CKEDITOR.instances.content2.getData();
    	var title = $("#title2").val();
    	var id = 2;
    	console.log(content,title);
   		jQuery.ajax({
			url : "/editDisplay/editBulletin",
				processData : true,
				dataType : "text",
				method : "POST",
				data:{
					content : content,
					title :title,
					id : id
				},
				success : function(data) {
					alert("修改成功");
					$("#title2").val(title);
					$("#content2p").attr("text",content);
				},
				error:function(data){
					alert("修改失败");
					location.reload();
				}
		});

	});
    
    $("#editBulletin3").click(function(e) {
    	var content = CKEDITOR.instances.content3.getData();
    	var title = $("#title3").val();
    	var id = 3;
    	console.log(content,title);
   		jQuery.ajax({
			url : "/editDisplay/editBulletin",
				processData : true,
				dataType : "text",
				method : "POST",
				data:{
					content : content,
					title :title,
					id : id
				},
				success : function(data) {
					alert("修改成功");
					$("#title3").val(title);
					$("#content3p").attr("text",content);
				},
				error:function(data){
					alert("修改失败");
					location.reload();
				}
		});

	});

    $('#myTab a').click(function (e) {
    	  e.preventDefault()
    	  $(this).tab('show')
    	})
    
});
