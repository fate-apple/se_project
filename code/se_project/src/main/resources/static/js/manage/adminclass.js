
jQuery(document).ready(function() {

    
    $("#add").click(function(e) {
    	$("#modalTitle").html("添加");
    	$(".delete").css("display","none");
    	$("input[name='fullname']").val("");
    	$("#grade").val("");
    	$("#teacher").val("");
    	$("#room").val("");
    	$("#modal").modal("show");
	});
    
    $(".updateClass").click(function(e){
    	$("#modalTitle").html("修改");
    	$(".delete").css("display","inline");
    	var dataset = e.currentTarget.dataset;
    	console.log(dataset.id,dataset.roomid);
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
						url : '/manage/deleteStudent',
						processData : true,
						dataType : "text",
						data : {
							studentId : id
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
    
});
