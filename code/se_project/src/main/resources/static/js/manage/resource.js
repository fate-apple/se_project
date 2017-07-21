jQuery(document).ready(function() {
	function resource(getPeriod,getSubject,getTeacher,getRoom,getAdminClass){
		if(getPeriod==1){
			jQuery.ajax({
				url:"/api/resource/period",
				method:"GET",
				dataType:"JSON",
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
})