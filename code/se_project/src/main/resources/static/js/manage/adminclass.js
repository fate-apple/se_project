
jQuery(document).ready(function() {

    
    $("#add").click(function(e) {
    	$("#modalTitle").html("添加");
    	$(".delete").css("display","none");
    	$("#passwordDiv").css("display","block");
    	$("input[name='fullname']").val("");
    	$("input[name='username']").val("");
    	$("input[name='password']").val("");
    	$("#grade").val("");
    	$("#teacher").val("");
    	$("#room").val("");
    	$(".save").attr("data-id","");
    	$("#modal").modal("show");
	});
    
    $(".updateClass").click(function(e){
    	$("#modalTitle").html("修改");
    	$(".delete").css("display","inline");
    	$("#passwordDiv").css("display","none");
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
		var teacherid = $("#teacher").val();
		var roomid = $("#room").val();
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
		
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
	});
    
});
