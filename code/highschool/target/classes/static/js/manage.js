jQuery(document).ready(function() {
    
    
    $("#grade").change(function(e) {
    
    	var grades="";
    	var obj = document.getElementById("grade");
    	for(var i=0;i<obj.options.length;i++){
			if(obj.options[i].selected){
				grades += obj.options[i].value+",";
			}
    	}
    	grades = grades.substring(0,grades.length-1);
    	console.log(grades);
    	jQuery.ajax({
			url : '/manage/getClass',
				processData : true,
				dataType : "JSON",
				type:"POST",
				traditional: true,
				data : {
					grades: grades
				},
				success : function(data) {
					$("#class").find("option").remove(); 
					for(var i=0;i<data.classnum;i++){
						$("#class.selectpicker").append("<option value="+data.classid[i]+">"+
								data.classname[i]+"</option>");
						
					}
					$("#class").selectpicker("refresh");
					console.log(data);

				}
			});
    });
		
    $("#getStudent").click(function(e){
    	var classes="";
    	var obj = document.getElementById("class");
    	for(var i=0;i<obj.options.length;i++){
			if(obj.options[i].selected){
				classes += obj.options[i].value+",";
			}
    	}
    	classes = classes.substring(0,classes.length-1);
       	console.log(classes);
       
       	$("#classes").val(classes);
       	$("#getStudentForm").attr("action","/manage/getStudent");
       	$("#getStudentForm").submit();
    });
    
    
});
