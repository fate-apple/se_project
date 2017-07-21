
jQuery(document).ready(function() {

    
    $("#add").click(function(e) {
    	$("#modalTitle").html("添加");
    	$(".delete").css("display","none");
    	$("#passwordDiv").css("display","block");
<<<<<<< HEAD
=======
    	$(".detailStudent").css("display","none");
    	$(".detailCourse").css("display","none");
>>>>>>> origin/csy
    	$("input[name='fullname']").val("");
    	$("input[name='username']").val("");
    	$("input[name='password']").val("");
    	$("#grade").val("");
    	$("#teacher").val("");
    	$("#room").val("");
    	$(".save").attr("data-id","");
    	$("#modal").modal("show");
	});
    
<<<<<<< HEAD
    $(".updateClass").click(function(e){
    	$("#modalTitle").html("修改");
    	$(".delete").css("display","inline");
    	$("#passwordDiv").css("display","none");
=======
    $("#dataTables").delegate(".update","click",function(e){
    	$("#modalTitle").html("修改");
    	$(".delete").css("display","inline");
    	$("#passwordDiv").css("display","none");
    	$(".detailStudent").css("display","inline");
    	$(".detailCourse").css("display","inline");
>>>>>>> origin/csy
    	var dataset = e.currentTarget.dataset;
    	var id = dataset.id;
    	var grade = dataset.grade;
    	var fullname = dataset.fullname;
    	var teacherid = dataset.teacherid;
    	var roomid = dataset.roomid;
    	var username = dataset.username;
    	$("#grade option[value="+grade+"]").attr("selected",true);
    	$("input[name='fullname']").val(fullname);
    	$("input[name='username']").val(username);
    	$("#teacher option[value="+teacherid+"]").attr("selected",true);
    	$("#room option[value="+roomid+"]").attr("selected",true);
    	$(".save").attr("data-id", dataset.id);
<<<<<<< HEAD
    	$("#modal").modal("show");
    });
    
=======
    	$(".delete").attr("data-id", dataset.id);
    	$("#modal").modal("show");
    });
    
//    $(".update").click(function(e){
//    	$("#modalTitle").html("修改");
//    	$(".delete").css("display","inline");
//    	$("#passwordDiv").css("display","none");
//    	$(".detailStudent").css("display","inline");
//    	$(".detailCourse").css("display","inline");
//    	var dataset = e.currentTarget.dataset;
//    	var id = dataset.id;
//    	var grade = dataset.grade;
//    	var fullname = dataset.fullname;
//    	var teacherid = dataset.teacherid;
//    	var roomid = dataset.roomid;
//    	var username = dataset.username;
//    	$("#grade option[value="+grade+"]").attr("selected",true);
//    	$("input[name='fullname']").val(fullname);
//    	$("input[name='username']").val(username);
//    	$("#teacher option[value="+teacherid+"]").attr("selected",true);
//    	$("#room option[value="+roomid+"]").attr("selected",true);
//    	$(".save").attr("data-id", dataset.id);
//    	$("#modal").modal("show");
//    });
    
>>>>>>> origin/csy
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
<<<<<<< HEAD
						url : '/manage/class/deleteAdminclass',
=======
						url : '/manage/class/delete',
>>>>>>> origin/csy
						processData : true,
						dataType : "text",
						data : {
							id : id
						},
						success : function(data) {
							console.log(id);
<<<<<<< HEAD
							alert(data);
							location.reload();

=======
							bootbox.alert({
								message :"删除成功",
								callback : function() {
									location.reload();
								}
							});

						},
						error:function(data){
							bootbox.alert({message:"班级仍存在学生或课程，故无法删除！"});
>>>>>>> origin/csy
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
		var teacherid = $("#teacher").val();
		var roomid = $("#room").val();
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
<<<<<<< HEAD
		
		jQuery.ajax({
			url : "/manage/class/updateAdminclass",
				processData : true,
				dataType : "text",
				method : "POST",
				data:{
					id: id,
					fullname : fullname,
					username : username,
					password : password,
					teacherid : teacherid,
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
=======
		if(id==""){
			jQuery.ajax({
				url : "/manage/class/create",
					processData : true,
					dataType : "text",
					method : "POST",
					data:{
						fullname : fullname,
						username : username,
						password : password,
						teacherId : teacherid,
						roomId : roomid,
						grade : grade
					},
					success : function(data) {
						console.log(id);
						bootbox.alert({
							message :"添加成功",
							callback : function() {
								location.reload();
							}
						});
					},
					error:function(data){
						alert("用户名重复");
					}
			});
		}
		else{
			jQuery.ajax({
				url : "/manage/class/update",
					processData : true,
					dataType : "text",
					method : "POST",
					data:{
						id: id,
						fullname : fullname,
						username : username,
						teacherId : teacherid,
						roomId : roomid,
						grade : grade
					},
					success : function(data) {
						console.log(id);
						bootbox.alert({
							message :"修改成功",
							callback : function() {
								location.reload();
							}
						});
					},
					error:function(data){
						alert("修改失败");
					}
			});
		}
>>>>>>> origin/csy
	});
    
});
