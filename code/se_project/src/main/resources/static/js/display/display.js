jQuery(document).ready(function() {
	
	//调整首页图片大小
	var height = $("#block1").css("height");
	$(".image").css("height",height);
	
    $('#horizontalTab').easyResponsiveTabs({
        type: 'default', //Types: default, vertical, accordion
        width: 'auto', //auto or any width like 600px
        fit: true, // 100% fit in a container
        closed: 'accordion', // Start closed if in accordion view
        activate: function(event) { // Callback function if tab is switched
            var $tab = $(this);
            var $info = $('#tabInfo');
            var $name = $('span', $info);

            $name.text($tab.text());

            $info.show();
			
        }
    });

    $('#ab').easyResponsiveTabs({
        type: 'vertical',
        width: 'auto',
        fit: true,
    });
	

	$('#cmt').easyResponsiveTabs({
        type: 'vertical',
        width: 'auto',
        fit: true,
    });
	
	//初始化班级公告
	var content1 = $("#content1").val();
	$("#content1p").html(content1);
	var content2 = $("#content2").val();
	$("#content2p").html(content2);	
	var content3 = $("#content3").val();
	$("#content3p").html(content3);
	var information1 = $("#information1").val();
	$("#information1p").html(information1);
	
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
			for(var i=0;i<data.length;i++){
				$("#timetable tr:eq("+data[i].period.id+") td:eq("+data[i].weekday+")").append(data[i].subject.title+
						"("+data[i].teacher.fullname+")"+"<br/>");
			}
		}
	});
	
//	$( '.prevInform' ).click( function(e) {
//		alert("上一条");
//	});
//	
//	$( '.nextInform' ).click( function(e) {
//		alert("下一条");
//	});
	window.setInterval("updateTime();",1000);
	

})

function updateTime(){
	var mydate = new Date();
	var day = mydate.getDay(); 
	var date = mydate.toLocaleDateString(); 
	var hours = mydate.getHours(); 
	var minutes = mydate.getMinutes(); 
	var seconds = mydate.getSeconds(); 
	$("#tmptime").text(hours+":"+minutes+":"+seconds);
	if(day==1){
		$("#tmpweekday").text("星期一");
	}
	else if(day==2){
		$("#tmpweekday").text("星期二");
	}
	else if(day==3){
		$("#tmpweekday").text("星期三");
	}	
	else if(day==4){
		$("#tmpweekday").text("星期四");
	}	
	else if(day==5){
		$("#tmpweekday").text("星期五");
	}	
	else if(day==6){
		$("#tmpweekday").text("星期六");
	}	
	else if(day==0){
		$("#tmpweekday").text("星期日");
	}
}