jQuery(document).ready(function() {
	function resource(getPeriod,getSubject,getTeacher,getRoom,getAdminClass){
		if(getPeriod==1){
			jQuery.ajax({
				url:"/api/resource/period",
				method:"GET",
				dataType:"JSON",
				async: false,
				success:function(data){
					$("#period").find("option").remove();
					for(var i=0;i<data.length;i++){
						$("#period.selectpicker").append("<option value="+data[i].id+">"+
								data[i].beginTime+"-"+data[i].endTime+"</option>")
					}
					$("#period").selectpicker("refresh");
				}
			});
		}
		if(getSubject==1){
			jQuery.ajax({
				url:"/api/resource/subject",
				method:"GET",
				dataType:"JSON",
				async: false,
				success:function(data){
					$("#subject").find("option").remove();
					for(var i=0;i<data.length;i++){
						$("#subject.selectpicker").append("<option value="+data[i].subjectId+">"+
								data[i].title+"</option>")
					}
					$("#subject").selectpicker("refresh");
				}
			});
		}
		if(getTeacher==1){
			jQuery.ajax({
				url:"/api/resource/teacher",
				method:"GET",
				dataType:"JSON",
				async: false,
				success:function(data){
					$("#teacher").find("option").remove();
					for(var i=0;i<data.length;i++){
						$("#teacher.selectpicker").append("<option value="+data[i].id+">"+
								data[i].fullname+"</option>")
					}
					$("#teacher").selectpicker("refresh");
				}
			});
		}
		if(getRoom==1){
			jQuery.ajax({
				url:"/api/resource/room",
				method:"GET",
				dataType:"JSON",
				async: false,
				success:function(data){
					$("#classroom").find("option").remove();
					for(var i=0;i<data.length;i++){
						$("#classroom.selectpicker").append("<option value="+data[i].roomId+">"+
								data[i].buildingName+' '+data[i].roomNum+"</option>")
					}
					$("#classroom").selectpicker("refresh");
				}
			});
		}
		if(getAdminClass==1){
			jQuery.ajax({
				url:"/api/resource/adminClass",
				method:"GET",
				dataType:"JSON",
				async: false,
				success:function(data){
					$("#adminClass").find("option").remove();
					for(var i=0;i<data.length;i++){
						$("#adminClass.selectpicker").append("<option value="+data[i].id+">"+
								data[i].fullname+"</option>")
					}
					$("#adminClass").selectpicker("refresh");
				}
			});
		}
	}
	
    $("#add").click(function(e) {
    	resource(1,1,1,1,0);
    	$("#modalTitle").html("添加");
    	$(".delete").css("display","none");
    	$("#capability").val("");
		$("#subject").selectpicker("val","");
		$("#teacher").selectpicker("val","");
		$("#classroom").selectpicker("val","");
		$("#weekday").selectpicker("val","");
		$("#period").selectpicker("val","");
    	$(".save").attr("data-id","");
    	$("#modal").modal("show");
	});
    
    $("#dataTables").delegate(".update","click",function(e){
    	resource(1,1,1,1,0);
    	var dataset = e.currentTarget.dataset;
    	$("#capability").val(dataset.capability);
		$("#subject").selectpicker("val",dataset.subjectid);
		$("#teacher").selectpicker("val",dataset.teacherid);
		$("#classroom").selectpicker("val",dataset.roomid);
		$("#weekday").selectpicker("val",dataset.weekday);
		$("#period").selectpicker("val",dataset.periodid);
    	$("#modalTitle").html("修改");
    	$(".delete").css("display","inline");
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
						url : '/manage/electivecourse/delete',
						processData : true,
						dataType : "text",
						data : {
							courseId : id
						},
						success : function(data) {
							console.log(id);
							bootbox.alert({
								message :data,
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
		var subjectId = $("#subject").val();
		var teacherId = $("#teacher").val();
		var roomId = $("#classroom").val();
		var capability = $("#capability").val();
		var weekday = $("#weekday").val();
		var periodId = $("#period").val();
		var dataset = e.currentTarget.dataset;
		var id = dataset.id;
		if (subjectId==""||teacherId==""||roomId==""||capability==""||weekday==""||periodId==""){
			alert("请填写完整信息！");
		}
		else if(capability<0){
			alert("限制人数错误！")
		}
		else{
			if(id==""){
				jQuery.ajax({
						url : "/manage/electivecourse/create",
							processData : true,
							dataType : "text",
							method : "POST",
							data:{
								subjectId:subjectId,
								teacherId : teacherId,
								capability : capability,
								weekday : weekday,
								periodId : periodId,
								roomId : roomId
							},
							success : function(data) {
								console.log(id);
								bootbox.alert({
									message :data,
									callback : function() {
										location.reload();
									}
								});
							},
							error:function(data){
								alert("表格不完整，添加失败");
							}
					});
			}
			else{
				jQuery.ajax({
					url : "/manage/electivecourse/update",
						processData : true,
						dataType : "text",
						method : "POST",
						data:{
							courseId : id,
							subjectId:subjectId,
							teacherId : teacherId,
							capability:capability,
							weekday : weekday,
							periodId : periodId,
							roomId : roomId
						},
						success : function(data) {
							console.log(id);
							bootbox.alert({
								message :data,
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
			//end else of id==""
		}
	});
    
    $("#getCourse").click(function(e){
    	var classes="";
    	var obj = document.getElementById("class");
    	for(var i=0;i<obj.options.length;i++){
			if(obj.options[i].selected){
				classes += obj.options[i].value+",";
			}
    	}
    	classes = classes.substring(0,classes.length-1);
       	console.log(classes);
       
       	$("#adminClasses").val(classes);
       	$("#getCourseForm").attr("action","/manage/course/findByAdminClass");
       	$("#getCourseForm").submit();
    });
    
});
