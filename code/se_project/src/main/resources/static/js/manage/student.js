
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
    
    $("#dataTables").delegate(".update","click",function(e){
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
    	$(".delete").attr("data-id", dataset.id);
    	$("#modal").modal("show");
    });

//    $(".update").click(function(e){
//    	$("#modalTitle").html("修改");
//    	$(".delete").css("display","inline");
//    	$("#passwordDiv").css("display","none");
//    	$(".detailCourse").css("display","inline");
//    	var dataset = e.currentTarget.dataset;
//    	var id = dataset.id;
//    	var gender = dataset.gender;
//    	var fullname = dataset.fullname;
//    	var roomid = dataset.roomid;
//    	var username = dataset.username;
//    	var enrolldate = dataset.enrolldate;
//    	$("#gender option[value="+gender+"]").attr("selected",true);
//    	$("input[name='fullname']").val(fullname);
//    	$("input[name='username']").val(username);
//    	$("#enrollDate").val(enrolldate);
//    	$(".save").attr("data-id", dataset.id);
//    	$("#modal").modal("show");
//    });
    
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
						url : '/manage/student/delete',
						processData : true,
						dataType : "text",
						data : {
							id : id
						},
						success : function(data) {
							console.log(id);
							bootbox.alert({
								message :"删除成功",
								callback : function() {
									location.reload();
								}
							});

						},
						error:function(data){
							bootbox.alert({message:"删除失败，详情请咨询QQ1403656791"});
						}
					});
				}
			}
		});
	});
	
	$(".save").click(function(e){
		var gender = $("#gender").val();
		var fullname = $("input[name='fullname']").val();
		var username = $("input[name='username']").val();
		var password = $("input[name='password']").val();
		var gender = $("#gender").val();
		var adminClassId = $("#adminClass").val();
		var virtualClassId = $("#virtualClass").val();
		var enrollDate = $("#enrollDate").val();
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
		if(id==""){
			jQuery.ajax({
					url : "/manage/student/create",
						processData : true,
						dataType : "text",
						method : "POST",
						data:{
							fullname : fullname,
							username : username,
							password : password,
							adminClassId : adminClassId,
							virtualClassId : virtualClassId,
							gender : gender,
							enrollDate : enrollDate
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
				url : "/manage/teacher/update",
					processData : true,
					dataType : "text",
					method : "POST",
					data:{
						id: id,
						fullname : fullname,
						username : username,
						adminClassId : adminClassId,
						virtualClassId : virtualClassId,
						gender : gender,
						enrollDate : enrollDate
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
	});
    
});
