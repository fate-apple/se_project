jQuery(document).ready(function() {
	var username = $("#timetableUsername").val();
	console.log(username);
	jQuery.ajax({
		url:"/manage/course/findByUsername",
		method:"GET",
		dataType:"text",
		data:{
			username:username
		},
		success:function(data){
			alert(data);
		}
	});
})