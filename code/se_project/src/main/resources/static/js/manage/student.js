
jQuery(document).ready(function() {

    
    $("#add").click(function(e) {
    	$("#modalTitle").html("添加");
    	$(".delete").css("display","none");
    	$("#passwordDiv").css("display","block");
    	$(".detailCourse").css("display","none");
    	$("input[name='fullname']").val("");
    	$("input[name='username']").val("");
    	$("input[name='password']").val("");
    	$("#gender").val("");
    	$("#adminClass").val("");
    	$("#virtualClass").val("");
    	$("#enrollDate").val("");
    	$(".save").attr("data-id","");
    	$("#modal").modal("show");
	});
    
    $(".update").click(function(e){
    	$("#modalTitle").html("修改");
    	$(".delete").css("display","inline");
    	$("#passwordDiv").css("display","none");
    	$(".detailCourse").css("display","inline");
    	var dataset = e.currentTarget.dataset;
    	var id = dataset.id;
    	var gender = dataset.gender;
    	var fullname = dataset.fullname;
    	var roomid = dataset.roomid;
    	var username = dataset.username;
    	var enrolldate = dataset.enrolldate;
    	$("#gender option[value="+gender+"]").attr("selected",true);
    	$("input[name='fullname']").val(fullname);
    	$("input[name='username']").val(username);
    	$("#enrollDate").val(enrolldate);
    	$(".save").attr("data-id", dataset.id);
    	$("#modal").modal("show");
    });
    
	$(".delete").click(function(e) {
		bootbox.confirm({
			buttons : {
				confirm : {
					label : '删除'
				},
				cancel : {
					label : '取消'
				}
			},
			message : '确认要删除吗？',
			callback : function(result) {
				if (result) {
					var dataset = e.currentTarget.dataset;
					var id = dataset.id;
					console.log(id);
					jQuery.ajax({
						url : '/manage/class/deleteAdminclass',
						processData : true,
						dataType : "text",
						data : {
							id : id
						},
						success : function(data) {
							console.log(id);
							alert(data);
							location.reload();

						}
					});
				}
			}
		});
	});
	
	$(".save").click(function(e){
		var grade = $("#grade").val();
		var fullname = $("input[name='fullname']").val();
		var username = $("input[name='username']").val();
		var password = $("input[name='password']").val();
		var roomid = $("#room").val();
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
		
		jQuery.ajax({
			url : "/manage/class/updateTeacher",
				processData : true,
				dataType : "text",
				method : "POST",
				data:{
					id: id,
					fullname : fullname,
					username : username,
					password : password,
					roomid : roomid,
					grade : grade
				},
				success : function(data) {
					console.log(id);
					bootbox.alert({
						message : data,
						callback : function() {
							location.reload();
						}
					});
				}
		});
	});
    
});
