jQuery(document).ready(function() {
	
	//重置密码
	$(".resetPassword").click(function(e){
		var username = $("#username").val();
		var password = $("#password").val();
		jQuery.ajax({
			url : "/manage/password/reset",
			processData : true,
			dataType : "text",
			method : "POST",
			data:{
				username:username,
				password:password
			},
			success : function(data) {
				console.log(id);
				bootbox.alert({
					message :"重置成功",
					callback : function() {
						location.reload();
					}
				});
			}
		})
	});

	
})