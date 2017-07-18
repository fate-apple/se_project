
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch([
                    "../img/background/bg.png"
	              , "../img/background/se.jpg"
	              
	             ], {duration: 3000, fade: 750});
    
    $("#login").click(function(e) {
    	var username;
    	var password;
		var usertype;
		var radio = document.getElementsByName("usertype"); 
	    for (i=0; i<radio.length; i++) {  
	        if (radio[i].checked) {  
	            usertype = radio[i].value;  
	        }  
	    } 
		if (usertype=="student"||usertype=="teacher"){
			username = $("input[name='username']").val();
		}
		if (usertype=="class"){
			var grade = document.getElementById("selectGrade").value;
			var classNo = document.getElementById("grade"+grade).value;
			username = "g"+grade+"c"+classNo;
		}
		password = $("input[name='password']").val();
		console.log(username, password,usertype);
<<<<<<< HEAD
		jQuery.ajax({
			url : '/auth',
				processData : true,
				dataType : "text",
				data : {
					username : username,
					password : password

				},
				success : function(data) {
					window.location.href = "/se/manage/news";
					console.log(data);

				}
			});
=======
        $.ajax({
            type: "post",
            url: "/auth",
            contentType: "application/json",
            data: JSON.stringify({
                "username": userName,
                "password": password
            }),
            dataType: 'json',
            success: function (resp) {
                alert(resp.token);
                if (1) {
                    //将token存在本地存储，然后跳转到主页面
                    localStorage.setItem('token', resp.token);
                    top.location.href = "/base/news";
                }
            }
        });
>>>>>>> cf14035ebec2295d395762a50c1696656ddd5378
		
	});
    
    
});
