jQuery(document).ready(function() {
	//填充课表
	var username = $("#timetableUsername").val();
	console.log(username);
	jQuery.ajax({
		url:"/manage/course/findByUsername",
		method:"GET",
		dataType:"JSON",
		data:{
			username:username
		},
		success:function(data){
			alert(JSON.stringify(data));
			for(var i=0;i<data.length;i++){
//				$("#timetable tr:eq("+data[i].period.id+") td:eq("+data[i].weekday+")").append(data[i].subject.title+
//						"("+data[i].teacher.fullname+")"+"<br/>");
				$("#timetable tr:eq("+data[i].period.id+") td:eq("+data[i].weekday+")").append(data[i].subject.title+"<br/>");
			}
		}
	});
})